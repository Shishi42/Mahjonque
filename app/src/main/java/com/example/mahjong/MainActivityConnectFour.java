package com.example.mahjong;

import android.os.Bundle;

import Controller.ConnectFourController;
import Core.ConnectFour;


/**
 * This class represent a view for a Connect four game
 * @author Mano Brabant
 * @version 1.0
 */
public class MainActivityConnectFour extends MainActivityBoardGame {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_connect_four);

        this.boardGame = new ConnectFour();
        this.controller = new ConnectFourController(this.boardGame, this);

        super.onCreate(savedInstanceState);

    }

}
