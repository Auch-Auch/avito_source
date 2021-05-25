package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.ArrayList;
public final class zzbrx implements zzbtp, zzbuj {
    private final zzaqs zzboi;
    private final zzdkx zzfpf;
    private final Context zzvr;

    public zzbrx(Context context, zzdkx zzdkx, zzaqs zzaqs) {
        this.zzvr = context;
        this.zzfpf = zzdkx;
        this.zzboi = zzaqs;
    }

    @Override // com.google.android.gms.internal.ads.zzbuj
    public final void onAdLoaded() {
        zzaqq zzaqq = this.zzfpf.zzhbb;
        if (zzaqq != null && zzaqq.zzdpd) {
            ArrayList arrayList = new ArrayList();
            if (!this.zzfpf.zzhbb.zzdpe.isEmpty()) {
                arrayList.add(this.zzfpf.zzhbb.zzdpe);
            }
            this.zzboi.zza(this.zzvr, arrayList);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final void zzbz(@Nullable Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final void zzca(@Nullable Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final void zzcb(@Nullable Context context) {
        this.zzboi.detach();
    }
}
