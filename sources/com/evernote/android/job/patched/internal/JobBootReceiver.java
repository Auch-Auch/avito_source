package com.evernote.android.job.patched.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
public final class JobBootReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            JobManager.create(context);
        } catch (JobManagerCreateException unused) {
        }
    }
}
