package com.voximplant.sdk.internal.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
public class VoxExecutor {
    public static VoxExecutor b;
    public ScheduledExecutorService a = Executors.newSingleThreadScheduledExecutor();

    public static synchronized VoxExecutor getInstance() {
        VoxExecutor voxExecutor;
        synchronized (VoxExecutor.class) {
            if (b == null) {
                b = new VoxExecutor();
            }
            voxExecutor = b;
        }
        return voxExecutor;
    }

    public void smRun(Runnable runnable) {
        this.a.execute(runnable);
    }

    public ScheduledFuture smRunAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.a.scheduleAtFixedRate(runnable, j, j2, timeUnit);
    }

    public ScheduledFuture smRunDelayed(Runnable runnable, int i) {
        return this.a.schedule(runnable, (long) i, TimeUnit.MILLISECONDS);
    }
}
