package ru.itis.hastecloud.services
import ru.itis.hastecloud.dtos.FileCommentaryDto
import ru.itis.hastecloud.dtos.forms.AddCommentaryForm

interface FileCommentaryService {
    fun addCommentary(addCommentaryForm: AddCommentaryForm)
    fun retrieveCommentariesByFileId(id: Long): List<FileCommentaryDto>
    fun retrieveCommentaryById(id: Long): FileCommentaryDto

}