package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzbjw implements zzdko {
    private final /* synthetic */ zzbjc zzeud;
    private Context zzffg;
    private String zzffh;

    private zzbjw(zzbjc zzbjc) {
        this.zzeud = zzbjc;
    }

    @Override // com.google.android.gms.internal.ads.zzdko
    public final zzdkp zzaga() {
        zzelu.zza(this.zzffg, Context.class);
        return new zzbjz(this.zzeud, this.zzffg, this.zzffh);
    }

    @Override // com.google.android.gms.internal.ads.zzdko
    public final /* synthetic */ zzdko zzby(Context context) {
        this.zzffg = (Context) zzelu.checkNotNull(context);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdko
    public final /* synthetic */ zzdko zzfw(String str) {
        this.zzffh = str;
        return this;
    }
}
