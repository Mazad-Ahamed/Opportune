package com.example.opportune.UI_Design

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.opportune.R
import com.example.opportune.databinding.FragmentAddjobsBinding
import com.example.opportune.databinding.FragmentBookmarkBinding

class AddjobsFragment : Fragment() {
    private lateinit var binding : FragmentAddjobsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddjobsBinding.inflate(inflater, container, false)
        return binding.root  }


}