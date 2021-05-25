package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
public final class zzccu {
    @Nullable
    private zzadr zzcki;

    public zzccu(zzccm zzccm) {
        this.zzcki = zzccm;
    }

    public final synchronized void zza(@Nullable zzadr zzadr) {
        this.zzcki = zzadr;
    }

    @Nullable
    public final synchronized zzadr zzss() {
        return this.zzcki;
    }
}
