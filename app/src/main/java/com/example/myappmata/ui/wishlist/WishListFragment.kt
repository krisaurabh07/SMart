package com.example.myappmata.ui.wishlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myappmata.R
import com.example.myappmata.WishListAdapter
import com.example.myappmata.WishListSuplier

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WishListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WishListFragment : Fragment() {
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
//        InitialSetup(inflater.inflate(R.layout.fragment_wish_list, container, false))
//        return inflater.inflate(R.layout.fragment_wish_list, container, false)
        rootView = inflater.inflate(R.layout.fragment_wish_list, container, false);
        initView()
        return rootView
    }

   private fun initView(){
        initializeRecyclerView()
    }

    private fun initializeRecyclerView() {
        recyclerView = rootView.findViewById(R.id.wishlist_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val adapter = WishListAdapter(
            requireContext(),
            WishListSuplier.wishlists
        )
        recyclerView.adapter = adapter
        recyclerView.setVisibility(View.GONE);

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WishListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WishListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}