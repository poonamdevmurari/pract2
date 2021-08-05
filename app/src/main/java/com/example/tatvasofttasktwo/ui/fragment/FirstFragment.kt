package com.example.tatvasofttasktwo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.example.tatvasofttasktwo.data.network.RetrofitService
import com.example.tatvasofttasktwo.data.repository.UserRepository
import com.example.tatvasofttasktwo.databinding.FragmentFirstBinding
import com.example.tatvasofttasktwo.ui.adapter.UserAdapter
import com.example.tatvasofttasktwo.ui.viewmodel.UserViewModel
import com.example.tatvasofttasktwo.ui.viewmodel.UserViewModelFactory

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var viewModel : UserViewModel
    private val retrofitService = RetrofitService.getInstance()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity(), UserViewModelFactory(UserRepository(retrofitService))).get(UserViewModel::class.java)


        viewModel.userList.observe(requireActivity(), Observer {
            binding.recycleView.adapter = it.data?.toMutableList()?.let { it1 -> UserAdapter(it1) }
        })
        viewModel.errorMessage.observe(requireActivity(), Observer {

        })
        viewModel.getUserList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}