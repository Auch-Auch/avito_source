package com.google.android.gms.internal.p002firebaseiid;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
/* renamed from: com.google.android.gms.internal.firebase-iid.zzc  reason: invalid package */
public final class zzc implements zzb {
    private zzc() {
    }

    @Override // com.google.android.gms.internal.p002firebaseiid.zzb
    public final ScheduledExecutorService zza(int i, ThreadFactory threadFactory, int i2) {
        return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, threadFactory));
    }
}
