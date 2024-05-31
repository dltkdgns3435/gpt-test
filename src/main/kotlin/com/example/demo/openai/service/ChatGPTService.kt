package com.example.demo.openai.service

import com.example.demo.openai.domain.ChatGPTDomain
import org.springframework.ai.openai.api.OpenAiApi
import org.springframework.stereotype.Service

@Service
class ChatGPTService(private val openAiApi: OpenAiApi) {

    fun getAnswer(question: String): String {
        val answer = ChatGPTDomain(openAiApi, question).getAnswer()

        require(answer != null) { "Failed to get answer from OpenAI" }

        return answer
    }
}