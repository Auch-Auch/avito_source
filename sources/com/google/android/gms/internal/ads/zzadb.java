package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
public final class zzadb {
    private static final AtomicReference<zzadc> zzdcc = new AtomicReference<>();
    public static final AtomicBoolean zzdcd = new AtomicBoolean();

    public static void zza(zzadc zzadc) {
        zzdcc.set(zzadc);
    }

    public static zzadc zzrx() {
        return zzdcc.get();
    }
}
