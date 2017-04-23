package edu.study.radek.whoisthis.activitiesControllers;

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

import edu.study.radek.whoisthis.Core;
import edu.study.radek.whoisthis.R;
import edu.study.radek.whoisthis.models.Loader;

public class GameRound3Activity extends Activity {

    private Loader loader;
    private ImageView images;
    private TextView characterName;
    private Button left;
    private Button right;
    private Button skip;
    private int current = 0;
    private int time = Core.time * 60 * 1000;
    private List<Integer> randoms;
    private ProgressBar progressBar;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_round3);

        /* Setting the application to show in fullscreen */
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /* Load pictures */
        loader = Core.loader;

        /* Find objects */
        images = (ImageView) findViewById(R.id.imageView);
        characterName = (TextView) findViewById(R.id.text_name);
        left  = (Button) findViewById(R.id.btn_left);
        right = (Button) findViewById(R.id.btn_right);
        skip  = (Button) findViewById(R.id.btn_skip3);

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
        countDownTimer.start();

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

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current<loader.getPictures().size()){
                    current++;
                    Core.teamA.addPoint();
                    nextImage(randoms.get(current));
                } else {
                    finishActivity(0);
                }
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current<loader.getPictures().size()){
                    current++;
                    Core.teamB.addPoint();
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

    private void setNameText(){
        left.setText(Core.teamA.getName());
        right.setText(Core.teamB.getName());
    }

    public void random(){
        randoms = new ArrayList<>();
        for(int i = 0; i < loader.getPictures().size(); i++){
            randoms.add(i);
        }
        Collections.shuffle(randoms);

    }
}

