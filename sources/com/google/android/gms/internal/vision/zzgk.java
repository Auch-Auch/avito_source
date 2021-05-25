package com.google.android.gms.internal.vision;

import com.google.common.base.Ascii;
import java.io.IOException;
public final class zzgk {
    public static int zza(byte[] bArr, int i, zzgm zzgm) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza(b, bArr, i2, zzgm);
        }
        zzgm.zztk = b;
        return i2;
    }

    public static int zzb(byte[] bArr, int i, zzgm zzgm) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zzgm.zztl = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & Byte.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & Byte.MAX_VALUE)) << i4;
            b = b2;
            i3 = i5;
        }
        zzgm.zztl = j2;
        return i3;
    }

    public static double zzc(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzb(bArr, i));
    }

    public static float zzd(byte[] bArr, int i) {
        return Float.intBitsToFloat(zza(bArr, i));
    }

    public static int zze(byte[] bArr, int i, zzgm zzgm) throws zzin {
        int zza = zza(bArr, i, zzgm);
        int i2 = zzgm.zztk;
        if (i2 < 0) {
            throw zzin.zzhi();
        } else if (i2 > bArr.length - zza) {
            throw zzin.zzhh();
        } else if (i2 == 0) {
            zzgm.zztm = zzgs.zztt;
            return zza;
        } else {
            zzgm.zztm = zzgs.zza(bArr, zza, i2);
            return zza + i2;
        }
    }

    public static int zzc(byte[] bArr, int i, zzgm zzgm) throws zzin {
        int zza = zza(bArr, i, zzgm);
        int i2 = zzgm.zztk;
        if (i2 < 0) {
            throw zzin.zzhi();
        } else if (i2 == 0) {
            zzgm.zztm = "";
            return zza;
        } else {
            zzgm.zztm = new String(bArr, zza, i2, zzie.UTF_8);
            return zza + i2;
        }
    }

    public static int zzd(byte[] bArr, int i, zzgm zzgm) throws zzin {
        int zza = zza(bArr, i, zzgm);
        int i2 = zzgm.zztk;
        if (i2 < 0) {
            throw zzin.zzhi();
        } else if (i2 == 0) {
            zzgm.zztm = "";
            return zza;
        } else {
            zzgm.zztm = zzlf.zzh(bArr, zza, i2);
            return zza + i2;
        }
    }

    public static int zza(int i, byte[] bArr, int i2, zzgm zzgm) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzgm.zztk = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzgm.zztk = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzgm.zztk = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzgm.zztk = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzgm.zztk = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static long zzb(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public static int zza(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static int zza(zzkf zzkf, byte[] bArr, int i, int i2, zzgm zzgm) throws IOException {
        int i3 = i + 1;
        byte b = bArr[i];
        byte b2 = b;
        if (b < 0) {
            i3 = zza(b, bArr, i3, zzgm);
            b2 = zzgm.zztk;
        }
        if (b2 < 0 || b2 > i2 - i3) {
            throw zzin.zzhh();
        }
        Object newInstance = zzkf.newInstance();
        int i4 = (b2 == 1 ? 1 : 0) + i3;
        zzkf.zza(newInstance, bArr, i3, i4, zzgm);
        zzkf.zzj(newInstance);
        zzgm.zztm = newInstance;
        return i4;
    }

    public static int zza(zzkf zzkf, byte[] bArr, int i, int i2, int i3, zzgm zzgm) throws IOException {
        zzjr zzjr = (zzjr) zzkf;
        Object newInstance = zzjr.newInstance();
        int zza = zzjr.zza((zzjr) newInstance, bArr, i, i2, i3, zzgm);
        zzjr.zzj(newInstance);
        zzgm.zztm = newInstance;
        return zza;
    }

    public static int zza(int i, byte[] bArr, int i2, int i3, zzik<?> zzik, zzgm zzgm) {
        zzif zzif = (zzif) zzik;
        int zza = zza(bArr, i2, zzgm);
        zzif.zzbs(zzgm.zztk);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzgm);
            if (i != zzgm.zztk) {
                break;
            }
            zza = zza(bArr, zza2, zzgm);
            zzif.zzbs(zzgm.zztk);
        }
        return zza;
    }

    public static int zza(byte[] bArr, int i, zzik<?> zzik, zzgm zzgm) throws IOException {
        zzif zzif = (zzif) zzik;
        int zza = zza(bArr, i, zzgm);
        int i2 = zzgm.zztk + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzgm);
            zzif.zzbs(zzgm.zztk);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzin.zzhh();
    }

    public static int zza(zzkf<?> zzkf, int i, byte[] bArr, int i2, int i3, zzik<?> zzik, zzgm zzgm) throws IOException {
        int zza = zza(zzkf, bArr, i2, i3, zzgm);
        zzik.add(zzgm.zztm);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzgm);
            if (i != zzgm.zztk) {
                break;
            }
            zza = zza(zzkf, bArr, zza2, i3, zzgm);
            zzik.add(zzgm.zztm);
        }
        return zza;
    }

    public static int zza(int i, byte[] bArr, int i2, int i3, zzkw zzkw, zzgm zzgm) throws zzin {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzb = zzb(bArr, i2, zzgm);
                zzkw.zzb(i, Long.valueOf(zzgm.zztl));
                return zzb;
            } else if (i4 == 1) {
                zzkw.zzb(i, Long.valueOf(zzb(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza = zza(bArr, i2, zzgm);
                int i5 = zzgm.zztk;
                if (i5 < 0) {
                    throw zzin.zzhi();
                } else if (i5 <= bArr.length - zza) {
                    if (i5 == 0) {
                        zzkw.zzb(i, zzgs.zztt);
                    } else {
                        zzkw.zzb(i, zzgs.zza(bArr, zza, i5));
                    }
                    return zza + i5;
                } else {
                    throw zzin.zzhh();
                }
            } else if (i4 == 3) {
                zzkw zzjb = zzkw.zzjb();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza2 = zza(bArr, i2, zzgm);
                    int i8 = zzgm.zztk;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = zza2;
                        break;
                    }
                    int zza3 = zza(i7, bArr, zza2, i3, zzjb, zzgm);
                    i7 = i8;
                    i2 = zza3;
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzin.zzhn();
                }
                zzkw.zzb(i, zzjb);
                return i2;
            } else if (i4 == 5) {
                zzkw.zzb(i, Integer.valueOf(zza(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzin.zzhk();
            }
        } else {
            throw zzin.zzhk();
        }
    }

    public static int zza(int i, byte[] bArr, int i2, int i3, zzgm zzgm) throws zzin {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return zzb(bArr, i2, zzgm);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return zza(bArr, i2, zzgm) + zzgm.zztk;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = zza(bArr, i2, zzgm);
                    i6 = zzgm.zztk;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = zza(i6, bArr, i2, i3, zzgm);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw zzin.zzhn();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw zzin.zzhk();
            }
        } else {
            throw zzin.zzhk();
        }
    }
}
