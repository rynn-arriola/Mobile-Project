package com.example.mobileapplicationproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mobileapplicationproject.R
import com.example.mobileapplicationproject.databinding.FragmentHomePageBinding

class HomePageFragment : Fragment() {

    private var _binding: FragmentHomePageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentHomePageBinding.inflate(inflater, container, false).also {
        _binding = it

    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle()
        onButtonClicked()

    }

    private fun onButtonClicked() {
        binding.btnShowList.setOnClickListener {
            val action = HomePageFragmentDirections.actionHomePageToEmployeesFragment()
            findNavController().navigate(action)
        }
    }

    private fun setTitle() {
        val actionBar = (requireActivity() as AppCompatActivity).supportActionBar
        actionBar?.title = getString(R.string.home_page_title)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
