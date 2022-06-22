package ru.itis.hastecloud.dtos

import org.springframework.core.io.Resource
import ru.itis.hastecloud.models.UserFile

class DownloadFileDto(
    val resource: Resource,
    val contentType: String,
    val filename: String
) {
}

