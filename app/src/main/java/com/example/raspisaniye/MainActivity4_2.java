package com.example.raspisaniye;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.annotation.SuppressLint;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MainActivity4_2 extends AppCompatActivity {



    private String year;
    private String group;

    String[] settime = {"1 смена","2 смена","пусто"};

    FirebaseFirestore firestore;
    private SharedPreferences pref;










    private EditText v11;
    private EditText v12;
    private EditText v13;
    private EditText v14;
    private EditText v15;


    private EditText v11t;
    private EditText v12t;
    private EditText v13t;
    private EditText v14t;
    private EditText v15t;


    private EditText v11t2;
    private EditText v12t2;
    private EditText v13t2;
    private EditText v14t2;
    private EditText v15t2;



    private EditText v21;
    private EditText v22;
    private EditText v23;
    private EditText v24;
    private EditText v25;


    private EditText v21t;
    private EditText v22t;
    private EditText v23t;
    private EditText v24t;
    private EditText v25t;


    private EditText v21t2;
    private EditText v22t2;
    private EditText v23t2;
    private EditText v24t2;
    private EditText v25t2;


    private EditText v31;
    private EditText v32;
    private EditText v33;
    private EditText v34;
    private EditText v35;


    private EditText v31t;
    private EditText v32t;
    private EditText v33t;
    private EditText v34t;
    private EditText v35t;


    private EditText v31t2;
    private EditText v32t2;
    private EditText v33t2;
    private EditText v34t2;
    private EditText v35t2;


    private EditText v41;
    private EditText v42;
    private EditText v43;
    private EditText v44;
    private EditText v45;


    private EditText v41t;
    private EditText v42t;
    private EditText v43t;
    private EditText v44t;
    private EditText v45t;


    private EditText v41t2;
    private EditText v42t2;
    private EditText v43t2;
    private EditText v44t2;
    private EditText v45t2;


    private EditText v51;
    private EditText v52;
    private EditText v53;
    private EditText v54;
    private EditText v55;

    private EditText v51t;
    private EditText v52t;
    private EditText v53t;
    private EditText v54t;
    private EditText v55t;


    private EditText v51t2;
    private EditText v52t2;
    private EditText v53t2;
    private EditText v54t2;
    private EditText v55t2;


    private EditText v61;
    private EditText v62;
    private EditText v63;
    private EditText v64;
    private EditText v65;


    private EditText v61t;
    private EditText v62t;
    private EditText v63t;
    private EditText v64t;
    private EditText v65t;


    private EditText v61t2;
    private EditText v62t2;
    private EditText v63t2;
    private EditText v64t2;
    private EditText v65t2;

    private String college;

    private final String pon = "понедельник";
    private final String vto = "вторник";
    private final String sre = "среда";
    private final String che = "четверг";
    private final String pat = "пятница";
    private final String sub = "суббота";

    public void init(){









        v11 = findViewById(R.id.v11);
        v12 = findViewById(R.id.v12);
        v13 = findViewById(R.id.v13);
        v14 = findViewById(R.id.v14);
        v15 = findViewById(R.id.v15);

        v11t = findViewById(R.id.v11t);
        v12t = findViewById(R.id.v12t);
        v13t = findViewById(R.id.v13t);
        v14t = findViewById(R.id.v14t);
        v15t = findViewById(R.id.v15t);


        v11t2 = findViewById(R.id.v11t2);
        v12t2 = findViewById(R.id.v12t2);
        v13t2 = findViewById(R.id.v13t2);
        v14t2 = findViewById(R.id.v14t2);
        v15t2 = findViewById(R.id.v15t2);



        v21 = findViewById(R.id.v21);
        v22 = findViewById(R.id.v22);
        v23 = findViewById(R.id.v23);
        v24 = findViewById(R.id.v24);
        v25 = findViewById(R.id.v25);


        v21t = findViewById(R.id.v21t);
        v22t = findViewById(R.id.v22t);
        v23t = findViewById(R.id.v23t);
        v24t = findViewById(R.id.v24t);
        v25t = findViewById(R.id.v25t);


        v21t2 = findViewById(R.id.v21t2);
        v22t2 = findViewById(R.id.v22t2);
        v23t2 = findViewById(R.id.v23t2);
        v24t2 = findViewById(R.id.v24t2);
        v25t2 = findViewById(R.id.v25t2);


        v31 = findViewById(R.id.v31);
        v32 = findViewById(R.id.v32);
        v33 = findViewById(R.id.v33);
        v34 = findViewById(R.id.v34);
        v35 = findViewById(R.id.v35);


        v31t = findViewById(R.id.v31t);
        v32t = findViewById(R.id.v32t);
        v33t = findViewById(R.id.v33t);
        v34t = findViewById(R.id.v34t);
        v35t = findViewById(R.id.v35t);


        v31t2 = findViewById(R.id.v31t2);
        v32t2 = findViewById(R.id.v32t2);
        v33t2 = findViewById(R.id.v33t2);
        v34t2 = findViewById(R.id.v34t2);
        v35t2 = findViewById(R.id.v35t2);


        v41 = findViewById(R.id.v41);
        v42 = findViewById(R.id.v42);
        v43 = findViewById(R.id.v43);
        v44 = findViewById(R.id.v44);
        v45 = findViewById(R.id.v45);


        v41t = findViewById(R.id.v41t);
        v42t = findViewById(R.id.v42t);
        v43t = findViewById(R.id.v43t);
        v44t = findViewById(R.id.v44t);
        v45t = findViewById(R.id.v45t);


        v41t2 = findViewById(R.id.v41t2);
        v42t2 = findViewById(R.id.v42t2);
        v43t2 = findViewById(R.id.v43t2);
        v44t2 = findViewById(R.id.v44t2);
        v45t2 = findViewById(R.id.v45t2);


        v51 = findViewById(R.id.v51);
        v52 = findViewById(R.id.v52);
        v53 = findViewById(R.id.v53);
        v54 = findViewById(R.id.v54);
        v55 = findViewById(R.id.v55);


        v51t = findViewById(R.id.v51t);
        v52t = findViewById(R.id.v52t);
        v53t = findViewById(R.id.v53t);
        v54t = findViewById(R.id.v54t);
        v55t = findViewById(R.id.v55t);


        v51t2 = findViewById(R.id.v51t2);
        v52t2 = findViewById(R.id.v52t2);
        v53t2 = findViewById(R.id.v53t2);
        v54t2 = findViewById(R.id.v54t2);
        v55t2 = findViewById(R.id.v55t2);


        v61 = findViewById(R.id.v61);
        v62 = findViewById(R.id.v62);
        v63 = findViewById(R.id.v63);
        v64 = findViewById(R.id.v64);
        v65 = findViewById(R.id.v65);


        v61t = findViewById(R.id.v61t);
        v62t = findViewById(R.id.v62t);
        v63t = findViewById(R.id.v63t);
        v64t = findViewById(R.id.v64t);
        v65t = findViewById(R.id.v65t);


        v61t2 = findViewById(R.id.v61t2);
        v62t2 = findViewById(R.id.v62t2);
        v63t2 = findViewById(R.id.v63t2);
        v64t2 = findViewById(R.id.v64t2);
        v65t2 = findViewById(R.id.v65t2);


    }


    public static int getCurrentWeekType() {
        // Получаем текущую дату
        Calendar calendar = Calendar.getInstance();

        // Получаем номер недели в году (от 1 до 52)
        int weekNumber = calendar.get(Calendar.WEEK_OF_YEAR);

        // Определяем, четная неделя или нечетная
        return (weekNumber % 2 == 0) ? 2 : 1;
    }

    public void intentimport(){

        group = pref.getString("group","Set group");
        year = pref.getString("year","Set year");
        college = pref.getString("college","Set college");

    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main42);




        firestore = FirebaseFirestore.getInstance();
        pref = getSharedPreferences("data", MODE_PRIVATE);
        init();
        intentimport();
        updatels();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, settime);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.spinnersity2);
        spinner.setAdapter(adapter);

        // заголовок
        spinner.setPrompt("Title");

        // устанавливаем обработчик нажатия
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                String selectedItem = parent.getItemAtPosition(position).toString();
                if(selectedItem.equals("1 смена")) {
                    addstandarttime();
                    Toast.makeText(getApplicationContext(), "Время установленно", Toast.LENGTH_SHORT).show();
                }

                if(selectedItem.equals("2 смена")) {
                    ddaddstandarttime();
                    Toast.makeText(getApplicationContext(), "Время установленно", Toast.LENGTH_SHORT).show();
                }
                if(selectedItem.equals("пусто")) {
                    nul();
                    Toast.makeText(getApplicationContext(), "Время установленно", Toast.LENGTH_SHORT).show();

                }






            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });
        OnBackPressedDispatcher dispatcher = getOnBackPressedDispatcher();
        dispatcher.addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(MainActivity4_2.this, adminpanelRazdelenie.class);
                startActivity(intent);
                // finish();
            }
        });


    }
    private void updatels(){
        CollectionReference cities = firestore.collection("College").document(college).collection("Year").document(year).collection("group").document(group).collection("lessons2");


        cities.document(pon).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        v11.setText(document.getString("урок1"));
                        v12.setText(document.getString("урок2"));
                        v13.setText(document.getString("урок3"));
                        v14.setText(document.getString("урок4"));
                        v15.setText(document.getString("урок5"));
                    }}}});
        cities.document(vto).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        v21.setText(document.getString("урок1"));
                        v22.setText(document.getString("урок2"));
                        v23.setText(document.getString("урок3"));
                        v24.setText(document.getString("урок4"));
                        v25.setText(document.getString("урок5"));

                    }}}});
        cities.document(sre).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        v21.setText(document.getString("урок1"));
                        v32.setText(document.getString("урок2"));
                        v33.setText(document.getString("урок3"));
                        v34.setText(document.getString("урок4"));
                        v35.setText(document.getString("урок5"));

                    }}}});
        cities.document(che).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        v41.setText(document.getString("урок1"));
                        v42.setText(document.getString("урок2"));
                        v43.setText(document.getString("урок3"));
                        v44.setText(document.getString("урок4"));
                        v45.setText(document.getString("урок5"));

                    }}}});


        cities.document(pat).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        v51.setText(document.getString("урок1"));
                        v52.setText(document.getString("урок2"));
                        v53.setText(document.getString("урок3"));
                        v54.setText(document.getString("урок4"));
                        v55.setText(document.getString("урок5"));

                    }}}});


        cities.document(sub).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        v61.setText(document.getString("урок1"));
                        v62.setText(document.getString("урок2"));
                        v63.setText(document.getString("урок3"));
                        v64.setText(document.getString("урок4"));
                        v65.setText(document.getString("урок5"));

                    }}}});


    }

    public void addtobbase(View view){





        CollectionReference cities = firestore.collection("College").document(college).collection("Year").document(year).collection("group").document(group).collection("lessons2");

        String uruk11 = v11.getText().toString();
        String urok12 = v12.getText().toString();
        String urok13 = v13.getText().toString();
        String uruk14 = v14.getText().toString();
        String urok15 = v15.getText().toString();


        String uruk21 = v21.getText().toString();
        String urok22 = v22.getText().toString();
        String urok23 = v23.getText().toString();
        String uruk24 = v24.getText().toString();
        String urok25 = v25.getText().toString();

        String uruk31 = v31.getText().toString();
        String urok32 = v32.getText().toString();
        String urok33 = v33.getText().toString();
        String uruk34 = v34.getText().toString();
        String urok35 = v35.getText().toString();


        String uruk41 = v41.getText().toString();
        String urok42 = v42.getText().toString();
        String urok43 = v43.getText().toString();
        String uruk44 = v44.getText().toString();
        String urok45 = v45.getText().toString();


        String uruk51 = v51.getText().toString();
        String urok52 = v52.getText().toString();
        String urok53 = v53.getText().toString();
        String uruk54 = v54.getText().toString();
        String urok55 = v55.getText().toString();


        String uruk61 = v61.getText().toString();
        String urok62 = v62.getText().toString();
        String urok63 = v63.getText().toString();
        String uruk64 = v64.getText().toString();
        String urok65 = v65.getText().toString();





        Map<String, Object> user = new HashMap<>();

        user.put("урок1",uruk11);
        user.put("урок2",urok12);
        user.put("урок3",urok13);
        user.put("урок4",uruk14);
        user.put("урок5",urok15);


        cities.document(pon).set(user);


        Map<String, Object> user2 = new HashMap<>();

        user2.put("урок1",uruk21);
        user2.put("урок2",urok22);
        user2.put("урок3",urok23);
        user2.put("урок4",uruk24);
        user2.put("урок5",urok25);


        cities.document(vto).set(user2);


        Map<String, Object> user3 = new HashMap<>();

        user3.put("урок1",uruk31);
        user3.put("урок2",urok32);
        user3.put("урок3",urok33);
        user3.put("урок4",uruk34);
        user3.put("урок5",urok35);


        cities.document(sre).set(user3);


        Map<String, Object> user4 = new HashMap<>();

        user4.put("урок1",uruk41);
        user4.put("урок2",urok42);
        user4.put("урок3",urok43);
        user4.put("урок4",uruk44);
        user4.put("урок5",urok45);


        cities.document(che).set(user4);


        Map<String, Object> user5 = new HashMap<>();

        user5.put("урок1",uruk51);
        user5.put("урок2",urok52);
        user5.put("урок3",urok53);
        user5.put("урок4",uruk54);
        user5.put("урок5",urok55);


        cities.document(pat).set(user5);


        Map<String, Object> user6 = new HashMap<>();

        user6.put("урок1",uruk61);
        user6.put("урок2",urok62);
        user6.put("урок3",urok63);
        user6.put("урок4",uruk64);
        user6.put("урок5",urok65);


        cities.document(sub).set(user6);










        CollectionReference time6 = cities.document(sub).collection("time");

        String st61 = v61t.getText().toString();
        String st62 = v62t.getText().toString();
        String st63 = v63t.getText().toString();
        String st64 = v64t.getText().toString();
        String st65 = v65t.getText().toString();


        Map<String, Object> tim6 = new HashMap<>();

        tim6.put("урок1",st61);
        tim6.put("урок2",st62);
        tim6.put("урок3",st63);
        tim6.put("урок4",st64);
        tim6.put("урок5",st65);


        time6.document("start").set(tim6);

        String fi61 = v61t2.getText().toString();
        String fi62 = v62t2.getText().toString();
        String fi63 = v63t2.getText().toString();
        String fi64 = v64t2.getText().toString();
        String fi65 = v65t2.getText().toString();


        Map<String, Object> fin6 = new HashMap<>();

        fin6.put("урок1",fi61);
        fin6.put("урок2",fi62);
        fin6.put("урок3",fi63);
        fin6.put("урок4",fi64);
        fin6.put("урок5",fi65);


        time6.document("finish").set(fin6);







        CollectionReference time1 = cities.document(pon).collection("time");

        String st1 = v11t.getText().toString();
        String st2 = v12t.getText().toString();
        String st3 = v13t.getText().toString();
        String st4 = v14t.getText().toString();
        String st5 = v15t.getText().toString();


        Map<String, Object> tim1 = new HashMap<>();

        tim1.put("урок1",st1);
        tim1.put("урок2",st2);
        tim1.put("урок3",st3);
        tim1.put("урок4",st4);
        tim1.put("урок5",st5);


        time1.document("start").set(tim1);

        String fi1 = v11t2.getText().toString();
        String fi2 = v12t2.getText().toString();
        String fi3 = v13t2.getText().toString();
        String fi4 = v14t2.getText().toString();
        String fi5 = v15t2.getText().toString();


        Map<String, Object> fin1 = new HashMap<>();

        fin1.put("урок1",fi1);
        fin1.put("урок2",fi2);
        fin1.put("урок3",fi3);
        fin1.put("урок4",fi4);
        fin1.put("урок5",fi5);


        time1.document("finish").set(fin1);








        CollectionReference time2 = cities.document(vto).collection("time");

        String st21 = v21t.getText().toString();
        String st22 = v22t.getText().toString();
        String st23 = v23t.getText().toString();
        String st24 = v24t.getText().toString();
        String st25 = v25t.getText().toString();


        Map<String, Object> tim2 = new HashMap<>();

        tim2.put("урок1",st21);
        tim2.put("урок2",st22);
        tim2.put("урок3",st23);
        tim2.put("урок4",st24);
        tim2.put("урок5",st25);


        time2.document("start").set(tim2);

        String fi21 = v21t2.getText().toString();
        String fi22 = v22t2.getText().toString();
        String fi23 = v23t2.getText().toString();
        String fi24 = v24t2.getText().toString();
        String fi25 = v25t2.getText().toString();


        Map<String, Object> fin2 = new HashMap<>();

        fin2.put("урок1",fi21);
        fin2.put("урок2",fi22);
        fin2.put("урок3",fi23);
        fin2.put("урок4",fi24);
        fin2.put("урок5",fi25);


        time2.document("finish").set(fin2);











        CollectionReference time3 = cities.document(sre).collection("time");

        String st31 = v31t.getText().toString();
        String st32 = v32t.getText().toString();
        String st33 = v33t.getText().toString();
        String st34 = v34t.getText().toString();
        String st35 = v35t.getText().toString();


        Map<String, Object> tim3 = new HashMap<>();

        tim3.put("урок1",st31);
        tim3.put("урок2",st32);
        tim3.put("урок3",st33);
        tim3.put("урок4",st34);
        tim3.put("урок5",st35);


        time3.document("start").set(tim3);

        String fi31 = v31t2.getText().toString();
        String fi32 = v32t2.getText().toString();
        String fi33 = v33t2.getText().toString();
        String fi34 = v34t2.getText().toString();
        String fi35 = v35t2.getText().toString();


        Map<String, Object> fin3 = new HashMap<>();

        fin3.put("урок1",fi31);
        fin3.put("урок2",fi32);
        fin3.put("урок3",fi33);
        fin3.put("урок4",fi34);
        fin3.put("урок5",fi35);


        time3.document("finish").set(fin3);











        CollectionReference time4 = cities.document(che).collection("time");

        String st41 = v41t.getText().toString();
        String st42 = v42t.getText().toString();
        String st43 = v43t.getText().toString();
        String st44 = v44t.getText().toString();
        String st45 = v45t.getText().toString();


        Map<String, Object> tim4 = new HashMap<>();

        tim4.put("урок1",st41);
        tim4.put("урок2",st42);
        tim4.put("урок3",st43);
        tim4.put("урок4",st44);
        tim4.put("урок5",st45);


        time4.document("start").set(tim4);

        String fi41 = v41t2.getText().toString();
        String fi42 = v42t2.getText().toString();
        String fi43 = v43t2.getText().toString();
        String fi44 = v44t2.getText().toString();
        String fi45 = v45t2.getText().toString();


        Map<String, Object> fin4 = new HashMap<>();

        fin4.put("урок1",fi41);
        fin4.put("урок2",fi42);
        fin4.put("урок3",fi43);
        fin4.put("урок4",fi44);
        fin4.put("урок5",fi45);


        time4.document("finish").set(fin4);













        CollectionReference time5 = cities.document(pat).collection("time");

        String st51 = v51t.getText().toString();
        String st52 = v52t.getText().toString();
        String st53 = v53t.getText().toString();
        String st54 = v54t.getText().toString();
        String st55 = v55t.getText().toString();


        Map<String, Object> tim5 = new HashMap<>();

        tim5.put("урок1",st51);
        tim5.put("урок2",st52);
        tim5.put("урок3",st53);
        tim5.put("урок4",st54);
        tim5.put("урок5",st55);


        time5.document("start").set(tim5);

        String fi51 = v51t2.getText().toString();
        String fi52 = v52t2.getText().toString();
        String fi53 = v53t2.getText().toString();
        String fi54 = v54t2.getText().toString();
        String fi55 = v55t2.getText().toString();


        Map<String, Object> fin5 = new HashMap<>();

        fin5.put("урок1",fi51);
        fin5.put("урок2",fi52);
        fin5.put("урок3",fi53);
        fin5.put("урок4",fi54);
        fin5.put("урок5",fi55);


        time5.document("finish").set(fin5);








        Toast.makeText(this, "Данные успешно внесены", Toast.LENGTH_SHORT).show();




    }


    @SuppressLint("SetTextI18n")

    public void addstandarttime(){

        v11t.setText("8.00");v11t2.setText("9.20");
        v12t.setText("9.30");v12t2.setText("10.50");
        v13t.setText("11.00");v13t2.setText("12.20");
        v14t.setText("12.50");v14t2.setText("14.10");
        v15t.setText("14.20");v15t2.setText("15.40");


        v21t.setText("8.00"); v21t2.setText("9.20");
        v22t.setText("9.30"); v22t2.setText("10.50");
        v23t.setText("11.00"); v23t2.setText("12.20");
        v24t.setText("12.50"); v24t2.setText("14.10");
        v25t.setText("14.20"); v25t2.setText("15.40");

        v31t.setText("8.00"); v31t2.setText("9.20");
        v32t.setText("9.30"); v32t2.setText("10.50");
        v33t.setText("11.00"); v33t2.setText("12.20");
        v34t.setText("12.50"); v34t2.setText("14.10");
        v35t.setText("14.20"); v35t2.setText("15.40");

        v41t.setText("8.00"); v41t2.setText("9.20");
        v42t.setText("9.30"); v42t2.setText("10.50");
        v43t.setText("11.00"); v43t2.setText("12.20");
        v44t.setText("12.50"); v44t2.setText("14.10");
        v45t.setText("14.20"); v45t2.setText("15.40");

        v51t.setText("8.00"); v51t2.setText("9.20");
        v52t.setText("9.30"); v52t2.setText("10.50");
        v53t.setText("11.00"); v53t2.setText("12.20");
        v54t.setText("12.50"); v54t2.setText("14.10");
        v55t.setText("14.20"); v55t2.setText("15.40");

        v61t.setText("8.00"); v61t2.setText("9.20");
        v62t.setText("9.30"); v62t2.setText("10.50");
        v63t.setText("11.00"); v63t2.setText("12.20");
        v64t.setText("12.50"); v64t2.setText("14.10");
        v65t.setText("14.20"); v65t2.setText("15.40");


    }






    @SuppressLint("SetTextI18n")
    public void ddaddstandarttime(){

        v11t.setText("13.30");v11t2.setText("14.15");
        v12t.setText("14.20");v12t2.setText("15.05");
        v13t.setText("15.15");v13t2.setText("16.00");
        v14t.setText("16.10");v14t2.setText("16.55");
        v15t.setText("17.00");v15t2.setText("17.45");


        v21t.setText("13.30");v21t2.setText("14.15");
        v22t.setText("14.20");v22t2.setText("15.05");
        v23t.setText("15.15");v23t2.setText("16.00");
        v24t.setText("16.10");v24t2.setText("16.55");
        v25t.setText("17.00");v25t2.setText("17.45");


        v31t.setText("13.30");v31t2.setText("14.15");
        v32t.setText("14.20");v32t2.setText("15.05");
        v33t.setText("15.15");v33t2.setText("16.00");
        v34t.setText("16.10");v34t2.setText("16.55");
        v35t.setText("17.00");v35t2.setText("17.45");


        v41t.setText("13.30");v41t2.setText("14.15");
        v42t.setText("14.20");v42t2.setText("15.05");
        v43t.setText("15.15");v43t2.setText("16.00");
        v44t.setText("16.10");v44t2.setText("16.55");
        v45t.setText("17.00");v45t2.setText("17.45");


        v51t.setText("13.30");v51t2.setText("14.15");
        v52t.setText("14.20");v52t2.setText("15.05");
        v53t.setText("15.15");v53t2.setText("16.00");
        v54t.setText("16.10");v54t2.setText("16.55");
        v55t.setText("17.00");v55t2.setText("17.45");


        v61t.setText("13.30");v61t2.setText("14.15");
        v62t.setText("14.20");v62t2.setText("15.05");
        v63t.setText("15.15");v63t2.setText("16.00");
        v64t.setText("16.10");v64t2.setText("16.55");
        v65t.setText("17.00");v65t2.setText("17.45");


    }



    @SuppressLint("SetTextI18n")
    public void nul(){

        v11t.setText("");v11t2.setText("");
        v12t.setText("");v12t2.setText("");
        v13t.setText("");v13t2.setText("");
        v14t.setText("");v14t2.setText("");
        v15t.setText("");v15t2.setText("");


        v21t.setText("");v21t2.setText("");
        v22t.setText("");v22t2.setText("");
        v23t.setText("");v23t2.setText("");
        v24t.setText("");v24t2.setText("");
        v25t.setText("");v25t2.setText("");


        v31t.setText("");v31t2.setText("");
        v32t.setText("");v32t2.setText("");
        v33t.setText("");v33t2.setText("");
        v34t.setText("");v34t2.setText("");
        v35t.setText("");v35t2.setText("");


        v41t.setText("");v41t2.setText("");
        v42t.setText("");v42t2.setText("");
        v43t.setText("");v43t2.setText("");
        v44t.setText("");v44t2.setText("");
        v45t.setText("");v45t2.setText("");


        v51t.setText("");v51t2.setText("");
        v52t.setText("");v52t2.setText("");
        v53t.setText("");v53t2.setText("");
        v54t.setText("");v54t2.setText("");
        v55t.setText("");v55t2.setText("");


        v61t.setText("");v61t2.setText("");
        v62t.setText("");v62t2.setText("");
        v63t.setText("");v63t2.setText("");
        v64t.setText("");v64t2.setText("");
        v65t.setText("");v65t2.setText("");

    }

    public void right(View view) {
        Intent intent = new Intent(this, adminpanel4.class);
        startActivity(intent);
    }
}