package ru.itis.hastecloud.models

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Role(
    @ManyToOne
    var storagePermission: StoragePermission,
    @Enumerated(EnumType.STRING)
    var permissionLevel: Permission = Permission.USER,
    var dueTo: LocalDateTime? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null
)

enum class Permission {
    USER, MODERATOR
}
