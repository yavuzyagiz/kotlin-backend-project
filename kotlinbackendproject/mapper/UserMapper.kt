package com.example.kotlinbackendproject.mapper

import com.example.kotlinbackendproject.dto.UserDTO
import com.example.kotlinbackendproject.model.User
import org.springframework.stereotype.Component

@Component
class UserMapper : Mapper<UserDTO, User> {

    override fun toEntity(domain: UserDTO): User = User(
        id = domain.id,
        firstName = domain.firstName,
        lastName = domain.lastName,
        email = domain.email
    )

    override fun fromEntity(entity: User): UserDTO = UserDTO(
        id = entity.id,
        firstName = entity.firstName,
        lastName = entity.lastName,
        email = entity.email
    )

}