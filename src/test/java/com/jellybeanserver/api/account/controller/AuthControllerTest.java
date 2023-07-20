package com.jellybeanserver.api.account.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jellybeanserver.api.account.dto.request.MemberRequest;
import com.jellybeanserver.api.account.repository.MemberRepository;
import com.jellybeanserver.api.account.service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AuthService authService;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void clean() {
        memberRepository.deleteAll();
    }

    @Test
    @DisplayName("회원가입")
    void signup_success() throws Exception {
        //given
        MemberRequest signup = MemberRequest.builder()
            .email("hyun@hyundai.bin")
            .password("1q2w3e4r")
            .name("현대빈")
            .birth("2023-07-20")
            .phone("010-1234-5678")
            .build();

        //expected
        mockMvc.perform(post("/api/auth/signup")
                .content(objectMapper.writeValueAsString(signup))
                .contentType(APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(print());
    }

}