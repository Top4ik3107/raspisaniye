package com.example.raspisaniye;

import android.content.Intent;
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

public class Mainr extends AppCompatActivity {

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
    }

    public void GoTosecond(View view) {
        Intent intent = new Intent(this, Secondr.class);
        startActivity(intent);
    }
    public void OpenMenu(View view) {

        FrameLayout frameLayout = findViewById(R.id.pan);
        LayoutInflater inflater = LayoutInflater.from(this);

        if (frameLayout != null) { // Проверяем, что frameLayout существует
            if (frameLayout.getChildCount() > 0) {
                frameLayout.removeAllViews(); // Очищаем, если есть элементы
            } else {
                View contentView = inflater.inflate(R.layout.panel, frameLayout, false);
                frameLayout.addView(contentView);
            }
        } else {
            Toast.makeText(this, "FrameLayout не найден", Toast.LENGTH_SHORT).show();

        }
    }
}