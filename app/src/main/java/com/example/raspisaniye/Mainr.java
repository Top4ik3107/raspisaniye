package com.example.raspisaniye;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;
import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Mainr extends AppCompatActivity {
    FirebaseFirestore firestore;
    private SharedPreferences pref;

    private String t11, t12, t13, t14, t15, t16, t17;
    private String t21, t22, t23, t24, t25, t26, t27;
    private String t11f, t12f, t13f, t14f, t15f, t16f, t17f;
    private String t21f, t22f, t23f, t24f, t25f, t26f, t27f;

    private TextView tt11, tt12, tt13, tt14, tt15, tt16, tt17;
    private TextView tt21, tt22, tt23, tt24, tt25, tt26, tt27;

    private TextView[] todayLessons, tomorrowLessons;
    private TextView classTextView, schoolTextView;

    private String year;
    private String group;
    private String college;


    private String timeRange11;
    private String timeRange12;
    private String timeRange13;
    private String timeRange14;
    private String timeRange15;
    private String timeRange16;
    private String timeRange17;

    private String timeRange21;
    private String timeRange22;
    private String timeRange23;
    private String timeRange24;
    private String timeRange25;
    private String timeRange26;
    private String timeRange27;





    private String day;
    private String sityw, schoolw, claccw, simbolw;
    private DocumentReference dd, gg, ddt, ddf, ddt2, ddf2;

    private int pendingTasks = 0;
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
        group = pref.getString("AddedGroup","p1a");
        year = pref.getString("AddedYear","Year1");
        college = pref.getString("AddedCollege","test");
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
                finishAffinity();
            }
        };

        // Регистрация обработчика
        getOnBackPressedDispatcher().addCallback(this, callback);
        testgo();





    }
    private void initUI() {
//        schoolTextView = findViewById(R.id.textView);
//        classTextView = findViewById(R.id.clacs);

        todayLessons = new TextView[]{
                findViewById(R.id.spred1), findViewById(R.id.spred2), findViewById(R.id.spred3),
                findViewById(R.id.spred4), findViewById(R.id.spred5),
        };

        tomorrowLessons = new TextView[]{
                findViewById(R.id.pred1), findViewById(R.id.pred2), findViewById(R.id.pred3),
                findViewById(R.id.pred4), findViewById(R.id.pred5)
        };

        tt11 = findViewById(R.id.stime1);
        tt12 = findViewById(R.id.stime2);
        tt13 = findViewById(R.id.stime3);
        tt14 = findViewById(R.id.stime4);
        tt15 = findViewById(R.id.stime5);


        tt21 = findViewById(R.id.time1);
        tt22 = findViewById(R.id.time2);
        tt23 = findViewById(R.id.time3);
        tt24 = findViewById(R.id.time4);
        tt25 = findViewById(R.id.time5);

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
    public void CloseMenu(View view){

        FrameLayout frameLayout = findViewById(R.id.pan);
        frameLayout.removeAllViews();

    }




    public void GoToAdmPass(View view) {
        Intent intent = new Intent(this, adminpanelPassword.class);
        startActivity(intent);
    }
    public void GoToSelColl(View view) {
        Intent intent = new Intent(this, ViborRassilkiActivity.class);
        startActivity(intent);
    }







    private void testgo() {
        pref = getSharedPreferences("data", MODE_PRIVATE);
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
        initUI();
        dayfind();
        initializeFirestoreReferences();
        updateUIWithFirestoreData();
//        updateClassAndSchoolTextViews();
        initTime();

    }
    public static String getCurrentWeekType() {
        // Получаем текущую дату
        Calendar calendar = Calendar.getInstance();

        // Получаем номер недели в году (от 1 до 52)
        int weekNumber = calendar.get(Calendar.WEEK_OF_YEAR);

        // Определяем, четная неделя или нечетная
        return (weekNumber % 2 == 0) ? "lessons2" : "lessons";
    }
    private void dayfind() {
        int dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
            case Calendar.MONDAY:
                day = "1";
                break;
            case Calendar.TUESDAY:
                day = "2";
                break;
            case Calendar.WEDNESDAY:
                day = "3";
                break;
            case Calendar.THURSDAY:
                day = "4";
                break;
            case Calendar.FRIDAY:
                day = "5";
                break;
            case Calendar.SATURDAY:
                day = "6";
                break;
            case Calendar.SUNDAY:
                day = "7";
                break;
        }
    }
    private void initializeFirestoreReferences() {
        CollectionReference clacc = firestore.collection("College").document(college).collection("Year").document(year).collection("group").document(group).collection(getCurrentWeekType());

        switch (day) {
            case "1":
                dd = clacc.document("понедельник");
                gg = clacc.document("вторник");
                break;
            case "2":
                dd = clacc.document("вторник");
                gg = clacc.document("среда");
                break;
            case "3":
                dd = clacc.document("среда");
                gg = clacc.document("четверг");
                break;
            case "4":
                dd = clacc.document("четверг");
                gg = clacc.document("пятница");
                break;
            case "5":
                dd = clacc.document("пятница");
                gg = clacc.document("суббота");
                break;
            case "6":
                dd = clacc.document("суббота");
                gg = clacc.document("воскресенье");
                break;
            case "7":
                dd = clacc.document("воскресенье");
                gg = clacc.document("понедельник");
                break;
        }
    }

    private void updateUIWithFirestoreData() {
        if ("7".equals(day)) {
            updateTextViews(todayLessons, "");
        } else {
            updateLessonsFromFirestore(dd, todayLessons);
        }

        if ("6".equals(day)) {
            updateTextViews(tomorrowLessons, "");
        } else {
                       updateLessonsFromFirestore(gg, tomorrowLessons);
        }
    }

    private void updateLessonsFromFirestore(DocumentReference docRef, TextView[] textViews) {
        if (textViews == null || textViews.length == 0) {
           // showToast("Ошибка: массив textViews не инициализирован или пуст");
            return;
        }

        pendingTasks++;
        docRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document != null && document.exists()) {
                    for (int i = 0; i < textViews.length; i++) {
                        String lessonKey = "урок" + (i + 1);
                        String lesson = document.getString(lessonKey);
                        if (lesson != null && !lesson.isEmpty()) {
                            textViews[i].setText(lesson);
                        } else {
                            textViews[i].setText("");
//                            showToast("Урок " + (i + 1) + " не найден в документе");
                        }
                    }
                } else {
                    //showToast("Документ отсутствует или не существует: " + (document != null ? document.getId() : "null"));
                }
            } else {
                Exception exception = task.getException();
               // showToast("Ошибка выполнения запроса: " + (exception != null ? exception.getMessage() : "неизвестная ошибка"));
            }
            pendingTasks--;
            checkPendingTasks();
        });
    }

    private void updateTextViews(TextView[] textViews, String text) {
        for (TextView textView : textViews) {
            textView.setText(text);
        }
    }

//    private void updateClassAndSchoolTextViews() {
//        classTextView.setText(claccw + simbolw);
//        schoolTextView.setText("School №" + schoolw);
//    }

    private void initTime() {
        CollectionReference clacc = firestore.collection("College").document(college).collection("Year").document(year).collection("group").document(group).collection(getCurrentWeekType());


        switch (day) {
            case "1":
                ddt = clacc.document("понедельник").collection("time").document("start");
                ddf = clacc.document("вторник").collection("time").document("finish");
                ddt2 = clacc.document("понедельник").collection("time").document("finish");
                ddf2 = clacc.document("вторник").collection("time").document("start");
                break;
            case "2":
                ddt = clacc.document("вторник").collection("time").document("start");
                ddf = clacc.document("среда").collection("time").document("finish");
                ddt2 = clacc.document("вторник").collection("time").document("finish");
                ddf2 = clacc.document("среда").collection("time").document("start");
                break;
            case "3":
                ddt = clacc.document("среда").collection("time").document("start");
                ddf = clacc.document("четверг").collection("time").document("finish");
                ddt2 = clacc.document("среда").collection("time").document("finish");
                ddf2 = clacc.document("четверг").collection("time").document("start");
                break;
            case "4":
                ddt = clacc.document("четверг").collection("time").document("start");
                ddf = clacc.document("пятница").collection("time").document("finish");
                ddt2 = clacc.document("четверг").collection("time").document("finish");
                ddf2 = clacc.document("пятница").collection("time").document("start");
                break;
            case "5":
                ddt = clacc.document("пятница").collection("time").document("start");
                ddf = clacc.document("суббота").collection("time").document("finish");
                ddt2 = clacc.document("пятница").collection("time").document("finish");
                ddf2 = clacc.document("суббота").collection("time").document("start");
                break;
            case "6":
                ddt = clacc.document("суббота").collection("time").document("start");
                ddf = clacc.document("воскресенье").collection("time").document("finish");
                ddt2 = clacc.document("суббота").collection("time").document("finish");
                ddf2 = clacc.document("воскресенье").collection("time").document("start");
                break;
            case "7":
                ddt = clacc.document("воскресенье").collection("time").document("start");
                ddf = clacc.document("понедельник").collection("time").document("finish");
                ddt2 = clacc.document("воскресенье").collection("time").document("finish");
                ddf2 = clacc.document("понедельник").collection("time").document("start");
                break;
        }

        pendingTasks += 4;  // since we are initiating 4 async tasks

        ddt.get().addOnCompleteListener(this::handleTimeResponse1);
        ddf.get().addOnCompleteListener(this::handleTimeResponse2);
        ddt2.get().addOnCompleteListener(this::handleTimeResponse3);
        ddf2.get().addOnCompleteListener(this::handleTimeResponse4);
    }

    private void handleTimeResponse1(Task<DocumentSnapshot> task) {
        if (task.isSuccessful()) {
            DocumentSnapshot document = task.getResult();
            if (document != null && document.exists()) {
                t11 = document.getString("урок1");
                t12 = document.getString("урок2");
                t13 = document.getString("урок3");
                t14 = document.getString("урок4");
                t15 = document.getString("урок5");

            }
        } else {
           // showToast("Ошибка при выполнении запроса");
        }
        pendingTasks--;
        checkPendingTasks();
    }

    private void handleTimeResponse2(Task<DocumentSnapshot> task) {
        if (task.isSuccessful()) {
            DocumentSnapshot document = task.getResult();
            if (document != null && document.exists()) {
                t21 = document.getString("урок1");
                t22 = document.getString("урок2");
                t23 = document.getString("урок3");
                t24 = document.getString("урок4");
                t25 = document.getString("урок5");

            }
        } else {
           // showToast("Ошибка при выполнении запроса");
        }
        pendingTasks--;
        checkPendingTasks();
    }

    private void handleTimeResponse3(Task<DocumentSnapshot> task) {
        if (task.isSuccessful()) {
            DocumentSnapshot document = task.getResult();
            if (document != null && document.exists()) {
                t11f = document.getString("урок1");
                t12f = document.getString("урок2");
                t13f = document.getString("урок3");
                t14f = document.getString("урок4");
                t15f = document.getString("урок5");

            }
        } else {
           // showToast("Ошибка при выполнении запроса");
        }
        pendingTasks--;
        checkPendingTasks();
    }

    private void handleTimeResponse4(Task<DocumentSnapshot> task) {
        if (task.isSuccessful()) {
            DocumentSnapshot document = task.getResult();
            if (document != null && document.exists()) {
                t21f = document.getString("урок1");
                t22f = document.getString("урок2");
                t23f = document.getString("урок3");
                t24f = document.getString("урок4");
                t25f = document.getString("урок5");

            }
        } else {
           // showToast("Ошибка при выполнении запроса");
        }
        pendingTasks--;
        checkPendingTasks();
    }

    private void checkPendingTasks() {
        if (pendingTasks == 0) {
            timep();
        }
    }
    private String checkNull(String value) {
        return (value != null) ? value : "";
    }

    private void timep() {


        if (day.equals("6")) {

            t11 = checkNull(t11);
            t12 = checkNull(t12);
            t13 = checkNull(t13);
            t14 = checkNull(t14);
            t15 = checkNull(t15);

// Проверяем переменные от t11f до t15f
            t11f = checkNull(t11f);
            t12f = checkNull(t12f);
            t13f = checkNull(t13f);
            t14f = checkNull(t14f);
            t15f = checkNull(t15f);


            timeRange11 = t11 + "-" + t11f;
            timeRange12 = t12 + "-" + t12f;
            timeRange13 = t13 + "-" + t13f;
            timeRange14 = t14 + "-" + t14f;
            timeRange15 = t15 + "-" + t15f;


            timeRange21 = "-";
            timeRange22 = "-";
            timeRange23 = "-";
            timeRange24 = "-";
            timeRange25 = "-";


        } else if (day.equals("7")) {
            timeRange11 = "-";
            timeRange12 = "-";
            timeRange13 = "-";
            timeRange14 = "-";
            timeRange15 = "-";

            t21 = checkNull(t21);
            t22 = checkNull(t22);
            t23 = checkNull(t23);
            t24 = checkNull(t24);
            t25 = checkNull(t25);

            t21f = checkNull(t21f);
            t22f = checkNull(t22f);
            t23f = checkNull(t23f);
            t24f = checkNull(t24f);
            t25f = checkNull(t25f);

            timeRange21 = t21f + "-" + t21;
            timeRange22 = t22f + "-" + t22;
            timeRange23 = t23f + "-" + t23;
            timeRange24 = t24f + "-" + t24;
            timeRange25 = t25f + "-" + t25;


        } else {
            timeRange11 = t11 + "-" + t11f;
            timeRange12 = t12 + "-" + t12f;
            timeRange13 = t13 + "-" + t13f;
            timeRange14 = t14 + "-" + t14f;
            timeRange15 = t15 + "-" + t15f;


            timeRange21 = t21f + "-" + t21;
            timeRange22 = t22f + "-" + t22;
            timeRange23 = t23f + "-" + t23;
            timeRange24 = t24f + "-" + t24;
            timeRange25 = t25f + "-" + t25;

        }


        tt11.setText(timeRange11);
        tt12.setText(timeRange12);
        tt13.setText(timeRange13);
        tt14.setText(timeRange14);
        tt15.setText(timeRange15);


        tt21.setText(timeRange21);
        tt22.setText(timeRange22);
        tt23.setText(timeRange23);
        tt24.setText(timeRange24);
        tt25.setText(timeRange25);

    }

    private void showToast(String message) {
      //  Toast.makeText(Mainr.this, message, Toast.LENGTH_SHORT).show();
    }


}