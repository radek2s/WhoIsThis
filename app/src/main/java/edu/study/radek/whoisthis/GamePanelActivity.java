package edu.study.radek.whoisthis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class GamePanelActivity extends Activity {

    public static final String TEAM_A_NAME = "name";
    public static final String TEAM_B_NAME = "name";
    private Button btn_exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_game_panel);

        btn_exit = (Button) findViewById(R.id.btnExit);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exit();
            }
        });

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }

    public void play(View view){
        Intent intent = new Intent(this, GameRoundActivity.class);
        EditText editTextA = (EditText) findViewById(R.id.editTextTeamA);
        EditText editTextB = (EditText) findViewById(R.id.editTextTeamB);

        Team teamA = new Team();
        Team teamB = new Team();
        teamA.setName(editTextA.getText().toString().trim());
        teamB.setName(editTextB.getText().toString().trim());
        intent.putExtra(TEAM_A_NAME, teamA.getName());
        intent.putExtra(TEAM_B_NAME, teamB.getName());
        startActivity(intent);

    }

    public void exit(){
        System.exit(0);
    }


}
