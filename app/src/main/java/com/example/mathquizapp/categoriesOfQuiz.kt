package com.example.mathquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mathquizapp.databinding.ActivityCategoriesOfQuizBinding

class categoriesOfQuiz : AppCompatActivity() {
    private var binding:ActivityCategoriesOfQuizBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCategoriesOfQuizBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnEasy?.setOnClickListener { startGame("easy") }
        binding?.btnMedium?.setOnClickListener { startGame("medium") }
        binding?.btnHard?.setOnClickListener { startGame("hard") }
    }


    private fun startGame(questionType:String){
        val intent=Intent(this,playQuiz::class.java)
        intent.putExtra("questionType",questionType)
        startActivity(intent)
    }
}