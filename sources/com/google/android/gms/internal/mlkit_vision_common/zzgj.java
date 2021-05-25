package com.google.android.gms.internal.mlkit_vision_common;

import java.io.IOException;
import java.util.List;
public final class zzgj {
    private static final Class<?> zza = zzd();
    private static final zzgz<?, ?> zzb = zza(false);
    private static final zzgz<?, ?> zzc = zza(true);
    private static final zzgz<?, ?> zzd = new zzhb();

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzej.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzb(int i, List<Float> list, zzht zzht, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzht.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzht zzht, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzht.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzht zzht, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzht.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzht zzht, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzht.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzht zzht, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzht.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzht zzht, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzht.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzht zzht, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzht.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzht zzht, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzht.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzht zzht, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzht.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzht zzht, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzht.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzht zzht, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzht.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzht zzht, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzht.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzht zzht, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzht.zzi(i, list, z);
        }
    }

    public static void zzb(int i, List<zzdf> list, zzht zzht) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzht.zzb(i, list);
        }
    }

    public static int zzc(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzff) {
            zzff zzff = (zzff) list;
            i = 0;
            while (i2 < size) {
                i += zzdw.zzf(zzff.zza(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdw.zzf(list.get(i2).longValue());
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
        if (list instanceof zzek) {
            zzek zzek = (zzek) list;
            i = 0;
            while (i2 < size) {
                i += zzdw.zzk(zzek.zza(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdw.zzk(list.get(i2).intValue());
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
        if (list instanceof zzek) {
            zzek zzek = (zzek) list;
            i = 0;
            while (i2 < size) {
                i += zzdw.zzf(zzek.zza(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdw.zzf(list.get(i2).intValue());
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
        if (list instanceof zzek) {
            zzek zzek = (zzek) list;
            i = 0;
            while (i2 < size) {
                i += zzdw.zzg(zzek.zza(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdw.zzg(list.get(i2).intValue());
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
        if (list instanceof zzek) {
            zzek zzek = (zzek) list;
            i = 0;
            while (i2 < size) {
                i += zzdw.zzh(zzek.zza(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdw.zzh(list.get(i2).intValue());
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

    public static void zza(int i, List<Double> list, zzht zzht, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzht.zzg(i, list, z);
        }
    }

    public static int zzh(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzdw.zzi(i, 0) * size;
    }

    public static int zzi(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzdw.zzg(i, 0L) * size;
    }

    public static int zzj(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzdw.zzb(i, true) * size;
    }

    public static void zzb(int i, List<?> list, zzht zzht, zzgh zzgh) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzht.zzb(i, list, zzgh);
        }
    }

    public static void zza(int i, List<String> list, zzht zzht) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzht.zza(i, list);
        }
    }

    public static int zzb(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzff) {
            zzff zzff = (zzff) list;
            i = 0;
            while (i2 < size) {
                i += zzdw.zze(zzff.zza(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdw.zze(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static void zza(int i, List<?> list, zzht zzht, zzgh zzgh) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzht.zza(i, list, zzgh);
        }
    }

    public static int zzc(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzdw.zze(i) * size) + zzc(list);
    }

    public static int zzd(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzdw.zze(i) * size) + zzd(list);
    }

    public static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzdw.zze(i) * size) + zze(list);
    }

    public static int zzf(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzdw.zze(i) * size) + zzf(list);
    }

    public static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzdw.zze(i) * size) + zzg(list);
    }

    public static int zza(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzff) {
            zzff zzff = (zzff) list;
            i = 0;
            while (i2 < size) {
                i += zzdw.zzd(zzff.zza(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdw.zzd(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzgz<?, ?> zzc() {
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
        return (zzdw.zze(i) * size) + zzb(list);
    }

    public static int zza(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return (zzdw.zze(i) * list.size()) + zza(list);
    }

    public static int zzb(int i, List<zzdf> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = zzdw.zze(i) * size;
        for (int i2 = 0; i2 < list.size(); i2++) {
            zze += zzdw.zzb(list.get(i2));
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
        int zze = zzdw.zze(i) * size;
        if (list instanceof zzfc) {
            zzfc zzfc = (zzfc) list;
            while (i4 < size) {
                Object zza2 = zzfc.zza(i4);
                if (zza2 instanceof zzdf) {
                    i3 = zzdw.zzb((zzdf) zza2);
                } else {
                    i3 = zzdw.zzb((String) zza2);
                }
                zze = i3 + zze;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzdf) {
                    i2 = zzdw.zzb((zzdf) obj);
                } else {
                    i2 = zzdw.zzb((String) obj);
                }
                zze = i2 + zze;
                i4++;
            }
        }
        return zze;
    }

    public static int zzb(int i, List<zzfr> list, zzgh zzgh) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzdw.zzc(i, list.get(i3), zzgh);
        }
        return i2;
    }

    public static zzgz<?, ?> zzb() {
        return zzc;
    }

    public static int zza(int i, Object obj, zzgh zzgh) {
        if (obj instanceof zzfa) {
            return zzdw.zza(i, (zzfa) obj);
        }
        return zzdw.zzb(i, (zzfr) obj, zzgh);
    }

    public static int zza(int i, List<?> list, zzgh zzgh) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = zzdw.zze(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzfa) {
                i2 = zzdw.zza((zzfa) obj);
            } else {
                i2 = zzdw.zza((zzfr) obj, zzgh);
            }
            zze = i2 + zze;
        }
        return zze;
    }

    public static zzgz<?, ?> zza() {
        return zzb;
    }

    private static zzgz<?, ?> zza(boolean z) {
        try {
            Class<?> zze = zze();
            if (zze == null) {
                return null;
            }
            return (zzgz) zze.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
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

    public static <T> void zza(zzfo zzfo, T t, T t2, long j) {
        zzhf.zza(t, j, zzfo.zza(zzhf.zzf(t, j), zzhf.zzf(t2, j)));
    }

    public static <T, FT extends zzed<FT>> void zza(zzea<FT> zzea, T t, T t2) {
        zzeb<FT> zza2 = zzea.zza((Object) t2);
        if (!zza2.zza.isEmpty()) {
            zzea.zzb(t).zza(zza2);
        }
    }

    public static <T, UT, UB> void zza(zzgz<UT, UB> zzgz, T t, T t2) {
        zzgz.zza((Object) t, (Object) zzgz.zzb(zzgz.zza(t), zzgz.zza(t2)));
    }
}
