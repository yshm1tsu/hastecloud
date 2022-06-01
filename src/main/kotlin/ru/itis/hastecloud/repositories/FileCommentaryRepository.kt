package ru.itis.hastecloud.repositories

import org.springframework.data.jpa.repository.JpaRepository
import ru.itis.hastecloud.models.FileCommentary
import ru.itis.hastecloud.models.User
import ru.itis.hastecloud.models.UserFile
import java.time.LocalDateTime
import java.util.Optional

interface FileCommentaryRepository : JpaRepository<FileCommentary, Long> {
    fun findAllByUser(user: User): List<FileCommentary>
    fun findAllByFile(file: UserFile)
    fun findAllById(id: Long)
    fun findAllByPublicashionDate(date: LocalDateTime)
    fun findAllByFileId(id: Long): List<FileCommentary>
}
