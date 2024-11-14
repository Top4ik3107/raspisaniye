package com.example.raspisaniye;

import static java.lang.reflect.Array.set;

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

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class adminpanel_create extends AppCompatActivity {
    EditText editTextText, editTextText2, editTextText3, editTextText4, editTextText5;
    FirebaseFirestore firestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adminpanel_create);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        firestore = FirebaseFirestore.getInstance();
        editTextText = findViewById(R.id.editTextText);
        editTextText2 = findViewById(R.id.editTextText2);
        editTextText3 = findViewById(R.id.editTextText3);
        editTextText4 = findViewById(R.id.editTextText4);
        editTextText5 = findViewById(R.id.editTextText5);

    }
    public void Addcollege(View view) {
        Toast.makeText(this, "Загрузка", Toast.LENGTH_SHORT).show();
        String name = editTextText.getText().toString();
        String city = editTextText2.getText().toString();
        String email = editTextText3.getText().toString();
        String password = editTextText4.getText().toString();
        String password2 = editTextText5.getText().toString();

        if (name.isEmpty() || city.isEmpty() || email.isEmpty() || password.isEmpty() || password2.isEmpty()) {
            Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show();
        } else {

            if (!password.equals(password2)) {
                Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show();
            } else {


                DocumentReference Fc = firestore.collection("College").document(name);
                DocumentReference ps = firestore.collection("College").document(name).collection("data").document("personal");
                Map<String, Object> curs = new HashMap<>();

                curs.put("Group","test");

                Fc.collection("Year").document("Year1").set(curs);
                Fc.collection("Year").document("Year2").set(curs);
                Fc.collection("Year").document("Year3").set(curs);
                Fc.collection("Year").document("Year4").set(curs);
                Toast.makeText(this, "Готово", Toast.LENGTH_SHORT).show();

                Map<String, Object> personal = new HashMap<>();
                personal.put("name", name);
                personal.put("city", city);
                personal.put("email", email);
                personal.put("password", password);
                ps.set(personal);





            }


        }
    }

    public void GoToRazdelenie(View view) {
        Intent intent = new Intent(this, adminpanelRazdelenie.class);
        startActivity(intent);
    }
}