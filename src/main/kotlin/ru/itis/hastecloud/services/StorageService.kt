package ru.itis.hastecloud.services

import ru.itis.hastecloud.dtos.StorageDto

interface StorageService {
    fun retrieveStorageById(id: Long): StorageDto
    fun retrieveStorageByUserId(id: Long): StorageDto
}