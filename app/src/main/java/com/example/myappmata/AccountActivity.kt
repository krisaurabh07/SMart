package com.example.myappmata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AccountActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    //var frameLayout: FrameLayout? = null
   val isFromMainAccountHolder = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        setDefaultFragement(AccountHolderMainFragment())
        initialSetUp()
    }

    fun initialSetUp() {

        val toolBar = findViewById<Toolbar>(R.id.myapp_toolbar)
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Account"

    }

    override fun onSupportNavigateUp(): Boolean {

       if (supportActionBar?.title == "Account"){
           onBackPressed()
       }else{
           replaceFragement(AccountHolderMainFragment())
       }
        return true

    }

    private fun setDefaultFragement(account_main_holderFragment: AccountHolderMainFragment){
        if (account_main_holderFragment == null) return
        val fm = supportFragmentManager
        val tr = fm.beginTransaction()
        tr.add(R.id.account_mainfragement_holder,account_main_holderFragment)
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

