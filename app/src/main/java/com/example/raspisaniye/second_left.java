package com.example.raspisaniye;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class second_left extends AppCompatActivity {
    FirebaseFirestore firestore;
    private SharedPreferences pref;

    private String a, b, c, d, e, f, g, j;
    private TextView aa, bb, cc, dd, ee, ff, gg, jj;
    private TextView subot7, class7;

    private TextView p11, p12, p13, p14, p15, p16, p17,
            p21, p22, p23, p24, p25, p26, p27,
            p31, p32, p33, p34, p35, p36, p37,
            p41, p42, p43, p44, p45, p46, p47,
            p51, p52, p53, p54, p55, p56, p57,
            p61, p62, p63, p64, p65, p66, p67;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second_left);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        firestore = FirebaseFirestore.getInstance();
        pref = getSharedPreferences("data", MODE_PRIVATE);
        init();
        class7.setText(pref.getString("AddedGroup", "Выберите колледж"));

        inittexts();


    }

    public void inittexts(){



        CollectionReference clacc = firestore.collection("College")
                .document(pref.getString("AddedCollege", "test"))
                .collection("Year")
                .document(pref.getString("AddedYear", "test"))
                .collection("group")
                .document(pref.getString("AddedGroup", "test"))
                .collection("lessons2");



        DocumentReference pon = clacc.document("понедельник");
        pon.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        String r11 = document.getString("урок1");
                        String r12 = document.getString("урок2");
                        String r13 = document.getString("урок3");
                        String r14 = document.getString("урок4");
                        String r15 = document.getString("урок5");

                        if (r11.length() != 0) {p11.setText(r11);} else {p11.setText("-");}
                        if (r12.length() != 0) {p12.setText(r12);} else {p12.setText("-");}
                        if (r13.length() != 0) {p13.setText(r13);} else {p13.setText("-");}
                        if (r14.length() != 0) {p14.setText(r14);} else {p14.setText("-");}
                        if (r15.length() != 0) {p15.setText(r15);} else {p15.setText("-");}

                    }}}});



        DocumentReference vto = clacc.document("вторник");
        vto.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        String r11 = document.getString("урок1");
                        String r12 = document.getString("урок2");
                        String r13 = document.getString("урок3");
                        String r14 = document.getString("урок4");
                        String r15 = document.getString("урок5");

                        if (r11.length() != 0) {p21.setText(r11);} else {p21.setText("-");}
                        if (r12.length() != 0) {p22.setText(r12);} else {p22.setText("-");}
                        if (r13.length() != 0) {p23.setText(r13);} else {p23.setText("-");}
                        if (r14.length() != 0) {p24.setText(r14);} else {p24.setText("-");}
                        if (r15.length() != 0) {p25.setText(r15);} else {p25.setText("-");}

                    }}}});

        DocumentReference sre = clacc.document("среда");
        sre.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        String r11 = document.getString("урок1");
                        String r12 = document.getString("урок2");
                        String r13 = document.getString("урок3");
                        String r14 = document.getString("урок4");
                        String r15 = document.getString("урок5");

                        if (r11.length() != 0) {p31.setText(r11);} else {p31.setText("-");}
                        if (r12.length() != 0) {p32.setText(r12);} else {p32.setText("-");}
                        if (r13.length() != 0) {p33.setText(r13);} else {p33.setText("-");}
                        if (r14.length() != 0) {p34.setText(r14);} else {p34.setText("-");}
                        if (r15.length() != 0) {p35.setText(r15);} else {p35.setText("-");}

                    }}}});

        DocumentReference che = clacc.document("четверг");
        che.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        String r11 = document.getString("урок1");
                        String r12 = document.getString("урок2");
                        String r13 = document.getString("урок3");
                        String r14 = document.getString("урок4");
                        String r15 = document.getString("урок5");

                        if (r11.length() != 0) {p41.setText(r11);} else {p41.setText("-");}
                        if (r12.length() != 0) {p42.setText(r12);} else {p42.setText("-");}
                        if (r13.length() != 0) {p43.setText(r13);} else {p43.setText("-");}
                        if (r14.length() != 0) {p44.setText(r14);} else {p44.setText("-");}
                        if (r15.length() != 0) {p45.setText(r15);} else {p45.setText("-");}

                    }}}});


        DocumentReference pat = clacc.document("пятница");
        pat.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        String r11 = document.getString("урок1");
                        String r12 = document.getString("урок2");
                        String r13 = document.getString("урок3");
                        String r14 = document.getString("урок4");
                        String r15 = document.getString("урок5");

                        if (r11.length() != 0) {p51.setText(r11);} else {p51.setText("-");}
                        if (r12.length() != 0) {p52.setText(r12);} else {p52.setText("-");}
                        if (r13.length() != 0) {p53.setText(r13);} else {p53.setText("-");}
                        if (r14.length() != 0) {p54.setText(r14);} else {p54.setText("-");}
                        if (r15.length() != 0) {p55.setText(r15);} else {p55.setText("-");}

                    }}}});


        DocumentReference sub = clacc.document("суббота");
        sub.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        String r11 = document.getString("урок1");
                        String r12 = document.getString("урок2");
                        String r13 = document.getString("урок3");
                        String r14 = document.getString("урок4");
                        String r15 = document.getString("урок5");

                        if (r11.length() != 0) {p61.setText(r11);} else {p61.setText("-");}
                        if (r12.length() != 0) {p62.setText(r12);} else {p62.setText("-");}
                        if (r13.length() != 0) {p63.setText(r13);} else {p63.setText("-");}
                        if (r14.length() != 0) {p64.setText(r14);} else {p64.setText("-");}
                        if (r15.length() != 0) {p65.setText(r15);} else {p65.setText("-");}

                    }}}});















    }

    public void init(){

        class7 = findViewById(R.id.clacs);


        p11 = findViewById(R.id.p11);
        p12 = findViewById(R.id.p12);
        p13 = findViewById(R.id.p13);
        p14 = findViewById(R.id.p14);
        p15 = findViewById(R.id.p15);


        p21 = findViewById(R.id.p21);
        p22 = findViewById(R.id.p22);
        p23 = findViewById(R.id.p23);
        p24 = findViewById(R.id.p24);
        p25 = findViewById(R.id.p25);


        p31 = findViewById(R.id.p31);
        p32 = findViewById(R.id.p32);
        p33 = findViewById(R.id.p33);
        p34 = findViewById(R.id.p34);
        p35 = findViewById(R.id.p35);


        p41 = findViewById(R.id.p41);
        p42 = findViewById(R.id.p42);
        p43 = findViewById(R.id.p43);
        p44 = findViewById(R.id.p44);
        p45 = findViewById(R.id.p45);


        p51 = findViewById(R.id.p51);
        p52 = findViewById(R.id.p52);
        p53 = findViewById(R.id.p53);
        p54 = findViewById(R.id.p54);
        p55 = findViewById(R.id.p55);


        p61 = findViewById(R.id.p61);
        p62 = findViewById(R.id.p62);
        p63 = findViewById(R.id.p63);
        p64 = findViewById(R.id.p64);
        p65 = findViewById(R.id.p65);


    }

    public void GoToMain(View view) {
        Intent intent = new Intent(this, Mainr.class);
        startActivity(intent);
    }

    public void chenge(View view) {
        Intent intent = new Intent(this, Secondr.class);
        startActivity(intent);
    }
}