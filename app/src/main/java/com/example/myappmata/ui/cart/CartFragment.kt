package com.example.myappmata.ui.cart

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myappmata.CheckOutActivity
import com.example.myappmata.MycartAdapter
import com.example.myappmata.ProductSuplier
import com.example.myappmata.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CartFragment : Fragment() {
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
        rootView = inflater.inflate(R.layout.fragment_cart, container, false)
        initializeRecyclerView()
        initialSetUP()
        setToolBarForCartFragment()
        return rootView
    }


    fun initialSetUP(){
       val checkOutButton =  rootView.findViewById<View>(R.id.cart_checkoutButton)
        checkOutButton.setOnClickListener{
            redirectCheckOutActivity()
        }
    }

    private fun initializeRecyclerView() {
        recyclerView = rootView.findViewById(R.id.myCart_list_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val adapter = MycartAdapter(
            requireContext(),
            ProductSuplier.productlists
        )
        recyclerView.adapter = adapter
    }

    private fun redirectCheckOutActivity(){
        val intent = Intent(context, CheckOutActivity::class.java)
        context?.startActivity(intent)
    }

    private fun setToolBarForCartFragment() {

        val toolBar = rootView.findViewById<Toolbar>(R.id.myapp_toolbar)
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).setSupportActionBar(toolBar)
        (activity as AppCompatActivity).title = "My Cart"

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CartFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CartFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}