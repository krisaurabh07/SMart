package com.example.myappmata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyAddressFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyAddressFragment : Fragment() {
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
        rootView =  inflater.inflate(R.layout.fragment_my_address, container, false)
        initialSetup()
        return rootView
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AccountActivity).supportActionBar?.title = "Choose Delivery Address"

    }



    fun initialSetup() {

        recyclerView = rootView.findViewById(R.id.myaddress_recyclerView)
        recyclerView.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        val adapter = MyAddressAdapter(requireContext(), MyAddressModel.myAddressSuplier.myaddressList)
        recyclerView.adapter = adapter

        val addAddress = rootView.findViewById<View>(R.id.add_new_address)
        addAddress.setOnClickListener{
            redirectToAddEditAddressfragement(MyAddEditAddressFragment())
        }

    }

    fun redirectToAddEditAddressfragement(fragment:Fragment){

        if (fragment == null) return
        val fm = activity?.supportFragmentManager
        val tr = fm?.beginTransaction()
        tr?.setCustomAnimations(R.anim.slide_from_right, R.anim.slideout_from_left)
        tr?.replace(R.id.account_mainfragement_holder, fragment)
        tr?.commitAllowingStateLoss()

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MyAddressFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyAddressFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}