package com.evernote.android.job;

import a2.f.a.a.b;
import a2.f.a.a.c;
import a2.f.a.a.e;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.JobIntentService;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;
import com.evernote.android.job.JobProxy;
import com.evernote.android.job.util.JobCat;
import com.evernote.android.job.util.JobPreconditions;
import com.evernote.android.job.util.JobUtil;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
public final class JobManager {
    public static final JobCat f = new JobCat("JobManager");
    @SuppressLint({"StaticFieldLeak"})
    public static volatile JobManager g;
    public final Context a;
    public final b b = new b();
    public final c c = new c();
    public volatile e d;
    public final CountDownLatch e;

    public class a extends Thread {
        public final /* synthetic */ Context a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, Context context) {
            super(str);
            this.a = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            JobManager.this.d = new e(this.a);
            JobManager.this.e.countDown();
        }
    }

    public JobManager(Context context) {
        this.a = context;
        EnumMap<JobApi, Boolean> enumMap = JobConfig.a;
        JobCat jobCat = JobRescheduleService.j;
        try {
            JobIntentService.enqueueWork(context, JobRescheduleService.class, 2147480000, new Intent());
            JobRescheduleService.k = new CountDownLatch(1);
        } catch (Exception e2) {
            JobRescheduleService.j.e(e2);
        }
        this.e = new CountDownLatch(1);
        new a("AndroidJob-storage-init", context).start();
    }

    public static JobManager create(@NonNull Context context) throws JobManagerCreateException {
        if (g == null) {
            synchronized (JobManager.class) {
                if (g == null) {
                    JobPreconditions.checkNotNull(context, "Context cannot be null");
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    JobApi jobApi = JobApi.getDefault(context);
                    if (jobApi == JobApi.V_14) {
                        if (!jobApi.isSupported(context)) {
                            throw new JobManagerCreateException("All APIs are disabled, cannot schedule any job");
                        }
                    }
                    g = new JobManager(context);
                    if (!JobUtil.hasWakeLockPermission(context)) {
                        f.w("No wake lock permission");
                    }
                    if (!JobUtil.hasBootPermission(context)) {
                        f.w("No boot permission");
                    }
                    i(context);
                }
            }
        }
        return g;
    }

    public static void i(@NonNull Context context) {
        List<ResolveInfo> list;
        String packageName = context.getPackageName();
        Intent intent = new Intent(JobCreator.ACTION_ADD_JOB_CREATOR);
        intent.setPackage(packageName);
        try {
            list = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        } catch (Exception unused) {
            list = Collections.emptyList();
        }
        for (ResolveInfo resolveInfo : list) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo != null && !activityInfo.exported && packageName.equals(activityInfo.packageName) && !TextUtils.isEmpty(activityInfo.name)) {
                try {
                    ((JobCreator.AddJobCreatorReceiver) Class.forName(activityInfo.name).newInstance()).addJobCreator(context, g);
                } catch (Exception unused2) {
                }
            }
        }
    }

    public static JobManager instance() {
        if (g == null) {
            synchronized (JobManager.class) {
                if (g == null) {
                    throw new IllegalStateException("You need to call create() at least once to create the singleton");
                }
            }
        }
        return g;
    }

    public final synchronized int a(@Nullable String str) {
        int i;
        i = 0;
        Iterator it = ((HashSet) d(str, true, false)).iterator();
        while (it.hasNext()) {
            if (c((JobRequest) it.next())) {
                i++;
            }
        }
        for (Job job : TextUtils.isEmpty(str) ? getAllJobs() : getAllJobsForTag(str)) {
            if (b(job)) {
                i++;
            }
        }
        return i;
    }

    public void addJobCreator(JobCreator jobCreator) {
        this.b.a.add(jobCreator);
    }

    public final boolean b(@Nullable Job job) {
        if (job == null || !job.a(true)) {
            return false;
        }
        f.i("Cancel running %s", job);
        return true;
    }

    public final boolean c(@Nullable JobRequest jobRequest) {
        if (jobRequest == null) {
            return false;
        }
        f.i("Found pending job %s, canceling", jobRequest);
        e(jobRequest.c()).cancel(jobRequest.getJobId());
        g().f(jobRequest);
        jobRequest.c = 0;
        return true;
    }

    public boolean cancel(int i) {
        boolean c2 = c(f(i, true)) | b(getJob(i));
        JobProxy.Common.c(this.a, i);
        return c2;
    }

    public int cancelAll() {
        return a(null);
    }

    public int cancelAllForTag(@NonNull String str) {
        return a(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0095, code lost:
        if (r4 != null) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ab, code lost:
        if (0 != 0) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f8 A[SYNTHETIC, Splitter:B:53:0x00f8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Set<com.evernote.android.job.JobRequest> d(@androidx.annotation.Nullable java.lang.String r15, boolean r16, boolean r17) {
        /*
        // Method dump skipped, instructions count: 264
        */
        throw new UnsupportedOperationException("Method not decompiled: com.evernote.android.job.JobManager.d(java.lang.String, boolean, boolean):java.util.Set");
    }

    public JobProxy e(JobApi jobApi) {
        return jobApi.b(this.a);
    }

    public JobRequest f(int i, boolean z) {
        e g2 = g();
        g2.f.readLock().lock();
        try {
            JobRequest jobRequest = (JobRequest) g2.b.get(Integer.valueOf(i));
            if (z || jobRequest == null || !jobRequest.d) {
                return jobRequest;
            }
            return null;
        } finally {
            g2.f.readLock().unlock();
        }
    }

    @NonNull
    public e g() {
        if (this.d == null) {
            try {
                this.e.await(20, TimeUnit.SECONDS);
            } catch (InterruptedException e2) {
                throw new RuntimeException(e2);
            }
        }
        if (this.d != null) {
            return this.d;
        }
        throw new IllegalStateException("Job storage shouldn't be null");
    }

    @NonNull
    public Set<JobRequest> getAllJobRequests() {
        return d(null, false, true);
    }

    public Set<JobRequest> getAllJobRequestsForTag(@NonNull String str) {
        return d(str, false, true);
    }

    @NonNull
    public SparseArray<Job.Result> getAllJobResults() {
        return this.c.c.clone();
    }

    @NonNull
    public Set<Job> getAllJobs() {
        Set<Job> b2;
        c cVar = this.c;
        synchronized (cVar) {
            b2 = cVar.b(null);
        }
        return b2;
    }

    @NonNull
    public Set<Job> getAllJobsForTag(@NonNull String str) {
        return this.c.b(str);
    }

    public Job getJob(int i) {
        Job job;
        c cVar = this.c;
        synchronized (cVar) {
            job = cVar.a.get(i);
            if (job == null) {
                WeakReference<Job> weakReference = cVar.b.get(Integer.valueOf(i));
                job = weakReference != null ? weakReference.get() : null;
            }
        }
        return job;
    }

    public JobRequest getJobRequest(int i) {
        JobRequest f2 = f(i, false);
        if (f2 == null || !f2.isTransient() || f2.c().b(this.a).isPlatformJobScheduled(f2)) {
            return f2;
        }
        g().f(f2);
        return null;
    }

    public final void h(JobRequest jobRequest, JobApi jobApi, boolean z, boolean z2) {
        JobProxy b2 = jobApi.b(this.a);
        if (!z) {
            b2.plantOneOff(jobRequest);
        } else if (z2) {
            b2.plantPeriodicFlexSupport(jobRequest);
        } else {
            b2.plantPeriodic(jobRequest);
        }
    }

    public void removeJobCreator(JobCreator jobCreator) {
        this.b.a.remove(jobCreator);
    }

    public synchronized void schedule(@NonNull JobRequest jobRequest) {
        JobApi jobApi;
        if (this.b.a.isEmpty()) {
            f.w("you haven't registered a JobCreator with addJobCreator(), it's likely that your job never will be executed");
        }
        if (jobRequest.getScheduledAt() <= 0) {
            if (jobRequest.isUpdateCurrent()) {
                cancelAllForTag(jobRequest.getTag());
            }
            JobProxy.Common.c(this.a, jobRequest.getJobId());
            JobApi c2 = jobRequest.c();
            boolean isPeriodic = jobRequest.isPeriodic();
            boolean z = isPeriodic && c2.c && jobRequest.getFlexMs() < jobRequest.getIntervalMs();
            jobRequest.c = JobConfig.getClock().currentTimeMillis();
            jobRequest.e = z;
            g().e(jobRequest);
            try {
                h(jobRequest, c2, isPeriodic, z);
            } catch (JobProxyIllegalStateException unused) {
                try {
                    c2.invalidateCachedProxy();
                    h(jobRequest, c2, isPeriodic, z);
                } catch (Exception e2) {
                    JobApi jobApi2 = JobApi.V_14;
                    if (c2 == jobApi2 || c2 == (jobApi = JobApi.V_19)) {
                        g().f(jobRequest);
                        throw e2;
                    }
                    if (jobApi.isSupported(this.a)) {
                        jobApi2 = jobApi;
                    }
                    try {
                        h(jobRequest, jobApi2, isPeriodic, z);
                    } catch (Exception e3) {
                        g().f(jobRequest);
                        throw e3;
                    }
                }
            } catch (Exception e4) {
                g().f(jobRequest);
                throw e4;
            }
        }
    }
}
