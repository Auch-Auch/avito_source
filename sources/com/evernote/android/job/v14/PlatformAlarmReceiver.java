package com.evernote.android.job.v14;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import com.evernote.android.job.JobProxy;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class PlatformAlarmReceiver extends BroadcastReceiver {
    public static final /* synthetic */ int a = 0;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.hasExtra("EXTRA_JOB_ID") && intent.hasExtra("EXTRA_JOB_EXACT")) {
            int intExtra = intent.getIntExtra("EXTRA_JOB_ID", -1);
            Bundle bundleExtra = intent.getBundleExtra("EXTRA_TRANSIENT_EXTRAS");
            if (intent.getBooleanExtra("EXTRA_JOB_EXACT", false)) {
                JobProxy.Common.startWakefulService(context, PlatformAlarmServiceExact.createIntent(context, intExtra, bundleExtra));
            } else {
                PlatformAlarmService.start(context, intExtra, bundleExtra);
            }
        }
    }
}
