package com.example.mahjong;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import Controller.MahjongController;
import Core.MahjongGame;
import Core.Tile;
import Core.TileNum;


public class MainActivityMahjong extends AppCompatActivity implements View.OnClickListener  {

    private MahjongGame mahjongGame;
    private MahjongController mahjongController;

    protected TextView textViewPlayer1;
    protected TextView textViewPlayer2;

    protected ImageView[] imagesPlayer1;
    protected ImageView[] imagesPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_mahjong);

        this.mahjongGame = new MahjongGame();
        this.mahjongController = new MahjongController(this.mahjongGame, this);

        this.imagesPlayer1 = new ImageView[14];
        this.imagesPlayer2 = new ImageView[14];

        this.textViewPlayer1 = findViewById(R.id.text_view_p1);
        this.textViewPlayer2 = findViewById(R.id.text_view_p2);


        for (int i = 0; i < 14; i++) {
            String buttonID = "imageCard_p1_" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            imagesPlayer1[i] = findViewById(resID);
            imagesPlayer1[i].setOnClickListener(this);
        }


        for (int i = 0; i < 14; i++) {
            String buttonID = "imageCard_p2_" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            imagesPlayer2[i] = findViewById(resID);
            imagesPlayer2[i].setOnClickListener(this);
        }

        this.update();

    }

    @Override
    public void onClick(View v) {

        this.mahjongController.clickHand(this.getNum(v.getId()));
        this.update();

    }


    /**
     * This method return the number of a given Button
     * @param id Le id of the button
     * @return The number of the button
     */
    public int getNum(int id) {
        return Integer.parseInt(getResources().getResourceEntryName(id).split("_")[2]);
    }


    /**
     * This method update the view.
     * It take the info needed in the model to update the view
     */
    public void update() {

        for (int i = 0; i < this.mahjongGame.getPlayer1Hand().getSize(); i++) {
            imagesPlayer1[i].setImageBitmap(this.getBitmapTile(this.mahjongGame.getPlayer1Hand().getTile(i)));
        }


        for (int i = 0; i < this.mahjongGame.getPlayer2Hand().getSize(); i++) {
        //    imagesPlayer2[i].setImageBitmap(this.getBitmapTile(this.mahjongGame.getPlayer2Hand().getTile(i)));
        }

        this.textViewPlayer1.setText(getString(R.string.player1) + " : " + String.valueOf(this.mahjongGame.getPlayer1Points()));
        this.textViewPlayer2.setText(getString(R.string.player2) + " : " + String.valueOf(this.mahjongGame.getPlayer2Points()));

    }


    public Bitmap getBitmapTile(Tile tile) {

        String test = "tile_" + tile.getType() + "_" + tile.getHauteur();

        int resID = getResources().getIdentifier(test, "drawable", getPackageName());

        Bitmap ret = BitmapFactory.decodeResource(getResources(), resID);

        return ret;

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
