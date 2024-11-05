package com.example.raspisaniye;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class adminpanelRazdelenie extends AppCompatActivity {


    private TextView subot7;


    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adminpanel_razdelenie);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        subot7= findViewById(R.id.textView25);

        pref = getSharedPreferences("adminDate",MODE_PRIVATE);

        try {
            Bundle arguments = getIntent().getExtras();

            String college = arguments.get("college").toString();
            

            SharedPreferences.Editor editor = pref.edit();

            editor.putString("college",college);
            

            editor.apply();
            subot7.setText(college);


        } catch (Exception ex) {

            String gj2 = pref.getString("college","Set college");

            subot7.setText(gj2);

        }


    }

    public void GoToAdd(View view) {
        if (subot7.getText().toString().equals("Set college")) {
        Toast.makeText(this, "Set college", Toast.LENGTH_SHORT).show();
    }
        else {
            Intent intent = new Intent(this, adminpanel5.class);
            startActivity(intent);
        }
    }

    public void GoToSchedule(View view) {
        if (subot7.getText().toString().equals("Set college")) {
            Toast.makeText(this, "Set college", Toast.LENGTH_SHORT).show();
        }else { Intent intent = new Intent(this, adminpanel4.class);
            startActivity(intent);
        }

    }

    public void GoToSelectCollege(View view) {
        Intent intent = new Intent(this, adminpanel6.class);
        startActivity(intent);



    }
}