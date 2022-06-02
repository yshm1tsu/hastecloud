package ru.itis.hastecloud.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.itis.hastecloud.listeners.DatabaseDataInitializerOnAppStartupListener

@RestController
class InitController(
    val databaseDataInitializerOnAppStartupListener: DatabaseDataInitializerOnAppStartupListener
) {

    @GetMapping("/init")
    fun init() {
        databaseDataInitializerOnAppStartupListener.initData()
    }

}