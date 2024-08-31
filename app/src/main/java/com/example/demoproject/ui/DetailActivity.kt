package com.example.demoproject.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoproject.adapters.HomeAdapter
import com.example.demoproject.databinding.ActivityDetailBinding
import com.example.demoproject.databinding.HomeActivityBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerViewHorizontal.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val sampleData = listOf("Item 1", "Item 2", "Item 3") // Sample data for demo
        // Set adapters for horizontal and vertical RecyclerViews
        binding.recyclerViewHorizontal.adapter = HomeAdapter(sampleData, { item ->
            // Handle item click
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("item", item)
            startActivity(intent)
        }, isHorizontal = true)

        binding.appBack.setOnClickListener {
            onBackPressed()
        }
    }

}