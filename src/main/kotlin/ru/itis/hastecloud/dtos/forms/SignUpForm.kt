package ru.itis.hastecloud.dtos.forms

data class SignUpForm(
    var firstname: String,
    var lastname: String,
    var username: String,
    var email: String,
    var password: String,
    var birthDate: String,
    var description: String
)