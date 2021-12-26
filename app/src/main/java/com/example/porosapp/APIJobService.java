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
                Log.d(TAG, "Run: get data from ...");
                if(jobCancelled) return;
//                do fetch api

                jobFinished(params, true);
                Log.d(TAG, "Finish: get data from ...");
            }
        }).start();
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.d(TAG, "Job cancelled before completion");
        jobCancelled = true;
        return true;
    }
}
