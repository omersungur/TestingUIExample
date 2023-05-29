package com.omersungur.testinguiexample.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.omersungur.testinguiexample.R
import com.omersungur.testinguiexample.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var fragmentBinding : FragmentFirstBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFirstBinding.bind(view)
        fragmentBinding = binding

        binding.nextButton.setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
    }
}