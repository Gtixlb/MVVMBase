package com.example.mvvmbase.ui.view.mainnav.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.example.mvvmbase.R
import com.example.mvvmbase.base.BaseFragment
import com.example.mvvmbase.databinding.FragmentUserBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UserFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserFragment : BaseFragment<FragmentUserBinding, ViewModel>(
    FragmentUserBinding::inflate,
    null,
    true,
) {
    override fun initFragment(
        binding: FragmentUserBinding,
        viewModel: ViewModel?,
        savedInstanceState: Bundle?
    ) {
        publicViewModel!!.testValue.observe(requireActivity()){
            binding.publicValue.text=it
        }

    }


}