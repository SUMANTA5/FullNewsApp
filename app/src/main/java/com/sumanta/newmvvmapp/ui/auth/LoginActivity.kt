package com.sumanta.newmvvmapp.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.sumanta.newmvvmapp.R
import com.sumanta.newmvvmapp.data.db.entities.User
import com.sumanta.newmvvmapp.databinding.ActivityLoginBinding
import com.sumanta.newmvvmapp.util.hide
import com.sumanta.newmvvmapp.util.show
import com.sumanta.newmvvmapp.util.snackbar
import com.sumanta.newmvvmapp.util.toast
import kotlinx.android.synthetic.main.activity_login.*


 class LoginActivity : AppCompatActivity(), AuthListener {

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)

         val binding: ActivityLoginBinding =
             DataBindingUtil.setContentView(this, R.layout.activity_login)
         val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
         binding.viewmodel = viewModel

         viewModel.authListener = this


     }

     override fun onStated() {
         progress_bar.show()
         toast("Login Started")
     }

     override fun onSuccess(user: User) {
         progress_bar.hide()
         root_layout.snackbar("${user.name} is Logged In")
        // toast("${user.name} is Logged In")
     }

     override fun onFailure(message: String) {
         progress_bar.hide()
         //toast(message)
         root_layout.snackbar(message)
     }
}
