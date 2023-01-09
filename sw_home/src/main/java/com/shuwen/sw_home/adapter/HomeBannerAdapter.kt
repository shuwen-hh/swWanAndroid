package com.shuwen.sw_home.adapter

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.shuwen.sw_home.bean.Banner
import com.youth.banner.adapter.BannerAdapter

/**
 * created by shuwen on 1/2/23
 */
class HomeBannerAdapter(bannerList: List<Banner>) : BannerAdapter<Banner, HomeBannerAdapter.BannerViewHolder>(bannerList) {

    class BannerViewHolder(view: ImageView) : RecyclerView.ViewHolder(view) {
        var imageView: ImageView
        init {
            imageView = view
        }
    }

    override fun onBindView(
        holder: BannerViewHolder,
        data: Banner,
        position: Int,
        size: Int
    ) {
        Glide.with(holder.itemView)
            .load(data.imagePath)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
            .into(holder.imageView)
    }

    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): BannerViewHolder {
        val imageView = ImageView(parent!!.context)
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        imageView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        return BannerViewHolder(imageView)
    }
}