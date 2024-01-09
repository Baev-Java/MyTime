package com.example.mytime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class BaseActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private FloatingActionButton btn_purpose;
    private RadioButton radioButton;
    private Button btnn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        btn_purpose = findViewById(R.id.btn_purpose);
        radioButton = findViewById(R.id.btn_completed);
        btnn = findViewById(R.id.buttonnn);

        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BaseActivity.this, "click", Toast.LENGTH_SHORT).show();
            }
        });

        btn_purpose.setOnClickListener(new View.OnClickListener() {//обработчик кнопки создания цели
            @Override
            public void onClick(View view) {
                // Создание мапы с данными для добавления
                Intent intent = new Intent(BaseActivity.this, PurposeActivity.class);
                startActivity(intent);
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