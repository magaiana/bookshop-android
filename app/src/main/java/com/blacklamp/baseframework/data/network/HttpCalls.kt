package com.blacklamp.baseframework.data.network

import com.blacklamp.baseframework.data.network.helpers.HttpRequestInterceptor
import com.blacklamp.baseframework.data.network.helpers.getOkHttpClient
import com.blacklamp.baseframework.models.AuthResponse
import com.blacklamp.baseframework.models.RegistrationModel
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.http.*
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface HttpCalls {

    companion object {

        private const val REMOTE_URL = "https://::80/"
        private const val LOCAL_BASE_URL = "http://10.0.2.2:80/"

        const val API_KEY = ""
        const val SERVER_TIME = "server_time"
        const val BASE_API_URL = LOCAL_BASE_URL + "api/"

        const val DEVICE_TYPE = "android"
        const val LOGIN_TYPE_GOOGLE = "google"
        const val LOGIN_TYPE_FACEBOOK = "facebook"
        const val LOGIN_TYPE_LINKEDIN = "linkedIn"
        const val LOGIN_TYPE_TWITTER = "twitter"
        const val LOGIN_TYPE_MICROSOFT = "microsoft"

        const val LOGOUT = "logout"
        const val LOGIN = "User/login"
        const val SIGN_UP = "User/sign-up"
        const val SOCIAL_LOGIN = "social_login"
        const val CHANGE_PASSWORD = "change_pwd"
        const val FORGOT_PASSWORD = "forgot_password"
        const val RECOVER_PASSWORD = "reset_password"

        const val FAILURE = 0
        const val SUCCESS = 1
        const val OK_RESULTS = 200
        const val CALL_FAILED = -1
        const val BAD_REQUEST = 400
        const val FORCE_LOGOUT = 5
        const val REFERRAL_REMAINING = 3
        const val VERIFICATION_PENDING = 2

        operator fun  invoke(httpRequestInterceptor: HttpRequestInterceptor): HttpCalls {
            val getOkHttpClient = OkHttpClient.Builder()
                .addInterceptor(httpRequestInterceptor)
                .build()


            return Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient)
                .build()
                .create(HttpCalls::class.java)
        }
    }

    //method for sign up
    @Headers("Accept: application/json")
    @POST(SIGN_UP)
    fun signUp(@Body params: RegistrationModel): Call<ResponseBody>

    //method for login
    @Headers("Accept: application/json")
    @POST(LOGIN)
    suspend fun login(@Field("username") username: String, @Field("password") password: String,): Response<AuthResponse>

    //method to get server time
    @GET(SERVER_TIME)
    fun getServerTime(@Query("apiKey") apiKey: String): Call<ResponseBody>

    @FormUrlEncoded
    @POST(LOGOUT)
    fun logout(@FieldMap params: Map<String, String>): Call<ResponseBody>

    //method for forgot password
    @FormUrlEncoded
    @POST(FORGOT_PASSWORD)
    fun forgotPassword(@FieldMap params: Map<String, String>): Call<ResponseBody>

    //method for recover password
    @FormUrlEncoded
    @POST(RECOVER_PASSWORD)
    fun recoverPassword(@FieldMap params: Map<String, String>): Call<ResponseBody>

    //method for change password
    @FormUrlEncoded
    @POST(CHANGE_PASSWORD)
    fun changePassword(@FieldMap params: Map<String, String>): Call<ResponseBody>

    //method for social login
    @FormUrlEncoded
    @POST(SOCIAL_LOGIN)
    fun socialLogin(@FieldMap params: Map<String, String>): Call<ResponseBody>
}