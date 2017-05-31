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

public class GameRoundActivity extends Activity{

    Loader loader;

    ImageView imageViewPeople;
    TextView textViewPeople;
    TextView textViewTeamName;
    Button btnNext;
    Button btnSkip;
    ProgressBar progressBar;
    Dialog dialog;

    int currentIndex = 0;
    int currentRound = 0;
    int activeTeam   = 0;
    int time         = Core.getInstance().getTime() * 60 * 1000;
    List<Integer> randoms;
    CountDownTimer countDownTimer;
    CountDownTimer countDownTimer2;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game_round);
        /* Setting the application to show in fullscreen */
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /* Load pictures */
        loader = Core.getInstance().getLoader();

        /* Find objects */
        imageViewPeople =   (ImageView) findViewById(R.id.imageView);
        textViewPeople =    (TextView) findViewById(R.id.text_name);
        textViewTeamName =  (TextView) findViewById(R.id.textViewTeamNameRound);
        btnNext =           (Button) findViewById(R.id.btn_Corr);
        btnSkip =           (Button) findViewById(R.id.btn_Skip);

        /* Prepare environment */
        textViewTeamName.setText(Core.getInstance().getTeamA().getName());
        random();
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

                showStartDialog(1);

            }
        };
        countDownTimer2 = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int progress = (int) (100*millisUntilFinished/time);
                progressBar.setProgress(progress);
            }

            @Override
            public void onFinish() {

                if ( currentRound < Core.getInstance().getRounds() - 1 ){
                    currentRound++;
                    showStartDialog(0);
                } else {
                    currentRound = 0;
                    play();
                }

            }
        };

        /* After initialization start game by showing start dialog */
        showStartDialog(0);

    }

    /**
     * play
     * Start another activity. Show results
     */
    public void play(){
        Intent intent = new Intent(this, ResultsActivity.class);
        startActivity(intent);
    }

    /**
     * nextImage
     * @param i - random parameter
     *          Based on the parameter show image from arrayList under this index
     *          Refresh also the Skip_Button label by checking which team is currently
     *          active and how many skips remain for them
     */
    public void nextImage(int i){
        imageViewPeople.setImageResource(loader.getPictures().get(i).getSrc());
        textViewPeople.setText(loader.getPictures().get(i).getName());
        btnSkip.setEnabled(true);
        if ( activeTeam == 0 ){
            int remain = Core.getInstance().getDifficulty() - Core.getInstance().getTeamA().getUsedSkips();
            if ( remain <= 0 ){
                btnSkip.setEnabled(false);
            }
            btnSkip.setText(getString(R.string.button_skip) + " (" + remain + ")");
        } else {
            int remain = Core.getInstance().getDifficulty() - Core.getInstance().getTeamB().getUsedSkips();
            if ( remain <= 0 ){
                btnSkip.setEnabled(false);
            }
            btnSkip.setText(getString(R.string.button_skip) + " (" + remain + ")");
        }
    }

    /**
     * showStartDialog
     * @param team - active team ["0","1"]
     *
     *             Depends of active team show different dialogs
     *             and start different counters.
     */
    public void showStartDialog(int team){
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_next_team);
        TextView dialogText = (TextView) dialog.findViewById(R.id.dialogText);

        if ( team == 0 ){
            dialog.setTitle(Core.getInstance().getTeamA().getName() + " - przygotujcie się!");
            Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
            dialogText.setText(Core.getInstance().getTeamB().getScore() + getString(R.string.dialog_next));
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    progressBar.setProgress(0);
                    textViewTeamName.setText(Core.getInstance().getTeamA().getName());
                    activeTeam = 0;
                    countDownTimer.start();
                    dialog.dismiss();

                    currentIndex++;
                    nextImage(randoms.get(currentIndex));
                }
            });

        } else {
            dialog.setTitle(Core.getInstance().getTeamB().getName() + " - przygotujcie się!");
            Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
            dialogText.setText(Core.getInstance().getTeamA().getScore() + getString(R.string.dialog_next));
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    progressBar.setProgress(0);
                    textViewTeamName.setText(Core.getInstance().getTeamB().getName());
                    activeTeam = 1;
                    countDownTimer2.start();
                    dialog.dismiss();

                    currentIndex++;
                    nextImage(randoms.get(currentIndex));
                }
            });

        }
        dialog.show();

    }

    public void addListenerOnButton(){

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentIndex <loader.getPictures().size()){
                    currentIndex++;
                    if(activeTeam==0){
                        Core.getInstance().getTeamA().addPoint();
                    } else {
                        Core.getInstance().getTeamB().addPoint();
                    }
                    nextImage(randoms.get(currentIndex));
                } else {
                    finishActivity(0);
                }
            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentIndex <loader.getPictures().size()){
                    Core.getInstance().getSkippedCharacters().add(new Picture(
                            loader.getPictures().get(randoms.get(currentIndex)).getName(),
                            loader.getPictures().get(randoms.get(currentIndex)).getSrc()));
                    currentIndex++;
                    if(activeTeam==0){
                        Core.getInstance().getTeamA().skip();
                    } else {
                        Core.getInstance().getTeamB().skip();
                    }
                    nextImage(randoms.get(currentIndex));
                } else {
                    finishActivity(0);
                }
            }
        });



    }

    /**
     * random - generates random order inside randoms arrayList
     */
    public void random(){
        randoms = new ArrayList<>();
        for(int i = 0; i < loader.getPictures().size(); i++){
            randoms.add(i);
        }
        Collections.shuffle(randoms);

    }

}
