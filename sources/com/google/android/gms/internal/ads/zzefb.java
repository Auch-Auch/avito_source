package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.io.IOException;
public final class zzefb {
    public static int zza(byte[] bArr, int i, zzefa zzefa) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza(b, bArr, i2, zzefa);
        }
        zzefa.zziaw = b;
        return i2;
    }

    public static int zzb(byte[] bArr, int i, zzefa zzefa) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zzefa.zziax = j;
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
        zzefa.zziax = j2;
        return i3;
    }

    public static int zzc(byte[] bArr, int i, zzefa zzefa) throws zzegz {
        int zza = zza(bArr, i, zzefa);
        int i2 = zzefa.zziaw;
        if (i2 < 0) {
            throw zzegz.zzbgc();
        } else if (i2 == 0) {
            zzefa.zziay = "";
            return zza;
        } else {
            zzefa.zziay = new String(bArr, zza, i2, zzegr.UTF_8);
            return zza + i2;
        }
    }

    public static int zzd(byte[] bArr, int i, zzefa zzefa) throws zzegz {
        int zza = zza(bArr, i, zzefa);
        int i2 = zzefa.zziaw;
        if (i2 < 0) {
            throw zzegz.zzbgc();
        } else if (i2 == 0) {
            zzefa.zziay = "";
            return zza;
        } else {
            zzefa.zziay = zzejw.zzo(bArr, zza, i2);
            return zza + i2;
        }
    }

    public static int zze(byte[] bArr, int i, zzefa zzefa) throws zzegz {
        int zza = zza(bArr, i, zzefa);
        int i2 = zzefa.zziaw;
        if (i2 < 0) {
            throw zzegz.zzbgc();
        } else if (i2 > bArr.length - zza) {
            throw zzegz.zzbgb();
        } else if (i2 == 0) {
            zzefa.zziay = zzeff.zzibd;
            return zza;
        } else {
            zzefa.zziay = zzeff.zzi(bArr, zza, i2);
            return zza + i2;
        }
    }

    public static int zzg(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static long zzh(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public static double zzi(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzh(bArr, i));
    }

    public static float zzj(byte[] bArr, int i) {
        return Float.intBitsToFloat(zzg(bArr, i));
    }

    public static int zza(int i, byte[] bArr, int i2, zzefa zzefa) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzefa.zziaw = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzefa.zziaw = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzefa.zziaw = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzefa.zziaw = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzefa.zziaw = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static int zza(zzeiv zzeiv, byte[] bArr, int i, int i2, zzefa zzefa) throws IOException {
        int i3 = i + 1;
        byte b = bArr[i];
        byte b2 = b;
        if (b < 0) {
            i3 = zza(b, bArr, i3, zzefa);
            b2 = zzefa.zziaw;
        }
        if (b2 < 0 || b2 > i2 - i3) {
            throw zzegz.zzbgb();
        }
        Object newInstance = zzeiv.newInstance();
        int i4 = (b2 == 1 ? 1 : 0) + i3;
        zzeiv.zza(newInstance, bArr, i3, i4, zzefa);
        zzeiv.zzaj(newInstance);
        zzefa.zziay = newInstance;
        return i4;
    }

    public static int zza(zzeiv zzeiv, byte[] bArr, int i, int i2, int i3, zzefa zzefa) throws IOException {
        zzeid zzeid = (zzeid) zzeiv;
        Object newInstance = zzeid.newInstance();
        int zza = zzeid.zza((zzeid) newInstance, bArr, i, i2, i3, zzefa);
        zzeid.zzaj(newInstance);
        zzefa.zziay = newInstance;
        return zza;
    }

    public static int zza(int i, byte[] bArr, int i2, int i3, zzeha<?> zzeha, zzefa zzefa) {
        zzegs zzegs = (zzegs) zzeha;
        int zza = zza(bArr, i2, zzefa);
        zzegs.zzhc(zzefa.zziaw);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzefa);
            if (i != zzefa.zziaw) {
                break;
            }
            zza = zza(bArr, zza2, zzefa);
            zzegs.zzhc(zzefa.zziaw);
        }
        return zza;
    }

    public static int zza(byte[] bArr, int i, zzeha<?> zzeha, zzefa zzefa) throws IOException {
        zzegs zzegs = (zzegs) zzeha;
        int zza = zza(bArr, i, zzefa);
        int i2 = zzefa.zziaw + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzefa);
            zzegs.zzhc(zzefa.zziaw);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzegz.zzbgb();
    }

    public static int zza(zzeiv<?> zzeiv, int i, byte[] bArr, int i2, int i3, zzeha<?> zzeha, zzefa zzefa) throws IOException {
        int zza = zza(zzeiv, bArr, i2, i3, zzefa);
        zzeha.add(zzefa.zziay);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzefa);
            if (i != zzefa.zziaw) {
                break;
            }
            zza = zza(zzeiv, bArr, zza2, i3, zzefa);
            zzeha.add(zzefa.zziay);
        }
        return zza;
    }

    public static int zza(int i, byte[] bArr, int i2, int i3, zzejq zzejq, zzefa zzefa) throws zzegz {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzb = zzb(bArr, i2, zzefa);
                zzejq.zzd(i, Long.valueOf(zzefa.zziax));
                return zzb;
            } else if (i4 == 1) {
                zzejq.zzd(i, Long.valueOf(zzh(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza = zza(bArr, i2, zzefa);
                int i5 = zzefa.zziaw;
                if (i5 < 0) {
                    throw zzegz.zzbgc();
                } else if (i5 <= bArr.length - zza) {
                    if (i5 == 0) {
                        zzejq.zzd(i, zzeff.zzibd);
                    } else {
                        zzejq.zzd(i, zzeff.zzi(bArr, zza, i5));
                    }
                    return zza + i5;
                } else {
                    throw zzegz.zzbgb();
                }
            } else if (i4 == 3) {
                zzejq zzbia = zzejq.zzbia();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza2 = zza(bArr, i2, zzefa);
                    int i8 = zzefa.zziaw;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = zza2;
                        break;
                    }
                    int zza3 = zza(i7, bArr, zza2, i3, zzbia, zzefa);
                    i7 = i8;
                    i2 = zza3;
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzegz.zzbgi();
                }
                zzejq.zzd(i, zzbia);
                return i2;
            } else if (i4 == 5) {
                zzejq.zzd(i, Integer.valueOf(zzg(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzegz.zzbge();
            }
        } else {
            throw zzegz.zzbge();
        }
    }

    public static int zza(int i, byte[] bArr, int i2, int i3, zzefa zzefa) throws zzegz {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return zzb(bArr, i2, zzefa);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return zza(bArr, i2, zzefa) + zzefa.zziaw;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = zza(bArr, i2, zzefa);
                    i6 = zzefa.zziaw;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = zza(i6, bArr, i2, i3, zzefa);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw zzegz.zzbgi();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw zzegz.zzbge();
            }
        } else {
            throw zzegz.zzbge();
        }
    }
}
