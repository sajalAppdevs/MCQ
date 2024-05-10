package com.sajal.mcq

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.sajal.mcq.R

class MainActivity : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var answerRadioGroup: RadioGroup
    private lateinit var option1RadioButton: RadioButton
    private lateinit var option2RadioButton: RadioButton
    private lateinit var submitButton: Button

    private val questions = listOf(
        "What is the capital of France?",
        "What is the largest planet in our solar system?"
    )

    private val correctAnswers = listOf(
        "Paris",
        "Jupiter"
    )

    private var currentQuestionIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionTextView = findViewById(R.id.questionTextView)
        answerRadioGroup = findViewById(R.id.answerRadioGroup)
        option1RadioButton = findViewById(R.id.option1RadioButton)
        option2RadioButton = findViewById(R.id.option2RadioButton)
        submitButton = findViewById(R.id.submitButton)

        displayQuestion()

        submitButton.setOnClickListener {
            checkAnswer()
        }
    }

    private fun displayQuestion() {
        if (currentQuestionIndex < questions.size) {
            questionTextView.text = questions[currentQuestionIndex]
            option1RadioButton.text = "Option A" // Replace with your options
            option2RadioButton.text = "Option B" // Replace with your options
            answerRadioGroup.clearCheck()
        } else {
            questionTextView.text = "Quiz completed!"
            answerRadioGroup.visibility = RadioGroup.GONE
            submitButton.isEnabled = false
        }
    }

    private fun checkAnswer() {
        val selectedRadioButtonId = answerRadioGroup.checkedRadioButtonId

        if (selectedRadioButtonId != -1) {
            val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
            val selectedAnswer = selectedRadioButton.text.toString()

            val correctAnswer = correctAnswers[currentQuestionIndex]

            if (selectedAnswer == correctAnswer) {
                // Correct answer
            } else {
                // Incorrect answer
            }

            currentQuestionIndex++
            displayQuestion()
        }
    }
}
