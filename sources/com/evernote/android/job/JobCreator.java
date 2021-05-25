package com.evernote.android.job;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public interface JobCreator {
    public static final String ACTION_ADD_JOB_CREATOR = "com.evernote.android.job.ADD_JOB_CREATOR";

    public static abstract class AddJobCreatorReceiver extends BroadcastReceiver {
        public abstract void addJobCreator(@NonNull Context context, @NonNull JobManager jobManager);

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (context != null && intent != null && JobCreator.ACTION_ADD_JOB_CREATOR.equals(intent.getAction())) {
                try {
                    addJobCreator(context, JobManager.create(context));
                } catch (JobManagerCreateException unused) {
                }
            }
        }
    }

    @Nullable
    Job create(@NonNull String str);
}
