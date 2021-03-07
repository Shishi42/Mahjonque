package com.example.mahjong;

import android.os.Bundle;

import Controller.Puissance4Controller;
import Controller.TicTacToeController;
import Core.TicTacToe;

public class MainActivityTicTacToe extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_main_tic_tac_toe);

        this.game = new TicTacToe();
        this.controller = new TicTacToeController(this.game);

        super.onCreate(savedInstanceState);

    }

}