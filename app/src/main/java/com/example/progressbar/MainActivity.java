package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyProgressBar myProgressBar = findViewById(R.id.myPB);

        Handler myHandler = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<100; i++){
                    int finalI = i;
                    myHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            myProgressBar.setProgress(finalI +1);
                        }
                    });
                    android.os.SystemClock.sleep(150);
                }
            }
        }).start();
    }
}