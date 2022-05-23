package ru.itis.hastecloud.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import ru.itis.hastecloud.dtos.LoginDto
import ru.itis.hastecloud.dtos.forms.LoginForm


@RestController
class SignInController {

    @PostMapping("/login")
    fun login(form: LoginForm): ResponseEntity<LoginDto>? {
        return null
    }
}