package com.example.myappmata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.wishlist_item_card.view.*

class WishListAdapter(val context: Context, val wishlists:List<WishList>): RecyclerView.Adapter<WishListAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =  LayoutInflater.from(context).inflate(R.layout.wishlist_item_card,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return wishlists.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val product = wishlists[position]
        holder.setdata(product,position)

    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun setdata(wishlist:WishList?,pos:Int){
            itemView.product_title.text = wishlist!!.title
        }

    }


}