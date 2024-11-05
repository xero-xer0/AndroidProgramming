package com.example.surveyapp

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val gingerbreadImage = findViewById<ImageView>(R.id.GingerbreadImage)
        val jellyBeanImage = findViewById<ImageView>(R.id.JellyBeanImage)
        val kitKatImage = findViewById<ImageView>(R.id.KitKatImage)

        // 초기에는 모든 이미지를 숨깁니다
        gingerbreadImage.visibility = View.GONE
        jellyBeanImage.visibility = View.GONE
        kitKatImage.visibility = View.GONE

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            // 모든 이미지를 숨깁니다
            gingerbreadImage.visibility = View.GONE
            jellyBeanImage.visibility = View.GONE
            kitKatImage.visibility = View.GONE

            // 선택된 RadioButton에 따라 이미지 표시
            when (checkedId) {
                R.id.Gingerbread -> gingerbreadImage.visibility = View.VISIBLE
                R.id.JellyBean -> jellyBeanImage.visibility = View.VISIBLE
                R.id.KitKat -> kitKatImage.visibility = View.VISIBLE
            }

            val imageToggleButton = findViewById<Button>(R.id.ImageToggleButton)
                imageToggleButton.setOnClickListener {
                    // 이미지를 숨기거나 표시합니다
                    if (gingerbreadImage.visibility == View.VISIBLE) {
                        gingerbreadImage.visibility = View.GONE
                    } else if (jellyBeanImage.visibility == View.VISIBLE) {
                        jellyBeanImage.visibility = View.GONE
                    } else if (kitKatImage.visibility == View.VISIBLE) {
                        kitKatImage.visibility = View.GONE
                    } else {
                        when (radioGroup.checkedRadioButtonId) {
                            R.id.Gingerbread -> gingerbreadImage.visibility = View.VISIBLE
                            R.id.JellyBean -> jellyBeanImage.visibility = View.VISIBLE
                            R.id.KitKat -> kitKatImage.visibility = View.VISIBLE
                    }
                }
            }
        }
    }
}
