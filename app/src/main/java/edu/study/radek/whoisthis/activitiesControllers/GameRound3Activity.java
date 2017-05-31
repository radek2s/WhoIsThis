package edu.study.radek.whoisthis.activitiesControllers;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.study.radek.whoisthis.Core;
import edu.study.radek.whoisthis.R;
import edu.study.radek.whoisthis.models.Loader;
import edu.study.radek.whoisthis.models.Picture;

public class GameRound3Activity extends Activity {

    private Loader loader;

    private ImageView imageViewPeople;
    private TextView textViewPeople;
    private Button btnLeft;
    private Button btnRight;
    private Button btnSkip;
    private Dialog dialog;

    private int currentIndex = 0;
    private int time = Core.getInstance().getTime() * 60 * 1000;
    private List<Integer> randoms;
    private ProgressBar progressBar;
    private CountDownTimer countDownTimer;

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_round3);

        /* Setting the application to show in fullscreen */
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /* Load pictures */
        loader = Core.getInstance().getLoader();

        /* Find objects */
        imageViewPeople = (ImageView) findViewById(R.id.imageView);
        textViewPeople = (TextView) findViewById(R.id.text_name);
        btnLeft = (Button) findViewById(R.id.btn_left);
        btnRight = (Button) findViewById(R.id.btn_right);
        btnSkip = (Button) findViewById(R.id.btn_skip3);

        /* Prepare environment */
        random();
        setNameText();
        addListenerOnButton();

        progressBar = (ProgressBar) findViewById(R.id.progressBar4);
        progressBar.setProgress(100);


        countDownTimer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int progress = (int) (100*millisUntilFinished/time);
                progressBar.setProgress(progress);
            }

            @Override
            public void onFinish() {
                progressBar.setProgress(0);
                play();
            }
        };
        showStartDialog();


    }

    public void play(){
        Intent intent = new Intent(this, ResultsActivity.class);
        startActivity(intent);
    }

    public void nextImage(int i){
        imageViewPeople.setImageResource(loader.getPictures().get(i).getSrc());
        textViewPeople.setText(loader.getPictures().get(i).getName());
        int remain = Core.getInstance().getDifficulty() - Core.getInstance().getTeamA().getUsedSkips();

        btnSkip.setEnabled(true);
        if ( remain <= 0 ){
            btnSkip.setEnabled(false);
        }
        btnSkip.setText(getString(R.string.button_skip) + " (" + remain + ")");

    }

    public void addListenerOnButton(){

        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentIndex <loader.getPictures().size()){
                    currentIndex++;
                    Core.getInstance().getTeamA().addPoint();
                    nextImage(randoms.get(currentIndex));
                } else {
                    finishActivity(0);
                }
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentIndex <loader.getPictures().size()){
                    currentIndex++;
                    Core.getInstance().getTeamB().addPoint();
                    nextImage(randoms.get(currentIndex));
                } else {
                    finishActivity(0);
                }
            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(currentIndex < loader.getPictures().size()){
                    Core.getInstance().getSkippedCharacters().add(new Picture(
                            loader.getPictures().get(randoms.get(currentIndex)).getName(),
                            loader.getPictures().get(randoms.get(currentIndex)).getSrc()));
                    currentIndex++;
                    Core.getInstance().getTeamA().skip();
                    nextImage(randoms.get(currentIndex));
                } else {
                    finishActivity(0);
                }
            }
        });

    }

    private void setNameText(){
        btnLeft.setText(Core.getInstance().getTeamA().getName());
        btnRight.setText(Core.getInstance().getTeamB().getName());
    }

    public void random(){
        randoms = new ArrayList<>();
        for(int i = 0; i < loader.getPictures().size(); i++){
            randoms.add(i);
        }
        Collections.shuffle(randoms);
    }

    public void showStartDialog(){
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_next_team);

        dialog.setTitle(R.string.startDialog_intro);
        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.start();
                dialog.dismiss();
                currentIndex++;
                nextImage(randoms.get(currentIndex));
            }
        });
        dialog.show();
    }

}