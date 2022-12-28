package com.example.trafficlight;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.TransactionTooLargeException;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout bulb_1, bulb_2, bulb_3;
    private boolean startStop = false;
    private Button button_1;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bulb_1 = findViewById(R.id.bulb_1);
        bulb_2 = findViewById(R.id.bulb_2);
        bulb_3 = findViewById(R.id.bulb_3);
        button_1 = findViewById(R.id.button4);
    }

    public void onClickStart(View view) {

        if (!startStop) {
            button_1.setText("Stop");
            startStop = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (startStop) {
                        counter++;
                        switch (counter) {
                            case 1:
                                bulb_1.setBackgroundColor(getResources().getColor(R.color.green_1));
                                bulb_2.setBackgroundColor(getResources().getColor(R.color.grey));
                                bulb_3.setBackgroundColor(getResources().getColor(R.color.grey));
                                break;
                            case 2:
                                bulb_2.setBackgroundColor(getResources().getColor(R.color.yellow_1));
                                bulb_1.setBackgroundColor(getResources().getColor(R.color.grey));
                                bulb_3.setBackgroundColor(getResources().getColor(R.color.grey));
                                break;
                            case 3:
                                bulb_3.setBackgroundColor(getResources().getColor(R.color.red_1));
                                bulb_1.setBackgroundColor(getResources().getColor(R.color.grey));
                                bulb_2.setBackgroundColor(getResources().getColor(R.color.grey));
                                counter = 0;
                                break;
                        }
                        }
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

            }).start();
        } else {
            startStop = false;
            button_1.setText("Start");
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        startStop = false;
    }
}
