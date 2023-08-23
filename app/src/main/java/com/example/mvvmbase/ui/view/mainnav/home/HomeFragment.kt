package com.example.mvvmbase.ui.view.mainnav.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.mvvmbase.R
import com.example.mvvmbase.base.BaseFragment
import com.example.mvvmbase.databinding.FragmentHomeBinding
import com.example.mvvmbase.databinding.FragmentLoginBinding


class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    FragmentHomeBinding::inflate,
    HomeViewModel::class.java,
    true
) {
    override fun initFragment(
        binding: FragmentHomeBinding,
        viewModel: HomeViewModel?,
        savedInstanceState: Bundle?
    ) {
        binding.btn.setOnClickListener{
            // 父Fragment跳转到子Fragment，需要获取Activity进行跳转，否则会报错
            // 获取最上层的Fragment（为MainActivity），用它来跳转其他页面
            requireActivity().findNavController(R.id.app_nav).navigate(R.id.action_mainNavFragment_to_otherFragment)

        }
        // 监听ViewModel值的变化，并回显到页面上
        viewModel!!.testValue.observe(requireActivity()){
            binding.changeValue.text=it
        }
        // 监听view按钮事件，并对ViewModel赋值赋值
        binding.btnValue.setOnClickListener{
            viewModel.testValue.value="你好 homeViewModel"
        }
        // 监听view按钮事件，并对ViewModel赋值赋值
        binding.btnPubValue.setOnClickListener{
            publicViewModel?.apply {
                this.testValue.value="home改变了public的值"
            }

        }
    }


}