package com.google.android.gms.internal.ads;
public final class zzhk {
    public final int index;
    private final zzhx[] zzael;
    private final zzog zzaem;
    public final zzmx zzafi;
    public final Object zzafj;
    public final zznm[] zzafk;
    private final boolean[] zzafl;
    public final long zzafm;
    public int zzafn;
    public long zzafo;
    public boolean zzafp;
    public boolean zzafq;
    public boolean zzafr;
    public zzhk zzafs;
    public zzoi zzaft;
    private final zzhw[] zzafu;
    private final zzhs zzafv;
    private final zzmz zzafw;
    private zzoi zzafx;

    public zzhk(zzhx[] zzhxArr, zzhw[] zzhwArr, long j, zzog zzog, zzhs zzhs, zzmz zzmz, Object obj, int i, int i2, boolean z, long j2) {
        this.zzael = zzhxArr;
        this.zzafu = zzhwArr;
        this.zzafm = j;
        this.zzaem = zzog;
        this.zzafv = zzhs;
        this.zzafw = zzmz;
        this.zzafj = zzoz.checkNotNull(obj);
        this.index = i;
        this.zzafn = i2;
        this.zzafp = z;
        this.zzafo = j2;
        this.zzafk = new zznm[zzhxArr.length];
        this.zzafl = new boolean[zzhxArr.length];
        this.zzafi = zzmz.zza(i2, zzhs.zzfb());
    }

    public final void release() {
        try {
            this.zzafw.zzb(this.zzafi);
        } catch (RuntimeException unused) {
        }
    }

    public final long zza(long j, boolean z, boolean[] zArr) {
        zzod zzod = this.zzaft.zzbht;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzod.length) {
                break;
            }
            boolean[] zArr2 = this.zzafl;
            if (z || !this.zzaft.zza(this.zzafx, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        long zza = this.zzafi.zza(zzod.zzik(), this.zzafl, this.zzafk, zArr, j);
        this.zzafx = this.zzaft;
        this.zzafr = false;
        int i2 = 0;
        while (true) {
            zznm[] zznmArr = this.zzafk;
            if (i2 < zznmArr.length) {
                if (zznmArr[i2] != null) {
                    zzoz.checkState(zzod.zzbg(i2) != null);
                    this.zzafr = true;
                } else {
                    zzoz.checkState(zzod.zzbg(i2) == null);
                }
                i2++;
            } else {
                this.zzafv.zza(this.zzael, this.zzaft.zzbhs, zzod);
                return zza;
            }
        }
    }

    public final long zzb(long j, boolean z) {
        return zza(j, false, new boolean[this.zzael.length]);
    }

    public final void zzc(int i, boolean z) {
        this.zzafn = i;
        this.zzafp = z;
    }

    public final long zzen() {
        return this.zzafm - this.zzafo;
    }

    public final boolean zzeo() {
        if (this.zzafq) {
            return !this.zzafr || this.zzafi.zzhp() == Long.MIN_VALUE;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzep() throws com.google.android.gms.internal.ads.zzhd {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzog r0 = r6.zzaem
            com.google.android.gms.internal.ads.zzhw[] r1 = r6.zzafu
            com.google.android.gms.internal.ads.zzmx r2 = r6.zzafi
            com.google.android.gms.internal.ads.zznp r2 = r2.zzhm()
            com.google.android.gms.internal.ads.zzoi r0 = r0.zza(r1, r2)
            com.google.android.gms.internal.ads.zzoi r1 = r6.zzafx
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0016
        L_0x0014:
            r1 = 0
            goto L_0x0028
        L_0x0016:
            r4 = 0
        L_0x0017:
            com.google.android.gms.internal.ads.zzod r5 = r0.zzbht
            int r5 = r5.length
            if (r4 >= r5) goto L_0x0027
            boolean r5 = r0.zza(r1, r4)
            if (r5 != 0) goto L_0x0024
            goto L_0x0014
        L_0x0024:
            int r4 = r4 + 1
            goto L_0x0017
        L_0x0027:
            r1 = 1
        L_0x0028:
            if (r1 == 0) goto L_0x002b
            return r3
        L_0x002b:
            r6.zzaft = r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhk.zzep():boolean");
    }
}
