package com.evernote.android.job;

import android.os.Build;
import androidx.annotation.NonNull;
import com.evernote.android.job.util.Clock;
import com.evernote.android.job.util.JobCat;
import com.evernote.android.job.util.JobLogger;
import com.evernote.android.job.util.JobPreconditions;
import java.util.EnumMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
public final class JobConfig {
    public static final EnumMap<JobApi, Boolean> a = new EnumMap<>(JobApi.class);
    public static final JobCat b = new JobCat("JobConfig");
    public static final ExecutorService c;
    public static volatile boolean d;
    public static volatile boolean e = false;
    public static volatile long f = 3000;
    public static volatile int g = 0;
    public static volatile boolean h = false;
    public static volatile Clock i = Clock.DEFAULT;
    public static volatile ExecutorService j;
    public static volatile boolean k = false;

    public static class a implements ThreadFactory {
        public final AtomicInteger a = new AtomicInteger();

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            StringBuilder L = a2.b.a.a.a.L("AndroidJob-");
            L.append(this.a.incrementAndGet());
            Thread thread = new Thread(runnable, L.toString());
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    static {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool(new a());
        c = newCachedThreadPool;
        j = newCachedThreadPool;
        JobApi[] values = JobApi.values();
        for (int i2 = 0; i2 < 7; i2++) {
            a.put((EnumMap<JobApi, Boolean>) values[i2], (JobApi) Boolean.TRUE);
        }
    }

    public JobConfig() {
        throw new UnsupportedOperationException();
    }

    public static synchronized boolean addLogger(@NonNull JobLogger jobLogger) {
        boolean addLogger;
        synchronized (JobConfig.class) {
            addLogger = JobCat.addLogger(jobLogger);
        }
        return addLogger;
    }

    public static void forceApi(@NonNull JobApi jobApi) {
        JobApi[] values = JobApi.values();
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 < 7) {
                JobApi jobApi2 = values[i2];
                EnumMap<JobApi, Boolean> enumMap = a;
                if (jobApi2 != jobApi) {
                    z = false;
                }
                enumMap.put((EnumMap<JobApi, Boolean>) jobApi2, (JobApi) Boolean.valueOf(z));
                i2++;
            } else {
                b.w("forceApi - %s", jobApi);
                return;
            }
        }
    }

    public static Clock getClock() {
        return i;
    }

    public static ExecutorService getExecutorService() {
        return j;
    }

    public static int getJobIdOffset() {
        return g;
    }

    public static long getJobReschedulePause() {
        return f;
    }

    public static boolean isAllowSmallerIntervalsForMarshmallow() {
        return d && Build.VERSION.SDK_INT < 24;
    }

    public static boolean isApiEnabled(@NonNull JobApi jobApi) {
        return a.get(jobApi).booleanValue();
    }

    public static boolean isCloseDatabase() {
        return k;
    }

    public static boolean isForceAllowApi14() {
        return e;
    }

    public static boolean isForceRtc() {
        return h;
    }

    public static boolean isLogcatEnabled() {
        return JobCat.isLogcatEnabled();
    }

    public static synchronized void removeLogger(@NonNull JobLogger jobLogger) {
        synchronized (JobConfig.class) {
            JobCat.removeLogger(jobLogger);
        }
    }

    public static void reset() {
        JobApi[] values = JobApi.values();
        for (int i2 = 0; i2 < 7; i2++) {
            a.put((EnumMap<JobApi, Boolean>) values[i2], (JobApi) Boolean.TRUE);
        }
        d = false;
        e = false;
        f = 3000;
        g = 0;
        h = false;
        i = Clock.DEFAULT;
        j = c;
        k = false;
        JobCat.setLogcatEnabled(true);
        JobCat.clearLogger();
    }

    public static void setAllowSmallerIntervalsForMarshmallow(boolean z) {
        if (!z || Build.VERSION.SDK_INT < 24) {
            d = z;
            return;
        }
        throw new IllegalStateException("This method is only allowed to call on Android M or earlier");
    }

    public static void setApiEnabled(@NonNull JobApi jobApi, boolean z) {
        a.put((EnumMap<JobApi, Boolean>) jobApi, (JobApi) Boolean.valueOf(z));
        b.w("setApiEnabled - %s, %b", jobApi, Boolean.valueOf(z));
    }

    public static void setCloseDatabase(boolean z) {
        k = z;
    }

    public static void setExecutorService(@NonNull ExecutorService executorService) {
        j = (ExecutorService) JobPreconditions.checkNotNull(executorService);
    }

    public static void setForceAllowApi14(boolean z) {
        e = z;
    }

    public static void setForceRtc(boolean z) {
        h = z;
    }

    public static void setJobIdOffset(int i2) {
        JobPreconditions.checkArgumentNonnegative(i2, "offset can't be negative");
        if (i2 <= 2147479500) {
            g = i2;
            return;
        }
        throw new IllegalArgumentException("offset is too close to Integer.MAX_VALUE");
    }

    public static void setJobReschedulePause(long j2, @NonNull TimeUnit timeUnit) {
        f = timeUnit.toMillis(j2);
    }

    public static void setLogcatEnabled(boolean z) {
        JobCat.setLogcatEnabled(z);
    }
}
