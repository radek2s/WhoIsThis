package edu.study.radek.whoisthis;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
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

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);


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

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }


}
