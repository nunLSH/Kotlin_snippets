package com.grepp.javatokotlinmytest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.grepp.javatokotlinmytest.entity.User;
import com.grepp.javatokotlinmytest.repository.UserRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    // C
    @Test
    void createUser(){
        //given
        String name = "jko";
        String email = "jko@google.com";
        User user = new User();
        user.setId(1L);
        user.setName(name);
        user.setEmail(email);

        when(userRepository.save(any(User.class))).thenReturn(user);

        // when
        User actual = userService.createUser(name, email);

        // then
        assertNotNull(actual);
        assertEquals("jko", actual.getName());
        assertEquals("jko@google.com", actual.getEmail());
    }

    // R
    @Test
    void testGetUser() {
        // given
        String name = "jko";
        String email = "jko@google.com";
        User user = new User();
        user.setId(1L);
        user.setName(name);
        user.setEmail(email);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        // when
        Optional<User> actual = userService.findUser(1L);

        // then
        assertTrue(actual.isPresent());
        assertEquals(user, actual.get());
    }
}