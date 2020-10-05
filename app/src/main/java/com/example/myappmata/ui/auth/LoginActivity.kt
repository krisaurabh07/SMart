package com.example.myappmata.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.FrameLayout
import com.example.myappmata.R

class LoginActivity : AppCompatActivity() {
    var frameLayout: FrameLayout? = null
   public var onfromForgotPassword = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        frameLayout = findViewById<FrameLayout>(R.id.login_framelayout)
        setDefaultFragement(LoginFragment())

    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            if(onfromForgotPassword) {
               setFragement(LoginFragment())
                onfromForgotPassword = false
            }
            return false
        }

        return super.onKeyDown(keyCode, event)
    }

    private fun setDefaultFragement(loginFragment: LoginFragment){
        if (loginFragment == null) return
        val fm = supportFragmentManager
        val tr = fm.beginTransaction()
        tr.add(R.id.login_framelayout,loginFragment)
        tr.commitAllowingStateLoss()
    }

    private fun setFragement(loginFragment: LoginFragment){
        if (loginFragment == null) return
        val fm = supportFragmentManager
        val tr = fm.beginTransaction()
        tr?.setCustomAnimations(
            R.anim.slide_from_left,
            R.anim.slideout_from_right
        )
        tr.add(R.id.login_framelayout,loginFragment)
        tr.commitAllowingStateLoss()
    }

}