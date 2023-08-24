package com.example.mvvmbase.ui.view.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.mvvmbase.R
import com.example.mvvmbase.base.BaseFragment
import com.example.mvvmbase.databinding.FragmentLoginBinding
import com.example.mvvmbase.model.LoginInfo
import com.example.mvvmbase.network.APIResponse
import com.example.mvvmbase.network.RequestBuilder
import com.example.mvvmbase.network.api.User
import com.example.mvvmbase.network.res.BaseResponse
import com.example.mvvmbase.network.res.UserLoginRes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : BaseFragment<FragmentLoginBinding, ViewModel>(
    FragmentLoginBinding::inflate,
    null,
    true,
) {
    override fun initFragment(
        binding: FragmentLoginBinding,
        viewModel: ViewModel?,
        savedInstanceState: Bundle?
    ) {
        binding.loginBtn.setOnClickListener {
//            findNavController().navigate(R.id.action_loginFragment_to_mainNavFragment)
            // 进栈出栈
            // 将MainNavFragment压进来，并将LoginFragment弹出去

            /*findNavController().navigate(
                R.id.mainNavFragment,
                null,
                NavOptions.Builder().setPopUpTo(R.id.loginFragment, true).build()
*/

            /*            RequestBuilder().getAPI(User::class.java).login(LoginInfo("root", "123456"))
                            .enqueue(object : Callback<BaseResponse<UserLoginRes>> {
                                override fun onResponse(
                                    call: Call<BaseResponse<UserLoginRes>>?,
                                    response: Response<BaseResponse<UserLoginRes>>?
                                ) {
                                    response?.let {
                                        if (it.body().data != null) {
                                            Log.i("TAG", "onResponse:${it.body().data.toString()}")
                                        } else {
                                            Toast.makeText(requireContext(), "$it", Toast.LENGTH_SHORT).show()
                                        }
                                    }

                                }

                                override fun onFailure(call: Call<BaseResponse<UserLoginRes>>?, t: Throwable?) {
                                    Log.e("TAG-FAIL", "======> fail")
                                }
                            })*/


            publicViewModel!!.apply {
                getAPI(User::class.java).login(LoginInfo("root", "123456")).getResponse { flow ->
                    flow.collect {
                        when (it) {
                            is APIResponse.Error -> Log.e("TAG", "===========> error:${it.errMsg}")
                            APIResponse.Loading -> Log.w("TAG", "===========> loading")
                            // 主线程更新UI，否则将会被异常（原线程为io线程）
                            is APIResponse.Success -> withContext(Dispatchers.Main) {
                                Toast.makeText(requireContext(), "登录成功", Toast.LENGTH_SHORT).show()
                                Log.e("TAG", "===========> success: ${it.response.data}")
                                findNavController().navigate(R.id.action_loginFragment_to_mainNavFragment)
                            }

                        }
                    }
                }
            }

        }
    }


}