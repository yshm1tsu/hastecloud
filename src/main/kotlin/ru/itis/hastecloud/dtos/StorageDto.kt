package ru.itis.hastecloud.dtos

import ru.itis.hastecloud.models.Storage
import ru.itis.hastecloud.models.User
import ru.itis.hastecloud.models.UserFile

class StorageDto(var user: User, var size: Long, var maxSize: Long, var storage: Storage)