package edu.study.radek.whoisthis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class ResultsActivity extends Activity {

    TextView teamA;
    TextView teamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        teamA = (TextView) findViewById(R.id.textViewTeamA);
        teamB = (TextView) findViewById(R.id.textViewTeamB);

        setWinner();

    }

    public void back(View view){

        Intent intent = new Intent(this, GamePanelActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    private void setWinner(){

        if ( Core.teamA.getScore() > Core.teamB.getScore()){
            teamA.setText(Core.teamA.getName());
            teamB.setText(Core.teamB.getName());
        } else {
            teamA.setText(Core.teamB.getName());
            teamB.setText(Core.teamA.getName());
        }
    }
}
