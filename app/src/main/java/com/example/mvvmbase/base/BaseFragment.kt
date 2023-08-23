package com.example.mvvmbase.base
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.mvvmbase.viewmodel.PublicViewModel


abstract class BaseFragment<VB:ViewBinding, VM:ViewModel>(
    private val inflater:(LayoutInflater, ViewGroup?, Boolean) -> VB,
    private val viewModelClass:Class<VM>?,
    private val publicViewModelTag:Boolean=false
): Fragment() {

    private val viewModel:VM? by lazy {
        val viewModelProvider = ViewModelProvider(this)
        viewModelClass?.let {
            viewModelProvider[viewModelClass]
        }
    }

    public val publicViewModel:PublicViewModel? by lazy {
        if (publicViewModelTag) {
            ViewModelProvider(requireActivity())[PublicViewModel::class.java]
        } else{
            null
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = inflater(inflater, container, false)
        initFragment(binding, viewModel, savedInstanceState)
        return binding.root
    }

    abstract fun initFragment(
        binding: VB,
        viewModel: VM?,
        savedInstanceState: Bundle?
    )
}




































