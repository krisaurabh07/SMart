package com.example.myappmata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductDetailsActivity : AppCompatActivity() {
    lateinit var recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        initialSetUp()
        setupProductDetailsImages()
    }


    fun initialSetUp() {

        val toolBar = findViewById<Toolbar>(R.id.myapp_toolbar)
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Product Details"

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        val searchItem = menu?.findItem(R.id.toolbar_search)
        val accountItem = menu?.findItem(R.id.toolbar_account)
        val notificationItem = menu?.findItem(R.id.toolbar_notification)

        accountItem?.setVisible(false)
        searchItem?.setVisible(false)
        notificationItem?.setVisible(false)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemView = item.itemId
        when (itemView) {
            R.id.toolbar_search -> {
                Toast.makeText(applicationContext, "Search Click", Toast.LENGTH_SHORT).show()
            }
            R.id.toolbar_cart -> {
               // val intent = Intent(this,MyCartActivity::class.java)
               // this?.startActivity(intent)
            }
            R.id.toolbar_notification -> {
                Toast.makeText(applicationContext, "Notification Click", Toast.LENGTH_SHORT).show()
            }
            R.id.toolbar_account -> {
             //   val intent = Intent(this,AccountActivity::class.java)
              //  this?.startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {

        if (supportActionBar?.title == "Product Details"){
            onBackPressed()
        }else{
           // replaceFragement(AccountHolderMainFragment())
        }
        return true

    }




    fun setupProductDetailsImages(){

        recyclerView = findViewById(R.id.descpt_img_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        val adapter = ProductDetailsImageAdapter(this,crosoulSuplier.crosouls)
        recyclerView.adapter = adapter

    }
}