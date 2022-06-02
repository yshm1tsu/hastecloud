package ru.itis.hastecloud.dtos

import org.springframework.core.io.Resource

data class DownloadFileDto(
    val resource: Resource,
    val contentType: String
)

