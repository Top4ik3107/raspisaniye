package com.example.raspisaniye;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class ViborRasspiski2Activity extends AppCompatActivity {

    FirebaseFirestore firestore;
    private SharedPreferences pref;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vibor_rasspiski2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        pref = getSharedPreferences("data", MODE_PRIVATE);
        firestore = FirebaseFirestore.getInstance();

    }
    private void update() {
        String name = pref.getString("college", "умпа лумпа ча ча ча");
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        DocumentReference ps = firestore.collection("College").document(name).collection("Year").document("Year1");
        LinearLayout linearLayout = findViewById(R.id.group_group);
        linearLayout.removeAllViews();

        ps.collection("group").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                QuerySnapshot querySnapshot = task.getResult();
                if (querySnapshot != null) {
                    for (QueryDocumentSnapshot document : querySnapshot) {
                        View itemView = LayoutInflater.from(this).inflate(R.layout.group, linearLayout, false);
                        TextView textView = itemView.findViewById(R.id.textView96);
                        textView.setText(document.getId());

                        // Добавляем обработчик клика
                        itemView.setOnClickListener(v -> {
                            text = document.getId(); // Запоминаем выбранный элемент
                            addhadle();
                            Toast.makeText(this, "Selected: " + text, Toast.LENGTH_SHORT).show();
                        });

                        linearLayout.addView(itemView);
                    }
                } else {
                    System.out.println("No documents found.");
                }
            } else {
                System.err.println("Error getting documents: " + task.getException());
            }
        });
    }
    public void addhadle() {
        if (text == null || text.isEmpty()) {
            Toast.makeText(this, "Please select a group first!", Toast.LENGTH_SHORT).show();
            return;
        }

        pref.edit().putString("sgroup", text).apply();


        Intent intent = new Intent(this, adminpanel4.class);
        startActivity(intent);
    }
}