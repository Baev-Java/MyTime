package com.example.mytime;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class PurposeActivity extends AppCompatActivity {

    FirebaseFirestore db;
    private EditText purpose_name;

    private EditText purpose_desc;
    private EditText measure_purpose;
    private EditText enter_cost_purpose;
    private ImageButton imageButton;
    private AppCompatButton purp_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purpose);
        purpose_name = findViewById(R.id.enter_name_purpose);
        purpose_desc = findViewById(R.id.enter_desc_purpose);
        measure_purpose = findViewById(R.id.measure_purpose);
        enter_cost_purpose = findViewById(R.id.enter_cost_purpose);
        imageButton = findViewById(R.id.imageButton2);
        purp_btn = findViewById(R.id.btn_add_purp);

        db = FirebaseFirestore.getInstance();


// Добавление документа в коллекцию "users"


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        purp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPurpose();
            }
        });

    }


    private void addPurpose() {
        String name_purp, desc_purp;
        int purp_meas, cost_purpose;
        name_purp = purpose_name.getText().toString();
        desc_purp = purpose_desc.getText().toString();
        cost_purpose = Integer.parseInt(enter_cost_purpose.getText().toString());
        purp_meas = Integer.parseInt(measure_purpose.getText().toString());


        // Создание мапы с данными для добавления
        String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Map<String, Object> purpose_data = new HashMap<>();

        purpose_data.put("NamePurpose", name_purp);
        purpose_data.put("DescPurpose", desc_purp);
        purpose_data.put("MeasurePurpose", purp_meas);
        purpose_data.put("CostPurpose", cost_purpose);
        //purpose_data.put("CostPurpose", cost);
        db.collection("users")
                .document(currentuser)
                .collection("users_data").document(name_purp).set(purpose_data);


    }
}