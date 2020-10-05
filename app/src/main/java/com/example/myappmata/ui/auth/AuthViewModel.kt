package com.example.myappmata.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

    var email: String? = "smart@gmail.com"
    var password: String? = "smart"
    var authListener: AuthListener? = null


    fun onLoginButtonClick(view: View) {

        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invalid email or password")
            return
        }
        authListener?.onSuccess()
    }

    fun onForgotPasswordButtonClick(view: View) {
        authListener?.onForgotPasswordButtonClick()

    }

    fun onSignupButtonClick(view: View) {

        authListener?.onSignupButtonclick()
    }


}