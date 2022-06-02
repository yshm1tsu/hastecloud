package ru.itis.hastecloud.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.itis.hastecloud.dtos.AddCommentaryDto
import ru.itis.hastecloud.dtos.RetrieveCommentaryByFileDto
import ru.itis.hastecloud.dtos.RetrieveCommentaryByIdDto
import ru.itis.hastecloud.dtos.forms.AddCommentaryForm
import ru.itis.hastecloud.services.FileCommentaryServiceImpl


@RestController
class FileCommentaryController(val fileCommentaryService: FileCommentaryServiceImpl) {

    @PostMapping("/api/v1/commentary/add-commentary")
    fun addCommentary(@RequestBody form: AddCommentaryForm): ResponseEntity<AddCommentaryDto>? =
        ResponseEntity.ok(fileCommentaryService.addCommentary(form))

    @GetMapping("/api/v1/commentary/retrieve-commentaries-for-file/{id}")
    fun retrieveCommentariesByFile(@PathVariable id: Long): ResponseEntity<RetrieveCommentaryByFileDto>? =
        ResponseEntity.ok(fileCommentaryService.retrieveCommentaryByFileId(id))

    @GetMapping("/api/v1/commentary/retrieve-comment/{id}")
    fun retrieveCommentaryById(@PathVariable id: Long): ResponseEntity<RetrieveCommentaryByIdDto>? =
        ResponseEntity.ok(fileCommentaryService.retrieveCommentaryById(id))
}