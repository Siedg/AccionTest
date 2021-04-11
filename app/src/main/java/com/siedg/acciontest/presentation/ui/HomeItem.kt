package com.siedg.acciontest.presentation.ui

import com.bumptech.glide.request.RequestOptions
import com.siedg.acciontest.R
import com.siedg.acciontest.data.model.Image
import com.xwray.groupie.databinding.BindableItem
import com.siedg.acciontest.databinding.HomeItemBinding
import com.siedg.acciontest.loadWithURL

class HomeItem(private val image: Image) : BindableItem<HomeItemBinding>() {
    override fun getLayout(): Int = R.layout.home_item

    override fun bind(viewBinding: HomeItemBinding, position: Int) {
        viewBinding.apply {
            ivHomeItem.loadWithURL(
                image.link,
                RequestOptions()
                    .placeholder(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
        }
    }
}