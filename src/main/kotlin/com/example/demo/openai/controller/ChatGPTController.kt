package com.example.demo.openai.controller

import com.example.demo.openai.service.ChatGPTService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ChatGPTController(val chatGPTService: ChatGPTService) {

    @GetMapping("/answer")
    fun getAnswer(@RequestParam question: String): String {
        return chatGPTService.getAnswer(question)
    }
}