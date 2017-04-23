package edu.study.radek.whoisthis.activitiesControllers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import edu.study.radek.whoisthis.R;

public class IntroductionActivity extends Activity {

    public static final String GAME_TYPE = "0";
    TextView textInfo;
    int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        switchInstruction(getIntent());
    }

    public void play(View view){
        Intent intent = new Intent(this, CreateTeamActivity.class);
        intent.putExtra(GAME_TYPE, String.valueOf(type));
        startActivity(intent);
    }

    /**
     * @param intent
     * Reading ExtraString with game type
     */
    private void switchInstruction(Intent intent){

        String types = intent.getStringExtra(GamePanelActivity.GAME_TYPE);
        type = Integer.parseInt(types);

        textInfo = (TextView) findViewById(R.id.textIntro);
        if (type == 3){
            textInfo.setText(R.string.instruction_3players);
        } else {
            textInfo.setText(R.string.instruction_4players);
        }
    }

}
