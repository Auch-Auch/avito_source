package com.evernote.android.job.patched.internal;

import a2.f.a.a.i.a.a;
import a2.f.a.a.i.a.b;
import a2.f.a.a.i.a.d;
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
import com.evernote.android.job.patched.internal.Job;
import com.evernote.android.job.patched.internal.JobCreator;
import com.evernote.android.job.patched.internal.JobProxy;
import com.evernote.android.job.patched.internal.util.JobCat;
import com.evernote.android.job.patched.internal.util.JobPreconditions;
import com.evernote.android.job.patched.internal.util.JobUtil;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
public final class JobManager {
    public static final JobCat e = new JobCat("JobManager");
    @SuppressLint({"StaticFieldLeak"})
    public static volatile JobManager f;
    public final Context a;
    public final a b = new a();
    public final d c;
    public final b d;

    public JobManager(Context context) {
        this.a = context;
        this.c = new d(context);
        this.d = new b();
        EnumMap<JobApi, Boolean> enumMap = JobConfig.a;
        JobCat jobCat = JobRescheduleService.j;
        try {
            JobIntentService.enqueueWork(context, JobRescheduleService.class, (int) JobIdsInternal.JOB_ID_JOB_RESCHEDULE_SERVICE, new Intent());
            JobRescheduleService.k = new CountDownLatch(1);
        } catch (Exception e2) {
            JobRescheduleService.j.e(e2);
        }
    }

    public static JobManager create(@NonNull Context context) throws JobManagerCreateException {
        if (f == null) {
            synchronized (JobManager.class) {
                if (f == null) {
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
                    f = new JobManager(context);
                    if (!JobUtil.hasWakeLockPermission(context)) {
                        e.w("No wake lock permission");
                    }
                    if (!JobUtil.hasBootPermission(context)) {
                        e.w("No boot permission");
                    }
                    h(context);
                }
            }
        }
        return f;
    }

    public static void h(@NonNull Context context) {
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
                    ((JobCreator.AddJobCreatorReceiver) Class.forName(activityInfo.name).newInstance()).addJobCreator(context, f);
                } catch (Exception unused2) {
                }
            }
        }
    }

    public static JobManager instance() {
        if (f == null) {
            synchronized (JobManager.class) {
                if (f == null) {
                    throw new IllegalStateException("You need to call create() at least once to create the singleton");
                }
            }
        }
        return f;
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
        if (job == null || !job.cancel(true)) {
            return false;
        }
        e.i("Cancel running %s", job);
        return true;
    }

    public final boolean c(@Nullable JobRequest jobRequest) {
        if (jobRequest == null) {
            return false;
        }
        e.i("Found pending job %s, canceling", jobRequest);
        e(jobRequest.c()).cancel(jobRequest.getJobId());
        this.c.f(jobRequest);
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

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0094, code lost:
        if (r5 != null) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a9, code lost:
        if (0 != 0) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ee A[SYNTHETIC, Splitter:B:50:0x00ee] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Set<com.evernote.android.job.patched.internal.JobRequest> d(@androidx.annotation.Nullable java.lang.String r16, boolean r17, boolean r18) {
        /*
        // Method dump skipped, instructions count: 254
        */
        throw new UnsupportedOperationException("Method not decompiled: com.evernote.android.job.patched.internal.JobManager.d(java.lang.String, boolean, boolean):java.util.Set");
    }

    public JobProxy e(JobApi jobApi) {
        return jobApi.b(this.a);
    }

    public JobRequest f(int i, boolean z) {
        d dVar = this.c;
        dVar.f.readLock().lock();
        try {
            JobRequest jobRequest = (JobRequest) dVar.b.get(Integer.valueOf(i));
            if (z || jobRequest == null || !jobRequest.d) {
                return jobRequest;
            }
            return null;
        } finally {
            dVar.f.readLock().unlock();
        }
    }

    public final void g(JobRequest jobRequest, JobApi jobApi, boolean z, boolean z2) {
        JobProxy b2 = jobApi.b(this.a);
        if (!z) {
            b2.plantOneOff(jobRequest);
        } else if (z2) {
            b2.plantPeriodicFlexSupport(jobRequest);
        } else {
            b2.plantPeriodic(jobRequest);
        }
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
        return this.d.c.clone();
    }

    @NonNull
    public Set<Job> getAllJobs() {
        Set<Job> b2;
        b bVar = this.d;
        synchronized (bVar) {
            b2 = bVar.b(null);
        }
        return b2;
    }

    @NonNull
    public Set<Job> getAllJobsForTag(@NonNull String str) {
        return this.d.b(str);
    }

    public Job getJob(int i) {
        Job job;
        b bVar = this.d;
        synchronized (bVar) {
            job = bVar.a.get(i);
            if (job == null) {
                WeakReference<Job> weakReference = bVar.b.get(Integer.valueOf(i));
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
        this.c.f(f2);
        return null;
    }

    public void removeJobCreator(JobCreator jobCreator) {
        this.b.a.remove(jobCreator);
    }

    public synchronized void schedule(@NonNull JobRequest jobRequest) {
        JobApi jobApi;
        if (this.b.a.isEmpty()) {
            e.w("you haven't registered a JobCreator with addJobCreator(), it's likely that your job never will be executed");
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
            this.c.e(jobRequest);
            try {
                g(jobRequest, c2, isPeriodic, z);
            } catch (JobProxyIllegalStateException unused) {
                try {
                    c2.invalidateCachedProxy();
                    g(jobRequest, c2, isPeriodic, z);
                } catch (Exception e2) {
                    JobApi jobApi2 = JobApi.V_14;
                    if (c2 == jobApi2 || c2 == (jobApi = JobApi.V_19)) {
                        this.c.f(jobRequest);
                        throw e2;
                    }
                    if (jobApi.isSupported(this.a)) {
                        jobApi2 = jobApi;
                    }
                    try {
                        g(jobRequest, jobApi2, isPeriodic, z);
                    } catch (Exception e3) {
                        this.c.f(jobRequest);
                        throw e3;
                    }
                }
            } catch (Exception e4) {
                this.c.f(jobRequest);
                throw e4;
            }
        }
    }
}
