package com.alexblackmore.playing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String EXTRA_PLAYER1 = "com.alexblackmore.playing.extra.PLAYER1";
    private static final String EXTRA_PLAYER2 = "com.alexblackmore.playing.extra.PLAYER2";
    private static final String EXTRA_PLAYER3 = "com.alexblackmore.playing.extra.PLAYER3";
    private static final String EXTRA_PLAYER4 = "com.alexblackmore.playing.extra.PLAYER4";
    public static final String EXTRA_SELECTEDDICESIDES = "com.alexblackmore.playing.extra.SELECTEDDICESIDES";

    public String player1NameStr;
    public String player2NameStr;
    public String player3NameStr;
    public String player4NameStr;

    public Spinner diceSpinner;
    public String selectedDiceSides;

    Intent launch4thIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent receivedIntentFrom2ndAct = getIntent();
        player1NameStr = receivedIntentFrom2ndAct.getStringExtra(SecondActivity.EXTRA_PLAYER1);
        player2NameStr = receivedIntentFrom2ndAct.getStringExtra(SecondActivity.EXTRA_PLAYER2);
        player3NameStr = receivedIntentFrom2ndAct.getStringExtra(SecondActivity.EXTRA_PLAYER3);
        player4NameStr = receivedIntentFrom2ndAct.getStringExtra(SecondActivity.EXTRA_PLAYER4);


        ArrayAdapter<CharSequence> myAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_array, android.R.layout.simple_spinner_item);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        diceSpinner = findViewById(R.id.dice_sides_spinner);

        if (diceSpinner != null) {

            diceSpinner.setAdapter(myAdapter);
            diceSpinner.setOnItemSelectedListener(this);

        }

    }




    public void launchFourthActivity(View view) {

        launch4thIntent = new Intent(this,FourthActivity.class);
        launch4thIntent.putExtra(EXTRA_PLAYER1, player1NameStr);
        launch4thIntent.putExtra(EXTRA_PLAYER2, player2NameStr);
        launch4thIntent.putExtra(EXTRA_PLAYER3, player3NameStr);
        launch4thIntent.putExtra(EXTRA_PLAYER4, player4NameStr);
        launch4thIntent.putExtra(EXTRA_SELECTEDDICESIDES, selectedDiceSides);
        startActivity(launch4thIntent);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedDiceSides = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
