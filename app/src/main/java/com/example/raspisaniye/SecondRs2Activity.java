package com.example.raspisaniye;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

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

public class SecondRs2Activity extends AppCompatActivity {

    private TextView aa, bb, cc, ddd, ee, jj;
    private TextView t1, t2, t3, t4, t5;

    private String a, b, c, d, e, j;
    private String r11, r12, r13, r14, r15;
    private String r21, r22, r23, r24, r25;

    private DocumentReference ddt, ddf;
    private String sityw, schoolw, claccw, simbolw;
    private FirebaseFirestore firestore;
    private SharedPreferences pref;

    private void init() {
        aa = findViewById(R.id.sspred1);
        bb = findViewById(R.id.sspred2);
        cc = findViewById(R.id.sspred3);
        ddd = findViewById(R.id.sspred4);
        ee = findViewById(R.id.sspred5);

        jj = findViewById(R.id.textView2);
        t1 = findViewById(R.id.sstime1);
        t2 = findViewById(R.id.sstime2);
        t3 = findViewById(R.id.sstime3);
        t4 = findViewById(R.id.sstime4);
        t5 = findViewById(R.id.sstime5);

    }

    private void init2() {
        sityw = pref.getString("putisit", "Non");
        schoolw = pref.getString("putinum", "1");
        claccw = pref.getString("claccnum", "1");
        simbolw = pref.getString("claccsim", "N");


    }

    private void inittxt() {
        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            a = arguments.getString("one");
            b = arguments.getString("two");
            c = arguments.getString("three");
            d = arguments.getString("four");
            e = arguments.getString("five");
            //f = arguments.getString("six");
            //g = arguments.getString("seven");
            j = arguments.getString("day");

            jj.setText(j);
            aa.setText(a);
            bb.setText(b);
            cc.setText(c);
            ddd.setText(d);
            ee.setText(e);

        } else {
            Toast.makeText(this, "Нет полученных данных", Toast.LENGTH_SHORT).show();
        }
    }

    private void fetchDocumentData(DocumentReference documentRef) {
        if (documentRef != null) {
            documentRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document != null && document.exists()) {

                            r11 = document.getString("урок1");
                            r12 = document.getString("урок2");
                            r13 = document.getString("урок3");
                            r14 = document.getString("урок4");
                            r15 = document.getString("урок5");




                            updateTextViews();

                        } else {
                            Toast.makeText(SecondRs2Activity.this, "Документ не найден", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(SecondRs2Activity.this, "Ошибка при получении данных", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            Toast.makeText(this, "Ссылка на документ равна null", Toast.LENGTH_SHORT).show();
        }
    }

    private void fetchDocumentData2(DocumentReference documentRef) {
        if (documentRef != null) {
            documentRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document != null && document.exists()) {


                            r21 = document.getString("урок1");
                            r22 = document.getString("урок2");
                            r23 = document.getString("урок3");
                            r24 = document.getString("урок4");
                            r25 = document.getString("урок5");


                            updateTextViews();

                        } else {
                            Toast.makeText(SecondRs2Activity.this, "Документ не найден", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(SecondRs2Activity.this, "Ошибка при получении данных", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            Toast.makeText(this, "Ссылка на документ равна null", Toast.LENGTH_SHORT).show();
        }
    }


    private void updateTextViews() {
        setText(t1, r11, r21);
        setText(t2, r12, r22);
        setText(t3, r13, r23);
        setText(t4, r14, r24);
        setText(t5, r15, r25);

    }

    private void setText(TextView textView, String start, String finish) {


        textView.setText(start + "-" + finish);



    }

    private void inittime() {
        CollectionReference clacc = firestore.collection("sity")
                .document(sityw)
                .collection(schoolw)
                .document(claccw)
                .collection(simbolw);

        ddt = clacc.document(j.toLowerCase()).collection("time").document("start");
        ddf = clacc.document(j.toLowerCase()).collection("time").document("finish");

        fetchDocumentData(ddt);
        fetchDocumentData2(ddf);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second_rs2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        pref = getSharedPreferences("TABLE", MODE_PRIVATE);
        firestore = FirebaseFirestore.getInstance();
        init();
        init2();
        inittxt();
        inittime();
    }
}