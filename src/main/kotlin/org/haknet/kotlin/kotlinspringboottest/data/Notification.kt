package org.haknet.kotlin.kotlinspringboottest.data

import com.google.gson.annotations.SerializedName

data class Notification(@SerializedName("body")
                        val body: String = "",
                        @SerializedName("title")
                        val title: String = "")