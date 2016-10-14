package com.example.jason.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class game extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.active2);

        final TextView GameText = (TextView) findViewById(R.id.textView3) ;
        final String[] words = getResources().getStringArray(R.array.word);
        GameText.setText(words[0]);
        final int[] counter = {1};
        Button submit = (Button) findViewById(R.id.button4);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameText.setText(words[counter[0]]);
                counter[0] +=1;

            }
        });

        Button mainmenu = (Button) findViewById(R.id.button3);
        mainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),MainActivity.class);
                startActivityForResult(intent,0);

            }
        });
    }

}

