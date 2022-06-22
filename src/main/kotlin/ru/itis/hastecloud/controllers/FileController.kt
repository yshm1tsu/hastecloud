package ru.itis.hastecloud.controllers

import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import ru.itis.hastecloud.dtos.forms.UploadFileForm
import ru.itis.hastecloud.services.FileService

@RestController
class FileController(
    private val fileService: FileService
) {

    @PostMapping(value = ["/api/v1/file/upload"], consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun uploadFile(@RequestPart file: MultipartFile?, @RequestParam userId: Long): ResponseEntity<Any>? {
        fileService.uploadFile(UploadFileForm(file, userId))
        return ResponseEntity.ok().build()
    }

    @GetMapping("/api/v1/file/download/{id}")
    fun downloadFile(@PathVariable id: Long): ResponseEntity<Any>? {
        val dto = fileService.downloadFile(id)
        val resource: Resource = dto.resource
        val contentType: String = dto.contentType
        val headerValue: String = "attachment; filename=\"${dto.filename}\""
        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(contentType))
            .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
            .body(resource)
    }

}