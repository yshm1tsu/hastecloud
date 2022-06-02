package ru.itis.hastecloud.dtos.forms

import org.springframework.web.multipart.MultipartFile

data class UploadFileForm(
    var file: MultipartFile,
    var userId: Long
)
