package com.example.myappmata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.account_list_item.view.*
import kotlinx.android.synthetic.main.account_view_item.view.*
import kotlinx.android.synthetic.main.wishlist_item_card.view.*


class AccountListAdapter(val context: Context,val accountHolderMainFragement:AccountHolderMainFragment, val accountModelists:List<AccountModel>): RecyclerView.Adapter<AccountListAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =  LayoutInflater.from(context).inflate(R.layout.account_view_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return accountModelists.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val product = accountModelists[position]
        holder.setdata(product,position)

    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun setdata(accountMList:AccountModel?,pos:Int){
            itemView.account_list_title.text = accountMList?.title
            if (accountMList != null) {
                itemView.account_list_icon.setImageResource(accountMList.icon)
            }
            
            itemView.setOnClickListener {
                accountHolderMainFragement.methodForSelectionCellInList(pos)

            }
        }


    }


}