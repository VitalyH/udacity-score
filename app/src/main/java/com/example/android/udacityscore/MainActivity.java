package com.example.android.udacityscore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //declare global variables
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int undoActionA = 0;
    int undoActionB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(scoreTeamA);
        displayForTeamA(scoreTeamB);

        // save the teams names
        Button t1button = (Button) findViewById(R.id.team_a_save);
        Button t2button = (Button) findViewById(R.id.team_b_save);

        t1button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // find the text view for team A
                EditText inputText = (EditText) findViewById(R.id.team_a_input);
                String str = inputText.getText().toString();
                TextView newText = (TextView) findViewById(R.id.team_a_name);
                newText.setText( str);
                //hide text view & button for Team A
                EditText team_a_input = (EditText) findViewById(R.id.team_a_input);
                team_a_input.setVisibility(View.GONE);
                Button team_a_save = (Button) findViewById(R.id.team_a_save);
                team_a_save.setVisibility(View.GONE);
            }
        });

        t2button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //find the text view for team A
                EditText inputText = (EditText) findViewById(R.id.team_b_input);
                String str = inputText.getText().toString();
                TextView newText = (TextView) findViewById(R.id.team_b_name);
                newText.setText( str);
                //hide text view & button for Team B
                EditText team_b_input = (EditText) findViewById(R.id.team_b_input);
                team_b_input.setVisibility(View.GONE);
                Button team_b_save = (Button) findViewById(R.id.team_b_save);
                team_b_save.setVisibility(View.GONE);
            }
        });
    }
    // buttons on click for the Team A
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

    // buttons on click for the Team B
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
    // reset button
    public void Reset(View view) {
        displayForTeamA(scoreTeamA = 0);
        displayForTeamB(scoreTeamB = 0);
        undoActionB = 0;
        undoActionA = 0;
    }
    // undo button
    public void Undo(View view) {
        displayForTeamA(scoreTeamA = scoreTeamA - undoActionA);
        undoActionA = 0;
        displayForTeamB(scoreTeamB = scoreTeamB - undoActionB);
        undoActionB = 0;
    }

    // hide the unneeded views
    public void saveTeamA(View view) {
        EditText team_a_input = (EditText) findViewById(R.id.team_a_input);
        team_a_input.setVisibility(View.GONE);
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
