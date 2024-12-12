package com.example.raspisaniye;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class ViborRassilkiActivity extends AppCompatActivity {
    private static final String TAG = "ViborRassilkiActivity";

    String text;
    FirebaseFirestore firestore;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: Activity started");
        Toast.makeText(this, "Activity started", Toast.LENGTH_SHORT).show();

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vibor_rassilki);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            Log.d(TAG, "Insets applied: " + systemBars);
            return insets;
        });

        firestore = FirebaseFirestore.getInstance();
        pref = getSharedPreferences("data", MODE_PRIVATE);

        update();
    }

    private void update() {
        String name = pref.getString("college", "умпа лумпа ча ча ча");
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        DocumentReference ps = firestore.collection("data").document("coll");
        LinearLayout linearLayout = findViewById(R.id.rassilBox);
        linearLayout.removeAllViews();

        ps.collection("c").get().addOnCompleteListener(task -> {
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
            Log.w(TAG, "addhadle: No college selected");
            Toast.makeText(this, "Please select a group first!", Toast.LENGTH_SHORT).show();
            return;
        }

        Log.d(TAG, "addhadle: Saving selected college: " + text);
        pref.edit().putString("scollege", text).apply();

//        Intent intent = new Intent(this, adminpanel4.class);
        Log.d(TAG, "addhadle: Starting admin panel");
//        startActivity(intent);
    }

    public void Getras(View view) {
        Log.d(TAG, "Getras: Refresh button clicked");
        Toast.makeText(this, "Refreshing list", Toast.LENGTH_SHORT).show();
        update();
    }
}
