package com.example.porosapp;

import android.app.job.JobParameters;
import android.util.Log;

public class APIJobService extends android.app.job.JobService {
    private static final String TAG = "JobService";
    private boolean jobCancelled = false;

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.d(TAG, "Job started");
        fetchApi(jobParameters);
        return true; // return true for keeping device awake and do a job until finishing entire job
    }

    private void fetchApi(final JobParameters params){
        new Thread(new Runnable() {
            @Override
            public void run() {
//                do fetch api
            }
        }).start();
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
