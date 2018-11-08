package com.zerodaedalus.www.clock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateProjectActivity extends AppCompatActivity {

    public static final String EXTRA_PROJECT_NAME = "com.zerodaedalus.www.clock.PROJECT_NAME";

    Button submitProject;
    EditText projectName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_project);

        projectName = findViewById(R.id.editText);
        submitProject = findViewById(R.id.submitProject);

        submitProject.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateProjectActivity.this, MainActivity.class);
                intent.putExtra(EXTRA_PROJECT_NAME, projectName.getText().toString());
                startActivity(intent);
            }
        });
    }
}
