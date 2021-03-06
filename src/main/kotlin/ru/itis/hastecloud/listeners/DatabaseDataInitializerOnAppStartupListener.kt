package ru.itis.hastecloud.listeners

import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component
import ru.itis.hastecloud.models.Role
import ru.itis.hastecloud.models.StoragePermission
import ru.itis.hastecloud.models.User
import ru.itis.hastecloud.repositories.RoleRepository
import ru.itis.hastecloud.repositories.StoragePermissionRepository

@Component
class DatabaseDataInitializerOnAppStartupListener(
    private val roleRepository: RoleRepository,
    private val storagePermissionRepository: StoragePermissionRepository
):ApplicationListener<ApplicationReadyEvent>{

    val GB: Long = 1073741824

    fun initData() {
        if (storagePermissionRepository.count() >= 2)
            return
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
            Role(storagePermissions.first(), users = setOf())
        )
        roleRepository.saveAll(roles)
    }

    override fun onApplicationEvent(event: ApplicationReadyEvent) = initData()
}