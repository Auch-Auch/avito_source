package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;
public final class zzdge implements zzden<zzdgf> {
    public List<String> zzdqh;
    private zzdvw zzgay;
    public zzaaf zzgwn;

    public zzdge(zzaaf zzaaf, zzdvw zzdvw, List<String> list) {
        this.zzgwn = zzaaf;
        this.zzgay = zzdvw;
        this.zzdqh = list;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzdgf> zzaqs() {
        return this.zzgay.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdgh
            private final zzdge zzgwo;

            {
                this.zzgwo = r1;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdge zzdge = this.zzgwo;
                return new zzdgf(zzdge.zzgwn.zzf(zzdge.zzdqh));
            }
        });
    }
}
