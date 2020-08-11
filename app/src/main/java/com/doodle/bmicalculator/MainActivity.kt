package com.doodle.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceManager

import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()

        result_Button.setOnClickListener{

            if (height_EditText.text.toString().equals("")) {
                height_EditText.setText("0")
            }

            if (weight_EditText.text.toString().equals("")) {
                weight_EditText.setText("0")
            }

            saveData(height_EditText.text.toString().toInt(),
                weight_EditText.text.toString().toInt())
            startActivity<ResultActivity>(
                "weight" to weight_EditText.text.toString(),
                "height" to height_EditText.text.toString()
            )

        }
    }

    private fun saveData(height:Int, weight:Int) {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()

        editor.putInt("KEY_HEIGHT", height)
        editor.putInt("KEY_WEIGHT", weight)
            .apply()
    }

    private fun loadData() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val height = pref.getInt("KEY_HEIGHT", 0)
        val weight = pref.getInt("KEY_WEIGHT", 0)

        if (height != 0 && weight != 0) {
            height_EditText.setText(height.toString())
            weight_EditText.setText(weight.toString())
        }
    }
}
