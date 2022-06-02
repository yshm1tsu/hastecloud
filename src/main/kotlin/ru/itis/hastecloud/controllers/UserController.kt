package ru.itis.hastecloud.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.itis.hastecloud.models.User
import ru.itis.hastecloud.repositories.UsersRepository

@RestController
class UserController(
    private val usersRepository: UsersRepository
) {

    @GetMapping("/api/v1/users/")
    fun users(): List<User> = usersRepository.findAll()

}