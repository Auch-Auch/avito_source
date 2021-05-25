package com.google.android.gms.internal.ads;
public final class zzla implements zzky {
    private final zzpk zzawe;
    private final int zzawy;
    private final int zzaxc;

    public zzla(zzkt zzkt) {
        zzpk zzpk = zzkt.zzawe;
        this.zzawe = zzpk;
        zzpk.zzbo(12);
        this.zzaxc = zzpk.zzjd();
        this.zzawy = zzpk.zzjd();
    }

    @Override // com.google.android.gms.internal.ads.zzky
    public final int zzgw() {
        return this.zzawy;
    }

    @Override // com.google.android.gms.internal.ads.zzky
    public final int zzgx() {
        int i = this.zzaxc;
        return i == 0 ? this.zzawe.zzjd() : i;
    }

    @Override // com.google.android.gms.internal.ads.zzky
    public final boolean zzgy() {
        return this.zzaxc != 0;
    }
}
