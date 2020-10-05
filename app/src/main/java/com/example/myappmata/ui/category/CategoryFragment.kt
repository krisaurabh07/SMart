package com.example.myappmata.ui.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myappmata.CategoryMainRecyclerViewAdapter
import com.example.myappmata.ui.product.ProductFragment
import com.example.myappmata.R
import com.example.myappmata.categorySuplierModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var rootView:View
    lateinit var categoryMainrecyclerView: RecyclerView


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
        rootView = inflater.inflate(R.layout.fragment_category, container, false)
        initialSetUP()
        setToolBarForCategoryFragment()
        return rootView
    }



    fun initialSetUP(){

        categoryMainrecyclerView = rootView.findViewById(R.id.category_recyclerView)
        categoryMainrecyclerView.layoutManager = LinearLayoutManager(activity,
            LinearLayoutManager.VERTICAL, false
        )
        val homeAdapter =
            CategoryMainRecyclerViewAdapter(
                requireContext(),
                this,
                categorySuplierModel.categorySuplierList
            )
        categoryMainrecyclerView.adapter = homeAdapter
    }

    private fun setToolBarForCategoryFragment() {

        val toolBar = rootView.findViewById<Toolbar>(R.id.myapp_toolbar)
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).setSupportActionBar(toolBar)
        (activity as AppCompatActivity).title = "Shop by Category"

    }

    fun viewAllButtonClick(){

        setFragement(ProductFragment())

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



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CategoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CategoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}