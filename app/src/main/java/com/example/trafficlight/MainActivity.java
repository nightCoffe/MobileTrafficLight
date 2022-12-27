package com.example.trafficlight;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.TransactionTooLargeException;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout bulb_1, bulb_2, bulb_3;
    private boolean startStop = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bulb_1 = findViewById(R.id.bulb_1);
        bulb_2 = findViewById(R.id.bulb_2);
        bulb_3 = findViewById(R.id.bulb_3);
    }

    public void onClickStart(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (startStop) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        startStop  = false;
    }
}