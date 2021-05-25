package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import com.avito.android.saved_searches.SavedSearchView;
import com.google.android.gms.internal.ads.zzegp;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;
public final class zzeid<T> implements zzeiv<T> {
    private static final Unsafe zzhop = zzejt.zzbie();
    private static final int[] zzihz = new int[0];
    private final int[] zziia;
    private final Object[] zziib;
    private final int zziic;
    private final int zziid;
    private final zzehz zziie;
    private final boolean zziif;
    private final boolean zziig;
    private final boolean zziih;
    private final boolean zziii;
    private final int[] zziij;
    private final int zziik;
    private final int zziil;
    private final zzeih zziim;
    private final zzehj zziin;
    private final zzejn<?, ?> zziio;
    private final zzege<?> zziip;
    private final zzehw zziiq;

    private zzeid(int[] iArr, Object[] objArr, int i, int i2, zzehz zzehz, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzeih zzeih, zzehj zzehj, zzejn<?, ?> zzejn, zzege<?> zzege, zzehw zzehw) {
        this.zziia = iArr;
        this.zziib = objArr;
        this.zziic = i;
        this.zziid = i2;
        this.zziig = zzehz instanceof zzegp;
        this.zziih = z;
        this.zziif = zzege != null && zzege.zzj(zzehz);
        this.zziii = false;
        this.zziij = iArr2;
        this.zziik = i3;
        this.zziil = i4;
        this.zziim = zzeih;
        this.zziin = zzehj;
        this.zziio = zzejn;
        this.zziip = zzege;
        this.zziie = zzehz;
        this.zziiq = zzehw;
    }

    public static <T> zzeid<T> zza(Class<T> cls, zzehx zzehx, zzeih zzeih, zzehj zzehj, zzejn<?, ?> zzejn, zzege<?> zzege, zzehw zzehw) {
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
        if (zzehx instanceof zzeiq) {
            zzeiq zzeiq = (zzeiq) zzehx;
            int i32 = 0;
            boolean z2 = zzeiq.zzbgw() == zzegp.zze.zzigf;
            String zzbhh = zzeiq.zzbhh();
            int length = zzbhh.length();
            if (zzbhh.charAt(0) >= 55296) {
                int i33 = 1;
                while (true) {
                    i = i33 + 1;
                    if (zzbhh.charAt(i33) < 55296) {
                        break;
                    }
                    i33 = i;
                }
            } else {
                i = 1;
            }
            int i34 = i + 1;
            int charAt14 = zzbhh.charAt(i);
            if (charAt14 >= 55296) {
                int i35 = charAt14 & 8191;
                int i36 = 13;
                while (true) {
                    i31 = i34 + 1;
                    charAt13 = zzbhh.charAt(i34);
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
                iArr = zzihz;
                i7 = 0;
                i6 = 0;
                i5 = 0;
                i4 = 0;
                i3 = 0;
                i2 = 0;
            } else {
                int i37 = i34 + 1;
                int charAt15 = zzbhh.charAt(i34);
                if (charAt15 >= 55296) {
                    int i38 = charAt15 & 8191;
                    int i39 = 13;
                    while (true) {
                        i30 = i37 + 1;
                        charAt12 = zzbhh.charAt(i37);
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
                int charAt16 = zzbhh.charAt(i37);
                if (charAt16 >= 55296) {
                    int i41 = charAt16 & 8191;
                    int i42 = 13;
                    while (true) {
                        i29 = i40 + 1;
                        charAt11 = zzbhh.charAt(i40);
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
                i6 = zzbhh.charAt(i40);
                if (i6 >= 55296) {
                    int i44 = i6 & 8191;
                    int i45 = 13;
                    while (true) {
                        i28 = i43 + 1;
                        charAt10 = zzbhh.charAt(i43);
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
                i5 = zzbhh.charAt(i43);
                if (i5 >= 55296) {
                    int i47 = i5 & 8191;
                    int i48 = 13;
                    while (true) {
                        i27 = i46 + 1;
                        charAt9 = zzbhh.charAt(i46);
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
                i4 = zzbhh.charAt(i46);
                if (i4 >= 55296) {
                    int i50 = i4 & 8191;
                    int i51 = 13;
                    while (true) {
                        i26 = i49 + 1;
                        charAt8 = zzbhh.charAt(i49);
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
                i3 = zzbhh.charAt(i49);
                if (i3 >= 55296) {
                    int i53 = i3 & 8191;
                    int i54 = 13;
                    while (true) {
                        i25 = i52 + 1;
                        charAt7 = zzbhh.charAt(i52);
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
                int charAt17 = zzbhh.charAt(i52);
                if (charAt17 >= 55296) {
                    int i56 = charAt17 & 8191;
                    int i57 = 13;
                    while (true) {
                        i24 = i55 + 1;
                        charAt6 = zzbhh.charAt(i55);
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
                i2 = zzbhh.charAt(i55);
                if (i2 >= 55296) {
                    int i59 = i2 & 8191;
                    int i60 = i58;
                    int i61 = 13;
                    while (true) {
                        i23 = i60 + 1;
                        charAt5 = zzbhh.charAt(i60);
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
            Unsafe unsafe = zzhop;
            Object[] zzbhi = zzeiq.zzbhi();
            Class<?> cls2 = zzeiq.zzbgy().getClass();
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
                int charAt18 = zzbhh.charAt(i65);
                if (charAt18 >= 55296) {
                    int i70 = charAt18 & 8191;
                    int i71 = i69;
                    int i72 = 13;
                    while (true) {
                        i22 = i71 + 1;
                        charAt4 = zzbhh.charAt(i71);
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
                int charAt19 = zzbhh.charAt(i9);
                if (charAt19 >= 55296) {
                    int i74 = charAt19 & 8191;
                    int i75 = i73;
                    int i76 = 13;
                    while (true) {
                        i21 = i75 + 1;
                        charAt3 = zzbhh.charAt(i75);
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
                    int charAt20 = zzbhh.charAt(i11);
                    char c = 55296;
                    if (charAt20 >= 55296) {
                        int i79 = charAt20 & 8191;
                        int i80 = 13;
                        while (true) {
                            i20 = i78 + 1;
                            charAt2 = zzbhh.charAt(i78);
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
                        objArr2[((i68 / 3) << 1) + 1] = zzbhi[i63];
                        i63++;
                    } else {
                        if (i81 == 12 && !z2) {
                            objArr2[((i68 / 3) << 1) + 1] = zzbhi[i63];
                            i63++;
                        }
                        i19 = 1;
                    }
                    int i82 = charAt20 << i19;
                    Object obj = zzbhi[i82];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zza(cls2, (String) obj);
                        zzbhi[i82] = field2;
                    }
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i83 = i82 + 1;
                    Object obj2 = zzbhi[i83];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zza(cls2, (String) obj2);
                        zzbhi[i83] = field3;
                    }
                    str = zzbhh;
                    i14 = (int) unsafe.objectFieldOffset(field3);
                    z = z2;
                    objArr = objArr2;
                    i13 = objectFieldOffset;
                    i12 = i78;
                    i15 = 0;
                } else {
                    int i84 = i63 + 1;
                    Field zza = zza(cls2, (String) zzbhi[i63]);
                    if (i77 == 9 || i77 == 17) {
                        objArr2[((i68 / 3) << 1) + 1] = zza.getType();
                    } else {
                        if (i77 == 27 || i77 == 49) {
                            i18 = i84 + 1;
                            objArr2[((i68 / 3) << 1) + 1] = zzbhi[i84];
                        } else if (i77 == 12 || i77 == 30 || i77 == 44) {
                            if (!z2) {
                                i18 = i84 + 1;
                                objArr2[((i68 / 3) << 1) + 1] = zzbhi[i84];
                            }
                        } else if (i77 == 50) {
                            int i85 = i64 + 1;
                            iArr[i64] = i68;
                            int i86 = (i68 / 3) << 1;
                            i18 = i84 + 1;
                            objArr2[i86] = zzbhi[i84];
                            if ((charAt19 & 2048) != 0) {
                                i84 = i18 + 1;
                                objArr2[i86 + 1] = zzbhi[i18];
                                i64 = i85;
                            } else {
                                i64 = i85;
                            }
                        }
                        i16 = i18;
                        i13 = (int) unsafe.objectFieldOffset(zza);
                        if ((charAt19 & 4096) == 4096 || i77 > 17) {
                            str = zzbhh;
                            z = z2;
                            objArr = objArr2;
                            i14 = 1048575;
                            i12 = i11;
                            i15 = 0;
                        } else {
                            int i87 = i11 + 1;
                            int charAt21 = zzbhh.charAt(i11);
                            if (charAt21 >= 55296) {
                                int i88 = charAt21 & 8191;
                                int i89 = 13;
                                while (true) {
                                    i17 = i87 + 1;
                                    charAt = zzbhh.charAt(i87);
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
                            Object obj3 = zzbhi[i90];
                            str = zzbhh;
                            if (obj3 instanceof Field) {
                                field = (Field) obj3;
                            } else {
                                field = zza(cls2, (String) obj3);
                                zzbhi[i90] = field;
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
                    str = zzbhh;
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
                zzbhh = str;
            }
            return new zzeid<>(iArr2, objArr2, i6, i5, zzeiq.zzbgy(), z2, false, iArr, i2, i62, zzeih, zzehj, zzejn, zzege, zzehw);
        }
        ((zzejk) zzehx).zzbgw();
        int i94 = zzegp.zze.zzigf;
        throw new NoSuchMethodError();
    }

    private final int zzan(int i, int i2) {
        if (i < this.zziic || i > this.zziid) {
            return -1;
        }
        return zzao(i, i2);
    }

    private final int zzao(int i, int i2) {
        int length = (this.zziia.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zziia[i4];
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

    private static zzejq zzau(Object obj) {
        zzegp zzegp = (zzegp) obj;
        zzejq zzejq = zzegp.zzifo;
        if (zzejq != zzejq.zzbhz()) {
            return zzejq;
        }
        zzejq zzbia = zzejq.zzbia();
        zzegp.zzifo = zzbia;
        return zzbia;
    }

    private final void zzb(T t, T t2, int i) {
        int zzhi = zzhi(i);
        int i2 = this.zziia[i];
        long j = (long) (zzhi & 1048575);
        if (zza(t2, i2, i)) {
            Object zzp = zzejt.zzp(t, j);
            Object zzp2 = zzejt.zzp(t2, j);
            if (zzp != null && zzp2 != null) {
                zzejt.zza(t, j, zzegr.zze(zzp, zzp2));
                zzb(t, i2, i);
            } else if (zzp2 != null) {
                zzejt.zza(t, j, zzp2);
                zzb(t, i2, i);
            }
        }
    }

    private final boolean zzc(T t, T t2, int i) {
        return zze(t, i) == zze(t2, i);
    }

    private static List<?> zze(Object obj, long j) {
        return (List) zzejt.zzp(obj, j);
    }

    private static <T> double zzf(T t, long j) {
        return ((Double) zzejt.zzp(t, j)).doubleValue();
    }

    private static <T> int zzh(T t, long j) {
        return ((Integer) zzejt.zzp(t, j)).intValue();
    }

    private final zzeiv zzhf(int i) {
        int i2 = (i / 3) << 1;
        zzeiv zzeiv = (zzeiv) this.zziib[i2];
        if (zzeiv != null) {
            return zzeiv;
        }
        zzeiv<T> zzh = zzeio.zzbhg().zzh((Class) this.zziib[i2 + 1]);
        this.zziib[i2] = zzh;
        return zzh;
    }

    private final Object zzhg(int i) {
        return this.zziib[(i / 3) << 1];
    }

    private final zzegw zzhh(int i) {
        return (zzegw) this.zziib[((i / 3) << 1) + 1];
    }

    private final int zzhi(int i) {
        return this.zziia[i + 1];
    }

    private final int zzhj(int i) {
        return this.zziia[i + 2];
    }

    private static boolean zzhk(int i) {
        return (i & 536870912) != 0;
    }

    private final int zzhl(int i) {
        if (i < this.zziic || i > this.zziid) {
            return -1;
        }
        return zzao(i, 0);
    }

    private static <T> long zzi(T t, long j) {
        return ((Long) zzejt.zzp(t, j)).longValue();
    }

    private static <T> boolean zzj(T t, long j) {
        return ((Boolean) zzejt.zzp(t, j)).booleanValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.ads.zzeix.zzh(com.google.android.gms.internal.ads.zzejt.zzp(r10, r6), com.google.android.gms.internal.ads.zzejt.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.ads.zzejt.zzl(r10, r6) == com.google.android.gms.internal.ads.zzejt.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.ads.zzejt.zzk(r10, r6) == com.google.android.gms.internal.ads.zzejt.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.ads.zzejt.zzl(r10, r6) == com.google.android.gms.internal.ads.zzejt.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.ads.zzejt.zzk(r10, r6) == com.google.android.gms.internal.ads.zzejt.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.ads.zzejt.zzk(r10, r6) == com.google.android.gms.internal.ads.zzejt.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.ads.zzejt.zzk(r10, r6) == com.google.android.gms.internal.ads.zzejt.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.ads.zzeix.zzh(com.google.android.gms.internal.ads.zzejt.zzp(r10, r6), com.google.android.gms.internal.ads.zzejt.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.ads.zzeix.zzh(com.google.android.gms.internal.ads.zzejt.zzp(r10, r6), com.google.android.gms.internal.ads.zzejt.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.ads.zzeix.zzh(com.google.android.gms.internal.ads.zzejt.zzp(r10, r6), com.google.android.gms.internal.ads.zzejt.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.ads.zzejt.zzm(r10, r6) == com.google.android.gms.internal.ads.zzejt.zzm(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.ads.zzejt.zzk(r10, r6) == com.google.android.gms.internal.ads.zzejt.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.ads.zzejt.zzl(r10, r6) == com.google.android.gms.internal.ads.zzejt.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.ads.zzejt.zzk(r10, r6) == com.google.android.gms.internal.ads.zzejt.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.ads.zzejt.zzl(r10, r6) == com.google.android.gms.internal.ads.zzejt.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.ads.zzejt.zzl(r10, r6) == com.google.android.gms.internal.ads.zzejt.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.ads.zzejt.zzn(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.ads.zzejt.zzn(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.ads.zzejt.zzo(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.ads.zzejt.zzo(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.ads.zzeix.zzh(com.google.android.gms.internal.ads.zzejt.zzp(r10, r6), com.google.android.gms.internal.ads.zzejt.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    @Override // com.google.android.gms.internal.ads.zzeiv
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r10, T r11) {
        /*
        // Method dump skipped, instructions count: 640
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeid.equals(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzeiv
    public final int hashCode(T t) {
        int i;
        int i2;
        int i3;
        int i4;
        int length = this.zziia.length;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6 += 3) {
            int zzhi = zzhi(i6);
            int i7 = this.zziia[i6];
            long j = (long) (1048575 & zzhi);
            int i8 = 37;
            switch ((zzhi & 267386880) >>> 20) {
                case 0:
                    i2 = i5 * 53;
                    i = zzegr.zzfr(Double.doubleToLongBits(zzejt.zzo(t, j)));
                    i5 = i + i2;
                    break;
                case 1:
                    i2 = i5 * 53;
                    i = Float.floatToIntBits(zzejt.zzn(t, j));
                    i5 = i + i2;
                    break;
                case 2:
                    i2 = i5 * 53;
                    i = zzegr.zzfr(zzejt.zzl(t, j));
                    i5 = i + i2;
                    break;
                case 3:
                    i2 = i5 * 53;
                    i = zzegr.zzfr(zzejt.zzl(t, j));
                    i5 = i + i2;
                    break;
                case 4:
                    i2 = i5 * 53;
                    i = zzejt.zzk(t, j);
                    i5 = i + i2;
                    break;
                case 5:
                    i2 = i5 * 53;
                    i = zzegr.zzfr(zzejt.zzl(t, j));
                    i5 = i + i2;
                    break;
                case 6:
                    i2 = i5 * 53;
                    i = zzejt.zzk(t, j);
                    i5 = i + i2;
                    break;
                case 7:
                    i2 = i5 * 53;
                    i = zzegr.zzbu(zzejt.zzm(t, j));
                    i5 = i + i2;
                    break;
                case 8:
                    i2 = i5 * 53;
                    i = ((String) zzejt.zzp(t, j)).hashCode();
                    i5 = i + i2;
                    break;
                case 9:
                    Object zzp = zzejt.zzp(t, j);
                    if (zzp != null) {
                        i8 = zzp.hashCode();
                    }
                    i5 = (i5 * 53) + i8;
                    break;
                case 10:
                    i2 = i5 * 53;
                    i = zzejt.zzp(t, j).hashCode();
                    i5 = i + i2;
                    break;
                case 11:
                    i2 = i5 * 53;
                    i = zzejt.zzk(t, j);
                    i5 = i + i2;
                    break;
                case 12:
                    i2 = i5 * 53;
                    i = zzejt.zzk(t, j);
                    i5 = i + i2;
                    break;
                case 13:
                    i2 = i5 * 53;
                    i = zzejt.zzk(t, j);
                    i5 = i + i2;
                    break;
                case 14:
                    i2 = i5 * 53;
                    i = zzegr.zzfr(zzejt.zzl(t, j));
                    i5 = i + i2;
                    break;
                case 15:
                    i2 = i5 * 53;
                    i = zzejt.zzk(t, j);
                    i5 = i + i2;
                    break;
                case 16:
                    i2 = i5 * 53;
                    i = zzegr.zzfr(zzejt.zzl(t, j));
                    i5 = i + i2;
                    break;
                case 17:
                    Object zzp2 = zzejt.zzp(t, j);
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
                    i = zzejt.zzp(t, j).hashCode();
                    i5 = i + i2;
                    break;
                case 50:
                    i2 = i5 * 53;
                    i = zzejt.zzp(t, j).hashCode();
                    i5 = i + i2;
                    break;
                case 51:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzegr.zzfr(Double.doubleToLongBits(zzf(t, j)));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = Float.floatToIntBits(zzg(t, j));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzegr.zzfr(zzi(t, j));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzegr.zzfr(zzi(t, j));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zza(t, i7, i6)) {
                        i4 = i5 * 53;
                        i3 = zzh(t, j);
                        i5 = i4 + i3;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzegr.zzfr(zzi(t, j));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zza(t, i7, i6)) {
                        i4 = i5 * 53;
                        i3 = zzh(t, j);
                        i5 = i4 + i3;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzegr.zzbu(zzj(t, j));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = ((String) zzejt.zzp(t, j)).hashCode();
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzejt.zzp(t, j).hashCode();
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzejt.zzp(t, j).hashCode();
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zza(t, i7, i6)) {
                        i4 = i5 * 53;
                        i3 = zzh(t, j);
                        i5 = i4 + i3;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zza(t, i7, i6)) {
                        i4 = i5 * 53;
                        i3 = zzh(t, j);
                        i5 = i4 + i3;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zza(t, i7, i6)) {
                        i4 = i5 * 53;
                        i3 = zzh(t, j);
                        i5 = i4 + i3;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzegr.zzfr(zzi(t, j));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zza(t, i7, i6)) {
                        i4 = i5 * 53;
                        i3 = zzh(t, j);
                        i5 = i4 + i3;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzegr.zzfr(zzi(t, j));
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zza(t, i7, i6)) {
                        i2 = i5 * 53;
                        i = zzejt.zzp(t, j).hashCode();
                        i5 = i + i2;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = this.zziio.zzax(t).hashCode() + (i5 * 53);
        return this.zziif ? (hashCode * 53) + this.zziip.zzah(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzeiv
    public final T newInstance() {
        return (T) this.zziim.newInstance(this.zziie);
    }

    @Override // com.google.android.gms.internal.ads.zzeiv
    public final void zzaj(T t) {
        int i;
        int i2 = this.zziik;
        while (true) {
            i = this.zziil;
            if (i2 >= i) {
                break;
            }
            long zzhi = (long) (zzhi(this.zziij[i2]) & 1048575);
            Object zzp = zzejt.zzp(t, zzhi);
            if (zzp != null) {
                zzejt.zza(t, zzhi, this.zziiq.zzar(zzp));
            }
            i2++;
        }
        int length = this.zziij.length;
        while (i < length) {
            this.zziin.zzb(t, (long) this.zziij[i]);
            i++;
        }
        this.zziio.zzaj(t);
        if (this.zziif) {
            this.zziip.zzaj(t);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.ads.zzeiv
    public final int zzat(T t) {
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
        if (this.zziih) {
            Unsafe unsafe = zzhop;
            int i16 = 0;
            int i17 = 0;
            while (i16 < this.zziia.length) {
                int zzhi = zzhi(i16);
                int i18 = (i14 & zzhi) >>> 20;
                int i19 = this.zziia[i16];
                long j = (long) (zzhi & 1048575);
                int i20 = (i18 < zzegj.DOUBLE_LIST_PACKED.id() || i18 > zzegj.SINT64_LIST_PACKED.id()) ? 0 : this.zziia[i16 + 2] & 1048575;
                switch (i18) {
                    case 0:
                        if (zze((zzeid<T>) t, i16)) {
                            i10 = zzefz.zzc(i19, 0.0d);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zze((zzeid<T>) t, i16)) {
                            i10 = zzefz.zzb(i19, 0.0f);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zze((zzeid<T>) t, i16)) {
                            i10 = zzefz.zzk(i19, zzejt.zzl(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zze((zzeid<T>) t, i16)) {
                            i10 = zzefz.zzl(i19, zzejt.zzl(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zze((zzeid<T>) t, i16)) {
                            i10 = zzefz.zzaf(i19, zzejt.zzk(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zze((zzeid<T>) t, i16)) {
                            i10 = zzefz.zzn(i19, 0);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zze((zzeid<T>) t, i16)) {
                            i10 = zzefz.zzai(i19, 0);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zze((zzeid<T>) t, i16)) {
                            i10 = zzefz.zzi(i19, true);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zze((zzeid<T>) t, i16)) {
                            Object zzp = zzejt.zzp(t, j);
                            if (zzp instanceof zzeff) {
                                i10 = zzefz.zzc(i19, (zzeff) zzp);
                            } else {
                                i10 = zzefz.zzj(i19, (String) zzp);
                            }
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (zze((zzeid<T>) t, i16)) {
                            i10 = zzeix.zzc(i19, zzejt.zzp(t, j), zzhf(i16));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zze((zzeid<T>) t, i16)) {
                            i10 = zzefz.zzc(i19, (zzeff) zzejt.zzp(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zze((zzeid<T>) t, i16)) {
                            i10 = zzefz.zzag(i19, zzejt.zzk(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zze((zzeid<T>) t, i16)) {
                            i10 = zzefz.zzak(i19, zzejt.zzk(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zze((zzeid<T>) t, i16)) {
                            i10 = zzefz.zzaj(i19, 0);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zze((zzeid<T>) t, i16)) {
                            i10 = zzefz.zzo(i19, 0);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zze((zzeid<T>) t, i16)) {
                            i10 = zzefz.zzah(i19, zzejt.zzk(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zze((zzeid<T>) t, i16)) {
                            i10 = zzefz.zzm(i19, zzejt.zzl(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zze((zzeid<T>) t, i16)) {
                            i10 = zzefz.zzc(i19, (zzehz) zzejt.zzp(t, j), zzhf(i16));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        i10 = zzeix.zzw(i19, zze(t, j), false);
                        i17 += i10;
                        break;
                    case 19:
                        i10 = zzeix.zzv(i19, zze(t, j), false);
                        i17 += i10;
                        break;
                    case 20:
                        i10 = zzeix.zzo(i19, zze(t, j), false);
                        i17 += i10;
                        break;
                    case 21:
                        i10 = zzeix.zzp(i19, zze(t, j), false);
                        i17 += i10;
                        break;
                    case 22:
                        i10 = zzeix.zzs(i19, zze(t, j), false);
                        i17 += i10;
                        break;
                    case 23:
                        i10 = zzeix.zzw(i19, zze(t, j), false);
                        i17 += i10;
                        break;
                    case 24:
                        i10 = zzeix.zzv(i19, zze(t, j), false);
                        i17 += i10;
                        break;
                    case 25:
                        i10 = zzeix.zzx(i19, zze(t, j), false);
                        i17 += i10;
                        break;
                    case 26:
                        i10 = zzeix.zzc(i19, zze(t, j));
                        i17 += i10;
                        break;
                    case 27:
                        i10 = zzeix.zzc(i19, zze(t, j), zzhf(i16));
                        i17 += i10;
                        break;
                    case 28:
                        i10 = zzeix.zzd(i19, zze(t, j));
                        i17 += i10;
                        break;
                    case 29:
                        i10 = zzeix.zzt(i19, zze(t, j), false);
                        i17 += i10;
                        break;
                    case 30:
                        i10 = zzeix.zzr(i19, zze(t, j), false);
                        i17 += i10;
                        break;
                    case 31:
                        i10 = zzeix.zzv(i19, zze(t, j), false);
                        i17 += i10;
                        break;
                    case 32:
                        i10 = zzeix.zzw(i19, zze(t, j), false);
                        i17 += i10;
                        break;
                    case 33:
                        i10 = zzeix.zzu(i19, zze(t, j), false);
                        i17 += i10;
                        break;
                    case 34:
                        i10 = zzeix.zzq(i19, zze(t, j), false);
                        i17 += i10;
                        break;
                    case 35:
                        i13 = zzeix.zzai((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zziii) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzefz.zzgq(i19);
                            i11 = zzefz.zzgs(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 36:
                        i13 = zzeix.zzah((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zziii) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzefz.zzgq(i19);
                            i11 = zzefz.zzgs(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 37:
                        i13 = zzeix.zzaa((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zziii) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzefz.zzgq(i19);
                            i11 = zzefz.zzgs(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 38:
                        i13 = zzeix.zzab((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zziii) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzefz.zzgq(i19);
                            i11 = zzefz.zzgs(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 39:
                        i13 = zzeix.zzae((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zziii) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzefz.zzgq(i19);
                            i11 = zzefz.zzgs(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 40:
                        i13 = zzeix.zzai((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zziii) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzefz.zzgq(i19);
                            i11 = zzefz.zzgs(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 41:
                        i13 = zzeix.zzah((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zziii) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzefz.zzgq(i19);
                            i11 = zzefz.zzgs(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 42:
                        i13 = zzeix.zzaj((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zziii) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzefz.zzgq(i19);
                            i11 = zzefz.zzgs(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 43:
                        i13 = zzeix.zzaf((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zziii) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzefz.zzgq(i19);
                            i11 = zzefz.zzgs(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 44:
                        i13 = zzeix.zzad((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zziii) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzefz.zzgq(i19);
                            i11 = zzefz.zzgs(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 45:
                        i13 = zzeix.zzah((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zziii) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzefz.zzgq(i19);
                            i11 = zzefz.zzgs(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 46:
                        i13 = zzeix.zzai((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zziii) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzefz.zzgq(i19);
                            i11 = zzefz.zzgs(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 47:
                        i13 = zzeix.zzag((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zziii) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzefz.zzgq(i19);
                            i11 = zzefz.zzgs(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 48:
                        i13 = zzeix.zzac((List) unsafe.getObject(t, j));
                        if (i13 <= 0) {
                            break;
                        } else {
                            if (this.zziii) {
                                unsafe.putInt(t, (long) i20, i13);
                            }
                            i12 = zzefz.zzgq(i19);
                            i11 = zzefz.zzgs(i13);
                            i17 = a.G1(i11, i12, i13, i17);
                            break;
                        }
                    case 49:
                        i10 = zzeix.zzd(i19, zze(t, j), zzhf(i16));
                        i17 += i10;
                        break;
                    case 50:
                        i10 = this.zziiq.zzb(i19, zzejt.zzp(t, j), zzhg(i16));
                        i17 += i10;
                        break;
                    case 51:
                        if (zza(t, i19, i16)) {
                            i10 = zzefz.zzc(i19, 0.0d);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zza(t, i19, i16)) {
                            i10 = zzefz.zzb(i19, 0.0f);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zza(t, i19, i16)) {
                            i10 = zzefz.zzk(i19, zzi(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zza(t, i19, i16)) {
                            i10 = zzefz.zzl(i19, zzi(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zza(t, i19, i16)) {
                            i10 = zzefz.zzaf(i19, zzh(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zza(t, i19, i16)) {
                            i10 = zzefz.zzn(i19, 0);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zza(t, i19, i16)) {
                            i10 = zzefz.zzai(i19, 0);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zza(t, i19, i16)) {
                            i10 = zzefz.zzi(i19, true);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zza(t, i19, i16)) {
                            Object zzp2 = zzejt.zzp(t, j);
                            if (zzp2 instanceof zzeff) {
                                i10 = zzefz.zzc(i19, (zzeff) zzp2);
                            } else {
                                i10 = zzefz.zzj(i19, (String) zzp2);
                            }
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (zza(t, i19, i16)) {
                            i10 = zzeix.zzc(i19, zzejt.zzp(t, j), zzhf(i16));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zza(t, i19, i16)) {
                            i10 = zzefz.zzc(i19, (zzeff) zzejt.zzp(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zza(t, i19, i16)) {
                            i10 = zzefz.zzag(i19, zzh(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zza(t, i19, i16)) {
                            i10 = zzefz.zzak(i19, zzh(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zza(t, i19, i16)) {
                            i10 = zzefz.zzaj(i19, 0);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zza(t, i19, i16)) {
                            i10 = zzefz.zzo(i19, 0);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zza(t, i19, i16)) {
                            i10 = zzefz.zzah(i19, zzh(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zza(t, i19, i16)) {
                            i10 = zzefz.zzm(i19, zzi(t, j));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zza(t, i19, i16)) {
                            i10 = zzefz.zzc(i19, (zzehz) zzejt.zzp(t, j), zzhf(i16));
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                }
                i16 += 3;
                i14 = 267386880;
            }
            return i17 + zza((zzejn) this.zziio, (Object) t);
        }
        Unsafe unsafe2 = zzhop;
        int i21 = 0;
        int i22 = 0;
        int i23 = 1048575;
        int i24 = 0;
        while (i21 < this.zziia.length) {
            int zzhi2 = zzhi(i21);
            int[] iArr = this.zziia;
            int i25 = iArr[i21];
            int i26 = (267386880 & zzhi2) >>> 20;
            if (i26 <= 17) {
                i2 = iArr[i21 + 2];
                int i27 = i2 & i15;
                i = 1 << (i2 >>> 20);
                if (i27 != i23) {
                    i24 = unsafe2.getInt(t, (long) i27);
                    i23 = i27;
                }
            } else {
                i2 = (!this.zziii || i26 < zzegj.DOUBLE_LIST_PACKED.id() || i26 > zzegj.SINT64_LIST_PACKED.id()) ? 0 : this.zziia[i21 + 2] & i15;
                i = 0;
            }
            long j2 = (long) (zzhi2 & i15);
            switch (i26) {
                case 0:
                    if ((i24 & i) != 0) {
                        i4 = zzefz.zzc(i25, 0.0d);
                        i3 = i4 + i22;
                        i22 = i3;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i24 & i) != 0) {
                        i22 += zzefz.zzb(i25, 0.0f);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((i24 & i) != 0) {
                        i5 = zzefz.zzk(i25, unsafe2.getLong(t, j2));
                        i22 += i5;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i24 & i) != 0) {
                        i5 = zzefz.zzl(i25, unsafe2.getLong(t, j2));
                        i22 += i5;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i24 & i) != 0) {
                        i5 = zzefz.zzaf(i25, unsafe2.getInt(t, j2));
                        i22 += i5;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i24 & i) != 0) {
                        i5 = zzefz.zzn(i25, 0);
                        i22 += i5;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((i24 & i) != 0) {
                        i4 = zzefz.zzai(i25, 0);
                        i3 = i4 + i22;
                        i22 = i3;
                        break;
                    }
                    i3 = i22;
                    i22 = i3;
                case 7:
                    if ((i24 & i) != 0) {
                        i6 = zzefz.zzi(i25, true);
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 8:
                    if ((i24 & i) != 0) {
                        Object object = unsafe2.getObject(t, j2);
                        if (object instanceof zzeff) {
                            i6 = zzefz.zzc(i25, (zzeff) object);
                        } else {
                            i6 = zzefz.zzj(i25, (String) object);
                        }
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 9:
                    if ((i24 & i) != 0) {
                        i6 = zzeix.zzc(i25, unsafe2.getObject(t, j2), zzhf(i21));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 10:
                    if ((i24 & i) != 0) {
                        i6 = zzefz.zzc(i25, (zzeff) unsafe2.getObject(t, j2));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 11:
                    if ((i24 & i) != 0) {
                        i6 = zzefz.zzag(i25, unsafe2.getInt(t, j2));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 12:
                    if ((i24 & i) != 0) {
                        i6 = zzefz.zzak(i25, unsafe2.getInt(t, j2));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 13:
                    if ((i24 & i) != 0) {
                        i6 = zzefz.zzaj(i25, 0);
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 14:
                    if ((i24 & i) != 0) {
                        i6 = zzefz.zzo(i25, 0);
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 15:
                    if ((i24 & i) != 0) {
                        i6 = zzefz.zzah(i25, unsafe2.getInt(t, j2));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 16:
                    if ((i24 & i) != 0) {
                        i6 = zzefz.zzm(i25, unsafe2.getLong(t, j2));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 17:
                    if ((i24 & i) != 0) {
                        i6 = zzefz.zzc(i25, (zzehz) unsafe2.getObject(t, j2), zzhf(i21));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 18:
                    i6 = zzeix.zzw(i25, (List) unsafe2.getObject(t, j2), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 19:
                    i6 = zzeix.zzv(i25, (List) unsafe2.getObject(t, j2), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 20:
                    i6 = zzeix.zzo(i25, (List) unsafe2.getObject(t, j2), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 21:
                    i6 = zzeix.zzp(i25, (List) unsafe2.getObject(t, j2), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 22:
                    i6 = zzeix.zzs(i25, (List) unsafe2.getObject(t, j2), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 23:
                    i6 = zzeix.zzw(i25, (List) unsafe2.getObject(t, j2), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 24:
                    i6 = zzeix.zzv(i25, (List) unsafe2.getObject(t, j2), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 25:
                    i6 = zzeix.zzx(i25, (List) unsafe2.getObject(t, j2), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 26:
                    i6 = zzeix.zzc(i25, (List) unsafe2.getObject(t, j2));
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 27:
                    i6 = zzeix.zzc(i25, (List<?>) ((List) unsafe2.getObject(t, j2)), zzhf(i21));
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 28:
                    i6 = zzeix.zzd(i25, (List) unsafe2.getObject(t, j2));
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 29:
                    i6 = zzeix.zzt(i25, (List) unsafe2.getObject(t, j2), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 30:
                    i6 = zzeix.zzr(i25, (List) unsafe2.getObject(t, j2), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 31:
                    i6 = zzeix.zzv(i25, (List) unsafe2.getObject(t, j2), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 32:
                    i6 = zzeix.zzw(i25, (List) unsafe2.getObject(t, j2), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 33:
                    i6 = zzeix.zzu(i25, (List) unsafe2.getObject(t, j2), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 34:
                    i6 = zzeix.zzq(i25, (List) unsafe2.getObject(t, j2), false);
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 35:
                    i9 = zzeix.zzai((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zziii) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzefz.zzgq(i25);
                        i7 = zzefz.zzgs(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 36:
                    i9 = zzeix.zzah((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zziii) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzefz.zzgq(i25);
                        i7 = zzefz.zzgs(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 37:
                    i9 = zzeix.zzaa((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zziii) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzefz.zzgq(i25);
                        i7 = zzefz.zzgs(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 38:
                    i9 = zzeix.zzab((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zziii) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzefz.zzgq(i25);
                        i7 = zzefz.zzgs(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 39:
                    i9 = zzeix.zzae((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zziii) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzefz.zzgq(i25);
                        i7 = zzefz.zzgs(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 40:
                    i9 = zzeix.zzai((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zziii) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzefz.zzgq(i25);
                        i7 = zzefz.zzgs(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 41:
                    i9 = zzeix.zzah((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zziii) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzefz.zzgq(i25);
                        i7 = zzefz.zzgs(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 42:
                    i9 = zzeix.zzaj((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zziii) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzefz.zzgq(i25);
                        i7 = zzefz.zzgs(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 43:
                    i9 = zzeix.zzaf((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zziii) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzefz.zzgq(i25);
                        i7 = zzefz.zzgs(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 44:
                    i9 = zzeix.zzad((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zziii) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzefz.zzgq(i25);
                        i7 = zzefz.zzgs(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 45:
                    i9 = zzeix.zzah((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zziii) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzefz.zzgq(i25);
                        i7 = zzefz.zzgs(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 46:
                    i9 = zzeix.zzai((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zziii) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzefz.zzgq(i25);
                        i7 = zzefz.zzgs(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 47:
                    i9 = zzeix.zzag((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zziii) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzefz.zzgq(i25);
                        i7 = zzefz.zzgs(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 48:
                    i9 = zzeix.zzac((List) unsafe2.getObject(t, j2));
                    if (i9 > 0) {
                        if (this.zziii) {
                            unsafe2.putInt(t, (long) i2, i9);
                        }
                        i8 = zzefz.zzgq(i25);
                        i7 = zzefz.zzgs(i9);
                        i22 = a.G1(i7, i8, i9, i22);
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 49:
                    i6 = zzeix.zzd(i25, (List) unsafe2.getObject(t, j2), zzhf(i21));
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 50:
                    i6 = this.zziiq.zzb(i25, unsafe2.getObject(t, j2), zzhg(i21));
                    i22 += i6;
                    i3 = i22;
                    i22 = i3;
                    break;
                case 51:
                    if (zza(t, i25, i21)) {
                        i6 = zzefz.zzc(i25, 0.0d);
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 52:
                    if (zza(t, i25, i21)) {
                        i6 = zzefz.zzb(i25, 0.0f);
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 53:
                    if (zza(t, i25, i21)) {
                        i6 = zzefz.zzk(i25, zzi(t, j2));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 54:
                    if (zza(t, i25, i21)) {
                        i6 = zzefz.zzl(i25, zzi(t, j2));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 55:
                    if (zza(t, i25, i21)) {
                        i6 = zzefz.zzaf(i25, zzh(t, j2));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 56:
                    if (zza(t, i25, i21)) {
                        i6 = zzefz.zzn(i25, 0);
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 57:
                    if (zza(t, i25, i21)) {
                        i6 = zzefz.zzai(i25, 0);
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 58:
                    if (zza(t, i25, i21)) {
                        i6 = zzefz.zzi(i25, true);
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 59:
                    if (zza(t, i25, i21)) {
                        Object object2 = unsafe2.getObject(t, j2);
                        if (object2 instanceof zzeff) {
                            i6 = zzefz.zzc(i25, (zzeff) object2);
                        } else {
                            i6 = zzefz.zzj(i25, (String) object2);
                        }
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 60:
                    if (zza(t, i25, i21)) {
                        i6 = zzeix.zzc(i25, unsafe2.getObject(t, j2), zzhf(i21));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 61:
                    if (zza(t, i25, i21)) {
                        i6 = zzefz.zzc(i25, (zzeff) unsafe2.getObject(t, j2));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 62:
                    if (zza(t, i25, i21)) {
                        i6 = zzefz.zzag(i25, zzh(t, j2));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 63:
                    if (zza(t, i25, i21)) {
                        i6 = zzefz.zzak(i25, zzh(t, j2));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 64:
                    if (zza(t, i25, i21)) {
                        i6 = zzefz.zzaj(i25, 0);
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 65:
                    if (zza(t, i25, i21)) {
                        i6 = zzefz.zzo(i25, 0);
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 66:
                    if (zza(t, i25, i21)) {
                        i6 = zzefz.zzah(i25, zzh(t, j2));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 67:
                    if (zza(t, i25, i21)) {
                        i6 = zzefz.zzm(i25, zzi(t, j2));
                        i22 += i6;
                    }
                    i3 = i22;
                    i22 = i3;
                    break;
                case 68:
                    if (zza(t, i25, i21)) {
                        i6 = zzefz.zzc(i25, (zzehz) unsafe2.getObject(t, j2), zzhf(i21));
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
        int zza = i22 + zza((zzejn) this.zziio, (Object) t);
        if (!this.zziif) {
            return zza;
        }
        zzegi<?> zzah = this.zziip.zzah(t);
        for (int i29 = 0; i29 < zzah.zzict.zzbhq(); i29++) {
            Map.Entry<T, Object> zzhp = zzah.zzict.zzhp(i29);
            i28 += zzegi.zzb((zzegk<?>) zzhp.getKey(), zzhp.getValue());
        }
        for (Map.Entry<T, Object> entry : zzah.zzict.zzbhr()) {
            i28 += zzegi.zzb((zzegk<?>) entry.getKey(), entry.getValue());
        }
        return zza + i28;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.ads.zzeiv] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.google.android.gms.internal.ads.zzeiv] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.gms.internal.ads.zzeiv
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzav(T r19) {
        /*
        // Method dump skipped, instructions count: 320
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeid.zzav(java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzeiv
    public final void zzg(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i = 0; i < this.zziia.length; i += 3) {
            int zzhi = zzhi(i);
            long j = (long) (1048575 & zzhi);
            int i2 = this.zziia[i];
            switch ((zzhi & 267386880) >>> 20) {
                case 0:
                    if (zze((zzeid<T>) t2, i)) {
                        zzejt.zza(t, j, zzejt.zzo(t2, j));
                        zzf((zzeid<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zze((zzeid<T>) t2, i)) {
                        zzejt.zza((Object) t, j, zzejt.zzn(t2, j));
                        zzf((zzeid<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zze((zzeid<T>) t2, i)) {
                        zzejt.zza((Object) t, j, zzejt.zzl(t2, j));
                        zzf((zzeid<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zze((zzeid<T>) t2, i)) {
                        zzejt.zza((Object) t, j, zzejt.zzl(t2, j));
                        zzf((zzeid<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zze((zzeid<T>) t2, i)) {
                        zzejt.zzb(t, j, zzejt.zzk(t2, j));
                        zzf((zzeid<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zze((zzeid<T>) t2, i)) {
                        zzejt.zza((Object) t, j, zzejt.zzl(t2, j));
                        zzf((zzeid<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zze((zzeid<T>) t2, i)) {
                        zzejt.zzb(t, j, zzejt.zzk(t2, j));
                        zzf((zzeid<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zze((zzeid<T>) t2, i)) {
                        zzejt.zza(t, j, zzejt.zzm(t2, j));
                        zzf((zzeid<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zze((zzeid<T>) t2, i)) {
                        zzejt.zza(t, j, zzejt.zzp(t2, j));
                        zzf((zzeid<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zze((zzeid<T>) t2, i)) {
                        zzejt.zza(t, j, zzejt.zzp(t2, j));
                        zzf((zzeid<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zze((zzeid<T>) t2, i)) {
                        zzejt.zzb(t, j, zzejt.zzk(t2, j));
                        zzf((zzeid<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zze((zzeid<T>) t2, i)) {
                        zzejt.zzb(t, j, zzejt.zzk(t2, j));
                        zzf((zzeid<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zze((zzeid<T>) t2, i)) {
                        zzejt.zzb(t, j, zzejt.zzk(t2, j));
                        zzf((zzeid<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zze((zzeid<T>) t2, i)) {
                        zzejt.zza((Object) t, j, zzejt.zzl(t2, j));
                        zzf((zzeid<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zze((zzeid<T>) t2, i)) {
                        zzejt.zzb(t, j, zzejt.zzk(t2, j));
                        zzf((zzeid<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zze((zzeid<T>) t2, i)) {
                        zzejt.zza((Object) t, j, zzejt.zzl(t2, j));
                        zzf((zzeid<T>) t, i);
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
                    this.zziin.zza(t, t2, j);
                    break;
                case 50:
                    zzeix.zza(this.zziiq, t, t2, j);
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
                        zzejt.zza(t, j, zzejt.zzp(t2, j));
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
                        zzejt.zza(t, j, zzejt.zzp(t2, j));
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
        zzeix.zza(this.zziio, t, t2);
        if (this.zziif) {
            zzeix.zza(this.zziip, t, t2);
        }
    }

    private final boolean zze(T t, int i) {
        int zzhj = zzhj(i);
        long j = (long) (zzhj & 1048575);
        if (j == 1048575) {
            int zzhi = zzhi(i);
            long j2 = (long) (zzhi & 1048575);
            switch ((zzhi & 267386880) >>> 20) {
                case 0:
                    return zzejt.zzo(t, j2) != 0.0d;
                case 1:
                    return zzejt.zzn(t, j2) != 0.0f;
                case 2:
                    return zzejt.zzl(t, j2) != 0;
                case 3:
                    return zzejt.zzl(t, j2) != 0;
                case 4:
                    return zzejt.zzk(t, j2) != 0;
                case 5:
                    return zzejt.zzl(t, j2) != 0;
                case 6:
                    return zzejt.zzk(t, j2) != 0;
                case 7:
                    return zzejt.zzm(t, j2);
                case 8:
                    Object zzp = zzejt.zzp(t, j2);
                    if (zzp instanceof String) {
                        return !((String) zzp).isEmpty();
                    }
                    if (zzp instanceof zzeff) {
                        return !zzeff.zzibd.equals(zzp);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzejt.zzp(t, j2) != null;
                case 10:
                    return !zzeff.zzibd.equals(zzejt.zzp(t, j2));
                case 11:
                    return zzejt.zzk(t, j2) != 0;
                case 12:
                    return zzejt.zzk(t, j2) != 0;
                case 13:
                    return zzejt.zzk(t, j2) != 0;
                case 14:
                    return zzejt.zzl(t, j2) != 0;
                case 15:
                    return zzejt.zzk(t, j2) != 0;
                case 16:
                    return zzejt.zzl(t, j2) != 0;
                case 17:
                    return zzejt.zzp(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zzejt.zzk(t, j) & (1 << (zzhj >>> 20))) != 0;
        }
    }

    private final void zzf(T t, int i) {
        int zzhj = zzhj(i);
        long j = (long) (1048575 & zzhj);
        if (j != 1048575) {
            zzejt.zzb(t, j, (1 << (zzhj >>> 20)) | zzejt.zzk(t, j));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:170:0x0495  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r18, com.google.android.gms.internal.ads.zzekk r19) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1342
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeid.zzb(java.lang.Object, com.google.android.gms.internal.ads.zzekk):void");
    }

    private static <T> float zzg(T t, long j) {
        return ((Float) zzejt.zzp(t, j)).floatValue();
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
        long zzhi = (long) (zzhi(i) & 1048575);
        if (zze((zzeid<T>) t2, i)) {
            Object zzp = zzejt.zzp(t, zzhi);
            Object zzp2 = zzejt.zzp(t2, zzhi);
            if (zzp != null && zzp2 != null) {
                zzejt.zza(t, zzhi, zzegr.zze(zzp, zzp2));
                zzf((zzeid<T>) t, i);
            } else if (zzp2 != null) {
                zzejt.zza(t, zzhi, zzp2);
                zzf((zzeid<T>) t, i);
            }
        }
    }

    private static <UT, UB> int zza(zzejn<UT, UB> zzejn, T t) {
        return zzejn.zzat(zzejn.zzax(t));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0552  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2a  */
    @Override // com.google.android.gms.internal.ads.zzeiv
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.ads.zzekk r15) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 2916
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeid.zza(java.lang.Object, com.google.android.gms.internal.ads.zzekk):void");
    }

    private final void zzb(T t, int i, int i2) {
        zzejt.zzb(t, (long) (zzhj(i2) & 1048575), i);
    }

    private final <K, V> void zza(zzekk zzekk, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzekk.zza(i, this.zziiq.zzao(zzhg(i2)), this.zziiq.zzap(obj));
        }
    }

    private static <UT, UB> void zza(zzejn<UT, UB> zzejn, T t, zzekk zzekk) throws IOException {
        zzejn.zza(zzejn.zzax(t), zzekk);
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    @Override // com.google.android.gms.internal.ads.zzeiv
    public final void zza(T r13, com.google.android.gms.internal.ads.zzeip r14, com.google.android.gms.internal.ads.zzegc r15) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1646
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeid.zza(java.lang.Object, com.google.android.gms.internal.ads.zzeip, com.google.android.gms.internal.ads.zzegc):void");
    }

    private static int zza(byte[] bArr, int i, int i2, zzeke zzeke, Class<?> cls, zzefa zzefa) throws IOException {
        switch (zzeig.zzicc[zzeke.ordinal()]) {
            case 1:
                int zzb = zzefb.zzb(bArr, i, zzefa);
                zzefa.zziay = Boolean.valueOf(zzefa.zziax != 0);
                return zzb;
            case 2:
                return zzefb.zze(bArr, i, zzefa);
            case 3:
                zzefa.zziay = Double.valueOf(zzefb.zzi(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzefa.zziay = Integer.valueOf(zzefb.zzg(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzefa.zziay = Long.valueOf(zzefb.zzh(bArr, i));
                return i + 8;
            case 8:
                zzefa.zziay = Float.valueOf(zzefb.zzj(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int zza = zzefb.zza(bArr, i, zzefa);
                zzefa.zziay = Integer.valueOf(zzefa.zziaw);
                return zza;
            case 12:
            case 13:
                int zzb2 = zzefb.zzb(bArr, i, zzefa);
                zzefa.zziay = Long.valueOf(zzefa.zziax);
                return zzb2;
            case 14:
                return zzefb.zza(zzeio.zzbhg().zzh(cls), bArr, i, i2, zzefa);
            case 15:
                int zza2 = zzefb.zza(bArr, i, zzefa);
                zzefa.zziay = Integer.valueOf(zzefq.zzgc(zzefa.zziaw));
                return zza2;
            case 16:
                int zzb3 = zzefb.zzb(bArr, i, zzefa);
                zzefa.zziay = Long.valueOf(zzefq.zzfh(zzefa.zziax));
                return zzb3;
            case 17:
                return zzefb.zzd(bArr, i, zzefa);
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
    private final int zza(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.ads.zzefa r29) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1126
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeid.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.ads.zzefa):int");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x003e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x003e */
    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, long j, zzefa zzefa) throws IOException {
        Unsafe unsafe = zzhop;
        Object zzhg = zzhg(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zziiq.zzaq(object)) {
            Object zzas = this.zziiq.zzas(zzhg);
            this.zziiq.zzf(zzas, object);
            unsafe.putObject(t, j, zzas);
            object = zzas;
        }
        zzehu<?, ?> zzao = this.zziiq.zzao(zzhg);
        Map<?, ?> zzan = this.zziiq.zzan(object);
        int zza = zzefb.zza(bArr, i, zzefa);
        int i4 = zzefa.zziaw;
        if (i4 < 0 || i4 > i2 - zza) {
            throw zzegz.zzbgb();
        }
        int i5 = i4 + zza;
        SavedSearchView.DefaultImpls defaultImpls = (K) zzao.zzihv;
        SavedSearchView.DefaultImpls defaultImpls2 = (V) zzao.zzckv;
        while (zza < i5) {
            int i6 = zza + 1;
            byte b = bArr[zza];
            int i7 = b;
            if (b < 0) {
                i6 = zzefb.zza(b, bArr, i6, zzefa);
                i7 = zzefa.zziaw;
            }
            int i8 = (i7 == 1 ? 1 : 0) >>> 3;
            int i9 = (i7 == 1 ? 1 : 0) & 7;
            if (i8 != 1) {
                if (i8 == 2 && i9 == zzao.zzihw.zzbij()) {
                    zza = zza(bArr, i6, i2, zzao.zzihw, zzao.zzckv.getClass(), zzefa);
                    defaultImpls2 = (V) zzefa.zziay;
                }
            } else if (i9 == zzao.zzihu.zzbij()) {
                zza = zza(bArr, i6, i2, zzao.zzihu, (Class<?>) null, zzefa);
                defaultImpls = (K) zzefa.zziay;
            }
            zza = zzefb.zza(i7, bArr, i6, i2, zzefa);
        }
        if (zza == i5) {
            zzan.put(defaultImpls, defaultImpls2);
            return i5;
        }
        throw zzegz.zzbgi();
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzefa zzefa) throws IOException {
        int i9;
        Unsafe unsafe = zzhop;
        long j2 = (long) (this.zziia[i8 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(zzefb.zzi(bArr, i)));
                    i9 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(zzefb.zzj(bArr, i)));
                    i9 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    i9 = zzefb.zzb(bArr, i, zzefa);
                    unsafe.putObject(t, j, Long.valueOf(zzefa.zziax));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    i9 = zzefb.zza(bArr, i, zzefa);
                    unsafe.putObject(t, j, Integer.valueOf(zzefa.zziaw));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(zzefb.zzh(bArr, i)));
                    i9 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(zzefb.zzg(bArr, i)));
                    i9 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    i9 = zzefb.zzb(bArr, i, zzefa);
                    unsafe.putObject(t, j, Boolean.valueOf(zzefa.zziax != 0));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    int zza = zzefb.zza(bArr, i, zzefa);
                    int i10 = zzefa.zziaw;
                    if (i10 == 0) {
                        unsafe.putObject(t, j, "");
                    } else if ((i6 & 536870912) == 0 || zzejw.zzm(bArr, zza, zza + i10)) {
                        unsafe.putObject(t, j, new String(bArr, zza, i10, zzegr.UTF_8));
                        zza += i10;
                    } else {
                        throw zzegz.zzbgj();
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    int zza2 = zzefb.zza(zzhf(i8), bArr, i, i2, zzefa);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, zzefa.zziay);
                    } else {
                        unsafe.putObject(t, j, zzegr.zze(object, zzefa.zziay));
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza2;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    i9 = zzefb.zze(bArr, i, zzefa);
                    unsafe.putObject(t, j, zzefa.zziay);
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int zza3 = zzefb.zza(bArr, i, zzefa);
                    int i11 = zzefa.zziaw;
                    zzegw zzhh = zzhh(i8);
                    if (zzhh == null || zzhh.zzi(i11)) {
                        unsafe.putObject(t, j, Integer.valueOf(i11));
                        i9 = zza3;
                        unsafe.putInt(t, j2, i4);
                        return i9;
                    }
                    zzau(t).zzd(i3, Long.valueOf((long) i11));
                    return zza3;
                }
                return i;
            case 66:
                if (i5 == 0) {
                    i9 = zzefb.zza(bArr, i, zzefa);
                    unsafe.putObject(t, j, Integer.valueOf(zzefq.zzgc(zzefa.zziaw)));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    i9 = zzefb.zzb(bArr, i, zzefa);
                    unsafe.putObject(t, j, Long.valueOf(zzefq.zzfh(zzefa.zziax)));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    i9 = zzefb.zza(zzhf(i8), bArr, i, i2, (i3 & -8) | 4, zzefa);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, zzefa.zziay);
                    } else {
                        unsafe.putObject(t, j, zzegr.zze(object2, zzefa.zziay));
                    }
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            default:
                return i;
        }
    }

    public final int zza(T t, byte[] bArr, int i, int i2, int i3, zzefa zzefa) throws IOException {
        Unsafe unsafe;
        int i4;
        T t2;
        zzeid<T> zzeid;
        byte b;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        T t3;
        int i11;
        zzefa zzefa2;
        int i12;
        zzefa zzefa3;
        int i13;
        int i14;
        int i15;
        zzefa zzefa4;
        int zzb;
        int i16;
        zzefa zzefa5;
        int i17;
        int i18;
        int i19;
        zzeid<T> zzeid2 = this;
        T t4 = t;
        byte[] bArr2 = bArr;
        int i20 = i2;
        int i21 = i3;
        zzefa zzefa6 = zzefa;
        Unsafe unsafe2 = zzhop;
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
                    int zza = zzefb.zza(b2, bArr2, i28, zzefa6);
                    b = zzefa6.zziaw;
                    i28 = zza;
                } else {
                    b = b2;
                }
                int i29 = b >>> 3;
                int i30 = b & 7;
                if (i29 > i23) {
                    i5 = zzeid2.zzan(i29, i24 / 3);
                } else {
                    i5 = zzeid2.zzhl(i29);
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
                    int[] iArr = zzeid2.zziia;
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
                                zzefa4 = zzefa;
                                if (i30 == 1) {
                                    zzejt.zza(t4, j, zzefb.zzi(bArr2, i28));
                                    i22 = i28 + 8;
                                    i26 |= i34;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    i24 = i14;
                                    zzefa6 = zzefa4;
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
                                zzefa4 = zzefa;
                                if (i30 == 5) {
                                    zzejt.zza((Object) t4, j, zzefb.zzj(bArr2, i28));
                                    i22 = i28 + 4;
                                    i26 |= i34;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    i24 = i14;
                                    zzefa6 = zzefa4;
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
                                zzefa4 = zzefa;
                                if (i30 == 0) {
                                    zzb = zzefb.zzb(bArr2, i28, zzefa4);
                                    unsafe2.putLong(t, j, zzefa4.zziax);
                                    i26 |= i34;
                                    i27 = i15;
                                    i22 = zzb;
                                    i25 = i8;
                                    i23 = i13;
                                    i24 = i14;
                                    zzefa6 = zzefa4;
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
                                zzefa4 = zzefa;
                                if (i30 == 0) {
                                    i22 = zzefb.zza(bArr2, i28, zzefa4);
                                    unsafe2.putInt(t4, j, zzefa4.zziaw);
                                    i26 |= i34;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    i24 = i14;
                                    zzefa6 = zzefa4;
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
                                zzefa4 = zzefa;
                                if (i30 == 1) {
                                    unsafe2.putLong(t, j, zzefb.zzh(bArr2, i28));
                                    i22 = i28 + 8;
                                    i26 |= i34;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    i24 = i14;
                                    zzefa6 = zzefa4;
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
                                zzefa5 = zzefa;
                                if (i30 == 5) {
                                    unsafe2.putInt(t4, j, zzefb.zzg(bArr2, i28));
                                    i22 = i28 + 4;
                                    i26 |= i34;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    zzefa6 = zzefa5;
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
                                zzefa5 = zzefa;
                                if (i30 == 0) {
                                    int zzb2 = zzefb.zzb(bArr2, i28, zzefa5);
                                    zzejt.zza(t4, j, zzefa5.zziax != 0);
                                    i26 |= i34;
                                    i27 = i15;
                                    i22 = zzb2;
                                    i25 = i8;
                                    i23 = i13;
                                    zzefa6 = zzefa5;
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
                                zzefa5 = zzefa;
                                if (i30 == 2) {
                                    if ((i31 & 536870912) == 0) {
                                        i22 = zzefb.zzc(bArr2, i28, zzefa5);
                                    } else {
                                        i22 = zzefb.zzd(bArr2, i28, zzefa5);
                                    }
                                    unsafe2.putObject(t4, j, zzefa5.zziay);
                                    i26 |= i34;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    zzefa6 = zzefa5;
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
                                zzefa5 = zzefa;
                                if (i30 == 2) {
                                    i16 = i2;
                                    i22 = zzefb.zza(zzeid2.zzhf(i14), bArr2, i28, i16, zzefa5);
                                    if ((i26 & i34) == 0) {
                                        unsafe2.putObject(t4, j, zzefa5.zziay);
                                    } else {
                                        unsafe2.putObject(t4, j, zzegr.zze(unsafe2.getObject(t4, j), zzefa5.zziay));
                                    }
                                    i26 |= i34;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    zzefa6 = zzefa5;
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
                                zzefa4 = zzefa;
                                if (i30 == 2) {
                                    i22 = zzefb.zze(bArr2, i28, zzefa4);
                                    unsafe2.putObject(t4, j, zzefa4.zziay);
                                    i26 |= i34;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    i24 = i14;
                                    zzefa6 = zzefa4;
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
                                zzefa4 = zzefa;
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
                                    i22 = zzefb.zza(bArr2, i28, zzefa4);
                                    int i36 = zzefa4.zziaw;
                                    zzegw zzhh = zzeid2.zzhh(i14);
                                    if (zzhh == null || zzhh.zzi(i36)) {
                                        unsafe2.putInt(t4, j, i36);
                                        i26 |= i34;
                                        i27 = i15;
                                        i25 = i8;
                                        i23 = i13;
                                        i24 = i14;
                                        zzefa6 = zzefa4;
                                        i20 = i2;
                                        break;
                                    } else {
                                        zzau(t).zzd(i8, Long.valueOf((long) i36));
                                        i26 = i26;
                                        i25 = i8;
                                        i23 = i13;
                                        i24 = i14;
                                        zzefa6 = zzefa4;
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
                                zzefa4 = zzefa;
                                if (i30 == 0) {
                                    i22 = zzefb.zza(bArr2, i28, zzefa4);
                                    unsafe2.putInt(t4, j, zzefq.zzgc(zzefa4.zziaw));
                                    i26 |= i34;
                                    i27 = i15;
                                    i25 = i8;
                                    i23 = i13;
                                    i24 = i14;
                                    zzefa6 = zzefa4;
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
                                    zzb = zzefb.zzb(bArr2, i28, zzefa);
                                    zzefa4 = zzefa;
                                    i15 = i12;
                                    i8 = b;
                                    unsafe2.putLong(t, j, zzefq.zzfh(zzefa.zziax));
                                    i26 |= i34;
                                    i27 = i15;
                                    i22 = zzb;
                                    i25 = i8;
                                    i23 = i13;
                                    i24 = i14;
                                    zzefa6 = zzefa4;
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
                                    i22 = zzefb.zza(zzeid2.zzhf(i5), bArr, i28, i2, (i29 << 3) | 4, zzefa);
                                    if ((i26 & i34) == 0) {
                                        zzefa3 = zzefa;
                                        unsafe2.putObject(t4, j, zzefa3.zziay);
                                    } else {
                                        zzefa3 = zzefa;
                                        unsafe2.putObject(t4, j, zzegr.zze(unsafe2.getObject(t4, j), zzefa3.zziay));
                                    }
                                    i26 |= i34;
                                    bArr2 = bArr;
                                    i20 = i2;
                                    i25 = b;
                                    i27 = i12;
                                    i23 = i29;
                                    i24 = i5;
                                    i21 = i3;
                                    zzefa6 = zzefa3;
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
                                i22 = zza(t, bArr, i28, i2, b, i29, i30, i10, (long) i31, i32, j, zzefa);
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
                                    i22 = zza(t, bArr, i18, i2, i19, i6, i30, i31, i32, j, i10, zzefa);
                                    if (i22 != i18) {
                                        zzeid2 = this;
                                        t4 = t;
                                        bArr2 = bArr;
                                        i20 = i2;
                                        zzefa6 = zzefa;
                                        i25 = i19;
                                        i23 = i6;
                                        i24 = i10;
                                        i26 = i9;
                                        i27 = i17;
                                        unsafe2 = unsafe;
                                    }
                                } else if (i30 == 2) {
                                    i22 = zza(t, bArr, i18, i2, i10, j, zzefa);
                                    if (i22 == i18) {
                                    }
                                }
                                i4 = i3;
                                i7 = i22;
                                i8 = i19;
                                i27 = i17;
                            }
                            zzeid2 = this;
                            t4 = t;
                            bArr2 = bArr;
                            i23 = i6;
                            i20 = i2;
                            i21 = i3;
                            zzefa6 = zzefa;
                            i24 = i10;
                            i25 = i19;
                            i26 = i9;
                            i27 = i17;
                            unsafe2 = unsafe;
                        } else if (i30 == 2) {
                            zzeha zzeha = (zzeha) unsafe2.getObject(t4, j);
                            if (!zzeha.zzbdf()) {
                                int size = zzeha.size();
                                zzeha = zzeha.zzft(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(t4, j, zzeha);
                            }
                            i22 = zzefb.zza(zzeid2.zzhf(i5), b, bArr, i28, i2, zzeha, zzefa);
                            i21 = i3;
                            i25 = b;
                            i23 = i29;
                            zzefa6 = zzefa6;
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
                    if (this.zziif) {
                        zzefa2 = zzefa;
                        if (zzefa2.zziaz == zzegc.zzbex()) {
                            t3 = t;
                            i11 = i6;
                        } else if (zzefa2.zziaz.zza(this.zziie, i6) == null) {
                            i22 = zzefb.zza(i8, bArr, i7, i2, zzau(t), zzefa);
                            t4 = t;
                            bArr2 = bArr;
                            i20 = i2;
                            i25 = i8;
                            zzeid2 = this;
                            zzefa6 = zzefa2;
                            i23 = i6;
                            i24 = i10;
                            i26 = i9;
                            unsafe2 = unsafe;
                            i21 = i4;
                        } else {
                            T t5 = t;
                            t5.zzbfy();
                            zzegi<zzegp.zzc> zzegi = t5.zzifv;
                            throw new NoSuchMethodError();
                        }
                    } else {
                        t3 = t;
                        i11 = i6;
                        zzefa2 = zzefa;
                    }
                    i22 = zzefb.zza(i8, bArr, i7, i2, zzau(t), zzefa);
                    i20 = i2;
                    i25 = i8;
                    zzeid2 = this;
                    zzefa6 = zzefa2;
                    i23 = i11;
                    t4 = t3;
                    i24 = i10;
                    i26 = i9;
                    unsafe2 = unsafe;
                    bArr2 = bArr;
                    i21 = i4;
                } else {
                    zzeid = this;
                    t2 = t;
                    i22 = i7;
                    i25 = i8;
                    i26 = i9;
                }
            } else {
                unsafe = unsafe2;
                i4 = i21;
                t2 = t4;
                zzeid = zzeid2;
            }
        }
        if (i27 != 1048575) {
            unsafe.putInt(t2, (long) i27, i26);
        }
        zzejq zzejq = null;
        for (int i37 = zzeid.zziik; i37 < zzeid.zziil; i37++) {
            zzejq = (zzejq) zzeid.zza((Object) t2, zzeid.zziij[i37], (int) zzejq, (zzejn<UT, int>) ((zzejn<UT, UB>) zzeid.zziio));
        }
        if (zzejq != null) {
            zzeid.zziio.zzj(t2, zzejq);
        }
        if (i4 == 0) {
            if (i22 != i2) {
                throw zzegz.zzbgi();
            }
        } else if (i22 > i2 || i25 != i4) {
            throw zzegz.zzbgi();
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
    @Override // com.google.android.gms.internal.ads.zzeiv
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.ads.zzefa r35) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 966
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeid.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.zzefa):void");
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzejn<UT, UB> zzejn) {
        zzegw zzhh;
        int i2 = this.zziia[i];
        Object zzp = zzejt.zzp(obj, (long) (zzhi(i) & 1048575));
        return (zzp == null || (zzhh = zzhh(i)) == null) ? ub : (UB) zza(i, i2, (Map<K, V>) this.zziiq.zzan(zzp), zzhh, ub, zzejn);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzegw zzegw, UB ub, zzejn<UT, UB> zzejn) {
        zzehu<?, ?> zzao = this.zziiq.zzao(zzhg(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzegw.zzi(next.getValue().intValue())) {
                if (ub == null) {
                    ub = zzejn.zzbhy();
                }
                zzefn zzfw = zzeff.zzfw(zzehr.zza(zzao, next.getKey(), next.getValue()));
                try {
                    zzehr.zza(zzfw.zzbds(), zzao, next.getKey(), next.getValue());
                    zzejn.zza(ub, i2, zzfw.zzbdr());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.android.gms.internal.ads.zzeiv */
    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzeiv zzeiv) {
        return zzeiv.zzav(zzejt.zzp(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzekk zzekk) throws IOException {
        if (obj instanceof String) {
            zzekk.zzi(i, (String) obj);
        } else {
            zzekk.zza(i, (zzeff) obj);
        }
    }

    private final void zza(Object obj, int i, zzeip zzeip) throws IOException {
        if (zzhk(i)) {
            zzejt.zza(obj, (long) (i & 1048575), zzeip.zzbea());
        } else if (this.zziig) {
            zzejt.zza(obj, (long) (i & 1048575), zzeip.readString());
        } else {
            zzejt.zza(obj, (long) (i & 1048575), zzeip.zzbeb());
        }
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zze((zzeid<T>) t, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zza(T t, int i, int i2) {
        return zzejt.zzk(t, (long) (zzhj(i2) & 1048575)) == i;
    }
}
