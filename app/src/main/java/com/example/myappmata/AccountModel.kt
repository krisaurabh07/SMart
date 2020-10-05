package com.example.myappmata

data class AccountModel(val title:String, val icon:Int){

    object accountSuplier {
        val accountDataList = listOf(
            AccountModel("My Application",R.drawable.account_myapp),
            AccountModel("My Orders",R.drawable.account_myorder),
            AccountModel("My Wishlist",R.drawable.account_wish_list),
            AccountModel("My Cards Wallet",R.drawable.account_cards),
            AccountModel("My Coupons",R.drawable.account_coupan),
            AccountModel("My Delivery Addresses",R.drawable.account_location),
            AccountModel("My Question Answer",R.drawable.account_question_answer),
            AccountModel("Help Center",R.drawable.account_help),
            AccountModel("Sign Out",R.drawable.account_logout)
        )

    }



}














