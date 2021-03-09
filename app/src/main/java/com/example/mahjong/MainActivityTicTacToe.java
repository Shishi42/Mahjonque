package com.example.mahjong;

import android.os.Bundle;

import Controller.TicTacToeController;
import Core.TicTacToe;


/**
 * This class represent a view for a Tic Tac Toe game
 */
public class MainActivityTicTacToe extends MainActivityBoardGame {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_main_tic_tac_toe);

        this.boardGame = new TicTacToe();
        this.controller = new TicTacToeController(this.boardGame, this);

        super.onCreate(savedInstanceState);

    }

}