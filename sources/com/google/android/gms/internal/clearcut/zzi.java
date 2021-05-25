package com.google.android.gms.internal.clearcut;

import com.google.android.gms.common.api.Status;
public final class zzi extends zzg {
    private final /* synthetic */ zzh zzap;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzi(zzh zzh) {
        super(null);
        this.zzap = zzh;
    }

    @Override // com.google.android.gms.internal.clearcut.zzg, com.google.android.gms.internal.clearcut.zzl
    public final void zza(Status status) {
        this.zzap.setResult((zzh) status);
    }
}
