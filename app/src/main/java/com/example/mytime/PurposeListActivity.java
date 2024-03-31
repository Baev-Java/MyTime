package com.example.mytime;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PurposeListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purpose_list);
        RecyclerView rv = (RecyclerView) findViewById(R.id.purpose_rv);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        FloatingActionButton add_purpose = findViewById(R.id.btn_purpose);
        bottomNavigationView.setSelectedItemId(R.id.purpose);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.sceen_time:
                        startActivity(new Intent(getApplicationContext(), AppStatActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.habit:
                        startActivity(new Intent(getApplicationContext(), HabbitActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.purpose:
                        startActivity(new Intent(getApplicationContext(), PurposeListActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), BaseActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), UserActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
        add_purpose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PurposeListActivity.this, PurposeActivity.class);
                startActivity(intent);
            }
        });


        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);


    }

}
