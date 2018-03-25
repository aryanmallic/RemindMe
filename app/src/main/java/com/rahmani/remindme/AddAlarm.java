package com.rahmani.remindme;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import adapter.Category_Adap;
import adapter.Theme_Adap;
import databinder.CategoryData;

import helper.Constants;
import helper.SharedPrefs;
import rminterface.UpdateValuesCallBack;

public class AddAlarm extends AppCompatActivity {

    RecyclerView rv_Categories;
    private Context mContext;
    private Category_Adap mAdapter;
    String name[] = {"Date:", "Time"};
    int img[] = {R.drawable.calendar, R.drawable.alarm_clock};
    private ArrayList<CategoryData> list;
    int year, mon, day;
    int hour ,minute;
    private UpdateValuesCallBack updateValuesCallBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mytheme();
        setContentView(R.layout.activity_add_alarm);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        mContext = getApplicationContext();
        list = new ArrayList<>();
        rv_Categories = (RecyclerView) findViewById(R.id.rv_Categories);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext);
        rv_Categories.setLayoutManager(layoutManager);
        getCategories();
        mAdapter.setOnItemClickListner(new Theme_Adap.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (position == 0) {
                    MyCalender();
                    //mAdapter.notifyDataSetChanged();
                }
                if (position == 1) {
                    MyTime();

                }
            }
        });
    }

    private void getCategories() {
        for (int i = 0; i < name.length; i++) {
            list.add(new CategoryData(name[i], img[i]));
            mAdapter = new Category_Adap(mContext, list, new UpdateValuesCallBack() {
                @Override
                public void ItemNewValue(int position, String value) {

                }
            });
            rv_Categories.setAdapter(mAdapter);
        }
    }

    public void Mytheme() {
        if (new SharedPrefs(getApplicationContext()).getNewTheme() != "") {
            String theme = new SharedPrefs(getApplicationContext()).getNewTheme();
            if (theme.equals("Purple_Theme")) {
                setTheme(R.style.Purple_Theme);
            } else if (theme.equals("Blue_Theme")) {
                setTheme(R.style.Blue_Theme);
            } else if (theme.equals("Night_Theme")) {
                setTheme(R.style.Night_Theme);
            }
        }
    }

    public void MyCalender() {
        final Calendar c = Calendar.getInstance();
        day = c.get(Calendar.DAY_OF_MONTH);
        mon = c.get(Calendar.MONTH);
        year = c.get(Calendar.YEAR);
        DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String d=Integer.toString(dayOfMonth);
                String m=Integer.toString(monthOfYear+1);
                if(d.length()<2){
                    d= "0" + d;
                }
                if(m.length()<2){
                    m= "0" + m;
                }
                String date=dayOfMonth + "" + (monthOfYear + 1) + "" + year;

                updateValuesCallBack=new UpdateValuesCallBack() {
                    @Override
                    public void ItemNewValue(int position, String value) {

                    }
                };

                if(updateValuesCallBack!=null){
                    updateValuesCallBack.ItemNewValue(0,date);
                }

                //CategoryData cd=new CategoryData();
                //cd.setPositon(0);
                //cd.setCategory_val(date);
               // mAdapter.notifyItemChanged(0, date);
                //Toast.makeText(mContext,""+date,Toast.LENGTH_SHORT).show();

                //pers_info_fm1_et_Dob.setText(d + "-" + m + "-" + year);
                //fm_new_patient_et_date_of_screen_camp.setText(dayOfMonth + "" + (monthOfYear + 1) + "" + year);

            }
        }, year, mon, day);

        dpd.getDatePicker().setMinDate(System.currentTimeMillis());
        dpd.setTitle("");
        dpd.show();

    }
    public void MyTime(){
        Calendar mcurrentTime = Calendar.getInstance();
        hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker= new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                //CategoryData cd=new CategoryData();
                //cd.setPositon(1);
                //cd.setCategory_val("ok");
            }
        }, hour, minute, false);
        mTimePicker.setTitle("");
        mTimePicker.show();

    }
}
