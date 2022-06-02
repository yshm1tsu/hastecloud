package ru.itis.hastecloud.repositories

import org.springframework.data.jpa.repository.JpaRepository
import ru.itis.hastecloud.models.User

interface UsersRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String?): User?
}