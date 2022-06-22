package ru.itis.hastecloud.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.itis.hastecloud.dtos.forms.SignUpForm
import ru.itis.hastecloud.services.AccountsService

@RestController
class SignUpController {

    @Autowired
    private lateinit var accountsService: AccountsService

    @PostMapping("/api/v1/signup")
    fun signUp(@RequestBody signUpForm: SignUpForm): ResponseEntity<Any> = ResponseEntity.ok(accountsService.signUp(signUpForm))

}