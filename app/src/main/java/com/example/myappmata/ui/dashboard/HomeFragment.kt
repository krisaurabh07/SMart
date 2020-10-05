package com.example.myappmata.ui.dashboard

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.GridView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.myappmata.*
import com.example.myappmata.ui.category.CategoryFragment
import com.example.myappmata.ui.product.ProductFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    protected lateinit var rootView: View
    lateinit var recyclerView: RecyclerView
    lateinit var homeMainrecyclerView: RecyclerView
    lateinit var horizontalrecyclerView: RecyclerView
    lateinit var gridView :GridView


    //// Banner Slider
    lateinit var viewpager: ViewPager2
    /////



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home, container, false)
        initView()
        return  rootView
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      // val gotoProductButtton = view.findViewById<Button>(R.id.gotoNextButton)
//        gotoProductButtton.setOnClickListener {
//            val intent = Intent(activity,ProductActivity::class.java)
//            activity?.startActivity(intent)
//        }
    }

    private fun initView(){

        setToolBarForHomeFragment()
        initializeCategoryRecyclerView()
        setupHomeRecyclerView()

//        initializeCrosouls()
//        initializeStripAddLayout()
//        initializeHSProductLayout()
//        initializeGridLayout()
    }


    private fun setToolBarForHomeFragment() {

        val toolBar = rootView.findViewById<Toolbar>(R.id.myapp_toolbar)
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).setSupportActionBar(toolBar)
        (activity as AppCompatActivity).title = "SMart"

    }


    private fun initializeCategoryRecyclerView() {
        recyclerView = rootView.findViewById(R.id.home_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        val adapter = TopCategoryAdapter(
            requireContext(),
            this,
            topCategorySuplier.topcategoryList
        )
        recyclerView.adapter = adapter
    }

    private fun setupHomeRecyclerView(){

        homeMainrecyclerView = rootView.findViewById(R.id.testing)
        homeMainrecyclerView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        val homeAdapter = HomeMainRecyclerViewAdapter(
            requireContext(),
            this,
            homePageSuplierModel.homePageSuplierList
        )
        homeMainrecyclerView.adapter = homeAdapter
    }

    fun viewAllButtonClick(){

        setFragement(ProductFragment())

    }

    fun clickOnTopCategoryItem(position:Int){
           setFragement(CategoryFragment())
    }

    fun clickOnProductTiles(position:Int){

       // setFragement(Product_d)
    }


    private fun setFragement(fragment: Fragment){
        val fm = activity?.supportFragmentManager
        val tr = fm?.beginTransaction()
        tr?.setCustomAnimations(
            R.anim.slide_from_right,
            R.anim.slideout_from_left
        )
        tr?.replace(R.id.homeFragment_Container,fragment)
        tr?.commitAllowingStateLoss()

    }

    private fun initializeCrosouls(){

        viewpager = rootView.findViewById(R.id.bannerslider_viewpager)
        viewpager.clipToPadding = false
        val crosoulAdapter = CrosoulAdapter(
            requireContext(),
            crosoulSuplier.crosouls
        )
        viewpager.adapter = crosoulAdapter

    }
    private fun initializeStripAddLayout(){
        val  stripadImage = rootView.findViewById<ImageView>(R.id.stripadd_image)
        val  stripImgContainer = rootView.findViewById<View>(R.id.stripadd_container)
        stripadImage.setImageResource(R.drawable.crosulfour)


    }

//    private fun initializeHSProductLayout(){
//
//        horizontalrecyclerView = rootView.findViewById(R.id.horizontalscroll_layout_recyclerview)
//        horizontalrecyclerView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
//        var hsAdapter = ProductHShomeAdapter(requireContext(),ProductHshomeListSuplier.producthshomelists)
//        horizontalrecyclerView.adapter = hsAdapter
//    }

    private fun initializeGridLayout(){

        gridView = rootView.findViewById(R.id.grid_product_layout_grideview)
        var gridProductlayoutAdapter =
            GridProductLayoutAdapter(
                requireContext(),
                ProductHshomeListSuplier.producthshomelists
            )
        gridView.adapter =  gridProductlayoutAdapter

    }


    companion object {

        const val ARG_POSITION = "position"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }



    }
}