package com.example.nordazza.movingball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AnimatedView animatedView = new AnimatedView(this);
        setContentView(animatedView);
    }
}
