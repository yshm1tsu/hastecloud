package ru.itis.hastecloud.dtos

import ru.itis.hastecloud.models.Role
import java.time.LocalDateTime

class RoleDto(
    var role: String?,
    var dueTo: LocalDateTime?
) {
    companion object {
        fun from(role: Role): RoleDto = RoleDto(role.permissionLevel.name, role.dueTo)
        fun from(roles: Collection<Role>): List<RoleDto> = roles.map { from(it) }
    }
}
