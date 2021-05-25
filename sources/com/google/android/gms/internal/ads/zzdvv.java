package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
public final class zzdvv {
    public static zzdvw zza(ExecutorService executorService) {
        if (executorService instanceof zzdvw) {
            return (zzdvw) executorService;
        }
        if (executorService instanceof ScheduledExecutorService) {
            return new zzdvz((ScheduledExecutorService) executorService);
        }
        return new zzdwa(executorService);
    }

    public static Executor zzaxm() {
        return zzdva.INSTANCE;
    }

    public static Executor zza(Executor executor, zzdui<?> zzdui) {
        zzdsv.checkNotNull(executor);
        zzdsv.checkNotNull(zzdui);
        if (executor == zzdva.INSTANCE) {
            return executor;
        }
        return new zzdvy(executor, zzdui);
    }
}
