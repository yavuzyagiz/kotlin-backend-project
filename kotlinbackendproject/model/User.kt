package com.example.kotlinbackendproject.model

import javax.persistence.*

@Entity
@Table(name = "announcement_user")
data class User(
    @Id
    @GeneratedValue(
        generator = "UUID",
        strategy = GenerationType.AUTO
    )
    @Column(
        name = "id",
        nullable = false
    )
    val id: Long?,
    @Column(
        name = "firstName",
        nullable = false,
        columnDefinition = "TEXT"
    )
    val firstName: String?,
    @Column(
        name = "lastName",
        nullable = true,
        columnDefinition = "TEXT"
    )
    val lastName: String?,
    @Column(
        name = "email",
        nullable = false,
        unique = true,
        columnDefinition = "TEXT"
    )
    val email: String?,
)