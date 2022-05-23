package ru.itis.hastecloud.models

import java.time.LocalDateTime
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

class Token(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    var token: String,
    var dueTo: LocalDateTime = LocalDateTime.now().plusMinutes(30),
    @ManyToOne var user: User
)