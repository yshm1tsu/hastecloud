package ru.itis.hastecloud.repositories

import org.springframework.data.jpa.repository.JpaRepository
import ru.itis.hastecloud.models.Token
import ru.itis.hastecloud.models.User
import java.time.LocalDateTime

interface TokenRepository : JpaRepository<Token, Long> {
    fun findAllByUser(user: User): List<Token>
    fun findAllByUserId(id: Long): Token?
    fun findAllByUserIdAndDueToAfter(id: Long, dateTime: LocalDateTime): List<Token>
    fun findFirstByUserIdAndDueToAfter(id: Long, dateTime: LocalDateTime): Token
}