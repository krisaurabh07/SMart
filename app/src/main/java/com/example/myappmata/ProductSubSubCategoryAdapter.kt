package com.example.myappmata

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.product_topmenu_item.view.*
import kotlinx.android.synthetic.main.topcategory_item.view.*

class ProductSubSubCategoryAdapter(val context: Context, val topCategoryList:List<TopCategoryModel>):
    RecyclerView.Adapter<ProductSubSubCategoryAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_topmenu_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return topCategoryList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val topcategoryItem = topCategoryList[position]
        holder.setdata(topcategoryItem, position)

    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun setdata(topcategoryItem: TopCategoryModel?, pos: Int) {
            if (topcategoryItem != null) {
                itemView.subsubCategory_Item.text = topcategoryItem.itemName
            }

            itemView.setOnClickListener {
//                val intent = Intent(context, CategoryActivity::class.java)
//                intent.putExtra("CategoryName", topcategoryItem!!.itemName)
//                context?.startActivity(intent)
            }

        }

    }


}