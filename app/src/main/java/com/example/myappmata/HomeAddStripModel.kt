package com.example.myappmata


data class HomeAddStripModel(var imageLink:Int){


    object homeaddStripSuplier {

        val stripSuplier = listOf(

            HomeAddStripModel(R.drawable.offerstrip1),
            HomeAddStripModel(R.drawable.offerstrip2),
            HomeAddStripModel(R.drawable.offerstrip3)
        )
    }


}



