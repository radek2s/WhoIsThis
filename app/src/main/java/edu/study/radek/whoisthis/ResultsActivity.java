package edu.study.radek.whoisthis;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class ResultsActivity extends Activity {

    TextView teamA;
    TextView teamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        teamA = (TextView) findViewById(R.id.textViewTeamA);
        teamB = (TextView) findViewById(R.id.textViewTeamB);

        teamA.setText(Core.teamA.getName());
        teamB.setText(Core.teamB.getName());

    }
}
