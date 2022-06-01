package ru.itis.hastecloud.services

import ru.itis.hastecloud.dtos.LoginDto
import ru.itis.hastecloud.dtos.SignUpDto
import ru.itis.hastecloud.dtos.forms.LoginForm
import ru.itis.hastecloud.dtos.forms.SignUpForm

interface AccountsService {
    fun signUp(signUpForm: SignUpForm): SignUpDto
    fun signIn(loginForm: LoginForm): LoginDto
}