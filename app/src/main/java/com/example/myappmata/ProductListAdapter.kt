package com.example.myappmata

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.productcarditem.view.*

class ProductListAdapter(val context: Context, val productList:List<ProductModel>): RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view =  LayoutInflater.from(context).inflate(R.layout.productcarditem,parent,false)
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

        var numberOfItem = 0
        var iswishlist = true

        fun setdata(product:ProductModel?,pos:Int){
            setupButtonState()
            itemView.product_img.setImageResource(product!!.productimg)
            itemView.product_title.text = product.title
            itemView.setOnClickListener {
                val intent = Intent(context,ProductDetailsActivity::class.java)
                context?.startActivity(intent)
            }
            itemView.selectwishtlist_button.setOnClickListener{
              if(iswishlist){
                  itemView.selectwishtlist_button.setImageResource(R.drawable.wishlist_selected)
                  iswishlist = false
              }else{
                  itemView.selectwishtlist_button.setImageResource(R.drawable.wishlist_unselected)
                  iswishlist = true
              }
            }

            itemView.addItemButton.setOnClickListener{
                numberOfItem = numberOfItem + 1
                itemView.product_noText.text = numberOfItem.toString()
               setupButtonState()
            }
            itemView.product_minusButton.setOnClickListener{
                numberOfItem = numberOfItem - 1
                itemView.product_noText.text = numberOfItem.toString()
                setupButtonState()
            }
            itemView.product_plusButton.setOnClickListener{
                numberOfItem = numberOfItem + 1
                itemView.product_noText.text = numberOfItem.toString()
                setupButtonState()
            }
        }

       fun setupButtonState(){

           if (itemView.product_noText.text =="0"){
               itemView.addItemButton.visibility = View.VISIBLE
               itemView.product_plusButton.visibility = View.GONE
               itemView.product_noText.visibility = View.GONE
               itemView.product_minusButton.visibility = View.GONE
           }else{
               itemView.addItemButton.visibility = View.GONE
               itemView.product_plusButton.visibility = View.VISIBLE
               itemView.product_noText.visibility = View.VISIBLE
               itemView.product_minusButton.visibility = View.VISIBLE
           }





       }



    }


}