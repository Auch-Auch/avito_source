package com.google.android.gms.internal.gtm;

import java.util.List;
public abstract class zzru {
    private static final zzru zzbch = new zzrw();
    private static final zzru zzbci = new zzrx();

    private zzru() {
    }

    public static zzru zzqc() {
        return zzbch;
    }

    public static zzru zzqd() {
        return zzbci;
    }

    public abstract <L> List<L> zza(Object obj, long j);

    public abstract <L> void zza(Object obj, Object obj2, long j);

    public abstract void zzb(Object obj, long j);
}
