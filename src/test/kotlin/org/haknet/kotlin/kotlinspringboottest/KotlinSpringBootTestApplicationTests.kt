package org.haknet.kotlin.kotlinspringboottest

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import org.haknet.kotlin.kotlinspringboottest.data.PushResponse
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KotlinSpringBootTestApplicationTests {

    val mapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule.Builder().build())

    @Test
    fun whenSerializePushResponse_thenSuccess() {
        val pushResponse = PushResponse("projects/test-notification/messages/2477757002822026317")
        val serialized = mapper.writeValueAsString(pushResponse)

        val json = """{"name":"projects/test-notification/messages/2477757002822026317"}"""

        assertEquals(serialized, json)
    }

    @Test
    fun whenDeserializePushResponse_thenSuccess() {
        val json = """{"name":"projects/test-notification/messages/2477757002822026317"}"""
        val pushResponse: PushResponse = mapper.readValue(json)

        assertEquals(pushResponse.name, "projects/test-notification/messages/2477757002822026317")
    }

}
