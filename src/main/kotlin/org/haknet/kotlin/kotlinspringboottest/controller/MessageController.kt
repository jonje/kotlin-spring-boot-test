package org.haknet.kotlin.kotlinspringboottest.controller

import org.haknet.kotlin.kotlinspringboottest.data.Message
import org.haknet.kotlin.kotlinspringboottest.data.Notification
import org.haknet.kotlin.kotlinspringboottest.data.PushResponse
import org.haknet.kotlin.kotlinspringboottest.service.FirebaseService
import org.haknet.kotlin.kotlinspringboottest.util.GoogleAuthUtil
import org.springframework.web.bind.annotation.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@RestController
@RequestMapping("message")
class MessageController(@Inject private val firebaseService: FirebaseService) {

    @GetMapping()
    @ResponseBody
    fun getMessage() : Message {
        val notification = Notification("THis is my test message", "Test Message")
        return Message("myFirstTopic", notification)
    }

    @PostMapping()
    fun sendMessage(@RequestBody message: Message) {
        val call = this.firebaseService.sendMessage(message = message)
        call.enqueue(object : Callback<PushResponse> {
            override fun onResponse(call: Call<PushResponse>, response: Response<PushResponse>) {
                println("Successful push: ${response.body()?.name}")
            }

            override fun onFailure(call: Call<PushResponse>, t: Throwable) {
                println("Failed to send push message ${t.message}")
            }

        })
    }

    @GetMapping("token")
    fun getToken() : String {
        return GoogleAuthUtil.getToken()
    }
}