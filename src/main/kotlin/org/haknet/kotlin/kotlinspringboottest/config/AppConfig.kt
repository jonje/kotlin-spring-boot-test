package org.haknet.kotlin.kotlinspringboottest.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.haknet.kotlin.kotlinspringboottest.service.FirebaseService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

@Configuration
class AppConfig {

    @Bean
    fun getFirebaseService(@Value("\${google.project}") project: String) : FirebaseService {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://fcm.googleapis.com/v1/projects/$project/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()

        return retrofit.create(FirebaseService::class.java)
    }

    @Bean
    fun getObjectMapper() : ObjectMapper {
        return ObjectMapper().registerKotlinModule()
    }
}