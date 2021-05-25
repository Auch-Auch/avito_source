package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;
public final class zzav extends zzaj {
    private final /* synthetic */ zzau zzcg;

    public zzav(zzau zzau) {
        this.zzcg = zzau;
    }

    @Override // com.google.android.gms.internal.auth.zzaj, com.google.android.gms.internal.auth.zzal
    public final void zzb(String str) {
        if (str != null) {
            this.zzcg.setResult((zzau) new zzax(str));
        } else {
            this.zzcg.setResult((zzau) zzaq.zzc(new Status(3006)));
        }
    }
}
