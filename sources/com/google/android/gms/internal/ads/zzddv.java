package com.google.android.gms.internal.ads;

import android.os.Bundle;
public final class zzddv implements zzdek<Bundle> {
    private final String zzdwv;
    private final String zzguq;
    private final String zzgur;
    private final String zzgus;
    private final Long zzgut;

    public zzddv(String str, String str2, String str3, String str4, Long l) {
        this.zzdwv = str;
        this.zzguq = str2;
        this.zzgur = str3;
        this.zzgus = str4;
        this.zzgut = l;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdek
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzdlu.zza(bundle2, "gmp_app_id", this.zzdwv);
        zzdlu.zza(bundle2, "fbs_aiid", this.zzguq);
        zzdlu.zza(bundle2, "fbs_aeid", this.zzgur);
        zzdlu.zza(bundle2, "apm_id_origin", this.zzgus);
        Long l = this.zzgut;
        if (l != null) {
            bundle2.putLong("sai_timeout", l.longValue());
        }
    }
}
