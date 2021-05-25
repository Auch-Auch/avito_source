package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
public final class zzrl implements ValueCallback<String> {
    private final /* synthetic */ zzrm zzbtn;

    public zzrl(zzrm zzrm) {
        this.zzbtn = zzrm;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(String str) {
        zzrm zzrm = this.zzbtn;
        zzrm.zzbta.zza(zzrm.zzbtp, zzrm.zzbtq, str, zzrm.zzbtr);
    }
}
