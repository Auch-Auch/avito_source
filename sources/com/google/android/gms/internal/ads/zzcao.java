package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
public final class zzcao implements zzelo<View> {
    private final zzbzw zzfva;

    private zzcao(zzbzw zzbzw) {
        this.zzfva = zzbzw;
    }

    public static zzcao zzd(zzbzw zzbzw) {
        return new zzcao(zzbzw);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    @Nullable
    public final /* synthetic */ Object get() {
        return this.zzfva.zzakn();
    }
}
