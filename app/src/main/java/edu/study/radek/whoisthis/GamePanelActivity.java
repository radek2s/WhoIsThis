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

    public static final String GAME_TYPE = "0";
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

    public void play3(View view){
        Intent intent = new Intent(this, IntroductionActivity.class);
        String type = "3";
        intent.putExtra(GAME_TYPE, type);
        startActivity(intent);

    }

    public void play4(View view){
        Intent intent = new Intent(this, IntroductionActivity.class);
        String type = "4";
        intent.putExtra(GAME_TYPE, type);
        startActivity(intent);
    }

    public void exit(){
        System.exit(0);
    }


}
