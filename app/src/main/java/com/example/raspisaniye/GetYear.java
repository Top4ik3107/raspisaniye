package com.example.raspisaniye;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GetYear extends AppCompatActivity {
    private SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_get_year);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        pref = getSharedPreferences("data",MODE_PRIVATE);
    }

    public void Add1(View view) {
        pref.edit().putString("syear","Year1").apply();
    }

    public void Add2(View view) {
        pref.edit().putString("syear","Year2").apply();
    }

    public void Add3(View view) {
        pref.edit().putString("syear","Year3").apply();
    }

    public void Add4(View view) {
        pref.edit().putString("syear","Year4").apply();
    }
}