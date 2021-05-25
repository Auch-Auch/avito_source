package com.google.android.gms.internal.gtm;

import java.lang.Thread;
public final class zzaq implements Thread.UncaughtExceptionHandler {
    private final /* synthetic */ zzap zzwt;

    public zzaq(zzap zzap) {
        this.zzwt = zzap;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        zzci zzdd = this.zzwt.zzdd();
        if (zzdd != null) {
            zzdd.zze("Job execution failed", th);
        }
    }
}
