package com.example.day11_02;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder alertDlg; // 선언 추가

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
        LinearLayout main = findViewById(R.id.main);

        Button btnPopupMenu = findViewById(R.id.btnPopupMenu);

        btnPopupMenu.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(this, v);
            popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(item -> {
                int id = item.getItemId(); // 대소문자 수정

                if (id == R.id.red) {
                    Toast.makeText(this, "Red", Toast.LENGTH_SHORT).show();
                    main.setBackgroundColor(Color.RED);
                } else if (id == R.id.blue) {
                    Toast.makeText(this, "Blue", Toast.LENGTH_SHORT).show();
                    main.setBackgroundColor(Color.BLUE);

                } else if (id == R.id.green) {
                    Toast.makeText(this, "Green", Toast.LENGTH_SHORT).show();
                    main.setBackgroundColor(Color.GREEN);

                }

                return false;
            });

            popupMenu.show(); // 위치 수정
        });
        TextView txtOutput = findViewById(R.id.txtOutput);
        Button BtnDate = findViewById(R.id.btnDateDlg);
        BtnDate.setOnClickListener(v -> {
            DatePickerDialog dateDlg = new DatePickerDialog(this);
            dateDlg.setOnDateSetListener((_v, year, month, dayOfMonth) -> {
                txtOutput.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
            });
            dateDlg.show();
        });

        Button btnTime = findViewById(R.id.btnTimeDlg);
btnTime.setOnClickListener(v -> {
    TimePickerDialog timeDlg = new TimePickerDialog(this, (view, hourOfDay, minute) -> {
        txtOutput.setText(hourOfDay + ":" + minute);
    }, 0, 0, false);
    timeDlg.show();
});

        alertDlg = new AlertDialog.Builder(this); // alertDlg 초기화 추가
        Button btnAlert = findViewById(R.id.btnAlert);
        btnAlert.setOnClickListener(v -> {
            alertDlg.setTitle("뷁궯둞쉛뤻");
            alertDlg.setMessage("뷁뷁뷁?");
            alertDlg.setPositiveButton("긝뷁괅", (dlg, which) -> {
                Toast.makeText(this, "확인 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
            });
            alertDlg.setNegativeButton("봙궭긝", (dlg, which) -> {
                Toast.makeText(this, "취소 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
            });
            alertDlg.show();
        });

    }
}