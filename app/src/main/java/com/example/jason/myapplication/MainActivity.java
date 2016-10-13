package com.example.jason.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button howtogame = (Button) findViewById(R.id.button3);
        howtogame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),howto.class);
                startActivityForResult(intent,0);

            }
        });
        Button topicselect = (Button) findViewById(R.id.button2);
        topicselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Topic_Selector.class);
                startActivityForResult(intent,0);

            }
        });
        Button gotogame = (Button) findViewById(R.id.button);
        gotogame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),game.class);
                startActivityForResult(intent,0);

            }
        });

    }

	// this constantly updates the display for every operation and number that is pressed on

}
