package com.evernote.android.job.patched.internal.v14;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.FixedJobIntentService;
import androidx.core.app.JobIntentService;
import com.evernote.android.job.patched.internal.JobIdsInternal;
import com.evernote.android.job.patched.internal.JobProxy;
import com.evernote.android.job.patched.internal.JobRequest;
import com.evernote.android.job.patched.internal.util.JobCat;
public final class PlatformAlarmService extends FixedJobIntentService {
    public static final JobCat j = new JobCat("PlatformAlarmService");

    public static void f(@Nullable Intent intent, @NonNull Service service, @NonNull JobCat jobCat) {
        if (intent == null) {
            jobCat.i("Delivered intent is null");
            return;
        }
        int intExtra = intent.getIntExtra("EXTRA_JOB_ID", -1);
        Bundle bundleExtra = intent.getBundleExtra("EXTRA_TRANSIENT_EXTRAS");
        JobProxy.Common common = new JobProxy.Common(service, jobCat, intExtra);
        JobRequest pendingRequest = common.getPendingRequest(true, true);
        if (pendingRequest != null) {
            common.executeJobRequest(pendingRequest, bundleExtra);
        }
    }

    public static void start(Context context, int i, @Nullable Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtra("EXTRA_JOB_ID", i);
        if (bundle != null) {
            intent.putExtra("EXTRA_TRANSIENT_EXTRAS", bundle);
        }
        JobIntentService.enqueueWork(context, PlatformAlarmService.class, (int) JobIdsInternal.JOB_ID_PLATFORM_ALARM_SERVICE, intent);
    }

    @Override // androidx.core.app.JobIntentService
    public void onHandleWork(@NonNull Intent intent) {
        f(intent, this, j);
    }
}
