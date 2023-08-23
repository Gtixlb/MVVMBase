package com.example.mvvmbase.ui.view.mainnav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.mvvmbase.R
import com.example.mvvmbase.base.BaseFragment
import com.example.mvvmbase.databinding.FragmentMainNavBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainNavFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainNavFragment : BaseFragment<FragmentMainNavBinding, ViewModel>(
    FragmentMainNavBinding::inflate,
    null,
) {
    override fun initFragment(
        binding: FragmentMainNavBinding,
        viewModel: ViewModel?,
        savedInstanceState: Bundle?
    ) {
        (childFragmentManager.findFragmentById(R.id.main_view_nav) as NavHostFragment).apply {
            binding.bottomNav.setupWithNavController(this.navController)
        }
    }

}