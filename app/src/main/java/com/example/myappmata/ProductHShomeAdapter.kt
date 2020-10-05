package com.example.myappmata

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.horizontal_scroll_item_layout.view.*
import kotlinx.android.synthetic.main.topcategory_item.view.*

class ProductHShomeAdapter(val context: Context,
                           val homehsProductLists:List<ProductHShomeModel>):
    RecyclerView.Adapter<ProductHShomeAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =  LayoutInflater.from(context).inflate(R.layout.horizontal_scroll_item_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return homehsProductLists.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val homeHSproductItemItem = homehsProductLists[position]
        holder.setdata(homeHSproductItemItem,position)

    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setdata(homeHSproductItem: ProductHShomeModel?, pos: Int) {
            itemView.hsproduct_image.setImageResource(homeHSproductItem!!.productimg)
            itemView.hsproduct_title.text = homeHSproductItem!!.title
            itemView.hsproduct_description.text = homeHSproductItem!!.productdescp
            itemView.hsproduct_price.text = homeHSproductItem!!.price

            itemView.setOnClickListener {
                val intent = Intent(context,ProductDetailsActivity::class.java)
                context?.startActivity(intent)

            }

        }
    }

}