package com.example.raspisaniye;



import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.HashMap;
import java.util.Map;


public class adminpanel3 extends AppCompatActivity {
    private SharedPreferences pref;
    private String gj2, y;
    private Integer h;
    private FrameLayout fy1, fy2, fy3, fy4;
    FirebaseFirestore firestore;
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
        firestore = FirebaseFirestore.getInstance();
        pref = getSharedPreferences("data", MODE_PRIVATE);
        fy1 = findViewById(R.id.f1);
        fy2 = findViewById(R.id.fy2);
        fy3 = findViewById(R.id.fy3);
        fy4 = findViewById(R.id.fy4);
        gj2 = pref.getString("func", "блять, как ты сюда попал?!!?!?!");


    }

    public void y1(View view) {
        h = 1;
        y = "Year1";

    }

    public void y4(View view) {
        h = 4;
        y = "Year4";
    }

    public void y3(View view) {
        h = 3;
        y = "Year3";
    }

    public void y2(View view) {
        h = 2;
        y = "Year2";
    }

    public void AddGroup(View view) {
        FrameLayout frameLayout = findViewById(R.id.panini);
        LayoutInflater inflater = LayoutInflater.from(this);
        View contentView = inflater.inflate(R.layout.addgroup, frameLayout, false);
        frameLayout.addView(contentView);

    }
    public void Add(View view) {
        EditText editText = findViewById(R.id.editTextText9);
        String text = editText.getText().toString();
        String name = pref.getString("name","умпа лумпа ча ча ча");

        DocumentReference ps = firestore.collection("College").document(name).collection("Year").document(y);

        DocumentSnapshot document = ps.get().getResult(); // get() блокирует поток до получения документа

        if (document.exists()) {
            // Если документ существует, выводим его данные
            System.out.println("Документ найден!");
            System.out.println("Данные документа: " + document.getData());
        } else {
            System.out.println("Документ не найден.");
        }





//                    Map<String, Object> curs = new HashMap<>();
//                    for (int i = 1; i <= fieldCount; i++) {
//                        curs.put("Day" + i, "test");
//
//                    }
//                    curs.put("Group",text);
//
//
//
//                    ps.set(curs);

    }
}