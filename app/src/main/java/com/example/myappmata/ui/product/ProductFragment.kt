package com.example.myappmata.ui.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myappmata.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProductFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    protected lateinit var rootView: View
    lateinit var recyclerView: RecyclerView

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
        rootView = inflater.inflate(R.layout.fragment_product, container, false)
        initView()

        return  rootView
    }


    private fun initView(){
        initializeRecyclerView()
        setToolBarForProductFragment()
    }

    private fun setToolBarForProductFragment() {

        val toolBar = rootView.findViewById<Toolbar>(R.id.myapp_toolbar)
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).setSupportActionBar(toolBar)
        (activity as AppCompatActivity).title = "SMart"

    }


    private fun initializeRecyclerView() {


        recyclerView = rootView.findViewById(R.id.topHorizontalSlider_RecyclerView)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val adapter = ProductSubSubCategoryAdapter(
            requireContext(),
            topCategorySuplier.topcategoryList
        )
        recyclerView.adapter = adapter

        recyclerView = rootView.findViewById(R.id.product_listRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val productListAdapter = ProductListAdapter(
            requireContext(),
            ProductSuplier.productlists
        )
        recyclerView.adapter = productListAdapter
    }



    companion object {

        const val ARG_POSITION = "position"
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProductFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProductFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

        fun getInstance(position: Int): Fragment {
            val doppelgangerFragment =
                ProductFragment()
            val bundle = Bundle()
            bundle.putInt(ARG_POSITION, position)
            doppelgangerFragment.arguments = bundle
            return doppelgangerFragment
        }


    }
}