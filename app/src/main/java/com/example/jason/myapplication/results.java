package com.example.jason.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.jason.myapplication.game.answers;
import static com.example.jason.myapplication.game.score;

/**
 * Created by Jason on 10/10/2016.
 */

public class results extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        final TextView GameText = (TextView) findViewById(R.id.textView2) ;
        final TextView result = (TextView) findViewById(R.id.textView4) ;
        final String[] com = getResources().getStringArray(R.array.answers);
        final String[] questions = getResources().getStringArray(R.array.word);
        final String[] answers = game.answers;

        result.setText("Question # 1: " + questions[0] +" Answer # 1: " + answers[0]+ compare(answers[0],com[0]) +"\n" +
                "Question # 2: " + questions[1] +" Answer # 2: " + answers[1]+compare(answers[1],com[1]) +"\n" +
                "Question # 3: " + questions[2] +" Answer # 3: " + answers[2]+compare(answers[2],com[2]) +"\n" +
                "Question # 4: " + questions[3] +" Answer # 4: " + answers[3]+compare(answers[3],com[3]) +"\n" +
                "Question # 5: " + questions[4] +" Answer # 5: " + answers[4]+compare(answers[4],com[4]) +"\n" );
        GameText.setText(score + "/5" );
        Button mainmenu = (Button) findViewById(R.id.button3);
        mainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = 0;
                game.answers = null;
                Intent intent = new Intent(v.getContext(),MainActivity.class);
                startActivityForResult(intent,0);

            }
        });


    }

    public String compare(String a, String b) {
        if(a.equals(b)){
            score +=1;
            return " Correct";
        }else{
            return " Wrong";
        }
    }

}