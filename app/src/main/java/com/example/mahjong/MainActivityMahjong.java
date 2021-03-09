package com.example.mahjong;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivityMahjong extends AppCompatActivity implements View.OnClickListener  {



    protected TextView textViewPlayer1;
    protected TextView textViewPlayer2;

    protected ImageView[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_mahjong);

        this.images = new ImageView[14];

        this.textViewPlayer1 = findViewById(R.id.text_view_p1);
        this.textViewPlayer2 = findViewById(R.id.text_view_p2);


        for (int i = 0; i < 14; i++) {
            String buttonID = "imageCard_p1_" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            images[i] = findViewById(resID);
            images[i].setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        ((ImageView)v).setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.example_black));
    }

}
