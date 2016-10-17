package com.example.jason.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.Menu;

/**
 * Created by Jason on 10/10/2016.
 */

public class results extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        // if we have stored answers here, we can iterate through them and display each one as a block since the results screen
        // is supposed to display the user's answers I think. Can also iterate through words array to display the word given
        // if we have a score stored as well we'd probably use that too

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