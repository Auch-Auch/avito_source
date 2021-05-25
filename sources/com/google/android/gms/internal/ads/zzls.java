package com.google.android.gms.internal.ads;
public final class zzls {
    public final int[] zzaoj;
    public final long[] zzaok;
    public final int zzawy;
    public final int zzaxe;
    public final int[] zzaxg;
    public final long[] zzbbd;

    public zzls(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        boolean z = true;
        zzoz.checkArgument(iArr.length == jArr2.length);
        zzoz.checkArgument(jArr.length == jArr2.length);
        zzoz.checkArgument(iArr2.length != jArr2.length ? false : z);
        this.zzaok = jArr;
        this.zzaoj = iArr;
        this.zzaxe = i;
        this.zzbbd = jArr2;
        this.zzaxg = iArr2;
        this.zzawy = jArr.length;
    }

    public final int zzec(long j) {
        for (int zza = zzpq.zza(this.zzbbd, j, true, false); zza >= 0; zza--) {
            if ((this.zzaxg[zza] & 1) != 0) {
                return zza;
            }
        }
        return -1;
    }

    public final int zzed(long j) {
        for (int zzb = zzpq.zzb(this.zzbbd, j, true, false); zzb < this.zzbbd.length; zzb++) {
            if ((this.zzaxg[zzb] & 1) != 0) {
                return zzb;
            }
        }
        return -1;
    }
}
