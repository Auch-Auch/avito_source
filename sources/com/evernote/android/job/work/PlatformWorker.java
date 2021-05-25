package com.evernote.android.job.work;

import a2.f.a.a.l.a;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobManager;
import com.evernote.android.job.JobProxy;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.JobCat;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class PlatformWorker extends Worker {
    public static final JobCat g = new JobCat("PlatformWorker");

    public PlatformWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public final int a() {
        Set<String> tags = getTags();
        JobCat jobCat = JobProxyWorkManager.b;
        for (String str : tags) {
            if (str.startsWith("android-job-")) {
                return Integer.parseInt(str.substring(12));
            }
        }
        return -1;
    }

    @Override // androidx.work.Worker
    @NonNull
    public ListenableWorker.Result doWork() {
        Bundle bundle;
        int a = a();
        if (a < 0) {
            return ListenableWorker.Result.failure();
        }
        try {
            Context applicationContext = getApplicationContext();
            JobCat jobCat = g;
            JobProxy.Common common = new JobProxy.Common(applicationContext, jobCat, a);
            JobRequest pendingRequest = common.getPendingRequest(true, true);
            if (pendingRequest == null) {
                return ListenableWorker.Result.failure();
            }
            Bundle bundle2 = null;
            if (pendingRequest.isTransient()) {
                SparseArray<Bundle> sparseArray = a.a;
                synchronized (a.class) {
                    bundle = a.a.get(a);
                }
                if (bundle == null) {
                    jobCat.d("Transient bundle is gone for request %s", pendingRequest);
                    ListenableWorker.Result failure = ListenableWorker.Result.failure();
                    a.a(a);
                    return failure;
                }
                bundle2 = bundle;
            }
            if (Job.Result.SUCCESS == common.executeJobRequest(pendingRequest, bundle2)) {
                ListenableWorker.Result success = ListenableWorker.Result.success();
                a.a(a);
                return success;
            }
            ListenableWorker.Result failure2 = ListenableWorker.Result.failure();
            a.a(a);
            return failure2;
        } finally {
            a.a(a);
        }
    }

    @Override // androidx.work.ListenableWorker
    public void onStopped() {
        int a = a();
        Job job = JobManager.create(getApplicationContext()).getJob(a);
        if (job != null) {
            job.cancel();
            g.d("Called onStopped for %s", job);
            return;
        }
        g.d("Called onStopped, job %d not found", Integer.valueOf(a));
    }
}
