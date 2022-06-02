package ru.itis.hastecloud.services

import org.springframework.stereotype.Service
import ru.itis.hastecloud.dtos.AddCommentaryDto
import ru.itis.hastecloud.dtos.RetrieveCommentaryByFileDto
import ru.itis.hastecloud.dtos.RetrieveCommentaryByIdDto
import ru.itis.hastecloud.dtos.forms.AddCommentaryForm
import ru.itis.hastecloud.exceptions.NotFoundException
import ru.itis.hastecloud.models.FileCommentary
import ru.itis.hastecloud.repositories.FileCommentaryRepository
import ru.itis.hastecloud.repositories.FileRepository
import ru.itis.hastecloud.repositories.UsersRepository
import java.time.LocalDateTime

@Service
class FileCommentaryServiceImpl(
    private val fileCommentaryRepository: FileCommentaryRepository,
    private val usersRepository: UsersRepository,
    private val fileRepository: FileRepository
) : FileCommentaryService {

    override fun addCommentary(addCommentaryForm: AddCommentaryForm): AddCommentaryDto {
        val user = usersRepository.findById(addCommentaryForm.userId!!).orElseThrow { NotFoundException() }
        val file = fileRepository.findById(addCommentaryForm.fileId!!).orElseThrow { NotFoundException() }
        val fileCommentary = FileCommentary(
            user = user, text = addCommentaryForm.text, publicashionDate = LocalDateTime.now(), file = file
        )
        fileCommentaryRepository.save(fileCommentary)
        return AddCommentaryDto("ok")
    }

    override fun retrieveCommentaryByFileId(id: Long): RetrieveCommentaryByFileDto =
        RetrieveCommentaryByFileDto(fileCommentaryRepository.findAllByFileId(id))

    override fun retrieveCommentaryById(id: Long): RetrieveCommentaryByIdDto =
        RetrieveCommentaryByIdDto(fileCommentaryRepository.findById(id).orElseThrow { NotFoundException() })

}