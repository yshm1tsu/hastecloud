package ru.itis.hastecloud.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import ru.itis.hastecloud.dtos.DownloadFileDto
import ru.itis.hastecloud.dtos.forms.DownloadFileForm
import ru.itis.hastecloud.dtos.forms.UploadFileForm
import ru.itis.hastecloud.services.FileService

@RestController("/api/v1/file")
class FileController(
    private val fileService: FileService
) {

    fun uploadFile(uploadFileForm: UploadFileForm): ResponseEntity<Any>? {
        fileService.uploadFile(uploadFileForm)
        return ResponseEntity.ok().build()
    }

    fun downloadFile(downloadFileForm: DownloadFileForm): ResponseEntity<DownloadFileDto>? {
        return ResponseEntity.ok(fileService.downloadFile(downloadFileForm))
    }

}