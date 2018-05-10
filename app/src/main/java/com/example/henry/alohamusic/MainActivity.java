package com.example.henry.alohamusic;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button1, button2;
    MediaPlayer mpUkulele, mpDrums;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //attaching button variables to xml
        button1 = (Button) findViewById (R.id.btnUkulele);
        button2 = (Button) findViewById(R.id.btnDrums);

        //set listeners
        button1.setOnClickListener(bUkulele);
        button2.setOnClickListener(bDrums);

        //set players
        mpUkulele = new MediaPlayer();
        mpUkulele = MediaPlayer.create(this,R.raw.ukulele);

        mpDrums = new MediaPlayer();
        mpDrums = MediaPlayer.create(this,R.raw.drums);
    }
    Button.OnClickListener bUkulele = new Button.OnClickListener(){

        @Override
        public void onClick(View view) {
            switch(playing){
                case 0:
                    mpUkulele.start();
                    playing = 1;
                    button1.setText("Pause Ukulele Song");
                    button2.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpUkulele.pause();
                    playing = 0;
                    button1.setText("Play Ukulele Song");
                    button2.setVisibility(View.INVISIBLE);
                    break;
            }


        }
    };
    Button.OnClickListener bDrums = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(playing){
                case 0:
                    mpDrums.start();
                    playing = 1;
                    button2.setText("Pause Drums Song");
                    button1.setVisibility(View.INVISIBLE);

                    break;
                case 1:
                    mpDrums.pause();
                    playing = 0;
                    button2.setText("Play Drums Song");
                    button1.setVisibility(View.INVISIBLE);
                    break;
            }

        }
    };
}
