package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
public abstract class zzefz extends zzefc {
    private static final Logger logger = Logger.getLogger(zzefz.class.getName());
    private static final boolean zzicg = zzejt.zzbic();
    public zzegb zzich;

    public static class zza extends IOException {
        public zza() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        public zza(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public zza(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r0 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r1 = r3.length()
                if (r1 == 0) goto L_0x0011
                java.lang.String r3 = r0.concat(r3)
                goto L_0x0016
            L_0x0011:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r0)
            L_0x0016:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzefz.zza.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private zzefz() {
    }

    public static int zzaf(int i, int i2) {
        return zzgr(i2) + zzgq(i);
    }

    public static int zzag(int i, int i2) {
        return zzgs(i2) + zzgq(i);
    }

    public static int zzah(int i, int i2) {
        return zzgs(zzgx(i2)) + zzgq(i);
    }

    public static int zzai(int i, int i2) {
        return zzgq(i) + 4;
    }

    public static int zzaj(int i, int i2) {
        return zzgq(i) + 4;
    }

    public static int zzak(int i, int i2) {
        return zzgr(i2) + zzgq(i);
    }

    public static int zzbt(boolean z) {
        return 1;
    }

    public static int zzc(double d) {
        return 8;
    }

    public static int zzc(int i, double d) {
        return zzgq(i) + 8;
    }

    public static int zzd(int i, zzeff zzeff) {
        int zzag = zzag(2, i);
        return zzc(3, zzeff) + zzag + (zzgq(1) << 1);
    }

    public static int zzfl(long j) {
        return zzfm(j);
    }

    public static int zzfm(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static int zzfn(long j) {
        return zzfm(zzfq(j));
    }

    public static int zzfo(long j) {
        return 8;
    }

    public static int zzfp(long j) {
        return 8;
    }

    private static long zzfq(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzg(float f) {
        return 4;
    }

    public static int zzgq(int i) {
        return zzgs(i << 3);
    }

    public static int zzgr(int i) {
        if (i >= 0) {
            return zzgs(i);
        }
        return 10;
    }

    public static int zzgs(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzgt(int i) {
        return zzgs(zzgx(i));
    }

    public static int zzgu(int i) {
        return 4;
    }

    public static int zzgv(int i) {
        return 4;
    }

    public static int zzgw(int i) {
        return zzgr(i);
    }

    private static int zzgx(int i) {
        return (i >> 31) ^ (i << 1);
    }

    @Deprecated
    public static int zzgy(int i) {
        return zzgs(i);
    }

    public static int zzh(zzehz zzehz) {
        int zzbfl = zzehz.zzbfl();
        return zzgs(zzbfl) + zzbfl;
    }

    public static int zzhw(String str) {
        int i;
        try {
            i = zzejw.zza(str);
        } catch (zzejz unused) {
            i = str.getBytes(zzegr.UTF_8).length;
        }
        return zzgs(i) + i;
    }

    public static int zzj(int i, String str) {
        return zzhw(str) + zzgq(i);
    }

    public static int zzk(int i, long j) {
        return zzfm(j) + zzgq(i);
    }

    public static int zzl(int i, long j) {
        return zzfm(j) + zzgq(i);
    }

    public static int zzm(int i, long j) {
        return zzfm(zzfq(j)) + zzgq(i);
    }

    public static int zzn(int i, long j) {
        return zzgq(i) + 8;
    }

    public static int zzo(int i, long j) {
        return zzgq(i) + 8;
    }

    public static zzefz zzw(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    public static int zzx(byte[] bArr) {
        int length = bArr.length;
        return zzgs(length) + length;
    }

    public abstract void writeTag(int i, int i2) throws IOException;

    public final void zza(int i, float f) throws IOException {
        zzae(i, Float.floatToRawIntBits(f));
    }

    public abstract void zza(int i, zzeff zzeff) throws IOException;

    public abstract void zza(int i, zzehz zzehz) throws IOException;

    public abstract void zza(int i, zzehz zzehz, zzeiv zzeiv) throws IOException;

    public abstract void zzab(int i, int i2) throws IOException;

    public abstract void zzac(int i, int i2) throws IOException;

    public final void zzad(int i, int i2) throws IOException {
        zzac(i, zzgx(i2));
    }

    public abstract void zzae(int i, int i2) throws IOException;

    public abstract void zzah(zzeff zzeff) throws IOException;

    public final void zzb(int i, double d) throws IOException {
        zzj(i, Double.doubleToRawLongBits(d));
    }

    public abstract void zzb(int i, zzeff zzeff) throws IOException;

    public abstract int zzbet();

    public final void zzbeu() {
        if (zzbet() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzbs(boolean z) throws IOException {
        zzd(z ? (byte) 1 : 0);
    }

    public abstract void zzd(byte b) throws IOException;

    public final void zzf(float f) throws IOException {
        zzgp(Float.floatToRawIntBits(f));
    }

    public abstract void zzfi(long j) throws IOException;

    public final void zzfj(long j) throws IOException {
        zzfi(zzfq(j));
    }

    public abstract void zzfk(long j) throws IOException;

    public abstract void zzg(zzehz zzehz) throws IOException;

    public abstract void zzgm(int i) throws IOException;

    public abstract void zzgn(int i) throws IOException;

    public final void zzgo(int i) throws IOException {
        zzgn(zzgx(i));
    }

    public abstract void zzgp(int i) throws IOException;

    public abstract void zzh(int i, long j) throws IOException;

    public abstract void zzh(int i, boolean z) throws IOException;

    public abstract void zzhv(String str) throws IOException;

    public final void zzi(int i, long j) throws IOException {
        zzh(i, zzfq(j));
    }

    public abstract void zzi(int i, String str) throws IOException;

    public abstract void zzj(int i, long j) throws IOException;

    public abstract void zzk(byte[] bArr, int i, int i2) throws IOException;

    public static class zzb extends zzefz {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        public zzb(byte[] bArr, int i, int i2) {
            super();
            Objects.requireNonNull(bArr, "buffer");
            int i3 = i2 + 0;
            if ((i2 | 0 | (bArr.length - i3)) >= 0) {
                this.buffer = bArr;
                this.offset = 0;
                this.position = 0;
                this.limit = i3;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)));
        }

        private final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzefz
        public final void writeTag(int i, int i2) throws IOException {
            zzgn((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.ads.zzefz
        public final void zza(int i, zzeff zzeff) throws IOException {
            writeTag(i, 2);
            zzah(zzeff);
        }

        @Override // com.google.android.gms.internal.ads.zzefz
        public final void zzab(int i, int i2) throws IOException {
            writeTag(i, 0);
            zzgm(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzefz
        public final void zzac(int i, int i2) throws IOException {
            writeTag(i, 0);
            zzgn(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzefz
        public final void zzae(int i, int i2) throws IOException {
            writeTag(i, 5);
            zzgp(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzefz
        public final void zzah(zzeff zzeff) throws IOException {
            zzgn(zzeff.size());
            zzeff.zza(this);
        }

        @Override // com.google.android.gms.internal.ads.zzefz
        public final void zzb(int i, zzeff zzeff) throws IOException {
            writeTag(1, 3);
            zzac(2, i);
            zza(3, zzeff);
            writeTag(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzefz
        public final int zzbet() {
            return this.limit - this.position;
        }

        @Override // com.google.android.gms.internal.ads.zzefz
        public final void zzd(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzefz
        public final void zzfi(long j) throws IOException {
            if (!zzefz.zzicg || zzbet() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i = this.position;
                    this.position = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    zzejt.zza(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzejt.zza(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        @Override // com.google.android.gms.internal.ads.zzefz
        public final void zzfk(long j) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                int i2 = i + 1;
                this.position = i2;
                bArr[i] = (byte) ((int) j);
                int i3 = i2 + 1;
                this.position = i3;
                bArr[i2] = (byte) ((int) (j >> 8));
                int i4 = i3 + 1;
                this.position = i4;
                bArr[i3] = (byte) ((int) (j >> 16));
                int i5 = i4 + 1;
                this.position = i5;
                bArr[i4] = (byte) ((int) (j >> 24));
                int i6 = i5 + 1;
                this.position = i6;
                bArr[i5] = (byte) ((int) (j >> 32));
                int i7 = i6 + 1;
                this.position = i7;
                bArr[i6] = (byte) ((int) (j >> 40));
                int i8 = i7 + 1;
                this.position = i8;
                bArr[i7] = (byte) ((int) (j >> 48));
                this.position = i8 + 1;
                bArr[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzefz
        public final void zzg(zzehz zzehz) throws IOException {
            zzgn(zzehz.zzbfl());
            zzehz.zzb(this);
        }

        @Override // com.google.android.gms.internal.ads.zzefz
        public final void zzgm(int i) throws IOException {
            if (i >= 0) {
                zzgn(i);
            } else {
                zzfi((long) i);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzefz
        public final void zzgn(int i) throws IOException {
            if (!zzefz.zzicg || zzeey.zzbdd() || zzbet() < 5) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
                }
            } else if ((i & -128) == 0) {
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzejt.zza(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                zzejt.zza(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i7 = this.position;
                    this.position = i7 + 1;
                    zzejt.zza(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                zzejt.zza(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i10 = this.position;
                    this.position = i10 + 1;
                    zzejt.zza(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                zzejt.zza(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.buffer;
                    int i13 = this.position;
                    this.position = i13 + 1;
                    zzejt.zza(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                zzejt.zza(bArr10, (long) i14, (byte) (i12 | 128));
                byte[] bArr11 = this.buffer;
                int i15 = this.position;
                this.position = i15 + 1;
                zzejt.zza(bArr11, (long) i15, (byte) (i12 >>> 7));
            }
        }

        @Override // com.google.android.gms.internal.ads.zzefz
        public final void zzgp(int i) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                int i3 = i2 + 1;
                this.position = i3;
                bArr[i2] = (byte) i;
                int i4 = i3 + 1;
                this.position = i4;
                bArr[i3] = (byte) (i >> 8);
                int i5 = i4 + 1;
                this.position = i5;
                bArr[i4] = (byte) (i >> 16);
                this.position = i5 + 1;
                bArr[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzefz
        public final void zzh(int i, long j) throws IOException {
            writeTag(i, 0);
            zzfi(j);
        }

        @Override // com.google.android.gms.internal.ads.zzefz
        public final void zzhv(String str) throws IOException {
            int i = this.position;
            try {
                int zzgs = zzefz.zzgs(str.length() * 3);
                int zzgs2 = zzefz.zzgs(str.length());
                if (zzgs2 == zzgs) {
                    int i2 = i + zzgs2;
                    this.position = i2;
                    int zza = zzejw.zza(str, this.buffer, i2, zzbet());
                    this.position = i;
                    zzgn((zza - i) - zzgs2);
                    this.position = zza;
                    return;
                }
                zzgn(zzejw.zza(str));
                this.position = zzejw.zza(str, this.buffer, this.position, zzbet());
            } catch (zzejz e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzefz
        public final void zzi(int i, String str) throws IOException {
            writeTag(i, 2);
            zzhv(str);
        }

        @Override // com.google.android.gms.internal.ads.zzefz
        public final void zzj(int i, long j) throws IOException {
            writeTag(i, 1);
            zzfk(j);
        }

        @Override // com.google.android.gms.internal.ads.zzefz
        public final void zzk(byte[] bArr, int i, int i2) throws IOException {
            zzgn(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzefz
        public final void zza(int i, zzehz zzehz, zzeiv zzeiv) throws IOException {
            writeTag(i, 2);
            zzeev zzeev = (zzeev) zzehz;
            int zzbdb = zzeev.zzbdb();
            if (zzbdb == -1) {
                zzbdb = zzeiv.zzat(zzeev);
                zzeev.zzfq(zzbdb);
            }
            zzgn(zzbdb);
            zzeiv.zza(zzehz, this.zzich);
        }

        @Override // com.google.android.gms.internal.ads.zzefz
        public final void zzh(int i, boolean z) throws IOException {
            writeTag(i, 0);
            zzd(z ? (byte) 1 : 0);
        }

        @Override // com.google.android.gms.internal.ads.zzefc
        public final void zzh(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzefz
        public final void zza(int i, zzehz zzehz) throws IOException {
            writeTag(1, 3);
            zzac(2, i);
            writeTag(3, 2);
            zzg(zzehz);
            writeTag(1, 4);
        }
    }

    public static int zza(int i, zzehi zzehi) {
        int zzgq = zzgq(i);
        int zzbfl = zzehi.zzbfl();
        return zzgs(zzbfl) + zzbfl + zzgq;
    }

    public static int zzai(zzeff zzeff) {
        int size = zzeff.size();
        return zzgs(size) + size;
    }

    public static int zzc(int i, zzeff zzeff) {
        int zzgq = zzgq(i);
        int size = zzeff.size();
        return zzgs(size) + size + zzgq;
    }

    public static int zzi(int i, boolean z) {
        return zzgq(i) + 1;
    }

    public final void zzb(double d) throws IOException {
        zzfk(Double.doubleToRawLongBits(d));
    }

    public static int zzb(int i, float f) {
        return zzgq(i) + 4;
    }

    @Deprecated
    public static int zzi(zzehz zzehz) {
        return zzehz.zzbfl();
    }

    public static int zzb(int i, zzehz zzehz, zzeiv zzeiv) {
        return zza(zzehz, zzeiv) + zzgq(i);
    }

    public static int zza(zzehi zzehi) {
        int zzbfl = zzehi.zzbfl();
        return zzgs(zzbfl) + zzbfl;
    }

    public static int zzb(int i, zzehz zzehz) {
        return zzh(zzehz) + zzgq(3) + zzag(2, i) + (zzgq(1) << 1);
    }

    @Deprecated
    public static int zzc(int i, zzehz zzehz, zzeiv zzeiv) {
        int zzgq = zzgq(i) << 1;
        zzeev zzeev = (zzeev) zzehz;
        int zzbdb = zzeev.zzbdb();
        if (zzbdb == -1) {
            zzbdb = zzeiv.zzat(zzeev);
            zzeev.zzfq(zzbdb);
        }
        return zzgq + zzbdb;
    }

    public static int zza(zzehz zzehz, zzeiv zzeiv) {
        zzeev zzeev = (zzeev) zzehz;
        int zzbdb = zzeev.zzbdb();
        if (zzbdb == -1) {
            zzbdb = zzeiv.zzat(zzeev);
            zzeev.zzfq(zzbdb);
        }
        return zzgs(zzbdb) + zzbdb;
    }

    public static int zzb(int i, zzehi zzehi) {
        int zzag = zzag(2, i);
        return zza(3, zzehi) + zzag + (zzgq(1) << 1);
    }

    public final void zza(String str, zzejz zzejz) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzejz);
        byte[] bytes = str.getBytes(zzegr.UTF_8);
        try {
            zzgn(bytes.length);
            zzh(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zza(e);
        } catch (zza e2) {
            throw e2;
        }
    }
}
