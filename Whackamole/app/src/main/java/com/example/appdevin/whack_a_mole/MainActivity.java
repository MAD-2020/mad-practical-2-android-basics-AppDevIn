package com.example.appdevin.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;



public class MainActivity extends AppCompatActivity {

    final String TAG = "Whack-A-Mole";

    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 2.
        - Feel free to modify the function to suit your program.
    */

    private static final int[] BUTTON_IDS = {R.id.button_01,R.id.button_02,R.id.button_03};
    private static final String[] BUTTON__IDS_TAGS = {"Button Left Clicked!","Button Centre Clicked!","Button Right Clicked!"};

    Integer score = 0;

    TextView txt_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v(TAG, "Finished Pre-Initialisation!");
    }

    @Override
    protected void onStart(){
        super.onStart();
        setNewMole();

        Log.v(TAG, "Starting GUI!");

        txt_score = findViewById(R.id.txt_score);
        txt_score.setText(score.toString());
    }



    public void setNewMole()
    {

        Random ran = new Random();
        int randomLocation = ran.nextInt(3);




        for (int i = 0; i < BUTTON_IDS.length; i++) {

            int id = BUTTON_IDS[i];
            final int finalI = i;

            if(BUTTON_IDS[randomLocation] != id){

                Button button = findViewById(id);

                button.setText("0");

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        score--;
                        txt_score.setText(score.toString());
                        setNewMole();
                        Log.v(TAG, BUTTON__IDS_TAGS[finalI]);
                        Log.v(TAG, "Missed, score deducted!");
                    }
                });
            }
            else{
                Button button = findViewById(id);
                button.setText("*");

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        score++;
                        txt_score.setText(score.toString());

                        setNewMole();
                        Log.v(TAG, BUTTON__IDS_TAGS[finalI]);
                        Log.v(TAG, "Hit, score added!");
                    }
                });
            }

        }

    }


}
