package ru.itis.hastecloud.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.itis.hastecloud.models.Token
import ru.itis.hastecloud.models.User
import java.time.LocalDateTime

@Repository
interface TokenRepository : JpaRepository<Token, Long> {
    fun findAllByUser(user: User): List<Token>
    fun findAllByUserId(id: Long): Token?
    fun findAllByUserIdAndDueToAfter(id: Long, dateTime: LocalDateTime): List<Token>
}