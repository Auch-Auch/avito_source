package com.google.android.gms.internal.ads;

import java.util.Map;
public final class zzcks implements zzdpl {
    private zzto zzgei;
    private Map<zzdpg, zzcku> zzger;

    public zzcks(zzto zzto, Map<zzdpg, zzcku> map) {
        this.zzger = map;
        this.zzgei = zzto;
    }

    @Override // com.google.android.gms.internal.ads.zzdpl
    public final void zza(zzdpg zzdpg, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdpl
    public final void zza(zzdpg zzdpg, String str, Throwable th) {
        if (this.zzger.containsKey(zzdpg)) {
            this.zzgei.zza(this.zzger.get(zzdpg).zzgev);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdpl
    public final void zzb(zzdpg zzdpg, String str) {
        if (this.zzger.containsKey(zzdpg)) {
            this.zzgei.zza(this.zzger.get(zzdpg).zzget);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdpl
    public final void zzc(zzdpg zzdpg, String str) {
        if (this.zzger.containsKey(zzdpg)) {
            this.zzgei.zza(this.zzger.get(zzdpg).zzgeu);
        }
    }
}
