package com.google.android.gms.internal.ads;
public final class zznf {
    private int length;
    private int[] zzaoj = new int[1000];
    private long[] zzaok = new long[1000];
    private long[] zzaom = new long[1000];
    private int[] zzaxg = new int[1000];
    private int zzbfh = 1000;
    private int[] zzbfi = new int[1000];
    private zzkf[] zzbfj = new zzkf[1000];
    private zzho[] zzbfk = new zzho[1000];
    private int zzbfl;
    private int zzbfm;
    private int zzbfn;
    private long zzbfo = Long.MIN_VALUE;
    private long zzbfp = Long.MIN_VALUE;
    private boolean zzbfq = true;
    private boolean zzbfr = true;
    private zzho zzbfs;

    public final synchronized int zza(zzhq zzhq, zzjk zzjk, boolean z, boolean z2, zzho zzho, zzni zzni) {
        long j;
        if (zzic()) {
            if (!z) {
                zzho[] zzhoArr = this.zzbfk;
                int i = this.zzbfm;
                if (zzhoArr[i] == zzho) {
                    if (zzjk.zzdd == null) {
                        return -3;
                    }
                    zzjk.zzanx = this.zzaom[i];
                    zzjk.setFlags(this.zzaxg[i]);
                    int[] iArr = this.zzaoj;
                    int i2 = this.zzbfm;
                    zzni.size = iArr[i2];
                    zzni.zzawj = this.zzaok[i2];
                    zzni.zzarm = this.zzbfj[i2];
                    this.zzbfo = Math.max(this.zzbfo, zzjk.zzanx);
                    int i3 = this.length - 1;
                    this.length = i3;
                    int i4 = this.zzbfm + 1;
                    this.zzbfm = i4;
                    this.zzbfl++;
                    if (i4 == this.zzbfh) {
                        this.zzbfm = 0;
                    }
                    if (i3 > 0) {
                        j = this.zzaok[this.zzbfm];
                    } else {
                        j = zzni.zzawj + ((long) zzni.size);
                    }
                    zzni.zzbgg = j;
                    return -4;
                }
            }
            zzhq.zzaht = this.zzbfk[this.zzbfm];
            return -5;
        } else if (z2) {
            zzjk.setFlags(4);
            return -4;
        } else {
            zzho zzho2 = this.zzbfs;
            if (zzho2 == null || (!z && zzho2 == zzho)) {
                return -3;
            }
            zzhq.zzaht = zzho2;
            return -5;
        }
    }

    public final synchronized long zzd(long j, boolean z) {
        if (zzic()) {
            long[] jArr = this.zzaom;
            int i = this.zzbfm;
            if (j >= jArr[i]) {
                if (j > this.zzbfp && !z) {
                    return -1;
                }
                int i2 = 0;
                int i3 = -1;
                while (i != this.zzbfn && this.zzaom[i] <= j) {
                    if ((this.zzaxg[i] & 1) != 0) {
                        i3 = i2;
                    }
                    i = (i + 1) % this.zzbfh;
                    i2++;
                }
                if (i3 == -1) {
                    return -1;
                }
                int i4 = (this.zzbfm + i3) % this.zzbfh;
                this.zzbfm = i4;
                this.zzbfl += i3;
                this.length -= i3;
                return this.zzaok[i4];
            }
        }
        return -1;
    }

    public final synchronized void zzei(long j) {
        this.zzbfp = Math.max(this.zzbfp, j);
    }

    public final synchronized boolean zzg(zzho zzho) {
        if (zzho == null) {
            this.zzbfr = true;
            return false;
        }
        this.zzbfr = false;
        if (zzpq.zza(zzho, this.zzbfs)) {
            return false;
        }
        this.zzbfs = zzho;
        return true;
    }

    public final synchronized long zzht() {
        return Math.max(this.zzbfo, this.zzbfp);
    }

    public final void zzhz() {
        this.zzbfl = 0;
        this.zzbfm = 0;
        this.zzbfn = 0;
        this.length = 0;
        this.zzbfq = true;
    }

    public final void zzia() {
        this.zzbfo = Long.MIN_VALUE;
        this.zzbfp = Long.MIN_VALUE;
    }

    public final int zzib() {
        return this.zzbfl + this.length;
    }

    public final synchronized boolean zzic() {
        return this.length != 0;
    }

    public final synchronized zzho zzid() {
        if (this.zzbfr) {
            return null;
        }
        return this.zzbfs;
    }

    public final synchronized long zzie() {
        if (!zzic()) {
            return -1;
        }
        int i = this.zzbfm;
        int i2 = this.length;
        int i3 = this.zzbfh;
        int i4 = ((i + i2) - 1) % i3;
        this.zzbfm = (i + i2) % i3;
        this.zzbfl += i2;
        this.length = 0;
        return this.zzaok[i4] + ((long) this.zzaoj[i4]);
    }

    public final synchronized void zza(long j, int i, long j2, int i2, zzkf zzkf) {
        if (this.zzbfq) {
            if ((i & 1) != 0) {
                this.zzbfq = false;
            } else {
                return;
            }
        }
        zzoz.checkState(!this.zzbfr);
        zzei(j);
        long[] jArr = this.zzaom;
        int i3 = this.zzbfn;
        jArr[i3] = j;
        long[] jArr2 = this.zzaok;
        jArr2[i3] = j2;
        this.zzaoj[i3] = i2;
        this.zzaxg[i3] = i;
        this.zzbfj[i3] = zzkf;
        this.zzbfk[i3] = this.zzbfs;
        this.zzbfi[i3] = 0;
        int i4 = this.length + 1;
        this.length = i4;
        int i5 = this.zzbfh;
        if (i4 == i5) {
            int i6 = i5 + 1000;
            int[] iArr = new int[i6];
            long[] jArr3 = new long[i6];
            long[] jArr4 = new long[i6];
            int[] iArr2 = new int[i6];
            int[] iArr3 = new int[i6];
            zzkf[] zzkfArr = new zzkf[i6];
            zzho[] zzhoArr = new zzho[i6];
            int i7 = this.zzbfm;
            int i8 = i5 - i7;
            System.arraycopy(jArr2, i7, jArr3, 0, i8);
            System.arraycopy(this.zzaom, this.zzbfm, jArr4, 0, i8);
            System.arraycopy(this.zzaxg, this.zzbfm, iArr2, 0, i8);
            System.arraycopy(this.zzaoj, this.zzbfm, iArr3, 0, i8);
            System.arraycopy(this.zzbfj, this.zzbfm, zzkfArr, 0, i8);
            System.arraycopy(this.zzbfk, this.zzbfm, zzhoArr, 0, i8);
            System.arraycopy(this.zzbfi, this.zzbfm, iArr, 0, i8);
            int i9 = this.zzbfm;
            System.arraycopy(this.zzaok, 0, jArr3, i8, i9);
            System.arraycopy(this.zzaom, 0, jArr4, i8, i9);
            System.arraycopy(this.zzaxg, 0, iArr2, i8, i9);
            System.arraycopy(this.zzaoj, 0, iArr3, i8, i9);
            System.arraycopy(this.zzbfj, 0, zzkfArr, i8, i9);
            System.arraycopy(this.zzbfk, 0, zzhoArr, i8, i9);
            System.arraycopy(this.zzbfi, 0, iArr, i8, i9);
            this.zzaok = jArr3;
            this.zzaom = jArr4;
            this.zzaxg = iArr2;
            this.zzaoj = iArr3;
            this.zzbfj = zzkfArr;
            this.zzbfk = zzhoArr;
            this.zzbfi = iArr;
            this.zzbfm = 0;
            int i10 = this.zzbfh;
            this.zzbfn = i10;
            this.length = i10;
            this.zzbfh = i6;
            return;
        }
        int i11 = i3 + 1;
        this.zzbfn = i11;
        if (i11 == i5) {
            this.zzbfn = 0;
        }
    }
}
