package edu.study.radek.whoisthis.activitiesControllers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import edu.study.radek.whoisthis.R;


public class GamePanelActivity extends Activity {

    public static final String GAME_TYPE = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_game_panel);

        Button btn_exit = (Button) findViewById(R.id.btnExit);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exit();
            }
        });

    }

    /*
     * Play in 3 players mode button reaction
     */
    public void play3(View view){
        Intent intent = new Intent(this, IntroductionActivity.class);
        String type = "3";
        intent.putExtra(GAME_TYPE, type);
        startActivity(intent);

    }

    /*
     * Play in 4 players mode+ button reaction
     */
    public void play4(View view){
        Intent intent = new Intent(this, IntroductionActivity.class);
        String type = "4";
        intent.putExtra(GAME_TYPE, type);
        startActivity(intent);
    }

    public void openSettings(View view){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void exit(){
        System.exit(0);
    }


}
