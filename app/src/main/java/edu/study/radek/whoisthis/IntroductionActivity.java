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
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class IntroductionActivity extends Activity {

    public static final String GAME_TYPE = "0";
    TextView textInfo;
    int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Intent intent = getIntent();
        String types = intent.getStringExtra(GamePanelActivity.GAME_TYPE);
        type = Integer.parseInt(types);

        textInfo = (TextView) findViewById(R.id.textIntro);
        if (type == 3){
            textInfo.setText(R.string.instruction_3players);
        } else {
            textInfo.setText(R.string.instruction_4players);
        }
    }

    public void play(View view){
        Intent intent = new Intent(this, CreateTeamActivity.class);
        intent.putExtra(GAME_TYPE, String.valueOf(type));
        startActivity(intent);
    }

}
