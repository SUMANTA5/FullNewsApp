package com.sumanta.newmvvmapp.data.network

import com.sumanta.newmvvmapp.data.network.responses.AuthResponse
import com.sumanta.newmvvmapp.util.Constants.Companion.User_BASE_URL
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyApi {

    @FormUrlEncoded
    @POST("login")
    suspend fun userLogin(
        @Field("email")email: String,
       @Field("password")password: String
    ) : Response<AuthResponse>


    companion object{
        operator fun invoke() : MyApi {
            return Retrofit.Builder()
                .baseUrl(User_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }


}