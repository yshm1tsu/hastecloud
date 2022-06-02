package ru.itis.hastecloud.listeners

import org.springframework.stereotype.Component
import ru.itis.hastecloud.models.Role
import ru.itis.hastecloud.models.StoragePermission
import ru.itis.hastecloud.repositories.RoleRepository
import ru.itis.hastecloud.repositories.StoragePermissionRepository
import javax.annotation.PostConstruct

@Component
class DatabaseDataInitializerOnAppStartupListener(
    private val roleRepository: RoleRepository,
    private val storagePermissionRepository: StoragePermissionRepository
) {

    val GB: Long = 1073741824

    @PostConstruct
    private fun initData() {
        val storagePermissions = listOf(
            StoragePermission(
                cost = 100,
                maxSize = 10 * GB
            ),
            StoragePermission(
                cost = 200,
                maxSize = 20 * GB
            )
        )
        storagePermissionRepository.saveAll(storagePermissions)
        val roles = listOf(
            Role(storagePermissions.first())
        )
        roleRepository.saveAll(roles)
    }
}