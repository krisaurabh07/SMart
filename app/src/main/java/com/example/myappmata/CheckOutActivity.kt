package com.example.myappmata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class CheckOutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out)
        initialSetUp()
        setDefaultFragement(CheckOutFragment())

    }

    fun initialSetUp() {

        val toolBar = findViewById<Toolbar>(R.id.myapp_toolbar)
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Order Summery"

    }

    override fun onSupportNavigateUp(): Boolean {

        if (supportActionBar?.title == "Order Summery"){
            onBackPressed()
        }else{
            //replaceFragement(AccountHolderMainFragment())
        }
        return true


    }


    private fun setDefaultFragement(checkoutFragment:CheckOutFragment ){
        val fm = supportFragmentManager
        val tr = fm.beginTransaction()
        tr.add(R.id.checkout_mainfragement_holder,checkoutFragment)
        tr.commitAllowingStateLoss()
    }

    private fun replaceFragement(fragment: Fragment){

        if (fragment == null) return
        val fm = supportFragmentManager
        val tr = fm?.beginTransaction()
        tr?.setCustomAnimations(R.anim.slide_from_left,R.anim.slideout_from_right)
        tr?.replace(R.id.account_mainfragement_holder,fragment)
        tr?.commitAllowingStateLoss()

    }





}