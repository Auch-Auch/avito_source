package com.google.android.gms.internal.measurement;

import a2.b.a.a.a;
import com.avito.android.saved_searches.SavedSearchView;
import com.google.android.gms.internal.measurement.zzib;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;
public final class zzjn<T> implements zzkc<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzla.zzc();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzjj zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzjr zzo;
    private final zzit zzp;
    private final zzku<?, ?> zzq;
    private final zzhq<?> zzr;
    private final zzjg zzs;

    private zzjn(int[] iArr, Object[] objArr, int i, int i2, zzjj zzjj, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzjr zzjr, zzit zzit, zzku<?, ?> zzku, zzhq<?> zzhq, zzjg zzjg) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzjj instanceof zzib;
        this.zzj = z;
        this.zzh = zzhq != null && zzhq.zza(zzjj);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzjr;
        this.zzp = zzit;
        this.zzq = zzku;
        this.zzr = zzhq;
        this.zzg = zzjj;
        this.zzs = zzjg;
    }

    public static <T> zzjn<T> zza(Class<T> cls, zzjh zzjh, zzjr zzjr, zzit zzit, zzku<?, ?> zzku, zzhq<?> zzhq, zzjg zzjg) {
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
        if (zzjh instanceof zzka) {
            zzka zzka = (zzka) zzjh;
            int i32 = 0;
            boolean z2 = zzka.zza() == zzib.zzf.zzi;
            String zzd2 = zzka.zzd();
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
            Object[] zze2 = zzka.zze();
            Class<?> cls2 = zzka.zzc().getClass();
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
            return new zzjn<>(iArr2, objArr2, i6, i5, zzka.zzc(), z2, false, iArr, i2, i62, zzjr, zzit, zzku, zzhq, zzjg);
        }
        ((zzkn) zzjh).zza();
        int i94 = zzib.zzf.zzi;
        throw new NoSuchMethodError();
    }

    private final zzif zzc(int i) {
        return (zzif) this.zzd[((i / 3) << 1) + 1];
    }

    private static zzkt zze(Object obj) {
        zzib zzib = (zzib) obj;
        zzkt zzkt = zzib.zzb;
        if (zzkt != zzkt.zza()) {
            return zzkt;
        }
        zzkt zzb2 = zzkt.zzb();
        zzib.zzb = zzb2;
        return zzb2;
    }

    private static boolean zzf(int i) {
        return (i & 536870912) != 0;
    }

    private static <T> boolean zzf(T t, long j) {
        return ((Boolean) zzla.zzf(t, j)).booleanValue();
    }

    private final int zzg(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, 0);
    }

    @Override // com.google.android.gms.internal.measurement.zzkc
    public final void zzb(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzd2 = zzd(i);
            long j = (long) (1048575 & zzd2);
            int i2 = this.zzc[i];
            switch ((zzd2 & 267386880) >>> 20) {
                case 0:
                    if (zza((zzjn<T>) t2, i)) {
                        zzla.zza(t, j, zzla.zze(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zza((zzjn<T>) t2, i)) {
                        zzla.zza((Object) t, j, zzla.zzd(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zza((zzjn<T>) t2, i)) {
                        zzla.zza((Object) t, j, zzla.zzb(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zza((zzjn<T>) t2, i)) {
                        zzla.zza((Object) t, j, zzla.zzb(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zza((zzjn<T>) t2, i)) {
                        zzla.zza((Object) t, j, zzla.zza(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zza((zzjn<T>) t2, i)) {
                        zzla.zza((Object) t, j, zzla.zzb(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zza((zzjn<T>) t2, i)) {
                        zzla.zza((Object) t, j, zzla.zza(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zza((zzjn<T>) t2, i)) {
                        zzla.zza(t, j, zzla.zzc(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zza((zzjn<T>) t2, i)) {
                        zzla.zza(t, j, zzla.zzf(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zza((zzjn<T>) t2, i)) {
                        zzla.zza(t, j, zzla.zzf(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zza((zzjn<T>) t2, i)) {
                        zzla.zza((Object) t, j, zzla.zza(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zza((zzjn<T>) t2, i)) {
                        zzla.zza((Object) t, j, zzla.zza(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zza((zzjn<T>) t2, i)) {
                        zzla.zza((Object) t, j, zzla.zza(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zza((zzjn<T>) t2, i)) {
                        zzla.zza((Object) t, j, zzla.zzb(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zza((zzjn<T>) t2, i)) {
                        zzla.zza((Object) t, j, zzla.zza(t2, j));
                        zzb((zzjn<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zza((zzjn<T>) t2, i)) {
                        zzla.zza((Object) t, j, zzla.zzb(t2, j));
                        zzb((zzjn<T>) t, i);
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
                    zzke.zza(this.zzs, t, t2, j);
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
                        zzla.zza(t, j, zzla.zzf(t2, j));
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
                        zzla.zza(t, j, zzla.zzf(t2, j));
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
        zzke.zza(this.zzq, t, t2);
        if (this.zzh) {
            zzke.zza(this.zzr, t, t2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.measurement.zzkc] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.google.android.gms.internal.measurement.zzkc] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.gms.internal.measurement.zzkc
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzd(T r19) {
        /*
        // Method dump skipped, instructions count: 320
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zzd(java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.measurement.zzkc
    public final void zzc(T t) {
        int i;
        int i2 = this.zzm;
        while (true) {
            i = this.zzn;
            if (i2 >= i) {
                break;
            }
            long zzd2 = (long) (zzd(this.zzl[i2]) & 1048575);
            Object zzf2 = zzla.zzf(t, zzd2);
            if (zzf2 != null) {
                zzla.zza(t, zzd2, this.zzs.zze(zzf2));
            }
            i2++;
        }
        int length = this.zzl.length;
        while (i < length) {
            this.zzp.zzb(t, (long) this.zzl[i]);
            i++;
        }
        this.zzq.zzd(t);
        if (this.zzh) {
            this.zzr.zzc(t);
        }
    }

    private final int zze(int i) {
        return this.zzc[i + 2];
    }

    private static <T> long zze(T t, long j) {
        return ((Long) zzla.zzf(t, j)).longValue();
    }

    private static <T> float zzc(T t, long j) {
        return ((Float) zzla.zzf(t, j)).floatValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final int zzd(int i) {
        return this.zzc[i + 1];
    }

    private static <T> int zzd(T t, long j) {
        return ((Integer) zzla.zzf(t, j)).intValue();
    }

    private final void zzb(T t, T t2, int i) {
        int zzd2 = zzd(i);
        int i2 = this.zzc[i];
        long j = (long) (zzd2 & 1048575);
        if (zza(t2, i2, i)) {
            Object zzf2 = zzla.zzf(t, j);
            Object zzf3 = zzla.zzf(t2, j);
            if (zzf2 != null && zzf3 != null) {
                zzla.zza(t, j, zzie.zza(zzf2, zzf3));
                zzb(t, i2, i);
            } else if (zzf3 != null) {
                zzla.zza(t, j, zzf3);
                zzb(t, i2, i);
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.measurement.zzkc
    public final int zzb(T t) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14 = 267386880;
        int i15 = 1048575;
        if (this.zzj) {
            Unsafe unsafe = zzb;
            int i16 = 0;
            int i17 = 0;
            while (i16 < this.zzc.length) {
                int zzd2 = zzd(i16);
                int i18 = (i14 & zzd2) >>> 20;
                int i19 = this.zzc[i16];
                long j = (long) (zzd2 & 1048575);
                int i20 = (i18 < zzhw.DOUBLE_LIST_PACKED.zza() || i18 > zzhw.SINT64_LIST_PACKED.zza()) ? 0 : this.zzc[i16 + 2] & 1048575;
                switch (i18) {
                    case 0:
                        if (zza((zzjn<T>) t, i16)) {
                            i10 = zzhi.zzb(i19, 0.0d);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zza((zzjn<T>) t, i16)) {
                            i10 = zzhi.zzb(i19, 0.0f);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zza((zzjn<T>) t, i16)) {
                            i10 = zzhi.zzd(i19, zzla.zzb(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zza((zzjn<T>) t, i16)) {
                            i10 = zzhi.zze(i19, zzla.zzb(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zza((zzjn<T>) t, i16)) {
                            i10 = zzhi.zzf(i19, zzla.zza(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zza((zzjn<T>) t, i16)) {
                            i10 = zzhi.zzg(i19, 0L);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zza((zzjn<T>) t, i16)) {
                            i10 = zzhi.zzi(i19, 0);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zza((zzjn<T>) t, i16)) {
                            i10 = zzhi.zzb(i19, true);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zza((zzjn<T>) t, i16)) {
                            Object zzf2 = zzla.zzf(t, j);
                            if (zzf2 instanceof zzgt) {
                                i10 = zzhi.zzc(i19, (zzgt) zzf2);
                            } else {
                                i10 = zzhi.zzb(i19, (String) zzf2);
                            }
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (zza((zzjn<T>) t, i16)) {
                            i10 = zzke.zza(i19, zzla.zzf(t, j), zza(i16));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zza((zzjn<T>) t, i16)) {
                            i10 = zzhi.zzc(i19, (zzgt) zzla.zzf(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zza((zzjn<T>) t, i16)) {
                            i10 = zzhi.zzg(i19, zzla.zza(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zza((zzjn<T>) t, i16)) {
                            i10 = zzhi.zzk(i19, zzla.zza(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zza((zzjn<T>) t, i16)) {
                            i10 = zzhi.zzj(i19, 0);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zza((zzjn<T>) t, i16)) {
                            i10 = zzhi.zzh(i19, 0L);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zza((zzjn<T>) t, i16)) {
                            i10 = zzhi.zzh(i19, zzla.zza(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zza((zzjn<T>) t, i16)) {
                            i10 = zzhi.zzf(i19, zzla.zzb(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zza((zzjn<T>) t, i16)) {
                            i10 = zzhi.zzc(i19, (zzjj) zzla.zzf(t, j), zza(i16));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        i10 = zzke.zzi(i19, zza(t, j), false);
                        i17 += i10;
                        break;
                    case 19:
                        i10 = zzke.zzh(i19, zza(t, j), false);
                        i17 += i10;
                        break;
                    case 20:
                        i10 = zzke.zza(i19, (List<Long>) zza(t, j), false);
                        i17 += i10;
                        break;
                    case 21:
                        i10 = zzke.zzb(i19, (List<Long>) zza(t, j), false);
                        i17 += i10;
                        break;
                    case 22:
                        i10 = zzke.zze(i19, zza(t, j), false);
                        i17 += i10;
                        break;
                    case 23:
                        i10 = zzke.zzi(i19, zza(t, j), false);
                        i17 += i10;
                        break;
                    case 24:
                        i10 = zzke.zzh(i19, zza(t, j), false);
                        i17 += i10;
                        break;
                    case 25:
                        i10 = zzke.zzj(i19, zza(t, j), false);
                        i17 += i10;
                        break;
                    case 26:
                        i10 = zzke.zza(i19, zza(t, j));
                        i17 += i10;
                        break;
                    case 27:
                        i10 = zzke.zza(i19, zza(t, j), zza(i16));
                        i17 += i10;
                        break;
                    case 28:
                        i10 = zzke.zzb(i19, zza(t, j));
                        i17 += i10;
                        break;
                    case 29:
                        i10 = zzke.zzf(i19, zza(t, j), false);
                        i17 += i10;
                        break;
                    case 30:
                        i10 = zzke.zzd(i19, zza(t, j), false);
                        i17 += i10;
                        break;
                    case 31:
                        i10 = zzke.zzh(i19, zza(t, j), false);
                        i17 += i10;
                        break;
                    case 32:
                        i10 = zzke.zzi(i19, zza(t, j), false);
                        i17 += i10;
                        break;
                    case 33:
                        i10 = zzke.zzg(i19, zza(t, j), false);
                        i17 += i10;
                        break;
                    case 34:
                        i10 = zzke.zzc(i19, zza(t, j), false);
                        i17 += i10;
                        break;
                    case 35:
                        i13 = zzke.zzi((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzhi.zze(i19);
                            i11 = zzhi.zzg(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 36:
                        i13 = zzke.zzh((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzhi.zze(i19);
                            i11 = zzhi.zzg(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 37:
                        i13 = zzke.zza((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzhi.zze(i19);
                            i11 = zzhi.zzg(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 38:
                        i13 = zzke.zzb((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzhi.zze(i19);
                            i11 = zzhi.zzg(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 39:
                        i13 = zzke.zze((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzhi.zze(i19);
                            i11 = zzhi.zzg(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 40:
                        i13 = zzke.zzi((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzhi.zze(i19);
                            i11 = zzhi.zzg(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 41:
                        i13 = zzke.zzh((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzhi.zze(i19);
                            i11 = zzhi.zzg(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 42:
                        i13 = zzke.zzj((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzhi.zze(i19);
                            i11 = zzhi.zzg(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 43:
                        i13 = zzke.zzf((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzhi.zze(i19);
                            i11 = zzhi.zzg(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 44:
                        i13 = zzke.zzd((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzhi.zze(i19);
                            i11 = zzhi.zzg(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 45:
                        i13 = zzke.zzh((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzhi.zze(i19);
                            i11 = zzhi.zzg(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 46:
                        i13 = zzke.zzi((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzhi.zze(i19);
                            i11 = zzhi.zzg(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 47:
                        i13 = zzke.zzg((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzhi.zze(i19);
                            i11 = zzhi.zzg(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 48:
                        i13 = zzke.zzc((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zzk) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzhi.zze(i19);
                            i11 = zzhi.zzg(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 49:
                        i10 = zzke.zzb(i19, (List<zzjj>) zza(t, j), zza(i16));
                        i17 += i10;
                        break;
                    case 50:
                        i10 = this.zzs.zza(i19, zzla.zzf(t, j), zzb(i16));
                        i17 += i10;
                        break;
                    case 51:
                        if (zza(t, i19, i16)) {
                            i10 = zzhi.zzb(i19, 0.0d);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zza(t, i19, i16)) {
                            i10 = zzhi.zzb(i19, 0.0f);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zza(t, i19, i16)) {
                            i10 = zzhi.zzd(i19, zze(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zza(t, i19, i16)) {
                            i10 = zzhi.zze(i19, zze(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zza(t, i19, i16)) {
                            i10 = zzhi.zzf(i19, zzd(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zza(t, i19, i16)) {
                            i10 = zzhi.zzg(i19, 0L);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zza(t, i19, i16)) {
                            i10 = zzhi.zzi(i19, 0);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zza(t, i19, i16)) {
                            i10 = zzhi.zzb(i19, true);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zza(t, i19, i16)) {
                            Object zzf3 = zzla.zzf(t, j);
                            if (zzf3 instanceof zzgt) {
                                i10 = zzhi.zzc(i19, (zzgt) zzf3);
                            } else {
                                i10 = zzhi.zzb(i19, (String) zzf3);
                            }
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (zza(t, i19, i16)) {
                            i10 = zzke.zza(i19, zzla.zzf(t, j), zza(i16));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zza(t, i19, i16)) {
                            i10 = zzhi.zzc(i19, (zzgt) zzla.zzf(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zza(t, i19, i16)) {
                            i10 = zzhi.zzg(i19, zzd(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zza(t, i19, i16)) {
                            i10 = zzhi.zzk(i19, zzd(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zza(t, i19, i16)) {
                            i10 = zzhi.zzj(i19, 0);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zza(t, i19, i16)) {
                            i10 = zzhi.zzh(i19, 0L);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zza(t, i19, i16)) {
                            i10 = zzhi.zzh(i19, zzd(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zza(t, i19, i16)) {
                            i10 = zzhi.zzf(i19, zze(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zza(t, i19, i16)) {
                            i10 = zzhi.zzc(i19, (zzjj) zzla.zzf(t, j), zza(i16));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                }
                i16 += 3;
                i14 = 267386880;
            }
            return i17 + zza((zzku) this.zzq, (Object) t);
        }
        Unsafe unsafe2 = zzb;
        int i21 = 0;
        int i22 = 0;
        int i23 = 1048575;
        int i24 = 0;
        while (i21 < this.zzc.length) {
            int zzd3 = zzd(i21);
            int[] iArr = this.zzc;
            int i25 = iArr[i21];
            int i26 = (267386880 & zzd3) >>> 20;
            if (i26 <= 17) {
                i2 = iArr[i21 + 2];
                int i27 = i2 & i15;
                i = 1 << (i2 >>> 20);
                if (i27 != i23) {
                    i24 = unsafe2.getInt(t, (long) i27);
                    i23 = i27;
                }
            } else {
                i2 = (!this.zzk || i26 < zzhw.DOUBLE_LIST_PACKED.zza() || i26 > zzhw.SINT64_LIST_PACKED.zza()) ? 0 : this.zzc[i21 + 2] & i15;
                i = 0;
            }
            long j2 = (long) (zzd3 & i15);
            switch (i26) {
                case 0:
                    if ((i24 & i) != 0) {
                        i4 = zzhi.zzb(i25, 0.0d);
                        i3 = i4 + i22;
                        i22 = i3;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i24 & i) != 0) {
                        i22 += zzhi.zzb(i25, 0.0f);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((i24 & i) != 0) {
                        i5 = zzhi.zzd(i25, unsafe2.getLong(t, j2));
                        i22 += i5;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i24 & i) != 0) {
                        i5 = zzhi.zze(i25, unsafe2.getLong(t, j2));
                        i22 += i5;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i24 & i) != 0) {
                        i5 = zzhi.zzf(i25, unsafe2.getInt(t, j2));
                        i22 += i5;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i24 & i) != 0) {
                        i5 = zzhi.zzg(i25, 0L);
                        i22 += i5;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((i24 & i) != 0) {
                        i4 = zzhi.zzi(i25, 0);
                        i3 = i4 + i22;
                        i22 = i3;
                        break;
                    }
                    i3 = i22;
                    i22 = i3;
                case 7:
                    if ((i24 & i) != 0) {
                        i6 = zzhi.zzb(i25, true);
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 8:
                    if ((i24 & i) != 0) {
                        Object object = unsafe2.getObject(t, j2);
                        if (object instanceof zzgt) {
                            i6 = zzhi.zzc(i25, (zzgt) object);
                        } else {
                            i6 = zzhi.zzb(i25, (String) object);
                        }
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 9:
                    if ((i24 & i) != 0) {
                        i6 = zzke.zza(i25, unsafe2.getObject(t, j2), zza(i21));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 10:
                    if ((i24 & i) != 0) {
                        i6 = zzhi.zzc(i25, (zzgt) unsafe2.getObject(t, j2));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 11:
                    if ((i24 & i) != 0) {
                        i6 = zzhi.zzg(i25, unsafe2.getInt(t, j2));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 12:
                    if ((i24 & i) != 0) {
                        i6 = zzhi.zzk(i25, unsafe2.getInt(t, j2));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 13:
                    if ((i24 & i) != 0) {
                        i6 = zzhi.zzj(i25, 0);
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 14:
                    if ((i24 & i) != 0) {
                        i6 = zzhi.zzh(i25, 0L);
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 15:
                    if ((i24 & i) != 0) {
                        i6 = zzhi.zzh(i25, unsafe2.getInt(t, j2));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 16:
                    if ((i24 & i) != 0) {
                        i6 = zzhi.zzf(i25, unsafe2.getLong(t, j2));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 17:
                    if ((i24 & i) != 0) {
                        i6 = zzhi.zzc(i25, (zzjj) unsafe2.getObject(t, j2), zza(i21));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 18:
                    i6 = zzke.zzi(i25, (List) unsafe2.getObject(t, j2), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 19:
                    i6 = zzke.zzh(i25, (List) unsafe2.getObject(t, j2), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 20:
                    i6 = zzke.zza(i25, (List<Long>) ((List) unsafe2.getObject(t, j2)), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 21:
                    i6 = zzke.zzb(i25, (List<Long>) ((List) unsafe2.getObject(t, j2)), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 22:
                    i6 = zzke.zze(i25, (List) unsafe2.getObject(t, j2), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 23:
                    i6 = zzke.zzi(i25, (List) unsafe2.getObject(t, j2), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 24:
                    i6 = zzke.zzh(i25, (List) unsafe2.getObject(t, j2), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 25:
                    i6 = zzke.zzj(i25, (List) unsafe2.getObject(t, j2), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 26:
                    i6 = zzke.zza(i25, (List) unsafe2.getObject(t, j2));
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 27:
                    i6 = zzke.zza(i25, (List<?>) ((List) unsafe2.getObject(t, j2)), zza(i21));
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 28:
                    i6 = zzke.zzb(i25, (List) unsafe2.getObject(t, j2));
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 29:
                    i6 = zzke.zzf(i25, (List) unsafe2.getObject(t, j2), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 30:
                    i6 = zzke.zzd(i25, (List) unsafe2.getObject(t, j2), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 31:
                    i6 = zzke.zzh(i25, (List) unsafe2.getObject(t, j2), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 32:
                    i6 = zzke.zzi(i25, (List) unsafe2.getObject(t, j2), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 33:
                    i6 = zzke.zzg(i25, (List) unsafe2.getObject(t, j2), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 34:
                    i6 = zzke.zzc(i25, (List) unsafe2.getObject(t, j2), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 35:
                    i9 = zzke.zzi((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzhi.zze(i25);
                        i7 = zzhi.zzg(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 36:
                    i9 = zzke.zzh((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzhi.zze(i25);
                        i7 = zzhi.zzg(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 37:
                    i9 = zzke.zza((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzhi.zze(i25);
                        i7 = zzhi.zzg(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 38:
                    i9 = zzke.zzb((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzhi.zze(i25);
                        i7 = zzhi.zzg(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 39:
                    i9 = zzke.zze((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzhi.zze(i25);
                        i7 = zzhi.zzg(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 40:
                    i9 = zzke.zzi((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzhi.zze(i25);
                        i7 = zzhi.zzg(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 41:
                    i9 = zzke.zzh((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzhi.zze(i25);
                        i7 = zzhi.zzg(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 42:
                    i9 = zzke.zzj((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzhi.zze(i25);
                        i7 = zzhi.zzg(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 43:
                    i9 = zzke.zzf((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzhi.zze(i25);
                        i7 = zzhi.zzg(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 44:
                    i9 = zzke.zzd((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzhi.zze(i25);
                        i7 = zzhi.zzg(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 45:
                    i9 = zzke.zzh((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzhi.zze(i25);
                        i7 = zzhi.zzg(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 46:
                    i9 = zzke.zzi((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzhi.zze(i25);
                        i7 = zzhi.zzg(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 47:
                    i9 = zzke.zzg((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzhi.zze(i25);
                        i7 = zzhi.zzg(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 48:
                    i9 = zzke.zzc((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzhi.zze(i25);
                        i7 = zzhi.zzg(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 49:
                    i6 = zzke.zzb(i25, (List) unsafe2.getObject(t, j2), zza(i21));
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 50:
                    i6 = this.zzs.zza(i25, unsafe2.getObject(t, j2), zzb(i21));
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 51:
                    if (zza(t, i25, i21)) {
                        i6 = zzhi.zzb(i25, 0.0d);
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 52:
                    if (zza(t, i25, i21)) {
                        i6 = zzhi.zzb(i25, 0.0f);
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 53:
                    if (zza(t, i25, i21)) {
                        i6 = zzhi.zzd(i25, zze(t, j2));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 54:
                    if (zza(t, i25, i21)) {
                        i6 = zzhi.zze(i25, zze(t, j2));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 55:
                    if (zza(t, i25, i21)) {
                        i6 = zzhi.zzf(i25, zzd(t, j2));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 56:
                    if (zza(t, i25, i21)) {
                        i6 = zzhi.zzg(i25, 0L);
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 57:
                    if (zza(t, i25, i21)) {
                        i6 = zzhi.zzi(i25, 0);
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 58:
                    if (zza(t, i25, i21)) {
                        i6 = zzhi.zzb(i25, true);
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 59:
                    if (zza(t, i25, i21)) {
                        Object object2 = unsafe2.getObject(t, j2);
                        if (object2 instanceof zzgt) {
                            i6 = zzhi.zzc(i25, (zzgt) object2);
                        } else {
                            i6 = zzhi.zzb(i25, (String) object2);
                        }
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 60:
                    if (zza(t, i25, i21)) {
                        i6 = zzke.zza(i25, unsafe2.getObject(t, j2), zza(i21));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 61:
                    if (zza(t, i25, i21)) {
                        i6 = zzhi.zzc(i25, (zzgt) unsafe2.getObject(t, j2));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 62:
                    if (zza(t, i25, i21)) {
                        i6 = zzhi.zzg(i25, zzd(t, j2));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 63:
                    if (zza(t, i25, i21)) {
                        i6 = zzhi.zzk(i25, zzd(t, j2));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 64:
                    if (zza(t, i25, i21)) {
                        i6 = zzhi.zzj(i25, 0);
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 65:
                    if (zza(t, i25, i21)) {
                        i6 = zzhi.zzh(i25, 0L);
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 66:
                    if (zza(t, i25, i21)) {
                        i6 = zzhi.zzh(i25, zzd(t, j2));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 67:
                    if (zza(t, i25, i21)) {
                        i6 = zzhi.zzf(i25, zze(t, j2));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 68:
                    if (zza(t, i25, i21)) {
                        i6 = zzhi.zzc(i25, (zzjj) unsafe2.getObject(t, j2), zza(i21));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                default:
                    i3 = i22;
                    i22 = i3;
                    break;
            }
            i21 += 3;
            i23 = i23;
            i15 = 1048575;
        }
        int i28 = 0;
        int zza2 = i22 + zza((zzku) this.zzq, (Object) t);
        if (!this.zzh) {
            return zza2;
        }
        zzhr<?> zza3 = this.zzr.zza((Object) t);
        for (int i29 = 0; i29 < zza3.zza.zzc(); i29++) {
            Map.Entry<T, Object> zzb2 = zza3.zza.zzb(i29);
            i28 += zzhr.zza((zzht<?>) zzb2.getKey(), zzb2.getValue());
        }
        for (Map.Entry<T, Object> entry : zza3.zza.zzd()) {
            i28 += zzhr.zza((zzht<?>) entry.getKey(), entry.getValue());
        }
        return zza2 + i28;
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

    @Override // com.google.android.gms.internal.measurement.zzkc
    public final T zza() {
        return (T) this.zzo.zza(this.zzg);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.measurement.zzke.zza(com.google.android.gms.internal.measurement.zzla.zzf(r10, r6), com.google.android.gms.internal.measurement.zzla.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.measurement.zzla.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzla.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.measurement.zzla.zza(r10, r6) == com.google.android.gms.internal.measurement.zzla.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.measurement.zzla.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzla.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.measurement.zzla.zza(r10, r6) == com.google.android.gms.internal.measurement.zzla.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.measurement.zzla.zza(r10, r6) == com.google.android.gms.internal.measurement.zzla.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.measurement.zzla.zza(r10, r6) == com.google.android.gms.internal.measurement.zzla.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.measurement.zzke.zza(com.google.android.gms.internal.measurement.zzla.zzf(r10, r6), com.google.android.gms.internal.measurement.zzla.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.measurement.zzke.zza(com.google.android.gms.internal.measurement.zzla.zzf(r10, r6), com.google.android.gms.internal.measurement.zzla.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.measurement.zzke.zza(com.google.android.gms.internal.measurement.zzla.zzf(r10, r6), com.google.android.gms.internal.measurement.zzla.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.measurement.zzla.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzla.zzc(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.measurement.zzla.zza(r10, r6) == com.google.android.gms.internal.measurement.zzla.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.measurement.zzla.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzla.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.measurement.zzla.zza(r10, r6) == com.google.android.gms.internal.measurement.zzla.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.measurement.zzla.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzla.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.measurement.zzla.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzla.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzla.zzd(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzla.zzd(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzla.zze(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzla.zze(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.measurement.zzke.zza(com.google.android.gms.internal.measurement.zzla.zzf(r10, r6), com.google.android.gms.internal.measurement.zzla.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    @Override // com.google.android.gms.internal.measurement.zzkc
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(T r10, T r11) {
        /*
        // Method dump skipped, instructions count: 640
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.measurement.zzkc
    public final int zza(T t) {
        int i;
        int i2;
        int i3;
        int i4;
        int length = this.zzc.length;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6 += 3) {
            int zzd2 = zzd(i6);
            int i7 = this.zzc[i6];
            long j = (long) (1048575 & zzd2);
            int i8 = 37;
            switch ((zzd2 & 267386880) >>> 20) {
                case 0:
                    i2 = i5 * 53;
                    i = zzie.zza(Double.doubleToLongBits(zzla.zze(t, j)));
                    i5 = i + i2;
                    break;
                case 1:
                    i2 = i5 * 53;
                    i = Float.floatToIntBits(zzla.zzd(t, j));
                    i5 = i + i2;
                    break;
                case 2:
                    i2 = i5 * 53;
                    i = zzie.zza(zzla.zzb(t, j));
                    i5 = i + i2;
                    break;
                case 3:
                    i2 = i5 * 53;
                    i = zzie.zza(zzla.zzb(t, j));
                    i5 = i + i2;
                    break;
                case 4:
                    i2 = i5 * 53;
                    i = zzla.zza(t, j);
                    i5 = i + i2;
                    break;
                case 5:
                    i2 = i5 * 53;
                    i = zzie.zza(zzla.zzb(t, j));
                    i5 = i + i2;
                    break;
                case 6:
                    i2 = i5 * 53;
                    i = zzla.zza(t, j);
                    i5 = i + i2;
                    break;
                case 7:
                    i2 = i5 * 53;
                    i = zzie.zza(zzla.zzc(t, j));
                    i5 = i + i2;
                    break;
                case 8:
                    i2 = i5 * 53;
                    i = ((String) zzla.zzf(t, j)).hashCode();
                    i5 = i + i2;
                    break;
                case 9:
                    Object zzf2 = zzla.zzf(t, j);
                    if (zzf2 != null) {
                        i8 = zzf2.hashCode();
                    }
                    i5 = (i5 * 53) + i8;
                    break;
                case 10:
                    i2 = i5 * 53;
                    i = zzla.zzf(t, j).hashCode();
                    i5 = i + i2;
                    break;
                case 11:
                    i2 = i5 * 53;
                    i = zzla.zza(t, j);
                    i5 = i + i2;
                    break;
                case 12:
                    i2 = i5 * 53;
                    i = zzla.zza(t, j);
                    i5 = i + i2;
                    break;
                case 13:
                    i2 = i5 * 53;
                    i = zzla.zza(t, j);
                    i5 = i + i2;
                    break;
                case 14:
                    i2 = i5 * 53;
                    i = zzie.zza(zzla.zzb(t, j));
                    i5 = i + i2;
                    break;
                case 15:
                    i2 = i5 * 53;
                    i = zzla.zza(t, j);
                    i5 = i + i2;
                    break;
                case 16:
                    i2 = i5 * 53;
                    i = zzie.zza(zzla.zzb(t, j));
                    i5 = i + i2;
                    break;
                case 17:
                    Object zzf3 = zzla.zzf(t, j);
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
                    i = zzla.zzf(t, j).hashCode();
                    i5 = i + i2;
                    break;
                case 50:
                    i2 = i5 * 53;
                    i = zzla.zzf(t, j).hashCode();
                    i5 = i + i2;
                    break;
                case 51:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzie.zza(Double.doubleToLongBits(zzb(t, j)));
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
                        i = zzie.zza(zze(t, j));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzie.zza(zze(t, j));
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
                        i = zzie.zza(zze(t, j));
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
                        i = zzie.zza(zzf(t, j));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = ((String) zzla.zzf(t, j)).hashCode();
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzla.zzf(t, j).hashCode();
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzla.zzf(t, j).hashCode();
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
                        i = zzie.zza(zze(t, j));
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
                        i = zzie.zza(zze(t, j));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzla.zzf(t, j).hashCode();
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = this.zzq.zzb(t).hashCode() + (i5 * 53);
        return this.zzh ? (hashCode * 53) + this.zzr.zza((Object) t).hashCode() : hashCode;
    }

    private final void zza(T t, T t2, int i) {
        long zzd2 = (long) (zzd(i) & 1048575);
        if (zza((zzjn<T>) t2, i)) {
            Object zzf2 = zzla.zzf(t, zzd2);
            Object zzf3 = zzla.zzf(t2, zzd2);
            if (zzf2 != null && zzf3 != null) {
                zzla.zza(t, zzd2, zzie.zza(zzf2, zzf3));
                zzb((zzjn<T>) t, i);
            } else if (zzf3 != null) {
                zzla.zza(t, zzd2, zzf3);
                zzb((zzjn<T>) t, i);
            }
        }
    }

    private static <UT, UB> int zza(zzku<UT, UB> zzku, T t) {
        return zzku.zzf(zzku.zzb(t));
    }

    private static List<?> zza(Object obj, long j) {
        return (List) zzla.zzf(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0552  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2a  */
    @Override // com.google.android.gms.internal.measurement.zzkc
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.measurement.zzln r15) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 2916
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzln):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:170:0x0495  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r18, com.google.android.gms.internal.measurement.zzln r19) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1342
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zzb(java.lang.Object, com.google.android.gms.internal.measurement.zzln):void");
    }

    private final <K, V> void zza(zzln zzln, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzln.zza(i, this.zzs.zzb(zzb(i2)), this.zzs.zzc(obj));
        }
    }

    private static <UT, UB> void zza(zzku<UT, UB> zzku, T t, zzln zzln) throws IOException {
        zzku.zza(zzku.zzb(t), zzln);
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    @Override // com.google.android.gms.internal.measurement.zzkc
    public final void zza(T r13, com.google.android.gms.internal.measurement.zzjz r14, com.google.android.gms.internal.measurement.zzho r15) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1646
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzjz, com.google.android.gms.internal.measurement.zzho):void");
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private static <T> double zzb(T t, long j) {
        return ((Double) zzla.zzf(t, j)).doubleValue();
    }

    private final void zzb(T t, int i) {
        int zze2 = zze(i);
        long j = (long) (1048575 & zze2);
        if (j != 1048575) {
            zzla.zza((Object) t, j, (1 << (zze2 >>> 20)) | zzla.zza(t, j));
        }
    }

    private final void zzb(T t, int i, int i2) {
        zzla.zza((Object) t, (long) (zze(i2) & 1048575), i);
    }

    private final int zzb(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zza(byte[] bArr, int i, int i2, zzlh zzlh, Class<?> cls, zzgo zzgo) throws IOException {
        switch (zzjq.zza[zzlh.ordinal()]) {
            case 1:
                int zzb2 = zzgp.zzb(bArr, i, zzgo);
                zzgo.zzc = Boolean.valueOf(zzgo.zzb != 0);
                return zzb2;
            case 2:
                return zzgp.zze(bArr, i, zzgo);
            case 3:
                zzgo.zzc = Double.valueOf(zzgp.zzc(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzgo.zzc = Integer.valueOf(zzgp.zza(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzgo.zzc = Long.valueOf(zzgp.zzb(bArr, i));
                return i + 8;
            case 8:
                zzgo.zzc = Float.valueOf(zzgp.zzd(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int zza2 = zzgp.zza(bArr, i, zzgo);
                zzgo.zzc = Integer.valueOf(zzgo.zza);
                return zza2;
            case 12:
            case 13:
                int zzb3 = zzgp.zzb(bArr, i, zzgo);
                zzgo.zzc = Long.valueOf(zzgo.zzb);
                return zzb3;
            case 14:
                return zzgp.zza(zzjy.zza().zza((Class) cls), bArr, i, i2, zzgo);
            case 15:
                int zza3 = zzgp.zza(bArr, i, zzgo);
                zzgo.zzc = Integer.valueOf(zzhf.zze(zzgo.zza));
                return zza3;
            case 16:
                int zzb4 = zzgp.zzb(bArr, i, zzgo);
                zzgo.zzc = Long.valueOf(zzhf.zza(zzgo.zzb));
                return zzb4;
            case 17:
                return zzgp.zzd(bArr, i, zzgo);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x041f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x041f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01e8  */
    private final int zza(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.measurement.zzgo r29) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1126
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.zzgo):int");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x003e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x003e */
    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, long j, zzgo zzgo) throws IOException {
        Unsafe unsafe = zzb;
        Object zzb2 = zzb(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zzs.zzd(object)) {
            Object zzf2 = this.zzs.zzf(zzb2);
            this.zzs.zza(zzf2, object);
            unsafe.putObject(t, j, zzf2);
            object = zzf2;
        }
        zzje<?, ?> zzb3 = this.zzs.zzb(zzb2);
        Map<?, ?> zza2 = this.zzs.zza(object);
        int zza3 = zzgp.zza(bArr, i, zzgo);
        int i4 = zzgo.zza;
        if (i4 < 0 || i4 > i2 - zza3) {
            throw zzij.zza();
        }
        int i5 = i4 + zza3;
        SavedSearchView.DefaultImpls defaultImpls = (K) zzb3.zzb;
        SavedSearchView.DefaultImpls defaultImpls2 = (V) zzb3.zzd;
        while (zza3 < i5) {
            int i6 = zza3 + 1;
            byte b = bArr[zza3];
            int i7 = b;
            if (b < 0) {
                i6 = zzgp.zza(b, bArr, i6, zzgo);
                i7 = zzgo.zza;
            }
            int i8 = (i7 == 1 ? 1 : 0) >>> 3;
            int i9 = (i7 == 1 ? 1 : 0) & 7;
            if (i8 != 1) {
                if (i8 == 2 && i9 == zzb3.zzc.zzb()) {
                    zza3 = zza(bArr, i6, i2, zzb3.zzc, zzb3.zzd.getClass(), zzgo);
                    defaultImpls2 = (V) zzgo.zzc;
                }
            } else if (i9 == zzb3.zza.zzb()) {
                zza3 = zza(bArr, i6, i2, zzb3.zza, (Class<?>) null, zzgo);
                defaultImpls = (K) zzgo.zzc;
            }
            zza3 = zzgp.zza(i7, bArr, i6, i2, zzgo);
        }
        if (zza3 == i5) {
            zza2.put(defaultImpls, defaultImpls2);
            return i5;
        }
        throw zzij.zzg();
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzgo zzgo) throws IOException {
        int i9;
        Unsafe unsafe = zzb;
        long j2 = (long) (this.zzc[i8 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(zzgp.zzc(bArr, i)));
                    i9 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(zzgp.zzd(bArr, i)));
                    i9 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    i9 = zzgp.zzb(bArr, i, zzgo);
                    unsafe.putObject(t, j, Long.valueOf(zzgo.zzb));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    i9 = zzgp.zza(bArr, i, zzgo);
                    unsafe.putObject(t, j, Integer.valueOf(zzgo.zza));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(zzgp.zzb(bArr, i)));
                    i9 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(zzgp.zza(bArr, i)));
                    i9 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    i9 = zzgp.zzb(bArr, i, zzgo);
                    unsafe.putObject(t, j, Boolean.valueOf(zzgo.zzb != 0));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    int zza2 = zzgp.zza(bArr, i, zzgo);
                    int i10 = zzgo.zza;
                    if (i10 == 0) {
                        unsafe.putObject(t, j, "");
                    } else if ((i6 & 536870912) == 0 || zzlc.zza(bArr, zza2, zza2 + i10)) {
                        unsafe.putObject(t, j, new String(bArr, zza2, i10, zzie.zza));
                        zza2 += i10;
                    } else {
                        throw zzij.zzh();
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza2;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    int zza3 = zzgp.zza(zza(i8), bArr, i, i2, zzgo);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, zzgo.zzc);
                    } else {
                        unsafe.putObject(t, j, zzie.zza(object, zzgo.zzc));
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza3;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    i9 = zzgp.zze(bArr, i, zzgo);
                    unsafe.putObject(t, j, zzgo.zzc);
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int zza4 = zzgp.zza(bArr, i, zzgo);
                    int i11 = zzgo.zza;
                    zzif zzc2 = zzc(i8);
                    if (zzc2 == null || zzc2.zza(i11)) {
                        unsafe.putObject(t, j, Integer.valueOf(i11));
                        i9 = zza4;
                        unsafe.putInt(t, j2, i4);
                        return i9;
                    }
                    zze(t).zza(i3, Long.valueOf((long) i11));
                    return zza4;
                }
                return i;
            case 66:
                if (i5 == 0) {
                    i9 = zzgp.zza(bArr, i, zzgo);
                    unsafe.putObject(t, j, Integer.valueOf(zzhf.zze(zzgo.zza)));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    i9 = zzgp.zzb(bArr, i, zzgo);
                    unsafe.putObject(t, j, Long.valueOf(zzhf.zza(zzgo.zzb)));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    i9 = zzgp.zza(zza(i8), bArr, i, i2, (i3 & -8) | 4, zzgo);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, zzgo.zzc);
                    } else {
                        unsafe.putObject(t, j, zzie.zza(object2, zzgo.zzc));
                    }
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            default:
                return i;
        }
    }

    private final zzkc zza(int i) {
        int i2 = (i / 3) << 1;
        zzkc zzkc = (zzkc) this.zzd[i2];
        if (zzkc != null) {
            return zzkc;
        }
        zzkc<T> zza2 = zzjy.zza().zza((Class) ((Class) this.zzd[i2 + 1]));
        this.zzd[i2] = zza2;
        return zza2;
    }

    public final int zza(T t, byte[] bArr, int i, int i2, int i3, zzgo zzgo) throws IOException {
        Unsafe unsafe;
        int i4;
        T t2;
        zzjn<T> zzjn;
        byte b;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        T t3;
        int i11;
        zzgo zzgo2;
        int i12;
        zzgo zzgo3;
        int i13;
        int i14;
        int i15;
        zzgo zzgo4;
        int zzb2;
        int i16;
        zzgo zzgo5;
        int i17;
        int i18;
        int i19;
        zzjn<T> zzjn2 = this;
        T t4 = t;
        byte[] bArr2 = bArr;
        int i20 = i2;
        int i21 = i3;
        zzgo zzgo6 = zzgo;
        Unsafe unsafe2 = zzb;
        int i22 = i;
        int i23 = -1;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 1048575;
        while (true) {
            if (i22 < i20) {
                int i28 = i22 + 1;
                byte b2 = bArr2[i22];
                if (b2 < 0) {
                    int zza2 = zzgp.zza(b2, bArr2, i28, zzgo6);
                    b = zzgo6.zza;
                    i28 = zza2;
                } else {
                    b = b2;
                }
                int i29 = b >>> 3;
                int i30 = b & 7;
                if (i29 > i23) {
                    i5 = zzjn2.zza(i29, i24 / 3);
                } else {
                    i5 = zzjn2.zzg(i29);
                }
                if (i5 == -1) {
                    i6 = i29;
                    i7 = i28;
                    i8 = b;
                    i9 = i26;
                    unsafe = unsafe2;
                    i4 = i21;
                    i10 = 0;
                } else {
                    int[] iArr = zzjn2.zzc;
                    int i31 = iArr[i5 + 1];
                    int i32 = (i31 & 267386880) >>> 20;
                    long j = (long) (i31 & 1048575);
                    if (i32 <= 17) {
                        int i33 = iArr[i5 + 2];
                        int i34 = 1 << (i33 >>> 20);
                        int i35 = i33 & 1048575;
                        if (i35 != i27) {
                            if (i27 != 1048575) {
                                unsafe2.putInt(t4, (long) i27, i26);
                            }
                            i26 = unsafe2.getInt(t4, (long) i35);
                            i12 = i35;
                        } else {
                            i12 = i27;
                        }
                        switch (i32) {
                            case 0:
                                i13 = i29;
                                i14 = i5;
                                i15 = i12;
                                i8 = b;
                                bArr2 = bArr;
                                zzgo4 = zzgo;
                                if (i30 == 1) {
                                    zzla.zza(t4, j, zzgp.zzc(bArr2, i28));
                                    i22 = i28 + 8;
                                    i26 |= i34;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    i24 = i14;
                                    zzgo6 = zzgo4;
                                    i20 = i2;
                                    break;
                                } else {
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i26;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                }
                            case 1:
                                i13 = i29;
                                i14 = i5;
                                i15 = i12;
                                i8 = b;
                                bArr2 = bArr;
                                zzgo4 = zzgo;
                                if (i30 == 5) {
                                    zzla.zza((Object) t4, j, zzgp.zzd(bArr2, i28));
                                    i22 = i28 + 4;
                                    i26 |= i34;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    i24 = i14;
                                    zzgo6 = zzgo4;
                                    i20 = i2;
                                    break;
                                } else {
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i26;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                }
                            case 2:
                            case 3:
                                i13 = i29;
                                i14 = i5;
                                i15 = i12;
                                i8 = b;
                                bArr2 = bArr;
                                zzgo4 = zzgo;
                                if (i30 == 0) {
                                    zzb2 = zzgp.zzb(bArr2, i28, zzgo4);
                                    unsafe2.putLong(t, j, zzgo4.zzb);
                                    i26 |= i34;
                                    i27 = i15;
                                    i22 = zzb2;
                                    i25 = i8;
                                    i23 = i13;
                                    i24 = i14;
                                    zzgo6 = zzgo4;
                                    i20 = i2;
                                    break;
                                } else {
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i26;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                }
                            case 4:
                            case 11:
                                i13 = i29;
                                i14 = i5;
                                i15 = i12;
                                i8 = b;
                                bArr2 = bArr;
                                zzgo4 = zzgo;
                                if (i30 == 0) {
                                    i22 = zzgp.zza(bArr2, i28, zzgo4);
                                    unsafe2.putInt(t4, j, zzgo4.zza);
                                    i26 |= i34;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    i24 = i14;
                                    zzgo6 = zzgo4;
                                    i20 = i2;
                                    break;
                                } else {
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i26;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                }
                            case 5:
                            case 14:
                                i13 = i29;
                                i14 = i5;
                                i15 = i12;
                                i8 = b;
                                bArr2 = bArr;
                                zzgo4 = zzgo;
                                if (i30 == 1) {
                                    unsafe2.putLong(t, j, zzgp.zzb(bArr2, i28));
                                    i22 = i28 + 8;
                                    i26 |= i34;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    i24 = i14;
                                    zzgo6 = zzgo4;
                                    i20 = i2;
                                    break;
                                } else {
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i26;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                }
                            case 6:
                            case 13:
                                i13 = i29;
                                i14 = i5;
                                i15 = i12;
                                i8 = b;
                                bArr2 = bArr;
                                i16 = i2;
                                zzgo5 = zzgo;
                                if (i30 == 5) {
                                    unsafe2.putInt(t4, j, zzgp.zza(bArr2, i28));
                                    i22 = i28 + 4;
                                    i26 |= i34;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    zzgo6 = zzgo5;
                                    i20 = i16;
                                    i24 = i14;
                                    break;
                                } else {
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i26;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                }
                            case 7:
                                i13 = i29;
                                i14 = i5;
                                i15 = i12;
                                i8 = b;
                                bArr2 = bArr;
                                i16 = i2;
                                zzgo5 = zzgo;
                                if (i30 == 0) {
                                    int zzb3 = zzgp.zzb(bArr2, i28, zzgo5);
                                    zzla.zza(t4, j, zzgo5.zzb != 0);
                                    i26 |= i34;
                                    i27 = i15;
                                    i22 = zzb3;
                                    i25 = i8;
                                    i23 = i13;
                                    zzgo6 = zzgo5;
                                    i20 = i16;
                                    i24 = i14;
                                    break;
                                } else {
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i26;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                }
                            case 8:
                                i13 = i29;
                                i14 = i5;
                                i15 = i12;
                                i8 = b;
                                bArr2 = bArr;
                                i16 = i2;
                                zzgo5 = zzgo;
                                if (i30 == 2) {
                                    if ((i31 & 536870912) == 0) {
                                        i22 = zzgp.zzc(bArr2, i28, zzgo5);
                                    } else {
                                        i22 = zzgp.zzd(bArr2, i28, zzgo5);
                                    }
                                    unsafe2.putObject(t4, j, zzgo5.zzc);
                                    i26 |= i34;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    zzgo6 = zzgo5;
                                    i20 = i16;
                                    i24 = i14;
                                    break;
                                } else {
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i26;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                }
                            case 9:
                                i13 = i29;
                                i14 = i5;
                                i15 = i12;
                                i8 = b;
                                bArr2 = bArr;
                                zzgo5 = zzgo;
                                if (i30 == 2) {
                                    i16 = i2;
                                    i22 = zzgp.zza(zzjn2.zza(i14), bArr2, i28, i16, zzgo5);
                                    if ((i26 & i34) == 0) {
                                        unsafe2.putObject(t4, j, zzgo5.zzc);
                                    } else {
                                        unsafe2.putObject(t4, j, zzie.zza(unsafe2.getObject(t4, j), zzgo5.zzc));
                                    }
                                    i26 |= i34;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    zzgo6 = zzgo5;
                                    i20 = i16;
                                    i24 = i14;
                                    break;
                                } else {
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i26;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                }
                            case 10:
                                i13 = i29;
                                i14 = i5;
                                i15 = i12;
                                i8 = b;
                                bArr2 = bArr;
                                zzgo4 = zzgo;
                                if (i30 == 2) {
                                    i22 = zzgp.zze(bArr2, i28, zzgo4);
                                    unsafe2.putObject(t4, j, zzgo4.zzc);
                                    i26 |= i34;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    i24 = i14;
                                    zzgo6 = zzgo4;
                                    i20 = i2;
                                    break;
                                } else {
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i26;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                }
                            case 12:
                                i13 = i29;
                                i14 = i5;
                                i15 = i12;
                                i8 = b;
                                bArr2 = bArr;
                                zzgo4 = zzgo;
                                if (i30 != 0) {
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i26;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                } else {
                                    i22 = zzgp.zza(bArr2, i28, zzgo4);
                                    int i36 = zzgo4.zza;
                                    zzif zzc2 = zzjn2.zzc(i14);
                                    if (zzc2 == null || zzc2.zza(i36)) {
                                        unsafe2.putInt(t4, j, i36);
                                        i26 |= i34;
                                        i27 = i15;
                                        i25 = i8;
                                        i23 = i13;
                                        i24 = i14;
                                        zzgo6 = zzgo4;
                                        i20 = i2;
                                        break;
                                    } else {
                                        zze(t).zza(i8, Long.valueOf((long) i36));
                                        i26 = i26;
                                        i25 = i8;
                                        i23 = i13;
                                        i24 = i14;
                                        zzgo6 = zzgo4;
                                        i27 = i15;
                                        i20 = i2;
                                    }
                                }
                                break;
                            case 15:
                                i13 = i29;
                                i14 = i5;
                                i15 = i12;
                                i8 = b;
                                bArr2 = bArr;
                                zzgo4 = zzgo;
                                if (i30 == 0) {
                                    i22 = zzgp.zza(bArr2, i28, zzgo4);
                                    unsafe2.putInt(t4, j, zzhf.zze(zzgo4.zza));
                                    i26 |= i34;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    i24 = i14;
                                    zzgo6 = zzgo4;
                                    i20 = i2;
                                    break;
                                } else {
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i26;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                }
                            case 16:
                                i13 = i29;
                                i14 = i5;
                                if (i30 == 0) {
                                    bArr2 = bArr;
                                    zzb2 = zzgp.zzb(bArr2, i28, zzgo);
                                    zzgo4 = zzgo;
                                    i15 = i12;
                                    i8 = b;
                                    unsafe2.putLong(t, j, zzhf.zza(zzgo.zzb));
                                    i26 |= i34;
                                    i27 = i15;
                                    i22 = zzb2;
                                    i25 = i8;
                                    i23 = i13;
                                    i24 = i14;
                                    zzgo6 = zzgo4;
                                    i20 = i2;
                                    break;
                                } else {
                                    i15 = i12;
                                    i8 = b;
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i26;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                }
                            case 17:
                                if (i30 == 3) {
                                    i22 = zzgp.zza(zzjn2.zza(i5), bArr, i28, i2, (i29 << 3) | 4, zzgo);
                                    if ((i26 & i34) == 0) {
                                        zzgo3 = zzgo;
                                        unsafe2.putObject(t4, j, zzgo3.zzc);
                                    } else {
                                        zzgo3 = zzgo;
                                        unsafe2.putObject(t4, j, zzie.zza(unsafe2.getObject(t4, j), zzgo3.zzc));
                                    }
                                    i26 |= i34;
                                    bArr2 = bArr;
                                    i20 = i2;
                                    i25 = b;
                                    i27 = i12;
                                    i23 = i29;
                                    i24 = i5;
                                    i21 = i3;
                                    zzgo6 = zzgo3;
                                    break;
                                } else {
                                    i13 = i29;
                                    i14 = i5;
                                    i15 = i12;
                                    i8 = b;
                                    i4 = i3;
                                    i7 = i28;
                                    i9 = i26;
                                    unsafe = unsafe2;
                                    i10 = i14;
                                    i27 = i15;
                                    i6 = i13;
                                    break;
                                }
                            default:
                                i13 = i29;
                                i14 = i5;
                                i15 = i12;
                                i8 = b;
                                i4 = i3;
                                i7 = i28;
                                i9 = i26;
                                unsafe = unsafe2;
                                i10 = i14;
                                i27 = i15;
                                i6 = i13;
                                break;
                        }
                    } else {
                        bArr2 = bArr;
                        if (i32 != 27) {
                            i10 = i5;
                            i9 = i26;
                            i17 = i27;
                            if (i32 <= 49) {
                                i19 = b;
                                i6 = i29;
                                unsafe = unsafe2;
                                i22 = zza(t, bArr, i28, i2, b, i29, i30, i10, (long) i31, i32, j, zzgo);
                                if (i22 == i28) {
                                    i4 = i3;
                                    i7 = i22;
                                    i8 = i19;
                                    i27 = i17;
                                }
                            } else {
                                i18 = i28;
                                i19 = b;
                                i6 = i29;
                                unsafe = unsafe2;
                                if (i32 != 50) {
                                    i22 = zza(t, bArr, i18, i2, i19, i6, i30, i31, i32, j, i10, zzgo);
                                    if (i22 != i18) {
                                        zzjn2 = this;
                                        t4 = t;
                                        bArr2 = bArr;
                                        i20 = i2;
                                        zzgo6 = zzgo;
                                        i25 = i19;
                                        i23 = i6;
                                        i24 = i10;
                                        i26 = i9;
                                        i27 = i17;
                                        unsafe2 = unsafe;
                                    }
                                } else if (i30 == 2) {
                                    i22 = zza(t, bArr, i18, i2, i10, j, zzgo);
                                    if (i22 == i18) {
                                    }
                                }
                                i4 = i3;
                                i7 = i22;
                                i8 = i19;
                                i27 = i17;
                            }
                            zzjn2 = this;
                            t4 = t;
                            bArr2 = bArr;
                            i23 = i6;
                            i20 = i2;
                            i21 = i3;
                            zzgo6 = zzgo;
                            i24 = i10;
                            i25 = i19;
                            i26 = i9;
                            i27 = i17;
                            unsafe2 = unsafe;
                        } else if (i30 == 2) {
                            zzik zzik = (zzik) unsafe2.getObject(t4, j);
                            if (!zzik.zza()) {
                                int size = zzik.size();
                                zzik = zzik.zza(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(t4, j, zzik);
                            }
                            i22 = zzgp.zza(zzjn2.zza(i5), b, bArr, i28, i2, zzik, zzgo);
                            i21 = i3;
                            i25 = b;
                            i23 = i29;
                            zzgo6 = zzgo6;
                            i24 = i5;
                            i26 = i26;
                            i27 = i27;
                            i20 = i2;
                        } else {
                            i10 = i5;
                            i9 = i26;
                            i17 = i27;
                            i18 = i28;
                            i19 = b;
                            i6 = i29;
                            unsafe = unsafe2;
                        }
                        i4 = i3;
                        i7 = i18;
                        i8 = i19;
                        i27 = i17;
                    }
                    i21 = i3;
                }
                if (i8 != i4 || i4 == 0) {
                    if (this.zzh) {
                        zzgo2 = zzgo;
                        if (zzgo2.zzd == zzho.zza()) {
                            t3 = t;
                            i11 = i6;
                        } else if (zzgo2.zzd.zza(this.zzg, i6) == null) {
                            i22 = zzgp.zza(i8, bArr, i7, i2, zze(t), zzgo);
                            t4 = t;
                            bArr2 = bArr;
                            i20 = i2;
                            i25 = i8;
                            zzjn2 = this;
                            zzgo6 = zzgo2;
                            i23 = i6;
                            i24 = i10;
                            i26 = i9;
                            unsafe2 = unsafe;
                            i21 = i4;
                        } else {
                            T t5 = t;
                            t5.zza();
                            zzhr<zzib.zze> zzhr = t5.zzc;
                            throw new NoSuchMethodError();
                        }
                    } else {
                        t3 = t;
                        i11 = i6;
                        zzgo2 = zzgo;
                    }
                    i22 = zzgp.zza(i8, bArr, i7, i2, zze(t), zzgo);
                    i20 = i2;
                    i25 = i8;
                    zzjn2 = this;
                    zzgo6 = zzgo2;
                    i23 = i11;
                    t4 = t3;
                    i24 = i10;
                    i26 = i9;
                    unsafe2 = unsafe;
                    bArr2 = bArr;
                    i21 = i4;
                } else {
                    zzjn = this;
                    t2 = t;
                    i22 = i7;
                    i25 = i8;
                    i26 = i9;
                }
            } else {
                unsafe = unsafe2;
                i4 = i21;
                t2 = t4;
                zzjn = zzjn2;
            }
        }
        if (i27 != 1048575) {
            unsafe.putInt(t2, (long) i27, i26);
        }
        zzkt zzkt = null;
        for (int i37 = zzjn.zzm; i37 < zzjn.zzn; i37++) {
            zzkt = (zzkt) zzjn.zza((Object) t2, zzjn.zzl[i37], (int) zzkt, (zzku<UT, int>) ((zzku<UT, UB>) zzjn.zzq));
        }
        if (zzkt != null) {
            zzjn.zzq.zzb((Object) t2, (T) zzkt);
        }
        if (i4 == 0) {
            if (i22 != i2) {
                throw zzij.zzg();
            }
        } else if (i22 > i2 || i25 != i4) {
            throw zzij.zzg();
        }
        return i22;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [int] */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02dc, code lost:
        if (r0 == r4) goto L_0x0348;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0323, code lost:
        if (r0 == r15) goto L_0x0348;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0346, code lost:
        if (r0 == r15) goto L_0x0348;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0348, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.gms.internal.measurement.zzkc
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.measurement.zzgo r35) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 966
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzgo):void");
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzku<UT, UB> zzku) {
        zzif zzc2;
        int i2 = this.zzc[i];
        Object zzf2 = zzla.zzf(obj, (long) (zzd(i) & 1048575));
        return (zzf2 == null || (zzc2 = zzc(i)) == null) ? ub : (UB) zza(i, i2, (Map<K, V>) this.zzs.zza(zzf2), zzc2, ub, zzku);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzif zzif, UB ub, zzku<UT, UB> zzku) {
        zzje<?, ?> zzb2 = this.zzs.zzb(zzb(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzif.zza(next.getValue().intValue())) {
                if (ub == null) {
                    ub = zzku.zza();
                }
                zzhb zzc2 = zzgt.zzc(zzjb.zza(zzb2, next.getKey(), next.getValue()));
                try {
                    zzjb.zza(zzc2.zzb(), zzb2, next.getKey(), next.getValue());
                    zzku.zza(ub, i2, zzc2.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.android.gms.internal.measurement.zzkc */
    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzkc zzkc) {
        return zzkc.zzd(zzla.zzf(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzln zzln) throws IOException {
        if (obj instanceof String) {
            zzln.zza(i, (String) obj);
        } else {
            zzln.zza(i, (zzgt) obj);
        }
    }

    private final void zza(Object obj, int i, zzjz zzjz) throws IOException {
        if (zzf(i)) {
            zzla.zza(obj, (long) (i & 1048575), zzjz.zzm());
        } else if (this.zzi) {
            zzla.zza(obj, (long) (i & 1048575), zzjz.zzl());
        } else {
            zzla.zza(obj, (long) (i & 1048575), zzjz.zzn());
        }
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zza((zzjn<T>) t, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zza(T t, int i) {
        int zze2 = zze(i);
        long j = (long) (zze2 & 1048575);
        if (j == 1048575) {
            int zzd2 = zzd(i);
            long j2 = (long) (zzd2 & 1048575);
            switch ((zzd2 & 267386880) >>> 20) {
                case 0:
                    return zzla.zze(t, j2) != 0.0d;
                case 1:
                    return zzla.zzd(t, j2) != 0.0f;
                case 2:
                    return zzla.zzb(t, j2) != 0;
                case 3:
                    return zzla.zzb(t, j2) != 0;
                case 4:
                    return zzla.zza(t, j2) != 0;
                case 5:
                    return zzla.zzb(t, j2) != 0;
                case 6:
                    return zzla.zza(t, j2) != 0;
                case 7:
                    return zzla.zzc(t, j2);
                case 8:
                    Object zzf2 = zzla.zzf(t, j2);
                    if (zzf2 instanceof String) {
                        return !((String) zzf2).isEmpty();
                    }
                    if (zzf2 instanceof zzgt) {
                        return !zzgt.zza.equals(zzf2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzla.zzf(t, j2) != null;
                case 10:
                    return !zzgt.zza.equals(zzla.zzf(t, j2));
                case 11:
                    return zzla.zza(t, j2) != 0;
                case 12:
                    return zzla.zza(t, j2) != 0;
                case 13:
                    return zzla.zza(t, j2) != 0;
                case 14:
                    return zzla.zzb(t, j2) != 0;
                case 15:
                    return zzla.zza(t, j2) != 0;
                case 16:
                    return zzla.zzb(t, j2) != 0;
                case 17:
                    return zzla.zzf(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zzla.zza(t, j) & (1 << (zze2 >>> 20))) != 0;
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzla.zza(t, (long) (zze(i2) & 1048575)) == i;
    }

    private final int zza(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, i2);
    }
}
