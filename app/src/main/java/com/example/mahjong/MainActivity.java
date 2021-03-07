package com.example.mahjong;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import Controller.GameController;
import Core.Game;

/**
 * This class represent an abstract 2 players board game
 */
public abstract class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected Game game;
    protected GameController controller;

    protected Button[][] buttons;

    protected TextView textViewPlayer1;
    protected TextView textViewPlayer2;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        textViewPlayer1 = findViewById(R.id.text_view_p1);
        textViewPlayer2 = findViewById(R.id.text_view_p2);

        this.buttons = new Button[this.game.getGrid().getNbRow()][this.game.getGrid().getNbCol()];

        for (int i = 0; i < this.game.getGrid().getNbRow(); i++) {
            for (int j = 0; j < this.game.getGrid().getNbCol(); j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }


        Button buttonReset = findViewById(R.id.button_reset);
     /*   buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { this.clickReset(); }
        });*/

    }



    public int getRow(int id) {
        return Integer.parseInt(getResources().getResourceEntryName(id).split("_")[1].substring(0,1));
    }

    public int getCol(int id) {
        return Integer.parseInt(getResources().getResourceEntryName(id).split("_")[1].substring(1,2));
    }

    private void clickReset() {

        this.controller.clickReset();
        this.update();

    }


    @Override
    public void onClick(View v) {

        this.controller.clickGrid(this.getRow(v.getId()), this.getCol(v.getId()));
        this.update();

    }

    public void update() {

        for (int i = 0; i < this.game.getGrid().getNbRow(); i++) {
            for (int j = 0; j < this.game.getGrid().getNbCol(); j++) {
                buttons[i][j].setText(this.game.getGrid().getCase(i, j).getJoueur());
            }
        }

        this.textViewPlayer1.setText("Player 1: " + String.valueOf(this.game.getPlayer1Points()));
        this.textViewPlayer2.setText("Player 2: " + String.valueOf(this.game.getPlayer2Points()));

    }


    public void player1Wins() {
        Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_SHORT).show();
    }

    public void player2Wins() {
        Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_SHORT).show();
    }

    public void draw() {
        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
/*
        outState.putInt("player1Points", player1Points);
        outState.putInt("player2Points", player2Points);
        outState.putBoolean("player1Turn", player1Turn);*/
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
/*
        player1Points = savedInstanceState.getInt("player1Points");
        player2Points = savedInstanceState.getInt("player2Points");
        player1Turn = savedInstanceState.getBoolean("player1Turn");*/
    }


}