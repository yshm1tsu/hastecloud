package ru.itis.hastecloud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
@Import(AppConfig::class)
class HastecloudApplication

fun main(args: Array<String>) {
    runApplication<HastecloudApplication>(*args)
}
