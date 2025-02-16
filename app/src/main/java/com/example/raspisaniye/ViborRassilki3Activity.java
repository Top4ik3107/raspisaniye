package com.example.raspisaniye;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ViborRassilki3Activity extends AppCompatActivity {
    private SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vibor_rassilki3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        pref = getSharedPreferences("data",MODE_PRIVATE);
        sub();
    }
//    public void sub(View view) {
    public void sub() {
        String col = pref.getString("scollege","test");
        String yea = pref.getString("syear","test");
        String gro = pref.getString("sgroup","test");

        pref.edit().putString("AddedCollege",col).apply();
        pref.edit().putString("AddedYear",yea).apply();
        pref.edit().putString("AddedGroup",gro).apply();
        Toast.makeText(this,"Теперь вы учащийся Коллежда: "+col+"  Группы: "+gro,Toast.LENGTH_SHORT).show();
        Intent in = new Intent(this,Mainr.class);
        startActivity(in);

    }
}