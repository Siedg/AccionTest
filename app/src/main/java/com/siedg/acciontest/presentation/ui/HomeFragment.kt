package com.siedg.acciontest.presentation.ui;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.siedg.acciontest.R
import com.siedg.acciontest.data.model.Image
import com.siedg.acciontest.databinding.FragmentHomeBinding
import com.siedg.acciontest.presentation.dependencyInjection.Injector
import com.siedg.acciontest.presentation.viewmodel.HomeViewModel
import com.siedg.acciontest.presentation.viewmodel.HomeViewModelFactory
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import javax.inject.Inject

class HomeFragment : Fragment(){
    @Inject
    lateinit var factory: HomeViewModelFactory
    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding
    private val groupAdapter = GroupAdapter<ViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as Injector).createHomeSubComponent()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )

        viewModel = ViewModelProvider(this, factory)
            .get(HomeViewModel::class.java)
        val responseLiveData = viewModel.getImages()
        responseLiveData.observe(this.viewLifecycleOwner, Observer {
            it?.let{
                groupAdapter.clear()
                groupAdapter.addAll(it.toRecyclerListItem())
                binding.rvHomeList.adapter = groupAdapter
            }
        })
        return binding.root
    }

    private fun List<Image>.toRecyclerListItem(): List<HomeItem>{
        return this.map { item -> HomeItem(item) }
    }
}