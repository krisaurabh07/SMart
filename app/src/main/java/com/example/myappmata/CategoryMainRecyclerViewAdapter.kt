package com.example.myappmata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.myappmata.ui.category.CategoryFragment
import kotlinx.android.synthetic.main.grid_product_layout.view.*
import kotlinx.android.synthetic.main.horizontalscroll_layout.view.*


private const val BANNER_SLIDER: Int = 0
private const val ADDS_STRIP: Int = 1
private const val HORIZONTAL_PRODUCT_SLIDER = 2
private const val GRIDVIEW_PRODUCT = 3
private const val GRIDLAYOUT_CATEGORY = 4

class CategoryMainRecyclerViewAdapter(
    val context: Context,
    val categoryFragment: CategoryFragment,
    val homePageModelList: List<CategoryModel>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var gridView : GridView


    override fun getItemViewType(position: Int): Int {

        if (homePageModelList[position].type == 0) {
            return BANNER_SLIDER
        } else if (homePageModelList[position].type == 1) {
            return ADDS_STRIP
        } else if (homePageModelList[position].type == 2) {
            return HORIZONTAL_PRODUCT_SLIDER
        }
        else if (homePageModelList[position].type == 3) {
            return GRIDVIEW_PRODUCT        }
        else {
          return  GRIDLAYOUT_CATEGORY
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when (viewType) {
            BANNER_SLIDER -> {
                val view = LayoutInflater.from(context).inflate(R.layout.banner_slider_layout, parent, false)
                return BannerSliderViewHolder(view)
            }
            ADDS_STRIP -> {
                val view = LayoutInflater.from(context).inflate(R.layout.strip_ad_layout, parent, false)
                return AddStripViewHolder(view)
            }
            HORIZONTAL_PRODUCT_SLIDER -> {
                val view = LayoutInflater.from(context).inflate(R.layout.horizontalscroll_layout, parent, false)
                return HorizontalProductSliderViewHolder(view)
            }
            GRIDVIEW_PRODUCT -> {
                val view = LayoutInflater.from(context).inflate(R.layout.grid_product_layout, parent, false)
                return GridViewHolder(view)
            }
            GRIDLAYOUT_CATEGORY -> {
                val view = LayoutInflater.from(context).inflate(R.layout.subcategory_layout, parent, false)
                return SubCategoryViewHolder(view)
            }
            else -> {
            val view = LayoutInflater.from(context).inflate(R.layout.grid_product_layout, parent, false)
            return GridViewHolder(view)
        }
        }
    }
    override fun getItemCount(): Int {
        return homePageModelList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val homeModelItem = homePageModelList[position]

        when (homeModelItem.type) {
            BANNER_SLIDER -> {
                (holder as BannerSliderViewHolder).bindDataInBannerSlider(homeModelItem.sliderModel)
            }
            ADDS_STRIP -> {
                (holder as AddStripViewHolder).bindDataInAddStrip(homeModelItem.stripaddsModel,
                    position)
            }
            HORIZONTAL_PRODUCT_SLIDER -> {
                (holder as HorizontalProductSliderViewHolder).bindDataInHorizontalProductSlider(homeModelItem.hsModel)
            }
            GRIDVIEW_PRODUCT -> {
                (holder as GridViewHolder).bindDataInGridView(homeModelItem.grideModel)
            }
            GRIDLAYOUT_CATEGORY -> {
                (holder as SubCategoryViewHolder).bindDataInSubCategory(homeModelItem.subCategoryModel)
            }

        }
    }


    inner class BannerSliderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindDataInBannerSlider(slideList:List<SliderModel>){

            var viewpager: ViewPager2 = itemView.findViewById(R.id.bannerslider_viewpager)
            viewpager.clipToPadding = false
            val crosoulAdapter = CrosoulAdapter(context,slideList)
            viewpager.adapter = crosoulAdapter

        }
    }

    inner class SubCategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindDataInSubCategory(subategoryList:List<SubCategoryModel>){


            val subcategoryrecyclerView:RecyclerView = itemView.findViewById(R.id.subcategory_recyclerview)
            subcategoryrecyclerView.layoutManager = GridLayoutManager(context,3,GridLayoutManager.VERTICAL,false)
            val hsAdapter = SubCategoryAdapter(context,categoryFragment,subategoryList)
            subcategoryrecyclerView.adapter = hsAdapter

        }
    }


    inner class AddStripViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindDataInAddStrip(stripImgList:List<HomeAddStripModel>,position: Int){

            val  stripadImage = itemView.findViewById<ImageView>(R.id.stripadd_image)
            val  stripImgContainer = itemView.findViewById<View>(R.id.stripadd_container)
            stripadImage.setImageResource(stripImgList[2].imageLink)

        }

    }

    inner class HorizontalProductSliderViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bindDataInHorizontalProductSlider(productList:List<ProductHShomeModel>){

            var horizontalrecyclerView:RecyclerView = itemView.findViewById(R.id.horizontalscroll_layout_recyclerview)
            horizontalrecyclerView.layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL,false)
            var hsAdapter = ProductHShomeAdapter(context,productList)
            horizontalrecyclerView.adapter = hsAdapter

            itemView.horizontal_scrolllayout_viewallbutton.setOnClickListener {
                categoryFragment.viewAllButtonClick()
            }

        }

    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindDataInGridView(productList:List<ProductHShomeModel>){

            var gridView: GridView = itemView.findViewById(R.id.grid_product_layout_grideview)
            var gridProductlayoutAdapter = GridProductLayoutAdapter(context,productList)
            gridView.adapter =  gridProductlayoutAdapter

            itemView.grid_product_layout_viewAllbutton.setOnClickListener {
                categoryFragment.viewAllButtonClick()
            }

        }



    }







}