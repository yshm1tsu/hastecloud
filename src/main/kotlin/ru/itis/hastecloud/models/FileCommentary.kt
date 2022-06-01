package ru.itis.hastecloud.models

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class FileCommentary(
    var text: String,
    var publicashionDate: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    var file: UserFile,
    @ManyToOne
    var user: User,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null

)