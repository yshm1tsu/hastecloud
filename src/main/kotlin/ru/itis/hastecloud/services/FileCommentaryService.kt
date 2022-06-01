package ru.itis.hastecloud.services
import ru.itis.hastecloud.dtos.forms.AddCommentaryForm
import ru.itis.hastecloud.dtos.AddCommentaryDto
import ru.itis.hastecloud.dtos.RetrieveCommentaryByFileDto
import ru.itis.hastecloud.dtos.RetrieveCommentaryByIdDto
interface FileCommentaryService {
    fun addCommentary(addCommentaryForm: AddCommentaryForm): AddCommentaryDto
    fun retrieveCommentaryByFileId(id: Long): RetrieveCommentaryByFileDto
    fun retrieveCommentaryById(id: Long): RetrieveCommentaryByIdDto

}