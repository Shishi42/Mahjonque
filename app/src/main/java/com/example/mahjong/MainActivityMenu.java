package com.example.mahjong;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;


/**
 * This class represent a view for the main menu
 * @author Mano Brabant
 * @version 1.0
 */
public class MainActivityMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_menu);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Intent mahjong = new Intent(this, MainActivityMahjong.class);
        Intent ticTacToe = new Intent(this, MainActivityTicTacToe.class);
        Intent connectFour = new Intent(this, MainActivityConnectFour.class);
        Intent options = new Intent(this, MainActivityOptions.class);



        @SuppressLint("WrongViewCast") ImageButton launchMahjong = findViewById(R.id.button_play);
        launchMahjong.setOnClickListener(v -> startActivity(mahjong));

        Button launchTicTacToe = findViewById(R.id.button_tictactoe);
        launchTicTacToe.setOnClickListener(v -> startActivity(ticTacToe));

        Button launchConnectFour = findViewById(R.id.button_connect_four);
        launchConnectFour.setOnClickListener(v -> startActivity(connectFour));

        Button option = findViewById(R.id.button_options);
        option.setOnClickListener(v -> startActivity(options));

        Button quit = findViewById(R.id.button_quit);
        quit.setOnClickListener(v -> this.finish());

    }

}
