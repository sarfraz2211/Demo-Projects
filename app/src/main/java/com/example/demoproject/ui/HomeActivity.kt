package com.example.demoproject.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject.R
import com.example.demoproject.adapters.HomeAdapter
import com.example.demoproject.controler.PageIndicatorDecoration
import com.example.demoproject.databinding.HomeActivityBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: HomeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val horizontalRecyclerView = findViewById<RecyclerView>(R.id.recyclerViewHorizontal)
        //val verticalRecyclerView = findViewById<RecyclerView>(R.id.recyclerViewVertical)

        binding.recyclerViewHorizontal.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewVertical.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val sampleData = listOf("Item 1", "Item 2", "Item 3") // Sample data for demo

        // Set adapters for horizontal and vertical RecyclerViews
        binding.recyclerViewHorizontal.adapter = HomeAdapter(sampleData, { item ->
            // Handle item click
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("item", item)
            startActivity(intent)
        }, isHorizontal = true)
        binding.recyclerViewHorizontal.addItemDecoration(PageIndicatorDecoration(this))

        binding.recyclerViewVertical.adapter = HomeAdapter(sampleData, { item ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("item", item)
            startActivity(intent)
        }, isHorizontal = false)
    }
}
