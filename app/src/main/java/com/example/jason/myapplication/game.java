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
        final TextView CounterText = (TextView) findViewById(R.id.textView4) ; // meant to hold current number of words completed out of total words (e.g. 4/9)
        final String[] words = getResources().getStringArray(R.array.word);
        GameText.setText(words[0]);
        final int[] counter = {1};

        //need to add a timer somewhere

        Button submit = (Button) findViewById(R.id.button4);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // maybe check if words array is empty, and if so, then set current word to first word
                // in new "skip" word array, since we're supposed to let people come back to skipped
                // words later
                GameText.setText(words[counter[0]]);
                counter[0] +=1; // can use the counter to set current number of words completed string, and use length of words to set the total number of words (e.g 4 words completed out of 9 words in total)

            }
        });

        Button skip = (Button) findViewById(R.id.button6);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // currently empty but potentially do the same as submit, but don't record the answer
                // and instead store the skipped word in a skipped words array to be displayed later

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

