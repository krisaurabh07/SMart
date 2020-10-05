package com.example.myappmata.ui.auth

interface AuthListener {

    fun onStarted()
    fun onSuccess()
    fun onFailure(message: String)
    fun onSignupButtonclick()
    fun onForgotPasswordButtonClick()

}