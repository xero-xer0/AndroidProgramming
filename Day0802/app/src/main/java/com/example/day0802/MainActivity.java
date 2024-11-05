package com.example.day0802;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        ImageView image_meat, image_cheese;

        image_meat = findViewById(R.id.image_meat);
        image_cheese = findViewById(R.id.image_cheese);
        image_meat.setVisibility(View.INVISIBLE);
        image_cheese.setVisibility(View.INVISIBLE);

        CheckBox _checkMeat = findViewById(R.id.check_meat);

        findViewById(R.id.check_meat).setOnClickListener((chbkbtn, isChecked) -> {

            Boolean isChecked = _checkMeat.isChecked();


            if (isChecked) {
                image_meat.setVisibility(View.VISIBLE);
            } else {
                image_meat.setVisibility(View.INVISIBLE);
            }
        });
    }
}