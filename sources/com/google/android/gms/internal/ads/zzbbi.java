package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public final class zzbbi {
    public static final zzdvw zzedu;
    public static final zzdvw zzedv;
    public static final zzdvw zzedw;
    public static final ScheduledExecutorService zzedx = new ScheduledThreadPoolExecutor(3, zzfh(AppEventsConstants.EVENT_NAME_SCHEDULE));
    public static final zzdvw zzedy = zza(new zzbbk());
    public static final zzdvw zzedz = zza(zzdvv.zzaxm());

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        zzedu = zza(new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10, timeUnit, new SynchronousQueue(), zzfh("Default")));
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 10, timeUnit, new LinkedBlockingQueue(), zzfh("Loader"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        zzedv = zza(threadPoolExecutor);
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 10, timeUnit, new LinkedBlockingQueue(), zzfh("Activeview"));
        threadPoolExecutor2.allowCoreThreadTimeOut(true);
        zzedw = zza(threadPoolExecutor2);
    }

    private static zzdvw zza(Executor executor) {
        return new zzbbn(executor, null);
    }

    private static ThreadFactory zzfh(String str) {
        return new zzbbl(str);
    }
}
