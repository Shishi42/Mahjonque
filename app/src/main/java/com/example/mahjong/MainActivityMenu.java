package com.example.mahjong;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;


/**
 * This class represent a view for the main menu
 * @author Mano Brabant
 * @author Benjamin Riviere
 * @author La Passion de l'Infographie
 * @version 1.0
 */
public class MainActivityMenu extends AppCompatActivity {


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_menu);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Intent mahjong = new Intent(this, MainActivityMahjong.class);
        Intent ticTacToe = new Intent(this, MainActivityTicTacToe.class);
        Intent connectFour = new Intent(this, MainActivityConnectFour.class);
        Intent options = new Intent(this, MainActivityOptions.class);

        Animation scaleUp, scaleDown;

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        @SuppressLint("WrongViewCast") ImageButton buttonMahjong = findViewById(R.id.button_play);
        buttonMahjong.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    buttonMahjong.startAnimation(scaleUp);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    buttonMahjong.startAnimation(scaleDown);
                }
                startActivity(mahjong);
                return true;
            }
        });

        @SuppressLint("WrongViewCast") ImageButton buttonTictactoe = findViewById(R.id.button_tictactoe);
        buttonTictactoe.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    buttonTictactoe.startAnimation(scaleUp);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    buttonTictactoe.startAnimation(scaleDown);
                }
                startActivity(ticTacToe);
                return true;
            }
        });

        @SuppressLint("WrongViewCast") ImageButton buttonConnectFour = findViewById(R.id.button_connect_four);
        buttonConnectFour.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    buttonConnectFour.startAnimation(scaleUp);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    buttonConnectFour.startAnimation(scaleDown);
                }
                startActivity(connectFour);
                return true;
            }
        });
        
        @SuppressLint("WrongViewCast") ImageButton buttonOption = findViewById(R.id.button_options);
        buttonOption.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    buttonOption.startAnimation(scaleUp);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    buttonOption.startAnimation(scaleDown);
                }
                startActivity(options);
                return true;
            }
        });

        @SuppressLint("WrongViewCast") ImageButton buttonQuit = findViewById(R.id.button_quit);
        buttonQuit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    buttonQuit.startAnimation(scaleUp);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    buttonQuit.startAnimation(scaleDown);
                }
                finishAndRemoveTask();
                return true;
            }
        });

    }

}
