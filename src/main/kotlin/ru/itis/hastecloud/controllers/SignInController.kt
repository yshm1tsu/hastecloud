package ru.itis.hastecloud.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.itis.hastecloud.dtos.LoginDto
import ru.itis.hastecloud.dtos.forms.LoginForm
import ru.itis.hastecloud.services.AccountsService


@RestController
class SignInController(val accountsService: AccountsService) {

    @PostMapping("/api/v1/login")
    fun login(@RequestBody form: LoginForm): ResponseEntity<LoginDto>? = ResponseEntity.ok(accountsService.signIn(form))
}