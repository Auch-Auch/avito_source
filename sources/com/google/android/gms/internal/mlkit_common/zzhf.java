package com.google.android.gms.internal.mlkit_common;

import a2.b.a.a.a;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;
public final class zzhf<T> implements zzhr<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzip.zzc();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzhb zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzhg zzo;
    private final zzgl zzp;
    private final zzij<?, ?> zzq;
    private final zzfg<?> zzr;
    private final zzgu zzs;

    private zzhf(int[] iArr, Object[] objArr, int i, int i2, zzhb zzhb, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzhg zzhg, zzgl zzgl, zzij<?, ?> zzij, zzfg<?> zzfg, zzgu zzgu) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzhb instanceof zzfq;
        this.zzj = z;
        this.zzh = zzfg != null && zzfg.zza(zzhb);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzhg;
        this.zzp = zzgl;
        this.zzq = zzij;
        this.zzr = zzfg;
        this.zzg = zzhb;
        this.zzs = zzgu;
    }

    public static <T> zzhf<T> zza(Class<T> cls, zzgz zzgz, zzhg zzhg, zzgl zzgl, zzij<?, ?> zzij, zzfg<?> zzfg, zzgu zzgu) {
        int i;
        int i2;
        int[] iArr;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        String str;
        Object[] objArr;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z;
        int i16;
        Field field;
        int i17;
        char charAt;
        int i18;
        int i19;
        Field field2;
        Field field3;
        int i20;
        char charAt2;
        int i21;
        char charAt3;
        int i22;
        char charAt4;
        int i23;
        char charAt5;
        int i24;
        char charAt6;
        int i25;
        char charAt7;
        int i26;
        char charAt8;
        int i27;
        char charAt9;
        int i28;
        char charAt10;
        int i29;
        char charAt11;
        int i30;
        char charAt12;
        int i31;
        char charAt13;
        if (zzgz instanceof zzho) {
            zzho zzho = (zzho) zzgz;
            int i32 = 0;
            boolean z2 = zzho.zza() == zzhn.zzb;
            String zzd2 = zzho.zzd();
            int length = zzd2.length();
            if (zzd2.charAt(0) >= 55296) {
                int i33 = 1;
                while (true) {
                    i = i33 + 1;
                    if (zzd2.charAt(i33) < 55296) {
                        break;
                    }
                    i33 = i;
                }
            } else {
                i = 1;
            }
            int i34 = i + 1;
            int charAt14 = zzd2.charAt(i);
            if (charAt14 >= 55296) {
                int i35 = charAt14 & 8191;
                int i36 = 13;
                while (true) {
                    i31 = i34 + 1;
                    charAt13 = zzd2.charAt(i34);
                    if (charAt13 < 55296) {
                        break;
                    }
                    i35 |= (charAt13 & 8191) << i36;
                    i36 += 13;
                    i34 = i31;
                }
                charAt14 = i35 | (charAt13 << i36);
                i34 = i31;
            }
            if (charAt14 == 0) {
                iArr = zza;
                i7 = 0;
                i6 = 0;
                i5 = 0;
                i4 = 0;
                i3 = 0;
                i2 = 0;
            } else {
                int i37 = i34 + 1;
                int charAt15 = zzd2.charAt(i34);
                if (charAt15 >= 55296) {
                    int i38 = charAt15 & 8191;
                    int i39 = 13;
                    while (true) {
                        i30 = i37 + 1;
                        charAt12 = zzd2.charAt(i37);
                        if (charAt12 < 55296) {
                            break;
                        }
                        i38 |= (charAt12 & 8191) << i39;
                        i39 += 13;
                        i37 = i30;
                    }
                    charAt15 = i38 | (charAt12 << i39);
                    i37 = i30;
                }
                int i40 = i37 + 1;
                int charAt16 = zzd2.charAt(i37);
                if (charAt16 >= 55296) {
                    int i41 = charAt16 & 8191;
                    int i42 = 13;
                    while (true) {
                        i29 = i40 + 1;
                        charAt11 = zzd2.charAt(i40);
                        if (charAt11 < 55296) {
                            break;
                        }
                        i41 |= (charAt11 & 8191) << i42;
                        i42 += 13;
                        i40 = i29;
                    }
                    charAt16 = i41 | (charAt11 << i42);
                    i40 = i29;
                }
                int i43 = i40 + 1;
                i6 = zzd2.charAt(i40);
                if (i6 >= 55296) {
                    int i44 = i6 & 8191;
                    int i45 = 13;
                    while (true) {
                        i28 = i43 + 1;
                        charAt10 = zzd2.charAt(i43);
                        if (charAt10 < 55296) {
                            break;
                        }
                        i44 |= (charAt10 & 8191) << i45;
                        i45 += 13;
                        i43 = i28;
                    }
                    i6 = i44 | (charAt10 << i45);
                    i43 = i28;
                }
                int i46 = i43 + 1;
                i5 = zzd2.charAt(i43);
                if (i5 >= 55296) {
                    int i47 = i5 & 8191;
                    int i48 = 13;
                    while (true) {
                        i27 = i46 + 1;
                        charAt9 = zzd2.charAt(i46);
                        if (charAt9 < 55296) {
                            break;
                        }
                        i47 |= (charAt9 & 8191) << i48;
                        i48 += 13;
                        i46 = i27;
                    }
                    i5 = i47 | (charAt9 << i48);
                    i46 = i27;
                }
                int i49 = i46 + 1;
                i4 = zzd2.charAt(i46);
                if (i4 >= 55296) {
                    int i50 = i4 & 8191;
                    int i51 = 13;
                    while (true) {
                        i26 = i49 + 1;
                        charAt8 = zzd2.charAt(i49);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i50 |= (charAt8 & 8191) << i51;
                        i51 += 13;
                        i49 = i26;
                    }
                    i4 = i50 | (charAt8 << i51);
                    i49 = i26;
                }
                int i52 = i49 + 1;
                i3 = zzd2.charAt(i49);
                if (i3 >= 55296) {
                    int i53 = i3 & 8191;
                    int i54 = 13;
                    while (true) {
                        i25 = i52 + 1;
                        charAt7 = zzd2.charAt(i52);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i53 |= (charAt7 & 8191) << i54;
                        i54 += 13;
                        i52 = i25;
                    }
                    i3 = i53 | (charAt7 << i54);
                    i52 = i25;
                }
                int i55 = i52 + 1;
                int charAt17 = zzd2.charAt(i52);
                if (charAt17 >= 55296) {
                    int i56 = charAt17 & 8191;
                    int i57 = 13;
                    while (true) {
                        i24 = i55 + 1;
                        charAt6 = zzd2.charAt(i55);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i56 |= (charAt6 & 8191) << i57;
                        i57 += 13;
                        i55 = i24;
                    }
                    charAt17 = i56 | (charAt6 << i57);
                    i55 = i24;
                }
                int i58 = i55 + 1;
                i2 = zzd2.charAt(i55);
                if (i2 >= 55296) {
                    int i59 = i2 & 8191;
                    int i60 = i58;
                    int i61 = 13;
                    while (true) {
                        i23 = i60 + 1;
                        charAt5 = zzd2.charAt(i60);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i59 |= (charAt5 & 8191) << i61;
                        i61 += 13;
                        i60 = i23;
                    }
                    i2 = i59 | (charAt5 << i61);
                    i58 = i23;
                }
                i7 = (charAt15 << 1) + charAt16;
                iArr = new int[(i2 + i3 + charAt17)];
                i32 = charAt15;
                i34 = i58;
            }
            Unsafe unsafe = zzb;
            Object[] zze2 = zzho.zze();
            Class<?> cls2 = zzho.zzc().getClass();
            int[] iArr2 = new int[(i4 * 3)];
            Object[] objArr2 = new Object[(i4 << 1)];
            int i62 = i2 + i3;
            int i63 = i7;
            int i64 = i2;
            int i65 = i34;
            int i66 = i62;
            int i67 = 0;
            int i68 = 0;
            while (i65 < length) {
                int i69 = i65 + 1;
                int charAt18 = zzd2.charAt(i65);
                if (charAt18 >= 55296) {
                    int i70 = charAt18 & 8191;
                    int i71 = i69;
                    int i72 = 13;
                    while (true) {
                        i22 = i71 + 1;
                        charAt4 = zzd2.charAt(i71);
                        i8 = length;
                        if (charAt4 < 55296) {
                            break;
                        }
                        i70 |= (charAt4 & 8191) << i72;
                        i72 += 13;
                        i71 = i22;
                        length = i8;
                    }
                    charAt18 = i70 | (charAt4 << i72);
                    i9 = i22;
                } else {
                    i8 = length;
                    i9 = i69;
                }
                int i73 = i9 + 1;
                int charAt19 = zzd2.charAt(i9);
                if (charAt19 >= 55296) {
                    int i74 = charAt19 & 8191;
                    int i75 = i73;
                    int i76 = 13;
                    while (true) {
                        i21 = i75 + 1;
                        charAt3 = zzd2.charAt(i75);
                        i10 = i2;
                        if (charAt3 < 55296) {
                            break;
                        }
                        i74 |= (charAt3 & 8191) << i76;
                        i76 += 13;
                        i75 = i21;
                        i2 = i10;
                    }
                    charAt19 = i74 | (charAt3 << i76);
                    i11 = i21;
                } else {
                    i10 = i2;
                    i11 = i73;
                }
                int i77 = charAt19 & 255;
                if ((charAt19 & 1024) != 0) {
                    iArr[i67] = i68;
                    i67++;
                }
                if (i77 >= 51) {
                    int i78 = i11 + 1;
                    int charAt20 = zzd2.charAt(i11);
                    char c = 55296;
                    if (charAt20 >= 55296) {
                        int i79 = charAt20 & 8191;
                        int i80 = 13;
                        while (true) {
                            i20 = i78 + 1;
                            charAt2 = zzd2.charAt(i78);
                            if (charAt2 < c) {
                                break;
                            }
                            i79 |= (charAt2 & 8191) << i80;
                            i80 += 13;
                            i78 = i20;
                            c = 55296;
                        }
                        charAt20 = i79 | (charAt2 << i80);
                        i78 = i20;
                    }
                    int i81 = i77 - 51;
                    if (i81 == 9 || i81 == 17) {
                        i19 = 1;
                        objArr2[((i68 / 3) << 1) + 1] = zze2[i63];
                        i63++;
                    } else {
                        if (i81 == 12 && !z2) {
                            objArr2[((i68 / 3) << 1) + 1] = zze2[i63];
                            i63++;
                        }
                        i19 = 1;
                    }
                    int i82 = charAt20 << i19;
                    Object obj = zze2[i82];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zza(cls2, (String) obj);
                        zze2[i82] = field2;
                    }
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i83 = i82 + 1;
                    Object obj2 = zze2[i83];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zza(cls2, (String) obj2);
                        zze2[i83] = field3;
                    }
                    str = zzd2;
                    i14 = (int) unsafe.objectFieldOffset(field3);
                    z = z2;
                    objArr = objArr2;
                    i13 = objectFieldOffset;
                    i12 = i78;
                    i15 = 0;
                } else {
                    int i84 = i63 + 1;
                    Field zza2 = zza(cls2, (String) zze2[i63]);
                    if (i77 == 9 || i77 == 17) {
                        objArr2[((i68 / 3) << 1) + 1] = zza2.getType();
                    } else {
                        if (i77 == 27 || i77 == 49) {
                            i18 = i84 + 1;
                            objArr2[((i68 / 3) << 1) + 1] = zze2[i84];
                        } else if (i77 == 12 || i77 == 30 || i77 == 44) {
                            if (!z2) {
                                i18 = i84 + 1;
                                objArr2[((i68 / 3) << 1) + 1] = zze2[i84];
                            }
                        } else if (i77 == 50) {
                            int i85 = i64 + 1;
                            iArr[i64] = i68;
                            int i86 = (i68 / 3) << 1;
                            i18 = i84 + 1;
                            objArr2[i86] = zze2[i84];
                            if ((charAt19 & 2048) != 0) {
                                i84 = i18 + 1;
                                objArr2[i86 + 1] = zze2[i18];
                                i64 = i85;
                            } else {
                                i64 = i85;
                            }
                        }
                        i16 = i18;
                        i13 = (int) unsafe.objectFieldOffset(zza2);
                        if ((charAt19 & 4096) == 4096 || i77 > 17) {
                            str = zzd2;
                            z = z2;
                            objArr = objArr2;
                            i14 = 1048575;
                            i12 = i11;
                            i15 = 0;
                        } else {
                            int i87 = i11 + 1;
                            int charAt21 = zzd2.charAt(i11);
                            if (charAt21 >= 55296) {
                                int i88 = charAt21 & 8191;
                                int i89 = 13;
                                while (true) {
                                    i17 = i87 + 1;
                                    charAt = zzd2.charAt(i87);
                                    if (charAt < 55296) {
                                        break;
                                    }
                                    i88 |= (charAt & 8191) << i89;
                                    i89 += 13;
                                    i87 = i17;
                                }
                                charAt21 = i88 | (charAt << i89);
                                i87 = i17;
                            }
                            int i90 = (charAt21 / 32) + (i32 << 1);
                            Object obj3 = zze2[i90];
                            str = zzd2;
                            if (obj3 instanceof Field) {
                                field = (Field) obj3;
                            } else {
                                field = zza(cls2, (String) obj3);
                                zze2[i90] = field;
                            }
                            z = z2;
                            objArr = objArr2;
                            i15 = charAt21 % 32;
                            i12 = i87;
                            i14 = (int) unsafe.objectFieldOffset(field);
                        }
                        if (i77 >= 18 && i77 <= 49) {
                            iArr[i66] = i13;
                            i66++;
                        }
                        i63 = i16;
                    }
                    i16 = i84;
                    i13 = (int) unsafe.objectFieldOffset(zza2);
                    if ((charAt19 & 4096) == 4096) {
                    }
                    str = zzd2;
                    z = z2;
                    objArr = objArr2;
                    i14 = 1048575;
                    i12 = i11;
                    i15 = 0;
                    iArr[i66] = i13;
                    i66++;
                    i63 = i16;
                }
                int i91 = i68 + 1;
                iArr2[i68] = charAt18;
                int i92 = i91 + 1;
                iArr2[i91] = ((charAt19 & 256) != 0 ? 268435456 : 0) | ((charAt19 & 512) != 0 ? 536870912 : 0) | (i77 << 20) | i13;
                int i93 = i92 + 1;
                iArr2[i92] = (i15 << 20) | i14;
                i65 = i12;
                i32 = i32;
                i5 = i5;
                i2 = i10;
                objArr2 = objArr;
                i6 = i6;
                z2 = z;
                i68 = i93;
                length = i8;
                zzd2 = str;
            }
            return new zzhf<>(iArr2, objArr2, i6, i5, zzho.zzc(), z2, false, iArr, i2, i62, zzhg, zzgl, zzij, zzfg, zzgu);
        }
        ((zzic) zzgz).zza();
        int i94 = zzhn.zzb;
        throw new NoSuchMethodError();
    }

    private static <T> long zze(T t, long j) {
        return ((Long) zzip.zzf(t, j)).longValue();
    }

    private static <T> boolean zzf(T t, long j) {
        return ((Boolean) zzip.zzf(t, j)).booleanValue();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzhr
    public final void zzb(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzc2 = zzc(i);
            long j = (long) (1048575 & zzc2);
            int i2 = this.zzc[i];
            switch ((zzc2 & 267386880) >>> 20) {
                case 0:
                    if (zza((zzhf<T>) t2, i)) {
                        zzip.zza(t, j, zzip.zze(t2, j));
                        zzb((zzhf<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zza((zzhf<T>) t2, i)) {
                        zzip.zza((Object) t, j, zzip.zzd(t2, j));
                        zzb((zzhf<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zza((zzhf<T>) t2, i)) {
                        zzip.zza((Object) t, j, zzip.zzb(t2, j));
                        zzb((zzhf<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zza((zzhf<T>) t2, i)) {
                        zzip.zza((Object) t, j, zzip.zzb(t2, j));
                        zzb((zzhf<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zza((zzhf<T>) t2, i)) {
                        zzip.zza((Object) t, j, zzip.zza(t2, j));
                        zzb((zzhf<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zza((zzhf<T>) t2, i)) {
                        zzip.zza((Object) t, j, zzip.zzb(t2, j));
                        zzb((zzhf<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zza((zzhf<T>) t2, i)) {
                        zzip.zza((Object) t, j, zzip.zza(t2, j));
                        zzb((zzhf<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zza((zzhf<T>) t2, i)) {
                        zzip.zza(t, j, zzip.zzc(t2, j));
                        zzb((zzhf<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zza((zzhf<T>) t2, i)) {
                        zzip.zza(t, j, zzip.zzf(t2, j));
                        zzb((zzhf<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zza((zzhf<T>) t2, i)) {
                        zzip.zza(t, j, zzip.zzf(t2, j));
                        zzb((zzhf<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zza((zzhf<T>) t2, i)) {
                        zzip.zza((Object) t, j, zzip.zza(t2, j));
                        zzb((zzhf<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zza((zzhf<T>) t2, i)) {
                        zzip.zza((Object) t, j, zzip.zza(t2, j));
                        zzb((zzhf<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zza((zzhf<T>) t2, i)) {
                        zzip.zza((Object) t, j, zzip.zza(t2, j));
                        zzb((zzhf<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zza((zzhf<T>) t2, i)) {
                        zzip.zza((Object) t, j, zzip.zzb(t2, j));
                        zzb((zzhf<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zza((zzhf<T>) t2, i)) {
                        zzip.zza((Object) t, j, zzip.zza(t2, j));
                        zzb((zzhf<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zza((zzhf<T>) t2, i)) {
                        zzip.zza((Object) t, j, zzip.zzb(t2, j));
                        zzb((zzhf<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zza(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzp.zza(t, t2, j);
                    break;
                case 50:
                    zzht.zza(this.zzs, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zza(t2, i2, i)) {
                        zzip.zza(t, j, zzip.zzf(t2, j));
                        zzb(t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzb(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zza(t2, i2, i)) {
                        zzip.zza(t, j, zzip.zzf(t2, j));
                        zzb(t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        zzht.zza(this.zzq, t, t2);
        if (this.zzh) {
            zzht.zza(this.zzr, t, t2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.mlkit_common.zzhr] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.google.android.gms.internal.mlkit_common.zzhr] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.gms.internal.mlkit_common.zzhr
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzc(T r19) {
        /*
        // Method dump skipped, instructions count: 320
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzhf.zzc(java.lang.Object):boolean");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.mlkit_common.zzhr
    public final int zzd(T t) {
        int i;
        int i2;
        int i3;
        int zzb2;
        int zzd2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12 = 267386880;
        int i13 = 1048575;
        int i14 = 1;
        if (this.zzj) {
            Unsafe unsafe = zzb;
            int i15 = 0;
            int i16 = 0;
            while (i15 < this.zzc.length) {
                int zzc2 = zzc(i15);
                int i17 = (i12 & zzc2) >>> 20;
                int i18 = this.zzc[i15];
                long j = (long) (zzc2 & 1048575);
                if (i17 >= zzfm.DOUBLE_LIST_PACKED.zza() && i17 <= zzfm.SINT64_LIST_PACKED.zza()) {
                    int i19 = this.zzc[i15 + 2];
                }
                switch (i17) {
                    case 0:
                        if (zza((zzhf<T>) t, i15)) {
                            i8 = zzfc.zzb(i18, 0.0d);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zza((zzhf<T>) t, i15)) {
                            i8 = zzfc.zzb(i18, 0.0f);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zza((zzhf<T>) t, i15)) {
                            i8 = zzfc.zzd(i18, zzip.zzb(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zza((zzhf<T>) t, i15)) {
                            i8 = zzfc.zze(i18, zzip.zzb(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zza((zzhf<T>) t, i15)) {
                            i8 = zzfc.zzf(i18, zzip.zza(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zza((zzhf<T>) t, i15)) {
                            i8 = zzfc.zzg(i18, 0L);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zza((zzhf<T>) t, i15)) {
                            i8 = zzfc.zzi(i18, 0);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zza((zzhf<T>) t, i15)) {
                            i8 = zzfc.zzb(i18, true);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zza((zzhf<T>) t, i15)) {
                            Object zzf2 = zzip.zzf(t, j);
                            if (zzf2 instanceof zzep) {
                                i8 = zzfc.zzc(i18, (zzep) zzf2);
                            } else {
                                i8 = zzfc.zzb(i18, (String) zzf2);
                            }
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (zza((zzhf<T>) t, i15)) {
                            i8 = zzht.zza(i18, zzip.zzf(t, j), zza(i15));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zza((zzhf<T>) t, i15)) {
                            i8 = zzfc.zzc(i18, (zzep) zzip.zzf(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zza((zzhf<T>) t, i15)) {
                            i8 = zzfc.zzg(i18, zzip.zza(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zza((zzhf<T>) t, i15)) {
                            i8 = zzfc.zzk(i18, zzip.zza(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zza((zzhf<T>) t, i15)) {
                            i8 = zzfc.zzj(i18, 0);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zza((zzhf<T>) t, i15)) {
                            i8 = zzfc.zzh(i18, 0L);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zza((zzhf<T>) t, i15)) {
                            i8 = zzfc.zzh(i18, zzip.zza(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zza((zzhf<T>) t, i15)) {
                            i8 = zzfc.zzf(i18, zzip.zzb(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zza((zzhf<T>) t, i15)) {
                            i8 = zzfc.zzc(i18, (zzhb) zzip.zzf(t, j), zza(i15));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        i8 = zzht.zzi(i18, zza(t, j), false);
                        i16 += i8;
                        break;
                    case 19:
                        i8 = zzht.zzh(i18, zza(t, j), false);
                        i16 += i8;
                        break;
                    case 20:
                        i8 = zzht.zza(i18, (List<Long>) zza(t, j), false);
                        i16 += i8;
                        break;
                    case 21:
                        i8 = zzht.zzb(i18, (List<Long>) zza(t, j), false);
                        i16 += i8;
                        break;
                    case 22:
                        i8 = zzht.zze(i18, zza(t, j), false);
                        i16 += i8;
                        break;
                    case 23:
                        i8 = zzht.zzi(i18, zza(t, j), false);
                        i16 += i8;
                        break;
                    case 24:
                        i8 = zzht.zzh(i18, zza(t, j), false);
                        i16 += i8;
                        break;
                    case 25:
                        i8 = zzht.zzj(i18, zza(t, j), false);
                        i16 += i8;
                        break;
                    case 26:
                        i8 = zzht.zza(i18, zza(t, j));
                        i16 += i8;
                        break;
                    case 27:
                        i8 = zzht.zza(i18, zza(t, j), zza(i15));
                        i16 += i8;
                        break;
                    case 28:
                        i8 = zzht.zzb(i18, zza(t, j));
                        i16 += i8;
                        break;
                    case 29:
                        i8 = zzht.zzf(i18, zza(t, j), false);
                        i16 += i8;
                        break;
                    case 30:
                        i8 = zzht.zzd(i18, zza(t, j), false);
                        i16 += i8;
                        break;
                    case 31:
                        i8 = zzht.zzh(i18, zza(t, j), false);
                        i16 += i8;
                        break;
                    case 32:
                        i8 = zzht.zzi(i18, zza(t, j), false);
                        i16 += i8;
                        break;
                    case 33:
                        i8 = zzht.zzg(i18, zza(t, j), false);
                        i16 += i8;
                        break;
                    case 34:
                        i8 = zzht.zzc(i18, zza(t, j), false);
                        i16 += i8;
                        break;
                    case 35:
                        i11 = zzht.zzi((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzfc.zze(i18);
                            i9 = zzfc.zzg(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        i11 = zzht.zzh((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzfc.zze(i18);
                            i9 = zzfc.zzg(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        i11 = zzht.zza((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzfc.zze(i18);
                            i9 = zzfc.zzg(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        i11 = zzht.zzb((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzfc.zze(i18);
                            i9 = zzfc.zzg(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        i11 = zzht.zze((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzfc.zze(i18);
                            i9 = zzfc.zzg(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        i11 = zzht.zzi((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzfc.zze(i18);
                            i9 = zzfc.zzg(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        i11 = zzht.zzh((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzfc.zze(i18);
                            i9 = zzfc.zzg(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        i11 = zzht.zzj((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzfc.zze(i18);
                            i9 = zzfc.zzg(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        i11 = zzht.zzf((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzfc.zze(i18);
                            i9 = zzfc.zzg(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        i11 = zzht.zzd((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzfc.zze(i18);
                            i9 = zzfc.zzg(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        i11 = zzht.zzh((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzfc.zze(i18);
                            i9 = zzfc.zzg(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        i11 = zzht.zzi((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzfc.zze(i18);
                            i9 = zzfc.zzg(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        i11 = zzht.zzg((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzfc.zze(i18);
                            i9 = zzfc.zzg(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        i11 = zzht.zzc((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzfc.zze(i18);
                            i9 = zzfc.zzg(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        i8 = zzht.zzb(i18, (List<zzhb>) zza(t, j), zza(i15));
                        i16 += i8;
                        break;
                    case 50:
                        i8 = this.zzs.zza(i18, zzip.zzf(t, j), zzb(i15));
                        i16 += i8;
                        break;
                    case 51:
                        if (zza(t, i18, i15)) {
                            i8 = zzfc.zzb(i18, 0.0d);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zza(t, i18, i15)) {
                            i8 = zzfc.zzb(i18, 0.0f);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zza(t, i18, i15)) {
                            i8 = zzfc.zzd(i18, zze(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zza(t, i18, i15)) {
                            i8 = zzfc.zze(i18, zze(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zza(t, i18, i15)) {
                            i8 = zzfc.zzf(i18, zzd(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zza(t, i18, i15)) {
                            i8 = zzfc.zzg(i18, 0L);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zza(t, i18, i15)) {
                            i8 = zzfc.zzi(i18, 0);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zza(t, i18, i15)) {
                            i8 = zzfc.zzb(i18, true);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zza(t, i18, i15)) {
                            Object zzf3 = zzip.zzf(t, j);
                            if (zzf3 instanceof zzep) {
                                i8 = zzfc.zzc(i18, (zzep) zzf3);
                            } else {
                                i8 = zzfc.zzb(i18, (String) zzf3);
                            }
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (zza(t, i18, i15)) {
                            i8 = zzht.zza(i18, zzip.zzf(t, j), zza(i15));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zza(t, i18, i15)) {
                            i8 = zzfc.zzc(i18, (zzep) zzip.zzf(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zza(t, i18, i15)) {
                            i8 = zzfc.zzg(i18, zzd(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zza(t, i18, i15)) {
                            i8 = zzfc.zzk(i18, zzd(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zza(t, i18, i15)) {
                            i8 = zzfc.zzj(i18, 0);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zza(t, i18, i15)) {
                            i8 = zzfc.zzh(i18, 0L);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zza(t, i18, i15)) {
                            i8 = zzfc.zzh(i18, zzd(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zza(t, i18, i15)) {
                            i8 = zzfc.zzf(i18, zze(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zza(t, i18, i15)) {
                            i8 = zzfc.zzc(i18, (zzhb) zzip.zzf(t, j), zza(i15));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                }
                i15 += 3;
                i12 = 267386880;
            }
            return i16 + zza((zzij) this.zzq, (Object) t);
        }
        Unsafe unsafe2 = zzb;
        int i20 = 0;
        int i21 = 0;
        int i22 = 1048575;
        int i23 = 0;
        while (i20 < this.zzc.length) {
            int zzc3 = zzc(i20);
            int[] iArr = this.zzc;
            int i24 = iArr[i20];
            int i25 = (267386880 & zzc3) >>> 20;
            if (i25 <= 17) {
                int i26 = iArr[i20 + 2];
                int i27 = i26 & i13;
                i = i14 << (i26 >>> 20);
                if (i27 != i22) {
                    i23 = unsafe2.getInt(t, (long) i27);
                    i22 = i27;
                }
            } else {
                i = 0;
            }
            long j2 = (long) (i13 & zzc3);
            switch (i25) {
                case 0:
                    if ((i23 & i) != 0) {
                        i3 = zzfc.zzb(i24, 0.0d);
                        i2 = i3 + i21;
                        i21 = i2;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i23 & i) != 0) {
                        zzb2 = zzfc.zzb(i24, 0.0f);
                        i21 += zzb2;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((i & i23) != 0) {
                        zzd2 = zzfc.zzd(i24, unsafe2.getLong(t, j2));
                        i21 += zzd2;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i & i23) != 0) {
                        zzd2 = zzfc.zze(i24, unsafe2.getLong(t, j2));
                        i21 += zzd2;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i & i23) != 0) {
                        zzd2 = zzfc.zzf(i24, unsafe2.getInt(t, j2));
                        i21 += zzd2;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i23 & i) != 0) {
                        zzd2 = zzfc.zzg(i24, 0L);
                        i21 += zzd2;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((i23 & i) != 0) {
                        zzb2 = zzfc.zzi(i24, 0);
                        i21 += zzb2;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((i23 & i) != 0) {
                        i3 = zzfc.zzb(i24, true);
                        i2 = i3 + i21;
                        i21 = i2;
                        break;
                    }
                    i2 = i21;
                    i21 = i2;
                case 8:
                    if ((i23 & i) != 0) {
                        Object object = unsafe2.getObject(t, j2);
                        if (object instanceof zzep) {
                            i4 = zzfc.zzc(i24, (zzep) object);
                        } else {
                            i4 = zzfc.zzb(i24, (String) object);
                        }
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 9:
                    if ((i23 & i) != 0) {
                        i4 = zzht.zza(i24, unsafe2.getObject(t, j2), zza(i20));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 10:
                    if ((i23 & i) != 0) {
                        i4 = zzfc.zzc(i24, (zzep) unsafe2.getObject(t, j2));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 11:
                    if ((i23 & i) != 0) {
                        i4 = zzfc.zzg(i24, unsafe2.getInt(t, j2));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 12:
                    if ((i23 & i) != 0) {
                        i4 = zzfc.zzk(i24, unsafe2.getInt(t, j2));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 13:
                    if ((i23 & i) != 0) {
                        i4 = zzfc.zzj(i24, 0);
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 14:
                    if ((i23 & i) != 0) {
                        i4 = zzfc.zzh(i24, 0L);
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 15:
                    if ((i23 & i) != 0) {
                        i4 = zzfc.zzh(i24, unsafe2.getInt(t, j2));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 16:
                    if ((i23 & i) != 0) {
                        i4 = zzfc.zzf(i24, unsafe2.getLong(t, j2));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 17:
                    if ((i23 & i) != 0) {
                        i4 = zzfc.zzc(i24, (zzhb) unsafe2.getObject(t, j2), zza(i20));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 18:
                    i4 = zzht.zzi(i24, (List) unsafe2.getObject(t, j2), false);
                    i21 += i4;
                    i2 = i21;
                    i21 = i2;
                    break;
                case 19:
                    zzd2 = zzht.zzh(i24, (List) unsafe2.getObject(t, j2), false);
                    i21 += zzd2;
                    break;
                case 20:
                    zzd2 = zzht.zza(i24, (List<Long>) ((List) unsafe2.getObject(t, j2)), false);
                    i21 += zzd2;
                    break;
                case 21:
                    zzd2 = zzht.zzb(i24, (List<Long>) ((List) unsafe2.getObject(t, j2)), false);
                    i21 += zzd2;
                    break;
                case 22:
                    zzd2 = zzht.zze(i24, (List) unsafe2.getObject(t, j2), false);
                    i21 += zzd2;
                    break;
                case 23:
                    zzd2 = zzht.zzi(i24, (List) unsafe2.getObject(t, j2), false);
                    i21 += zzd2;
                    break;
                case 24:
                    zzd2 = zzht.zzh(i24, (List) unsafe2.getObject(t, j2), false);
                    i21 += zzd2;
                    break;
                case 25:
                    zzd2 = zzht.zzj(i24, (List) unsafe2.getObject(t, j2), false);
                    i21 += zzd2;
                    break;
                case 26:
                    i4 = zzht.zza(i24, (List) unsafe2.getObject(t, j2));
                    i21 += i4;
                    i2 = i21;
                    i21 = i2;
                    break;
                case 27:
                    i4 = zzht.zza(i24, (List<?>) ((List) unsafe2.getObject(t, j2)), zza(i20));
                    i21 += i4;
                    i2 = i21;
                    i21 = i2;
                    break;
                case 28:
                    i4 = zzht.zzb(i24, (List) unsafe2.getObject(t, j2));
                    i21 += i4;
                    i2 = i21;
                    i21 = i2;
                    break;
                case 29:
                    i4 = zzht.zzf(i24, (List) unsafe2.getObject(t, j2), false);
                    i21 += i4;
                    i2 = i21;
                    i21 = i2;
                    break;
                case 30:
                    zzd2 = zzht.zzd(i24, (List) unsafe2.getObject(t, j2), false);
                    i21 += zzd2;
                    break;
                case 31:
                    zzd2 = zzht.zzh(i24, (List) unsafe2.getObject(t, j2), false);
                    i21 += zzd2;
                    break;
                case 32:
                    zzd2 = zzht.zzi(i24, (List) unsafe2.getObject(t, j2), false);
                    i21 += zzd2;
                    break;
                case 33:
                    zzd2 = zzht.zzg(i24, (List) unsafe2.getObject(t, j2), false);
                    i21 += zzd2;
                    break;
                case 34:
                    zzd2 = zzht.zzc(i24, (List) unsafe2.getObject(t, j2), false);
                    i21 += zzd2;
                    break;
                case 35:
                    i7 = zzht.zzi((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzfc.zze(i24);
                        i5 = zzfc.zzg(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 36:
                    i7 = zzht.zzh((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzfc.zze(i24);
                        i5 = zzfc.zzg(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 37:
                    i7 = zzht.zza((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzfc.zze(i24);
                        i5 = zzfc.zzg(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 38:
                    i7 = zzht.zzb((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzfc.zze(i24);
                        i5 = zzfc.zzg(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 39:
                    i7 = zzht.zze((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzfc.zze(i24);
                        i5 = zzfc.zzg(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 40:
                    i7 = zzht.zzi((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzfc.zze(i24);
                        i5 = zzfc.zzg(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 41:
                    i7 = zzht.zzh((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzfc.zze(i24);
                        i5 = zzfc.zzg(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 42:
                    i7 = zzht.zzj((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzfc.zze(i24);
                        i5 = zzfc.zzg(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 43:
                    i7 = zzht.zzf((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzfc.zze(i24);
                        i5 = zzfc.zzg(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 44:
                    i7 = zzht.zzd((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzfc.zze(i24);
                        i5 = zzfc.zzg(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 45:
                    i7 = zzht.zzh((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzfc.zze(i24);
                        i5 = zzfc.zzg(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 46:
                    i7 = zzht.zzi((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzfc.zze(i24);
                        i5 = zzfc.zzg(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 47:
                    i7 = zzht.zzg((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzfc.zze(i24);
                        i5 = zzfc.zzg(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 48:
                    i7 = zzht.zzc((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzfc.zze(i24);
                        i5 = zzfc.zzg(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 49:
                    i4 = zzht.zzb(i24, (List) unsafe2.getObject(t, j2), zza(i20));
                    i21 += i4;
                    i2 = i21;
                    i21 = i2;
                    break;
                case 50:
                    i4 = this.zzs.zza(i24, unsafe2.getObject(t, j2), zzb(i20));
                    i21 += i4;
                    i2 = i21;
                    i21 = i2;
                    break;
                case 51:
                    if (zza(t, i24, i20)) {
                        i4 = zzfc.zzb(i24, 0.0d);
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 52:
                    if (zza(t, i24, i20)) {
                        i4 = zzfc.zzb(i24, 0.0f);
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 53:
                    if (zza(t, i24, i20)) {
                        i4 = zzfc.zzd(i24, zze(t, j2));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 54:
                    if (zza(t, i24, i20)) {
                        i4 = zzfc.zze(i24, zze(t, j2));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 55:
                    if (zza(t, i24, i20)) {
                        i4 = zzfc.zzf(i24, zzd(t, j2));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 56:
                    if (zza(t, i24, i20)) {
                        i4 = zzfc.zzg(i24, 0L);
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 57:
                    if (zza(t, i24, i20)) {
                        i4 = zzfc.zzi(i24, 0);
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 58:
                    if (zza(t, i24, i20)) {
                        i4 = zzfc.zzb(i24, true);
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 59:
                    if (zza(t, i24, i20)) {
                        Object object2 = unsafe2.getObject(t, j2);
                        if (object2 instanceof zzep) {
                            i4 = zzfc.zzc(i24, (zzep) object2);
                        } else {
                            i4 = zzfc.zzb(i24, (String) object2);
                        }
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 60:
                    if (zza(t, i24, i20)) {
                        i4 = zzht.zza(i24, unsafe2.getObject(t, j2), zza(i20));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 61:
                    if (zza(t, i24, i20)) {
                        i4 = zzfc.zzc(i24, (zzep) unsafe2.getObject(t, j2));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 62:
                    if (zza(t, i24, i20)) {
                        i4 = zzfc.zzg(i24, zzd(t, j2));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 63:
                    if (zza(t, i24, i20)) {
                        i4 = zzfc.zzk(i24, zzd(t, j2));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 64:
                    if (zza(t, i24, i20)) {
                        i4 = zzfc.zzj(i24, 0);
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 65:
                    if (zza(t, i24, i20)) {
                        i4 = zzfc.zzh(i24, 0L);
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 66:
                    if (zza(t, i24, i20)) {
                        i4 = zzfc.zzh(i24, zzd(t, j2));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 67:
                    if (zza(t, i24, i20)) {
                        i4 = zzfc.zzf(i24, zze(t, j2));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 68:
                    if (zza(t, i24, i20)) {
                        i4 = zzfc.zzc(i24, (zzhb) unsafe2.getObject(t, j2), zza(i20));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                default:
                    i2 = i21;
                    i21 = i2;
                    break;
            }
            i20 += 3;
            i13 = 1048575;
            i14 = 1;
        }
        int i28 = 0;
        int zza2 = i21 + zza((zzij) this.zzq, (Object) t);
        if (!this.zzh) {
            return zza2;
        }
        zzfl<?> zza3 = this.zzr.zza((Object) t);
        for (int i29 = 0; i29 < zza3.zza.zzc(); i29++) {
            Map.Entry<T, Object> zzb3 = zza3.zza.zzb(i29);
            i28 += zzfl.zza((zzfn<?>) zzb3.getKey(), zzb3.getValue());
        }
        for (Map.Entry<T, Object> entry : zza3.zza.zzd()) {
            i28 += zzfl.zza((zzfn<?>) entry.getKey(), entry.getValue());
        }
        return zza2 + i28;
    }

    private final int zzc(int i) {
        return this.zzc[i + 1];
    }

    private static <T> float zzc(T t, long j) {
        return ((Float) zzip.zzf(t, j)).floatValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final void zzb(T t, T t2, int i) {
        int zzc2 = zzc(i);
        int i2 = this.zzc[i];
        long j = (long) (zzc2 & 1048575);
        if (zza(t2, i2, i)) {
            Object zzf2 = zzip.zzf(t, j);
            Object zzf3 = zzip.zzf(t2, j);
            if (zzf2 != null && zzf3 != null) {
                zzip.zza(t, j, zzfs.zza(zzf2, zzf3));
                zzb(t, i2, i);
            } else if (zzf3 != null) {
                zzip.zza(t, j, zzf3);
                zzb(t, i2, i);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:170:0x0495  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r18, com.google.android.gms.internal.mlkit_common.zzjd r19) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1342
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzhf.zzb(java.lang.Object, com.google.android.gms.internal.mlkit_common.zzjd):void");
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            throw new RuntimeException(a.t(a.K(a.q0(arrays, name.length() + a.q0(str, 40)), "Field ", str, " for ", name), " not found. Known fields are ", arrays));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.mlkit_common.zzht.zza(com.google.android.gms.internal.mlkit_common.zzip.zzf(r10, r6), com.google.android.gms.internal.mlkit_common.zzip.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.mlkit_common.zzip.zzb(r10, r6) == com.google.android.gms.internal.mlkit_common.zzip.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.mlkit_common.zzip.zza(r10, r6) == com.google.android.gms.internal.mlkit_common.zzip.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.mlkit_common.zzip.zzb(r10, r6) == com.google.android.gms.internal.mlkit_common.zzip.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.mlkit_common.zzip.zza(r10, r6) == com.google.android.gms.internal.mlkit_common.zzip.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.mlkit_common.zzip.zza(r10, r6) == com.google.android.gms.internal.mlkit_common.zzip.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.mlkit_common.zzip.zza(r10, r6) == com.google.android.gms.internal.mlkit_common.zzip.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.mlkit_common.zzht.zza(com.google.android.gms.internal.mlkit_common.zzip.zzf(r10, r6), com.google.android.gms.internal.mlkit_common.zzip.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.mlkit_common.zzht.zza(com.google.android.gms.internal.mlkit_common.zzip.zzf(r10, r6), com.google.android.gms.internal.mlkit_common.zzip.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.mlkit_common.zzht.zza(com.google.android.gms.internal.mlkit_common.zzip.zzf(r10, r6), com.google.android.gms.internal.mlkit_common.zzip.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.mlkit_common.zzip.zzc(r10, r6) == com.google.android.gms.internal.mlkit_common.zzip.zzc(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.mlkit_common.zzip.zza(r10, r6) == com.google.android.gms.internal.mlkit_common.zzip.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.mlkit_common.zzip.zzb(r10, r6) == com.google.android.gms.internal.mlkit_common.zzip.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.mlkit_common.zzip.zza(r10, r6) == com.google.android.gms.internal.mlkit_common.zzip.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.mlkit_common.zzip.zzb(r10, r6) == com.google.android.gms.internal.mlkit_common.zzip.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.mlkit_common.zzip.zzb(r10, r6) == com.google.android.gms.internal.mlkit_common.zzip.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.mlkit_common.zzip.zzd(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.mlkit_common.zzip.zzd(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.mlkit_common.zzip.zze(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.mlkit_common.zzip.zze(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.mlkit_common.zzht.zza(com.google.android.gms.internal.mlkit_common.zzip.zzf(r10, r6), com.google.android.gms.internal.mlkit_common.zzip.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    @Override // com.google.android.gms.internal.mlkit_common.zzhr
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(T r10, T r11) {
        /*
        // Method dump skipped, instructions count: 640
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzhf.zza(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzhr
    public final int zza(T t) {
        int i;
        int i2;
        int i3;
        int i4;
        int length = this.zzc.length;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6 += 3) {
            int zzc2 = zzc(i6);
            int i7 = this.zzc[i6];
            long j = (long) (1048575 & zzc2);
            int i8 = 37;
            switch ((zzc2 & 267386880) >>> 20) {
                case 0:
                    i2 = i5 * 53;
                    i = zzfs.zza(Double.doubleToLongBits(zzip.zze(t, j)));
                    i5 = i + i2;
                    break;
                case 1:
                    i2 = i5 * 53;
                    i = Float.floatToIntBits(zzip.zzd(t, j));
                    i5 = i + i2;
                    break;
                case 2:
                    i2 = i5 * 53;
                    i = zzfs.zza(zzip.zzb(t, j));
                    i5 = i + i2;
                    break;
                case 3:
                    i2 = i5 * 53;
                    i = zzfs.zza(zzip.zzb(t, j));
                    i5 = i + i2;
                    break;
                case 4:
                    i2 = i5 * 53;
                    i = zzip.zza(t, j);
                    i5 = i + i2;
                    break;
                case 5:
                    i2 = i5 * 53;
                    i = zzfs.zza(zzip.zzb(t, j));
                    i5 = i + i2;
                    break;
                case 6:
                    i2 = i5 * 53;
                    i = zzip.zza(t, j);
                    i5 = i + i2;
                    break;
                case 7:
                    i2 = i5 * 53;
                    i = zzfs.zza(zzip.zzc(t, j));
                    i5 = i + i2;
                    break;
                case 8:
                    i2 = i5 * 53;
                    i = ((String) zzip.zzf(t, j)).hashCode();
                    i5 = i + i2;
                    break;
                case 9:
                    Object zzf2 = zzip.zzf(t, j);
                    if (zzf2 != null) {
                        i8 = zzf2.hashCode();
                    }
                    i5 = (i5 * 53) + i8;
                    break;
                case 10:
                    i2 = i5 * 53;
                    i = zzip.zzf(t, j).hashCode();
                    i5 = i + i2;
                    break;
                case 11:
                    i2 = i5 * 53;
                    i = zzip.zza(t, j);
                    i5 = i + i2;
                    break;
                case 12:
                    i2 = i5 * 53;
                    i = zzip.zza(t, j);
                    i5 = i + i2;
                    break;
                case 13:
                    i2 = i5 * 53;
                    i = zzip.zza(t, j);
                    i5 = i + i2;
                    break;
                case 14:
                    i2 = i5 * 53;
                    i = zzfs.zza(zzip.zzb(t, j));
                    i5 = i + i2;
                    break;
                case 15:
                    i2 = i5 * 53;
                    i = zzip.zza(t, j);
                    i5 = i + i2;
                    break;
                case 16:
                    i2 = i5 * 53;
                    i = zzfs.zza(zzip.zzb(t, j));
                    i5 = i + i2;
                    break;
                case 17:
                    Object zzf3 = zzip.zzf(t, j);
                    if (zzf3 != null) {
                        i8 = zzf3.hashCode();
                    }
                    i5 = (i5 * 53) + i8;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i2 = i5 * 53;
                    i = zzip.zzf(t, j).hashCode();
                    i5 = i + i2;
                    break;
                case 50:
                    i2 = i5 * 53;
                    i = zzip.zzf(t, j).hashCode();
                    i5 = i + i2;
                    break;
                case 51:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzfs.zza(Double.doubleToLongBits(zzb(t, j)));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = Float.floatToIntBits(zzc(t, j));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzfs.zza(zze(t, j));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzfs.zza(zze(t, j));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zza(t, i7, i6)) {
                        i4 = i5 * 53;
                        i3 = zzd(t, j);
                        i5 = i4 + i3;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzfs.zza(zze(t, j));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zza(t, i7, i6)) {
                        i4 = i5 * 53;
                        i3 = zzd(t, j);
                        i5 = i4 + i3;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzfs.zza(zzf(t, j));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = ((String) zzip.zzf(t, j)).hashCode();
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzip.zzf(t, j).hashCode();
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzip.zzf(t, j).hashCode();
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zza(t, i7, i6)) {
                        i4 = i5 * 53;
                        i3 = zzd(t, j);
                        i5 = i4 + i3;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zza(t, i7, i6)) {
                        i4 = i5 * 53;
                        i3 = zzd(t, j);
                        i5 = i4 + i3;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zza(t, i7, i6)) {
                        i4 = i5 * 53;
                        i3 = zzd(t, j);
                        i5 = i4 + i3;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzfs.zza(zze(t, j));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zza(t, i7, i6)) {
                        i4 = i5 * 53;
                        i3 = zzd(t, j);
                        i5 = i4 + i3;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzfs.zza(zze(t, j));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzip.zzf(t, j).hashCode();
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = this.zzq.zza(t).hashCode() + (i5 * 53);
        return this.zzh ? (hashCode * 53) + this.zzr.zza((Object) t).hashCode() : hashCode;
    }

    private final void zza(T t, T t2, int i) {
        long zzc2 = (long) (zzc(i) & 1048575);
        if (zza((zzhf<T>) t2, i)) {
            Object zzf2 = zzip.zzf(t, zzc2);
            Object zzf3 = zzip.zzf(t2, zzc2);
            if (zzf2 != null && zzf3 != null) {
                zzip.zza(t, zzc2, zzfs.zza(zzf2, zzf3));
                zzb((zzhf<T>) t, i);
            } else if (zzf3 != null) {
                zzip.zza(t, zzc2, zzf3);
                zzb((zzhf<T>) t, i);
            }
        }
    }

    private static <UT, UB> int zza(zzij<UT, UB> zzij, T t) {
        return zzij.zzd(zzij.zza(t));
    }

    private static List<?> zza(Object obj, long j) {
        return (List) zzip.zzf(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0552  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2a  */
    @Override // com.google.android.gms.internal.mlkit_common.zzhr
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.mlkit_common.zzjd r15) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 2916
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzhf.zza(java.lang.Object, com.google.android.gms.internal.mlkit_common.zzjd):void");
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzhr
    public final void zzb(T t) {
        int i;
        int i2 = this.zzm;
        while (true) {
            i = this.zzn;
            if (i2 >= i) {
                break;
            }
            long zzc2 = (long) (zzc(this.zzl[i2]) & 1048575);
            Object zzf2 = zzip.zzf(t, zzc2);
            if (zzf2 != null) {
                zzip.zza(t, zzc2, this.zzs.zzb(zzf2));
            }
            i2++;
        }
        int length = this.zzl.length;
        while (i < length) {
            this.zzp.zza(t, (long) this.zzl[i]);
            i++;
        }
        this.zzq.zzb(t);
        if (this.zzh) {
            this.zzr.zzc(t);
        }
    }

    private static <T> double zzb(T t, long j) {
        return ((Double) zzip.zzf(t, j)).doubleValue();
    }

    private final void zzb(T t, int i) {
        int zzd2 = zzd(i);
        long j = (long) (1048575 & zzd2);
        if (j != 1048575) {
            zzip.zza((Object) t, j, (1 << (zzd2 >>> 20)) | zzip.zza(t, j));
        }
    }

    private final void zzb(T t, int i, int i2) {
        zzip.zza((Object) t, (long) (zzd(i2) & 1048575), i);
    }

    private final int zzd(int i) {
        return this.zzc[i + 2];
    }

    private static <T> int zzd(T t, long j) {
        return ((Integer) zzip.zzf(t, j)).intValue();
    }

    private final <K, V> void zza(zzjd zzjd, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzjd.zza(i, this.zzs.zzc(zzb(i2)), this.zzs.zza(obj));
        }
    }

    private static <UT, UB> void zza(zzij<UT, UB> zzij, T t, zzjd zzjd) throws IOException {
        zzij.zza(zzij.zza(t), zzjd);
    }

    private final zzhr zza(int i) {
        int i2 = (i / 3) << 1;
        zzhr zzhr = (zzhr) this.zzd[i2];
        if (zzhr != null) {
            return zzhr;
        }
        zzhr<T> zza2 = zzhm.zza().zza((Class) ((Class) this.zzd[i2 + 1]));
        this.zzd[i2] = zza2;
        return zza2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.android.gms.internal.mlkit_common.zzhr */
    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzhr zzhr) {
        return zzhr.zzc(zzip.zzf(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzjd zzjd) throws IOException {
        if (obj instanceof String) {
            zzjd.zza(i, (String) obj);
        } else {
            zzjd.zza(i, (zzep) obj);
        }
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zza((zzhf<T>) t, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zza(T t, int i) {
        int zzd2 = zzd(i);
        long j = (long) (zzd2 & 1048575);
        if (j == 1048575) {
            int zzc2 = zzc(i);
            long j2 = (long) (zzc2 & 1048575);
            switch ((zzc2 & 267386880) >>> 20) {
                case 0:
                    return zzip.zze(t, j2) != 0.0d;
                case 1:
                    return zzip.zzd(t, j2) != 0.0f;
                case 2:
                    return zzip.zzb(t, j2) != 0;
                case 3:
                    return zzip.zzb(t, j2) != 0;
                case 4:
                    return zzip.zza(t, j2) != 0;
                case 5:
                    return zzip.zzb(t, j2) != 0;
                case 6:
                    return zzip.zza(t, j2) != 0;
                case 7:
                    return zzip.zzc(t, j2);
                case 8:
                    Object zzf2 = zzip.zzf(t, j2);
                    if (zzf2 instanceof String) {
                        return !((String) zzf2).isEmpty();
                    }
                    if (zzf2 instanceof zzep) {
                        return !zzep.zza.equals(zzf2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzip.zzf(t, j2) != null;
                case 10:
                    return !zzep.zza.equals(zzip.zzf(t, j2));
                case 11:
                    return zzip.zza(t, j2) != 0;
                case 12:
                    return zzip.zza(t, j2) != 0;
                case 13:
                    return zzip.zza(t, j2) != 0;
                case 14:
                    return zzip.zzb(t, j2) != 0;
                case 15:
                    return zzip.zza(t, j2) != 0;
                case 16:
                    return zzip.zzb(t, j2) != 0;
                case 17:
                    return zzip.zzf(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zzip.zza(t, j) & (1 << (zzd2 >>> 20))) != 0;
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzip.zza(t, (long) (zzd(i2) & 1048575)) == i;
    }
}
