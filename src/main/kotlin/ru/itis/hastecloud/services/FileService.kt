package ru.itis.hastecloud.services

import ru.itis.hastecloud.dtos.DownloadFileDto
import ru.itis.hastecloud.dtos.forms.UploadFileForm

interface FileService {
    fun uploadFile(uploadFileForm: UploadFileForm)
    fun downloadFile(id: Long): DownloadFileDto

}
