package com.example.mytime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class BaseActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private FloatingActionButton btn_purpose;
    private RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        btn_purpose = findViewById(R.id.btn_purpose);
        radioButton = findViewById(R.id.btn_completed);

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
    }
}