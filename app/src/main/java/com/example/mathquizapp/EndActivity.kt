package com.example.mathquizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.color.utilities.Score

@Suppress("UNCHECKED_CAST")
class EndActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        val score = intent.getIntExtra("score", 0)
        val data: ArrayList<Question> =
            intent.getSerializableExtra("dataSet") as ArrayList<Question>

        val tvScore: TextView = findViewById(R.id.tvScore)
        tvScore.text = "FINAL SCORE\n$score/10"

        setAdapterRecyclerView(data)

        val btnHome:Button=findViewById(R.id.btnHome)
        btnHome.setOnClickListener { finish() }

    }

    private fun setAdapterRecyclerView(data:ArrayList<Question>){
        val recyclerView:RecyclerView=findViewById(R.id.rvQuestionList)
        recyclerView.layoutManager=LinearLayoutManager(this)
        val adapter=MyAdapter(data)
        recyclerView.adapter=adapter
    }

}
