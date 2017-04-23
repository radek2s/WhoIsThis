package edu.study.radek.whoisthis.activitiesControllers;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;

import edu.study.radek.whoisthis.Core;
import edu.study.radek.whoisthis.R;

public class SettingsActivity extends Activity {

    RadioButton radiobuttonRoundMin;
    RadioButton radiobuttonRoundMid;
    RadioButton radiobuttonRoundMax;
    RadioButton radiobuttonTimeMin;
    RadioButton radiobuttonTimeMid;
    RadioButton radiobuttonTimeMax;
    RadioButton radiobuttonDiffMin;
    RadioButton radiobuttonDiffMid;
    RadioButton radiobuttonDiffMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        prepareRadioButtons();
    }

    /**
     * Prepare view based on the variables stored inside Core
     */
    private void prepareRadioButtons(){

        radiobuttonRoundMin = (RadioButton) findViewById(R.id.rbR1);
        radiobuttonRoundMid = (RadioButton) findViewById(R.id.rbR2);
        radiobuttonRoundMax = (RadioButton) findViewById(R.id.rbR3);

        radiobuttonTimeMin = (RadioButton) findViewById(R.id.rbT1);
        radiobuttonTimeMid = (RadioButton) findViewById(R.id.rbT2);
        radiobuttonTimeMax = (RadioButton) findViewById(R.id.rbT3);

        radiobuttonDiffMin = (RadioButton) findViewById(R.id.rbS1);
        radiobuttonDiffMid = (RadioButton) findViewById(R.id.rbS2);
        radiobuttonDiffMax = (RadioButton) findViewById(R.id.rbS3);

        if (Core.rounds == 1){
            radiobuttonRoundMin.toggle();
        } else if (Core.rounds == 3) {
            radiobuttonRoundMid.toggle();
        } else {
            radiobuttonRoundMax.toggle();
        }

        if (Core.time == 2){
            radiobuttonTimeMin.toggle();
        } else if (Core.time == 3){
            radiobuttonTimeMid.toggle();
        } else {
            radiobuttonTimeMax.toggle();
        }

        if (Core.difficulty == 10){
            radiobuttonDiffMin.toggle();
        } else if (Core.difficulty == 5){
            radiobuttonDiffMid.toggle();
        } else {
            radiobuttonDiffMax.toggle();
        }

    }

    public void onRadioButtonClicked(View view){

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            /* Setting rounds */
            case R.id.rbR1:
                if (checked){
                    Core.rounds = 1;
                }
                break;
            case R.id.rbR2:
                if (checked){
                    Core.rounds = 3;
                }
                break;
            case R.id.rbR3:
                if (checked){
                    Core.rounds = 5;
                }
                break;
            /* Setting Time */
            case R.id.rbT1:
                if (checked){
                    Core.time = 2;
                }
                break;
            case R.id.rbT2:
                if (checked){
                    Core.time = 3;
                }
                break;
            case R.id.rbT3:
                if (checked){
                    Core.time = 5;
                }
                break;
            /* Setting difficulty */
            case R.id.rbS1:
                if (checked){
                    Core.difficulty = 10;
                }
                break;
            case R.id.rbS2:
                if (checked){
                    Core.difficulty = 5;
                }
                break;
            case R.id.rbS3:
                if (checked){
                    Core.difficulty = 3;
                }
                break;

        }

    }

    public void onReturnButtonClicked(View view){

        Intent intent = new Intent(this, GamePanelActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
