package com.ir.mydiet.extensions

import android.content.Context
import android.widget.ImageView
import com.sana.appinterview.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

/**
 * Created by Masoud Ashrafzadeh on 2017/11/10.
 */

fun ImageView.loadImageWithGlide(context: Context, url: String) {

    var options = RequestOptions().apply {
        diskCacheStrategy(DiskCacheStrategy.ALL)
        centerCrop()


    }

    Glide.with(context)
            .applyDefaultRequestOptions(options)
            .load(url)
            .into(this)
}

fun ImageView.loadImageWithGlideLand(context: Context, url: String) {

    var options = RequestOptions().apply {
        diskCacheStrategy(DiskCacheStrategy.ALL)
        centerCrop()


    }

    Glide.with(context)
            .applyDefaultRequestOptions(options)
            .load(url)
            .into(this)
}

fun ImageView.loadImageWithGlideNoCrop(context: Context, url: String) {
    var options = RequestOptions().apply {
        diskCacheStrategy(DiskCacheStrategy.ALL)

    }
    Glide.with(context)
            .applyDefaultRequestOptions(options)
            .load(url)

            .into(this)
}
fun ImageView.loadImageWithGlideFit(context: Context, url: String) {
    var options = RequestOptions().apply {
        diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()

    }
    Glide.with(context)
            .applyDefaultRequestOptions(options)
            .load(url)

            .into(this)
}
