package edu.study.radek.whoisthis.activitiesControllers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import edu.study.radek.whoisthis.Core;
import edu.study.radek.whoisthis.R;

public class CreateTeamActivity extends Activity {

    int type;
    TextView textViewTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_create_team);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent intent = getIntent();
        String types = intent.getStringExtra(IntroductionActivity.GAME_TYPE);
        type = Integer.parseInt(types);

        textViewTeam = (TextView) findViewById(R.id.textViewGameType);
        if (type == 3){
            textViewTeam.setText(R.string.button_play);
        } else {
            textViewTeam.setText(R.string.button_play2);
        }


    }

    public void play(View view){

        Intent intent;
        if (type == 3){
            intent = new Intent(this, GameRound3Activity.class);
        } else {
            intent = new Intent(this, GameRoundActivity.class);
        }

        EditText teamA = (EditText) findViewById(R.id.editTextTeamNameA);
        EditText teamB = (EditText) findViewById(R.id.editTextTeamNameB);

        Core.teamA.setName(teamA.getText().toString().trim());
        Core.teamB.setName(teamB.getText().toString().trim());
        Core.teamA.resetPoints();
        Core.teamB.resetPoints();

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }


}
