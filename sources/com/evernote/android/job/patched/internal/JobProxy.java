package com.evernote.android.job.patched.internal;

import a2.b.a.a.a;
import a2.f.a.a.i.a.b;
import a2.f.a.a.i.a.f;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.evernote.android.job.patched.internal.Job;
import com.evernote.android.job.patched.internal.util.JobCat;
import com.evernote.android.job.patched.internal.util.JobUtil;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
public interface JobProxy {

    public static final class Common {
        public static final Object e = new Object();
        public final Context a;
        public final int b;
        public final JobCat c;
        public final JobManager d;

        public Common(@NonNull Service service, JobCat jobCat, int i) {
            JobManager jobManager;
            this.a = service;
            this.b = i;
            this.c = jobCat;
            try {
                jobManager = JobManager.create(service);
            } catch (JobManagerCreateException e2) {
                this.c.e(e2);
                jobManager = null;
            }
            this.d = jobManager;
        }

        public static long a(long j, boolean z) {
            if (z) {
                return j;
            }
            return Long.MAX_VALUE;
        }

        public static long b(long j, long j2) {
            long j3 = j + j2;
            boolean z = true;
            boolean z2 = (j2 ^ j) < 0;
            if ((j ^ j3) < 0) {
                z = false;
            }
            return a(j3, z2 | z);
        }

        public static void c(Context context, int i) {
            JobApi[] values = JobApi.values();
            for (int i2 = 0; i2 < 5; i2++) {
                JobApi jobApi = values[i2];
                if (jobApi.isSupported(context)) {
                    try {
                        jobApi.b(context).cancel(i);
                    } catch (Exception unused) {
                    }
                }
            }
        }

        public static boolean completeWakefulIntent(Intent intent) {
            int intExtra;
            JobCat jobCat = f.a;
            if (intent == null || (intExtra = intent.getIntExtra("com.evernote.android.job.patched.internal.wakelockid", 0)) == 0) {
                return false;
            }
            SparseArray<PowerManager.WakeLock> sparseArray = f.b;
            synchronized (sparseArray) {
                f.c(sparseArray.get(intExtra));
                sparseArray.remove(intExtra);
            }
            return true;
        }

        public static long getAverageDelayMs(JobRequest jobRequest) {
            return b(getStartMs(jobRequest), (getEndMs(jobRequest) - getStartMs(jobRequest)) / 2);
        }

        public static long getAverageDelayMsSupportFlex(JobRequest jobRequest) {
            return b(getStartMsSupportFlex(jobRequest), (getEndMsSupportFlex(jobRequest) - getStartMsSupportFlex(jobRequest)) / 2);
        }

        public static long getEndMs(JobRequest jobRequest) {
            return getEndMs(jobRequest, false);
        }

        public static long getEndMsSupportFlex(JobRequest jobRequest) {
            return jobRequest.getIntervalMs();
        }

        public static int getRescheduleCount(JobRequest jobRequest) {
            return jobRequest.getFailureCount();
        }

        public static long getStartMs(JobRequest jobRequest) {
            if (jobRequest.getFailureCount() > 0) {
                return jobRequest.b();
            }
            return jobRequest.getStartMs();
        }

        public static long getStartMsSupportFlex(JobRequest jobRequest) {
            return Math.max(1L, jobRequest.getIntervalMs() - jobRequest.getFlexMs());
        }

        public static ComponentName startWakefulService(Context context, Intent intent) {
            ComponentName startService;
            SparseArray<PowerManager.WakeLock> sparseArray = f.b;
            synchronized (sparseArray) {
                int i = f.c;
                int i2 = i + 1;
                f.c = i2;
                if (i2 <= 0) {
                    f.c = 1;
                }
                intent.putExtra("com.evernote.android.job.patched.internal.wakelockid", i);
                startService = context.startService(intent);
                if (startService == null) {
                    startService = null;
                } else {
                    PowerManager.WakeLock a3 = f.a(context, "wake:" + startService.flattenToShortString(), TimeUnit.MINUTES.toMillis(3));
                    if (a3 != null) {
                        sparseArray.put(i, a3);
                    }
                }
            }
            return startService;
        }

        @NonNull
        public Job.Result executeJobRequest(@NonNull JobRequest jobRequest, @Nullable Bundle bundle) {
            String str;
            long currentTimeMillis = System.currentTimeMillis() - jobRequest.getScheduledAt();
            if (jobRequest.isPeriodic()) {
                str = String.format(Locale.US, "interval %s, flex %s", JobUtil.timeToString(jobRequest.getIntervalMs()), JobUtil.timeToString(jobRequest.getFlexMs()));
            } else if (jobRequest.c().b) {
                str = String.format(Locale.US, "start %s, end %s", JobUtil.timeToString(getStartMs(jobRequest)), JobUtil.timeToString(getEndMs(jobRequest)));
            } else {
                StringBuilder L = a.L("delay ");
                L.append(JobUtil.timeToString(getAverageDelayMs(jobRequest)));
                str = L.toString();
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.c.w("Running JobRequest on a main thread, this could cause stutter or ANR in your app.");
            }
            this.c.d("Run job, %s, waited %s, %s", jobRequest, JobUtil.timeToString(currentTimeMillis), str);
            JobManager jobManager = this.d;
            b bVar = jobManager.d;
            Job job = null;
            try {
                Job a3 = jobManager.b.a(jobRequest.getTag());
                if (!jobRequest.isPeriodic()) {
                    jobRequest.e(true);
                }
                if (bundle == null) {
                    bundle = Bundle.EMPTY;
                }
                Future<Job.Result> a4 = bVar.a(this.a, jobRequest, a3, bundle);
                if (a4 == null) {
                    Job.Result result = Job.Result.FAILURE;
                    if (a3 == null) {
                        this.d.c.f(jobRequest);
                    } else if (!jobRequest.isPeriodic()) {
                        this.d.c.f(jobRequest);
                    } else if (jobRequest.e && !a3.isDeleted()) {
                        this.d.c.f(jobRequest);
                        jobRequest.d(false, false);
                    }
                    return result;
                }
                Job.Result result2 = a4.get();
                this.c.d("Finished job, %s %s", jobRequest, result2);
                if (a3 == null) {
                    this.d.c.f(jobRequest);
                } else if (!jobRequest.isPeriodic()) {
                    this.d.c.f(jobRequest);
                } else if (jobRequest.e && !a3.isDeleted()) {
                    this.d.c.f(jobRequest);
                    jobRequest.d(false, false);
                }
                return result2;
            } catch (InterruptedException | ExecutionException e2) {
                this.c.e(e2);
                if (0 != 0) {
                    job.cancel();
                    this.c.e("Canceled %s", jobRequest);
                }
                Job.Result result3 = Job.Result.FAILURE;
                if (0 == 0) {
                    this.d.c.f(jobRequest);
                } else if (!jobRequest.isPeriodic()) {
                    this.d.c.f(jobRequest);
                } else if (jobRequest.e && !job.isDeleted()) {
                    this.d.c.f(jobRequest);
                    jobRequest.d(false, false);
                }
                return result3;
            } catch (Throwable th) {
                if (0 == 0) {
                    this.d.c.f(jobRequest);
                } else if (!jobRequest.isPeriodic()) {
                    this.d.c.f(jobRequest);
                } else if (jobRequest.e && !job.isDeleted()) {
                    this.d.c.f(jobRequest);
                    jobRequest.d(false, false);
                }
                throw th;
            }
        }

        public JobRequest getPendingRequest(boolean z, boolean z2) {
            boolean contains;
            synchronized (e) {
                JobManager jobManager = this.d;
                if (jobManager == null) {
                    return null;
                }
                JobRequest f = jobManager.f(this.b, true);
                Job job = this.d.getJob(this.b);
                boolean z3 = f != null && f.isPeriodic();
                if (job != null && !job.isFinished()) {
                    this.c.d("Job %d is already running, %s", Integer.valueOf(this.b), f);
                    return null;
                } else if (job != null && !z3) {
                    this.c.d("Job %d already finished, %s", Integer.valueOf(this.b), f);
                    if (z) {
                        c(this.a, this.b);
                    }
                    return null;
                } else if (job != null && System.currentTimeMillis() - job.getFinishedTimeStamp() < 2000) {
                    this.c.d("Job %d is periodic and just finished, %s", Integer.valueOf(this.b), f);
                    return null;
                } else if (f == null || !f.d) {
                    if (f != null) {
                        b bVar = this.d.d;
                        synchronized (bVar) {
                            contains = bVar.d.contains(f);
                        }
                        if (contains) {
                            this.c.d("Request %d is in the queue to start, %s", Integer.valueOf(this.b), f);
                            return null;
                        }
                    }
                    if (f == null) {
                        this.c.d("Request for ID %d was null", Integer.valueOf(this.b));
                        if (z) {
                            c(this.a, this.b);
                        }
                        return null;
                    }
                    if (z2) {
                        markStarting(f);
                    }
                    return f;
                } else {
                    this.c.d("Request %d already started, %s", Integer.valueOf(this.b), f);
                    return null;
                }
            }
        }

        public void markStarting(@NonNull JobRequest jobRequest) {
            b bVar = this.d.d;
            synchronized (bVar) {
                bVar.d.add(jobRequest);
            }
        }

        public static long getEndMs(JobRequest jobRequest, boolean z) {
            long j;
            if (jobRequest.getFailureCount() > 0) {
                j = jobRequest.b();
            } else {
                j = jobRequest.getEndMs();
            }
            if (!z || !jobRequest.requirementsEnforced() || !jobRequest.hasRequirements()) {
                return j;
            }
            int numberOfLeadingZeros = Long.numberOfLeadingZeros(-101) + Long.numberOfLeadingZeros(100) + Long.numberOfLeadingZeros(~j) + Long.numberOfLeadingZeros(j);
            if (numberOfLeadingZeros > 65) {
                return j * 100;
            }
            boolean z2 = false;
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            long a3 = a(a(j * 100, numberOfLeadingZeros >= 64), (i >= 0) | true);
            if (i == 0 || a3 / j == 100) {
                z2 = true;
            }
            return a(a3, z2);
        }
    }

    void cancel(int i);

    boolean isPlatformJobScheduled(JobRequest jobRequest);

    void plantOneOff(JobRequest jobRequest);

    void plantPeriodic(JobRequest jobRequest);

    void plantPeriodicFlexSupport(JobRequest jobRequest);
}
