package com.zerodaedalus.www.clock;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private long timeWhenStopped = 0;
    private boolean isClockRunning = false;
    Chronometer timer;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Startup code
        sharedPref = this.getPreferences(Context.MODE_PRIVATE);
//        editor = sharedPref.edit();
        String currentProject = sharedPref.getString("current_project", "No active project");
//        updateCurrentProject();
        initializeTimer();

        // Set current project display
        TextView projectName = (TextView) findViewById(R.id.projectName);
        projectName.setText(String.format(getResources().getString(R.string.project_display), currentProject));
    }

    @Override
    protected void onResume() {
        super.onResume();
//        updateCurrentProject();
    }

//    public void updateCurrentProject() {
//        // Fetch current project from Shared Preferences and display
//        String currentProject = sharedPref.getString("current_project", "No active project");
//
//        // Write new name to text view
//        TextView textView = findViewById(R.id.currentProject);
//        textView.setText(currentProject);
//    }
//
//    public void setProject(View view) {
//        // Fetch input text
//        EditText newProjectName = (EditText) findViewById(R.id.newProjectName);
//        String currentProject = newProjectName.getText().toString();
//
//        // Save input text as current project name
//        editor.putString("current_project", currentProject);
//        editor.commit();
//        recreate();
//    }

    public void toggleClock(View view) {

        // Import button
        Button toggleClock = (Button) findViewById(R.id.toggleClock);

        // Clock in if clock is not running.
        if (!isClockRunning) {
            timer.setBase(SystemClock.elapsedRealtime());
            timer.start();
            toggleClock.setText(R.string.clock_out_string);
            toggleClock.setBackgroundColor(getResources().getColor(R.color.colorWarning, getTheme()));
            timer.setTextColor(getResources().getColor(R.color.colorWarning, getTheme()));
        } else {
            // Clock out if clock is running.
            timer.stop();
            timer.setText(String.format("Completed: \n%s", convertTime()));
            toggleClock.setText(R.string.clock_in_string);
            toggleClock.setBackgroundColor(getResources().getColor(R.color.colorPrimary, getTheme()));
            timer.setTextColor(getResources().getColor(R.color.colorBlack, getTheme()));
        }

        isClockRunning = !isClockRunning;
    }

    private String convertTime() {
        long time = SystemClock.elapsedRealtime() - timer.getBase();
        int h   = (int)(time / 3600000);
        int m = (int)(time - h * 3600000)/60000;
        int s= (int)(time - h * 3600000 - m *60000)/1000;
        String t = String.format("%02d hr : %02d min : %02d sec", h, m, s);
        return t;
    }

    private void initializeTimer() {
        timer = (Chronometer) findViewById(R.id.clockTimer);
        timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener(){
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                chronometer.setText(String.format("Elapsed: \n%s", convertTime()));
            }
        });
        timer.setBase(SystemClock.elapsedRealtime());
        timer.setText("");
    }
}
