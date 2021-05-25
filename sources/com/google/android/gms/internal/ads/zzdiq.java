package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbse;
import javax.annotation.concurrent.GuardedBy;
public final class zzdiq<RequestComponentT extends zzbse<AdT>, AdT> implements zzdiz<RequestComponentT, AdT> {
    @Nullable
    @GuardedBy("this")
    private RequestComponentT zzgyk;
    private final zzdiz<RequestComponentT, AdT> zzgyx;

    public zzdiq(zzdiz<RequestComponentT, AdT> zzdiz) {
        this.zzgyx = zzdiz;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzasc */
    public final synchronized RequestComponentT zzasb() {
        return this.zzgyk;
    }

    @Override // com.google.android.gms.internal.ads.zzdiz
    public final synchronized zzdvt<AdT> zza(zzdja zzdja, zzdjb<RequestComponentT> zzdjb) {
        if (zzdja.zzgzb != null) {
            RequestComponentT zzael = zzdjb.zzc(zzdja.zzgzc).zzael();
            this.zzgyk = zzael;
            return zzael.zzafc().zzb(zzdja.zzgzb);
        }
        zzdvt<AdT> zza = this.zzgyx.zza(zzdja, zzdjb);
        this.zzgyk = this.zzgyx.zzasb();
        return zza;
    }
}
