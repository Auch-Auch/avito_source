package com.google.android.gms.internal.ads;

import android.content.Context;
public final class zzbrr implements zzelo<zzdsl<zzdkx, zzayy>> {
    private final zzelx<Context> zzert;
    private final zzelx<zzbbg> zzfkr;
    private final zzelx<zzdln> zzfos;

    public zzbrr(zzelx<Context> zzelx, zzelx<zzbbg> zzelx2, zzelx<zzdln> zzelx3) {
        this.zzert = zzelx;
        this.zzfkr = zzelx2;
        this.zzfos = zzelx3;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzdsl) zzelu.zza(new zzdsl(this.zzert.get(), this.zzfkr.get(), this.zzfos.get()) { // from class: com.google.android.gms.internal.ads.zzbrs
            private final Context zzcxz;
            private final zzbbg zzfon;
            private final zzdln zzfrl;

            {
                this.zzcxz = r1;
                this.zzfon = r2;
                this.zzfrl = r3;
            }

            @Override // com.google.android.gms.internal.ads.zzdsl
            public final Object apply(Object obj) {
                Context context = this.zzcxz;
                zzbbg zzbbg = this.zzfon;
                zzdln zzdln = this.zzfrl;
                zzdkx zzdkx = (zzdkx) obj;
                zzayy zzayy = new zzayy(context);
                zzayy.zzet(zzdkx.zzdrx);
                zzayy.zzeu(zzdkx.zzhat.toString());
                zzayy.zzae(zzbbg.zzbra);
                zzayy.setAdUnitId(zzdln.zzhbv);
                return zzayy;
            }
        }, "Cannot return null from a non-@Nullable @Provides method");
    }
}
