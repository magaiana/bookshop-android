package com.blacklamp.baseframework.data.network

import com.blacklamp.baseframework.BuildConfig
import com.blacklamp.baseframework.models.UserResponse
import com.blacklamp.baseframework.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    companion object {

        fun createCall(): UserService {

            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(UserService::class.java)
        }
    }

    @GET(ApiRoutes.LOGIN)
    suspend fun login(username: String,password: String) : Response<UserResponse>
}
