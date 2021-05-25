package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
public final class zzbnt implements zzelo<zzbys<zzbuj>> {
    private final zzelx<Context> zzert;
    private final zzelx<zzbbg> zzfkr;
    private final zzelx<zzdkx> zzfnc;
    private final zzbnl zzfoq;
    private final zzelx<zzdln> zzfos;

    public zzbnt(zzbnl zzbnl, zzelx<Context> zzelx, zzelx<zzbbg> zzelx2, zzelx<zzdkx> zzelx3, zzelx<zzdln> zzelx4) {
        this.zzfoq = zzbnl;
        this.zzert = zzelx;
        this.zzfkr = zzelx2;
        this.zzfnc = zzelx3;
        this.zzfos = zzelx4;
    }

    public static zzbys<zzbuj> zza(zzbnl zzbnl, Context context, zzbbg zzbbg, zzdkx zzdkx, zzdln zzdln) {
        return (zzbys) zzelu.zza(new zzbys(new zzbuj(context, zzbbg, zzdkx, zzdln) { // from class: com.google.android.gms.internal.ads.zzbno
            private final Context zzcxz;
            private final zzbbg zzfon;
            private final zzdkx zzfoo;
            private final zzdln zzfop;

            {
                this.zzcxz = r1;
                this.zzfon = r2;
                this.zzfoo = r3;
                this.zzfop = r4;
            }

            @Override // com.google.android.gms.internal.ads.zzbuj
            public final void onAdLoaded() {
                zzp.zzkz().zzb(this.zzcxz, this.zzfon.zzbra, this.zzfoo.zzhat.toString(), this.zzfop.zzhbv);
            }
        }, zzbbi.zzedz), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zza(this.zzfoq, this.zzert.get(), this.zzfkr.get(), this.zzfnc.get(), this.zzfos.get());
    }
}
