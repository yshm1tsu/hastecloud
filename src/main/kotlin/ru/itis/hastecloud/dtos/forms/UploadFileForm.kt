package ru.itis.hastecloud.dtos.forms

import org.springframework.web.multipart.MultipartFile

class UploadFileForm(
    var file: MultipartFile?,
    var userId: Long?
)
