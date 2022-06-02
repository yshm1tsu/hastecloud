package ru.itis.hastecloud.dtos

import org.springframework.core.io.Resource

class DownloadFileDto(
    val resource: Resource,
    val contentType: String
)

