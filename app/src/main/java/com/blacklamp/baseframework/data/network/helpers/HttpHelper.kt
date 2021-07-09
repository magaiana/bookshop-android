package com.blacklamp.baseframework.data.network.helpers

import okhttp3.Response
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import android.app.Activity
import android.widget.Toast
import com.google.gson.Gson
import android.content.Intent
import android.content.Context
import com.google.gson.JsonElement
import java.util.concurrent.TimeUnit
import com.blacklamp.baseframework.R
import com.blacklamp.baseframework.data.network.HttpCalls
import com.blacklamp.baseframework.utils.SessionManager
import com.blacklamp.baseframework.ui.auth.LoginActivity

fun Context.getOkHttpClient(hasAuth: Boolean, authHeaderVal: String? = ""): OkHttpClient {
    val httpClient = OkHttpClient.Builder()
        .readTimeout(90, TimeUnit.SECONDS)
        .writeTimeout(90, TimeUnit.SECONDS)
        .connectTimeout(90, TimeUnit.SECONDS)

    httpClient.addInterceptor(object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val original = chain.request()
            var authHeader = if (authHeaderVal?.isEmpty() == true) {
                "Bearer " + SessionManager(this@getOkHttpClient)//.accessToken!!
            } else {
                authHeaderVal
            }

            // check if api need two header or not
            // check if api need two header or not : Used to pass header values { if needed }
            val request = if (hasAuth) { //for two header
                original.newBuilder()
                    .header("ApiKey", HttpCalls.API_KEY)
                    .header("Content-Type", "application/json")
                    .header("Authorization", authHeader)
                    .method(original.method(), original.body())
                    .build()

            } else {
                original.newBuilder()
                    // .header("ApiKey", APICalls.API_KEY)
                    .method(original.method(), original.body())
                    .build()
            }

            val response = chain.proceed(request)
            val content = response.body()?.string()
            val contentType = response.body()?.contentType()

            try {
                val objResponse = Gson().fromJson(content, JsonElement::class.java).asJsonObject
                if (objResponse.has("status") && objResponse.get("status").asInt == HttpCalls.FORCE_LOGOUT) {

                    if (this@getOkHttpClient is Activity) {
                        this@getOkHttpClient.runOnUiThread {
                            val message = when {
                                objResponse.has("message") -> objResponse.get("message").asString
                                else -> getString(R.string.err_force_logout)
                            }

                            if (message.isNotBlank()) {
                                Toast.makeText(this@getOkHttpClient, message, Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                    startActivity(Intent(this@getOkHttpClient, LoginActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))
                    SessionManager(this@getOkHttpClient)//.accessToken!!
                }
                return response.newBuilder().body(ResponseBody.create(contentType, content!!)).build()

            } catch (e: Exception) {
                e.printStackTrace()
                return response.newBuilder().body(ResponseBody.create(contentType, content!!)).build()
            }
        }
    })

    return httpClient.build()
}