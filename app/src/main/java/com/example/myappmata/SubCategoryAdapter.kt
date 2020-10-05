package com.example.myappmata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myappmata.ui.category.CategoryFragment
import kotlinx.android.synthetic.main.subcategory_item.view.*


class SubCategoryAdapter(val context: Context, val categoryFragment: CategoryFragment, val subCategoryList:List<SubCategoryModel>):
    RecyclerView.Adapter<SubCategoryAdapter.CategoryViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view =  LayoutInflater.from(context).inflate(R.layout.subcategory_item,parent,false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return subCategoryList.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val topcategoryItem = subCategoryList[position]
        holder.setdata(topcategoryItem,position)

    }

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


        fun setdata(topcategoryItem:SubCategoryModel?,pos:Int){
            if (topcategoryItem != null) {
                  itemView.category_title.text = topcategoryItem.categoryName
                 itemView.category_icon.setImageResource(topcategoryItem.categoryIcon)
            }

            itemView.setOnClickListener {
                categoryFragment.viewAllButtonClick()
            }

        }

    }

}

