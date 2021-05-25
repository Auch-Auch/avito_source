package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbse;
import javax.annotation.concurrent.GuardedBy;
public final class zzdir<RequestComponentT extends zzbse<AdT>, AdT> implements zzdiz<RequestComponentT, AdT> {
    @Nullable
    @GuardedBy("this")
    private RequestComponentT zzgyk;

    /* access modifiers changed from: private */
    /* renamed from: zzasc */
    public final synchronized RequestComponentT zzasb() {
        return this.zzgyk;
    }

    @Override // com.google.android.gms.internal.ads.zzdiz
    public final synchronized zzdvt<AdT> zza(zzdja zzdja, zzdjb<RequestComponentT> zzdjb) {
        RequestComponentT zzael;
        zzael = zzdjb.zzc(zzdja.zzgzc).zzael();
        this.zzgyk = zzael;
        return zzael.zzafc().zzaiv();
    }
}
