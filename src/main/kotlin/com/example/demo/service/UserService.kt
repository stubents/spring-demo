package com.example.demo.service

import com.example.demo.repository.DemoUser
import com.example.demo.repository.UserRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class UserService(val repository: UserRepository) {

    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    fun getUsers(): List<DemoUser> {
        return repository.findAll().toList()
    }

    /**
     * see https://github.com/marlon360/rki-covid-api
     */
    fun requestRki() {
        val restTemplate = RestTemplate()
        val result = restTemplate.getForObject("https://rki.marlon-lueckert.de/api/states", String::class.java)
        logger.info(result)
    }

}