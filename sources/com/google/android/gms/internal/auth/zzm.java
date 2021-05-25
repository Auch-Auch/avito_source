package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;
public final class zzm extends zzn {
    private final /* synthetic */ zzl zzag;

    public zzm(zzl zzl) {
        this.zzag = zzl;
    }

    @Override // com.google.android.gms.internal.auth.zzn, com.google.android.gms.auth.account.zza
    public final void zza(boolean z) {
        this.zzag.setResult((zzl) new zzq(z ? Status.RESULT_SUCCESS : zzh.zzad));
    }
}
