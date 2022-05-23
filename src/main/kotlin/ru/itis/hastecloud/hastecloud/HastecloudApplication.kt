package ru.itis.hastecloud.hastecloud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HastecloudApplication

fun main(args: Array<String>) {
    runApplication<HastecloudApplication>(*args)
}
