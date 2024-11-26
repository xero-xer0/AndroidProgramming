package com.example.day13_01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SubActivity : AppCompatActivity() {
    private lateinit var mBtnGotoHome: Button
    private lateinit var edMsg: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sub)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
        edMsg = findViewById(R.id.edMsg)
        intent.getStringExtra("msg")?.let {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            findViewById<TextView>(R.id.tvMsg).text = it
        }

        mBtnGotoHome = findViewById(R.id.btn_go_home)
        mBtnGotoHome.setOnClickListener {
            val _resultIntent = Intent()
            _resultIntent.putExtra("msg", edMsg.text.toString())
            setResult(RESULT_OK, _resultIntent)
            finish()


        }

    }
}