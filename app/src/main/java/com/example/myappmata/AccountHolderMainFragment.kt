package com.example.myappmata

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myappmata.ui.myorder.MyOrderFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AccountHolderMainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccountHolderMainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var recyclerView: RecyclerView
    protected lateinit var rootView: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            setHasOptionsMenu(true)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_account_holder_main, container, false)
        initializeRecyclerView()
        // initialSetUp()
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        super.onViewCreated(view, savedInstanceState)
    }


    fun initializeRecyclerView() {

        recyclerView = rootView.findViewById(R.id.accout_recyclerView)
        recyclerView.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        val adapter =
            AccountListAdapter(requireContext(), this, AccountModel.accountSuplier.accountDataList)
        recyclerView.adapter = adapter

    }


    fun methodForSelectionCellInList(position: Int) {

        when (position) {
            0 -> {
                Toast.makeText(activity, "This feature will be coming soon", Toast.LENGTH_SHORT)
                    .show()
            }
            1 -> {
                setNewFragement(MyOrderFragment())
            }
            2 -> {
                Toast.makeText(activity, "This feature will be coming soon", Toast.LENGTH_SHORT)
                    .show()
            }
            3 -> {
                Toast.makeText(activity, "This feature will be coming soon", Toast.LENGTH_SHORT)
                    .show()
            }
            4 -> {
                Toast.makeText(activity, "This feature will be coming soon", Toast.LENGTH_SHORT)
                    .show()
            }
            5 -> {
                setNewFragement(MyAddressFragment())
            }
            6 -> {
                Toast.makeText(activity, "This feature will be coming soon", Toast.LENGTH_SHORT)
                    .show()
            }
            7 -> {
                Toast.makeText(activity, "This feature will be coming soon", Toast.LENGTH_SHORT)
                    .show()
            }
            8 -> {
                Toast.makeText(activity, "This feature will be coming soon", Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }

    private fun setNewFragement(fragment: Fragment) {

        if (fragment == null) return
        val fm = activity?.supportFragmentManager
        val tr = fm?.beginTransaction()
        tr?.setCustomAnimations(R.anim.slide_from_right, R.anim.slideout_from_left)
        tr?.replace(R.id.account_mainfragement_holder, fragment)
        tr?.commitAllowingStateLoss()

    }

    //    Toast.makeText(applicationContext, "Search Click", Toast.LENGTH_SHORT).show()


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AccountHolderMainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AccountHolderMainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}