package com.google.android.gms.internal.ads;
public final class zzboc implements zzelo<zzbys<zzbwm>> {
    private final zzbnl zzfoq;
    private final zzelx<zzbvb> zzfot;

    public zzboc(zzbnl zzbnl, zzelx<zzbvb> zzelx) {
        this.zzfoq = zzbnl;
        this.zzfot = zzelx;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzbys) zzelu.zza(new zzbys(new zzbwm(this.zzfot.get()) { // from class: com.google.android.gms.internal.ads.zzbnn
            private final zzbvb zzfom;

            {
                this.zzfom = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbwm
            public final void zzaia() {
                this.zzfom.zzajn();
            }
        }, zzbbi.zzedz), "Cannot return null from a non-@Nullable @Provides method");
    }
}
