package com.example.mytime;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class PurposeActivity extends AppCompatActivity {
    Map<String, Object> data = new HashMap<>();
    private FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] countries = {"Бразилия", "Аргентина", "Колумбия", "Чили", "Уругвай"};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purpose);
        db = FirebaseFirestore.getInstance();

        TextView selection = findViewById(R.id.selection);
        TextView purpose_name = findViewById(R.id.enter_name_purpose);
        TextView purpose_desc = findViewById(R.id.enter_desc_purpose);
        Spinner spinner = findViewById(R.id.spinner);

        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект
                String item = (String) parent.getItemAtPosition(position);
                selection.setText(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);
    }


    private void addPurpose() {
        // Создание мапы с данными для добавления

        data.put("name", "John");
        data.put("age", 25);

// Добавление документа в коллекцию "users"
        db.collection("users")
                .add(data)
                .addOnSuccessListener(documentReference -> {
                    // Успешно добавлено
                    Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> {
                    // Ошибка при добавлении
                    Toast.makeText(this, "fuck", Toast.LENGTH_SHORT).show();
                });

    }


}