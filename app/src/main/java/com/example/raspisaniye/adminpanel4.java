package com.example.raspisaniye;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class adminpanel4 extends AppCompatActivity {


    private String class_num;
    private String school_num;
    private String class_simbol;
    private String school_sity;

    String[] settime = {"1 смена","1 смена, пн сокрашенный","1 смена, пн сокрашенный, 2 кл.час","2 смена","2 смена, 2 кл.час","пусто"};

    FirebaseFirestore firestore;











    private EditText v11;
    private EditText v12;
    private EditText v13;
    private EditText v14;
    private EditText v15;
    private EditText v16;
    private EditText v17;

    private EditText v11t;
    private EditText v12t;
    private EditText v13t;
    private EditText v14t;
    private EditText v15t;
    private EditText v16t;
    private EditText v17t;

    private EditText v11t2;
    private EditText v12t2;
    private EditText v13t2;
    private EditText v14t2;
    private EditText v15t2;
    private EditText v16t2;
    private EditText v17t2;


    private EditText v21;
    private EditText v22;
    private EditText v23;
    private EditText v24;
    private EditText v25;
    private EditText v26;
    private EditText v27;

    private EditText v21t;
    private EditText v22t;
    private EditText v23t;
    private EditText v24t;
    private EditText v25t;
    private EditText v26t;
    private EditText v27t;

    private EditText v21t2;
    private EditText v22t2;
    private EditText v23t2;
    private EditText v24t2;
    private EditText v25t2;
    private EditText v26t2;
    private EditText v27t2;

    private EditText v31;
    private EditText v32;
    private EditText v33;
    private EditText v34;
    private EditText v35;
    private EditText v36;
    private EditText v37;

    private EditText v31t;
    private EditText v32t;
    private EditText v33t;
    private EditText v34t;
    private EditText v35t;
    private EditText v36t;
    private EditText v37t;

    private EditText v31t2;
    private EditText v32t2;
    private EditText v33t2;
    private EditText v34t2;
    private EditText v35t2;
    private EditText v36t2;
    private EditText v37t2;

    private EditText v41;
    private EditText v42;
    private EditText v43;
    private EditText v44;
    private EditText v45;
    private EditText v46;
    private EditText v47;

    private EditText v41t;
    private EditText v42t;
    private EditText v43t;
    private EditText v44t;
    private EditText v45t;
    private EditText v46t;
    private EditText v47t;

    private EditText v41t2;
    private EditText v42t2;
    private EditText v43t2;
    private EditText v44t2;
    private EditText v45t2;
    private EditText v46t2;
    private EditText v47t2;

    private EditText v51;
    private EditText v52;
    private EditText v53;
    private EditText v54;
    private EditText v55;
    private EditText v56;
    private EditText v57;

    private EditText v51t;
    private EditText v52t;
    private EditText v53t;
    private EditText v54t;
    private EditText v55t;
    private EditText v56t;
    private EditText v57t;

    private EditText v51t2;
    private EditText v52t2;
    private EditText v53t2;
    private EditText v54t2;
    private EditText v55t2;
    private EditText v56t2;
    private EditText v57t2;

    private EditText v61;
    private EditText v62;
    private EditText v63;
    private EditText v64;
    private EditText v65;
    private EditText v66;
    private EditText v67;

    private EditText v61t;
    private EditText v62t;
    private EditText v63t;
    private EditText v64t;
    private EditText v65t;
    private EditText v66t;
    private EditText v67t;

    private EditText v61t2;
    private EditText v62t2;
    private EditText v63t2;
    private EditText v64t2;
    private EditText v65t2;
    private EditText v66t2;
    private EditText v67t2;


    public void init(){









        v11 = findViewById(R.id.v11);
        v12 = findViewById(R.id.v12);
        v13 = findViewById(R.id.v13);
        v14 = findViewById(R.id.v14);
        v15 = findViewById(R.id.v15);
        v16 = findViewById(R.id.v16);
        v17 = findViewById(R.id.v17);

        v11t = findViewById(R.id.v11t);
        v12t = findViewById(R.id.v12t);
        v13t = findViewById(R.id.v13t);
        v14t = findViewById(R.id.v14t);
        v15t = findViewById(R.id.v15t);
        v16t = findViewById(R.id.v16t);
        v17t = findViewById(R.id.v17t);

        v11t2 = findViewById(R.id.v11t2);
        v12t2 = findViewById(R.id.v12t2);
        v13t2 = findViewById(R.id.v13t2);
        v14t2 = findViewById(R.id.v14t2);
        v15t2 = findViewById(R.id.v15t2);
        v16t2 = findViewById(R.id.v16t2);
        v17t2 = findViewById(R.id.v17t2);


        v21 = findViewById(R.id.v21);
        v22 = findViewById(R.id.v22);
        v23 = findViewById(R.id.v23);
        v24 = findViewById(R.id.v24);
        v25 = findViewById(R.id.v25);
        v26 = findViewById(R.id.v26);
        v27 = findViewById(R.id.v27);

        v21t = findViewById(R.id.v21t);
        v22t = findViewById(R.id.v22t);
        v23t = findViewById(R.id.v23t);
        v24t = findViewById(R.id.v24t);
        v25t = findViewById(R.id.v25t);
        v26t = findViewById(R.id.v26t);
        v27t = findViewById(R.id.v27t);

        v21t2 = findViewById(R.id.v21t2);
        v22t2 = findViewById(R.id.v22t2);
        v23t2 = findViewById(R.id.v23t2);
        v24t2 = findViewById(R.id.v24t2);
        v25t2 = findViewById(R.id.v25t2);
        v26t2 = findViewById(R.id.v26t2);
        v27t2 = findViewById(R.id.v27t2);

        v31 = findViewById(R.id.v31);
        v32 = findViewById(R.id.v32);
        v33 = findViewById(R.id.v33);
        v34 = findViewById(R.id.v34);
        v35 = findViewById(R.id.v35);
        v36 = findViewById(R.id.v36);
        v37 = findViewById(R.id.v37);

        v31t = findViewById(R.id.v31t);
        v32t = findViewById(R.id.v32t);
        v33t = findViewById(R.id.v33t);
        v34t = findViewById(R.id.v34t);
        v35t = findViewById(R.id.v35t);
        v36t = findViewById(R.id.v36t);
        v37t = findViewById(R.id.v37t);

        v31t2 = findViewById(R.id.v31t2);
        v32t2 = findViewById(R.id.v32t2);
        v33t2 = findViewById(R.id.v33t2);
        v34t2 = findViewById(R.id.v34t2);
        v35t2 = findViewById(R.id.v35t2);
        v36t2 = findViewById(R.id.v36t2);
        v37t2 = findViewById(R.id.v37t2);

        v41 = findViewById(R.id.v41);
        v42 = findViewById(R.id.v42);
        v43 = findViewById(R.id.v43);
        v44 = findViewById(R.id.v44);
        v45 = findViewById(R.id.v45);
        v46 = findViewById(R.id.v46);
        v47 = findViewById(R.id.v47);

        v41t = findViewById(R.id.v41t);
        v42t = findViewById(R.id.v42t);
        v43t = findViewById(R.id.v43t);
        v44t = findViewById(R.id.v44t);
        v45t = findViewById(R.id.v45t);
        v46t = findViewById(R.id.v46t);
        v47t = findViewById(R.id.v47t);

        v41t2 = findViewById(R.id.v41t2);
        v42t2 = findViewById(R.id.v42t2);
        v43t2 = findViewById(R.id.v43t2);
        v44t2 = findViewById(R.id.v44t2);
        v45t2 = findViewById(R.id.v45t2);
        v46t2 = findViewById(R.id.v46t2);
        v47t2 = findViewById(R.id.v47t2);

        v51 = findViewById(R.id.v51);
        v52 = findViewById(R.id.v52);
        v53 = findViewById(R.id.v53);
        v54 = findViewById(R.id.v54);
        v55 = findViewById(R.id.v55);
        v56 = findViewById(R.id.v56);
        v57 = findViewById(R.id.v57);

        v51t = findViewById(R.id.v51t);
        v52t = findViewById(R.id.v52t);
        v53t = findViewById(R.id.v53t);
        v54t = findViewById(R.id.v54t);
        v55t = findViewById(R.id.v55t);
        v56t = findViewById(R.id.v56t);
        v57t = findViewById(R.id.v57t);

        v51t2 = findViewById(R.id.v51t2);
        v52t2 = findViewById(R.id.v52t2);
        v53t2 = findViewById(R.id.v53t2);
        v54t2 = findViewById(R.id.v54t2);
        v55t2 = findViewById(R.id.v55t2);
        v56t2 = findViewById(R.id.v56t2);
        v57t2 = findViewById(R.id.v57t2);

        v61 = findViewById(R.id.v61);
        v62 = findViewById(R.id.v62);
        v63 = findViewById(R.id.v63);
        v64 = findViewById(R.id.v64);
        v65 = findViewById(R.id.v65);
        v66 = findViewById(R.id.v66);
        v67 = findViewById(R.id.v67);

        v61t = findViewById(R.id.v61t);
        v62t = findViewById(R.id.v62t);
        v63t = findViewById(R.id.v63t);
        v64t = findViewById(R.id.v64t);
        v65t = findViewById(R.id.v65t);
        v66t = findViewById(R.id.v66t);
        v67t = findViewById(R.id.v67t);

        v61t2 = findViewById(R.id.v61t2);
        v62t2 = findViewById(R.id.v62t2);
        v63t2 = findViewById(R.id.v63t2);
        v64t2 = findViewById(R.id.v64t2);
        v65t2 = findViewById(R.id.v65t2);
        v66t2 = findViewById(R.id.v66t2);
        v67t2 = findViewById(R.id.v67t2);

    }

    public void intentimport(){

        Bundle arguments = getIntent().getExtras();
        school_num = arguments.get("school_num").toString();
        school_sity = arguments.get("school_sity").toString();
        class_num = arguments.get("class_num").toString();
        class_simbol = arguments.get("class_simbol").toString();


    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpanel4);



















        firestore = FirebaseFirestore.getInstance();

        init();
        intentimport();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, settime);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.spinnersity);
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
                if(selectedItem.equals("1 смена, пн сокрашенный")) {
                    addstandartpnplustime();
                    Toast.makeText(getApplicationContext(), "Время установленно", Toast.LENGTH_SHORT).show();

                }
                if(selectedItem.equals("1 смена, пн сокрашенный, 2 кл.час")) {
                    addstandartpnplusandkltime();
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
                if(selectedItem.equals("2 смена, 2 кл.час")) {
                    ddaddstandartkltime();
                    Toast.makeText(getApplicationContext(), "Время установленно", Toast.LENGTH_SHORT).show();

                }










            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });

    }

    public void addtobbase(View view){

        String pon = "понедельник";
        String vto = "вторник";
        String sre = "среда";
        String che = "четверг";
        String pat = "пятница";
        String sub = "суббота";



        CollectionReference cities = firestore.collection("sity").document(school_sity).collection(school_num).document(class_num).collection(class_simbol);

        String uruk11 = v11.getText().toString();
        String urok12 = v12.getText().toString();
        String urok13 = v13.getText().toString();
        String uruk14 = v14.getText().toString();
        String urok15 = v15.getText().toString();
        String urok16 = v16.getText().toString();
        String urok17 = v17.getText().toString();

        String uruk21 = v21.getText().toString();
        String urok22 = v22.getText().toString();
        String urok23 = v23.getText().toString();
        String uruk24 = v24.getText().toString();
        String urok25 = v25.getText().toString();
        String urok26 = v26.getText().toString();
        String urok27 = v27.getText().toString();

        String uruk31 = v31.getText().toString();
        String urok32 = v32.getText().toString();
        String urok33 = v33.getText().toString();
        String uruk34 = v34.getText().toString();
        String urok35 = v35.getText().toString();
        String urok36 = v36.getText().toString();
        String urok37 = v37.getText().toString();

        String uruk41 = v41.getText().toString();
        String urok42 = v42.getText().toString();
        String urok43 = v43.getText().toString();
        String uruk44 = v44.getText().toString();
        String urok45 = v45.getText().toString();
        String urok46 = v46.getText().toString();
        String urok47 = v47.getText().toString();

        String uruk51 = v51.getText().toString();
        String urok52 = v52.getText().toString();
        String urok53 = v53.getText().toString();
        String uruk54 = v54.getText().toString();
        String urok55 = v55.getText().toString();
        String urok56 = v56.getText().toString();
        String urok57 = v57.getText().toString();

        String uruk61 = v61.getText().toString();
        String urok62 = v62.getText().toString();
        String urok63 = v63.getText().toString();
        String uruk64 = v64.getText().toString();
        String urok65 = v65.getText().toString();
        String urok66 = v66.getText().toString();
        String urok67 = v67.getText().toString();




        Map<String, Object> user = new HashMap<>();

        user.put("урок1",uruk11);
        user.put("урок2",urok12);
        user.put("урок3",urok13);
        user.put("урок4",uruk14);
        user.put("урок5",urok15);
        user.put("урок6",urok16);
        user.put("урок7",urok17);

        cities.document(pon).set(user);


        Map<String, Object> user2 = new HashMap<>();

        user2.put("урок1",uruk21);
        user2.put("урок2",urok22);
        user2.put("урок3",urok23);
        user2.put("урок4",uruk24);
        user2.put("урок5",urok25);
        user2.put("урок6",urok26);
        user2.put("урок7",urok27);

        cities.document(vto).set(user2);


        Map<String, Object> user3 = new HashMap<>();

        user3.put("урок1",uruk31);
        user3.put("урок2",urok32);
        user3.put("урок3",urok33);
        user3.put("урок4",uruk34);
        user3.put("урок5",urok35);
        user3.put("урок6",urok36);
        user3.put("урок7",urok37);

        cities.document(sre).set(user3);


        Map<String, Object> user4 = new HashMap<>();

        user4.put("урок1",uruk41);
        user4.put("урок2",urok42);
        user4.put("урок3",urok43);
        user4.put("урок4",uruk44);
        user4.put("урок5",urok45);
        user4.put("урок6",urok46);
        user4.put("урок7",urok47);

        cities.document(che).set(user4);


        Map<String, Object> user5 = new HashMap<>();

        user5.put("урок1",uruk51);
        user5.put("урок2",urok52);
        user5.put("урок3",urok53);
        user5.put("урок4",uruk54);
        user5.put("урок5",urok55);
        user5.put("урок6",urok56);
        user5.put("урок7",urok57);

        cities.document(pat).set(user5);


        Map<String, Object> user6 = new HashMap<>();

        user6.put("урок1",uruk61);
        user6.put("урок2",urok62);
        user6.put("урок3",urok63);
        user6.put("урок4",uruk64);
        user6.put("урок5",urok65);
        user6.put("урок6",urok66);
        user6.put("урок7",urok67);

        cities.document(sub).set(user6);










        CollectionReference time6 = cities.document(sub).collection("time");

        String st61 = v61t.getText().toString();
        String st62 = v62t.getText().toString();
        String st63 = v63t.getText().toString();
        String st64 = v64t.getText().toString();
        String st65 = v65t.getText().toString();
        String st66 = v66t.getText().toString();
        String st67 = v67t.getText().toString();

        Map<String, Object> tim6 = new HashMap<>();

        tim6.put("урок1",st61);
        tim6.put("урок2",st62);
        tim6.put("урок3",st63);
        tim6.put("урок4",st64);
        tim6.put("урок5",st65);
        tim6.put("урок6",st66);
        tim6.put("урок7",st67);

        time6.document("start").set(tim6);

        String fi61 = v61t2.getText().toString();
        String fi62 = v62t2.getText().toString();
        String fi63 = v63t2.getText().toString();
        String fi64 = v64t2.getText().toString();
        String fi65 = v65t2.getText().toString();
        String fi66 = v66t2.getText().toString();
        String fi67 = v67t2.getText().toString();

        Map<String, Object> fin6 = new HashMap<>();

        fin6.put("урок1",fi61);
        fin6.put("урок2",fi62);
        fin6.put("урок3",fi63);
        fin6.put("урок4",fi64);
        fin6.put("урок5",fi65);
        fin6.put("урок6",fi66);
        fin6.put("урок7",fi67);

        time6.document("finish").set(fin6);







        CollectionReference time1 = cities.document(pon).collection("time");

        String st1 = v11t.getText().toString();
        String st2 = v12t.getText().toString();
        String st3 = v13t.getText().toString();
        String st4 = v14t.getText().toString();
        String st5 = v15t.getText().toString();
        String st6 = v16t.getText().toString();
        String st7 = v17t.getText().toString();

        Map<String, Object> tim1 = new HashMap<>();

        tim1.put("урок1",st1);
        tim1.put("урок2",st2);
        tim1.put("урок3",st3);
        tim1.put("урок4",st4);
        tim1.put("урок5",st5);
        tim1.put("урок6",st6);
        tim1.put("урок7",st7);

        time1.document("start").set(tim1);

        String fi1 = v11t2.getText().toString();
        String fi2 = v12t2.getText().toString();
        String fi3 = v13t2.getText().toString();
        String fi4 = v14t2.getText().toString();
        String fi5 = v15t2.getText().toString();
        String fi6 = v16t2.getText().toString();
        String fi7 = v17t2.getText().toString();

        Map<String, Object> fin1 = new HashMap<>();

        fin1.put("урок1",fi1);
        fin1.put("урок2",fi2);
        fin1.put("урок3",fi3);
        fin1.put("урок4",fi4);
        fin1.put("урок5",fi5);
        fin1.put("урок6",fi6);
        fin1.put("урок7",fi7);

        time1.document("finish").set(fin1);








        CollectionReference time2 = cities.document(vto).collection("time");

        String st21 = v21t.getText().toString();
        String st22 = v22t.getText().toString();
        String st23 = v23t.getText().toString();
        String st24 = v24t.getText().toString();
        String st25 = v25t.getText().toString();
        String st26 = v26t.getText().toString();
        String st27 = v27t.getText().toString();

        Map<String, Object> tim2 = new HashMap<>();

        tim2.put("урок1",st21);
        tim2.put("урок2",st22);
        tim2.put("урок3",st23);
        tim2.put("урок4",st24);
        tim2.put("урок5",st25);
        tim2.put("урок6",st26);
        tim2.put("урок7",st27);

        time2.document("start").set(tim2);

        String fi21 = v21t2.getText().toString();
        String fi22 = v22t2.getText().toString();
        String fi23 = v23t2.getText().toString();
        String fi24 = v24t2.getText().toString();
        String fi25 = v25t2.getText().toString();
        String fi26 = v26t2.getText().toString();
        String fi27 = v27t2.getText().toString();

        Map<String, Object> fin2 = new HashMap<>();

        fin2.put("урок1",fi21);
        fin2.put("урок2",fi22);
        fin2.put("урок3",fi23);
        fin2.put("урок4",fi24);
        fin2.put("урок5",fi25);
        fin2.put("урок6",fi26);
        fin2.put("урок7",fi27);

        time2.document("finish").set(fin2);











        CollectionReference time3 = cities.document(sre).collection("time");

        String st31 = v31t.getText().toString();
        String st32 = v32t.getText().toString();
        String st33 = v33t.getText().toString();
        String st34 = v34t.getText().toString();
        String st35 = v35t.getText().toString();
        String st36 = v36t.getText().toString();
        String st37 = v37t.getText().toString();

        Map<String, Object> tim3 = new HashMap<>();

        tim3.put("урок1",st31);
        tim3.put("урок2",st32);
        tim3.put("урок3",st33);
        tim3.put("урок4",st34);
        tim3.put("урок5",st35);
        tim3.put("урок6",st36);
        tim3.put("урок7",st37);

        time3.document("start").set(tim3);

        String fi31 = v31t2.getText().toString();
        String fi32 = v32t2.getText().toString();
        String fi33 = v33t2.getText().toString();
        String fi34 = v34t2.getText().toString();
        String fi35 = v35t2.getText().toString();
        String fi36 = v36t2.getText().toString();
        String fi37 = v37t2.getText().toString();

        Map<String, Object> fin3 = new HashMap<>();

        fin3.put("урок1",fi31);
        fin3.put("урок2",fi32);
        fin3.put("урок3",fi33);
        fin3.put("урок4",fi34);
        fin3.put("урок5",fi35);
        fin3.put("урок6",fi36);
        fin3.put("урок7",fi37);

        time3.document("finish").set(fin3);











        CollectionReference time4 = cities.document(che).collection("time");

        String st41 = v41t.getText().toString();
        String st42 = v42t.getText().toString();
        String st43 = v43t.getText().toString();
        String st44 = v44t.getText().toString();
        String st45 = v45t.getText().toString();
        String st46 = v46t.getText().toString();
        String st47 = v47t.getText().toString();

        Map<String, Object> tim4 = new HashMap<>();

        tim4.put("урок1",st41);
        tim4.put("урок2",st42);
        tim4.put("урок3",st43);
        tim4.put("урок4",st44);
        tim4.put("урок5",st45);
        tim4.put("урок6",st46);
        tim4.put("урок7",st47);

        time4.document("start").set(tim4);

        String fi41 = v41t2.getText().toString();
        String fi42 = v42t2.getText().toString();
        String fi43 = v43t2.getText().toString();
        String fi44 = v44t2.getText().toString();
        String fi45 = v45t2.getText().toString();
        String fi46 = v46t2.getText().toString();
        String fi47 = v47t2.getText().toString();

        Map<String, Object> fin4 = new HashMap<>();

        fin4.put("урок1",fi41);
        fin4.put("урок2",fi42);
        fin4.put("урок3",fi43);
        fin4.put("урок4",fi44);
        fin4.put("урок5",fi45);
        fin4.put("урок6",fi46);
        fin4.put("урок7",fi47);

        time4.document("finish").set(fin4);













        CollectionReference time5 = cities.document(pat).collection("time");

        String st51 = v51t.getText().toString();
        String st52 = v52t.getText().toString();
        String st53 = v53t.getText().toString();
        String st54 = v54t.getText().toString();
        String st55 = v55t.getText().toString();
        String st56 = v56t.getText().toString();
        String st57 = v57t.getText().toString();

        Map<String, Object> tim5 = new HashMap<>();

        tim5.put("урок1",st51);
        tim5.put("урок2",st52);
        tim5.put("урок3",st53);
        tim5.put("урок4",st54);
        tim5.put("урок5",st55);
        tim5.put("урок6",st56);
        tim5.put("урок7",st57);

        time5.document("start").set(tim5);

        String fi51 = v51t2.getText().toString();
        String fi52 = v52t2.getText().toString();
        String fi53 = v53t2.getText().toString();
        String fi54 = v54t2.getText().toString();
        String fi55 = v55t2.getText().toString();
        String fi56 = v56t2.getText().toString();
        String fi57 = v57t2.getText().toString();

        Map<String, Object> fin5 = new HashMap<>();

        fin5.put("урок1",fi51);
        fin5.put("урок2",fi52);
        fin5.put("урок3",fi53);
        fin5.put("урок4",fi54);
        fin5.put("урок5",fi55);
        fin5.put("урок6",fi56);
        fin5.put("урок7",fi57);

        time5.document("finish").set(fin5);








        Toast.makeText(this, "Данные успешно внесены", Toast.LENGTH_SHORT).show();



        //Intent intent = new Intent(addschoollesons.this, MainActivity2.class);
        //startActivity(intent);



    }


    @SuppressLint("SetTextI18n")

    public void addstandarttime(){

        v11t.setText("8.00");v11t2.setText("8.45");
        v12t.setText("8.50");v12t2.setText("9.35");
        v13t.setText("9.50");v13t2.setText("10.35");
        v14t.setText("10.45");v14t2.setText("11.30");
        v15t.setText("11.40");v15t2.setText("12.25");
        v16t.setText("12.30");v16t2.setText("13.15");
        v17t.setText("13.20");v17t2.setText("14.05");

        v21t.setText("8.00");v21t2.setText("8.45");
        v22t.setText("8.50");v22t2.setText("9.35");
        v23t.setText("9.50");v23t2.setText("10.35");
        v24t.setText("10.45");v24t2.setText("11.30");
        v25t.setText("11.40");v25t2.setText("12.25");
        v26t.setText("12.30");v26t2.setText("13.15");
        v27t.setText("13.20");v27t2.setText("14.05");

        v31t.setText("8.00");v31t2.setText("8.45");
        v32t.setText("8.50");v32t2.setText("9.35");
        v33t.setText("9.50");v33t2.setText("10.35");
        v34t.setText("10.45");v34t2.setText("11.30");
        v35t.setText("11.40");v35t2.setText("12.25");
        v36t.setText("12.30");v36t2.setText("13.15");
        v37t.setText("13.20");v37t2.setText("14.05");

        v41t.setText("8.00");v41t2.setText("8.45");
        v42t.setText("8.50");v42t2.setText("9.35");
        v43t.setText("9.50");v43t2.setText("10.35");
        v44t.setText("10.45");v44t2.setText("11.30");
        v45t.setText("11.40");v45t2.setText("12.25");
        v46t.setText("12.30");v46t2.setText("13.15");
        v47t.setText("13.20");v47t2.setText("14.05");

        v51t.setText("8.00");v51t2.setText("8.45");
        v52t.setText("8.50");v52t2.setText("9.35");
        v53t.setText("9.50");v53t2.setText("10.35");
        v54t.setText("10.45");v54t2.setText("11.30");
        v55t.setText("11.40");v55t2.setText("12.25");
        v56t.setText("12.30");v56t2.setText("13.15");
        v57t.setText("13.20");v57t2.setText("14.05");

        v61t.setText("8.00");v61t2.setText("8.45");
        v62t.setText("8.50");v62t2.setText("9.35");
        v63t.setText("9.50");v63t2.setText("10.35");
        v64t.setText("10.45");v64t2.setText("11.30");
        v65t.setText("11.40");v65t2.setText("12.25");
        v66t.setText("12.30");v66t2.setText("13.15");
        v67t.setText("13.20");v67t2.setText("14.05");

    }

    @SuppressLint("SetTextI18n")
    public void addstandartpnplustime(){

        v11t.setText("8.00");v11t2.setText("8.40");
        v12t.setText("8.45");v12t2.setText("9.25");
        v13t.setText("9.30");v13t2.setText("10.10");
        v14t.setText("10.20");v14t2.setText("11.00");
        v15t.setText("11.10");v15t2.setText("11.50");
        v16t.setText("11.55");v16t2.setText("12.35");
        v17t.setText("12.40");v17t2.setText("13.20");

        v21t.setText("8.00");v21t2.setText("8.45");
        v22t.setText("8.50");v22t2.setText("9.35");
        v23t.setText("9.50");v23t2.setText("10.35");
        v24t.setText("10.45");v24t2.setText("11.30");
        v25t.setText("11.40");v25t2.setText("12.25");
        v26t.setText("12.30");v26t2.setText("13.15");
        v27t.setText("13.20");v27t2.setText("14.05");

        v31t.setText("8.00");v31t2.setText("8.45");
        v32t.setText("8.50");v32t2.setText("9.35");
        v33t.setText("9.50");v33t2.setText("10.35");
        v34t.setText("10.45");v34t2.setText("11.30");
        v35t.setText("11.40");v35t2.setText("12.25");
        v36t.setText("12.30");v36t2.setText("13.15");
        v37t.setText("13.20");v37t2.setText("14.05");

        v41t.setText("8.00");v41t2.setText("8.45");
        v42t.setText("8.50");v42t2.setText("9.35");
        v43t.setText("9.50");v43t2.setText("10.35");
        v44t.setText("10.45");v44t2.setText("11.30");
        v45t.setText("11.40");v45t2.setText("12.25");
        v46t.setText("12.30");v46t2.setText("13.15");
        v47t.setText("13.20");v47t2.setText("14.05");

        v51t.setText("8.00");v51t2.setText("8.45");
        v52t.setText("8.50");v52t2.setText("9.35");
        v53t.setText("9.50");v53t2.setText("10.35");
        v54t.setText("10.45");v54t2.setText("11.30");
        v55t.setText("11.40");v55t2.setText("12.25");
        v56t.setText("12.30");v56t2.setText("13.15");
        v57t.setText("13.20");v57t2.setText("14.05");

        v61t.setText("8.00");v61t2.setText("8.45");
        v62t.setText("8.50");v62t2.setText("9.35");
        v63t.setText("9.50");v63t2.setText("10.35");
        v64t.setText("10.45");v64t2.setText("11.30");
        v65t.setText("11.40");v65t2.setText("12.25");
        v66t.setText("12.30");v66t2.setText("13.15");
        v67t.setText("13.20");v67t2.setText("14.05");

    }

    @SuppressLint("SetTextI18n")
    public void addstandartpnplusandkltime(){

        v11t.setText("8.00");v11t2.setText("8.40");
        v12t.setText("8.45");v12t2.setText("9.25");
        v13t.setText("9.30");v13t2.setText("10.10");
        v14t.setText("10.20");v14t2.setText("11.00");
        v15t.setText("11.10");v15t2.setText("11.50");
        v16t.setText("11.55");v16t2.setText("12.35");
        v17t.setText("12.40");v17t2.setText("13.20");

        v21t.setText("8.00");v21t2.setText("8.20");
        v22t.setText("8.25");v22t2.setText("9.10");
        v23t.setText("9.15");v23t2.setText("10.00");
        v24t.setText("10.10");v24t2.setText("10.55");
        v25t.setText("11.05");v25t2.setText("11.45");
        v26t.setText("11.50");v26t2.setText("12.30");
        v27t.setText("12.35");v27t2.setText("13.15");

        v31t.setText("8.00");v31t2.setText("8.45");
        v32t.setText("8.50");v32t2.setText("9.35");
        v33t.setText("9.50");v33t2.setText("10.35");
        v34t.setText("10.45");v34t2.setText("11.30");
        v35t.setText("11.40");v35t2.setText("12.25");
        v36t.setText("12.30");v36t2.setText("13.15");
        v37t.setText("13.20");v37t2.setText("14.05");

        v41t.setText("8.00");v41t2.setText("8.45");
        v42t.setText("8.50");v42t2.setText("9.35");
        v43t.setText("9.50");v43t2.setText("10.35");
        v44t.setText("10.45");v44t2.setText("11.30");
        v45t.setText("11.40");v45t2.setText("12.25");
        v46t.setText("12.30");v46t2.setText("13.15");
        v47t.setText("13.20");v47t2.setText("14.05");

        v51t.setText("8.00");v51t2.setText("8.45");
        v52t.setText("8.50");v52t2.setText("9.35");
        v53t.setText("9.50");v53t2.setText("10.35");
        v54t.setText("10.45");v54t2.setText("11.30");
        v55t.setText("11.40");v55t2.setText("12.25");
        v56t.setText("12.30");v56t2.setText("13.15");
        v57t.setText("13.20");v57t2.setText("14.05");

        v61t.setText("8.00");v61t2.setText("8.45");
        v62t.setText("8.50");v62t2.setText("9.35");
        v63t.setText("9.50");v63t2.setText("10.35");
        v64t.setText("10.45");v64t2.setText("11.30");
        v65t.setText("11.40");v65t2.setText("12.25");
        v66t.setText("12.30");v66t2.setText("13.15");
        v67t.setText("13.20");v67t2.setText("14.05");
    }


    @SuppressLint("SetTextI18n")
    public void ddaddstandarttime(){

        v11t.setText("13.30");v11t2.setText("14.15");
        v12t.setText("14.20");v12t2.setText("15.05");
        v13t.setText("15.15");v13t2.setText("16.00");
        v14t.setText("16.10");v14t2.setText("16.55");
        v15t.setText("17.00");v15t2.setText("17.45");
        v16t.setText("17.50");v16t2.setText("18.35");
        v17t.setText("18.40");v17t2.setText("19.25");

        v21t.setText("13.30");v21t2.setText("14.15");
        v22t.setText("14.20");v22t2.setText("15.05");
        v23t.setText("15.15");v23t2.setText("16.00");
        v24t.setText("16.10");v24t2.setText("16.55");
        v25t.setText("17.00");v25t2.setText("17.45");
        v26t.setText("17.50");v26t2.setText("18.35");
        v27t.setText("18.40");v27t2.setText("19.25");

        v31t.setText("13.30");v31t2.setText("14.15");
        v32t.setText("14.20");v32t2.setText("15.05");
        v33t.setText("15.15");v33t2.setText("16.00");
        v34t.setText("16.10");v34t2.setText("16.55");
        v35t.setText("17.00");v35t2.setText("17.45");
        v36t.setText("17.50");v36t2.setText("18.35");
        v37t.setText("18.40");v37t2.setText("19.25");

        v41t.setText("13.30");v41t2.setText("14.15");
        v42t.setText("14.20");v42t2.setText("15.05");
        v43t.setText("15.15");v43t2.setText("16.00");
        v44t.setText("16.10");v44t2.setText("16.55");
        v45t.setText("17.00");v45t2.setText("17.45");
        v46t.setText("17.50");v46t2.setText("18.35");
        v47t.setText("18.40");v47t2.setText("19.25");

        v51t.setText("13.30");v51t2.setText("14.15");
        v52t.setText("14.20");v52t2.setText("15.05");
        v53t.setText("15.15");v53t2.setText("16.00");
        v54t.setText("16.10");v54t2.setText("16.55");
        v55t.setText("17.00");v55t2.setText("17.45");
        v56t.setText("17.50");v56t2.setText("18.35");
        v57t.setText("18.40");v57t2.setText("19.25");

        v61t.setText("13.30");v61t2.setText("14.15");
        v62t.setText("14.20");v62t2.setText("15.05");
        v63t.setText("15.15");v63t2.setText("16.00");
        v64t.setText("16.10");v64t2.setText("16.55");
        v65t.setText("17.00");v65t2.setText("17.45");
        v66t.setText("17.50");v66t2.setText("18.35");
        v67t.setText("18.40");v67t2.setText("19.25");

    }

    @SuppressLint("SetTextI18n")
    public void ddaddstandartkltime(){

        v11t.setText("13.30");v11t2.setText("14.15");
        v12t.setText("14.20");v12t2.setText("15.05");
        v13t.setText("15.15");v13t2.setText("16.00");
        v14t.setText("16.10");v14t2.setText("16.55");
        v15t.setText("17.00");v15t2.setText("17.45");
        v16t.setText("17.50");v16t2.setText("18.35");
        v17t.setText("18.40");v17t2.setText("19.25");

        v21t.setText("13.30");v21t2.setText("13.50");
        v22t.setText("13.55");v22t2.setText("14.35");
        v23t.setText("14.40");v23t2.setText("15.20");
        v24t.setText("15.30");v24t2.setText("16.10");
        v25t.setText("16.20");v25t2.setText("17.00");
        v26t.setText("17.10");v26t2.setText("17.50");
        v27t.setText("17.55");v27t2.setText("18.35");

        v31t.setText("13.30");v31t2.setText("14.15");
        v32t.setText("14.20");v32t2.setText("15.05");
        v33t.setText("15.15");v33t2.setText("16.00");
        v34t.setText("16.10");v34t2.setText("16.55");
        v35t.setText("17.00");v35t2.setText("17.45");
        v36t.setText("17.50");v36t2.setText("18.35");
        v37t.setText("18.40");v37t2.setText("19.25");

        v41t.setText("13.30");v41t2.setText("14.15");
        v42t.setText("14.20");v42t2.setText("15.05");
        v43t.setText("15.15");v43t2.setText("16.00");
        v44t.setText("16.10");v44t2.setText("16.55");
        v45t.setText("17.00");v45t2.setText("17.45");
        v46t.setText("17.50");v46t2.setText("18.35");
        v47t.setText("18.40");v47t2.setText("19.25");

        v51t.setText("13.30");v51t2.setText("14.15");
        v52t.setText("14.20");v52t2.setText("15.05");
        v53t.setText("15.15");v53t2.setText("16.00");
        v54t.setText("16.10");v54t2.setText("16.55");
        v55t.setText("17.00");v55t2.setText("17.45");
        v56t.setText("17.50");v56t2.setText("18.35");
        v57t.setText("18.40");v57t2.setText("19.25");

        v61t.setText("13.30");v61t2.setText("14.15");
        v62t.setText("14.20");v62t2.setText("15.05");
        v63t.setText("15.15");v63t2.setText("16.00");
        v64t.setText("16.10");v64t2.setText("16.55");
        v65t.setText("17.00");v65t2.setText("17.45");
        v66t.setText("17.50");v66t2.setText("18.35");
        v67t.setText("18.40");v67t2.setText("19.25");

    }


    @SuppressLint("SetTextI18n")
    public void nul(){

        v11t.setText("");v11t2.setText("");
        v12t.setText("");v12t2.setText("");
        v13t.setText("");v13t2.setText("");
        v14t.setText("");v14t2.setText("");
        v15t.setText("");v15t2.setText("");
        v16t.setText("");v16t2.setText("");
        v17t.setText("");v17t2.setText("");

        v21t.setText("");v21t2.setText("");
        v22t.setText("");v22t2.setText("");
        v23t.setText("");v23t2.setText("");
        v24t.setText("");v24t2.setText("");
        v25t.setText("");v25t2.setText("");
        v26t.setText("");v26t2.setText("");
        v27t.setText("");v27t2.setText("");

        v31t.setText("");v31t2.setText("");
        v32t.setText("");v32t2.setText("");
        v33t.setText("");v33t2.setText("");
        v34t.setText("");v34t2.setText("");
        v35t.setText("");v35t2.setText("");
        v36t.setText("");v36t2.setText("");
        v37t.setText("");v37t2.setText("");

        v41t.setText("");v41t2.setText("");
        v42t.setText("");v42t2.setText("");
        v43t.setText("");v43t2.setText("");
        v44t.setText("");v44t2.setText("");
        v45t.setText("");v45t2.setText("");
        v46t.setText("");v46t2.setText("");
        v47t.setText("");v47t2.setText("");

        v51t.setText("");v51t2.setText("");
        v52t.setText("");v52t2.setText("");
        v53t.setText("");v53t2.setText("");
        v54t.setText("");v54t2.setText("");
        v55t.setText("");v55t2.setText("");
        v56t.setText("");v56t2.setText("");
        v57t.setText("");v57t2.setText("");

        v61t.setText("");v61t2.setText("");
        v62t.setText("");v62t2.setText("");
        v63t.setText("");v63t2.setText("");
        v64t.setText("");v64t2.setText("");
        v65t.setText("");v65t2.setText("");
        v66t.setText("");v66t2.setText("");
        v67t.setText("");v67t2.setText("");
    }
}