package com.example.mathquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.mathquizapp.databinding.ActivityPlayQuizBinding
import java.lang.StackWalker.Option



class playQuiz : AppCompatActivity() {
    var binding: ActivityPlayQuizBinding? = null

    private var position = 0
    private var score = 0
    var questionDataList = ArrayList<Question>(10)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayQuizBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val questionType = intent.getStringExtra("questionType")
        questionDataList = questionList(questionType).getQuestionList()
        updateQuestion()
        updateOption()
        updateHorizontalProgressBar()

        binding?.option1?.setOnClickListener {
            onSelectOption(binding?.option1?.text.toString())
        }
        binding?.option2?.setOnClickListener {
            onSelectOption(binding?.option2?.text.toString())
        }
        binding?.option3?.setOnClickListener {
            onSelectOption(binding?.option3?.text.toString())
        }
        binding?.option4?.setOnClickListener {
            onSelectOption(binding?.option4?.text.toString())
        }
    }

    private fun updateOption() {
        binding?.option1?.text = questionDataList[position].option1
        binding?.option2?.text = questionDataList[position].option2
        binding?.option3?.text = questionDataList[position].option3
        binding?.option4?.text = questionDataList[position].option4
    }

    private fun updateHorizontalProgressBar() {
        binding?.horizontalProgressBar?.incrementProgressBy(1)
    }


   private fun updateQuestion(){
       binding?.Question?.text=questionDataList[position].problem
   }


    private fun onSelectOption(option:String){
        if(option==questionDataList[position].answer)
            score++
        questionDataList[position].selectedOption=option
        setNextRound()
    }

    private fun setNextRound(){
        if(position<9){
            position++
            updateQuestion()
            updateOption()
            updateHorizontalProgressBar()
        }
        else
            endGame()
    }
    private fun endGame(){

        val intent= Intent(this,EndActivity::class.java)
        intent.putExtra("Score", score)
        intent.putExtra("DataSet",questionDataList)
        finish()
        binding=null
    }

}



