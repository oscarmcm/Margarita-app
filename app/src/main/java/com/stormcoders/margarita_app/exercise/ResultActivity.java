package com.stormcoders.margarita_app.exercise;

import android.content.ComponentName;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.stormcoders.margarita_app.R;
import com.stormcoders.margarita_app.Utils;

public class ResultActivity  extends ActionBarActivity {
    Utils utils = new Utils();

    final int ExerciseAnswers = 5;
    TextView tvResult;
    ImageView ivResult;
    Button btFinish;
    String prevActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.result_activity);
        utils.toggleHideyBar(this);

        tvResult = (TextView) findViewById(R.id.tvResult);
        ivResult = (ImageView) findViewById(R.id.ivResult);
        btFinish = (Button) findViewById(R.id.btFinish);

        int countOptions = getIntent().getIntExtra("OPTION", 0);
        prevActivity = getIntent().getStringExtra("FROM");

        if(countOptions == ExerciseAnswers) {
            tvResult.setText("FELICIDADES");
            ivResult.setImageResource(R.drawable.medalla);
        }
        else {
            tvResult.setText("CASI LO LOGRAS");
            btFinish.setVisibility(View.VISIBLE);
        }
    }

    public void tryAgain(View view) {
        Intent intent = new Intent();

        switch (prevActivity) {
            case "MultipleChoice":
                intent = new Intent(ResultActivity.this, MultipleChoice.class);
                break;
            case "TrueOrFalse":
                intent = new Intent(ResultActivity.this, TrueOrFalse.class);
                break;
            case "SortEvents":
                intent = new Intent(ResultActivity.this, SortEvents.class);
                break;
        }

        startActivity(intent);
    }
}