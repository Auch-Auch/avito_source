package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
public final class zzbsh implements zzelo<String> {
    private final zzbsg zzfsm;

    private zzbsh(zzbsg zzbsg) {
        this.zzfsm = zzbsg;
    }

    public static zzbsh zzg(zzbsg zzbsg) {
        return new zzbsh(zzbsg);
    }

    @Nullable
    public static String zzh(zzbsg zzbsg) {
        return zzbsg.zzaji();
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    @Nullable
    public final /* synthetic */ Object get() {
        return this.zzfsm.zzaji();
    }
}
