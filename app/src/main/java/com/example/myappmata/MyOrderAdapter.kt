package com.example.myappmata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.onlysingle_image_holder_item.view.*


class MyOrderAdapter(val context: Context, val myOrderLists:List<MyOrderModel>):
    RecyclerView.Adapter<MyOrderAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =  LayoutInflater.from(context).inflate(R.layout.onlysingle_image_holder_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myOrderLists.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val myorderItem = myOrderLists[position]
        holder.setdata(myorderItem,position)

    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun setdata(myOrderItem:MyOrderModel?,pos:Int){
            if (myOrderItem != null) {
                itemView.item_image_icon.setImageResource(myOrderItem.itemicon)
            }


        }

    }


}