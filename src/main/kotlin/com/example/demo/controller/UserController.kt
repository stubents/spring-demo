package com.example.demo.controller

import com.example.demo.repository.DemoUser
import com.example.demo.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/demo"])
class UserController(val userService: UserService) {

    @GetMapping("/users")
    fun getUsers(): List<DemoUser> {
        return userService.getUsers()
    }

}