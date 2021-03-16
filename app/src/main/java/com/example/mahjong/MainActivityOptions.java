package com.example.mahjong;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

/**
 * This class represent a view for the options menu
 * @author Mano Brabant
 * @author Benjamin Riviere
 * @author Le mec sur youtube qui a fait le tuto
 * @version 1.0
 */
public class MainActivityOptions extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.play_options);

        Animation scaleUp, scaleDown;

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        EditText TextInputLength = findViewById(R.id.input_length);
        EditText TextInputThinking = findViewById(R.id.input_thinking);

        @SuppressLint("WrongViewCast") Button buttonConfirm = findViewById(R.id.button_confirm);
        buttonConfirm.setOnTouchListener((v, event) -> {
            if(event.getAction()== MotionEvent.ACTION_DOWN){
                buttonConfirm.startAnimation(scaleUp);
            }else if(event.getAction()==MotionEvent.ACTION_UP){
                buttonConfirm.startAnimation(scaleDown);
                Toast.makeText(getApplicationContext(),  "Game length : "+ TextInputLength.getText() + "\nThinking time : " + TextInputThinking.getText() , Toast.LENGTH_SHORT).show();
                this.finish();
            }
            return true;
        });
    }

}
