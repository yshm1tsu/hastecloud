package ru.itis.hastecloud.services

import org.springframework.stereotype.Service
import ru.itis.hastecloud.dtos.FileCommentaryDto
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

    override fun addCommentary(addCommentaryForm: AddCommentaryForm) {
        val user = usersRepository.findById(addCommentaryForm.userId!!).orElseThrow { NotFoundException() }
        val file = fileRepository.findById(addCommentaryForm.fileId!!).orElseThrow { NotFoundException() }
        val fileCommentary = FileCommentary(
            user = user, text = addCommentaryForm.text, publicashionDate = LocalDateTime.now(), file = file
        )
        fileCommentaryRepository.save(fileCommentary)
    }

    override fun retrieveCommentariesByFileId(id: Long): List<FileCommentaryDto> =
        FileCommentaryDto.from(fileCommentaryRepository.findAllByFileId(id))

    override fun retrieveCommentaryById(id: Long): FileCommentaryDto =
        FileCommentaryDto.from(fileCommentaryRepository.findById(id).orElseThrow { NotFoundException() })

}