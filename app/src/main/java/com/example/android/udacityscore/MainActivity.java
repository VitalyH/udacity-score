package com.example.android.udacityscore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //declare all variables
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
    }
    //buttons on click for Team A
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

    //buttons on click for Team B
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
    //reset button
    public void Reset(View view) {
        displayForTeamA(scoreTeamA = 0);
        displayForTeamB(scoreTeamB = 0);
        undoActionB = 0;
        undoActionA = 0;
    }
    //undo button
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
