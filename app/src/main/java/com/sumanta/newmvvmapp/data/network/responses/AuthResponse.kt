package com.sumanta.newmvvmapp.data.network.responses

import com.sumanta.newmvvmapp.data.db.entities.User

data class AuthResponse (
    var isSuccessful: Boolean?,
    var message: String?,
    var user: User?
)