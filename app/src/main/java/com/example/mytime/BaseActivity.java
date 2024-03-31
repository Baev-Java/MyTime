package com.example.mytime;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;


public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ProgressBar progr = findViewById(R.id.day);

        Button btnn = findViewById(R.id.buttonnn);
        TextView lastDay = findViewById(R.id.last_day);


        LocalTime current = LocalTime.now();
        long millis = ChronoUnit.MILLIS.between(current, LocalTime.MAX);
        int progres = (int) ((millis * 100) / 86400000) * 4;
        String hours = String.valueOf((int) (millis / 3600000));
        String minutes = String.valueOf((int) ((millis - (Integer.parseInt(hours) * 3600000)) / 60000));

        String timee = "До конца дня осталось: " + hours + "ч" + ":" + minutes + "мин";
        lastDay.setText(timee);


        lastDay.setText(timee);
        progr.setProgress(progres);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.sceen_time:
                        startActivity(new Intent(getApplicationContext(),AppStatActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.habit:
                        startActivity(new Intent(getApplicationContext(),HabbitActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),BaseActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.purpose:
                        startActivity(new Intent(getApplicationContext(),PurposeListActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),UserActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });


        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BaseActivity.this, AppStatActivity.class);
                startActivity(intent);
            }
        });


    }

}