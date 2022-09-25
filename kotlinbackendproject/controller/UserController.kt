package com.example.kotlinbackendproject.controller

import com.example.kotlinbackendproject.dto.UserDTO
import com.example.kotlinbackendproject.model.User
import com.example.kotlinbackendproject.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/user")
class UserController(private val userService: UserService) {

    // POST http://localhost:8080/api/v1/user
    @PostMapping
    fun create(@RequestBody userDTO: UserDTO): ResponseEntity<UserDTO> {
        return ResponseEntity.ok(this.userService.saveUser(userDTO))
    }

    // GET http://localhost:8080/api/v1/user
    @GetMapping
    fun findAll(): ResponseEntity<List<UserDTO>> {
        return ResponseEntity.ok(this.userService.findAllUser())
    }

    // GET http://localhost:8080/api/v1/user/1
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<User> {
        return ResponseEntity.ok(this.userService.findUserById(id))
    }
}