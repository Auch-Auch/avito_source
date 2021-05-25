package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
public final class zzbsi implements zzelo<Bundle> {
    private final zzbsg zzfsm;

    private zzbsi(zzbsg zzbsg) {
        this.zzfsm = zzbsg;
    }

    public static zzbsi zzi(zzbsg zzbsg) {
        return new zzbsi(zzbsg);
    }

    @Nullable
    public static Bundle zzj(zzbsg zzbsg) {
        return zzbsg.zzajh();
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    @Nullable
    public final /* synthetic */ Object get() {
        return this.zzfsm.zzajh();
    }
}
