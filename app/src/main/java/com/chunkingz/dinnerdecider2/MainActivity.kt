package com.chunkingz.dinnerdecider2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chunkingz.dinnerdecider2.databinding.ActivityMainBinding
//import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val defaultFoodList = arrayListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")
    private val userAddedFoods = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handleUserEvents()
    }

    private fun handleUserEvents(){

        binding.ddFoodText.text = defaultFoodList[0]

        binding.ddAddFoodButton.setOnClickListener {
            val newFood = binding.ddFoodInput.text.toString()
            if (newFood.isNotEmpty()) {
                defaultFoodList.add(newFood)
                binding.ddFoodInput.text.clear()
            }
        }

        binding.ddDecideButton.setOnClickListener {
            val randomFoodIndex = Random.nextInt(defaultFoodList.size)
            binding.ddFoodText.text = defaultFoodList[randomFoodIndex]
        }
    }
}