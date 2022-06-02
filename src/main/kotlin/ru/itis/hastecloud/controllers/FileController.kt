package ru.itis.hastecloud.controllers

import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import ru.itis.hastecloud.dtos.forms.UploadFileForm
import ru.itis.hastecloud.services.FileService

@RestController("/api/v1/file")
class FileController(
    private val fileService: FileService
) {

    @PostMapping("/upload")
    fun uploadFile(uploadFileForm: UploadFileForm): ResponseEntity<Any>? {
        fileService.uploadFile(uploadFileForm)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/download/{id}")
    fun downloadFile(@PathVariable id: Long): ResponseEntity<Any>? {
        val dto = fileService.downloadFile(id)
        val resource: Resource = dto.resource
        val contentType: String = dto.contentType
        val headerValue: String = "attachment; filename=\"${resource.filename}\""
        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(contentType))
            .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
            .body(resource)
    }

}