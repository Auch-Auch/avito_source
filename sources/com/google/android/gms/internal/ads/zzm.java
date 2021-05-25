package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;
public final class zzm extends Thread {
    private static final boolean DEBUG = zzaq.DEBUG;
    private final BlockingQueue<zzaa<?>> zzl;
    private final BlockingQueue<zzaa<?>> zzm;
    private final zzk zzn;
    private final zzak zzo;
    private volatile boolean zzp = false;
    private final zzo zzq;

    public zzm(BlockingQueue<zzaa<?>> blockingQueue, BlockingQueue<zzaa<?>> blockingQueue2, zzk zzk, zzak zzak) {
        this.zzl = blockingQueue;
        this.zzm = blockingQueue2;
        this.zzn = zzk;
        this.zzo = zzak;
        this.zzq = new zzo(this);
    }

    private final void processRequest() throws InterruptedException {
        zzaa<?> take = this.zzl.take();
        take.zzc("cache-queue-take");
        take.zzd(1);
        int i = 2;
        try {
            take.isCanceled();
            zzn zzb = this.zzn.zzb(take.zze());
            if (zzb == null) {
                take.zzc("cache-miss");
                if (!zzo.zza(this.zzq, take)) {
                    this.zzm.put(take);
                }
            } else if (zzb.zza()) {
                take.zzc("cache-hit-expired");
                take.zza(zzb);
                if (!zzo.zza(this.zzq, take)) {
                    this.zzm.put(take);
                }
                take.zzd(2);
            } else {
                take.zzc("cache-hit");
                zzaj<?> zza = take.zza(new zzy(zzb.data, zzb.zzw));
                take.zzc("cache-hit-parsed");
                if (!zza.isSuccess()) {
                    take.zzc("cache-parsing-failed");
                    this.zzn.zza(take.zze(), true);
                    take.zza((zzn) null);
                    if (!zzo.zza(this.zzq, take)) {
                        this.zzm.put(take);
                    }
                    take.zzd(2);
                    return;
                }
                if (!(zzb.zzv < System.currentTimeMillis())) {
                    this.zzo.zzb(take, zza);
                } else {
                    take.zzc("cache-hit-refresh-needed");
                    take.zza(zzb);
                    zza.zzbu = true;
                    if (!zzo.zza(this.zzq, take)) {
                        this.zzo.zza(take, zza, new zzp(this, take));
                    } else {
                        this.zzo.zzb(take, zza);
                    }
                }
                take.zzd(2);
            }
        } finally {
            take.zzd(i);
        }
    }

    public final void quit() {
        this.zzp = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (DEBUG) {
            zzaq.v("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzn.initialize();
        while (true) {
            try {
                processRequest();
            } catch (InterruptedException unused) {
                if (this.zzp) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzaq.e("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
