package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.OnPaidEventListener;
public final class zzzt extends zzyd {
    @Nullable
    private final OnPaidEventListener zzckr;

    public zzzt(@Nullable OnPaidEventListener onPaidEventListener) {
        this.zzckr = onPaidEventListener;
    }

    @Override // com.google.android.gms.internal.ads.zzya
    public final void zza(zzvl zzvl) {
        if (this.zzckr != null) {
            this.zzckr.onPaidEvent(AdValue.zza(zzvl.zzadb, zzvl.zzadc, zzvl.zzadd));
        }
    }
}
