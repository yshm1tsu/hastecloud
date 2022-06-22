package ru.itis.hastecloud.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.itis.hastecloud.dtos.UserDto
import ru.itis.hastecloud.models.User
import ru.itis.hastecloud.repositories.UsersRepository
import ru.itis.hastecloud.services.AccountsService

@RestController
class UserController(
    private val accountsService: AccountsService
) {

    @GetMapping("/api/v1/users/")
    fun users(): List<UserDto> = accountsService.getAllUsers()

}