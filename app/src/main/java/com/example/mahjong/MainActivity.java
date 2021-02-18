package com.example.mahjong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.context = this.getApplicationContext();
        setContentView(R.layout.activity_main);
    }


    public static Context getAppContext() {
        return MainActivity.context;
    }




}