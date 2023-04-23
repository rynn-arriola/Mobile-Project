package com.example.mobileapplicationproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mobileapplicationproject.R
import com.example.mobileapplicationproject.adapter.EmployeeAdapter
import com.example.mobileapplicationproject.databinding.FragmentEmployeesBinding
import com.example.mobileapplicationproject.util.State
import com.example.mobileapplicationproject.viewmodel.EmployeesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EmployeesFragment : Fragment() {

    private var _binding: FragmentEmployeesBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<EmployeesViewModel>()
    private val adapter by lazy { EmployeeAdapter() }

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentEmployeesBinding.inflate(inflater, container, false).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle()
        viewModel.fetChData()
        initViews()
        initObservers()
    }

    private fun initViews() {
        binding.rvEmployee.adapter = adapter
    }

    private fun initObservers() = with(viewModel) {
        state.observe(viewLifecycleOwner) { state ->
            if (state is State.Success) {
                hideProgressBar()
                val sortedEmployee = viewModel.sortEmployeesAlphabetical(state.data.employees)
                adapter.submitList(sortedEmployee)
            }
            if (state is State.Error) {
                hideProgressBar()
                handleError(state.errorMessage)
            }
            if (state is State.Loading) {
                showProgressBar()
            }

        }
    }

    private fun setTitle() {
        val actionBar = (requireActivity() as AppCompatActivity).supportActionBar
        actionBar?.title = getString(R.string.employees_page_title)
    }

    private fun handleError(exception: String) {
        binding.errorLayout.visibility = View.VISIBLE
        binding.errorDetails.text = exception
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}