package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
public final class zzefv extends zzefq {
    private final byte[] buffer;
    private int pos;
    private int zzajz;
    private int zzibv;
    private int zzibx;
    private int zziby;
    private final InputStream zzibz;
    private int zzica;
    private zzefu zzicb;

    private zzefv(InputStream inputStream, int i) {
        super();
        this.zziby = Integer.MAX_VALUE;
        this.zzicb = null;
        zzegr.zza(inputStream, "input");
        this.zzibz = inputStream;
        this.buffer = new byte[i];
        this.zzajz = 0;
        this.pos = 0;
        this.zzica = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r2[r3] >= 0) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzbel() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.pos
            int r1 = r5.zzajz
            if (r1 == r0) goto L_0x006b
            byte[] r2 = r5.buffer
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0011
            r5.pos = r3
            return r0
        L_0x0011:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x006b
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0022
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0068
        L_0x0022:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x002f
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002d:
            r1 = r3
            goto L_0x0068
        L_0x002f:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003d
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0068
        L_0x003d:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0068
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0068
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 < 0) goto L_0x006b
        L_0x0068:
            r5.pos = r1
            return r0
        L_0x006b:
            long r0 = r5.zzbei()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzefv.zzbel():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b0, code lost:
        if (((long) r2[r0]) >= 0) goto L_0x00b4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zzbem() throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 189
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzefv.zzbem():long");
    }

    private final int zzben() throws IOException {
        int i = this.pos;
        if (this.zzajz - i < 4) {
            zzge(4);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long zzbeo() throws IOException {
        int i = this.pos;
        if (this.zzajz - i < 8) {
            zzge(8);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    private final void zzbep() {
        int i = this.zzajz + this.zzibv;
        this.zzajz = i;
        int i2 = this.zzica + i;
        int i3 = this.zziby;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzibv = i4;
            this.zzajz = i - i4;
            return;
        }
        this.zzibv = 0;
    }

    private final byte zzbeq() throws IOException {
        if (this.pos == this.zzajz) {
            zzge(1);
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    private final byte[] zzg(int i, boolean z) throws IOException {
        byte[] zzgg = zzgg(i);
        if (zzgg != null) {
            return zzgg;
        }
        int i2 = this.pos;
        int i3 = this.zzajz;
        int i4 = i3 - i2;
        this.zzica += i3;
        this.pos = 0;
        this.zzajz = 0;
        List<byte[]> zzgh = zzgh(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.buffer, i2, bArr, 0, i4);
        for (byte[] bArr2 : zzgh) {
            System.arraycopy(bArr2, 0, bArr, i4, bArr2.length);
            i4 += bArr2.length;
        }
        return bArr;
    }

    private final void zzgd(int i) throws IOException {
        int i2 = this.zzajz;
        int i3 = this.pos;
        if (i <= i2 - i3 && i >= 0) {
            this.pos = i3 + i;
        } else if (i >= 0) {
            int i4 = this.zzica;
            int i5 = i4 + i3 + i;
            int i6 = this.zziby;
            if (i5 <= i6) {
                this.zzica = i4 + i3;
                int i7 = i2 - i3;
                this.zzajz = 0;
                this.pos = 0;
                while (i7 < i) {
                    try {
                        long j = (long) (i - i7);
                        long skip = this.zzibz.skip(j);
                        int i8 = (skip > 0 ? 1 : (skip == 0 ? 0 : -1));
                        if (i8 >= 0 && skip <= j) {
                            if (i8 == 0) {
                                break;
                            }
                            i7 += (int) skip;
                        } else {
                            String valueOf = String.valueOf(this.zzibz.getClass());
                            StringBuilder sb = new StringBuilder(valueOf.length() + 92);
                            sb.append(valueOf);
                            sb.append("#skip returned invalid result: ");
                            sb.append(skip);
                            sb.append("\nThe InputStream implementation is buggy.");
                            throw new IllegalStateException(sb.toString());
                        }
                    } catch (Throwable th) {
                        this.zzica += i7;
                        zzbep();
                        throw th;
                    }
                }
                this.zzica += i7;
                zzbep();
                if (i7 < i) {
                    int i9 = this.zzajz;
                    int i10 = i9 - this.pos;
                    this.pos = i9;
                    zzge(1);
                    while (true) {
                        int i11 = i - i10;
                        int i12 = this.zzajz;
                        if (i11 > i12) {
                            i10 += i12;
                            this.pos = i12;
                            zzge(1);
                        } else {
                            this.pos = i11;
                            return;
                        }
                    }
                }
            } else {
                zzgd((i6 - i4) - i3);
                throw zzegz.zzbgb();
            }
        } else {
            throw zzegz.zzbgc();
        }
    }

    private final void zzge(int i) throws IOException {
        if (zzgf(i)) {
            return;
        }
        if (i > (this.zzibr - this.zzica) - this.pos) {
            throw zzegz.zzbgh();
        }
        throw zzegz.zzbgb();
    }

    private final boolean zzgf(int i) throws IOException {
        do {
            int i2 = this.pos;
            int i3 = i2 + i;
            int i4 = this.zzajz;
            if (i3 > i4) {
                int i5 = this.zzibr;
                int i6 = this.zzica;
                if (i > (i5 - i6) - i2 || i6 + i2 + i > this.zziby) {
                    return false;
                }
                if (i2 > 0) {
                    if (i4 > i2) {
                        byte[] bArr = this.buffer;
                        System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
                    }
                    this.zzica += i2;
                    this.zzajz -= i2;
                    this.pos = 0;
                }
                InputStream inputStream = this.zzibz;
                byte[] bArr2 = this.buffer;
                int i7 = this.zzajz;
                int read = inputStream.read(bArr2, i7, Math.min(bArr2.length - i7, (this.zzibr - this.zzica) - i7));
                if (read == 0 || read < -1 || read > this.buffer.length) {
                    String valueOf = String.valueOf(this.zzibz.getClass());
                    StringBuilder sb = new StringBuilder(valueOf.length() + 91);
                    sb.append(valueOf);
                    sb.append("#read(byte[]) returned invalid result: ");
                    sb.append(read);
                    sb.append("\nThe InputStream implementation is buggy.");
                    throw new IllegalStateException(sb.toString());
                } else if (read <= 0) {
                    return false;
                } else {
                    this.zzajz += read;
                    zzbep();
                }
            } else {
                throw new IllegalStateException(a.o2(77, "refillBuffer() called when ", i, " bytes were already available in buffer"));
            }
        } while (this.zzajz < i);
        return true;
    }

    private final byte[] zzgg(int i) throws IOException {
        if (i == 0) {
            return zzegr.zzibj;
        }
        if (i >= 0) {
            int i2 = this.zzica;
            int i3 = this.pos;
            int i4 = i2 + i3 + i;
            if (i4 - this.zzibr <= 0) {
                int i5 = this.zziby;
                if (i4 <= i5) {
                    int i6 = this.zzajz - i3;
                    int i7 = i - i6;
                    if (i7 >= 4096 && i7 > this.zzibz.available()) {
                        return null;
                    }
                    byte[] bArr = new byte[i];
                    System.arraycopy(this.buffer, this.pos, bArr, 0, i6);
                    this.zzica += this.zzajz;
                    this.pos = 0;
                    this.zzajz = 0;
                    while (i6 < i) {
                        int read = this.zzibz.read(bArr, i6, i - i6);
                        if (read != -1) {
                            this.zzica += read;
                            i6 += read;
                        } else {
                            throw zzegz.zzbgb();
                        }
                    }
                    return bArr;
                }
                zzgd((i5 - i2) - i3);
                throw zzegz.zzbgb();
            }
            throw zzegz.zzbgh();
        }
        throw zzegz.zzbgc();
    }

    private final List<byte[]> zzgh(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int min = Math.min(i, 4096);
            byte[] bArr = new byte[min];
            int i2 = 0;
            while (i2 < min) {
                int read = this.zzibz.read(bArr, i2, min - i2);
                if (read != -1) {
                    this.zzica += read;
                    i2 += read;
                } else {
                    throw zzegz.zzbgb();
                }
            }
            i -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzbeo());
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzben());
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    public final String readString() throws IOException {
        int zzbel = zzbel();
        if (zzbel > 0 && zzbel <= this.zzajz - this.pos) {
            String str = new String(this.buffer, this.pos, zzbel, zzegr.UTF_8);
            this.pos += zzbel;
            return str;
        } else if (zzbel == 0) {
            return "";
        } else {
            if (zzbel > this.zzajz) {
                return new String(zzg(zzbel, false), zzegr.UTF_8);
            }
            zzge(zzbel);
            String str2 = new String(this.buffer, this.pos, zzbel, zzegr.UTF_8);
            this.pos += zzbel;
            return str2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    public final int zzbdt() throws IOException {
        if (zzbej()) {
            this.zzibx = 0;
            return 0;
        }
        int zzbel = zzbel();
        this.zzibx = zzbel;
        if ((zzbel >>> 3) != 0) {
            return zzbel;
        }
        throw zzegz.zzbge();
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    public final long zzbdu() throws IOException {
        return zzbem();
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    public final long zzbdv() throws IOException {
        return zzbem();
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    public final int zzbdw() throws IOException {
        return zzbel();
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    public final long zzbdx() throws IOException {
        return zzbeo();
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    public final int zzbdy() throws IOException {
        return zzben();
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    public final boolean zzbdz() throws IOException {
        return zzbem() != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    public final String zzbea() throws IOException {
        byte[] bArr;
        int zzbel = zzbel();
        int i = this.pos;
        int i2 = this.zzajz;
        if (zzbel <= i2 - i && zzbel > 0) {
            bArr = this.buffer;
            this.pos = i + zzbel;
        } else if (zzbel == 0) {
            return "";
        } else {
            if (zzbel <= i2) {
                zzge(zzbel);
                bArr = this.buffer;
                this.pos = zzbel;
            } else {
                bArr = zzg(zzbel, false);
            }
            i = 0;
        }
        return zzejw.zzo(bArr, i, zzbel);
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    public final zzeff zzbeb() throws IOException {
        int zzbel = zzbel();
        int i = this.zzajz;
        int i2 = this.pos;
        if (zzbel <= i - i2 && zzbel > 0) {
            zzeff zzi = zzeff.zzi(this.buffer, i2, zzbel);
            this.pos += zzbel;
            return zzi;
        } else if (zzbel == 0) {
            return zzeff.zzibd;
        } else {
            byte[] zzgg = zzgg(zzbel);
            if (zzgg != null) {
                return zzeff.zzu(zzgg);
            }
            int i3 = this.pos;
            int i4 = this.zzajz;
            int i5 = i4 - i3;
            this.zzica += i4;
            this.pos = 0;
            this.zzajz = 0;
            List<byte[]> zzgh = zzgh(zzbel - i5);
            byte[] bArr = new byte[zzbel];
            System.arraycopy(this.buffer, i3, bArr, 0, i5);
            for (byte[] bArr2 : zzgh) {
                System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
                i5 += bArr2.length;
            }
            return zzeff.zzv(bArr);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    public final int zzbec() throws IOException {
        return zzbel();
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    public final int zzbed() throws IOException {
        return zzbel();
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    public final int zzbee() throws IOException {
        return zzben();
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    public final long zzbef() throws IOException {
        return zzbeo();
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    public final int zzbeg() throws IOException {
        return zzefq.zzgc(zzbel());
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    public final long zzbeh() throws IOException {
        return zzefq.zzfh(zzbem());
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    public final long zzbei() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzbeq = zzbeq();
            j |= ((long) (zzbeq & Byte.MAX_VALUE)) << i;
            if ((zzbeq & 128) == 0) {
                return j;
            }
        }
        throw zzegz.zzbgd();
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    public final boolean zzbej() throws IOException {
        return this.pos == this.zzajz && !zzgf(1);
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    public final int zzbek() {
        return this.zzica + this.pos;
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    public final void zzfy(int i) throws zzegz {
        if (this.zzibx != i) {
            throw zzegz.zzbgf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    public final boolean zzfz(int i) throws IOException {
        int zzbdt;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzajz - this.pos >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.buffer;
                    int i4 = this.pos;
                    this.pos = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzegz.zzbgd();
            }
            while (i3 < 10) {
                if (zzbeq() < 0) {
                    i3++;
                }
            }
            throw zzegz.zzbgd();
            return true;
        } else if (i2 == 1) {
            zzgd(8);
            return true;
        } else if (i2 == 2) {
            zzgd(zzbel());
            return true;
        } else if (i2 == 3) {
            do {
                zzbdt = zzbdt();
                if (zzbdt == 0) {
                    break;
                }
            } while (zzfz(zzbdt));
            zzfy(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzgd(4);
                return true;
            }
            throw zzegz.zzbgg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    public final int zzga(int i) throws zzegz {
        if (i >= 0) {
            int i2 = this.zzica + this.pos + i;
            int i3 = this.zziby;
            if (i2 <= i3) {
                this.zziby = i2;
                zzbep();
                return i3;
            }
            throw zzegz.zzbgb();
        }
        throw zzegz.zzbgc();
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    public final void zzgb(int i) {
        this.zziby = i;
        zzbep();
    }
}
