package edu.study.radek.whoisthis;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class GameRoundActivity extends Activity{


    Loader loader;
    ImageView images;
    TextView textName;
    Button next;
    Button skip;
    Button end;
    int current = 0;
    List<Integer> randoms;
    ProgressBar progressBar;
    CountDownTimer countDownTimer;



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
        textName = (TextView) findViewById(R.id.text_name);
        next = (Button) findViewById(R.id.btn_Corr);
        skip = (Button) findViewById(R.id.btn_Skip);
        end =  (Button) findViewById(R.id.btnExit);

        /* Prepare environment */
        random();
        addListenerOnButton();

        progressBar = (ProgressBar) findViewById(R.id.progressBar4);
        progressBar.setProgress(100);


        countDownTimer = new CountDownTimer(120000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int progress = (int) (millisUntilFinished/1000);
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
        textName.setText(loader.getPictures().get(i).getName());
    }

    public void addListenerOnButton(){

        next.setOnClickListener(new View.OnClickListener() {
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
