package com.blacklamp.baseframework.data.network

import android.content.Context
import com.blacklamp.baseframework.data.network.helpers.APICallback
import com.blacklamp.baseframework.data.network.helpers.getOkHttpClient
import com.blacklamp.baseframework.utils.SessionManager
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginApiCall(
    context: Context,
    username: String,
    password: String,
    val callBack: APICallback
) {

    private var call: Call<ResponseBody>? = null
    private var sessionManager: SessionManager? = SessionManager(context)

//    init {
//        sessionManager =
//        val retrofit = Retrofit.Builder()
//            .baseUrl(HttpCalls.BASE_API_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(context.getOkHttpClient(false))
//            .build()
//
//        call = retrofit.create(HttpCalls::class.java).login(username, password)
//    }
//
//    fun executeCall(): Call<ResponseBody>? {
//        call?.enqueue(object : Callback<ResponseBody> {
//            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                callBack.onFailed(HttpCalls.FAILURE, t.message)
//            }
//
//            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//                if (response.isSuccessful) {
//                    callBack.onSuccess(response.code(), response.body()!!)
//                } else {
//                    try {
//                        callBack.onValidationError(response.code(), response.errorBody()!!)
//                    } catch (e: Exception) {
//                        callBack.onFailed(HttpCalls.BAD_REQUEST, e.message)
//                    }
//                }
//            }
//        })
//        return call
//    }
//
//    fun cancelCall() {
//        call?.cancel()
    //}
}