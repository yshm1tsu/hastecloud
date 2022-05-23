package ru.itis.hastecloud.models

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "account")
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    var firstName: String,
    var lastName: String,
    var username: String,
    var email: String,
    var hashPassword: String,
    var birthDate: LocalDateTime,
    var description: String
)