package com.google.android.gms.internal.gtm;

import java.util.concurrent.ThreadFactory;
public final class zzgs implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "google-tag-manager-scheduler-thread");
    }
}
