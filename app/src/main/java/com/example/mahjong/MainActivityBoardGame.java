package com.example.mahjong;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import Controller.GameController;
import Core.BoardGame;

/**
 * This class represent an abstract view for a board game
 * @author Mano Brabant
 * @version 1.0
 */
public abstract class MainActivityBoardGame extends AppCompatActivity implements View.OnClickListener {

    protected BoardGame boardGame;
    protected GameController controller;

    protected Button[][] buttons;

    protected TextView textViewPlayer1;
    protected TextView textViewPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        textViewPlayer1 = findViewById(R.id.text_view_p1);
        textViewPlayer2 = findViewById(R.id.text_view_p2);

        this.buttons = new Button[this.boardGame.getGrid().getNbRow()][this.boardGame.getGrid().getNbCol()];

        for (int i = 0; i < this.boardGame.getGrid().getNbRow(); i++) {
            for (int j = 0; j < this.boardGame.getGrid().getNbCol(); j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }


        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(v -> clickReset());

        Button buttonRetry = findViewById(R.id.button_retry);
        buttonRetry.setOnClickListener(v -> clickRetry());

        this.update();

    }


    /**
     * This method return the row of a given Button
     * @param id Le id of the button
     * @return The row's number of the button
     */
    public int getRow(int id) {
        return Integer.parseInt(getResources().getResourceEntryName(id).split("_")[1].substring(0,1));
    }


    /**
     * This method return the column of a given Button
     * @param id Le id of the button
     * @return The column's number of the button
     */
    public int getCol(int id) {
        return Integer.parseInt(getResources().getResourceEntryName(id).split("_")[1].substring(1,2));
    }

    /**
     * This method reset the game
     */
    private void clickReset() {

        this.controller.clickReset();
        this.update();

    }

    /**
     * This method restart a new game
     */
    private void clickRetry() {

        this.controller.clickRetry();
        this.update();

    }


    @Override
    public void onClick(View v) {

        this.controller.clickGrid(this.getRow(v.getId()), this.getCol(v.getId()));
        this.update();

    }

    /**
     * This method update the view.
     * It take the info needed in the model to update the view
     */
    @SuppressLint("SetTextI18n")
    public void update() {

        for (int i = 0; i < this.boardGame.getGrid().getNbRow(); i++) {
            for (int j = 0; j < this.boardGame.getGrid().getNbCol(); j++) {
                buttons[i][j].setText(this.boardGame.getGrid().getCell(i, j).getLetter());
            }
        }

        this.textViewPlayer1.setText(getString(R.string.player1) + " : " + this.boardGame.getPlayer1Points());
        this.textViewPlayer2.setText(getString(R.string.player2) + " : " + this.boardGame.getPlayer2Points());

    }


    /**
     * This method show a pop up saying that the player1 has wined
     */
    public void player1Wins() {
        Toast.makeText(this, getString(R.string.player1Wins), Toast.LENGTH_SHORT).show();
    }


    /**
     * This method show a pop up saying that the player2 has wined
     */
    public void player2Wins() {
        Toast.makeText(this, getString(R.string.player2Wins), Toast.LENGTH_SHORT).show();
    }


    /**
     * This method show a pop up saying that the game is a draw
     */
    public void draw() {
        Toast.makeText(this, getString(R.string.draw), Toast.LENGTH_SHORT).show();
    }

}