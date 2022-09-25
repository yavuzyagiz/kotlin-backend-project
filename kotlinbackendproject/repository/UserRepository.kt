package com.example.kotlinbackendproject.repository

import com.example.kotlinbackendproject.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>
