package com.example.mahjong;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

/**
 * This class represent a activity for the main menu
 * @author Mano Brabant
 * @author Benjamin Riviere
 * @version 1.0
 */
public class MainActivityMenu extends AppCompatActivity {


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Intent mahjong = new Intent(this, MainActivityMahjong.class);
        Intent ticTacToe = new Intent(this, MainActivityTicTacToe.class);
        Intent connectFour = new Intent(this, MainActivityConnectFour.class);
        Intent options = new Intent(this, MainActivityOptions.class);

        Animation scaleUp, scaleDown;

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        @SuppressLint("WrongViewCast") Button buttonMahjong = findViewById(R.id.button_play);
        buttonMahjong.setOnTouchListener((v, event) -> {
            if(event.getAction()==MotionEvent.ACTION_DOWN){
                buttonMahjong.startAnimation(scaleUp);
            }else if(event.getAction()==MotionEvent.ACTION_UP){
                buttonMahjong.startAnimation(scaleDown);
                startActivity(mahjong);
            }
            return true;
        });

        @SuppressLint("WrongViewCast") Button buttonTictactoe = findViewById(R.id.button_tictactoe);
        buttonTictactoe.setOnTouchListener((v, event) -> {
            if(event.getAction()==MotionEvent.ACTION_DOWN){
                buttonTictactoe.startAnimation(scaleUp);
            }else if(event.getAction()==MotionEvent.ACTION_UP){
                buttonTictactoe.startAnimation(scaleDown);
                startActivity(ticTacToe);
            }
            return true;
        });

        @SuppressLint("WrongViewCast") Button buttonConnectFour = findViewById(R.id.button_connect_four);
        buttonConnectFour.setOnTouchListener((v, event) -> {
            if(event.getAction()==MotionEvent.ACTION_DOWN){
                buttonConnectFour.startAnimation(scaleUp);
            }else if(event.getAction()==MotionEvent.ACTION_UP){
                buttonConnectFour.startAnimation(scaleDown);
                startActivity(connectFour);
            }
            return true;
        });

        @SuppressLint("WrongViewCast") Button buttonOption = findViewById(R.id.button_options);
        buttonOption.setOnTouchListener((v, event) -> {
            if(event.getAction()==MotionEvent.ACTION_DOWN){
                buttonOption.startAnimation(scaleUp);
            }else if(event.getAction()==MotionEvent.ACTION_UP){
                buttonOption.startAnimation(scaleDown);
                startActivity(options);
            }
            return true;
        });

        @SuppressLint("WrongViewCast") Button buttonQuit = findViewById(R.id.button_quit);
        buttonQuit.setOnTouchListener((v, event) -> {
            if(event.getAction()==MotionEvent.ACTION_DOWN){
                buttonQuit.startAnimation(scaleUp);
            }else if(event.getAction()==MotionEvent.ACTION_UP){
                buttonQuit.startAnimation(scaleDown);
                finishAndRemoveTask();
            }
            return true;
        });

    }

}
