package com.amarinag.error

import java.lang.Exception

class NetworkException(override val message: String?, val exception: Exception) : Throwable(message) {
}