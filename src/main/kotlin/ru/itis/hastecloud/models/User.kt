package ru.itis.hastecloud.models

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "account")
class User(
    var firstname: String,
    var lastname: String,
    var username: String,
    var email: String,
    var hashPassword: String,
    var birthDate: LocalDateTime,
    var description: String,
    @OneToMany
    var roles: Set<Role> = setOf(Role()),
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null
)