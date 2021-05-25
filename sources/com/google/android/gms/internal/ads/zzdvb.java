package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
public abstract class zzdvb<T> extends zzdvs<T> {
    private final /* synthetic */ zzduz zzhpm;
    private final Executor zzhpq;
    public boolean zzhpr = true;

    public zzdvb(zzduz zzduz, Executor executor) {
        this.zzhpm = zzduz;
        this.zzhpq = (Executor) zzdsv.checkNotNull(executor);
    }

    public final void execute() {
        try {
            this.zzhpq.execute(this);
        } catch (RejectedExecutionException e) {
            if (this.zzhpr) {
                this.zzhpm.setException(e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvs
    public final boolean isDone() {
        return this.zzhpm.isDone();
    }

    public abstract void setValue(T t);

    @Override // com.google.android.gms.internal.ads.zzdvs
    public final void zzb(T t, Throwable th) {
        zzduz.zza(this.zzhpm, (zzdvb) null);
        if (th == null) {
            setValue(t);
        } else if (th instanceof ExecutionException) {
            this.zzhpm.setException(th.getCause());
        } else if (th instanceof CancellationException) {
            this.zzhpm.cancel(false);
        } else {
            this.zzhpm.setException(th);
        }
    }
}
