package com.siedg.acciontest.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadWithURL(url: String, requestOptions: RequestOptions? = null){
    Glide.with(this).load(url).apply {
        requestOptions?.let {
            apply(it).transition(DrawableTransitionOptions.withCrossFade())
        }
    }.into(this)
}