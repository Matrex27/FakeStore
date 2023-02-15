package com.example.fakestore.MainModule.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.fakestore.R
import com.example.fakestore.common.entities.ProductEntity
import com.example.fakestore.databinding.ItemProductBinding

class ProductsAdapter: ListAdapter<ProductEntity, RecyclerView.ViewHolder>(productDiffCallBack()) {

    private lateinit var mContext: Context

    inner class viewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemProductBinding.bind(view)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mContext = parent.context

        val view = LayoutInflater.from(mContext).inflate(R.layout.item_product, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        var product = getItem(position)

        with(holder as viewHolder){
            binding.tvTitle.text = product.title
            binding.tvDescription.text = product.description
            binding.tvPrice.text= "$${product.price.toString()}"

            Glide.with(mContext)
                .load(product.images[0])
                //.centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.img1)

            Glide.with(mContext)
                .load(product.images[1])
                //.centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.img2)

            Glide.with(mContext)
                .load(product.images[2])
                //.centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.img3)
        }

    }


    class productDiffCallBack: DiffUtil.ItemCallback<ProductEntity>(){
        override fun areItemsTheSame(oldItem: ProductEntity, newItem: ProductEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductEntity, newItem: ProductEntity): Boolean {
            return oldItem == newItem
        }


    }

}