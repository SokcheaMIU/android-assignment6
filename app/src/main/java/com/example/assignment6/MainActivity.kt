package com.example.assignment6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quizBnt.setOnClickListener(this)
        foodAppBnt.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        var intent: Intent? = null
        if (view == quizBnt) {
            intent = Intent(this, QuizActivity::class.java)
        } else if (view == foodAppBnt) {
            intent = Intent(this, FoodAppActivity::class.java)
        }

        intent?.let {
            startActivity(it)
        }
    }
}