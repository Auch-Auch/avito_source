package com.google.android.gms.internal.ads;
public final class zzkv {
    public int index;
    public final int length;
    public int zzawi;
    public long zzawj;
    private final boolean zzawk;
    private final zzpk zzawl;
    private final zzpk zzawm;
    private int zzawn;
    private int zzawo;

    public zzkv(zzpk zzpk, zzpk zzpk2, boolean z) {
        this.zzawm = zzpk;
        this.zzawl = zzpk2;
        this.zzawk = z;
        zzpk2.zzbo(12);
        this.length = zzpk2.zzjd();
        zzpk.zzbo(12);
        this.zzawo = zzpk.zzjd();
        zzoz.checkState(zzpk.readInt() != 1 ? false : true, "first_chunk must be 1");
        this.index = -1;
    }

    public final boolean zzgv() {
        long j;
        int i = this.index + 1;
        this.index = i;
        if (i == this.length) {
            return false;
        }
        if (this.zzawk) {
            j = this.zzawl.zzje();
        } else {
            j = this.zzawl.zzja();
        }
        this.zzawj = j;
        if (this.index == this.zzawn) {
            this.zzawi = this.zzawm.zzjd();
            this.zzawm.zzbp(4);
            int i2 = this.zzawo - 1;
            this.zzawo = i2;
            this.zzawn = i2 > 0 ? this.zzawm.zzjd() - 1 : -1;
        }
        return true;
    }
}
