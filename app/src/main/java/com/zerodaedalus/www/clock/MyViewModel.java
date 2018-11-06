package com.zerodaedalus.www.clock;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;
import android.os.SystemClock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyViewModel extends ViewModel {
    private MutableLiveData<List<String>> projects;
    public LiveData<List<String>> getProjects() {
        if (projects == null) {
            projects = new MutableLiveData<List<String>>();
            loadProjects();
        }
        return projects;
    }

    private void loadProjects() {
        Handler myHandler = new Handler();
        myHandler.postDelayed(() -> {
            List<String> projectStringList = new ArrayList<>();
            projectStringList.add("Writing");
            projectStringList.add("Programming");
            projectStringList.add("Designing");

            projects.setValue(projectStringList);
        }, 500);
    }
}
