package ru.itis.hastecloud.models

import javax.persistence.*

@Entity
class StoragePermission(
    var cost: Long,
    var maxSize: Long,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null
)