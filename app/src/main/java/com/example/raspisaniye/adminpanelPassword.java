package com.example.raspisaniye;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class adminpanelPassword extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adminpanel_password);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        editText = findViewById(R.id.editTextTextPassword2);

    }

    public void GoToAdmRaz(View view) {
        String password = editText.getText().toString();
        if (password.equals("admin")) {
            Intent intent = new Intent(this, adminpanelRazdelenie.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Неправильный пароль", Toast.LENGTH_SHORT).show();
        }

    }
}