package ru.itis.hastecloud.services

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import ru.itis.hastecloud.dtos.StorageDto
import ru.itis.hastecloud.dtos.UserFileDto
import ru.itis.hastecloud.repositories.FileRepository
import ru.itis.hastecloud.repositories.StorageRepository
import ru.itis.hastecloud.repositories.UsersRepository

@Service
class StorageServiceImpl(
    private val usersRepository: UsersRepository,
    private val storageRepository: StorageRepository,
    private val fileRepository: FileRepository
) : StorageService {
    override fun retrieveStorageById(id: Long): StorageDto {
        var storage = storageRepository.findById(id).orElseThrow { NotFoundException() }
        return StorageDto(
            storage.user,
            storage.size,
            storage.maxSize,
            fileRepository.findAllByStorage(storage).map { UserFileDto(it.id, it.filename, it.size, "${it.type.type}/${it.type.subtype}") }
        )
    }

    override fun retrieveStorageByUserId(id: Long): StorageDto {
        var storage = storageRepository.findByUserId(id)
        return StorageDto(
            storage.user,
            storage.size,
            storage.maxSize,
            fileRepository.findAllByStorage(storage).map { UserFileDto(it.id, it.filename, it.size, "${it.type.type}/${it.type.subtype}") }
        )
    }
}