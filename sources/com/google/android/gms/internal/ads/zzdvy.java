package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
public final class zzdvy implements Executor {
    public boolean zzhqc = true;
    private final /* synthetic */ Executor zzhqd;
    private final /* synthetic */ zzdui zzhqe;

    public zzdvy(Executor executor, zzdui zzdui) {
        this.zzhqd = executor;
        this.zzhqe = zzdui;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        try {
            this.zzhqd.execute(new zzdvx(this, runnable));
        } catch (RejectedExecutionException e) {
            if (this.zzhqc) {
                this.zzhqe.setException(e);
            }
        }
    }
}
