package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
public final class zzgb<V> extends FutureTask<V> implements Comparable<zzgb<V>> {
    public final boolean zza;
    private final long zzb;
    private final String zzc;
    private final /* synthetic */ zzfw zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzgb(zzfw zzfw, Callable<V> callable, boolean z, String str) {
        super(callable);
        this.zzd = zzfw;
        Preconditions.checkNotNull(str);
        long andIncrement = zzfw.zzj.getAndIncrement();
        this.zzb = andIncrement;
        this.zzc = str;
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzfw.zzr().zzf().zza("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(@NonNull Object obj) {
        zzgb zzgb = (zzgb) obj;
        boolean z = this.zza;
        if (z != zzgb.zza) {
            return z ? -1 : 1;
        }
        long j = this.zzb;
        long j2 = zzgb.zzb;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.zzd.zzr().zzg().zza("Two tasks share the same index. index", Long.valueOf(this.zzb));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th) {
        this.zzd.zzr().zzf().zza(this.zzc, th);
        if (th instanceof zzfz) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzgb(zzfw zzfw, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        this.zzd = zzfw;
        Preconditions.checkNotNull(str);
        long andIncrement = zzfw.zzj.getAndIncrement();
        this.zzb = andIncrement;
        this.zzc = str;
        this.zza = false;
        if (andIncrement == Long.MAX_VALUE) {
            zzfw.zzr().zzf().zza("Tasks index overflow");
        }
    }
}
