package com.example.mathquizapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class MyAdapter(private val datSet:ArrayList<Question>):
RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val tvProblem:TextView=view.findViewById(R.id.rvTvProblem)
        val option1:TextView=view.findViewById(R.id.rvTvOption1)
        val option2:TextView=view.findViewById(R.id.rvTvOption2)
        val option3:TextView=view.findViewById(R.id.rvTvOption3)
        val option4:TextView=view.findViewById(R.id.rvTvOption4)
        val selectedAnswer:TextView=view.findViewById(R.id.selectedAnswer)
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
       holder.tvProblem.text=datSet[position].problem
        holder.option1.text=datSet[position].option1
        holder.option2.text=datSet[position].option2
        holder.option3.text=datSet[position].option3
        holder.option4.text=datSet[position].option4
        holder.selectedAnswer.text="YOUR ANSWER:${datSet[position].selectedOption}"
        holder.correctAnswer.text="CORRECT ANSWER:${datSet[position].answer}"

        if(position%2 != 0){
            holder.itemView.setBackgroundColor(Color.parseColor("#000000"))
        }
        else{
            holder.itemView.setBackgroundColor(Color.parseColor("#3c3f41"))
        }
    }
}


