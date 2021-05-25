package com.google.android.gms.internal.mlkit_vision_face;

import java.io.IOException;
import java.util.List;
public final class zzid {
    private static final Class<?> zza = zzd();
    private static final zzit<?, ?> zzb = zza(false);
    private static final zzit<?, ?> zzc = zza(true);
    private static final zzit<?, ?> zzd = new zziv();

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzgd.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzb(int i, List<Float> list, zzjn zzjn, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjn.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzjn zzjn, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjn.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzjn zzjn, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjn.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzjn zzjn, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjn.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzjn zzjn, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjn.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzjn zzjn, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjn.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzjn zzjn, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjn.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzjn zzjn, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjn.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzjn zzjn, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjn.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzjn zzjn, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjn.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzjn zzjn, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjn.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzjn zzjn, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjn.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzjn zzjn, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjn.zzi(i, list, z);
        }
    }

    public static void zzb(int i, List<zzez> list, zzjn zzjn) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjn.zzb(i, list);
        }
    }

    public static int zzc(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgz) {
            zzgz zzgz = (zzgz) list;
            i = 0;
            while (i2 < size) {
                i += zzfq.zzf(zzgz.zza(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfq.zzf(list.get(i2).longValue());
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
        if (list instanceof zzge) {
            zzge zzge = (zzge) list;
            i = 0;
            while (i2 < size) {
                i += zzfq.zzk(zzge.zza(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfq.zzk(list.get(i2).intValue());
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
        if (list instanceof zzge) {
            zzge zzge = (zzge) list;
            i = 0;
            while (i2 < size) {
                i += zzfq.zzf(zzge.zza(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfq.zzf(list.get(i2).intValue());
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
        if (list instanceof zzge) {
            zzge zzge = (zzge) list;
            i = 0;
            while (i2 < size) {
                i += zzfq.zzg(zzge.zza(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfq.zzg(list.get(i2).intValue());
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
        if (list instanceof zzge) {
            zzge zzge = (zzge) list;
            i = 0;
            while (i2 < size) {
                i += zzfq.zzh(zzge.zza(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfq.zzh(list.get(i2).intValue());
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

    public static void zza(int i, List<Double> list, zzjn zzjn, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjn.zzg(i, list, z);
        }
    }

    public static int zzh(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzfq.zzi(i, 0) * size;
    }

    public static int zzi(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzfq.zzg(i, 0L) * size;
    }

    public static int zzj(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzfq.zzb(i, true) * size;
    }

    public static void zzb(int i, List<?> list, zzjn zzjn, zzib zzib) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjn.zzb(i, list, zzib);
        }
    }

    public static void zza(int i, List<String> list, zzjn zzjn) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjn.zza(i, list);
        }
    }

    public static int zzb(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgz) {
            zzgz zzgz = (zzgz) list;
            i = 0;
            while (i2 < size) {
                i += zzfq.zze(zzgz.zza(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfq.zze(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static void zza(int i, List<?> list, zzjn zzjn, zzib zzib) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjn.zza(i, list, zzib);
        }
    }

    public static int zzc(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzfq.zze(i) * size) + zzc(list);
    }

    public static int zzd(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzfq.zze(i) * size) + zzd(list);
    }

    public static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzfq.zze(i) * size) + zze(list);
    }

    public static int zzf(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzfq.zze(i) * size) + zzf(list);
    }

    public static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzfq.zze(i) * size) + zzg(list);
    }

    public static int zza(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgz) {
            zzgz zzgz = (zzgz) list;
            i = 0;
            while (i2 < size) {
                i += zzfq.zzd(zzgz.zza(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzfq.zzd(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzit<?, ?> zzc() {
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
        return (zzfq.zze(i) * size) + zzb(list);
    }

    public static int zza(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return (zzfq.zze(i) * list.size()) + zza(list);
    }

    public static int zzb(int i, List<zzez> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = zzfq.zze(i) * size;
        for (int i2 = 0; i2 < list.size(); i2++) {
            zze += zzfq.zzb(list.get(i2));
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
        int zze = zzfq.zze(i) * size;
        if (list instanceof zzgw) {
            zzgw zzgw = (zzgw) list;
            while (i4 < size) {
                Object zza2 = zzgw.zza(i4);
                if (zza2 instanceof zzez) {
                    i3 = zzfq.zzb((zzez) zza2);
                } else {
                    i3 = zzfq.zzb((String) zza2);
                }
                zze = i3 + zze;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzez) {
                    i2 = zzfq.zzb((zzez) obj);
                } else {
                    i2 = zzfq.zzb((String) obj);
                }
                zze = i2 + zze;
                i4++;
            }
        }
        return zze;
    }

    public static int zzb(int i, List<zzhl> list, zzib zzib) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzfq.zzc(i, list.get(i3), zzib);
        }
        return i2;
    }

    public static zzit<?, ?> zzb() {
        return zzc;
    }

    public static int zza(int i, Object obj, zzib zzib) {
        if (obj instanceof zzgu) {
            return zzfq.zza(i, (zzgu) obj);
        }
        return zzfq.zzb(i, (zzhl) obj, zzib);
    }

    public static int zza(int i, List<?> list, zzib zzib) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = zzfq.zze(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzgu) {
                i2 = zzfq.zza((zzgu) obj);
            } else {
                i2 = zzfq.zza((zzhl) obj, zzib);
            }
            zze = i2 + zze;
        }
        return zze;
    }

    public static zzit<?, ?> zza() {
        return zzb;
    }

    private static zzit<?, ?> zza(boolean z) {
        try {
            Class<?> zze = zze();
            if (zze == null) {
                return null;
            }
            return (zzit) zze.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
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

    public static <T> void zza(zzhi zzhi, T t, T t2, long j) {
        zziz.zza(t, j, zzhi.zza(zziz.zzf(t, j), zziz.zzf(t2, j)));
    }

    public static <T, FT extends zzfx<FT>> void zza(zzfu<FT> zzfu, T t, T t2) {
        zzfv<FT> zza2 = zzfu.zza((Object) t2);
        if (!zza2.zza.isEmpty()) {
            zzfu.zzb(t).zza(zza2);
        }
    }

    public static <T, UT, UB> void zza(zzit<UT, UB> zzit, T t, T t2) {
        zzit.zza((Object) t, (Object) zzit.zzb(zzit.zza(t), zzit.zza(t2)));
    }
}
