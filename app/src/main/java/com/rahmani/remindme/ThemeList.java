package com.rahmani.remindme;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.Theme_Adap;
import databinder.ThemeData;
import helper.SharedPrefs;

public class ThemeList extends AppCompatActivity {

    RecyclerView rv_color;
    private Context mContext;
    private Theme_Adap mAdapter;
    private ArrayList<ThemeData> list;
    String colorName[] = {"Candy Purple", "Candy Blue", "Night Voyage"};


    int[] color1;
    int[] color2;
    int[] color3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mytheme();
        setContentView(R.layout.activity_theme_list);
        mContext = getApplicationContext();


        color1 = mContext.getResources().getIntArray(R.array.color1);
        color2 = mContext.getResources().getIntArray(R.array.color2);
        color3 = mContext.getResources().getIntArray(R.array.color3);
        list = new ArrayList<>();
        rv_color = (RecyclerView) findViewById(R.id.rv_color);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext);
        rv_color.setLayoutManager(layoutManager);

        ThemeColor();

        mAdapter.setOnItemClickListner(new Theme_Adap.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                if (position == 0) {
                    new SharedPrefs(mContext).setNewTheme("Purple_Theme");
                    Intent intent = new Intent(mContext, Home.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    ThemeList.super.onBackPressed();
                    // mContext.setTheme(R.style.Purple_Theme);
                    //setTheme(R.style.Purple_Theme);
                }
                if (position == 1) {
                    new SharedPrefs(mContext).setNewTheme("Blue_Theme");
                    Intent intent = new Intent(mContext, Home.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    ThemeList.super.onBackPressed();
                }

                if (position == 2) {
                    new SharedPrefs(mContext).setNewTheme("Night_Theme");
                    Intent intent = new Intent(mContext, Home.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    ThemeList.super.onBackPressed();
                }
            }
        });
    }

    private void ThemeColor() {
        for (int i = 0; i < colorName.length; i++) {
            list.add(new ThemeData(colorName[i], color1[i], color2[i], color3[i]));
            mAdapter = new Theme_Adap(mContext, list);
            rv_color.setAdapter(mAdapter);
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
}
