package com.doodle.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*
import org.jetbrains.anko.toast

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //전달받은값
        val height = intent.getStringExtra("height").toInt()
        val weight = intent.getStringExtra("weight").toInt()

        //BMI계산
        val bmi = weight / Math.pow(height/ 100.0, 2.0)

        //결과표시
        when {
            bmi >= 35 -> result_TextView.text = "고도비만"
            bmi >= 30 -> result_TextView.text = "2단계 비만"
            bmi >= 25 -> result_TextView.text = "1단계 비만"
            bmi >= 23 -> result_TextView.text = "과체중"
            bmi >= 18.5 -> result_TextView.text = "정상"
            else -> result_TextView.text = "저체중"
        }

        //이미지 표시
        when {
            bmi >= 23 ->
                imageView.setImageResource(
                    R.drawable.ic_sentiment_very_dissatisfied_black_24dp)

            bmi >= 18.5 ->
                imageView.setImageResource(
                    R.drawable.ic_mood_black_24dp)

            else ->
                imageView.setImageResource(
                    R.drawable.ic_mood_bad_black_24dp)
        }
        toast("$bmi")
    }


}
