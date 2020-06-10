package com.alexblackmore.playing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_PLAYER1 = "com.alexblackmore.playing.extra.PLAYER1";
    public static final String EXTRA_PLAYER2 = "com.alexblackmore.playing.extra.PLAYER2";
    public static final String EXTRA_PLAYER3 = "com.alexblackmore.playing.extra.PLAYER3";
    public static final String EXTRA_PLAYER4 = "com.alexblackmore.playing.extra.PLAYER4";

    public EditText player1NameET;
    public EditText player2NameET;
    public EditText player3NameET;
    public EditText player4NameET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        player1NameET = (EditText) findViewById(R.id.player1_input);
        player2NameET = findViewById(R.id.player2_input);
        player3NameET = findViewById(R.id.player3_input);
        player4NameET = findViewById(R.id.player4_input);

    }

    public void launchThirdActivity(View view) {

        Intent launch3rdIntent = new Intent(this,ThirdActivity.class);
        launch3rdIntent.putExtra(EXTRA_PLAYER1, player1NameET.getText().toString());
        launch3rdIntent.putExtra(EXTRA_PLAYER2, player2NameET.getText().toString());
        launch3rdIntent.putExtra(EXTRA_PLAYER3, player3NameET.getText().toString());
        launch3rdIntent.putExtra(EXTRA_PLAYER4, player4NameET.getText().toString());
        startActivity(launch3rdIntent);

    }
}
