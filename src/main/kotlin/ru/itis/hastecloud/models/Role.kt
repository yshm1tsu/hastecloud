package ru.itis.hastecloud.models

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Role(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    @Enumerated(EnumType.STRING)
    var permissionLevel: Permission = Permission.USER,
    var dueTo: LocalDateTime? = null,
)

enum class Permission {
    USER, MODERATOR
}
