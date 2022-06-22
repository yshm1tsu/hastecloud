package ru.itis.hastecloud.services

import org.springframework.core.io.ByteArrayResource
import org.springframework.stereotype.Service
import org.springframework.util.MimeType
import org.springframework.util.MimeTypeUtils
import ru.itis.hastecloud.dtos.DownloadFileDto
import ru.itis.hastecloud.dtos.forms.UploadFileForm
import ru.itis.hastecloud.exceptions.NotFoundException
import ru.itis.hastecloud.models.UserFile
import ru.itis.hastecloud.repositories.FileRepository
import ru.itis.hastecloud.repositories.StorageRepository
import ru.itis.hastecloud.repositories.UsersRepository

@Service
class FileServiceImpl(
    private val fileRepository: FileRepository,
    private val usersRepository: UsersRepository,
    private val storageRepository: StorageRepository
) : FileService {
    override fun uploadFile(uploadFileForm: UploadFileForm) {
        val multipartFile = uploadFileForm.file
        val user = usersRepository.findById(uploadFileForm.userId!!).orElseThrow { NotFoundException() }
        var storage = storageRepository.findByUser(user)

        val userFile = UserFile(
            content = multipartFile?.bytes,
            type = MimeType.valueOf(multipartFile?.contentType ?: MimeTypeUtils.APPLICATION_OCTET_STREAM_VALUE),
            filename = "${user.username}-${multipartFile?.originalFilename}",
            size = multipartFile?.size,
            storage = storage
        )
        storage.addFile(userFile)

        fileRepository.save(userFile)
        storageRepository.save(storage)
    }

    override fun downloadFile(id: Long): DownloadFileDto {
        val userFile = fileRepository.findById(id).orElseThrow { NotFoundException() }
        return DownloadFileDto(
            resource = ByteArrayResource(userFile.content!!),
            contentType = "${userFile.type.type}/${userFile.type.subtype}",
            filename = userFile.filename
        )
    }

}