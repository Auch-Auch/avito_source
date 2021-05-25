package com.google.android.gms.internal.vision;

import a2.b.a.a.a;
import com.avito.android.saved_searches.SavedSearchView;
import com.google.android.gms.internal.vision.zzid;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;
public final class zzjr<T> implements zzkf<T> {
    private static final int[] zzaai = new int[0];
    private static final Unsafe zzaaj = zzld.zzjg();
    private final int[] zzaak;
    private final Object[] zzaal;
    private final int zzaam;
    private final int zzaan;
    private final zzjn zzaao;
    private final boolean zzaap;
    private final boolean zzaaq;
    private final boolean zzaar;
    private final boolean zzaas;
    private final int[] zzaat;
    private final int zzaau;
    private final int zzaav;
    private final zzjv zzaaw;
    private final zzix zzaax;
    private final zzkx<?, ?> zzaay;
    private final zzhq<?> zzaaz;
    private final zzjg zzaba;

    private zzjr(int[] iArr, Object[] objArr, int i, int i2, zzjn zzjn, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzjv zzjv, zzix zzix, zzkx<?, ?> zzkx, zzhq<?> zzhq, zzjg zzjg) {
        this.zzaak = iArr;
        this.zzaal = objArr;
        this.zzaam = i;
        this.zzaan = i2;
        this.zzaaq = zzjn instanceof zzid;
        this.zzaar = z;
        this.zzaap = zzhq != null && zzhq.zze(zzjn);
        this.zzaas = false;
        this.zzaat = iArr2;
        this.zzaau = i3;
        this.zzaav = i4;
        this.zzaaw = zzjv;
        this.zzaax = zzix;
        this.zzaay = zzkx;
        this.zzaaz = zzhq;
        this.zzaao = zzjn;
        this.zzaba = zzjg;
    }

    public static <T> zzjr<T> zza(Class<T> cls, zzjl zzjl, zzjv zzjv, zzix zzix, zzkx<?, ?> zzkx, zzhq<?> zzhq, zzjg zzjg) {
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
        if (zzjl instanceof zzkd) {
            zzkd zzkd = (zzkd) zzjl;
            int i32 = 0;
            boolean z2 = zzkd.zzid() == zzjy.zzabe;
            String zzil = zzkd.zzil();
            int length = zzil.length();
            if (zzil.charAt(0) >= 55296) {
                int i33 = 1;
                while (true) {
                    i = i33 + 1;
                    if (zzil.charAt(i33) < 55296) {
                        break;
                    }
                    i33 = i;
                }
            } else {
                i = 1;
            }
            int i34 = i + 1;
            int charAt14 = zzil.charAt(i);
            if (charAt14 >= 55296) {
                int i35 = charAt14 & 8191;
                int i36 = 13;
                while (true) {
                    i31 = i34 + 1;
                    charAt13 = zzil.charAt(i34);
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
                iArr = zzaai;
                i7 = 0;
                i6 = 0;
                i5 = 0;
                i4 = 0;
                i3 = 0;
                i2 = 0;
            } else {
                int i37 = i34 + 1;
                int charAt15 = zzil.charAt(i34);
                if (charAt15 >= 55296) {
                    int i38 = charAt15 & 8191;
                    int i39 = 13;
                    while (true) {
                        i30 = i37 + 1;
                        charAt12 = zzil.charAt(i37);
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
                int charAt16 = zzil.charAt(i37);
                if (charAt16 >= 55296) {
                    int i41 = charAt16 & 8191;
                    int i42 = 13;
                    while (true) {
                        i29 = i40 + 1;
                        charAt11 = zzil.charAt(i40);
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
                i6 = zzil.charAt(i40);
                if (i6 >= 55296) {
                    int i44 = i6 & 8191;
                    int i45 = 13;
                    while (true) {
                        i28 = i43 + 1;
                        charAt10 = zzil.charAt(i43);
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
                i5 = zzil.charAt(i43);
                if (i5 >= 55296) {
                    int i47 = i5 & 8191;
                    int i48 = 13;
                    while (true) {
                        i27 = i46 + 1;
                        charAt9 = zzil.charAt(i46);
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
                i4 = zzil.charAt(i46);
                if (i4 >= 55296) {
                    int i50 = i4 & 8191;
                    int i51 = 13;
                    while (true) {
                        i26 = i49 + 1;
                        charAt8 = zzil.charAt(i49);
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
                i3 = zzil.charAt(i49);
                if (i3 >= 55296) {
                    int i53 = i3 & 8191;
                    int i54 = 13;
                    while (true) {
                        i25 = i52 + 1;
                        charAt7 = zzil.charAt(i52);
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
                int charAt17 = zzil.charAt(i52);
                if (charAt17 >= 55296) {
                    int i56 = charAt17 & 8191;
                    int i57 = 13;
                    while (true) {
                        i24 = i55 + 1;
                        charAt6 = zzil.charAt(i55);
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
                i2 = zzil.charAt(i55);
                if (i2 >= 55296) {
                    int i59 = i2 & 8191;
                    int i60 = i58;
                    int i61 = 13;
                    while (true) {
                        i23 = i60 + 1;
                        charAt5 = zzil.charAt(i60);
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
            Unsafe unsafe = zzaaj;
            Object[] zzim = zzkd.zzim();
            Class<?> cls2 = zzkd.zzif().getClass();
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
                int charAt18 = zzil.charAt(i65);
                if (charAt18 >= 55296) {
                    int i70 = charAt18 & 8191;
                    int i71 = i69;
                    int i72 = 13;
                    while (true) {
                        i22 = i71 + 1;
                        charAt4 = zzil.charAt(i71);
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
                int charAt19 = zzil.charAt(i9);
                if (charAt19 >= 55296) {
                    int i74 = charAt19 & 8191;
                    int i75 = i73;
                    int i76 = 13;
                    while (true) {
                        i21 = i75 + 1;
                        charAt3 = zzil.charAt(i75);
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
                    int charAt20 = zzil.charAt(i11);
                    char c = 55296;
                    if (charAt20 >= 55296) {
                        int i79 = charAt20 & 8191;
                        int i80 = 13;
                        while (true) {
                            i20 = i78 + 1;
                            charAt2 = zzil.charAt(i78);
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
                        objArr2[((i68 / 3) << 1) + 1] = zzim[i63];
                        i63++;
                    } else {
                        if (i81 == 12 && !z2) {
                            objArr2[((i68 / 3) << 1) + 1] = zzim[i63];
                            i63++;
                        }
                        i19 = 1;
                    }
                    int i82 = charAt20 << i19;
                    Object obj = zzim[i82];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zza(cls2, (String) obj);
                        zzim[i82] = field2;
                    }
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i83 = i82 + 1;
                    Object obj2 = zzim[i83];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zza(cls2, (String) obj2);
                        zzim[i83] = field3;
                    }
                    str = zzil;
                    i14 = (int) unsafe.objectFieldOffset(field3);
                    z = z2;
                    objArr = objArr2;
                    i13 = objectFieldOffset;
                    i12 = i78;
                    i15 = 0;
                } else {
                    int i84 = i63 + 1;
                    Field zza = zza(cls2, (String) zzim[i63]);
                    if (i77 == 9 || i77 == 17) {
                        objArr2[((i68 / 3) << 1) + 1] = zza.getType();
                    } else {
                        if (i77 == 27 || i77 == 49) {
                            i18 = i84 + 1;
                            objArr2[((i68 / 3) << 1) + 1] = zzim[i84];
                        } else if (i77 == 12 || i77 == 30 || i77 == 44) {
                            if (!z2) {
                                i18 = i84 + 1;
                                objArr2[((i68 / 3) << 1) + 1] = zzim[i84];
                            }
                        } else if (i77 == 50) {
                            int i85 = i64 + 1;
                            iArr[i64] = i68;
                            int i86 = (i68 / 3) << 1;
                            i18 = i84 + 1;
                            objArr2[i86] = zzim[i84];
                            if ((charAt19 & 2048) != 0) {
                                i84 = i18 + 1;
                                objArr2[i86 + 1] = zzim[i18];
                                i64 = i85;
                            } else {
                                i64 = i85;
                            }
                        }
                        i16 = i18;
                        i13 = (int) unsafe.objectFieldOffset(zza);
                        if ((charAt19 & 4096) == 4096 || i77 > 17) {
                            str = zzil;
                            z = z2;
                            objArr = objArr2;
                            i14 = 1048575;
                            i12 = i11;
                            i15 = 0;
                        } else {
                            int i87 = i11 + 1;
                            int charAt21 = zzil.charAt(i11);
                            if (charAt21 >= 55296) {
                                int i88 = charAt21 & 8191;
                                int i89 = 13;
                                while (true) {
                                    i17 = i87 + 1;
                                    charAt = zzil.charAt(i87);
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
                            Object obj3 = zzim[i90];
                            str = zzil;
                            if (obj3 instanceof Field) {
                                field = (Field) obj3;
                            } else {
                                field = zza(cls2, (String) obj3);
                                zzim[i90] = field;
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
                    i13 = (int) unsafe.objectFieldOffset(zza);
                    if ((charAt19 & 4096) == 4096) {
                    }
                    str = zzil;
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
                zzil = str;
            }
            return new zzjr<>(iArr2, objArr2, i6, i5, zzkd.zzif(), z2, false, iArr, i2, i62, zzjv, zzix, zzkx, zzhq, zzjg);
        }
        ((zzkq) zzjl).zzid();
        int i94 = zzjy.zzabe;
        throw new NoSuchMethodError();
    }

    private final void zzb(T t, T t2, int i) {
        int zzbx = zzbx(i);
        int i2 = this.zzaak[i];
        long j = (long) (zzbx & 1048575);
        if (zzb(t2, i2, i)) {
            Object zzp = zzld.zzp(t, j);
            Object zzp2 = zzld.zzp(t2, j);
            if (zzp != null && zzp2 != null) {
                zzld.zza(t, j, zzie.zzb(zzp, zzp2));
                zzc(t, i2, i);
            } else if (zzp2 != null) {
                zzld.zza(t, j, zzp2);
                zzc(t, i2, i);
            }
        }
    }

    private final zzkf zzbu(int i) {
        int i2 = (i / 3) << 1;
        zzkf zzkf = (zzkf) this.zzaal[i2];
        if (zzkf != null) {
            return zzkf;
        }
        zzkf<T> zzf = zzkb.zzik().zzf((Class) this.zzaal[i2 + 1]);
        this.zzaal[i2] = zzf;
        return zzf;
    }

    private final Object zzbv(int i) {
        return this.zzaal[(i / 3) << 1];
    }

    private final zzij zzbw(int i) {
        return (zzij) this.zzaal[((i / 3) << 1) + 1];
    }

    private final int zzbx(int i) {
        return this.zzaak[i + 1];
    }

    private final int zzby(int i) {
        return this.zzaak[i + 2];
    }

    private static boolean zzbz(int i) {
        return (i & 536870912) != 0;
    }

    private final boolean zzc(T t, T t2, int i) {
        return zzc(t, i) == zzc(t2, i);
    }

    private final int zzca(int i) {
        if (i < this.zzaam || i > this.zzaan) {
            return -1;
        }
        return zzw(i, 0);
    }

    private static List<?> zze(Object obj, long j) {
        return (List) zzld.zzp(obj, j);
    }

    private static <T> double zzf(T t, long j) {
        return ((Double) zzld.zzp(t, j)).doubleValue();
    }

    private static <T> float zzg(T t, long j) {
        return ((Float) zzld.zzp(t, j)).floatValue();
    }

    private static <T> int zzh(T t, long j) {
        return ((Integer) zzld.zzp(t, j)).intValue();
    }

    private static <T> long zzi(T t, long j) {
        return ((Long) zzld.zzp(t, j)).longValue();
    }

    private static zzkw zzv(Object obj) {
        zzid zzid = (zzid) obj;
        zzkw zzkw = zzid.zzxz;
        if (zzkw != zzkw.zzja()) {
            return zzkw;
        }
        zzkw zzjb = zzkw.zzjb();
        zzid.zzxz = zzjb;
        return zzjb;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.vision.zzkh.zze(com.google.android.gms.internal.vision.zzld.zzp(r10, r6), com.google.android.gms.internal.vision.zzld.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.vision.zzld.zzl(r10, r6) == com.google.android.gms.internal.vision.zzld.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.vision.zzld.zzk(r10, r6) == com.google.android.gms.internal.vision.zzld.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.vision.zzld.zzl(r10, r6) == com.google.android.gms.internal.vision.zzld.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.vision.zzld.zzk(r10, r6) == com.google.android.gms.internal.vision.zzld.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.vision.zzld.zzk(r10, r6) == com.google.android.gms.internal.vision.zzld.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.vision.zzld.zzk(r10, r6) == com.google.android.gms.internal.vision.zzld.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.vision.zzkh.zze(com.google.android.gms.internal.vision.zzld.zzp(r10, r6), com.google.android.gms.internal.vision.zzld.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.vision.zzkh.zze(com.google.android.gms.internal.vision.zzld.zzp(r10, r6), com.google.android.gms.internal.vision.zzld.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.vision.zzkh.zze(com.google.android.gms.internal.vision.zzld.zzp(r10, r6), com.google.android.gms.internal.vision.zzld.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.vision.zzld.zzm(r10, r6) == com.google.android.gms.internal.vision.zzld.zzm(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.vision.zzld.zzk(r10, r6) == com.google.android.gms.internal.vision.zzld.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.vision.zzld.zzl(r10, r6) == com.google.android.gms.internal.vision.zzld.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.vision.zzld.zzk(r10, r6) == com.google.android.gms.internal.vision.zzld.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.vision.zzld.zzl(r10, r6) == com.google.android.gms.internal.vision.zzld.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.vision.zzld.zzl(r10, r6) == com.google.android.gms.internal.vision.zzld.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.vision.zzld.zzn(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.vision.zzld.zzn(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.vision.zzld.zzo(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.vision.zzld.zzo(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.vision.zzkh.zze(com.google.android.gms.internal.vision.zzld.zzp(r10, r6), com.google.android.gms.internal.vision.zzld.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    @Override // com.google.android.gms.internal.vision.zzkf
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r10, T r11) {
        /*
        // Method dump skipped, instructions count: 640
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzjr.equals(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.vision.zzkf
    public final int hashCode(T t) {
        int i;
        int i2;
        int i3;
        int i4;
        int length = this.zzaak.length;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6 += 3) {
            int zzbx = zzbx(i6);
            int i7 = this.zzaak[i6];
            long j = (long) (1048575 & zzbx);
            int i8 = 37;
            switch ((zzbx & 267386880) >>> 20) {
                case 0:
                    i2 = i5 * 53;
                    i = zzie.zzab(Double.doubleToLongBits(zzld.zzo(t, j)));
                    i5 = i + i2;
                    break;
                case 1:
                    i2 = i5 * 53;
                    i = Float.floatToIntBits(zzld.zzn(t, j));
                    i5 = i + i2;
                    break;
                case 2:
                    i2 = i5 * 53;
                    i = zzie.zzab(zzld.zzl(t, j));
                    i5 = i + i2;
                    break;
                case 3:
                    i2 = i5 * 53;
                    i = zzie.zzab(zzld.zzl(t, j));
                    i5 = i + i2;
                    break;
                case 4:
                    i2 = i5 * 53;
                    i = zzld.zzk(t, j);
                    i5 = i + i2;
                    break;
                case 5:
                    i2 = i5 * 53;
                    i = zzie.zzab(zzld.zzl(t, j));
                    i5 = i + i2;
                    break;
                case 6:
                    i2 = i5 * 53;
                    i = zzld.zzk(t, j);
                    i5 = i + i2;
                    break;
                case 7:
                    i2 = i5 * 53;
                    i = zzie.zzm(zzld.zzm(t, j));
                    i5 = i + i2;
                    break;
                case 8:
                    i2 = i5 * 53;
                    i = ((String) zzld.zzp(t, j)).hashCode();
                    i5 = i + i2;
                    break;
                case 9:
                    Object zzp = zzld.zzp(t, j);
                    if (zzp != null) {
                        i8 = zzp.hashCode();
                    }
                    i5 = (i5 * 53) + i8;
                    break;
                case 10:
                    i2 = i5 * 53;
                    i = zzld.zzp(t, j).hashCode();
                    i5 = i + i2;
                    break;
                case 11:
                    i2 = i5 * 53;
                    i = zzld.zzk(t, j);
                    i5 = i + i2;
                    break;
                case 12:
                    i2 = i5 * 53;
                    i = zzld.zzk(t, j);
                    i5 = i + i2;
                    break;
                case 13:
                    i2 = i5 * 53;
                    i = zzld.zzk(t, j);
                    i5 = i + i2;
                    break;
                case 14:
                    i2 = i5 * 53;
                    i = zzie.zzab(zzld.zzl(t, j));
                    i5 = i + i2;
                    break;
                case 15:
                    i2 = i5 * 53;
                    i = zzld.zzk(t, j);
                    i5 = i + i2;
                    break;
                case 16:
                    i2 = i5 * 53;
                    i = zzie.zzab(zzld.zzl(t, j));
                    i5 = i + i2;
                    break;
                case 17:
                    Object zzp2 = zzld.zzp(t, j);
                    if (zzp2 != null) {
                        i8 = zzp2.hashCode();
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
                    i = zzld.zzp(t, j).hashCode();
                    i5 = i + i2;
                    break;
                case 50:
                    i2 = i5 * 53;
                    i = zzld.zzp(t, j).hashCode();
                    i5 = i + i2;
                    break;
                case 51:
                    if (zzb(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzie.zzab(Double.doubleToLongBits(zzf(t, j)));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzb(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = Float.floatToIntBits(zzg(t, j));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzb(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzie.zzab(zzi(t, j));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzb(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzie.zzab(zzi(t, j));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzb(t, i7, i6)) {
                        i4 = i5 * 53;
                        i3 = zzh(t, j);
                        i5 = i4 + i3;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzb(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzie.zzab(zzi(t, j));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzb(t, i7, i6)) {
                        i4 = i5 * 53;
                        i3 = zzh(t, j);
                        i5 = i4 + i3;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzb(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzie.zzm(zzj(t, j));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzb(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = ((String) zzld.zzp(t, j)).hashCode();
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzb(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzld.zzp(t, j).hashCode();
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzb(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzld.zzp(t, j).hashCode();
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzb(t, i7, i6)) {
                        i4 = i5 * 53;
                        i3 = zzh(t, j);
                        i5 = i4 + i3;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzb(t, i7, i6)) {
                        i4 = i5 * 53;
                        i3 = zzh(t, j);
                        i5 = i4 + i3;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzb(t, i7, i6)) {
                        i4 = i5 * 53;
                        i3 = zzh(t, j);
                        i5 = i4 + i3;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzb(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzie.zzab(zzi(t, j));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzb(t, i7, i6)) {
                        i4 = i5 * 53;
                        i3 = zzh(t, j);
                        i5 = i4 + i3;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzb(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzie.zzab(zzi(t, j));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzb(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzld.zzp(t, j).hashCode();
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = this.zzaay.zzy(t).hashCode() + (i5 * 53);
        return this.zzaap ? (hashCode * 53) + this.zzaaz.zzh(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.vision.zzkf
    public final T newInstance() {
        return (T) this.zzaaw.newInstance(this.zzaao);
    }

    @Override // com.google.android.gms.internal.vision.zzkf
    public final void zzd(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i = 0; i < this.zzaak.length; i += 3) {
            int zzbx = zzbx(i);
            long j = (long) (1048575 & zzbx);
            int i2 = this.zzaak[i];
            switch ((zzbx & 267386880) >>> 20) {
                case 0:
                    if (zzc(t2, i)) {
                        zzld.zza(t, j, zzld.zzo(t2, j));
                        zzd(t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzc(t2, i)) {
                        zzld.zza((Object) t, j, zzld.zzn(t2, j));
                        zzd(t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzc(t2, i)) {
                        zzld.zza((Object) t, j, zzld.zzl(t2, j));
                        zzd(t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzc(t2, i)) {
                        zzld.zza((Object) t, j, zzld.zzl(t2, j));
                        zzd(t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzc(t2, i)) {
                        zzld.zzb(t, j, zzld.zzk(t2, j));
                        zzd(t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzc(t2, i)) {
                        zzld.zza((Object) t, j, zzld.zzl(t2, j));
                        zzd(t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzc(t2, i)) {
                        zzld.zzb(t, j, zzld.zzk(t2, j));
                        zzd(t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzc(t2, i)) {
                        zzld.zza(t, j, zzld.zzm(t2, j));
                        zzd(t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzc(t2, i)) {
                        zzld.zza(t, j, zzld.zzp(t2, j));
                        zzd(t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zzc(t2, i)) {
                        zzld.zza(t, j, zzld.zzp(t2, j));
                        zzd(t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzc(t2, i)) {
                        zzld.zzb(t, j, zzld.zzk(t2, j));
                        zzd(t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzc(t2, i)) {
                        zzld.zzb(t, j, zzld.zzk(t2, j));
                        zzd(t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzc(t2, i)) {
                        zzld.zzb(t, j, zzld.zzk(t2, j));
                        zzd(t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzc(t2, i)) {
                        zzld.zza((Object) t, j, zzld.zzl(t2, j));
                        zzd(t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzc(t2, i)) {
                        zzld.zzb(t, j, zzld.zzk(t2, j));
                        zzd(t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzc(t2, i)) {
                        zzld.zza((Object) t, j, zzld.zzl(t2, j));
                        zzd(t, i);
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
                    this.zzaax.zza(t, t2, j);
                    break;
                case 50:
                    zzkh.zza(this.zzaba, t, t2, j);
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
                    if (zzb(t2, i2, i)) {
                        zzld.zza(t, j, zzld.zzp(t2, j));
                        zzc(t, i2, i);
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
                    if (zzb(t2, i2, i)) {
                        zzld.zza(t, j, zzld.zzp(t2, j));
                        zzc(t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        zzkh.zza(this.zzaay, t, t2);
        if (this.zzaap) {
            zzkh.zza(this.zzaaz, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.vision.zzkf
    public final void zzj(T t) {
        int i;
        int i2 = this.zzaau;
        while (true) {
            i = this.zzaav;
            if (i2 >= i) {
                break;
            }
            long zzbx = (long) (zzbx(this.zzaat[i2]) & 1048575);
            Object zzp = zzld.zzp(t, zzbx);
            if (zzp != null) {
                zzld.zza(t, zzbx, this.zzaba.zzq(zzp));
            }
            i2++;
        }
        int length = this.zzaat.length;
        while (i < length) {
            this.zzaax.zzb(t, (long) this.zzaat[i]);
            i++;
        }
        this.zzaay.zzj(t);
        if (this.zzaap) {
            this.zzaaz.zzj(t);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.vision.zzkf
    public final int zzu(T t) {
        int i;
        int i2;
        int i3;
        int zzb;
        int zzd;
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
        if (this.zzaar) {
            Unsafe unsafe = zzaaj;
            int i15 = 0;
            int i16 = 0;
            while (i15 < this.zzaak.length) {
                int zzbx = zzbx(i15);
                int i17 = (i12 & zzbx) >>> 20;
                int i18 = this.zzaak[i15];
                long j = (long) (zzbx & 1048575);
                if (i17 >= zzhy.DOUBLE_LIST_PACKED.id() && i17 <= zzhy.SINT64_LIST_PACKED.id()) {
                    int i19 = this.zzaak[i15 + 2];
                }
                switch (i17) {
                    case 0:
                        if (zzc(t, i15)) {
                            i8 = zzhl.zzb(i18, 0.0d);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zzc(t, i15)) {
                            i8 = zzhl.zzb(i18, 0.0f);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zzc(t, i15)) {
                            i8 = zzhl.zzd(i18, zzld.zzl(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zzc(t, i15)) {
                            i8 = zzhl.zze(i18, zzld.zzl(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zzc(t, i15)) {
                            i8 = zzhl.zzn(i18, zzld.zzk(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zzc(t, i15)) {
                            i8 = zzhl.zzg(i18, 0);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zzc(t, i15)) {
                            i8 = zzhl.zzq(i18, 0);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zzc(t, i15)) {
                            i8 = zzhl.zzb(i18, true);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zzc(t, i15)) {
                            Object zzp = zzld.zzp(t, j);
                            if (zzp instanceof zzgs) {
                                i8 = zzhl.zzc(i18, (zzgs) zzp);
                            } else {
                                i8 = zzhl.zzb(i18, (String) zzp);
                            }
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (zzc(t, i15)) {
                            i8 = zzkh.zzc(i18, zzld.zzp(t, j), zzbu(i15));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zzc(t, i15)) {
                            i8 = zzhl.zzc(i18, (zzgs) zzld.zzp(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zzc(t, i15)) {
                            i8 = zzhl.zzo(i18, zzld.zzk(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zzc(t, i15)) {
                            i8 = zzhl.zzs(i18, zzld.zzk(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zzc(t, i15)) {
                            i8 = zzhl.zzr(i18, 0);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zzc(t, i15)) {
                            i8 = zzhl.zzh(i18, 0);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zzc(t, i15)) {
                            i8 = zzhl.zzp(i18, zzld.zzk(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zzc(t, i15)) {
                            i8 = zzhl.zzf(i18, zzld.zzl(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zzc(t, i15)) {
                            i8 = zzhl.zzc(i18, (zzjn) zzld.zzp(t, j), zzbu(i15));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        i8 = zzkh.zzw(i18, zze(t, j), false);
                        i16 += i8;
                        break;
                    case 19:
                        i8 = zzkh.zzv(i18, zze(t, j), false);
                        i16 += i8;
                        break;
                    case 20:
                        i8 = zzkh.zzo(i18, zze(t, j), false);
                        i16 += i8;
                        break;
                    case 21:
                        i8 = zzkh.zzp(i18, zze(t, j), false);
                        i16 += i8;
                        break;
                    case 22:
                        i8 = zzkh.zzs(i18, zze(t, j), false);
                        i16 += i8;
                        break;
                    case 23:
                        i8 = zzkh.zzw(i18, zze(t, j), false);
                        i16 += i8;
                        break;
                    case 24:
                        i8 = zzkh.zzv(i18, zze(t, j), false);
                        i16 += i8;
                        break;
                    case 25:
                        i8 = zzkh.zzx(i18, zze(t, j), false);
                        i16 += i8;
                        break;
                    case 26:
                        i8 = zzkh.zzc(i18, zze(t, j));
                        i16 += i8;
                        break;
                    case 27:
                        i8 = zzkh.zzc(i18, zze(t, j), zzbu(i15));
                        i16 += i8;
                        break;
                    case 28:
                        i8 = zzkh.zzd(i18, zze(t, j));
                        i16 += i8;
                        break;
                    case 29:
                        i8 = zzkh.zzt(i18, zze(t, j), false);
                        i16 += i8;
                        break;
                    case 30:
                        i8 = zzkh.zzr(i18, zze(t, j), false);
                        i16 += i8;
                        break;
                    case 31:
                        i8 = zzkh.zzv(i18, zze(t, j), false);
                        i16 += i8;
                        break;
                    case 32:
                        i8 = zzkh.zzw(i18, zze(t, j), false);
                        i16 += i8;
                        break;
                    case 33:
                        i8 = zzkh.zzu(i18, zze(t, j), false);
                        i16 += i8;
                        break;
                    case 34:
                        i8 = zzkh.zzq(i18, zze(t, j), false);
                        i16 += i8;
                        break;
                    case 35:
                        i11 = zzkh.zzy((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzhl.zzbh(i18);
                            i9 = zzhl.zzbj(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        i11 = zzkh.zzx((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzhl.zzbh(i18);
                            i9 = zzhl.zzbj(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        i11 = zzkh.zzq((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzhl.zzbh(i18);
                            i9 = zzhl.zzbj(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        i11 = zzkh.zzr((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzhl.zzbh(i18);
                            i9 = zzhl.zzbj(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        i11 = zzkh.zzu((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzhl.zzbh(i18);
                            i9 = zzhl.zzbj(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        i11 = zzkh.zzy((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzhl.zzbh(i18);
                            i9 = zzhl.zzbj(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        i11 = zzkh.zzx((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzhl.zzbh(i18);
                            i9 = zzhl.zzbj(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        i11 = zzkh.zzz((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzhl.zzbh(i18);
                            i9 = zzhl.zzbj(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        i11 = zzkh.zzv((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzhl.zzbh(i18);
                            i9 = zzhl.zzbj(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        i11 = zzkh.zzt((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzhl.zzbh(i18);
                            i9 = zzhl.zzbj(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        i11 = zzkh.zzx((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzhl.zzbh(i18);
                            i9 = zzhl.zzbj(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        i11 = zzkh.zzy((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzhl.zzbh(i18);
                            i9 = zzhl.zzbj(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        i11 = zzkh.zzw((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzhl.zzbh(i18);
                            i9 = zzhl.zzbj(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        i11 = zzkh.zzs((List) unsafe.getObject(t, j));
                        if (i11 > 0) {
                            i10 = zzhl.zzbh(i18);
                            i9 = zzhl.zzbj(i11);
                            i16 = a.G1(i9, i10, i11, i16);
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        i8 = zzkh.zzd(i18, zze(t, j), zzbu(i15));
                        i16 += i8;
                        break;
                    case 50:
                        i8 = this.zzaba.zzb(i18, zzld.zzp(t, j), zzbv(i15));
                        i16 += i8;
                        break;
                    case 51:
                        if (zzb(t, i18, i15)) {
                            i8 = zzhl.zzb(i18, 0.0d);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zzb(t, i18, i15)) {
                            i8 = zzhl.zzb(i18, 0.0f);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zzb(t, i18, i15)) {
                            i8 = zzhl.zzd(i18, zzi(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zzb(t, i18, i15)) {
                            i8 = zzhl.zze(i18, zzi(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zzb(t, i18, i15)) {
                            i8 = zzhl.zzn(i18, zzh(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zzb(t, i18, i15)) {
                            i8 = zzhl.zzg(i18, 0);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zzb(t, i18, i15)) {
                            i8 = zzhl.zzq(i18, 0);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zzb(t, i18, i15)) {
                            i8 = zzhl.zzb(i18, true);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zzb(t, i18, i15)) {
                            Object zzp2 = zzld.zzp(t, j);
                            if (zzp2 instanceof zzgs) {
                                i8 = zzhl.zzc(i18, (zzgs) zzp2);
                            } else {
                                i8 = zzhl.zzb(i18, (String) zzp2);
                            }
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (zzb(t, i18, i15)) {
                            i8 = zzkh.zzc(i18, zzld.zzp(t, j), zzbu(i15));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zzb(t, i18, i15)) {
                            i8 = zzhl.zzc(i18, (zzgs) zzld.zzp(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zzb(t, i18, i15)) {
                            i8 = zzhl.zzo(i18, zzh(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zzb(t, i18, i15)) {
                            i8 = zzhl.zzs(i18, zzh(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zzb(t, i18, i15)) {
                            i8 = zzhl.zzr(i18, 0);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zzb(t, i18, i15)) {
                            i8 = zzhl.zzh(i18, 0);
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zzb(t, i18, i15)) {
                            i8 = zzhl.zzp(i18, zzh(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zzb(t, i18, i15)) {
                            i8 = zzhl.zzf(i18, zzi(t, j));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zzb(t, i18, i15)) {
                            i8 = zzhl.zzc(i18, (zzjn) zzld.zzp(t, j), zzbu(i15));
                            i16 += i8;
                            break;
                        } else {
                            break;
                        }
                }
                i15 += 3;
                i12 = 267386880;
            }
            return i16 + zza((zzkx) this.zzaay, (Object) t);
        }
        Unsafe unsafe2 = zzaaj;
        int i20 = 0;
        int i21 = 0;
        int i22 = 1048575;
        int i23 = 0;
        while (i20 < this.zzaak.length) {
            int zzbx2 = zzbx(i20);
            int[] iArr = this.zzaak;
            int i24 = iArr[i20];
            int i25 = (267386880 & zzbx2) >>> 20;
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
            long j2 = (long) (i13 & zzbx2);
            switch (i25) {
                case 0:
                    if ((i23 & i) != 0) {
                        i3 = zzhl.zzb(i24, 0.0d);
                        i2 = i3 + i21;
                        i21 = i2;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i23 & i) != 0) {
                        zzb = zzhl.zzb(i24, 0.0f);
                        i21 += zzb;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((i & i23) != 0) {
                        zzd = zzhl.zzd(i24, unsafe2.getLong(t, j2));
                        i21 += zzd;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i & i23) != 0) {
                        zzd = zzhl.zze(i24, unsafe2.getLong(t, j2));
                        i21 += zzd;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i & i23) != 0) {
                        zzd = zzhl.zzn(i24, unsafe2.getInt(t, j2));
                        i21 += zzd;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i23 & i) != 0) {
                        zzd = zzhl.zzg(i24, 0);
                        i21 += zzd;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((i23 & i) != 0) {
                        zzb = zzhl.zzq(i24, 0);
                        i21 += zzb;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((i23 & i) != 0) {
                        i3 = zzhl.zzb(i24, true);
                        i2 = i3 + i21;
                        i21 = i2;
                        break;
                    }
                    i2 = i21;
                    i21 = i2;
                case 8:
                    if ((i23 & i) != 0) {
                        Object object = unsafe2.getObject(t, j2);
                        if (object instanceof zzgs) {
                            i4 = zzhl.zzc(i24, (zzgs) object);
                        } else {
                            i4 = zzhl.zzb(i24, (String) object);
                        }
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 9:
                    if ((i23 & i) != 0) {
                        i4 = zzkh.zzc(i24, unsafe2.getObject(t, j2), zzbu(i20));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 10:
                    if ((i23 & i) != 0) {
                        i4 = zzhl.zzc(i24, (zzgs) unsafe2.getObject(t, j2));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 11:
                    if ((i23 & i) != 0) {
                        i4 = zzhl.zzo(i24, unsafe2.getInt(t, j2));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 12:
                    if ((i23 & i) != 0) {
                        i4 = zzhl.zzs(i24, unsafe2.getInt(t, j2));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 13:
                    if ((i23 & i) != 0) {
                        i4 = zzhl.zzr(i24, 0);
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 14:
                    if ((i23 & i) != 0) {
                        i4 = zzhl.zzh(i24, 0);
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 15:
                    if ((i23 & i) != 0) {
                        i4 = zzhl.zzp(i24, unsafe2.getInt(t, j2));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 16:
                    if ((i23 & i) != 0) {
                        i4 = zzhl.zzf(i24, unsafe2.getLong(t, j2));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 17:
                    if ((i23 & i) != 0) {
                        i4 = zzhl.zzc(i24, (zzjn) unsafe2.getObject(t, j2), zzbu(i20));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 18:
                    i4 = zzkh.zzw(i24, (List) unsafe2.getObject(t, j2), false);
                    i21 += i4;
                    i2 = i21;
                    i21 = i2;
                    break;
                case 19:
                    zzd = zzkh.zzv(i24, (List) unsafe2.getObject(t, j2), false);
                    i21 += zzd;
                    break;
                case 20:
                    zzd = zzkh.zzo(i24, (List) unsafe2.getObject(t, j2), false);
                    i21 += zzd;
                    break;
                case 21:
                    zzd = zzkh.zzp(i24, (List) unsafe2.getObject(t, j2), false);
                    i21 += zzd;
                    break;
                case 22:
                    zzd = zzkh.zzs(i24, (List) unsafe2.getObject(t, j2), false);
                    i21 += zzd;
                    break;
                case 23:
                    zzd = zzkh.zzw(i24, (List) unsafe2.getObject(t, j2), false);
                    i21 += zzd;
                    break;
                case 24:
                    zzd = zzkh.zzv(i24, (List) unsafe2.getObject(t, j2), false);
                    i21 += zzd;
                    break;
                case 25:
                    zzd = zzkh.zzx(i24, (List) unsafe2.getObject(t, j2), false);
                    i21 += zzd;
                    break;
                case 26:
                    i4 = zzkh.zzc(i24, (List) unsafe2.getObject(t, j2));
                    i21 += i4;
                    i2 = i21;
                    i21 = i2;
                    break;
                case 27:
                    i4 = zzkh.zzc(i24, (List<?>) ((List) unsafe2.getObject(t, j2)), zzbu(i20));
                    i21 += i4;
                    i2 = i21;
                    i21 = i2;
                    break;
                case 28:
                    i4 = zzkh.zzd(i24, (List) unsafe2.getObject(t, j2));
                    i21 += i4;
                    i2 = i21;
                    i21 = i2;
                    break;
                case 29:
                    i4 = zzkh.zzt(i24, (List) unsafe2.getObject(t, j2), false);
                    i21 += i4;
                    i2 = i21;
                    i21 = i2;
                    break;
                case 30:
                    zzd = zzkh.zzr(i24, (List) unsafe2.getObject(t, j2), false);
                    i21 += zzd;
                    break;
                case 31:
                    zzd = zzkh.zzv(i24, (List) unsafe2.getObject(t, j2), false);
                    i21 += zzd;
                    break;
                case 32:
                    zzd = zzkh.zzw(i24, (List) unsafe2.getObject(t, j2), false);
                    i21 += zzd;
                    break;
                case 33:
                    zzd = zzkh.zzu(i24, (List) unsafe2.getObject(t, j2), false);
                    i21 += zzd;
                    break;
                case 34:
                    zzd = zzkh.zzq(i24, (List) unsafe2.getObject(t, j2), false);
                    i21 += zzd;
                    break;
                case 35:
                    i7 = zzkh.zzy((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzhl.zzbh(i24);
                        i5 = zzhl.zzbj(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 36:
                    i7 = zzkh.zzx((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzhl.zzbh(i24);
                        i5 = zzhl.zzbj(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 37:
                    i7 = zzkh.zzq((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzhl.zzbh(i24);
                        i5 = zzhl.zzbj(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 38:
                    i7 = zzkh.zzr((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzhl.zzbh(i24);
                        i5 = zzhl.zzbj(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 39:
                    i7 = zzkh.zzu((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzhl.zzbh(i24);
                        i5 = zzhl.zzbj(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 40:
                    i7 = zzkh.zzy((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzhl.zzbh(i24);
                        i5 = zzhl.zzbj(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 41:
                    i7 = zzkh.zzx((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzhl.zzbh(i24);
                        i5 = zzhl.zzbj(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 42:
                    i7 = zzkh.zzz((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzhl.zzbh(i24);
                        i5 = zzhl.zzbj(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 43:
                    i7 = zzkh.zzv((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzhl.zzbh(i24);
                        i5 = zzhl.zzbj(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 44:
                    i7 = zzkh.zzt((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzhl.zzbh(i24);
                        i5 = zzhl.zzbj(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 45:
                    i7 = zzkh.zzx((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzhl.zzbh(i24);
                        i5 = zzhl.zzbj(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 46:
                    i7 = zzkh.zzy((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzhl.zzbh(i24);
                        i5 = zzhl.zzbj(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 47:
                    i7 = zzkh.zzw((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzhl.zzbh(i24);
                        i5 = zzhl.zzbj(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 48:
                    i7 = zzkh.zzs((List) unsafe2.getObject(t, j2));
                    if (i7 > 0) {
                        i6 = zzhl.zzbh(i24);
                        i5 = zzhl.zzbj(i7);
                        i21 = a.G1(i5, i6, i7, i21);
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 49:
                    i4 = zzkh.zzd(i24, (List) unsafe2.getObject(t, j2), zzbu(i20));
                    i21 += i4;
                    i2 = i21;
                    i21 = i2;
                    break;
                case 50:
                    i4 = this.zzaba.zzb(i24, unsafe2.getObject(t, j2), zzbv(i20));
                    i21 += i4;
                    i2 = i21;
                    i21 = i2;
                    break;
                case 51:
                    if (zzb(t, i24, i20)) {
                        i4 = zzhl.zzb(i24, 0.0d);
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 52:
                    if (zzb(t, i24, i20)) {
                        i4 = zzhl.zzb(i24, 0.0f);
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 53:
                    if (zzb(t, i24, i20)) {
                        i4 = zzhl.zzd(i24, zzi(t, j2));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 54:
                    if (zzb(t, i24, i20)) {
                        i4 = zzhl.zze(i24, zzi(t, j2));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 55:
                    if (zzb(t, i24, i20)) {
                        i4 = zzhl.zzn(i24, zzh(t, j2));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 56:
                    if (zzb(t, i24, i20)) {
                        i4 = zzhl.zzg(i24, 0);
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 57:
                    if (zzb(t, i24, i20)) {
                        i4 = zzhl.zzq(i24, 0);
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 58:
                    if (zzb(t, i24, i20)) {
                        i4 = zzhl.zzb(i24, true);
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 59:
                    if (zzb(t, i24, i20)) {
                        Object object2 = unsafe2.getObject(t, j2);
                        if (object2 instanceof zzgs) {
                            i4 = zzhl.zzc(i24, (zzgs) object2);
                        } else {
                            i4 = zzhl.zzb(i24, (String) object2);
                        }
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 60:
                    if (zzb(t, i24, i20)) {
                        i4 = zzkh.zzc(i24, unsafe2.getObject(t, j2), zzbu(i20));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 61:
                    if (zzb(t, i24, i20)) {
                        i4 = zzhl.zzc(i24, (zzgs) unsafe2.getObject(t, j2));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 62:
                    if (zzb(t, i24, i20)) {
                        i4 = zzhl.zzo(i24, zzh(t, j2));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 63:
                    if (zzb(t, i24, i20)) {
                        i4 = zzhl.zzs(i24, zzh(t, j2));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 64:
                    if (zzb(t, i24, i20)) {
                        i4 = zzhl.zzr(i24, 0);
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 65:
                    if (zzb(t, i24, i20)) {
                        i4 = zzhl.zzh(i24, 0);
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 66:
                    if (zzb(t, i24, i20)) {
                        i4 = zzhl.zzp(i24, zzh(t, j2));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 67:
                    if (zzb(t, i24, i20)) {
                        i4 = zzhl.zzf(i24, zzi(t, j2));
                        i21 += i4;
                    }
                    i2 = i21;
                    i21 = i2;
                    break;
                case 68:
                    if (zzb(t, i24, i20)) {
                        i4 = zzhl.zzc(i24, (zzjn) unsafe2.getObject(t, j2), zzbu(i20));
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
        int zza = i21 + zza((zzkx) this.zzaay, (Object) t);
        if (!this.zzaap) {
            return zza;
        }
        zzht<?> zzh = this.zzaaz.zzh(t);
        for (int i29 = 0; i29 < zzh.zzux.zzin(); i29++) {
            Map.Entry<T, Object> zzcc = zzh.zzux.zzcc(i29);
            i28 += zzht.zzc(zzcc.getKey(), zzcc.getValue());
        }
        for (Map.Entry<T, Object> entry : zzh.zzux.zzio()) {
            i28 += zzht.zzc(entry.getKey(), entry.getValue());
        }
        return zza + i28;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.vision.zzkf] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.google.android.gms.internal.vision.zzkf] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.gms.internal.vision.zzkf
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzw(T r19) {
        /*
        // Method dump skipped, instructions count: 320
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzjr.zzw(java.lang.Object):boolean");
    }

    private final boolean zzc(T t, int i) {
        int zzby = zzby(i);
        long j = (long) (zzby & 1048575);
        if (j == 1048575) {
            int zzbx = zzbx(i);
            long j2 = (long) (zzbx & 1048575);
            switch ((zzbx & 267386880) >>> 20) {
                case 0:
                    return zzld.zzo(t, j2) != 0.0d;
                case 1:
                    return zzld.zzn(t, j2) != 0.0f;
                case 2:
                    return zzld.zzl(t, j2) != 0;
                case 3:
                    return zzld.zzl(t, j2) != 0;
                case 4:
                    return zzld.zzk(t, j2) != 0;
                case 5:
                    return zzld.zzl(t, j2) != 0;
                case 6:
                    return zzld.zzk(t, j2) != 0;
                case 7:
                    return zzld.zzm(t, j2);
                case 8:
                    Object zzp = zzld.zzp(t, j2);
                    if (zzp instanceof String) {
                        return !((String) zzp).isEmpty();
                    }
                    if (zzp instanceof zzgs) {
                        return !zzgs.zztt.equals(zzp);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzld.zzp(t, j2) != null;
                case 10:
                    return !zzgs.zztt.equals(zzld.zzp(t, j2));
                case 11:
                    return zzld.zzk(t, j2) != 0;
                case 12:
                    return zzld.zzk(t, j2) != 0;
                case 13:
                    return zzld.zzk(t, j2) != 0;
                case 14:
                    return zzld.zzl(t, j2) != 0;
                case 15:
                    return zzld.zzk(t, j2) != 0;
                case 16:
                    return zzld.zzl(t, j2) != 0;
                case 17:
                    return zzld.zzp(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zzld.zzk(t, j) & (1 << (zzby >>> 20))) != 0;
        }
    }

    private final int zzv(int i, int i2) {
        if (i < this.zzaam || i > this.zzaan) {
            return -1;
        }
        return zzw(i, i2);
    }

    private static <T> boolean zzj(T t, long j) {
        return ((Boolean) zzld.zzp(t, j)).booleanValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:170:0x0495  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r18, com.google.android.gms.internal.vision.zzlq r19) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1342
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzjr.zzb(java.lang.Object, com.google.android.gms.internal.vision.zzlq):void");
    }

    private final void zzc(T t, int i, int i2) {
        zzld.zzb(t, (long) (zzby(i2) & 1048575), i);
    }

    private final int zzw(int i, int i2) {
        int length = (this.zzaak.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzaak[i4];
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

    private final void zzd(T t, int i) {
        int zzby = zzby(i);
        long j = (long) (1048575 & zzby);
        if (j != 1048575) {
            zzld.zzb(t, j, (1 << (zzby >>> 20)) | zzld.zzk(t, j));
        }
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

    private final void zza(T t, T t2, int i) {
        long zzbx = (long) (zzbx(i) & 1048575);
        if (zzc(t2, i)) {
            Object zzp = zzld.zzp(t, zzbx);
            Object zzp2 = zzld.zzp(t2, zzbx);
            if (zzp != null && zzp2 != null) {
                zzld.zza(t, zzbx, zzie.zzb(zzp, zzp2));
                zzd(t, i);
            } else if (zzp2 != null) {
                zzld.zza(t, zzbx, zzp2);
                zzd(t, i);
            }
        }
    }

    private static <UT, UB> int zza(zzkx<UT, UB> zzkx, T t) {
        return zzkx.zzu(zzkx.zzy(t));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0552  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2a  */
    @Override // com.google.android.gms.internal.vision.zzkf
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.vision.zzlq r15) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 2916
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzjr.zza(java.lang.Object, com.google.android.gms.internal.vision.zzlq):void");
    }

    private final boolean zzb(T t, int i, int i2) {
        return zzld.zzk(t, (long) (zzby(i2) & 1048575)) == i;
    }

    private final <K, V> void zza(zzlq zzlq, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzlq.zza(i, this.zzaba.zzs(zzbv(i2)), this.zzaba.zzo(obj));
        }
    }

    private static <UT, UB> void zza(zzkx<UT, UB> zzkx, T t, zzlq zzlq) throws IOException {
        zzkx.zza(zzkx.zzy(t), zzlq);
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    @Override // com.google.android.gms.internal.vision.zzkf
    public final void zza(T r13, com.google.android.gms.internal.vision.zzkc r14, com.google.android.gms.internal.vision.zzho r15) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1646
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzjr.zza(java.lang.Object, com.google.android.gms.internal.vision.zzkc, com.google.android.gms.internal.vision.zzho):void");
    }

    private static int zza(byte[] bArr, int i, int i2, zzlk zzlk, Class<?> cls, zzgm zzgm) throws IOException {
        switch (zzjq.zztn[zzlk.ordinal()]) {
            case 1:
                int zzb = zzgk.zzb(bArr, i, zzgm);
                zzgm.zztm = Boolean.valueOf(zzgm.zztl != 0);
                return zzb;
            case 2:
                return zzgk.zze(bArr, i, zzgm);
            case 3:
                zzgm.zztm = Double.valueOf(zzgk.zzc(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzgm.zztm = Integer.valueOf(zzgk.zza(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzgm.zztm = Long.valueOf(zzgk.zzb(bArr, i));
                return i + 8;
            case 8:
                zzgm.zztm = Float.valueOf(zzgk.zzd(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int zza = zzgk.zza(bArr, i, zzgm);
                zzgm.zztm = Integer.valueOf(zzgm.zztk);
                return zza;
            case 12:
            case 13:
                int zzb2 = zzgk.zzb(bArr, i, zzgm);
                zzgm.zztm = Long.valueOf(zzgm.zztl);
                return zzb2;
            case 14:
                return zzgk.zza(zzkb.zzik().zzf(cls), bArr, i, i2, zzgm);
            case 15:
                int zza2 = zzgk.zza(bArr, i, zzgm);
                zzgm.zztm = Integer.valueOf(zzhe.zzbb(zzgm.zztk));
                return zza2;
            case 16:
                int zzb3 = zzgk.zzb(bArr, i, zzgm);
                zzgm.zztm = Long.valueOf(zzhe.zzr(zzgm.zztl));
                return zzb3;
            case 17:
                return zzgk.zzd(bArr, i, zzgm);
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
    private final int zza(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.vision.zzgm r29) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1126
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzjr.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.vision.zzgm):int");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x003e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x003e */
    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, long j, zzgm zzgm) throws IOException {
        Unsafe unsafe = zzaaj;
        Object zzbv = zzbv(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zzaba.zzp(object)) {
            Object zzr = this.zzaba.zzr(zzbv);
            this.zzaba.zzc(zzr, object);
            unsafe.putObject(t, j, zzr);
            object = zzr;
        }
        zzje<?, ?> zzs = this.zzaba.zzs(zzbv);
        Map<?, ?> zzn = this.zzaba.zzn(object);
        int zza = zzgk.zza(bArr, i, zzgm);
        int i4 = zzgm.zztk;
        if (i4 < 0 || i4 > i2 - zza) {
            throw zzin.zzhh();
        }
        int i5 = i4 + zza;
        SavedSearchView.DefaultImpls defaultImpls = (K) zzs.zzaad;
        SavedSearchView.DefaultImpls defaultImpls2 = (V) zzs.zzgk;
        while (zza < i5) {
            int i6 = zza + 1;
            byte b = bArr[zza];
            int i7 = b;
            if (b < 0) {
                i6 = zzgk.zza(b, bArr, i6, zzgm);
                i7 = zzgm.zztk;
            }
            int i8 = (i7 == 1 ? 1 : 0) >>> 3;
            int i9 = (i7 == 1 ? 1 : 0) & 7;
            if (i8 != 1) {
                if (i8 == 2 && i9 == zzs.zzaae.zzjl()) {
                    zza = zza(bArr, i6, i2, zzs.zzaae, zzs.zzgk.getClass(), zzgm);
                    defaultImpls2 = (V) zzgm.zztm;
                }
            } else if (i9 == zzs.zzaac.zzjl()) {
                zza = zza(bArr, i6, i2, zzs.zzaac, (Class<?>) null, zzgm);
                defaultImpls = (K) zzgm.zztm;
            }
            zza = zzgk.zza(i7, bArr, i6, i2, zzgm);
        }
        if (zza == i5) {
            zzn.put(defaultImpls, defaultImpls2);
            return i5;
        }
        throw zzin.zzhn();
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzgm zzgm) throws IOException {
        int i9;
        Unsafe unsafe = zzaaj;
        long j2 = (long) (this.zzaak[i8 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(zzgk.zzc(bArr, i)));
                    i9 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(zzgk.zzd(bArr, i)));
                    i9 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    i9 = zzgk.zzb(bArr, i, zzgm);
                    unsafe.putObject(t, j, Long.valueOf(zzgm.zztl));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    i9 = zzgk.zza(bArr, i, zzgm);
                    unsafe.putObject(t, j, Integer.valueOf(zzgm.zztk));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(zzgk.zzb(bArr, i)));
                    i9 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(zzgk.zza(bArr, i)));
                    i9 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    i9 = zzgk.zzb(bArr, i, zzgm);
                    unsafe.putObject(t, j, Boolean.valueOf(zzgm.zztl != 0));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    int zza = zzgk.zza(bArr, i, zzgm);
                    int i10 = zzgm.zztk;
                    if (i10 == 0) {
                        unsafe.putObject(t, j, "");
                    } else if ((i6 & 536870912) == 0 || zzlf.zzf(bArr, zza, zza + i10)) {
                        unsafe.putObject(t, j, new String(bArr, zza, i10, zzie.UTF_8));
                        zza += i10;
                    } else {
                        throw zzin.zzho();
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    int zza2 = zzgk.zza(zzbu(i8), bArr, i, i2, zzgm);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, zzgm.zztm);
                    } else {
                        unsafe.putObject(t, j, zzie.zzb(object, zzgm.zztm));
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza2;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    i9 = zzgk.zze(bArr, i, zzgm);
                    unsafe.putObject(t, j, zzgm.zztm);
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int zza3 = zzgk.zza(bArr, i, zzgm);
                    int i11 = zzgm.zztk;
                    zzij zzbw = zzbw(i8);
                    if (zzbw == null || zzbw.zzg(i11)) {
                        unsafe.putObject(t, j, Integer.valueOf(i11));
                        i9 = zza3;
                        unsafe.putInt(t, j2, i4);
                        return i9;
                    }
                    zzv(t).zzb(i3, Long.valueOf((long) i11));
                    return zza3;
                }
                return i;
            case 66:
                if (i5 == 0) {
                    i9 = zzgk.zza(bArr, i, zzgm);
                    unsafe.putObject(t, j, Integer.valueOf(zzhe.zzbb(zzgm.zztk)));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    i9 = zzgk.zzb(bArr, i, zzgm);
                    unsafe.putObject(t, j, Long.valueOf(zzhe.zzr(zzgm.zztl)));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    i9 = zzgk.zza(zzbu(i8), bArr, i, i2, (i3 & -8) | 4, zzgm);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, zzgm.zztm);
                    } else {
                        unsafe.putObject(t, j, zzie.zzb(object2, zzgm.zztm));
                    }
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            default:
                return i;
        }
    }

    public final int zza(T t, byte[] bArr, int i, int i2, int i3, zzgm zzgm) throws IOException {
        Unsafe unsafe;
        int i4;
        int i5;
        T t2;
        zzjr<T> zzjr;
        int i6;
        int i7;
        byte b;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z;
        int i14;
        int i15;
        T t3;
        byte[] bArr2;
        zzgm zzgm2;
        int i16;
        Object obj;
        Object zza;
        long j;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        T t4;
        int i23;
        int i24;
        zzjr<T> zzjr2 = this;
        T t5 = t;
        byte[] bArr3 = bArr;
        int i25 = i2;
        int i26 = i3;
        zzgm zzgm3 = zzgm;
        Unsafe unsafe2 = zzaaj;
        int i27 = i;
        int i28 = -1;
        int i29 = 0;
        int i30 = 0;
        int i31 = 0;
        int i32 = 1048575;
        while (true) {
            Object obj2 = null;
            if (i27 < i25) {
                int i33 = i27 + 1;
                byte b2 = bArr3[i27];
                if (b2 < 0) {
                    int zza2 = zzgk.zza(b2, bArr3, i33, zzgm3);
                    b = zzgm3.zztk;
                    i33 = zza2;
                } else {
                    b = b2;
                }
                int i34 = b >>> 3;
                int i35 = b & 7;
                if (i34 > i28) {
                    i8 = zzjr2.zzv(i34, i29 / 3);
                } else {
                    i8 = zzjr2.zzca(i34);
                }
                if (i8 == -1) {
                    i9 = i34;
                    i10 = i33;
                    i11 = b;
                    i12 = i31;
                    unsafe = unsafe2;
                    i13 = i26;
                    z = true;
                    i14 = 0;
                } else {
                    int[] iArr = zzjr2.zzaak;
                    int i36 = iArr[i8 + 1];
                    int i37 = (i36 & 267386880) >>> 20;
                    long j2 = (long) (i36 & 1048575);
                    if (i37 <= 17) {
                        int i38 = iArr[i8 + 2];
                        int i39 = 1 << (i38 >>> 20);
                        int i40 = i38 & 1048575;
                        if (i40 != i32) {
                            if (i32 != 1048575) {
                                long j3 = (long) i32;
                                t4 = t;
                                j = j2;
                                unsafe2.putInt(t4, j3, i31);
                            } else {
                                t4 = t;
                                j = j2;
                            }
                            i31 = unsafe2.getInt(t4, (long) i40);
                            t5 = t4;
                        } else {
                            t5 = t;
                            j = j2;
                            i40 = i32;
                        }
                        switch (i37) {
                            case 0:
                                i18 = i34;
                                i19 = i8;
                                i12 = i31;
                                i17 = i40;
                                i20 = b;
                                if (i35 == 1) {
                                    zzld.zza(t5, j, zzgk.zzc(bArr3, i33));
                                    i27 = i33 + 8;
                                    i31 = i12 | i39;
                                    i32 = i17;
                                    i30 = i20;
                                    i29 = i19;
                                    i28 = i18;
                                    i25 = i2;
                                    i26 = i3;
                                    break;
                                } else {
                                    i32 = i17;
                                    i13 = i3;
                                    i10 = i33;
                                    i11 = i20;
                                    unsafe = unsafe2;
                                    i14 = i19;
                                    i9 = i18;
                                    z = true;
                                    break;
                                }
                            case 1:
                                i18 = i34;
                                i19 = i8;
                                i12 = i31;
                                i17 = i40;
                                i20 = b;
                                if (i35 == 5) {
                                    zzld.zza((Object) t5, j, zzgk.zzd(bArr3, i33));
                                    i27 = i33 + 4;
                                    i31 = i12 | i39;
                                    i32 = i17;
                                    i30 = i20;
                                    i29 = i19;
                                    i28 = i18;
                                    i25 = i2;
                                    i26 = i3;
                                    break;
                                } else {
                                    i32 = i17;
                                    i13 = i3;
                                    i10 = i33;
                                    i11 = i20;
                                    unsafe = unsafe2;
                                    i14 = i19;
                                    i9 = i18;
                                    z = true;
                                    break;
                                }
                            case 2:
                            case 3:
                                i18 = i34;
                                i19 = i8;
                                i12 = i31;
                                i17 = i40;
                                i20 = b;
                                if (i35 == 0) {
                                    i21 = zzgk.zzb(bArr3, i33, zzgm3);
                                    unsafe2.putLong(t, j, zzgm3.zztl);
                                    i31 = i12 | i39;
                                    i32 = i17;
                                    i27 = i21;
                                    i30 = i20;
                                    i29 = i19;
                                    i28 = i18;
                                    i25 = i2;
                                    i26 = i3;
                                    break;
                                } else {
                                    i32 = i17;
                                    i13 = i3;
                                    i10 = i33;
                                    i11 = i20;
                                    unsafe = unsafe2;
                                    i14 = i19;
                                    i9 = i18;
                                    z = true;
                                    break;
                                }
                            case 4:
                            case 11:
                                i18 = i34;
                                i19 = i8;
                                i12 = i31;
                                i17 = i40;
                                i20 = b;
                                if (i35 == 0) {
                                    i27 = zzgk.zza(bArr3, i33, zzgm3);
                                    unsafe2.putInt(t5, j, zzgm3.zztk);
                                    i31 = i12 | i39;
                                    i32 = i17;
                                    i30 = i20;
                                    i29 = i19;
                                    i28 = i18;
                                    i25 = i2;
                                    i26 = i3;
                                    break;
                                } else {
                                    i32 = i17;
                                    i13 = i3;
                                    i10 = i33;
                                    i11 = i20;
                                    unsafe = unsafe2;
                                    i14 = i19;
                                    i9 = i18;
                                    z = true;
                                    break;
                                }
                            case 5:
                            case 14:
                                i18 = i34;
                                i19 = i8;
                                i12 = i31;
                                i17 = i40;
                                i20 = b;
                                if (i35 == 1) {
                                    unsafe2.putLong(t, j, zzgk.zzb(bArr3, i33));
                                    i27 = i33 + 8;
                                    i31 = i12 | i39;
                                    i32 = i17;
                                    i30 = i20;
                                    i29 = i19;
                                    i28 = i18;
                                    i25 = i2;
                                    i26 = i3;
                                    break;
                                } else {
                                    i32 = i17;
                                    i13 = i3;
                                    i10 = i33;
                                    i11 = i20;
                                    unsafe = unsafe2;
                                    i14 = i19;
                                    i9 = i18;
                                    z = true;
                                    break;
                                }
                            case 6:
                            case 13:
                                i18 = i34;
                                i19 = i8;
                                i12 = i31;
                                i17 = i40;
                                i20 = b;
                                if (i35 == 5) {
                                    unsafe2.putInt(t5, j, zzgk.zza(bArr3, i33));
                                    i27 = i33 + 4;
                                    i31 = i12 | i39;
                                    i32 = i17;
                                    i30 = i20;
                                    i29 = i19;
                                    i28 = i18;
                                    i25 = i2;
                                    i26 = i3;
                                    break;
                                } else {
                                    i32 = i17;
                                    i13 = i3;
                                    i10 = i33;
                                    i11 = i20;
                                    unsafe = unsafe2;
                                    i14 = i19;
                                    i9 = i18;
                                    z = true;
                                    break;
                                }
                            case 7:
                                i18 = i34;
                                i19 = i8;
                                i12 = i31;
                                i17 = i40;
                                i20 = b;
                                if (i35 == 0) {
                                    i27 = zzgk.zzb(bArr3, i33, zzgm3);
                                    zzld.zza(t5, j, zzgm3.zztl != 0);
                                    i31 = i12 | i39;
                                    i32 = i17;
                                    i30 = i20;
                                    i29 = i19;
                                    i28 = i18;
                                    i25 = i2;
                                    i26 = i3;
                                    break;
                                } else {
                                    i32 = i17;
                                    i13 = i3;
                                    i10 = i33;
                                    i11 = i20;
                                    unsafe = unsafe2;
                                    i14 = i19;
                                    i9 = i18;
                                    z = true;
                                    break;
                                }
                            case 8:
                                i18 = i34;
                                i19 = i8;
                                i12 = i31;
                                i17 = i40;
                                i20 = b;
                                if (i35 == 2) {
                                    if ((536870912 & i36) == 0) {
                                        i27 = zzgk.zzc(bArr3, i33, zzgm3);
                                    } else {
                                        i27 = zzgk.zzd(bArr3, i33, zzgm3);
                                    }
                                    unsafe2.putObject(t5, j, zzgm3.zztm);
                                    i31 = i12 | i39;
                                    i32 = i17;
                                    i30 = i20;
                                    i29 = i19;
                                    i28 = i18;
                                    i25 = i2;
                                    i26 = i3;
                                    break;
                                } else {
                                    i32 = i17;
                                    i13 = i3;
                                    i10 = i33;
                                    i11 = i20;
                                    unsafe = unsafe2;
                                    i14 = i19;
                                    i9 = i18;
                                    z = true;
                                    break;
                                }
                            case 9:
                                i18 = i34;
                                i19 = i8;
                                i17 = i40;
                                i20 = b;
                                if (i35 == 2) {
                                    int zza3 = zzgk.zza(zzjr2.zzbu(i19), bArr3, i33, i2, zzgm3);
                                    if ((i31 & i39) == 0) {
                                        unsafe2.putObject(t5, j, zzgm3.zztm);
                                    } else {
                                        unsafe2.putObject(t5, j, zzie.zzb(unsafe2.getObject(t5, j), zzgm3.zztm));
                                    }
                                    i32 = i17;
                                    i30 = i20;
                                    i28 = i18;
                                    i25 = i2;
                                    i31 |= i39;
                                    i27 = zza3;
                                    i29 = i19;
                                    i26 = i3;
                                    break;
                                } else {
                                    i12 = i31;
                                    i32 = i17;
                                    i13 = i3;
                                    i10 = i33;
                                    i11 = i20;
                                    unsafe = unsafe2;
                                    i14 = i19;
                                    i9 = i18;
                                    z = true;
                                    break;
                                }
                            case 10:
                                i18 = i34;
                                i19 = i8;
                                i17 = i40;
                                i20 = b;
                                if (i35 == 2) {
                                    i22 = zzgk.zze(bArr3, i33, zzgm3);
                                    unsafe2.putObject(t5, j, zzgm3.zztm);
                                    i31 |= i39;
                                    i32 = i17;
                                    i27 = i22;
                                    i30 = i20;
                                    i29 = i19;
                                    i28 = i18;
                                    i25 = i2;
                                    i26 = i3;
                                    break;
                                } else {
                                    i12 = i31;
                                    i32 = i17;
                                    i13 = i3;
                                    i10 = i33;
                                    i11 = i20;
                                    unsafe = unsafe2;
                                    i14 = i19;
                                    i9 = i18;
                                    z = true;
                                    break;
                                }
                            case 12:
                                i18 = i34;
                                i19 = i8;
                                i17 = i40;
                                i20 = b;
                                if (i35 != 0) {
                                    i12 = i31;
                                    i32 = i17;
                                    i13 = i3;
                                    i10 = i33;
                                    i11 = i20;
                                    unsafe = unsafe2;
                                    i14 = i19;
                                    i9 = i18;
                                    z = true;
                                    break;
                                } else {
                                    i22 = zzgk.zza(bArr3, i33, zzgm3);
                                    int i41 = zzgm3.zztk;
                                    zzij zzbw = zzjr2.zzbw(i19);
                                    if (zzbw == null || zzbw.zzg(i41)) {
                                        unsafe2.putInt(t5, j, i41);
                                        i31 |= i39;
                                        i32 = i17;
                                        i27 = i22;
                                        i30 = i20;
                                        i29 = i19;
                                        i28 = i18;
                                        i25 = i2;
                                        i26 = i3;
                                        break;
                                    } else {
                                        zzv(t).zzb(i20, Long.valueOf((long) i41));
                                        i27 = i22;
                                        i31 = i31;
                                        i30 = i20;
                                        i29 = i19;
                                        i28 = i18;
                                        i32 = i17;
                                        i25 = i2;
                                        i26 = i3;
                                    }
                                }
                                break;
                            case 15:
                                i18 = i34;
                                i19 = i8;
                                i17 = i40;
                                i20 = b;
                                if (i35 == 0) {
                                    i22 = zzgk.zza(bArr3, i33, zzgm3);
                                    unsafe2.putInt(t5, j, zzhe.zzbb(zzgm3.zztk));
                                    i31 |= i39;
                                    i32 = i17;
                                    i27 = i22;
                                    i30 = i20;
                                    i29 = i19;
                                    i28 = i18;
                                    i25 = i2;
                                    i26 = i3;
                                    break;
                                } else {
                                    i12 = i31;
                                    i32 = i17;
                                    i13 = i3;
                                    i10 = i33;
                                    i11 = i20;
                                    unsafe = unsafe2;
                                    i14 = i19;
                                    i9 = i18;
                                    z = true;
                                    break;
                                }
                            case 16:
                                i18 = i34;
                                i19 = i8;
                                if (i35 == 0) {
                                    i21 = zzgk.zzb(bArr3, i33, zzgm3);
                                    i17 = i40;
                                    i20 = b;
                                    unsafe2.putLong(t, j, zzhe.zzr(zzgm3.zztl));
                                    i31 |= i39;
                                    i32 = i17;
                                    i27 = i21;
                                    i30 = i20;
                                    i29 = i19;
                                    i28 = i18;
                                    i25 = i2;
                                    i26 = i3;
                                    break;
                                } else {
                                    i17 = i40;
                                    i20 = b;
                                    i12 = i31;
                                    i32 = i17;
                                    i13 = i3;
                                    i10 = i33;
                                    i11 = i20;
                                    unsafe = unsafe2;
                                    i14 = i19;
                                    i9 = i18;
                                    z = true;
                                    break;
                                }
                            case 17:
                                if (i35 == 3) {
                                    i18 = i34;
                                    i19 = i8;
                                    i27 = zzgk.zza(zzjr2.zzbu(i8), bArr, i33, i2, (i34 << 3) | 4, zzgm);
                                    if ((i31 & i39) == 0) {
                                        unsafe2.putObject(t5, j, zzgm3.zztm);
                                    } else {
                                        unsafe2.putObject(t5, j, zzie.zzb(unsafe2.getObject(t5, j), zzgm3.zztm));
                                    }
                                    i31 |= i39;
                                    i30 = b;
                                    i32 = i40;
                                    i29 = i19;
                                    i28 = i18;
                                    i25 = i2;
                                    i26 = i3;
                                    break;
                                } else {
                                    i18 = i34;
                                    i19 = i8;
                                    i12 = i31;
                                    i17 = i40;
                                    i20 = b;
                                    i32 = i17;
                                    i13 = i3;
                                    i10 = i33;
                                    i11 = i20;
                                    unsafe = unsafe2;
                                    i14 = i19;
                                    i9 = i18;
                                    z = true;
                                    break;
                                }
                            default:
                                i18 = i34;
                                i19 = i8;
                                i12 = i31;
                                i17 = i40;
                                i20 = b;
                                i32 = i17;
                                i13 = i3;
                                i10 = i33;
                                i11 = i20;
                                unsafe = unsafe2;
                                i14 = i19;
                                i9 = i18;
                                z = true;
                                break;
                        }
                    } else {
                        i12 = i31;
                        t5 = t;
                        if (i37 != 27) {
                            i14 = i8;
                            if (i37 <= 49) {
                                i24 = b;
                                z = true;
                                unsafe = unsafe2;
                                i13 = i3;
                                i9 = i34;
                                i27 = zza(t, bArr, i33, i2, b, i34, i35, i14, (long) i36, i37, j2, zzgm);
                                if (i27 == i33) {
                                    i10 = i27;
                                    i11 = i24;
                                    i32 = i32;
                                }
                            } else {
                                i13 = i3;
                                i23 = i33;
                                i24 = b;
                                unsafe = unsafe2;
                                i9 = i34;
                                z = true;
                                if (i37 != 50) {
                                    i27 = zza(t, bArr, i23, i2, i24, i9, i35, i36, i37, j2, i14, zzgm);
                                    if (i27 != i23) {
                                        t5 = t;
                                        bArr3 = bArr;
                                        i25 = i2;
                                        zzgm3 = zzgm;
                                        i30 = i24;
                                        i26 = i13;
                                        i32 = i32;
                                        i31 = i12;
                                        i29 = i14;
                                        i28 = i9;
                                        unsafe2 = unsafe;
                                        zzjr2 = this;
                                    }
                                } else if (i35 == 2) {
                                    i27 = zza(t, bArr, i23, i2, i14, j2, zzgm);
                                    if (i27 == i23) {
                                    }
                                }
                                i10 = i27;
                                i11 = i24;
                                i32 = i32;
                            }
                            t5 = t;
                            bArr3 = bArr;
                            i25 = i2;
                            zzgm3 = zzgm;
                            i26 = i13;
                            i30 = i24;
                            i32 = i32;
                            i31 = i12;
                            i29 = i14;
                            i28 = i9;
                            unsafe2 = unsafe;
                            zzjr2 = this;
                        } else if (i35 == 2) {
                            zzik zzik = (zzik) unsafe2.getObject(t5, j2);
                            if (!zzik.zzei()) {
                                int size = zzik.size();
                                zzik = zzik.zzan(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(t5, j2, zzik);
                            }
                            i27 = zzgk.zza(zzjr2.zzbu(i8), b, bArr, i33, i2, zzik, zzgm);
                            i26 = i3;
                            i30 = b;
                            i28 = i34;
                            i32 = i32;
                            i31 = i12;
                            i29 = i8;
                            i25 = i2;
                        } else {
                            i14 = i8;
                            i13 = i3;
                            i23 = i33;
                            i24 = b;
                            unsafe = unsafe2;
                            i9 = i34;
                            z = true;
                        }
                        i10 = i23;
                        i11 = i24;
                        i32 = i32;
                    }
                }
                if (i11 != i13 || i13 == 0) {
                    if (this.zzaap) {
                        zzgm2 = zzgm;
                        if (zzgm2.zzcu != zzho.zzgf()) {
                            zzid.zzg zza4 = zzgm2.zzcu.zza(this.zzaao, i9);
                            if (zza4 == null) {
                                i27 = zzgk.zza(i11, bArr, i10, i2, zzv(t), zzgm);
                                t3 = t;
                                i15 = i32;
                                i9 = i9;
                                bArr2 = bArr;
                                i16 = i2;
                            } else {
                                t3 = t;
                                T t7 = t3;
                                t7.zzhe();
                                zzht<zzid.zzd> zzht = t7.zzyg;
                                zzid.zzd zzd = zza4.zzyr;
                                boolean z2 = zzd.zzye;
                                zzlk zzlk = zzd.zzyd;
                                if (zzlk != zzlk.ENUM) {
                                    int[] iArr2 = zzgn.zztn;
                                    switch (iArr2[zzlk.ordinal()]) {
                                        case 1:
                                            i15 = i32;
                                            i9 = i9;
                                            bArr2 = bArr;
                                            i16 = i2;
                                            obj2 = Double.valueOf(zzgk.zzc(bArr2, i10));
                                            i10 += 8;
                                            obj = obj2;
                                            break;
                                        case 2:
                                            i15 = i32;
                                            i9 = i9;
                                            bArr2 = bArr;
                                            i16 = i2;
                                            obj2 = Float.valueOf(zzgk.zzd(bArr2, i10));
                                            i10 += 4;
                                            obj = obj2;
                                            break;
                                        case 3:
                                        case 4:
                                            i15 = i32;
                                            i9 = i9;
                                            bArr2 = bArr;
                                            i16 = i2;
                                            i10 = zzgk.zzb(bArr2, i10, zzgm2);
                                            obj2 = Long.valueOf(zzgm2.zztl);
                                            obj = obj2;
                                            break;
                                        case 5:
                                        case 6:
                                            i15 = i32;
                                            i9 = i9;
                                            bArr2 = bArr;
                                            i16 = i2;
                                            i10 = zzgk.zza(bArr2, i10, zzgm2);
                                            obj2 = Integer.valueOf(zzgm2.zztk);
                                            obj = obj2;
                                            break;
                                        case 7:
                                        case 8:
                                            i15 = i32;
                                            i9 = i9;
                                            bArr2 = bArr;
                                            i16 = i2;
                                            obj2 = Long.valueOf(zzgk.zzb(bArr2, i10));
                                            i10 += 8;
                                            obj = obj2;
                                            break;
                                        case 9:
                                        case 10:
                                            i15 = i32;
                                            i9 = i9;
                                            bArr2 = bArr;
                                            i16 = i2;
                                            obj2 = Integer.valueOf(zzgk.zza(bArr2, i10));
                                            i10 += 4;
                                            obj = obj2;
                                            break;
                                        case 11:
                                            i15 = i32;
                                            i9 = i9;
                                            bArr2 = bArr;
                                            i16 = i2;
                                            i10 = zzgk.zzb(bArr2, i10, zzgm2);
                                            if (zzgm2.zztl == 0) {
                                                z = false;
                                            }
                                            obj2 = Boolean.valueOf(z);
                                            obj = obj2;
                                            break;
                                        case 12:
                                            i15 = i32;
                                            i9 = i9;
                                            bArr2 = bArr;
                                            i16 = i2;
                                            i10 = zzgk.zza(bArr2, i10, zzgm2);
                                            obj2 = Integer.valueOf(zzhe.zzbb(zzgm2.zztk));
                                            obj = obj2;
                                            break;
                                        case 13:
                                            i15 = i32;
                                            i9 = i9;
                                            bArr2 = bArr;
                                            i16 = i2;
                                            i10 = zzgk.zzb(bArr2, i10, zzgm2);
                                            obj2 = Long.valueOf(zzhe.zzr(zzgm2.zztl));
                                            obj = obj2;
                                            break;
                                        case 14:
                                            throw new IllegalStateException("Shouldn't reach here.");
                                        case 15:
                                            i15 = i32;
                                            i9 = i9;
                                            bArr2 = bArr;
                                            i16 = i2;
                                            i10 = zzgk.zze(bArr2, i10, zzgm2);
                                            obj = zzgm2.zztm;
                                            break;
                                        case 16:
                                            i15 = i32;
                                            i9 = i9;
                                            bArr2 = bArr;
                                            i16 = i2;
                                            i10 = zzgk.zzc(bArr2, i10, zzgm2);
                                            obj = zzgm2.zztm;
                                            break;
                                        case 17:
                                            int i42 = (i9 << 3) | 4;
                                            i15 = i32;
                                            i16 = i2;
                                            i9 = i9;
                                            bArr2 = bArr;
                                            i10 = zzgk.zza(zzkb.zzik().zzf(zza4.zzyq.getClass()), bArr, i10, i2, i42, zzgm);
                                            obj = zzgm2.zztm;
                                            break;
                                        case 18:
                                            i10 = zzgk.zza(zzkb.zzik().zzf(zza4.zzyq.getClass()), bArr, i10, i2, zzgm2);
                                            obj = zzgm2.zztm;
                                            i15 = i32;
                                            i9 = i9;
                                            i16 = i2;
                                            bArr2 = bArr;
                                            break;
                                        default:
                                            i15 = i32;
                                            i9 = i9;
                                            bArr2 = bArr;
                                            i16 = i2;
                                            obj = obj2;
                                            break;
                                    }
                                    zzid.zzd zzd2 = zza4.zzyr;
                                    if (zzd2.zzye) {
                                        zzht.zzb((zzht<zzid.zzd>) zzd2, obj);
                                    } else {
                                        int i43 = iArr2[zzd2.zzyd.ordinal()];
                                        if ((i43 == 17 || i43 == 18) && (zza = zzht.zza((zzht<zzid.zzd>) zza4.zzyr)) != null) {
                                            obj = zzie.zzb(zza, obj);
                                        }
                                        zzht.zza((zzht<zzid.zzd>) zza4.zzyr, obj);
                                    }
                                    i27 = i10;
                                } else {
                                    zzgk.zza(bArr, i10, zzgm2);
                                    throw null;
                                }
                            }
                            i30 = i11;
                            zzjr2 = this;
                            bArr3 = bArr2;
                            t5 = t3;
                            i31 = i12;
                            i29 = i14;
                            i28 = i9;
                            i25 = i16;
                            i26 = i13;
                            zzgm3 = zzgm2;
                            unsafe2 = unsafe;
                            i32 = i15;
                        } else {
                            t3 = t;
                            bArr2 = bArr;
                        }
                    } else {
                        t3 = t;
                        bArr2 = bArr;
                        zzgm2 = zzgm;
                    }
                    i15 = i32;
                    i16 = i2;
                    i27 = zzgk.zza(i11, bArr, i10, i2, zzv(t), zzgm);
                    i30 = i11;
                    zzjr2 = this;
                    bArr3 = bArr2;
                    t5 = t3;
                    i31 = i12;
                    i29 = i14;
                    i28 = i9;
                    i25 = i16;
                    i26 = i13;
                    zzgm3 = zzgm2;
                    unsafe2 = unsafe;
                    i32 = i15;
                } else {
                    zzjr = this;
                    t2 = t;
                    i27 = i10;
                    i6 = i32;
                    i30 = i11;
                    i4 = i13;
                    i31 = i12;
                    i7 = 1048575;
                    i5 = i2;
                }
            } else {
                unsafe = unsafe2;
                i4 = i26;
                i5 = i25;
                t2 = t5;
                zzjr = zzjr2;
                i6 = i32;
                i7 = 1048575;
            }
        }
        if (i6 != i7) {
            unsafe.putInt(t2, (long) i6, i31);
        }
        zzkw zzkw = null;
        for (int i44 = zzjr.zzaau; i44 < zzjr.zzaav; i44++) {
            zzkw = (zzkw) zzjr.zza((Object) t2, zzjr.zzaat[i44], (int) zzkw, (zzkx<UT, int>) ((zzkx<UT, UB>) zzjr.zzaay));
        }
        if (zzkw != null) {
            zzjr.zzaay.zzg(t2, zzkw);
        }
        if (i4 == 0) {
            if (i27 != i5) {
                throw zzin.zzhn();
            }
        } else if (i27 > i5 || i30 != i4) {
            throw zzin.zzhn();
        }
        return i27;
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
    @Override // com.google.android.gms.internal.vision.zzkf
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.vision.zzgm r35) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 966
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzjr.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.vision.zzgm):void");
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzkx<UT, UB> zzkx) {
        zzij zzbw;
        int i2 = this.zzaak[i];
        Object zzp = zzld.zzp(obj, (long) (zzbx(i) & 1048575));
        return (zzp == null || (zzbw = zzbw(i)) == null) ? ub : (UB) zza(i, i2, (Map<K, V>) this.zzaba.zzn(zzp), zzbw, ub, zzkx);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzij zzij, UB ub, zzkx<UT, UB> zzkx) {
        zzje<?, ?> zzs = this.zzaba.zzs(zzbv(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzij.zzg(next.getValue().intValue())) {
                if (ub == null) {
                    ub = zzkx.zzjd();
                }
                zzha zzaw = zzgs.zzaw(zzjf.zza(zzs, next.getKey(), next.getValue()));
                try {
                    zzjf.zza(zzaw.zzfq(), zzs, next.getKey(), next.getValue());
                    zzkx.zza(ub, i2, zzaw.zzfp());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.android.gms.internal.vision.zzkf */
    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzkf zzkf) {
        return zzkf.zzw(zzld.zzp(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzlq zzlq) throws IOException {
        if (obj instanceof String) {
            zzlq.zza(i, (String) obj);
        } else {
            zzlq.zza(i, (zzgs) obj);
        }
    }

    private final void zza(Object obj, int i, zzkc zzkc) throws IOException {
        if (zzbz(i)) {
            zzld.zza(obj, (long) (i & 1048575), zzkc.zzew());
        } else if (this.zzaaq) {
            zzld.zza(obj, (long) (i & 1048575), zzkc.readString());
        } else {
            zzld.zza(obj, (long) (i & 1048575), zzkc.zzex());
        }
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzc(t, i);
        }
        return (i3 & i4) != 0;
    }
}
