package ru.itis.hastecloud.repositories

import org.springframework.data.jpa.repository.JpaRepository
import ru.itis.hastecloud.models.StoragePermission

interface StoragePermissionRepository : JpaRepository<StoragePermission, Long> {
}