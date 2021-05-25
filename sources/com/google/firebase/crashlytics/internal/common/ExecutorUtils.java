package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
public final class ExecutorUtils {

    public class a implements ThreadFactory {
        public final /* synthetic */ String a;
        public final /* synthetic */ AtomicLong b;

        /* renamed from: com.google.firebase.crashlytics.internal.common.ExecutorUtils$a$a  reason: collision with other inner class name */
        public class C0302a extends BackgroundPriorityRunnable {
            public final /* synthetic */ Runnable a;

            public C0302a(a aVar, Runnable runnable) {
                this.a = runnable;
            }

            @Override // com.google.firebase.crashlytics.internal.common.BackgroundPriorityRunnable
            public void onRun() {
                this.a.run();
            }
        }

        public a(String str, AtomicLong atomicLong) {
            this.a = str;
            this.b = atomicLong;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(new C0302a(this, runnable));
            newThread.setName(this.a + this.b.getAndIncrement());
            return newThread;
        }
    }

    public class b extends BackgroundPriorityRunnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ ExecutorService b;
        public final /* synthetic */ long c;
        public final /* synthetic */ TimeUnit d;

        public b(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
            this.a = str;
            this.b = executorService;
            this.c = j;
            this.d = timeUnit;
        }

        @Override // com.google.firebase.crashlytics.internal.common.BackgroundPriorityRunnable
        public void onRun() {
            try {
                Logger logger = Logger.getLogger();
                logger.d("Executing shutdown hook for " + this.a);
                this.b.shutdown();
                if (!this.b.awaitTermination(this.c, this.d)) {
                    Logger logger2 = Logger.getLogger();
                    logger2.d(this.a + " did not shut down in the allocated time. Requesting immediate shutdown.");
                    this.b.shutdownNow();
                }
            } catch (InterruptedException unused) {
                Logger.getLogger().d(String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", this.a));
                this.b.shutdownNow();
            }
        }
    }

    public static final void addDelayedShutdownHook(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        Runtime.getRuntime().addShutdownHook(new Thread(new b(str, executorService, j, timeUnit), a2.b.a.a.a.c3("Crashlytics Shutdown Hook for ", str)));
    }

    public static ExecutorService buildSingleThreadExecutorService(String str) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(getNamedThreadFactory(str));
        addDelayedShutdownHook(str, newSingleThreadExecutor, 2, TimeUnit.SECONDS);
        return newSingleThreadExecutor;
    }

    public static ScheduledExecutorService buildSingleThreadScheduledExecutorService(String str) {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(getNamedThreadFactory(str));
        addDelayedShutdownHook(str, newSingleThreadScheduledExecutor, 2, TimeUnit.SECONDS);
        return newSingleThreadScheduledExecutor;
    }

    public static final ThreadFactory getNamedThreadFactory(String str) {
        return new a(str, new AtomicLong(1));
    }
}
