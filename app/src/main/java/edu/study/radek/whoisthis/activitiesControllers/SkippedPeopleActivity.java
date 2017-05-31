package edu.study.radek.whoisthis.activitiesControllers;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import edu.study.radek.whoisthis.Core;
import edu.study.radek.whoisthis.R;
import edu.study.radek.whoisthis.models.Picture;

public class SkippedPeopleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skipped_people);

        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayoutResults);

        linearLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        if ( Core.getInstance().getSkippedCharacters().isEmpty() ){
            TextView info = new TextView(this);
            info.setText("No data!");
            info.setGravity(Gravity.CENTER);
            info.setHeight(40);
            linearLayout.addView(info);
        } else {
            linearLayout.removeAllViews();
            for (Picture picture : Core.getInstance().getSkippedCharacters()){
                LinearLayout ll = new LinearLayout(this);
                ll.setOrientation(LinearLayout.VERTICAL);
                ll.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));

                ImageView pictureView = new ImageView(this);
                pictureView.setImageResource(picture.getSrc());
                ll.addView(pictureView);

                TextView pictureDesc = new TextView(this);
                pictureDesc.setText(picture.getName());
                pictureDesc.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
                pictureDesc.setHeight(20);
                ll.addView(pictureDesc);

                linearLayout.addView(ll);
            }

        }


    }
}
