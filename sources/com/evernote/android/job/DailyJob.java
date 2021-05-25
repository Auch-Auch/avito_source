package com.evernote.android.job;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.JobCat;
import com.evernote.android.job.util.JobPreconditions;
import com.evernote.android.job.util.support.PersistableBundleCompat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
public abstract class DailyJob extends Job {
    public static final JobCat j = new JobCat("DailyJob");
    public static final long k = TimeUnit.DAYS.toMillis(1);

    public enum DailyJobResult {
        SUCCESS,
        CANCEL
    }

    public static class a implements Runnable {
        public final /* synthetic */ JobRequest.Builder a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;
        public final /* synthetic */ JobRequest.JobScheduledCallback d;

        public a(JobRequest.Builder builder, long j, long j2, JobRequest.JobScheduledCallback jobScheduledCallback) {
            this.a = builder;
            this.b = j;
            this.c = j2;
            this.d = jobScheduledCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.d.onJobScheduled(DailyJob.schedule(this.a, this.b, this.c), this.a.b, null);
            } catch (Exception e) {
                this.d.onJobScheduled(-1, this.a.b, e);
            }
        }
    }

    public static int e(@NonNull JobRequest.Builder builder, boolean z, long j2, long j3, boolean z2) {
        long j4 = k;
        if (j2 >= j4 || j3 >= j4 || j2 < 0 || j3 < 0) {
            throw new IllegalArgumentException("startMs or endMs should be less than one day (in milliseconds)");
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(JobConfig.getClock().currentTimeMillis());
        int i = instance.get(11);
        int i2 = instance.get(12);
        long millis = TimeUnit.SECONDS.toMillis((long) (60 - instance.get(13)));
        TimeUnit timeUnit = TimeUnit.MINUTES;
        long millis2 = timeUnit.toMillis((long) (60 - i2)) + millis;
        TimeUnit timeUnit2 = TimeUnit.HOURS;
        long millis3 = ((timeUnit2.toMillis((long) ((24 - i) % 24)) + millis2) - timeUnit2.toMillis(1)) - timeUnit.toMillis(1);
        TimeUnit timeUnit3 = TimeUnit.DAYS;
        long millis4 = ((timeUnit3.toMillis(1) + millis3) + j2) % timeUnit3.toMillis(1);
        if (z2 && millis4 < timeUnit2.toMillis(12)) {
            millis4 += timeUnit3.toMillis(1);
        }
        if (j2 > j3) {
            j3 += timeUnit3.toMillis(1);
        }
        long j5 = (j3 - j2) + millis4;
        PersistableBundleCompat persistableBundleCompat = new PersistableBundleCompat();
        persistableBundleCompat.putLong("EXTRA_START_MS", j2);
        persistableBundleCompat.putLong("EXTRA_END_MS", j3);
        builder.addExtras(persistableBundleCompat);
        if (z) {
            JobManager instance2 = JobManager.instance();
            Iterator it = new HashSet(instance2.getAllJobRequestsForTag(builder.b)).iterator();
            while (it.hasNext()) {
                JobRequest jobRequest = (JobRequest) it.next();
                if (!jobRequest.isExact() || jobRequest.getStartMs() != 1) {
                    instance2.cancel(jobRequest.getJobId());
                }
            }
        }
        JobRequest build = builder.setExecutionWindow(Math.max(1L, millis4), Math.max(1L, j5)).build();
        if (!z || (!build.isExact() && !build.isPeriodic() && !build.isTransient())) {
            return build.schedule();
        }
        throw new IllegalArgumentException("Daily jobs cannot be exact, periodic or transient");
    }

    public static int schedule(@NonNull JobRequest.Builder builder, long j2, long j3) {
        return e(builder, true, j2, j3, false);
    }

    public static void scheduleAsync(@NonNull JobRequest.Builder builder, long j2, long j3) {
        scheduleAsync(builder, j2, j3, JobRequest.DEFAULT_JOB_SCHEDULED_CALLBACK);
    }

    public static int startNowOnce(@NonNull JobRequest.Builder builder) {
        PersistableBundleCompat persistableBundleCompat = new PersistableBundleCompat();
        persistableBundleCompat.putBoolean("EXTRA_ONCE", true);
        return builder.startNow().addExtras(persistableBundleCompat).build().schedule();
    }

    @NonNull
    @WorkerThread
    public abstract DailyJobResult onRunDailyJob(@NonNull Job.Params params);

    @Override // com.evernote.android.job.Job
    @NonNull
    public final Job.Result onRunJob(@NonNull Job.Params params) {
        DailyJobResult dailyJobResult;
        PersistableBundleCompat extras = params.getExtras();
        boolean z = extras.getBoolean("EXTRA_ONCE", false);
        if (z || (extras.containsKey("EXTRA_START_MS") && extras.containsKey("EXTRA_END_MS"))) {
            DailyJobResult dailyJobResult2 = null;
            try {
                if (c(true)) {
                    dailyJobResult = onRunDailyJob(params);
                } else {
                    DailyJobResult dailyJobResult3 = DailyJobResult.SUCCESS;
                    j.i("Daily job requirements not met, reschedule for the next day");
                    dailyJobResult = dailyJobResult3;
                }
                if (dailyJobResult == null) {
                    dailyJobResult = DailyJobResult.SUCCESS;
                    j.e("Daily job result was null");
                }
                if (!z) {
                    JobRequest jobRequest = params.a;
                    if (dailyJobResult == DailyJobResult.SUCCESS) {
                        j.i("Rescheduling daily job %s", jobRequest);
                        JobRequest.Builder builder = new JobRequest.Builder(jobRequest.a, true);
                        long j2 = extras.getLong("EXTRA_START_MS", 0);
                        long j3 = k;
                        JobRequest jobRequest2 = JobManager.instance().getJobRequest(e(builder, false, j2 % j3, extras.getLong("EXTRA_END_MS", 0) % j3, true));
                        if (jobRequest2 != null) {
                            jobRequest2.f(false, true);
                        }
                    } else {
                        j.i("Cancel daily job %s", jobRequest);
                    }
                }
                return Job.Result.SUCCESS;
            } catch (Throwable th) {
                if (0 == 0) {
                    dailyJobResult2 = DailyJobResult.SUCCESS;
                    j.e("Daily job result was null");
                }
                if (!z) {
                    JobRequest jobRequest3 = params.a;
                    if (dailyJobResult2 == DailyJobResult.SUCCESS) {
                        j.i("Rescheduling daily job %s", jobRequest3);
                        JobRequest.Builder builder2 = new JobRequest.Builder(jobRequest3.a, true);
                        long j4 = extras.getLong("EXTRA_START_MS", 0);
                        long j5 = k;
                        JobRequest jobRequest4 = JobManager.instance().getJobRequest(e(builder2, false, j4 % j5, extras.getLong("EXTRA_END_MS", 0) % j5, true));
                        if (jobRequest4 != null) {
                            jobRequest4.f(false, true);
                        }
                    } else {
                        j.i("Cancel daily job %s", jobRequest3);
                    }
                }
                throw th;
            }
        } else {
            j.e("Daily job doesn't contain start and end time");
            return Job.Result.FAILURE;
        }
    }

    public static void scheduleAsync(@NonNull JobRequest.Builder builder, long j2, long j3, @NonNull JobRequest.JobScheduledCallback jobScheduledCallback) {
        JobPreconditions.checkNotNull(jobScheduledCallback);
        JobConfig.getExecutorService().execute(new a(builder, j2, j3, jobScheduledCallback));
    }
}
