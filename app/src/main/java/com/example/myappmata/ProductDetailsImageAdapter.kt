package com.example.myappmata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.wishlist_item_card.view.*

class ProductDetailsImageAdapter(val context: Context, val productDetailsImgList:List<SliderModel>): RecyclerView.Adapter<ProductDetailsImageAdapter.ProductDetailsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductDetailsViewHolder {
        val view =  LayoutInflater.from(context).inflate(R.layout.product_details_image_container,parent,false)
        return ProductDetailsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productDetailsImgList.size
    }

    override fun onBindViewHolder(holder: ProductDetailsViewHolder, position: Int) {
        val product = productDetailsImgList[position]
        holder.setdata(product,position)

    }

    inner class ProductDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun setdata(wishlist:SliderModel?,pos:Int){

        }

    }


}