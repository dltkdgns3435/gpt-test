package com.example.demo.openai.service

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ChatGPTServiceTest {
    @Autowired
    private lateinit var chatGPTService: ChatGPTService

    @Test
    fun testGetAnswer() {
        //given, when
        val answer = chatGPTService.getAnswer("안녕 나는 상훈이야")

        //print
        println("answer = $answer")
    }
}