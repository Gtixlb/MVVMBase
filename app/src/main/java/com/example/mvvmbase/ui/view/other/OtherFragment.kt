package com.example.mvvmbase.ui.view.other

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.example.mvvmbase.R
import com.example.mvvmbase.base.BaseFragment
import com.example.mvvmbase.databinding.FragmentOtherBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OtherFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OtherFragment : BaseFragment<FragmentOtherBinding, ViewModel>(
    FragmentOtherBinding::inflate,
    null,
) {
    override fun initFragment(
        binding: FragmentOtherBinding,
        viewModel: ViewModel?,
        savedInstanceState: Bundle?
    ) {
        binding.otherBtn.setOnClickListener {

        }
    }


}