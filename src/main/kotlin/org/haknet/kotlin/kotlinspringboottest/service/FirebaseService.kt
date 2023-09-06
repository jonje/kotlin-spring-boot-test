package org.haknet.kotlin.kotlinspringboottest.service

import org.haknet.kotlin.kotlinspringboottest.data.Message
import org.haknet.kotlin.kotlinspringboottest.data.PushResponse
import org.haknet.kotlin.kotlinspringboottest.util.GoogleAuthUtil
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface FirebaseService {

    @POST("./messages:send")
    fun sendMessage(
        @Header("Authorization") token: String = "Bearer ${GoogleAuthUtil.getToken()}",
        @Body message: Message
    ) : Call<PushResponse>

}