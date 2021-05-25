package com.google.android.gms.internal.ads;

import java.lang.Thread;
public final class zzart implements Thread.UncaughtExceptionHandler {
    private final /* synthetic */ zzaro zzdps;
    private final /* synthetic */ Thread.UncaughtExceptionHandler zzdpu;

    public zzart(zzaro zzaro, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzdps = zzaro;
        this.zzdpu = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            this.zzdps.zza(thread, th);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.zzdpu;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.zzdpu;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            }
            throw th2;
        }
    }
}
