package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;
public final class zzkm implements zzfe {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzkk zzb;

    public zzkm(zzkk zzkk, String str) {
        this.zzb = zzkk;
        this.zza = str;
    }

    @Override // com.google.android.gms.measurement.internal.zzfe
    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.zzb.zza(i, th, bArr, this.zza);
    }
}
