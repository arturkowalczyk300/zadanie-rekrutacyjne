package com.arturkowalczyk300.zadanierekrutacyjne.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.arturkowalczyk300.zadanierekrutacyjne.R
import com.arturkowalczyk300.zadanierekrutacyjne.ViewModel.UsersViewModel

class DataFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: UsersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.recyclerView)
        initViewModel()
        updateData()
        observeData()

        super.onViewCreated(view, savedInstanceState)
    }

    private fun initViewModel() {
        viewModel =
            ViewModelProvider(requireActivity()).get(UsersViewModel::class.java)
    }

    private fun observeData(){
            viewModel.getAllUsers()?.observe(requireActivity()){
                recyclerView.adapter = UsersAdapter(it)
        }
    }

    private fun updateData() {
        viewModel.updateGithubUsers()
        viewModel.updateDailymotionUsers()
    }
}