package com.example.myappmata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.myappmata.ui.cart.CartFragment

class MyCartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cart)
        setDefaultFragement(CartFragment())
        initialSetUp()
    }


    fun initialSetUp() {

        val toolBar = findViewById<Toolbar>(R.id.myapp_toolbar)
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "My Cart"
        toolBar.menu.findItem(R.id.toolbar_notification).isVisible = false
        toolBar.menu.findItem(R.id.toolbar_search).isVisible = false
        toolBar.menu.findItem(R.id.toolbar_account).isVisible = false
        toolBar.menu.findItem(R.id.toolbar_cart).isVisible = false

    }
    override fun onSupportNavigateUp(): Boolean {
        if (supportActionBar?.title == "My Cart"){
            onBackPressed()
        }else{
           // replaceFragement(AccountHolderMainFragment())
        }
        return true
    }


    private fun setDefaultFragement(cartFragment: CartFragment){
        val fm = supportFragmentManager
        val tr = fm.beginTransaction()
        tr.add(R.id.myCartHolder_framelayout,cartFragment)
        tr.commitAllowingStateLoss()
    }

//    private fun replaceFragement(fragment: Fragment){
//
//        if (fragment == null) return
//        val fm = supportFragmentManager
//        val tr = fm?.beginTransaction()
//        tr?.setCustomAnimations(R.anim.slide_from_left,R.anim.slideout_from_right)
//        tr?.replace(R.id.account_mainfragement_holder,fragment)
//        tr?.commitAllowingStateLoss()
//
//    }



}