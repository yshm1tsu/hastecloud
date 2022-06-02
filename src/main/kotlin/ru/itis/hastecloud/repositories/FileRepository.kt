package ru.itis.hastecloud.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import ru.itis.hastecloud.models.Storage
import ru.itis.hastecloud.models.User
import ru.itis.hastecloud.models.UserFile

interface FileRepository : JpaRepository<UserFile, Long> {

    @Query("from UserFile u where u.storage.user = :user")
    fun findAllByUser(user: User)

    fun findAllByStorage(storage: Storage): List<UserFile>

}