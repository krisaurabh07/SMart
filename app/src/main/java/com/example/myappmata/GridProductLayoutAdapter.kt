package com.example.myappmata

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.wishlist_item_card.view.*

class GridProductLayoutAdapter(val context: Context, val homehsProductLists:List<ProductHShomeModel>): BaseAdapter(){

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View? {



        val view =  LayoutInflater.from(context).inflate(R.layout.horizontal_scroll_item_layout,null)
        view.elevation = 0.0f
        view.setBackgroundColor(Color.parseColor("#ffffff"))
        val title = view.findViewById<TextView>(R.id.hsproduct_title)
        val price = view.findViewById<TextView>(R.id.hsproduct_price)
        val descpt = view.findViewById<TextView>(R.id.hsproduct_description)
        val productImg = view.findViewById<ImageView>(R.id.hsproduct_image)

        title.text = homehsProductLists[p0].title
        price.text = homehsProductLists[p0].price
        descpt.text = homehsProductLists[p0].productdescp
        productImg.setImageResource(homehsProductLists[p0].productimg)

        view.setOnClickListener {
            val intent = Intent(context,ProductDetailsActivity::class.java)
            context?.startActivity(intent)
        }

        return view

    }


    override fun getItem(p0: Int): Any? {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return 4
    }



}