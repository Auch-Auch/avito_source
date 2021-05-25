package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.internal.ads.zzmc;
import java.util.ArrayList;
public final class zzkw {
    private static final int zzavp = zzpq.zzbl("meta");
    private static final int zzawp = zzpq.zzbl("vide");
    private static final int zzawq = zzpq.zzbl("soun");
    private static final int zzawr = zzpq.zzbl("text");
    private static final int zzaws = zzpq.zzbl("sbtl");
    private static final int zzawt = zzpq.zzbl("subt");
    private static final int zzawu = zzpq.zzbl("clcp");
    private static final int zzawv = zzpq.zzbl(C.CENC_TYPE_cenc);

    /* JADX WARNING: Removed duplicated region for block: B:192:0x0392  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x039c  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x03a4  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x03a7  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x03fb  */
    /* JADX WARNING: Removed duplicated region for block: B:407:0x0825 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:408:0x0826  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01b6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzln zza(com.google.android.gms.internal.ads.zzku r49, com.google.android.gms.internal.ads.zzkt r50, long r51, com.google.android.gms.internal.ads.zzjn r53, boolean r54) throws com.google.android.gms.internal.ads.zzhv {
        /*
        // Method dump skipped, instructions count: 2143
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkw.zza(com.google.android.gms.internal.ads.zzku, com.google.android.gms.internal.ads.zzkt, long, com.google.android.gms.internal.ads.zzjn, boolean):com.google.android.gms.internal.ads.zzln");
    }

    private static Pair<String, byte[]> zzb(zzpk zzpk, int i) {
        zzpk.zzbo(i + 8 + 4);
        zzpk.zzbp(1);
        zzc(zzpk);
        zzpk.zzbp(2);
        int readUnsignedByte = zzpk.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            zzpk.zzbp(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            zzpk.zzbp(zzpk.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            zzpk.zzbp(2);
        }
        zzpk.zzbp(1);
        zzc(zzpk);
        int readUnsignedByte2 = zzpk.readUnsignedByte();
        String str = null;
        if (readUnsignedByte2 == 32) {
            str = MimeTypes.VIDEO_MP4V;
        } else if (readUnsignedByte2 == 33) {
            str = MimeTypes.VIDEO_H264;
        } else if (readUnsignedByte2 != 35) {
            if (readUnsignedByte2 != 64) {
                if (readUnsignedByte2 == 107) {
                    return Pair.create(MimeTypes.AUDIO_MPEG, null);
                }
                if (readUnsignedByte2 == 165) {
                    str = MimeTypes.AUDIO_AC3;
                } else if (readUnsignedByte2 != 166) {
                    switch (readUnsignedByte2) {
                        case 102:
                        case 103:
                        case 104:
                            break;
                        default:
                            switch (readUnsignedByte2) {
                                case 169:
                                case 172:
                                    return Pair.create(MimeTypes.AUDIO_DTS, null);
                                case 170:
                                case 171:
                                    return Pair.create(MimeTypes.AUDIO_DTS_HD, null);
                            }
                    }
                } else {
                    str = MimeTypes.AUDIO_E_AC3;
                }
            }
            str = MimeTypes.AUDIO_AAC;
        } else {
            str = MimeTypes.VIDEO_H265;
        }
        zzpk.zzbp(12);
        zzpk.zzbp(1);
        int zzc = zzc(zzpk);
        byte[] bArr = new byte[zzc];
        zzpk.zze(bArr, 0, zzc);
        return Pair.create(str, bArr);
    }

    private static int zzc(zzpk zzpk) {
        int readUnsignedByte = zzpk.readUnsignedByte();
        int i = readUnsignedByte & 127;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = zzpk.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & 127);
        }
        return i;
    }

    public static zzls zza(zzln zzln, zzku zzku, zzjz zzjz) throws zzhv {
        zzky zzky;
        boolean z;
        int i;
        int i2;
        long j;
        int i3;
        int[] iArr;
        int i4;
        long[] jArr;
        int[] iArr2;
        long[] jArr2;
        long j2;
        long[] jArr3;
        boolean z2;
        long[] jArr4;
        int[] iArr3;
        int[] iArr4;
        int[] iArr5;
        int i5;
        int i6;
        int i7;
        zzln zzln2 = zzln;
        zzkt zzau = zzku.zzau(zzkr.zzave);
        if (zzau != null) {
            zzky = new zzla(zzau);
        } else {
            zzkt zzau2 = zzku.zzau(zzkr.zzavf);
            if (zzau2 != null) {
                zzky = new zzkz(zzau2);
            } else {
                throw new zzhv("Track has no sample table size information");
            }
        }
        int zzgw = zzky.zzgw();
        if (zzgw == 0) {
            return new zzls(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        zzkt zzau3 = zzku.zzau(zzkr.zzavg);
        if (zzau3 == null) {
            zzau3 = zzku.zzau(zzkr.zzavh);
            z = true;
        } else {
            z = false;
        }
        zzpk zzpk = zzau3.zzawe;
        zzpk zzpk2 = zzku.zzau(zzkr.zzavd).zzawe;
        zzpk zzpk3 = zzku.zzau(zzkr.zzava).zzawe;
        zzkt zzau4 = zzku.zzau(zzkr.zzavb);
        zzpk zzpk4 = null;
        zzpk zzpk5 = zzau4 != null ? zzau4.zzawe : null;
        zzkt zzau5 = zzku.zzau(zzkr.zzavc);
        zzpk zzpk6 = zzau5 != null ? zzau5.zzawe : null;
        zzkv zzkv = new zzkv(zzpk2, zzpk, z);
        zzpk3.zzbo(12);
        int zzjd = zzpk3.zzjd() - 1;
        int zzjd2 = zzpk3.zzjd();
        int zzjd3 = zzpk3.zzjd();
        if (zzpk6 != null) {
            zzpk6.zzbo(12);
            i = zzpk6.zzjd();
        } else {
            i = 0;
        }
        int i8 = -1;
        if (zzpk5 != null) {
            zzpk5.zzbo(12);
            i2 = zzpk5.zzjd();
            if (i2 > 0) {
                i8 = zzpk5.zzjd() - 1;
                zzpk4 = zzpk5;
            }
        } else {
            zzpk4 = zzpk5;
            i2 = 0;
        }
        long j3 = 0;
        if (!(zzky.zzgy() && MimeTypes.AUDIO_RAW.equals(zzln2.zzaht.zzagy) && zzjd == 0 && i == 0 && i2 == 0)) {
            long[] jArr5 = new long[zzgw];
            iArr = new int[zzgw];
            jArr = new long[zzgw];
            iArr2 = new int[zzgw];
            int i9 = i8;
            long j4 = 0;
            j = 0;
            int i10 = 0;
            i4 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = i;
            int i15 = zzjd3;
            int i16 = zzjd2;
            int i17 = zzjd;
            int i18 = i2;
            while (i10 < zzgw) {
                while (i12 == 0) {
                    zzoz.checkState(zzkv.zzgv());
                    j4 = zzkv.zzawj;
                    i12 = zzkv.zzawi;
                    i15 = i15;
                    i16 = i16;
                }
                if (zzpk6 != null) {
                    while (i11 == 0 && i14 > 0) {
                        i11 = zzpk6.zzjd();
                        i13 = zzpk6.readInt();
                        i14--;
                    }
                    i11--;
                }
                jArr5[i10] = j4;
                iArr[i10] = zzky.zzgx();
                if (iArr[i10] > i4) {
                    i4 = iArr[i10];
                }
                jArr[i10] = j + ((long) i13);
                iArr2[i10] = zzpk4 == null ? 1 : 0;
                if (i10 == i9) {
                    iArr2[i10] = 1;
                    i18--;
                    if (i18 > 0) {
                        i9 = zzpk4.zzjd() - 1;
                    }
                }
                j += (long) i15;
                int i19 = i16 - 1;
                if (i19 != 0 || i17 <= 0) {
                    i6 = i15;
                    i7 = i19;
                } else {
                    i7 = zzpk3.zzjd();
                    i6 = zzpk3.zzjd();
                    i17--;
                }
                j4 += (long) iArr[i10];
                i12--;
                i10++;
                zzgw = zzgw;
                jArr5 = jArr5;
                i9 = i9;
                i13 = i13;
                i16 = i7;
                i15 = i6;
                zzky = zzky;
            }
            i3 = zzgw;
            zzoz.checkArgument(i11 == 0);
            while (i14 > 0) {
                zzoz.checkArgument(zzpk6.zzjd() == 0);
                zzpk6.readInt();
                i14--;
            }
            if (i18 == 0 && i16 == 0 && i12 == 0 && i17 == 0) {
                zzln2 = zzln;
            } else {
                zzln2 = zzln;
                int i20 = zzln2.id;
            }
            jArr2 = jArr5;
        } else {
            i3 = zzgw;
            int i21 = zzkv.length;
            long[] jArr6 = new long[i21];
            int[] iArr6 = new int[i21];
            while (zzkv.zzgv()) {
                int i22 = zzkv.index;
                jArr6[i22] = zzkv.zzawj;
                iArr6[i22] = zzkv.zzawi;
            }
            int zzgx = zzky.zzgx();
            long j5 = (long) zzjd3;
            int i23 = 8192 / zzgx;
            int i24 = 0;
            for (int i25 = 0; i25 < i21; i25++) {
                i24 += zzpq.zzf(iArr6[i25], i23);
            }
            long[] jArr7 = new long[i24];
            int[] iArr7 = new int[i24];
            long[] jArr8 = new long[i24];
            int[] iArr8 = new int[i24];
            int i26 = 0;
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            while (i26 < i21) {
                int i30 = iArr6[i26];
                long j6 = jArr6[i26];
                int i31 = i30;
                while (i31 > 0) {
                    int min = Math.min(i23, i31);
                    jArr7[i28] = j6;
                    iArr7[i28] = zzgx * min;
                    i29 = Math.max(i29, iArr7[i28]);
                    jArr8[i28] = ((long) i27) * j5;
                    iArr8[i28] = 1;
                    j6 += (long) iArr7[i28];
                    i27 += min;
                    i31 -= min;
                    i28++;
                    jArr6 = jArr6;
                    iArr6 = iArr6;
                }
                i26++;
                i21 = i21;
            }
            zzld zzld = new zzld(jArr7, iArr7, i29, jArr8, iArr8);
            jArr2 = zzld.zzaok;
            iArr = zzld.zzaoj;
            i4 = zzld.zzaxe;
            jArr = zzld.zzaxf;
            iArr2 = zzld.zzaxg;
            j = 0;
        }
        if (zzln2.zzbac == null || zzjz.zzgq()) {
            zzpq.zza(jArr, 1000000, zzln2.zzdg);
            return new zzls(jArr2, iArr, i4, jArr, iArr2);
        }
        long[] jArr9 = zzln2.zzbac;
        if (jArr9.length == 1 && zzln2.type == 1 && jArr.length >= 2) {
            long j7 = zzln2.zzbad[0];
            long zza = zzpq.zza(jArr9[0], zzln2.zzdg, zzln2.zzazz) + j7;
            if (jArr[0] <= j7 && j7 < jArr[1] && jArr[jArr.length - 1] < zza && zza <= j) {
                long j8 = j - zza;
                long zza2 = zzpq.zza(j7 - jArr[0], (long) zzln2.zzaht.zzahj, zzln2.zzdg);
                long zza3 = zzpq.zza(j8, (long) zzln2.zzaht.zzahj, zzln2.zzdg);
                if (!(zza2 == 0 && zza3 == 0) && zza2 <= 2147483647L && zza3 <= 2147483647L) {
                    zzjz.zzahl = (int) zza2;
                    zzjz.zzahm = (int) zza3;
                    zzpq.zza(jArr, 1000000, zzln2.zzdg);
                    return new zzls(jArr2, iArr, i4, jArr, iArr2);
                }
            }
        }
        long[] jArr10 = zzln2.zzbac;
        if (jArr10.length == 1) {
            char c = 0;
            if (jArr10[0] == 0) {
                int i32 = 0;
                while (i32 < jArr.length) {
                    jArr[i32] = zzpq.zza(jArr[i32] - zzln2.zzbad[c], 1000000, zzln2.zzdg);
                    i32++;
                    c = 0;
                }
                return new zzls(jArr2, iArr, i4, jArr, iArr2);
            }
        }
        boolean z3 = zzln2.type == 1;
        boolean z4 = false;
        int i33 = 0;
        int i34 = 0;
        int i35 = 0;
        while (true) {
            long[] jArr11 = zzln2.zzbac;
            j2 = -1;
            if (i35 >= jArr11.length) {
                break;
            }
            long j9 = zzln2.zzbad[i35];
            if (j9 != -1) {
                i5 = i4;
                long zza4 = zzpq.zza(jArr11[i35], zzln2.zzdg, zzln2.zzazz);
                int zzb = zzpq.zzb(jArr, j9, true, true);
                int zzb2 = zzpq.zzb(jArr, j9 + zza4, z3, false);
                int i36 = (zzb2 - zzb) + i33;
                z4 |= i34 != zzb;
                i33 = i36;
                i34 = zzb2;
            } else {
                i5 = i4;
            }
            i35++;
            iArr = iArr;
            i4 = i5;
        }
        int[] iArr9 = iArr;
        boolean z5 = z4 | (i33 != i3);
        long[] jArr12 = z5 ? new long[i33] : jArr2;
        int[] iArr10 = z5 ? new int[i33] : iArr9;
        int i37 = z5 ? 0 : i4;
        int[] iArr11 = z5 ? new int[i33] : iArr2;
        long[] jArr13 = new long[i33];
        int i38 = i37;
        int i39 = 0;
        int i40 = 0;
        while (true) {
            long[] jArr14 = zzln2.zzbac;
            if (i39 >= jArr14.length) {
                break;
            }
            int[] iArr12 = iArr11;
            long j10 = zzln2.zzbad[i39];
            long j11 = jArr14[i39];
            if (j10 != j2) {
                jArr4 = jArr12;
                int zzb3 = zzpq.zzb(jArr, j10, true, true);
                int zzb4 = zzpq.zzb(jArr, zzpq.zza(j11, zzln2.zzdg, zzln2.zzazz) + j10, z3, false);
                if (z5) {
                    int i41 = zzb4 - zzb3;
                    System.arraycopy(jArr2, zzb3, jArr4, i40, i41);
                    iArr4 = iArr9;
                    z2 = z3;
                    iArr3 = iArr10;
                    System.arraycopy(iArr4, zzb3, iArr3, i40, i41);
                    jArr3 = jArr2;
                    iArr5 = iArr12;
                    System.arraycopy(iArr2, zzb3, iArr5, i40, i41);
                } else {
                    iArr4 = iArr9;
                    jArr3 = jArr2;
                    iArr5 = iArr12;
                    z2 = z3;
                    iArr3 = iArr10;
                }
                int i42 = i38;
                while (zzb3 < zzb4) {
                    jArr13[i40] = zzpq.zza(j3, 1000000, zzln2.zzazz) + zzpq.zza(jArr[zzb3] - j10, 1000000, zzln2.zzdg);
                    if (z5 && iArr3[i40] > i42) {
                        i42 = iArr4[zzb3];
                    }
                    i40++;
                    zzb3++;
                    iArr4 = iArr4;
                    j10 = j10;
                    iArr5 = iArr5;
                }
                iArr12 = iArr5;
                iArr9 = iArr4;
                i38 = i42;
            } else {
                jArr4 = jArr12;
                jArr3 = jArr2;
                z2 = z3;
                iArr3 = iArr10;
            }
            j3 += j11;
            i39++;
            iArr10 = iArr3;
            jArr12 = jArr4;
            z3 = z2;
            iArr11 = iArr12;
            jArr2 = jArr3;
            j2 = -1;
        }
        boolean z7 = false;
        for (int i43 = 0; i43 < iArr11.length && !z7; i43++) {
            z7 |= (iArr11[i43] & 1) != 0;
        }
        if (z7) {
            return new zzls(jArr12, iArr10, i38, jArr13, iArr11);
        }
        throw new zzhv("The edited sample sequence does not contain a sync sample.");
    }

    public static zzmc zza(zzkt zzkt, boolean z) {
        if (z) {
            return null;
        }
        zzpk zzpk = zzkt.zzawe;
        zzpk.zzbo(8);
        while (zzpk.zziy() >= 8) {
            int position = zzpk.getPosition();
            int readInt = zzpk.readInt();
            if (zzpk.readInt() == zzkr.zzavp) {
                zzpk.zzbo(position);
                int i = position + readInt;
                zzpk.zzbp(12);
                while (true) {
                    if (zzpk.getPosition() >= i) {
                        break;
                    }
                    int position2 = zzpk.getPosition();
                    int readInt2 = zzpk.readInt();
                    if (zzpk.readInt() == zzkr.zzavq) {
                        zzpk.zzbo(position2);
                        int i2 = position2 + readInt2;
                        zzpk.zzbp(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzpk.getPosition() < i2) {
                            zzmc.zza zzd = zzlk.zzd(zzpk);
                            if (zzd != null) {
                                arrayList.add(zzd);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            return new zzmc(arrayList);
                        }
                    } else {
                        zzpk.zzbp(readInt2 - 8);
                    }
                }
                return null;
            }
            zzpk.zzbp(readInt - 8);
        }
        return null;
    }

    private static int zza(zzpk zzpk, int i, int i2, zzkx zzkx, int i3) {
        int position = zzpk.getPosition();
        while (true) {
            boolean z = false;
            if (position - i >= i2) {
                return 0;
            }
            zzpk.zzbo(position);
            int readInt = zzpk.readInt();
            zzoz.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (zzpk.readInt() == zzkr.zzauj) {
                int i4 = position + 8;
                Pair pair = null;
                Integer num = null;
                zzlq zzlq = null;
                boolean z2 = false;
                while (i4 - position < readInt) {
                    zzpk.zzbo(i4);
                    int readInt2 = zzpk.readInt();
                    int readInt3 = zzpk.readInt();
                    if (readInt3 == zzkr.zzaup) {
                        num = Integer.valueOf(zzpk.readInt());
                    } else if (readInt3 == zzkr.zzauk) {
                        zzpk.zzbp(4);
                        z2 = zzpk.readInt() == zzawv;
                    } else if (readInt3 == zzkr.zzaul) {
                        int i5 = i4 + 8;
                        while (true) {
                            if (i5 - i4 >= readInt2) {
                                zzlq = null;
                                break;
                            }
                            zzpk.zzbo(i5);
                            int readInt4 = zzpk.readInt();
                            if (zzpk.readInt() == zzkr.zzaum) {
                                zzpk.zzbp(6);
                                boolean z3 = zzpk.readUnsignedByte() == 1;
                                int readUnsignedByte = zzpk.readUnsignedByte();
                                byte[] bArr = new byte[16];
                                zzpk.zze(bArr, 0, 16);
                                zzlq = new zzlq(z3, readUnsignedByte, bArr);
                            } else {
                                i5 += readInt4;
                            }
                        }
                    }
                    i4 += readInt2;
                }
                if (z2) {
                    zzoz.checkArgument(num != null, "frma atom is mandatory");
                    if (zzlq != null) {
                        z = true;
                    }
                    zzoz.checkArgument(z, "schi->tenc atom is mandatory");
                    pair = Pair.create(num, zzlq);
                }
                if (pair != null) {
                    zzkx.zzaww[i3] = (zzlq) pair.second;
                    return ((Integer) pair.first).intValue();
                }
            }
            position += readInt;
        }
    }
}
