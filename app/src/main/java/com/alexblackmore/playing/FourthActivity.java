package com.alexblackmore.playing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class FourthActivity extends AppCompatActivity {

    public String player1NameStr;
    public String player2NameStr;
    public String player3NameStr;
    public String player4NameStr;

    String selectedDiceSides;
    TextView currentPlayerTV;
    Button rollButton;

    String currentPlayerStr;
    TextView subTitleTV;
    int currentPlayerTracker;
    TextView playersRollTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        rollButton = findViewById(R.id.roll_button);
        subTitleTV = findViewById(R.id.subTitle);

        Intent receivedIntentFrom3rdAct = getIntent();
        player1NameStr = receivedIntentFrom3rdAct.getStringExtra(SecondActivity.EXTRA_PLAYER1);
        player2NameStr = receivedIntentFrom3rdAct.getStringExtra(SecondActivity.EXTRA_PLAYER2);
        player3NameStr = receivedIntentFrom3rdAct.getStringExtra(SecondActivity.EXTRA_PLAYER3);
        player4NameStr = receivedIntentFrom3rdAct.getStringExtra(SecondActivity.EXTRA_PLAYER4);

        selectedDiceSides = receivedIntentFrom3rdAct.getStringExtra(ThirdActivity.EXTRA_SELECTEDDICESIDES);

        currentPlayerTracker = 1;

        currentPlayerTV = findViewById(R.id.currentPlayerNameWIdget);

        updateWhoseGoTitle();
    }

    public void rollDice(View view) {
        Random myRandomNumber = new Random();
        int playersRollInt = 1 + myRandomNumber.nextInt(Integer.parseInt(selectedDiceSides));
        playersRollTV = findViewById(R.id.players_roll);
        playersRollTV.setText(String.valueOf(playersRollInt));
    }

    public void nextPlayer(View view) {
        currentPlayerTracker = currentPlayerTracker + 1;

        if (currentPlayerTracker == 5){

            currentPlayerTracker = 1;

        }

        updateWhoseGoTitle();

    }

    public void updateWhoseGoTitle () {

        switch (currentPlayerTracker){

            case 1:
                currentPlayerStr = player1NameStr;
                break;
            case 2:
                currentPlayerStr = player2NameStr;
                break;
            case 3:
                currentPlayerStr = player3NameStr;
                break;
            case 4:
                currentPlayerStr = player4NameStr;
                break;
        }

        currentPlayerTV.setText(currentPlayerStr);
        subTitleTV.setText(getString(R.string.your_go) + " " + selectedDiceSides + ".");

    }
}


