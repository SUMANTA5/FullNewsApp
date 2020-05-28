package com.sumanta.newmvvmapp.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.sumanta.newmvvmapp.data.repositories.UserRepository
import com.sumanta.newmvvmapp.util.ApiException
import com.sumanta.newmvvmapp.util.Coroutines

class AuthViewModel : ViewModel() {
    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null


    fun onLoginButtonClick(view: View){
        authListener?.onStated()

        if (email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListener?.onFailure("Invalid email or password")
            return
        }
        Coroutines.main {
            try {
                val authResponse = UserRepository().userLogin(email!!, password!!)
              authResponse.user?.let {
                  authListener?.onSuccess(it)
                  return@main
              }
                authListener?.onFailure(authResponse.message!!)
            }catch (e: ApiException){
                authListener?.onFailure(e.message!!)
            }
        }


    }

}