package com.example.myappmata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.banner_slider_item.view.*
import kotlinx.android.synthetic.main.topcategory_item.view.*

class CrosoulAdapter(val context: Context, val crosoulList:List<SliderModel>) : RecyclerView.Adapter<CrosoulAdapter.ViewPagerViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.banner_slider_item, parent, false)
        return ViewPagerViewHolder(view)

    }
    override fun getItemCount(): Int {
        return crosoulList.size
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val topcategoryItem = crosoulList[position]
        holder.setdata(topcategoryItem,position)

    }

    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun setdata(crosoulItemItem:SliderModel?,pos:Int){

            if (crosoulItemItem != null) {
                itemView.crosoul_img.setImageResource(crosoulItemItem.imgLink)

            }


        }
    }

}










