package com.example.raspisaniye;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.firestore.FirebaseFirestore;

public class Mainr extends AppCompatActivity {
    FirebaseFirestore firestore;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_rs);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        pref = getSharedPreferences("data", MODE_PRIVATE);


        firestore = FirebaseFirestore.getInstance();
    }

    public void GoTosecond(View view) {
        Intent intent = new Intent(this, Secondr.class);
        startActivity(intent);
    }
    public void OpenMenu(View view) {

        FrameLayout frameLayout = findViewById(R.id.pan);
        LayoutInflater inflater = LayoutInflater.from(this);

        if (frameLayout != null) {
            if (frameLayout.getChildCount() > 0) {
                frameLayout.removeAllViews();
            } else {
                View contentView = inflater.inflate(R.layout.panel, frameLayout, false);
                frameLayout.addView(contentView);
            }
        } else {
            Toast.makeText(this, "FrameLayout не найден", Toast.LENGTH_SHORT).show();

        }
    }
    public void GoToAdmPass(View view) {
        Intent intent = new Intent(this, adminpanelPassword.class);
        startActivity(intent);
    }
    private void testgo() {
        String first = pref.getString("first", "0");
        if (first.equals("0")) {
            Intent intent = new Intent(this, Privet.class);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("first", "1");
            editor.apply();
            startActivity(intent);
        }
        else{
            update();
        }

    }
    private void update() {


    }



}