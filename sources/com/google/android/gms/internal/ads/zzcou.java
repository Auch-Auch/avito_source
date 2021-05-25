package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
public final class zzcou implements zzbvj {
    private final zzawb zzbqm;
    private final Context zzvr;

    public zzcou(Context context, zzawb zzawb) {
        this.zzvr = context;
        this.zzbqm = zzawb;
    }

    @Override // com.google.android.gms.internal.ads.zzbvj
    public final void zzb(zzdlj zzdlj) {
        if (!TextUtils.isEmpty(zzdlj.zzhbq.zzhbn.zzdst)) {
            this.zzbqm.zza(this.zzvr, zzdlj.zzhbp.zzfqn.zzhbu);
            this.zzbqm.zzk(this.zzvr, zzdlj.zzhbq.zzhbn.zzdst);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvj
    public final void zzd(zzasp zzasp) {
    }
}
