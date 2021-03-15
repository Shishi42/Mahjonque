package com.example.mahjong;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import Controller.MahjongController;
import Core.MahjongGame;
import Core.Tile;


/**
 * This class represent a view for a mahjong game
 * @author Mano Brabant
 * @version 1.0
 */
public class MainActivityMahjong extends AppCompatActivity implements View.OnClickListener  {

    //Model & Controller
    private MahjongGame mahjongGame;
    private MahjongController mahjongController;

    //Elements of the view
    private TextView textViewPlayer1;
    private TextView textViewPlayer2;
    private ImageView[] imagesPlayer1;
    private ImageView[] imagesPlayer2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_mahjong);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

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


        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(v -> clickReset());

        Button buttonRetry = findViewById(R.id.button_retry);
        buttonRetry.setOnClickListener(v -> clickRetry());

        this.update();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {

        this.mahjongController.clickHand(this.getNum(v.getId()));
        this.update();

    }


    /**
     * This method reset the game
     */
    private void clickReset() {

        this.mahjongController.clickReset();
        this.update();

    }


    /**
     * This method restart a new game
     */
    private void clickRetry() {

        this.mahjongController.clickRetry();
        this.update();

    }


    /**
     * This method return the number of a given ImageView
     * @param id Le id of the ImageView
     * @return The number of the ImageView
     */
    public int getNum(int id) {
        return Integer.parseInt(getResources().getResourceEntryName(id).split("_")[2]);
    }


    /**
     * This method update the view.
     * It take the info needed in the model to update the view
     */
    @SuppressLint("SetTextI18n")
    public void update() {

        for (int i = 0; i < this.mahjongGame.getPlayer1Hand().getSize(); i++) {
            imagesPlayer1[i].setImageBitmap(this.getBitmapTile(this.mahjongGame.getPlayer1Hand().getTile(i)));
        }


        for (int i = 0; i < this.mahjongGame.getPlayer2Hand().getSize(); i++) {
            imagesPlayer2[i].setImageBitmap(this.getBitmapTile(this.mahjongGame.getPlayer2Hand().getTile(i)));
        }

        this.textViewPlayer1.setText(getString(R.string.player1) + " : " + this.mahjongGame.getPlayer1Points());
        this.textViewPlayer2.setText(this.mahjongGame.getPlayer2Points() + " : " + getString(R.string.player2));

    }


    /**
     * This method return the Bitmap of a given Tile
     * @param tile The tile we want to show with a Bitmap
     * @return The Bitmap of the tile
     */
    public Bitmap getBitmapTile(Tile tile) {

        String test = "" + tile.getType() + tile.getHeight().getNum();
        int resID = getResources().getIdentifier(test, "drawable", getPackageName());

        return BitmapFactory.decodeResource(getResources(), resID);

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
