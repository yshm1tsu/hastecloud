package ru.itis.hastecloud.repositories

import org.springframework.data.jpa.repository.JpaRepository
import ru.itis.hastecloud.models.Permission
import ru.itis.hastecloud.models.Role

interface RoleRepository : JpaRepository<Role, Long> {

    fun findByPermissionLevel(permission: Permission): Role

}