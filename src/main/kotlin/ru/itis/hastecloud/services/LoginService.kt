package ru.itis.hastecloud.services

import org.springframework.stereotype.Service
import ru.itis.hastecloud.repositories.TokenRepository
@Service
class LoginService(val db: TokenRepository) {

}