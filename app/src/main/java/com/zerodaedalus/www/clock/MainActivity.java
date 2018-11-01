package com.zerodaedalus.www.clock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.zerodaedalus.www.clock.MESSAGE";
    public static final String EXTRA_NEW_PROJECT = "com.zerodaedalus.www.clock.NEW_PROJECT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createProject(View view) {
        Intent intent = new Intent(this, CreateProjectActivity.class);
        EditText newProject = (EditText) findViewById(R.id.editText);
        String projectName = newProject.getText().toString();
        intent.putExtra(EXTRA_NEW_PROJECT, projectName);
        startActivity(intent);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
