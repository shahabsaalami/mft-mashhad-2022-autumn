package com.example.myapplication

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myapplication.network.MarsPhoto
import com.example.myapplication.overview.OverviewViewModel


@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }

    }
}

@BindingAdapter("listData")
fun bindRecyclerView(
    recyclerView: RecyclerView,
    data: List<MarsPhoto>?
) {
    recyclerView.let {
        val adapter = recyclerView.adapter as PhotoGridAdapter
        adapter.submitList(data)
    }
}
@BindingAdapter("marsApiStatus")
fun bindStatus(statusImageView: ImageView,
               status: OverviewViewModel.MarsApiStatus?) {
    when (status) {
        OverviewViewModel.MarsApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        OverviewViewModel.MarsApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        OverviewViewModel.MarsApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        else -> {statusImageView.visibility = View.GONE}
    }
}