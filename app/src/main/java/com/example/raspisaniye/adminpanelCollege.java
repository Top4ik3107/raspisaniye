package com.example.raspisaniye;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class adminpanelCollege extends AppCompatActivity {
    EditText editTextText, editTextText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adminpanel_college);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;});

        editTextText = findViewById(R.id.editTextText);
        editTextText2 = findViewById(R.id.editTextText2);
    }

    public void GoToSing(View view) {

        Intent intent = new Intent(this, adminpanel3.class);


    }

    public void GoToCreate(View view) {
        Intent intent = new Intent(this, adminpanel_create.class);
        startActivity(intent);

    }
}