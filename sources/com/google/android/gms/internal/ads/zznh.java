package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
public final class zznh implements zzkg {
    private final zzpk zzapo = new zzpk(32);
    private final zzok zzbdi;
    private final int zzbfu;
    private final zznf zzbfv = new zznf();
    private final zzni zzbfw = new zzni();
    private final AtomicInteger zzbfx = new AtomicInteger();
    private zznk zzbfy;
    private zznk zzbfz;
    private zzho zzbga;
    private boolean zzbgb;
    private zzho zzbgc;
    private long zzbgd;
    private int zzbge;
    private zznj zzbgf;

    public zznh(zzok zzok) {
        this.zzbdi = zzok;
        int zzim = zzok.zzim();
        this.zzbfu = zzim;
        this.zzbge = zzim;
        zznk zznk = new zznk(0, zzim);
        this.zzbfy = zznk;
        this.zzbfz = zznk;
    }

    private final int zzbc(int i) {
        if (this.zzbge == this.zzbfu) {
            this.zzbge = 0;
            zznk zznk = this.zzbfz;
            if (zznk.zzbgi) {
                this.zzbfz = zznk.zzbgk;
            }
            zznk zznk2 = this.zzbfz;
            zzoh zzil = this.zzbdi.zzil();
            zznk zznk3 = new zznk(this.zzbfz.zzawf, this.zzbfu);
            zznk2.zzbgj = zzil;
            zznk2.zzbgk = zznk3;
            zznk2.zzbgi = true;
        }
        return Math.min(i, this.zzbfu - this.zzbge);
    }

    private final void zzej(long j) {
        while (true) {
            zznk zznk = this.zzbfy;
            if (j >= zznk.zzawf) {
                this.zzbdi.zza(zznk.zzbgj);
                this.zzbfy = this.zzbfy.zzii();
            } else {
                return;
            }
        }
    }

    private final void zzhz() {
        this.zzbfv.zzhz();
        zznk zznk = this.zzbfy;
        if (zznk.zzbgi) {
            zznk zznk2 = this.zzbfz;
            int i = (((int) (zznk2.zzbgh - zznk.zzbgh)) / this.zzbfu) + (zznk2.zzbgi ? 1 : 0);
            zzoh[] zzohArr = new zzoh[i];
            for (int i2 = 0; i2 < i; i2++) {
                zzohArr[i2] = zznk.zzbgj;
                zznk = zznk.zzii();
            }
            this.zzbdi.zza(zzohArr);
        }
        zznk zznk3 = new zznk(0, this.zzbfu);
        this.zzbfy = zznk3;
        this.zzbfz = zznk3;
        this.zzbgd = 0;
        this.zzbge = this.zzbfu;
        this.zzbdi.zzn();
    }

    private final boolean zzig() {
        return this.zzbfx.compareAndSet(0, 1);
    }

    private final void zzih() {
        if (!this.zzbfx.compareAndSet(1, 0)) {
            zzhz();
        }
    }

    public final void disable() {
        if (this.zzbfx.getAndSet(2) == 0) {
            zzhz();
        }
    }

    public final int zza(zzhq zzhq, zzjk zzjk, boolean z, boolean z2, long j) {
        int i;
        int zza = this.zzbfv.zza(zzhq, zzjk, z, z2, this.zzbga, this.zzbfw);
        if (zza == -5) {
            this.zzbga = zzhq.zzaht;
            return -5;
        } else if (zza == -4) {
            if (!zzjk.zzgj()) {
                if (zzjk.zzanx < j) {
                    zzjk.zzac(Integer.MIN_VALUE);
                }
                if (zzjk.isEncrypted()) {
                    zzni zzni = this.zzbfw;
                    long j2 = zzni.zzawj;
                    this.zzapo.reset(1);
                    zza(j2, this.zzapo.data, 1);
                    long j3 = j2 + 1;
                    byte b = this.zzapo.data[0];
                    boolean z3 = (b & 128) != 0;
                    int i2 = b & Byte.MAX_VALUE;
                    zzjg zzjg = zzjk.zzanw;
                    if (zzjg.iv == null) {
                        zzjg.iv = new byte[16];
                    }
                    zza(j3, zzjg.iv, i2);
                    long j4 = j3 + ((long) i2);
                    if (z3) {
                        this.zzapo.reset(2);
                        zza(j4, this.zzapo.data, 2);
                        j4 += 2;
                        i = this.zzapo.readUnsignedShort();
                    } else {
                        i = 1;
                    }
                    zzjg zzjg2 = zzjk.zzanw;
                    int[] iArr = zzjg2.numBytesOfClearData;
                    if (iArr == null || iArr.length < i) {
                        iArr = new int[i];
                    }
                    int[] iArr2 = zzjg2.numBytesOfEncryptedData;
                    if (iArr2 == null || iArr2.length < i) {
                        iArr2 = new int[i];
                    }
                    if (z3) {
                        int i3 = i * 6;
                        this.zzapo.reset(i3);
                        zza(j4, this.zzapo.data, i3);
                        j4 += (long) i3;
                        this.zzapo.zzbo(0);
                        for (int i4 = 0; i4 < i; i4++) {
                            iArr[i4] = this.zzapo.readUnsignedShort();
                            iArr2[i4] = this.zzapo.zzjd();
                        }
                    } else {
                        iArr[0] = 0;
                        iArr2[0] = zzni.size - ((int) (j4 - zzni.zzawj));
                    }
                    zzkf zzkf = zzni.zzarm;
                    zzjg zzjg3 = zzjk.zzanw;
                    zzjg3.set(i, iArr, iArr2, zzkf.zzaow, zzjg3.iv, zzkf.zzaov);
                    long j5 = zzni.zzawj;
                    int i5 = (int) (j4 - j5);
                    zzni.zzawj = j5 + ((long) i5);
                    zzni.size -= i5;
                }
                zzjk.zzae(this.zzbfw.size);
                zzni zzni2 = this.zzbfw;
                long j6 = zzni2.zzawj;
                ByteBuffer byteBuffer = zzjk.zzdd;
                int i6 = zzni2.size;
                zzej(j6);
                while (i6 > 0) {
                    int i7 = (int) (j6 - this.zzbfy.zzbgh);
                    int min = Math.min(i6, this.zzbfu - i7);
                    zzoh zzoh = this.zzbfy.zzbgj;
                    byteBuffer.put(zzoh.data, zzoh.zzbh(i7), min);
                    j6 += (long) min;
                    i6 -= min;
                    if (j6 == this.zzbfy.zzawf) {
                        this.zzbdi.zza(zzoh);
                        this.zzbfy = this.zzbfy.zzii();
                    }
                }
                zzej(this.zzbfw.zzbgg);
            }
            return -4;
        } else if (zza == -3) {
            return -3;
        } else {
            throw new IllegalStateException();
        }
    }

    public final boolean zze(long j, boolean z) {
        long zzd = this.zzbfv.zzd(j, z);
        if (zzd == -1) {
            return false;
        }
        zzej(zzd);
        return true;
    }

    public final long zzht() {
        return this.zzbfv.zzht();
    }

    public final int zzib() {
        return this.zzbfv.zzib();
    }

    public final boolean zzic() {
        return this.zzbfv.zzic();
    }

    public final zzho zzid() {
        return this.zzbfv.zzid();
    }

    public final void zzif() {
        long zzie = this.zzbfv.zzie();
        if (zzie != -1) {
            zzej(zzie);
        }
    }

    public final void zzk(boolean z) {
        int andSet = this.zzbfx.getAndSet(z ? 0 : 2);
        zzhz();
        this.zzbfv.zzia();
        if (andSet == 2) {
            this.zzbga = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkg
    public final void zze(zzho zzho) {
        zzho zzho2 = zzho == null ? null : zzho;
        boolean zzg = this.zzbfv.zzg(zzho2);
        this.zzbgc = zzho;
        this.zzbgb = false;
        zznj zznj = this.zzbgf;
        if (zznj != null && zzg) {
            zznj.zzf(zzho2);
        }
    }

    private final void zza(long j, byte[] bArr, int i) {
        zzej(j);
        int i2 = 0;
        while (i2 < i) {
            int i3 = (int) (j - this.zzbfy.zzbgh);
            int min = Math.min(i - i2, this.zzbfu - i3);
            zzoh zzoh = this.zzbfy.zzbgj;
            System.arraycopy(zzoh.data, zzoh.zzbh(i3), bArr, i2, min);
            j += (long) min;
            i2 += min;
            if (j == this.zzbfy.zzawf) {
                this.zzbdi.zza(zzoh);
                this.zzbfy = this.zzbfy.zzii();
            }
        }
    }

    public final void zza(zznj zznj) {
        this.zzbgf = zznj;
    }

    @Override // com.google.android.gms.internal.ads.zzkg
    public final int zza(zzjy zzjy, int i, boolean z) throws IOException, InterruptedException {
        if (!zzig()) {
            int zzah = zzjy.zzah(i);
            if (zzah != -1) {
                return zzah;
            }
            throw new EOFException();
        }
        try {
            int zzbc = zzbc(i);
            zzoh zzoh = this.zzbfz.zzbgj;
            int read = zzjy.read(zzoh.data, zzoh.zzbh(this.zzbge), zzbc);
            if (read != -1) {
                this.zzbge += read;
                this.zzbgd += (long) read;
                return read;
            }
            throw new EOFException();
        } finally {
            zzih();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkg
    public final void zza(zzpk zzpk, int i) {
        if (!zzig()) {
            zzpk.zzbp(i);
            return;
        }
        while (i > 0) {
            int zzbc = zzbc(i);
            zzoh zzoh = this.zzbfz.zzbgj;
            zzpk.zze(zzoh.data, zzoh.zzbh(this.zzbge), zzbc);
            this.zzbge += zzbc;
            this.zzbgd += (long) zzbc;
            i -= zzbc;
        }
        zzih();
    }

    @Override // com.google.android.gms.internal.ads.zzkg
    public final void zza(long j, int i, int i2, int i3, zzkf zzkf) {
        if (!zzig()) {
            this.zzbfv.zzei(j);
            return;
        }
        try {
            this.zzbfv.zza(j, i, (this.zzbgd - ((long) i2)) - ((long) i3), i2, zzkf);
        } finally {
            zzih();
        }
    }
}
