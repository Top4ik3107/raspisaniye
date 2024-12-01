package com.example.raspisaniye;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class addgroup extends AppCompatActivity {
    private SharedPreferences pref;
    private String gj2, y;
    private Integer h;
    private FrameLayout fy1, fy2, fy3, fy4;
    FirebaseFirestore firestore;String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.addgroup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        pref = getSharedPreferences("data", MODE_PRIVATE);
        fy1 = findViewById(R.id.f1);
        fy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Действие при нажатии
                EditText editText = findViewById(R.id.editTextText9);

                text = editText.getText().toString();
                String name = pref.getString("name","умпа лумпа ча ча ча");

                DocumentReference ps = firestore.collection("College").document(name).collection("Year").document(y);

                ps.collection("group").document(text).set(new HashMap<>());

            }
        });
    }

    public void Add(View view) {
        pref = getSharedPreferences("data", MODE_PRIVATE);
        fy1 = findViewById(R.id.f1);
        EditText editText = findViewById(R.id.editTextText9);

        text = editText.getText().toString();
        String name = pref.getString("name","умпа лумпа ча ча ча");

        DocumentReference ps = firestore.collection("College").document(name).collection("Year").document(y);

        ps.collection("group").document(text).set(new HashMap<>());
    }

    public void exit(View view) {
    }
}