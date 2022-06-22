package ru.itis.hastecloud.services

import ru.itis.hastecloud.dtos.LoginDto
import ru.itis.hastecloud.dtos.UserDto
import ru.itis.hastecloud.dtos.forms.LoginForm
import ru.itis.hastecloud.dtos.forms.SignUpForm

interface AccountsService {
    fun signUp(signUpForm: SignUpForm)
    fun signIn(loginForm: LoginForm): LoginDto
    fun getAllUsers(): List<UserDto>
}