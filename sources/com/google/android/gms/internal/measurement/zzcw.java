package com.google.android.gms.internal.measurement;

import android.content.Context;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
public abstract class zzcw<T> {
    private static final Object zza = new Object();
    @Nullable
    private static volatile zzde zzb = null;
    private static volatile boolean zzc = false;
    private static final AtomicReference<Collection<zzcw<?>>> zzd = new AtomicReference<>();
    private static zzdj zze = new zzdj(zzcy.zza);
    private static final AtomicInteger zzi = new AtomicInteger();
    private final zzdf zzf;
    private final String zzg;
    private final T zzh;
    private volatile int zzj;
    private volatile T zzk;
    private final boolean zzl;

    private zzcw(zzdf zzdf, String str, T t, boolean z) {
        this.zzj = -1;
        if (zzdf.zzb != null) {
            this.zzf = zzdf;
            this.zzg = str;
            this.zzh = t;
            this.zzl = z;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    @Deprecated
    public static void zza(Context context) {
        synchronized (zza) {
            zzde zzde = zzb;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzde == null || zzde.zza() != context) {
                zzci.zzc();
                zzdh.zza();
                zzcr.zza();
                zzb = new zzcj(context, zzdu.zza((zzdv) new zzdv(context) { // from class: com.google.android.gms.internal.measurement.zzcz
                    private final Context zza;

                    {
                        this.zza = r1;
                    }

                    @Override // com.google.android.gms.internal.measurement.zzdv
                    public final Object zza() {
                        return zzcw.zzb(this.zza);
                    }
                }));
                zzi.incrementAndGet();
            }
        }
    }

    public static final /* synthetic */ boolean zzd() {
        return true;
    }

    public abstract T zza(Object obj);

    public final String zzb() {
        return zza(this.zzf.zzd);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T zzc() {
        /*
        // Method dump skipped, instructions count: 271
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzcw.zzc():java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static zzcw<Long> zzb(zzdf zzdf, String str, long j, boolean z) {
        return new zzdb(zzdf, str, Long.valueOf(j), true);
    }

    /* access modifiers changed from: private */
    public static zzcw<Boolean> zzb(zzdf zzdf, String str, boolean z, boolean z2) {
        return new zzda(zzdf, str, Boolean.valueOf(z), true);
    }

    /* access modifiers changed from: private */
    public static zzcw<Double> zzb(zzdf zzdf, String str, double d, boolean z) {
        return new zzdd(zzdf, str, Double.valueOf(d), true);
    }

    /* access modifiers changed from: private */
    public static zzcw<String> zzb(zzdf zzdf, String str, String str2, boolean z) {
        return new zzdc(zzdf, str, str2, true);
    }

    public static final /* synthetic */ zzdr zzb(Context context) {
        new zzcv();
        return zzcv.zza(context);
    }

    public /* synthetic */ zzcw(zzdf zzdf, String str, Object obj, boolean z, zzdb zzdb) {
        this(zzdf, str, obj, z);
    }

    public static void zza() {
        zzi.incrementAndGet();
    }

    private final String zza(String str) {
        if (str != null && str.isEmpty()) {
            return this.zzg;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.zzg);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }
}
