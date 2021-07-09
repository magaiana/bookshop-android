package com.blacklamp.baseframework.data.network.helpers

import okhttp3.ResponseBody

interface APICallback {
    fun onSuccess(status: Int, content: ResponseBody? = null)
    fun onFailed(status: Int, content: String? = null)
    fun onValidationError(status: Int, content: ResponseBody? = null)
}  