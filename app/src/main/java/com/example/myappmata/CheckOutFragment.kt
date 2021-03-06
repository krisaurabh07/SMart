package com.example.myappmata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CheckOutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CheckOutFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var horizontalrecyclerView: RecyclerView
    protected lateinit var rootView: View
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
        rootView = inflater.inflate(R.layout.fragment_check_out, container, false)
        initialSetUP()
        setupMyOrderItemScrollableLayout()
        return rootView
    }

    fun initialSetUP() {

        val checkOutButton = rootView.findViewById<Button>(R.id.cart_checkoutButton)
            checkOutButton.setOnClickListener{
                redirectToPaymentFragement(PaymentFragment())
            }

    }


    fun redirectToPaymentFragement(fragment: Fragment){

        val fm = activity?.supportFragmentManager
        val tr = fm?.beginTransaction()
        tr?.setCustomAnimations(R.anim.slide_from_right,R.anim.slideout_from_left)
        tr?.replace(R.id.checkout_mainfragement_holder,fragment)
        tr?.commitAllowingStateLoss()

    }


    private fun setupMyOrderItemScrollableLayout() {

        horizontalrecyclerView = rootView.findViewById(R.id.Order_SummeryHS_List)
        horizontalrecyclerView.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.HORIZONTAL, false
        )
        var hsAdapter = MyOrderAdapter(requireContext(), MyOrderModel.orderSuplier.orderDataList)
        horizontalrecyclerView.adapter = hsAdapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CheckOutFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CheckOutFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}