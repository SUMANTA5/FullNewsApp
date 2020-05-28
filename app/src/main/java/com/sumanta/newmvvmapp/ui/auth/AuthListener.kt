package com.sumanta.newmvvmapp.ui.auth


import com.sumanta.newmvvmapp.data.db.entities.User

interface AuthListener {
    fun onStated()
    fun onSuccess(user: User)
    fun onFailure(message: String)

}