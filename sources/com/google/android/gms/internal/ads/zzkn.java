package com.google.android.gms.internal.ads;

import java.io.IOException;
public final class zzkn implements zzkm {
    private final /* synthetic */ zzkl zzarg;

    private zzkn(zzkl zzkl) {
        this.zzarg = zzkl;
    }

    @Override // com.google.android.gms.internal.ads.zzkm
    public final void zza(int i, double d) throws zzhv {
        this.zzarg.zza(i, d);
    }

    @Override // com.google.android.gms.internal.ads.zzkm
    public final int zzan(int i) {
        return zzkl.zzan(i);
    }

    @Override // com.google.android.gms.internal.ads.zzkm
    public final boolean zzao(int i) {
        return zzkl.zzao(i);
    }

    @Override // com.google.android.gms.internal.ads.zzkm
    public final void zzap(int i) throws zzhv {
        this.zzarg.zzap(i);
    }

    @Override // com.google.android.gms.internal.ads.zzkm
    public final void zzc(int i, long j) throws zzhv {
        this.zzarg.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzkm
    public final void zzd(int i, long j, long j2) throws zzhv {
        this.zzarg.zzd(i, j, j2);
    }

    public /* synthetic */ zzkn(zzkl zzkl, zzko zzko) {
        this(zzkl);
    }

    @Override // com.google.android.gms.internal.ads.zzkm
    public final void zza(int i, String str) throws zzhv {
        this.zzarg.zza(i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzkm
    public final void zza(int i, int i2, zzjy zzjy) throws IOException, InterruptedException {
        this.zzarg.zza(i, i2, zzjy);
    }
}
