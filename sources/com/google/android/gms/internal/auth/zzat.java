package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyResponse;
public final class zzat extends zzaj {
    private final /* synthetic */ zzas zzcf;

    public zzat(zzas zzas) {
        this.zzcf = zzas;
    }

    @Override // com.google.android.gms.internal.auth.zzaj, com.google.android.gms.internal.auth.zzal
    public final void zza(ProxyResponse proxyResponse) {
        this.zzcf.setResult((zzas) new zzaw(proxyResponse));
    }
}
