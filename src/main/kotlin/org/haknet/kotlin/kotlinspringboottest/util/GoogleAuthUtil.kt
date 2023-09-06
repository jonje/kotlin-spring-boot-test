package org.haknet.kotlin.kotlinspringboottest.util

import com.google.auth.oauth2.GoogleCredentials
import org.springframework.util.ResourceUtils
import java.io.FileInputStream

class GoogleAuthUtil {
    companion object {
        fun getToken() : String {
            val googleCredentials = GoogleCredentials
                    .fromStream(FileInputStream(ResourceUtils.getFile("classpath:service-account.json")))
                    .createScoped("https://www.googleapis.com/auth/firebase.messaging")
            val accessToken = googleCredentials.refreshAccessToken()
            return accessToken.tokenValue
        }
    }
}