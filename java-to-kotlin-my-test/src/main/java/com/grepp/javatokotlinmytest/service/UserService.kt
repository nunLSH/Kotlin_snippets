package com.grepp.javatokotlinmytest.service

import com.grepp.javatokotlinmytest.entity.User
import com.grepp.javatokotlinmytest.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {
    // C
    fun createUser(name: String?, email: String?): User {
        val user = User()
        user.name = name
        user.email = email

        return userRepository.save(user)
    }

    // R
    fun findUser(id: Long): Optional<User> {
        return userRepository.findById(id)
    }

    // U
    fun updateUser(id: Long, name: String?): User {
        val user = userRepository.findById(id)
            .orElseThrow { RuntimeException("User not found") }

        user.name = name

        return userRepository.save(user)
    }
}
