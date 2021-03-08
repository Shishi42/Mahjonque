package com.example.mahjong;

import android.os.Bundle;

import Controller.ConnectFourController;
import Core.ConnectFour;

public class MainActivityConnectFour extends MainActivityBoardGame {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_main_connect_four);

        this.boardGame = new ConnectFour();
        this.controller = new ConnectFourController(this.boardGame, this);

        super.onCreate(savedInstanceState);

    }

}