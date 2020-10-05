package com.example.myappmata.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myappmata.R
import com.example.myappmata.databinding.FragmentLoginBinding
import com.example.myappmata.ui.MainActivity
import com.example.myappmata.utils.toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment(),AuthListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
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

       // rootView = inflater.inflate(R.layout.fragment_login, container, false)

        var binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        val vm = activity?.let { ViewModelProvider(it).get(AuthViewModel::class.java) }
         binding.viewModel = vm
        if (vm != null) {
            vm.authListener = this
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun loadsignUpFragement(){
      setFragement(RegistrationFragment())
    }

    fun loadForgotpasswordFragement(){
      setFragement(ForgotPasswordFragment())
    }


    private fun setFragement(fragment: Fragment){

        if (fragment == null) return
        val fm = activity?.supportFragmentManager
        val tr = fm?.beginTransaction()
        tr?.setCustomAnimations(
            R.anim.slide_from_right,
            R.anim.slideout_from_left
        )
        tr?.replace(R.id.login_framelayout,fragment)
        tr?.commitAllowingStateLoss()

    }

     fun redirectToDashboard(){
         val intent = Intent(activity, MainActivity::class.java)
         activity?.startActivity(intent)
         activity?.finish()

     }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onStarted() {
        activity?.toast("Login Started")
    }

    override fun onSuccess() {
        activity?.toast("Login Success")
        redirectToDashboard()

    }

    override fun onFailure(message: String) {
        activity?.toast(message)
    }
    override fun onSignupButtonclick() {
        loadsignUpFragement()

    }
    override fun onForgotPasswordButtonClick() {
      loadForgotpasswordFragement()
    }






}