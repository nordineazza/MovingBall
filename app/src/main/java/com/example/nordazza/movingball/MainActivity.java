package com.example.nordazza.movingball;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button button_jouer;
    EditText et_pts, et_speedX, et_speedY, et_frameSpeed;
    int pts, speedX, speedY, frameSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Récupération des champs EditText
        et_pts = (EditText) findViewById(R.id.editText);
        et_frameSpeed = (EditText) findViewById(R.id.editText2);
        et_speedX = (EditText) findViewById(R.id.editText3);
        et_speedY = (EditText) findViewById(R.id.editText4);

        button_jouer = (Button) findViewById(R.id.button);
        button_jouer.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //Affectation des valeurs
        pts = Integer.parseInt(et_pts.getText().toString());
        speedX = Integer.parseInt(et_speedX.getText().toString());
        speedY = Integer.parseInt(et_speedY.getText().toString());
        frameSpeed = Integer.parseInt(et_frameSpeed.getText().toString());

        System.out.println("pts=" + pts + " speedX=" + speedX + " speedY=" +speedY + " frameSpeed=" + frameSpeed);

        //Intent intent = new Intent(this, GameActivity.class);
        //intent.putExtra()
        //startActivity(intent);
    }
}
