package com.example.lguti.flickster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class VideoActivity extends AppCompatActivity {
    TextView tvPopularity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        tvPopularity = (TextView) findViewById(R.id.tvPopularity);


    }
}
