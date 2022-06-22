package ru.itis.hastecloud.dtos

import ru.itis.hastecloud.models.FileCommentary

class FileCommentaryDto(
    var content: String?,
    var user: UserDto
) {
    companion object {
        fun from(userFileCommentary: FileCommentary) = FileCommentaryDto(
            userFileCommentary.text,
            UserDto.from(userFileCommentary.user)
        )
        fun from(userFileCommentaries: List<FileCommentary>) = userFileCommentaries.map { from(it) }
    }
}