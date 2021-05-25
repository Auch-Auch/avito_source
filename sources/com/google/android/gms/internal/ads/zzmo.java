package com.google.android.gms.internal.ads;
public final class zzmo implements zznl {
    private final zznl[] zzbef;

    public zzmo(zznl[] zznlArr) {
        this.zzbef = zznlArr;
    }

    @Override // com.google.android.gms.internal.ads.zznl
    public final boolean zzef(long j) {
        boolean z;
        boolean z2 = false;
        do {
            long zzhn = zzhn();
            if (zzhn == Long.MIN_VALUE) {
                break;
            }
            zznl[] zznlArr = this.zzbef;
            z = false;
            for (zznl zznl : zznlArr) {
                if (zznl.zzhn() == zzhn) {
                    z |= zznl.zzef(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }

    @Override // com.google.android.gms.internal.ads.zznl
    public final long zzhn() {
        long j = Long.MAX_VALUE;
        for (zznl zznl : this.zzbef) {
            long zzhn = zznl.zzhn();
            if (zzhn != Long.MIN_VALUE) {
                j = Math.min(j, zzhn);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }
}
