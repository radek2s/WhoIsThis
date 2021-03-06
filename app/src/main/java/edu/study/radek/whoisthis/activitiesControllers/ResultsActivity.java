package edu.study.radek.whoisthis.activitiesControllers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import edu.study.radek.whoisthis.Core;
import edu.study.radek.whoisthis.R;

public class ResultsActivity extends Activity {

    TextView textViewTeamA;
    TextView textViewTeamAP;
    TextView textViewTeamB;
    TextView textViewTeamBP;
    ImageView imgHap;
    ImageView imgSad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        textViewTeamA = (TextView) findViewById(R.id.textViewWinnerName);
        textViewTeamAP= (TextView) findViewById(R.id.textViewWinnerPoints);
        textViewTeamB = (TextView) findViewById(R.id.textViewLooserName);
        textViewTeamBP= (TextView) findViewById(R.id.textViewLooserPoints);
        imgHap = (ImageView) findViewById(R.id.imageViewHappy);
        imgSad = (ImageView) findViewById(R.id.imageViewSad);
        imgHap.setImageResource(R.drawable.icon_happy);
        imgSad.setImageResource(R.drawable.icon_sad);

        setWinner();

    }

    public void back(View view){

        Intent intent = new Intent(this, GamePanelActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    private void setWinner(){

        if ( Core.getInstance().getTeamA().getScore() > Core.getInstance().getTeamB().getScore()){
            textViewTeamA.setText(Core.getInstance().getTeamA().getName());
            textViewTeamAP.setText(String.valueOf(Core.getInstance().getTeamA().getScore()));
            textViewTeamB.setText(Core.getInstance().getTeamB().getName());
            textViewTeamBP.setText(String.valueOf(Core.getInstance().getTeamB().getScore()));
        } else {
            textViewTeamA.setText(Core.getInstance().getTeamB().getName());
            textViewTeamAP.setText(String.valueOf(Core.getInstance().getTeamB().getScore()));
            textViewTeamB.setText(Core.getInstance().getTeamA().getName());
            textViewTeamBP.setText(String.valueOf(Core.getInstance().getTeamA().getScore()));
        }
    }
}