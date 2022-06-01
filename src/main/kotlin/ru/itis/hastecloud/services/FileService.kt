package ru.itis.hastecloud.services

import ru.itis.hastecloud.dtos.DownloadFileDto
import ru.itis.hastecloud.dtos.forms.DownloadFileForm
import ru.itis.hastecloud.dtos.forms.UploadFileForm

interface FileService {
    fun uploadFile(uploadFileForm: UploadFileForm)
    fun downloadFile(downloadFileForm: DownloadFileForm): DownloadFileDto

}
