package com.evernote.android.job.work;

import a2.b.a.a.a;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.annotation.RestrictTo;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import com.evernote.android.job.JobProxy;
import com.evernote.android.job.JobProxyIllegalStateException;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.JobCat;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class JobProxyWorkManager implements JobProxy {
    public static final JobCat b = new JobCat("JobProxyWork");
    public final Context a;

    public JobProxyWorkManager(Context context) {
        this.a = context;
    }

    public static Constraints a(JobRequest jobRequest) {
        NetworkType networkType;
        Constraints.Builder requiresStorageNotLow = new Constraints.Builder().setRequiresBatteryNotLow(jobRequest.requiresBatteryNotLow()).setRequiresCharging(jobRequest.requiresCharging()).setRequiresStorageNotLow(jobRequest.requiresStorageNotLow());
        int ordinal = jobRequest.requiredNetworkType().ordinal();
        if (ordinal == 0) {
            networkType = NetworkType.NOT_REQUIRED;
        } else if (ordinal == 1) {
            networkType = NetworkType.CONNECTED;
        } else if (ordinal == 2) {
            networkType = NetworkType.UNMETERED;
        } else if (ordinal == 3) {
            networkType = NetworkType.NOT_ROAMING;
        } else if (ordinal == 4) {
            networkType = NetworkType.METERED;
        } else {
            throw new IllegalStateException("Not implemented");
        }
        Constraints.Builder requiredNetworkType = requiresStorageNotLow.setRequiredNetworkType(networkType);
        if (Build.VERSION.SDK_INT >= 23) {
            requiredNetworkType.setRequiresDeviceIdle(jobRequest.requiresDeviceIdle());
        }
        return requiredNetworkType.build();
    }

    public static String b(int i) {
        return a.M2("android-job-", i);
    }

    public final WorkManager c() {
        WorkManager workManager;
        try {
            workManager = WorkManager.getInstance(this.a);
        } catch (Throwable unused) {
            workManager = null;
        }
        if (workManager == null) {
            try {
                WorkManager.initialize(this.a, new Configuration.Builder().build());
                workManager = WorkManager.getInstance(this.a);
            } catch (Throwable unused2) {
            }
            b.w("WorkManager getInstance() returned null, now: %s", workManager);
        }
        return workManager;
    }

    @Override // com.evernote.android.job.JobProxy
    public void cancel(int i) {
        WorkManager c = c();
        if (c != null) {
            c.cancelAllWorkByTag(b(i));
            a2.f.a.a.l.a.a(i);
        }
    }

    @Override // com.evernote.android.job.JobProxy
    public boolean isPlatformJobScheduled(JobRequest jobRequest) {
        List<WorkInfo> list;
        String b2 = b(jobRequest.getJobId());
        WorkManager c = c();
        if (c == null) {
            list = Collections.emptyList();
        } else {
            try {
                list = c.getWorkInfosByTag(b2).get(5, TimeUnit.SECONDS);
            } catch (Exception unused) {
                list = Collections.emptyList();
            }
        }
        if (list == null || list.isEmpty() || list.get(0).getState() != WorkInfo.State.ENQUEUED) {
            return false;
        }
        return true;
    }

    @Override // com.evernote.android.job.JobProxy
    public void plantOneOff(JobRequest jobRequest) {
        if (jobRequest.isTransient()) {
            int jobId = jobRequest.getJobId();
            Bundle transientExtras = jobRequest.getTransientExtras();
            SparseArray<Bundle> sparseArray = a2.f.a.a.l.a.a;
            synchronized (a2.f.a.a.l.a.class) {
                a2.f.a.a.l.a.a.put(jobId, transientExtras);
            }
        }
        OneTimeWorkRequest oneTimeWorkRequest = (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(PlatformWorker.class).setInitialDelay(jobRequest.getStartMs(), TimeUnit.MILLISECONDS)).setConstraints(a(jobRequest))).addTag(b(jobRequest.getJobId()))).build();
        WorkManager c = c();
        if (c != null) {
            c.enqueue(oneTimeWorkRequest);
            return;
        }
        throw new JobProxyIllegalStateException("WorkManager is null");
    }

    @Override // com.evernote.android.job.JobProxy
    public void plantPeriodic(JobRequest jobRequest) {
        long intervalMs = jobRequest.getIntervalMs();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        PeriodicWorkRequest periodicWorkRequest = (PeriodicWorkRequest) ((PeriodicWorkRequest.Builder) ((PeriodicWorkRequest.Builder) new PeriodicWorkRequest.Builder(PlatformWorker.class, intervalMs, timeUnit, jobRequest.getFlexMs(), timeUnit).setConstraints(a(jobRequest))).addTag(b(jobRequest.getJobId()))).build();
        WorkManager c = c();
        if (c != null) {
            c.enqueue(periodicWorkRequest);
            return;
        }
        throw new JobProxyIllegalStateException("WorkManager is null");
    }

    @Override // com.evernote.android.job.JobProxy
    public void plantPeriodicFlexSupport(JobRequest jobRequest) {
        b.w("plantPeriodicFlexSupport called although flex is supported");
        plantPeriodic(jobRequest);
    }
}
