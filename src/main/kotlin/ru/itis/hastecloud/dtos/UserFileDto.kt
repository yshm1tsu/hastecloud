package ru.itis.hastecloud.dtos

import ru.itis.hastecloud.models.UserFile

class UserFileDto(
    var id: Long?,
    var filename: String?,
    var size: Long?,
    var type: String?
) {
    companion object {
        fun from(userFile: UserFile) = UserFileDto(
            userFile.id,
            userFile.filename,
            userFile.size,
            "${userFile.type.type}/${userFile.type.subtype}"
        )
        fun from(userFiles: List<UserFile>) = userFiles.map { from(it) }
    }
}