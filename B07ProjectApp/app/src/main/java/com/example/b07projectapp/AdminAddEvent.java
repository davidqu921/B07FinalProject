package com.example.b07projectapp;

import static android.provider.Settings.System.DATE_FORMAT;
import static android.widget.Toast.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.b07projectapp.login_module.AdminLogin;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AdminAddEvent extends AppCompatActivity {
    FirebaseDatabase base = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com/");
    //Button dateButton;
    private Button dateButton;
    private DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_event);
        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysDate());
    }

    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month+1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int style = AlertDialog.THEME_HOLO_LIGHT;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
    }
    private String makeDateString(int day, int month, int year) {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month) {
        if (month == 2)
            return "FEB";
        if (month == 3)
            return "MAR";
        if (month == 4)
            return "APR";
        if (month == 5)
            return "MAY";
        if (month == 6)
            return "JUN";
        if (month == 7)
            return "JUL";
        if (month == 8)
            return "AUG";
        if (month == 9)
            return "SEP";
        if (month == 10)
            return "OCT";
        if (month == 11)
            return "NOV";
        if (month == 12)
            return "DEC";
        else
            return "JAN";
    }

    public void openDatePicker(View view) {
        datePickerDialog.show();
    }


    public void onClickAdd(View view){
        String user = getIntent().getStringExtra("username");
        if (user == null) {
            makeText(AdminAddEvent.this, "Log In as an Admin First!", LENGTH_SHORT).show();
            startActivity(new Intent(AdminAddEvent.this, AdminLogin.class));
        }
        else {

            DatabaseReference ref = base.getReference();
            EditText Title = (EditText) findViewById(R.id.editTextText);
            EditText desc = (EditText) findViewById(R.id.editTextStudentComplaint2);
            String descStr = desc.getText().toString();
            String TitleStr = Title.getText().toString();
            //desc.setText("");
            //Title.setText("");
            EditText location = (EditText) findViewById(R.id.editTextText2);
            String locationStr = location.getText().toString();
            //location.setText("");
            //EditText date =  findViewById(R.id.editTextDate);
            //String dateStr = date.getText().toString();
            String dateStr = dateButton.getText().toString();

            //Date eventDate = Date.valueOf(dateStr);
            //makeText(AdminAddEvent.this, dateStr, LENGTH_SHORT).show();
            EditText people = (EditText) findViewById(R.id.editTextNumber2);
            String peoplestr = people.getText().toString();


            //people.setText("");

            boolean ct[] = {true};
            ref.child("event").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    boolean call = false;

                    for (DataSnapshot ds: snapshot.getChildren()){
                        if (ds.getKey().equals(TitleStr)) {
                            call = true;
                            break;
                        }
                    }
                    if(ct[0]) {
                        if (!call) {
                            //java.util.Date eventDate = Date.valueOf(dateStr);
                            //java.util.Date currentDate = Calendar.getInstance().getTime();
                            if (TitleStr.isEmpty() || descStr.isEmpty()  || locationStr.isEmpty() || peoplestr.isEmpty()) {
                                makeText(AdminAddEvent.this, "Fill In All Empty Fields", LENGTH_SHORT).show();
                           // } else if (eventDate.compareTo(currentDate) <= 0) {
                            //  makeText(AdminAddEvent.this, "Date cannot be before current date", LENGTH_SHORT).show();
                            //} else if (Integer.valueOf(people.getText().toString()) <= 0){
                              //makeText(AdminAddEvent.this, "Must have atleast one Participant", LENGTH_SHORT).show();
                            }
                            else {
                                ref.child("event").child(TitleStr).child("title").setValue(TitleStr);
                                ref.child("event").child(TitleStr).child("description").setValue(descStr);
                                ref.child("event").child(TitleStr).child("date").setValue(dateStr);
                                ref.child("event").child(TitleStr).child("location").setValue(locationStr);
                                ref.child("event").child(TitleStr).child("limit").setValue(Integer.valueOf(peoplestr));
                                ref.child("event").child(TitleStr).child("poster").setValue(user);
                                makeText(AdminAddEvent.this, "Event Created!", LENGTH_SHORT).show();
                                ct[0] = false;
                                onBackPressed();
                            }

                        } else {
                            makeText(AdminAddEvent.this, "Event Already Exists", LENGTH_SHORT).show();
                        }
                        ct[0] = false;
                    }
                    //finish();
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });

        }

    }
}