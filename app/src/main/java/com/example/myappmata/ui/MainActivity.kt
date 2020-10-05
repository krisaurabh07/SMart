package com.example.myappmata.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myappmata.AccountActivity
import com.example.myappmata.MyCartActivity
import com.example.myappmata.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialSetUp()
       // setToolBarForMainActivity()
    }

    private fun initialSetUp() {
        val bottomNavagationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragment)
        bottomNavagationView.setupWithNavController(navController)
    }

    private fun setToolBarForMainActivity() {

        val toolBar = findViewById<Toolbar>(R.id.myapp_toolbar)
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "SMart"

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        val cartItem = menu?.findItem(R.id.toolbar_cart)
         cartItem?.setVisible(false)

        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemView = item.itemId
        when (itemView) {
            R.id.toolbar_search -> {
                Toast.makeText(applicationContext, "Search Click", Toast.LENGTH_SHORT).show()
            }
            R.id.toolbar_cart -> {
                val intent = Intent(this, MyCartActivity::class.java)
                this?.startActivity(intent)
            }
            R.id.toolbar_notification -> {
                Toast.makeText(applicationContext, "Notification Click", Toast.LENGTH_SHORT).show()
            }
            R.id.toolbar_account -> {
                val intent = Intent(this, AccountActivity::class.java)
                this?.startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }


}