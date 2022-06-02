package ru.itis.hastecloud.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import ru.itis.hastecloud.dtos.AddCommentaryDto
import ru.itis.hastecloud.dtos.RetrieveCommentaryByFileDto
import ru.itis.hastecloud.dtos.RetrieveCommentaryByIdDto
import ru.itis.hastecloud.dtos.forms.AddCommentaryForm
import ru.itis.hastecloud.services.FileCommentaryServiceImpl


@RestController("/api/v1/commentary")
class FileCommentaryController(val fileCommentaryService: FileCommentaryServiceImpl) {

    @PostMapping("/add-commentary")
    fun addCommentary(form: AddCommentaryForm): ResponseEntity<AddCommentaryDto>? =
        ResponseEntity.ok(fileCommentaryService.addCommentary(form))

    @GetMapping("/retrieve-commentaries-for-file/{id}")
    fun retrieveCommentariesByFile(@PathVariable id: Long): ResponseEntity<RetrieveCommentaryByFileDto>? =
        ResponseEntity.ok(fileCommentaryService.retrieveCommentaryByFileId(id))

    @GetMapping("retrieve-comment/{id}")
    fun retrieveCommentaryById(@PathVariable id: Long): ResponseEntity<RetrieveCommentaryByIdDto>? =
        ResponseEntity.ok(fileCommentaryService.retrieveCommentaryById(id))
}