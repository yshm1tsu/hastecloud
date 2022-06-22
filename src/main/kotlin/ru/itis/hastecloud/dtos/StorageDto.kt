package ru.itis.hastecloud.dtos

import ru.itis.hastecloud.models.Storage

class StorageDto(var user: UserDto, var size: Long, var maxSize: Long, var userFiles: List<UserFileDto>){
    companion object {
        fun from(storage: Storage) = StorageDto(
            UserDto.from(storage.user),
            storage.size,
            storage.maxSize,
            UserFileDto.from(storage.userFiles)
        )
    }
}