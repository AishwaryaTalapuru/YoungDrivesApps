package com.appstone.www.youngdrivesapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;
import android.widget.TextClock;


import java.text.DateFormat;
import java.util.Calendar;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    String[] SPINNERLIST = {"Car", "2 Wheeler"};
    DateFormat formatDateTime = DateFormat.getDateTimeInstance();
    DateFormat formatDateTime1 = DateFormat.getDateTimeInstance();
    Calendar dateTime = Calendar.getInstance();
    Calendar dateTime1 = Calendar.getInstance();
    private TextView text;
    private Button btn_date;
    private Button btn_time;

    private TextView text1;
    private Button btn_date1;
    private Button btn_time1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SPINNERLIST);
        MaterialBetterSpinner betterSpinner = (MaterialBetterSpinner) findViewById(R.id.android_material_design_spinner);
        betterSpinner.setAdapter(arrayAdapter);


        text = (TextView) findViewById(R.id.txt_TextDateTime);
        text1 = (TextView) findViewById(R.id.txt_TextDateTime1);


        btn_date = (Button) findViewById(R.id.btn_datePicker);
        btn_date1 = (Button) findViewById(R.id.btn_datePicker1);
        btn_time = (Button) findViewById(R.id.btn_timePicker);
        btn_time1 = (Button) findViewById(R.id.btn_timePicker1);

        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDate();

            }
        });

        btn_date1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                updateDate1();

            }
        });
        btn_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTime();

            }
        });

        btn_time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                updateTime1();

            }
        });



        updateTextLabel();
        updateTextLabel1();
    }

    private void updateTextLabel() {
        text.setText(formatDateTime.format(dateTime.getTime()));
    }

    private void updateTextLabel1() {
        text1.setText(formatDateTime1.format(dateTime1.getTime()));
    }


    private void updateDate() {
        new DatePickerDialog(this, d, dateTime.get(Calendar.YEAR), dateTime.get(Calendar.MONTH), dateTime.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void updateDate1() {

        new DatePickerDialog(this, d1, dateTime1.get(Calendar.YEAR), dateTime1.get(Calendar.MONTH), dateTime1.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void updateTime() {
        new TimePickerDialog(this, t, dateTime.get(Calendar.HOUR_OF_DAY), dateTime.get(Calendar.MINUTE), true).show();
    }

    private void updateTime1() {

        new TimePickerDialog(this, t1, dateTime1.get(Calendar.HOUR_OF_DAY), dateTime1.get(Calendar.MINUTE), true).show();

    }

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateTime.set(Calendar.YEAR, year);
            dateTime.set(Calendar.MONTH, monthOfYear);

            dateTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateTextLabel();
        }
    };

    DatePickerDialog.OnDateSetListener d1 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view1, int year1, int monthOfYear1, int dayOfMonth1) {
            dateTime.set(Calendar.YEAR, year1);
            dateTime.set(Calendar.MONTH, monthOfYear1);
            dateTime.set(Calendar.DAY_OF_MONTH, dayOfMonth1);
            updateTextLabel1();

        }
    };

    TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dateTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateTime.set(Calendar.MINUTE, minute);
            updateTextLabel();
        }
    };
    TimePickerDialog.OnTimeSetListener t1 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view1, int hourOfDay1, int minute1) {
            dateTime.set(Calendar.HOUR_OF_DAY, hourOfDay1);
            dateTime.set(Calendar.MINUTE, minute1);
            updateTextLabel1();

        }
    };
}























