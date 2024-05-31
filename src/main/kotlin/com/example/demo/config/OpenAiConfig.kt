package com.example.demo.config

import org.springframework.ai.openai.api.OpenAiApi
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenAiConfig {

    @Value("\${spring.ai.openai.api-key}")
    private lateinit var secretKey: String

    @Bean
    fun openAiApi(): OpenAiApi {
        return OpenAiApi(secretKey)
    }

  
}