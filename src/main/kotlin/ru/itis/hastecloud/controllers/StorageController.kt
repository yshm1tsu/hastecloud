package ru.itis.hastecloud.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import ru.itis.hastecloud.services.StorageService
import org.springframework.http.ResponseEntity


@RestController("/api/v1/storage")
class StorageController(private val storageService: StorageService) {

    @GetMapping("/{id}")
    fun retrieveStorageById(@PathVariable id: Long): ResponseEntity<Any>? {
        return ResponseEntity.ok(storageService.retrieveStorageById(id))
    }

    @GetMapping("/by-user/{id}")
    fun retrieveStorageByUserId(@PathVariable id: Long): ResponseEntity<Any>? {
        return ResponseEntity.ok(storageService.retrieveStorageByUserId(id))
    }


}