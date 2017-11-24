package com.example.android.udacityscore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    //global variables
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int undoActionA = 0;
    int undoActionB = 0;

    //rotation state check and save
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putInt("scoreA", scoreTeamA);
        savedInstanceState.putInt("scoreB", scoreTeamB);
        savedInstanceState.putInt("undoA", undoActionA);
        savedInstanceState.putInt("undoB", undoActionB);
        super.onSaveInstanceState(savedInstanceState);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //restore score values, keeps undo values
        if (savedInstanceState != null) {
            scoreTeamA = savedInstanceState.getInt("scoreA");
            scoreTeamB = savedInstanceState.getInt("scoreB");
            undoActionA = savedInstanceState.getInt("undoA");
            undoActionB = savedInstanceState.getInt("undoB");
            //print scores after restoration
            TextView scoreViewA = (TextView) findViewById(R.id.team_a_score);
            scoreViewA.setText(String.valueOf(scoreTeamA));
            TextView scoreViewB = (TextView) findViewById(R.id.team_b_score);
            scoreViewB.setText(String.valueOf(scoreTeamB));

            //keeps A Team input field and save button hidden
            EditText team_a_input = (EditText) findViewById(R.id.team_a_input);
            team_a_input.setVisibility(View.GONE);
            Button team_a_save = (Button) findViewById(R.id.team_a_save);
            team_a_save.setVisibility(View.GONE);

            //keeps B Team input field and save button hidden
            EditText team_b_input = (EditText) findViewById(R.id.team_b_input);
            team_b_input.setVisibility(View.GONE);
            Button team_b_save = (Button) findViewById(R.id.team_b_save);
            team_b_save.setVisibility(View.GONE);
        }


        /**
         * Saving the teams names.
         */
        // get the buttons ID's
        Button t1button = (Button) findViewById(R.id.team_a_save);
        Button t2button = (Button) findViewById(R.id.team_b_save);

        // listener for Team A name
        t1button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // find the text view for team A
                EditText inputText = (EditText) findViewById(R.id.team_a_input);
                String strA = inputText.getText().toString();
                TextView newText = (TextView) findViewById(R.id.team_a_name);
                newText.setText(strA);

                //hide text view & button for Team A
                EditText team_a_input = (EditText) findViewById(R.id.team_a_input);
                team_a_input.setVisibility(View.GONE);
                Button team_a_save = (Button) findViewById(R.id.team_a_save);
                team_a_save.setVisibility(View.GONE);

            }
        });

        // listener for Team B name
        t2button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //find the text view for team A
                EditText inputText = (EditText) findViewById(R.id.team_b_input);
                String strB = inputText.getText().toString();
                TextView newText = (TextView) findViewById(R.id.team_b_name);
                newText.setText(strB);

                //hide text view & button for Team B
                EditText team_b_input = (EditText) findViewById(R.id.team_b_input);
                team_b_input.setVisibility(View.GONE);
                Button team_b_save = (Button) findViewById(R.id.team_b_save);
                team_b_save.setVisibility(View.GONE);

            }
        });
    }


    /**
     * Buttons with scores for both teams.
     */
    // for the Team A
    public void plusThreeA(View view) {
        displayForTeamA(scoreTeamA = scoreTeamA + 3);
        undoActionA = 3;
        undoActionB = 0;
    }

    public void plusTwoA(View view) {
        displayForTeamA(scoreTeamA = scoreTeamA + 2);
        undoActionA = 2;
        undoActionB = 0;
    }

    public void FreeDrawA(View view) {
        displayForTeamA(scoreTeamA = scoreTeamA + 1);
        undoActionA = 1;
        undoActionB = 0;
    }

    // for the Team B
    public void plusThreeB(View view) {
        displayForTeamB(scoreTeamB = scoreTeamB + 3);
        undoActionB = 3;
        undoActionA = 0;
    }

    public void plusTwoB(View view) {
        displayForTeamB(scoreTeamB = scoreTeamB + 2);
        undoActionB = 2;
        undoActionA = 0;
    }

    public void FreeDrawB(View view) {
        displayForTeamB(scoreTeamB = scoreTeamB + 1);
        undoActionB = 1;
        undoActionA = 0;
    }

    /**
     * Reset button.
     */
    public void Reset(View view) {
        //reset score and hidden "undo" values
        displayForTeamA(scoreTeamA = 0);
        displayForTeamB(scoreTeamB = 0);
        undoActionB = 0;
        undoActionA = 0;

        //reset Team A name
        EditText team_a_input = (EditText) findViewById(R.id.team_a_input);
        team_a_input.setVisibility(View.VISIBLE);
        Button team_a_save = (Button) findViewById(R.id.team_a_save);
        team_a_save.setVisibility(View.VISIBLE);
        String str_a = "Team A";
        TextView team_a_name = (TextView) findViewById(R.id.team_a_name);
        team_a_name.setText(str_a);

        //reset Team B name
        EditText team_b_input = (EditText) findViewById(R.id.team_b_input);
        team_b_input.setVisibility(View.VISIBLE);
        Button team_b_save = (Button) findViewById(R.id.team_b_save);
        team_b_save.setVisibility(View.VISIBLE);
        String str_b = "Team B";
        TextView team_b_name = (TextView) findViewById(R.id.team_b_name);
        team_b_name.setText(str_b);
    }

    /**
     * Basic "Undo" button.
     */
    public void Undo(View view) {
        displayForTeamA(scoreTeamA = scoreTeamA - undoActionA);
        undoActionA = 0;
        displayForTeamB(scoreTeamB = scoreTeamB - undoActionB);
        undoActionB = 0;
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int scoreTeamA) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(scoreTeamA));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int scoreTeamB) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(scoreTeamB));
    }


}
