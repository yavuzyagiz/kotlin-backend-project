package com.example.kotlinbackendproject.service

import com.example.kotlinbackendproject.dto.UserDTO
import com.example.kotlinbackendproject.exception.UserNotFoundException
import com.example.kotlinbackendproject.mapper.UserMapper
import com.example.kotlinbackendproject.model.User
import com.example.kotlinbackendproject.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
) {

    fun findUserById(id: Long): User {
        return this.userRepository.findById(id).orElseThrow {
            UserNotFoundException("User could not found by id=$id")
        }
    }

    fun saveUser(userDTO: UserDTO): UserDTO =
        this.userMapper.fromEntity(this.userRepository.save(this.userMapper.toEntity(userDTO)))

    fun findAllUser(): List<UserDTO> {
        return this.userRepository.findAll()
            .stream()
            .map(this.userMapper::fromEntity)
            .collect(Collectors.toList())
    }

}