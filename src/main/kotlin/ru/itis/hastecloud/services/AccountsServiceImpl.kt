package ru.itis.hastecloud.services

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import ru.itis.hastecloud.dtos.LoginDto
import ru.itis.hastecloud.dtos.SignUpDto
import ru.itis.hastecloud.dtos.forms.LoginForm
import ru.itis.hastecloud.dtos.forms.SignUpForm
import ru.itis.hastecloud.exceptions.NotFoundException
import ru.itis.hastecloud.models.*
import ru.itis.hastecloud.repositories.RoleRepository
import ru.itis.hastecloud.repositories.StorageRepository
import ru.itis.hastecloud.repositories.TokenRepository
import ru.itis.hastecloud.repositories.UsersRepository
import java.time.LocalDateTime
import java.util.UUID

@Service
class AccountsServiceImpl(
    private val passwordEncoder: BCryptPasswordEncoder,
    private val usersRepository: UsersRepository,
    private val tokenRepository: TokenRepository,
    private val roleRepository: RoleRepository,
    private val storageRepository: StorageRepository
) : AccountsService {

    override fun signUp(signUpForm: SignUpForm): SignUpDto {
        if (usersRepository.findByEmail(signUpForm.email) == null)
            throw NotFoundException()
        val user = getUser(signUpForm)
        usersRepository.save(user)
        val storagePermission = user.roles.first().storagePermission
        val storage = getStorage(storagePermission, user)
        storageRepository.save(storage)
        return SignUpDto()
    }

    private fun getStorage(
        storagePermission: StoragePermission,
        user: User
    ) = Storage(
        size = 0,
        maxSize = storagePermission.maxSize,
        user = user
    )

    private fun getUser(signUpForm: SignUpForm) = User(
        signUpForm.firstname,
        signUpForm.lastname,
        signUpForm.username,
        signUpForm.email,
        passwordEncoder.encode(signUpForm.password),
        getDefaultDateTime(),
        signUpForm.description,
        setOf(roleRepository.findByPermissionLevel(Permission.USER))
    )

    override fun signIn(loginForm: LoginForm): LoginDto {
        val user = usersRepository.findByEmail(loginForm.email) ?: throw NotFoundException()
        if (user.hashPassword != passwordEncoder.encode(loginForm.password)){
            throw NotFoundException()
        }
        val token = Token(token = UUID.randomUUID().toString(), user = user)
        return LoginDto(tokenRepository.save(token).token)
    }

    private fun getDefaultDateTime(): LocalDateTime {
        return LocalDateTime.of(2020, 6, 1, 0, 0, 0)
    }
}