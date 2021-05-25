package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
public final class zzfw extends zzgw {
    private static final AtomicLong zzj = new AtomicLong(Long.MIN_VALUE);
    private zzga zza;
    private zzga zzb;
    private final PriorityBlockingQueue<zzgb<?>> zzc = new PriorityBlockingQueue<>();
    private final BlockingQueue<zzgb<?>> zzd = new LinkedBlockingQueue();
    private final Thread.UncaughtExceptionHandler zze = new zzfy(this, "Thread death: Uncaught exception on worker thread");
    private final Thread.UncaughtExceptionHandler zzf = new zzfy(this, "Thread death: Uncaught exception on network thread");
    private final Object zzg = new Object();
    private final Semaphore zzh = new Semaphore(2);
    private volatile boolean zzi;

    public zzfw(zzgd zzgd) {
        super(zzgd);
    }

    public final <V> Future<V> zza(Callable<V> callable) throws IllegalStateException {
        zzaa();
        Preconditions.checkNotNull(callable);
        zzgb<?> zzgb = new zzgb<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zza) {
            if (!this.zzc.isEmpty()) {
                zzr().zzi().zza("Callable skipped the worker queue.");
            }
            zzgb.run();
        } else {
            zza(zzgb);
        }
        return zzgb;
    }

    public final <V> Future<V> zzb(Callable<V> callable) throws IllegalStateException {
        zzaa();
        Preconditions.checkNotNull(callable);
        zzgb<?> zzgb = new zzgb<>(this, (Callable<?>) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zza) {
            zzgb.run();
        } else {
            zza(zzgb);
        }
        return zzgb;
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final void zzc() {
        if (Thread.currentThread() != this.zzb) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final void zzd() {
        if (Thread.currentThread() != this.zza) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgw
    public final boolean zze() {
        return false;
    }

    public final boolean zzg() {
        return Thread.currentThread() == this.zza;
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzai zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx, com.google.android.gms.measurement.internal.zzgz
    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx, com.google.android.gms.measurement.internal.zzgz
    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzex zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzkw zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx, com.google.android.gms.measurement.internal.zzgz
    public final /* bridge */ /* synthetic */ zzfw zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx, com.google.android.gms.measurement.internal.zzgz
    public final /* bridge */ /* synthetic */ zzez zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzfl zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ zzy zzt() {
        return super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzgx, com.google.android.gms.measurement.internal.zzgz
    public final /* bridge */ /* synthetic */ zzx zzu() {
        return super.zzu();
    }

    public final void zzb(Runnable runnable) throws IllegalStateException {
        zzaa();
        Preconditions.checkNotNull(runnable);
        zzgb<?> zzgb = new zzgb<>(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzg) {
            this.zzd.add(zzgb);
            zzga zzga = this.zzb;
            if (zzga == null) {
                zzga zzga2 = new zzga(this, "Measurement Network", this.zzd);
                this.zzb = zzga2;
                zzga2.setUncaughtExceptionHandler(this.zzf);
                this.zzb.start();
            } else {
                zzga.zza();
            }
        }
    }

    public final void zza(Runnable runnable) throws IllegalStateException {
        zzaa();
        Preconditions.checkNotNull(runnable);
        zza(new zzgb<>(this, runnable, false, "Task exception on worker thread"));
    }

    public final <T> T zza(AtomicReference<T> atomicReference, long j, String str, Runnable runnable) {
        synchronized (atomicReference) {
            zzq().zza(runnable);
            try {
                atomicReference.wait(j);
            } catch (InterruptedException unused) {
                zzfb zzi2 = zzr().zzi();
                String valueOf = String.valueOf(str);
                zzi2.zza(valueOf.length() != 0 ? "Interrupted waiting for ".concat(valueOf) : new String("Interrupted waiting for "));
                return null;
            }
        }
        T t = atomicReference.get();
        if (t == null) {
            zzfb zzi3 = zzr().zzi();
            String valueOf2 = String.valueOf(str);
            zzi3.zza(valueOf2.length() != 0 ? "Timed out waiting for ".concat(valueOf2) : new String("Timed out waiting for "));
        }
        return t;
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    private final void zza(zzgb<?> zzgb) {
        synchronized (this.zzg) {
            this.zzc.add(zzgb);
            zzga zzga = this.zza;
            if (zzga == null) {
                zzga zzga2 = new zzga(this, "Measurement Worker", this.zzc);
                this.zza = zzga2;
                zzga2.setUncaughtExceptionHandler(this.zze);
                this.zza.start();
            } else {
                zzga.zza();
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
