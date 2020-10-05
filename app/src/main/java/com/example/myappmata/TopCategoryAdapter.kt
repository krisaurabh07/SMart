package com.example.myappmata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myappmata.ui.dashboard.HomeFragment
import kotlinx.android.synthetic.main.topcategory_item.view.*


class TopCategoryAdapter(val context: Context, val homeFragement: HomeFragment, val topCategoryList:List<TopCategoryModel>):
    RecyclerView.Adapter<TopCategoryAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =  LayoutInflater.from(context).inflate(R.layout.topcategory_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
      return topCategoryList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val topcategoryItem = topCategoryList[position]
        holder.setdata(topcategoryItem,position)

    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


        fun setdata(topcategoryItem:TopCategoryModel?,pos:Int){
            if (topcategoryItem != null) {
                itemView.hometopCat_name.text = topcategoryItem.itemName
                itemView.hometopCat_icon.setImageResource(topcategoryItem.imageIcon)

            }

        itemView.setOnClickListener {
//            val intent = Intent(context,CategoryActivity::class.java)
//            intent.putExtra("CategoryName",topcategoryItem!!.itemName)
//            context?.startActivity(intent)
            homeFragement.clickOnTopCategoryItem(pos)


        }

        }

    }





}














