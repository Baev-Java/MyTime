package com.example.mytime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;


public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ProgressBar progr = findViewById(R.id.day);
        FloatingActionButton btn_purpose = findViewById(R.id.btn_purpose);
        Button btnn = findViewById(R.id.buttonnn);
        TextView lastDay = findViewById(R.id.last_day);

        LocalTime current = LocalTime.now();
        long millis = ChronoUnit.MILLIS.between(current, LocalTime.MAX);
        int progres = (int)((millis * 100) / 86400000)*4;
        String hours = String.valueOf((int) (millis / 3600000));
        String minutes = String.valueOf((int) ((millis - (Integer.parseInt(hours) * 3600000)) / 60000));

        String timee = "До конца дня осталось: " + hours + "ч" + ":" + minutes + "мин";
        lastDay.setText(timee);


        lastDay.setText(timee);
        progr.setProgress(progres);


        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BaseActivity.this, AppStatActivity.class);
                startActivity(intent);
            }
        });
    }
}