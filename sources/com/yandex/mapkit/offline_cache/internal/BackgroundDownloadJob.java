package com.yandex.mapkit.offline_cache.internal;

import android.os.Handler;
import android.os.Looper;
import com.evernote.android.job.patched.internal.Job;
import java.util.logging.Logger;
public class BackgroundDownloadJob extends Job {
    private static Logger LOGGER = Logger.getLogger(BackgroundDownloadJob.class.getCanonicalName());
    public static final String TAG = "mapkit_background_download";
    private Runnable initializer;

    public BackgroundDownloadJob(Runnable runnable) {
        this.initializer = runnable;
    }

    @Override // com.evernote.android.job.patched.internal.Job
    public synchronized void onCancel() {
        notifyAll();
    }

    @Override // com.evernote.android.job.patched.internal.Job
    public synchronized Job.Result onRunJob(Job.Params params) {
        LOGGER.info("Start background download job");
        if (this.initializer != null) {
            new Handler(Looper.getMainLooper()).post(this.initializer);
            this.initializer = null;
        }
        try {
            wait();
            LOGGER.info("Stop background download job");
        } catch (InterruptedException unused) {
            LOGGER.info("Background download job interrupted");
            return Job.Result.RESCHEDULE;
        }
        return Job.Result.SUCCESS;
    }
}
