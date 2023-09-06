package org.haknet.kotlin.kotlinspringboottest.data

import com.fasterxml.jackson.annotation.JsonProperty

data class PushResponse(@JsonProperty("name") val name: String)
