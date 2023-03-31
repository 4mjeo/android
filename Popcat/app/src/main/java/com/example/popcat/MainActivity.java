package com.example.popcat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imgPopcat;
    Button buttonreset;

    TextView countText;
    Long count = 0L;
    Vibrator viberator;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPopcat = findViewById(R.id.img_popcat);
        countText = findViewById(R.id.tv_count);
        buttonreset = findViewById(R.id.reset);

        viberator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        imgPopcat.setOnTouchListener((view, motionEvent) -> {
            switch(motionEvent.getAction()) {
                case (MotionEvent.ACTION_UP):
                    this.imgPopcat.setImageResource(R.drawable.img_closed);
                    return true;
                case(MotionEvent.ACTION_DOWN):
                    this.imgPopcat.setImageResource((R.drawable.opened));

                    count++;
                    this.countText.setText(count.toString());
                    viberator.vibrate(50);
                    return true;
            }
            return false;
        });

        buttonreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0L;
                countText.setText(count.toString());
            }
        });

    }
}