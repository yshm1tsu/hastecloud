package ru.itis.hastecloud.repositories

import org.springframework.data.jpa.repository.JpaRepository
import ru.itis.hastecloud.models.Storage
import ru.itis.hastecloud.models.User

interface StorageRepository : JpaRepository<Storage, Long> {
    fun findByUser(user: User): Storage
    fun findByUserId(id: Long): Storage
}