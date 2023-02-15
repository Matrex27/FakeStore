package com.example.fakestore.MainModule.mainView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fakestore.MainModule.adapters.ProductsAdapter
import com.example.fakestore.MainModule.mainViewModel.MainViewModel
import com.example.fakestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //ViewModel
    private lateinit var mainViewModel: MainViewModel

    //Adapter
    private lateinit var mAdapter: ProductsAdapter
    private lateinit var mLayoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setUpViewModel()
        setUpRecyclerView()
    }

    private fun setUpViewModel(){

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainViewModel.getAllProducts()

        mainViewModel.getResult().observe(this){

            mAdapter.submitList(it)
        }

    }


    private fun setUpRecyclerView(){
        mAdapter = ProductsAdapter()
        mLayoutManager = GridLayoutManager(this, 1)

        binding.productsRecyclerView.apply {
            setHasFixedSize(true)
            adapter = mAdapter
            layoutManager = mLayoutManager

        }
    }


}