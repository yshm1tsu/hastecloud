package ru.itis.hastecloud.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import ru.itis.hastecloud.dtos.LoginDto
import ru.itis.hastecloud.dtos.SignUpDto
import ru.itis.hastecloud.dtos.forms.LoginForm
import ru.itis.hastecloud.dtos.forms.SignUpForm
import ru.itis.hastecloud.exceptions.NotFoundException
import ru.itis.hastecloud.models.User
import ru.itis.hastecloud.repositories.TokenRepository
import ru.itis.hastecloud.repositories.UsersRepository
import java.time.LocalDateTime

@Service
class AccountsServiceImpl(
    private val passwordEncoder: BCryptPasswordEncoder,
    private val usersRepository: UsersRepository,
    private val tokenRepository: TokenRepository
    ) : AccountsService {

    override fun signUp(signUpForm: SignUpForm) : SignUpDto {
        if (usersRepository.findByEmail(signUpForm.email) != null)
            throw NotFoundException()
        val user = User(
            signUpForm.firstname,
            signUpForm.lastname,
            signUpForm.username,
            signUpForm.email,
            passwordEncoder.encode(signUpForm.password),
            getDefaultDateTime(),
            signUpForm.description
        )
        usersRepository.save(user)
        return SignUpDto()
    }

    override fun signIn(loginForm: LoginForm): LoginDto {
        TODO("Not yet implemented")
    }

    private fun getDefaultDateTime(): LocalDateTime {
        return LocalDateTime.of(2020, 6, 1, 0, 0, 0)
    }
}