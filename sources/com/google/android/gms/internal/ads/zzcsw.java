package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzp;
public final class zzcsw implements zzcaz {
    private final zzbbg zzbop;
    private final zzdkx zzfyh;
    private final zzdvt<zzbzt> zzgmk;
    private final zzbfq zzgml;
    private final Context zzvr;

    private zzcsw(Context context, zzbbg zzbbg, zzdvt<zzbzt> zzdvt, zzdkx zzdkx, zzbfq zzbfq) {
        this.zzvr = context;
        this.zzbop = zzbbg;
        this.zzgmk = zzdvt;
        this.zzfyh = zzdkx;
        this.zzgml = zzbfq;
    }

    @Override // com.google.android.gms.internal.ads.zzcaz
    public final void zza(boolean z, Context context) {
        this.zzgml.zzax(true);
        zzp.zzkp();
        zzi zzi = new zzi(false, zzayh.zzbc(this.zzvr), false, 0.0f, -1, z, this.zzfyh.zzfnp, false);
        zzp.zzko();
        zzcap zzagd = ((zzbzt) zzdvl.zzb(this.zzgmk)).zzagd();
        zzbfq zzbfq = this.zzgml;
        zzdkx zzdkx = this.zzfyh;
        int i = zzdkx.zzhaw;
        zzbbg zzbbg = this.zzbop;
        String str = zzdkx.zzdrx;
        zzdlb zzdlb = zzdkx.zzhao;
        zzn.zza(context, new AdOverlayInfoParcel((zzut) null, zzagd, (zzt) null, zzbfq, i, zzbbg, str, zzi, zzdlb.zzdos, zzdlb.zzdou), true);
    }
}
