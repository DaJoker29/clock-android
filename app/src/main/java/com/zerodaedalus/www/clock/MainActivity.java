package com.zerodaedalus.www.clock;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateCurrentProject();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateCurrentProject();
    }

    public void updateCurrentProject() {
        // Fetch current project from Shared Preferences and display
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        String currentProject = sharedPref.getString("current_project", "No active project");

        // Write new name to text view
        TextView textView = findViewById(R.id.currentProjectDisplay);
        textView.setText(currentProject);
    }

    public void setProject(View view) {
        // Fetch input text
        EditText newProjectName = (EditText) findViewById(R.id.newProjectName);
        String currentProject = newProjectName.getText().toString();

        // Save input text as current project name
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("current_project", currentProject);
        editor.commit();
        recreate();
    }
}
