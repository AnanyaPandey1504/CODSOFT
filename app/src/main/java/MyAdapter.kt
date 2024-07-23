package com.example.mathquizapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class MyAdapter(private val datSet:ArrayList<Question>):
RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val Problem:TextView=view.findViewById(R.id.Question)
        val option1:TextView=view.findViewById(R.id.option1)
        val option2:TextView=view.findViewById(R.id.option2)
        val option3:TextView=view.findViewById(R.id.option3)
        val option4:TextView=view.findViewById(R.id.option4)
        val yourAnswer:TextView=view.findViewById(R.id.yourAnswer)
        val correctAnswer:TextView=view.findViewById(R.id.correctAnswer)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view=LayoutInflater.from(parent.context)
           .inflate(R.layout.item_questions,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datSet.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.Problem.text=datSet[position].problem
        holder.option1.text=datSet[position].option1
        holder.option2.text=datSet[position].option2
        holder.option3.text=datSet[position].option3
        holder.option4.text=datSet[position].option4
        holder.yourAnswer.text="YOUR ANSWER:${datSet[position].selectedOption}"
        holder.correctAnswer.text="CORRECT ANSWER:${datSet[position].answer}"
    }
}


