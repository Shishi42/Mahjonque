package com.example.mahjong;

import android.os.Bundle;

import Controller.Puissance4Controller;
import Core.Puissance4;

public class MainActivityPuissance4 extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_main_puissance4);

        this.game = new Puissance4();
        this.controller = new Puissance4Controller(this.game);

        super.onCreate(savedInstanceState);

    }

}