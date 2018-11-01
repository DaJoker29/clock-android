package com.zerodaedalus.www.clock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CreateProjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_project);

        Intent intent = getIntent();
        String message = ((Intent) intent).getStringExtra(MainActivity.EXTRA_NEW_PROJECT);
    }
}
