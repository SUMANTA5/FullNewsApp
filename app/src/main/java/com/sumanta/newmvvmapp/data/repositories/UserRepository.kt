package com.sumanta.newmvvmapp.data.repositories


import com.sumanta.newmvvmapp.data.network.MyApi
import com.sumanta.newmvvmapp.data.network.SafeApiRequest
import com.sumanta.newmvvmapp.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String) : AuthResponse{

        return apiRequest { MyApi().userLogin(email, password) }

    }


}