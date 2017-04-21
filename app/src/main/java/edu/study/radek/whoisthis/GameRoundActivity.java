package edu.study.radek.whoisthis;

import android.app.Activity;
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

import edu.study.radek.whoisthis.models.Loader;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class GameRoundActivity extends Activity{


    Loader loader;
    ImageView images;
    TextView characterName;
    TextView teamName;
    Button next;
    Button skip;
    Button end;
    int current = 0;
    int activeTeam = 0;
    List<Integer> randoms;
    ProgressBar progressBar;
    CountDownTimer countDownTimer;
    CountDownTimer countDownTimer2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game_round);
        /* Setting the application to show in fullscreen */
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /* Load pictures */
        loader = Core.loader;

        /* Find objects */
        images = (ImageView) findViewById(R.id.imageView);
        characterName = (TextView) findViewById(R.id.text_name);
        teamName = (TextView) findViewById(R.id.textViewTeamNameRound);
        next = (Button) findViewById(R.id.btn_Corr);
        skip = (Button) findViewById(R.id.btn_Skip);
        end =  (Button) findViewById(R.id.btnExit);


        /* Prepare environment */
        teamName.setText(Core.teamA.getName());
        random();
        addListenerOnButton();

        progressBar = (ProgressBar) findViewById(R.id.progressBar4);
        progressBar.setProgress(100);


        countDownTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int progress = (int) (100*millisUntilFinished/60000);
                progressBar.setProgress(progress);
            }

            @Override
            public void onFinish() {
                progressBar.setProgress(0);
                teamName.setText(Core.teamB.getName());
                activeTeam=1;
                countDownTimer2.start();
            }
        };
        countDownTimer.start();

        countDownTimer2 = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int progress = (int) (100*millisUntilFinished/60000);
                progressBar.setProgress(progress);
            }

            @Override
            public void onFinish() {
                play();
            }
        };
    }

    public void play(){
        Intent intent = new Intent(this, ResultsActivity.class);
        startActivity(intent);
    }

    public void nextImage(int i){
        images.setImageResource(loader.getPictures().get(i).getSrc());
        characterName.setText(loader.getPictures().get(i).getName());
    }

    public void addListenerOnButton(){

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current<loader.getPictures().size()){
                    current++;
                    if(activeTeam==0){
                        Core.teamA.addPoint();
                    } else {
                        Core.teamB.addPoint();
                    }
                    nextImage(randoms.get(current));
                } else {
                    finishActivity(0);
                }
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current<loader.getPictures().size()){
                    current++;
                    nextImage(randoms.get(current));
                } else {
                    finishActivity(0);
                }
            }
        });



    }



    public void random(){
        randoms = new ArrayList<>();
        for(int i = 0; i < loader.getPictures().size(); i++){
            randoms.add(i);
        }
        Collections.shuffle(randoms);

    }

}
