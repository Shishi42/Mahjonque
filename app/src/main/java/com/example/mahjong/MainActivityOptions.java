package com.example.mahjong;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;


/**
 * This class represent a view for the options menu
 * @author Mano Brabant
 * @version 1.0
 */
public class MainActivityOptions extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.play_options);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Button quit = findViewById(R.id.button_back);
        quit.setOnClickListener(v -> this.finish());

    }

}
