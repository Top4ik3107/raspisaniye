package com.example.raspisaniye;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class adminpanelCollege extends AppCompatActivity {
    EditText editTextText, editTextText2;
    private FirebaseFirestore firestore;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adminpanel_college);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextText = findViewById(R.id.editTextText);
        editTextText2 = findViewById(R.id.editTextText2);
        firestore = FirebaseFirestore.getInstance();
        pref = getSharedPreferences("data", MODE_PRIVATE);
    }

    public void GoToSing(View view) {
        String login = editTextText.getText().toString();
        String password = editTextText2.getText().toString();

        if (login.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show();
        } else {
            DocumentReference ps = firestore.collection("College").document(login).collection("data").document("personal");
            ps.get().addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document != null && document.exists()) {
                        String passwordImport = document.getString("password");
                        if (passwordImport != null && password.equals(passwordImport)) {
                            Intent intent = new Intent(this, adminpanelRazdelenie.class);
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("college", login);
                            editor.apply();
                            startActivity(intent);
                        } else {
                            Toast.makeText(this, "Неверный логин или пароль", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Документ не найден", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Ошибка при выполнении запроса: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public void GoToCreate(View view) {
        Intent intent = new Intent(this, adminpanel_create.class);
        startActivity(intent);
    }
}