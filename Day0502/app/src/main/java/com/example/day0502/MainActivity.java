package com.example.day0502;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2, tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tv1 = findViewById(R.id.frame1);
        tv2 = findViewById(R.id.frame2);
        tv3 = findViewById(R.id.frame3);


        tv1.setVisibility(View.INVISIBLE);
        tv2.setVisibility(View.INVISIBLE);
        tv3.setVisibility(View.INVISIBLE);

        findViewById(R.id.btnFrame1).setOnClickListener(v -> {
            tv1.setVisibility(View.VISIBLE);
            tv2.setVisibility(View.INVISIBLE);
            tv3.setVisibility(View.INVISIBLE);

        });
        findViewById(R.id.btnFrame2).setOnClickListener(v -> {
            tv1.setVisibility(View.INVISIBLE);
            tv2.setVisibility(View.VISIBLE);
            tv3.setVisibility(View.INVISIBLE);

        });
        findViewById(R.id.btnFrame3).setOnClickListener(v -> {
            tv1.setVisibility(View.INVISIBLE);
            tv2.setVisibility(View.INVISIBLE);
            tv3.setVisibility(View.VISIBLE);
        });
    }
}