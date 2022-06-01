package ru.itis.hastecloud.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import ru.itis.hastecloud.dtos.SignUpDto
import ru.itis.hastecloud.dtos.forms.SignUpForm
import ru.itis.hastecloud.services.AccountsService

@RestController("/api/v1/")
class SignUpController {

    @Autowired
    private lateinit var accountsService: AccountsService

    @PostMapping("/singUp")
    fun signUp(signUpForm: SignUpForm): ResponseEntity<SignUpDto> = ResponseEntity.ok(accountsService.signUp(signUpForm))

}