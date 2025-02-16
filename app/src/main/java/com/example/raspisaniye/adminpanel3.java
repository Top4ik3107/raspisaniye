package com.example.raspisaniye;



import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;


public class adminpanel3 extends AppCompatActivity {
    private SharedPreferences pref;
    private String gj2, y;
    private Integer h;
    private FrameLayout fy1, fy2, fy3, fy4;
    FirebaseFirestore firestore;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adminpanel3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });
        y = "Year1";
        firestore = FirebaseFirestore.getInstance();
        pref = getSharedPreferences("data", MODE_PRIVATE);

        fy2 = findViewById(R.id.fy2);
        fy3 = findViewById(R.id.fy3);
        fy4 = findViewById(R.id.fy4);
        gj2 = pref.getString("func", "блять, как ты сюда попал?!!?!?!");
        update();
        pref = getSharedPreferences("data", MODE_PRIVATE);
        fy1 = findViewById(R.id.f1);
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
//                new AlertDialog.Builder(Mainr.this)
//                        .setTitle("Выход")
//                        .setMessage("Вы действительно хотите выйти из приложения?")
//                        .setPositiveButton("Да", (dialog, which) -> finishAffinity())
//                        .setNegativeButton("Нет", null)
//                        .show();
//
//                // Завершаем приложение
                Intent intent = new Intent(adminpanel3.this, Mainr.class);
                startActivity(intent);
            }
        };

        // Регистрация обработчика
        getOnBackPressedDispatcher().addCallback(this, callback);


    }

    public void y1(View view) {
        h = 1;
        y = "Year1";
        update();

    }

    public void y4(View view) {
        h = 4;
        y = "Year4";
        update();
    }

    public void y3(View view) {
        h = 3;
        y = "Year3";
        update();
    }

    public void y2(View view) {
        h = 2;
        y = "Year2";
        update();
    }

    public void AddGroup(View view) {
        FrameLayout frameLayout = findViewById(R.id.panini);
        LayoutInflater inflater = LayoutInflater.from(this);
        View contentView = inflater.inflate(R.layout.addgroup, frameLayout, false);
        frameLayout.addView(contentView);

    }
    public void exit(View view) {
        FrameLayout frameLayout = findViewById(R.id.panini);
        frameLayout.removeAllViews();
    }
    public void Add(View view) {
//        Toast.makeText(this,"dfd",Toast.LENGTH_SHORT).show();
        pref = getSharedPreferences("data", MODE_PRIVATE);
        fy1 = findViewById(R.id.f1);
        EditText editText = findViewById(R.id.editTextText9);

        text = editText.getText().toString();
        String name = pref.getString("college","умпа лумпа ча ча ча");

        DocumentReference ps = firestore.collection("College").document(name).collection("Year").document(y);

        ps.collection("group").document(text).set(new HashMap<>());
        update();
    }
    private void update() {
        String name = pref.getString("college", "умпа лумпа ча ча ча");
//        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        DocumentReference ps = firestore.collection("College").document(name).collection("Year").document(y);
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

        pref.edit().putString("group", text).apply();
        pref.edit().putString("year", y).apply();

        Intent intent = gj2.equals("R") ? new Intent(this, adminpanel4.class) : new Intent(this, adminpanel5.class);
        startActivity(intent);
    }

}