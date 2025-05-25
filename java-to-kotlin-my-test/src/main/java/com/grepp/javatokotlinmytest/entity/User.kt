package com.grepp.javatokotlinmytest.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity(name = "my_user")
class User {

    @Id
    @GeneratedValue
    var id: Long? = null

    var name: String? = null
    var email: String? = null
}