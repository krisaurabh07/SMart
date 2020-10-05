package com.example.myappmata

import android.content.Context
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.myappmata.ui.dashboard.HomeFragment
import kotlinx.android.synthetic.main.grid_product_layout.view.*
import kotlinx.android.synthetic.main.horizontalscroll_layout.view.*
import java.util.*


private const val BANNER_SLIDER: Int = 0
private const val ADDS_STRIP: Int = 1
private const val HORIZONTAL_PRODUCT_SLIDER = 2
private const val GRIDVIEW_PRODUCT = 3


class HomeMainRecyclerViewAdapter(
    val context: Context,
    val homeFragment: HomeFragment,
    val homePageModelList: List<HomePageModel>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var gridView: GridView


    override fun getItemViewType(position: Int): Int {

        if (homePageModelList[position].type == 0) {
            return BANNER_SLIDER
        } else if (homePageModelList[position].type == 1) {
            return ADDS_STRIP
        } else if (homePageModelList[position].type == 2) {
            return HORIZONTAL_PRODUCT_SLIDER
        } else {
            return GRIDVIEW_PRODUCT
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when (viewType) {
            BANNER_SLIDER -> {
                val view = LayoutInflater.from(context)
                    .inflate(R.layout.banner_slider_layout, parent, false)
                return BannerSliderViewHolder(view)
            }
            ADDS_STRIP -> {
                val view =
                    LayoutInflater.from(context).inflate(R.layout.strip_ad_layout, parent, false)
                return AddStripViewHolder(view)
            }
            HORIZONTAL_PRODUCT_SLIDER -> {
                val view = LayoutInflater.from(context)
                    .inflate(R.layout.horizontalscroll_layout, parent, false)
                return HorizontalProductSliderViewHolder(view)
            }
            GRIDVIEW_PRODUCT -> {
                val view = LayoutInflater.from(context)
                    .inflate(R.layout.grid_product_layout, parent, false)
                return GridViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(context)
                    .inflate(R.layout.grid_product_layout, parent, false)
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
                (holder as AddStripViewHolder).bindDataInAddStrip(
                    homeModelItem.stripaddsModel,
                    position
                )
            }
            HORIZONTAL_PRODUCT_SLIDER -> {
                (holder as HorizontalProductSliderViewHolder).bindDataInHorizontalProductSlider(
                    homeModelItem.hsModel
                )
            }
            GRIDVIEW_PRODUCT -> {
                (holder as GridViewHolder).bindDataInGridView(homeModelItem.grideModel)
            }

        }
    }


    inner class BannerSliderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currentPage = 2
        lateinit var bannerSlider: ViewPager2

       // var slideList:List<SliderModel>




        fun bindDataInBannerSlider(slideList: List<SliderModel>) {

            bannerSlider = itemView.findViewById(R.id.bannerslider_viewpager)
            bannerSlider.clipToPadding = false
            val crosoulAdapter = CrosoulAdapter(context, slideList)
            bannerSlider.adapter = crosoulAdapter
            startBannerSlideShow(slideList)

            bannerSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                    if (state == ViewPager2.SCROLL_STATE_IDLE){
                        pageLooper(slideList)
                    }
                }

                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                }
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    currentPage = position
                }
            })
        }

        fun pageLooper(slideList: List<SliderModel>) {

            if (currentPage == slideList.size - 2) {
                currentPage = 2
                bannerSlider.setCurrentItem(currentPage, false)
            }

            if (currentPage == 1) {
                currentPage = slideList.size - 3
                bannerSlider.setCurrentItem(currentPage, false)
            }


        }

        fun startBannerSlideShow(slideList: List<SliderModel>){

            val handler = Handler()
            val update = Runnable {
                if (currentPage == slideList.size) {
                    currentPage = 0
                }

                //The second parameter ensures smooth scrolling
                bannerSlider.setCurrentItem(currentPage++, true)
            }

            Timer().schedule(object : TimerTask() {
                // task to be scheduled
                override fun run() {
                    handler.post(update)
                }
            }, 2500, 2500)

        }

    }


    inner class AddStripViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindDataInAddStrip(stripImgList: List<HomeAddStripModel>, position: Int) {

            val stripadImage = itemView.findViewById<ImageView>(R.id.stripadd_image)
            val stripImgContainer = itemView.findViewById<View>(R.id.stripadd_container)
            stripadImage.setImageResource(stripImgList[2].imageLink)


        }

    }

    inner class HorizontalProductSliderViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bindDataInHorizontalProductSlider(productList: List<ProductHShomeModel>) {

            var horizontalrecyclerView: RecyclerView =
                itemView.findViewById(R.id.horizontalscroll_layout_recyclerview)
            horizontalrecyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            var hsAdapter = ProductHShomeAdapter(context, productList)
            horizontalrecyclerView.adapter = hsAdapter
            itemView.horizontal_scrolllayout_viewallbutton.setOnClickListener {
                homeFragment.viewAllButtonClick()
            }

        }


    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindDataInGridView(productList: List<ProductHShomeModel>) {

            var gridView: GridView = itemView.findViewById(R.id.grid_product_layout_grideview)
            var gridProductlayoutAdapter = GridProductLayoutAdapter(context, productList)
            gridView.adapter = gridProductlayoutAdapter
            itemView.grid_product_layout_viewAllbutton.setOnClickListener {
                homeFragment.viewAllButtonClick()
            }



        }


    }


}


