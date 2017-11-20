package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.scorekeeper.R;

public class MainActivity extends AppCompatActivity {
    //set score for team A
    int scoreTeamA = 0;
    int scoreTeamB = 0;

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
    }

    public void plusTwoA(View view) {
        displayForTeamA(scoreTeamA = scoreTeamA + 2);
    }

    public void FreeDrawA(View view) {
        displayForTeamA(scoreTeamA = scoreTeamA + 1);
    }

    //buttons on click for Team B
    public void plusThreeB(View view) {
        displayForTeamB(scoreTeamB = scoreTeamB + 3);
    }

    public void plusTwoB(View view) {
        displayForTeamB(scoreTeamB = scoreTeamB + 2);
    }

    public void FreeDrawB(View view) {
        displayForTeamB(scoreTeamB = scoreTeamB + 1);
    }
    //reset button
    public void Reset(View view) {
        displayForTeamA(scoreTeamA = 0);
        displayForTeamB(scoreTeamB = 0);
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
