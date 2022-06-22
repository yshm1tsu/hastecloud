package ru.itis.hastecloud.dtos

import ru.itis.hastecloud.models.User
import java.time.LocalDateTime

class UserDto(
    var firstname: String?,
    var lastname: String?,
    var username: String?,
    var email: String?,
    var birthDate: LocalDateTime?,
    var description: String?,
    var roles: List<RoleDto>,
    var id: Long?
) {
    companion object {
        fun from(user: User) = UserDto(
            user.firstname,
            user.lastname,
            user.username,
            user.email,
            user.birthDate,
            user.description,
            RoleDto.from(user.roles),
            user.id
        )
        fun from(users: List<User>) = users.map { from(it) }
    }
}
