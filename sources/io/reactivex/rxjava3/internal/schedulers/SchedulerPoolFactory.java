package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
public final class SchedulerPoolFactory {
    public static final boolean PURGE_ENABLED;
    public static final int PURGE_PERIOD_SECONDS;
    public static final AtomicReference<ScheduledExecutorService> a = new AtomicReference<>();
    public static final Map<ScheduledThreadPoolExecutor, Object> b = new ConcurrentHashMap();

    public static final class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(SchedulerPoolFactory.b.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    SchedulerPoolFactory.b.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    public static final class b implements Function<String, String> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public String apply(String str) throws Throwable {
            return System.getProperty(str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031 A[SYNTHETIC, Splitter:B:11:0x0031] */
    static {
        /*
            java.util.concurrent.atomic.AtomicReference r0 = new java.util.concurrent.atomic.AtomicReference
            r0.<init>()
            io.reactivex.rxjava3.internal.schedulers.SchedulerPoolFactory.a = r0
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            io.reactivex.rxjava3.internal.schedulers.SchedulerPoolFactory.b = r0
            io.reactivex.rxjava3.internal.schedulers.SchedulerPoolFactory$b r0 = new io.reactivex.rxjava3.internal.schedulers.SchedulerPoolFactory$b
            r0.<init>()
            java.lang.String r1 = "rx3.purge-enabled"
            r2 = 1
            java.lang.Object r1 = r0.apply(r1)     // Catch:{ all -> 0x0026 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0026 }
            if (r1 != 0) goto L_0x001f
            goto L_0x002a
        L_0x001f:
            java.lang.String r3 = "true"
            boolean r1 = r3.equals(r1)     // Catch:{ all -> 0x0026 }
            goto L_0x002b
        L_0x0026:
            r1 = move-exception
            io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r1)
        L_0x002a:
            r1 = 1
        L_0x002b:
            io.reactivex.rxjava3.internal.schedulers.SchedulerPoolFactory.PURGE_ENABLED = r1
            java.lang.String r3 = "rx3.purge-period-seconds"
            if (r1 == 0) goto L_0x0043
            java.lang.Object r0 = r0.apply(r3)     // Catch:{ all -> 0x003f }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x003f }
            if (r0 != 0) goto L_0x003a
            goto L_0x0043
        L_0x003a:
            int r2 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x003f }
            goto L_0x0043
        L_0x003f:
            r0 = move-exception
            io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r0)
        L_0x0043:
            io.reactivex.rxjava3.internal.schedulers.SchedulerPoolFactory.PURGE_PERIOD_SECONDS = r2
            start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.schedulers.SchedulerPoolFactory.<clinit>():void");
    }

    public SchedulerPoolFactory() {
        throw new IllegalStateException("No instances!");
    }

    public static ScheduledExecutorService create(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (PURGE_ENABLED && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            b.put((ScheduledThreadPoolExecutor) newScheduledThreadPool, newScheduledThreadPool);
        }
        return newScheduledThreadPool;
    }

    public static void shutdown() {
        ScheduledExecutorService andSet = a.getAndSet(null);
        if (andSet != null) {
            andSet.shutdownNow();
        }
        b.clear();
    }

    public static void start() {
        if (PURGE_ENABLED) {
            while (true) {
                AtomicReference<ScheduledExecutorService> atomicReference = a;
                ScheduledExecutorService scheduledExecutorService = atomicReference.get();
                if (scheduledExecutorService == null) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
                    if (atomicReference.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                        a aVar = new a();
                        long j = (long) PURGE_PERIOD_SECONDS;
                        newScheduledThreadPool.scheduleAtFixedRate(aVar, j, j, TimeUnit.SECONDS);
                        return;
                    }
                    newScheduledThreadPool.shutdownNow();
                } else {
                    return;
                }
            }
        }
    }
}
