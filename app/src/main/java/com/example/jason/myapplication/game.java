package com.example.jason.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class game extends Activity {
    static int score = 0;
    static String[] answers = new String[5];
    static int tracker = 1;
    static int skipcounter = 0;
    static int counter = 1;
    static int what = 0 ;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.active2);
        final TextView CounterText = (TextView) findViewById(R.id.textView5) ;
        final EditText editext = (EditText) findViewById(R.id.editText);
        final TextView GameText = (TextView) findViewById(R.id.textView3) ;
        final String[] words = getResources().getStringArray(R.array.word);
        final String[] skipped = new String[5];
        final int[] whatskipped = new int[5];
        final TextView timer = (TextView) findViewById(R.id.textView6) ;
        final Intent intent = new Intent(game.this, MainActivity.class);
        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
               startActivity(intent);
            }
        }.start();



        CounterText.setText("Question # 1" );
        GameText.setText(words[0]);

        Button submit = (Button) findViewById(R.id.button4);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter != 5) {
                    answers[tracker-1] = String.valueOf(editext.getText());
                    tracker +=1;
                    editext.setText("");
                    GameText.setText(words[counter]);
                    counter += 1;
                    CounterText.setText("Question # " + tracker);
                }else if(skipcounter != 0){
                    answers[tracker-1] = String.valueOf(editext.getText());
                    tracker = whatskipped[what-1];
                    what-=1;
                    CounterText.setText("Question # " + tracker);
                    editext.setText("");
                    GameText.setText(skipped[skipcounter-1]);
                    skipcounter-=1;
                }else{
                    answers[tracker-1] = String.valueOf(editext.getText());
                    counter = 1;
                    tracker = 0;
                    what = 0;
                    skipcounter = 0;
                    Intent intent = new Intent(v.getContext(),results.class);
                    startActivityForResult(intent,0);
                }

            }
        });

        Button skip = (Button) findViewById(R.id.button6);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter != 5) {
                    whatskipped[what] = tracker;
                    what+=1;
                    skipped[skipcounter] = words[counter-1];
                    tracker+=1;
                    skipcounter +=1;
                    editext.setText("");
                    CounterText.setText("Question # " + tracker);
                    GameText.setText(words[counter]);
                    counter += 1;
                }
            }
        });

        Button mainmenu = (Button) findViewById(R.id.button3);
        mainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = 1;
                tracker = 1;
                answers = null;
                skipcounter = 0;
                Intent intent = new Intent(v.getContext(),MainActivity.class);
                startActivityForResult(intent,0);

            }
        });
    }

}
