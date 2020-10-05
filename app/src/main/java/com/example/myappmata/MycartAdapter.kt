package com.example.myappmata

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.mycart_list_item.view.*
import kotlinx.android.synthetic.main.productcarditem.view.*
import kotlinx.android.synthetic.main.productcarditem.view.product_img
import kotlinx.android.synthetic.main.productcarditem.view.product_title

class MycartAdapter(val context: Context, val productList:List<ProductModel>): RecyclerView.Adapter<MycartAdapter.ProductViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view =  LayoutInflater.from(context).inflate(R.layout.mycart_list_item,parent,false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.setdata(product,position)

    }



    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var numberOfItem = 2


        fun setdata(product:ProductModel?,pos:Int){
            itemView.product_img.setImageResource(product!!.productimg)
            itemView.product_title.text = product.title
            itemView.setOnClickListener {
                val intent = Intent(context,ProductDetailsActivity::class.java)
                context?.startActivity(intent)
            }
            itemView.cart_minus_button.setOnClickListener{
                numberOfItem = numberOfItem - 1
                itemView.cart_item_count_textview.text = numberOfItem.toString()
            }
            itemView.cart_plus_button.setOnClickListener{
                numberOfItem = numberOfItem + 1
                itemView.cart_item_count_textview.text = numberOfItem.toString()
            }
        }
    }


}