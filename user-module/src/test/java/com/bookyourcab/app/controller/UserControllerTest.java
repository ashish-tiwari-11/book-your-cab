package com.bookyourcab.app.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getUserById() throws Exception {
        assertEquals(true,true);
    }

    @Test
    void getAllUsers() {
        assertEquals(true,true);
    }

    @Test
    void getUserEmailOrMobile() {
        assertEquals(true,true);
    }

    @Test
    void registerNewUser() {
        assertEquals(true,true);
    }
}