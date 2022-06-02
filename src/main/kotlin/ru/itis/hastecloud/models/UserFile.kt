package ru.itis.hastecloud.models

import org.springframework.util.MimeType
import org.springframework.util.MimeTypeUtils
import javax.persistence.*

@Entity
class UserFile(
    @Lob
    var content: ByteArray,
    var size: Long,
    var type: MimeType = MimeTypeUtils.APPLICATION_OCTET_STREAM,
    var filename: String,
    @Enumerated(EnumType.STRING)
    var permissionLevel: FilePermission = FilePermission.OPEN,
    @OneToMany
    var commentaries: List<FileCommentary> = listOf(),
    @ManyToOne
    var storage: Storage,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null
)

enum class FilePermission {
    OPEN, PROTECTED, PRIVATE
}
