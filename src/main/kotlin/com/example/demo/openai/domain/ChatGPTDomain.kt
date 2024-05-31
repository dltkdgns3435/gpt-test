package com.example.demo.openai.domain

import org.springframework.ai.openai.api.OpenAiApi
import org.springframework.ai.openai.api.OpenAiApi.ChatCompletionMessage
import org.springframework.ai.openai.api.OpenAiApi.DEFAULT_CHAT_MODEL
import org.springframework.http.ResponseEntity

class ChatGPTDomain(private val openAiApi: OpenAiApi, private val question: String) {

    fun getAnswer(): String? {
        val request: OpenAiApi.ChatCompletionRequest = generateDefaultQuestionRequest()
        val response: ResponseEntity<OpenAiApi.ChatCompletion> = openAiApi.chatCompletionEntity(request)
        val responseBody: MutableList<OpenAiApi.ChatCompletion.Choice> = response.body?.choices ?: return null

        return responseBody.stream().map { choice -> choice.message.rawContent }?.toList()
                ?.let { messages -> return messages.joinToString { it.toString() } }
    }

    private fun generateDefaultQuestionRequest(): OpenAiApi.ChatCompletionRequest {
        val question = listOf(ChatCompletionMessage(question, ChatCompletionMessage.Role.USER))

        return OpenAiApi.ChatCompletionRequest(question, DEFAULT_CHAT_MODEL, Float.MIN_VALUE)
    }

}