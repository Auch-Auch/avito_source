package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkTimer {
    public static final String f = Logger.tagWithPrefix("WorkTimer");
    public final ThreadFactory a;
    public final ScheduledExecutorService b;
    public final Map<String, WorkTimerRunnable> c = new HashMap();
    public final Map<String, TimeLimitExceededListener> d = new HashMap();
    public final Object e = new Object();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface TimeLimitExceededListener {
        void onTimeLimitExceeded(@NonNull String str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class WorkTimerRunnable implements Runnable {
        public final WorkTimer a;
        public final String b;

        public WorkTimerRunnable(@NonNull WorkTimer workTimer, @NonNull String str) {
            this.a = workTimer;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.a.e) {
                if (this.a.c.remove(this.b) != null) {
                    TimeLimitExceededListener remove = this.a.d.remove(this.b);
                    if (remove != null) {
                        remove.onTimeLimitExceeded(this.b);
                    }
                } else {
                    Logger.get().debug("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", this.b), new Throwable[0]);
                }
            }
        }
    }

    public class a implements ThreadFactory {
        public int a = 0;

        public a(WorkTimer workTimer) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            StringBuilder L = a2.b.a.a.a.L("WorkManager-WorkTimer-thread-");
            L.append(this.a);
            newThread.setName(L.toString());
            this.a++;
            return newThread;
        }
    }

    public WorkTimer() {
        a aVar = new a(this);
        this.a = aVar;
        this.b = Executors.newSingleThreadScheduledExecutor(aVar);
    }

    @NonNull
    @VisibleForTesting
    public ScheduledExecutorService getExecutorService() {
        return this.b;
    }

    @NonNull
    @VisibleForTesting
    public synchronized Map<String, TimeLimitExceededListener> getListeners() {
        return this.d;
    }

    @NonNull
    @VisibleForTesting
    public synchronized Map<String, WorkTimerRunnable> getTimerMap() {
        return this.c;
    }

    public void onDestroy() {
        if (!this.b.isShutdown()) {
            this.b.shutdownNow();
        }
    }

    public void startTimer(@NonNull String str, long j, @NonNull TimeLimitExceededListener timeLimitExceededListener) {
        synchronized (this.e) {
            Logger.get().debug(f, String.format("Starting timer for %s", str), new Throwable[0]);
            stopTimer(str);
            WorkTimerRunnable workTimerRunnable = new WorkTimerRunnable(this, str);
            this.c.put(str, workTimerRunnable);
            this.d.put(str, timeLimitExceededListener);
            this.b.schedule(workTimerRunnable, j, TimeUnit.MILLISECONDS);
        }
    }

    public void stopTimer(@NonNull String str) {
        synchronized (this.e) {
            if (this.c.remove(str) != null) {
                Logger.get().debug(f, String.format("Stopping timer for %s", str), new Throwable[0]);
                this.d.remove(str);
            }
        }
    }
}
