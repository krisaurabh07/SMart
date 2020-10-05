package com.example.myappmata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.onlysingle_image_holder_item.view.*

class MyAddressAdapter(val context: Context, val myAddressLists:List<MyAddressModel>):
    RecyclerView.Adapter<MyAddressAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =  LayoutInflater.from(context).inflate(R.layout.myaddress_list_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myAddressLists.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val myorderItem = myAddressLists[position]
        holder.setdata(myorderItem,position)

    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun setdata(myOrderItem:MyAddressModel?,pos:Int){

        }

    }


}