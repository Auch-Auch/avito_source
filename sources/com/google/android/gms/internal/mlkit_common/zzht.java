package com.google.android.gms.internal.mlkit_common;

import java.io.IOException;
import java.util.List;
public final class zzht {
    private static final Class<?> zza = zzd();
    private static final zzij<?, ?> zzb = zza(false);
    private static final zzij<?, ?> zzc = zza(true);
    private static final zzij<?, ?> zzd = new zzil();

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzfq.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzb(int i, List<Float> list, zzjd zzjd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjd.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzjd zzjd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjd.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzjd zzjd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjd.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzjd zzjd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjd.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzjd zzjd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjd.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzjd zzjd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjd.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzjd zzjd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjd.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzjd zzjd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjd.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzjd zzjd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjd.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzjd zzjd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjd.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzjd zzjd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjd.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzjd zzjd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjd.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzjd zzjd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjd.zzi(i, list, z);
        }
    }

    public static void zzb(int i, List<zzep> list, zzjd zzjd) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjd.zzb(i, list);
        }
    }

    public static int zzc(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgp) {
            zzgp zzgp = (zzgp) list;
            i = 0;
            while (i2 < size) {
                i += zzfc.zzf(zzgp.zza(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfc.zzf(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzd(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzft) {
            zzft zzft = (zzft) list;
            i = 0;
            while (i2 < size) {
                i += zzfc.zzk(zzft.zza(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfc.zzk(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zze(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzft) {
            zzft zzft = (zzft) list;
            i = 0;
            while (i2 < size) {
                i += zzfc.zzf(zzft.zza(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfc.zzf(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzf(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzft) {
            zzft zzft = (zzft) list;
            i = 0;
            while (i2 < size) {
                i += zzfc.zzg(zzft.zza(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfc.zzg(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzg(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzft) {
            zzft zzft = (zzft) list;
            i = 0;
            while (i2 < size) {
                i += zzfc.zzh(zzft.zza(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfc.zzh(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int zzh(List<?> list) {
        return list.size() << 2;
    }

    public static int zzi(List<?> list) {
        return list.size() << 3;
    }

    public static int zzj(List<?> list) {
        return list.size();
    }

    public static void zza(int i, List<Double> list, zzjd zzjd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjd.zzg(i, list, z);
        }
    }

    public static int zzh(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzfc.zzi(i, 0) * size;
    }

    public static int zzi(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzfc.zzg(i, 0L) * size;
    }

    public static int zzj(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzfc.zzb(i, true) * size;
    }

    public static void zzb(int i, List<?> list, zzjd zzjd, zzhr zzhr) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjd.zzb(i, list, zzhr);
        }
    }

    public static void zza(int i, List<String> list, zzjd zzjd) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjd.zza(i, list);
        }
    }

    public static int zzb(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgp) {
            zzgp zzgp = (zzgp) list;
            i = 0;
            while (i2 < size) {
                i += zzfc.zze(zzgp.zza(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfc.zze(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static void zza(int i, List<?> list, zzjd zzjd, zzhr zzhr) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjd.zza(i, list, zzhr);
        }
    }

    public static int zzc(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzfc.zze(i) * size) + zzc(list);
    }

    public static int zzd(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzfc.zze(i) * size) + zzd(list);
    }

    public static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzfc.zze(i) * size) + zze(list);
    }

    public static int zzf(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzfc.zze(i) * size) + zzf(list);
    }

    public static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzfc.zze(i) * size) + zzg(list);
    }

    public static int zza(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgp) {
            zzgp zzgp = (zzgp) list;
            i = 0;
            while (i2 < size) {
                i += zzfc.zzd(zzgp.zza(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfc.zzd(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzij<?, ?> zzc() {
        return zzd;
    }

    private static Class<?> zzd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zze() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int zzb(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzfc.zze(i) * size) + zzb(list);
    }

    public static int zza(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return (zzfc.zze(i) * list.size()) + zza(list);
    }

    public static int zzb(int i, List<zzep> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = zzfc.zze(i) * size;
        for (int i2 = 0; i2 < list.size(); i2++) {
            zze += zzfc.zzb(list.get(i2));
        }
        return zze;
    }

    public static int zza(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zze = zzfc.zze(i) * size;
        if (list instanceof zzgi) {
            zzgi zzgi = (zzgi) list;
            while (i4 < size) {
                Object zza2 = zzgi.zza(i4);
                if (zza2 instanceof zzep) {
                    i3 = zzfc.zzb((zzep) zza2);
                } else {
                    i3 = zzfc.zzb((String) zza2);
                }
                zze = i3 + zze;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzep) {
                    i2 = zzfc.zzb((zzep) obj);
                } else {
                    i2 = zzfc.zzb((String) obj);
                }
                zze = i2 + zze;
                i4++;
            }
        }
        return zze;
    }

    public static int zzb(int i, List<zzhb> list, zzhr zzhr) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzfc.zzc(i, list.get(i3), zzhr);
        }
        return i2;
    }

    public static zzij<?, ?> zzb() {
        return zzc;
    }

    public static int zza(int i, Object obj, zzhr zzhr) {
        if (obj instanceof zzgg) {
            return zzfc.zza(i, (zzgg) obj);
        }
        return zzfc.zzb(i, (zzhb) obj, zzhr);
    }

    public static int zza(int i, List<?> list, zzhr zzhr) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = zzfc.zze(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzgg) {
                i2 = zzfc.zza((zzgg) obj);
            } else {
                i2 = zzfc.zza((zzhb) obj, zzhr);
            }
            zze = i2 + zze;
        }
        return zze;
    }

    public static zzij<?, ?> zza() {
        return zzb;
    }

    private static zzij<?, ?> zza(boolean z) {
        try {
            Class<?> zze = zze();
            if (zze == null) {
                return null;
            }
            return (zzij) zze.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static <T> void zza(zzgu zzgu, T t, T t2, long j) {
        zzip.zza(t, j, zzgu.zza(zzip.zzf(t, j), zzip.zzf(t2, j)));
    }

    public static <T, FT extends zzfn<FT>> void zza(zzfg<FT> zzfg, T t, T t2) {
        zzfl<FT> zza2 = zzfg.zza((Object) t2);
        if (!zza2.zza.isEmpty()) {
            zzfg.zzb(t).zza(zza2);
        }
    }

    public static <T, UT, UB> void zza(zzij<UT, UB> zzij, T t, T t2) {
        zzij.zza((Object) t, (Object) zzij.zzb(zzij.zza(t), zzij.zza(t2)));
    }
}
