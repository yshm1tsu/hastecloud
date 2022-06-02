package ru.itis.hastecloud.models

import javax.persistence.*

@Entity
class Storage(
    var size: Long,
    var maxSize: Long,
    @OneToMany(fetch = FetchType.EAGER)
    var userFiles: List<UserFile> = listOf(),
    @OneToOne
    var user: User,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null
)