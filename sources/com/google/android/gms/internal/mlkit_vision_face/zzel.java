package com.google.android.gms.internal.mlkit_vision_face;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.internal.mlkit_vision_face.zzbm;
import com.google.android.gms.tasks.Task;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
public final class zzel {
    public static final Component<?> zza = Component.builder(zzel.class).add(Dependency.required(Context.class)).add(Dependency.required(SharedPrefManager.class)).add(Dependency.required(zzb.class)).factory(zzeo.zza).build();
    @Nullable
    private static List<String> zzb = null;
    private static boolean zzk = true;
    private static boolean zzl = true;
    private final String zzc;
    private final String zzd;
    private final zzb zze;
    private final SharedPrefManager zzf;
    private final Task<String> zzg;
    private final Task<String> zzh;
    private final Map<zzcb, Long> zzi = new HashMap();
    private final Map<zzcb, zzau<Object, Long>> zzj = new HashMap();

    public interface zza<K> {
        zzbm.zzad.zza zza(K k, int i, zzbm.zzab zzab);
    }

    public interface zzb {
        void zza(zzbm.zzad zzad);
    }

    public interface zzc {
        zzbm.zzad.zza zza();
    }

    private zzel(Context context, SharedPrefManager sharedPrefManager, zzb zzb2) {
        this.zzc = context.getPackageName();
        this.zzd = CommonUtils.getAppVersion(context);
        this.zzf = sharedPrefManager;
        this.zze = zzb2;
        this.zzg = MLTaskExecutor.getInstance().scheduleCallable(zzek.zza);
        MLTaskExecutor instance = MLTaskExecutor.getInstance();
        sharedPrefManager.getClass();
        this.zzh = instance.scheduleCallable(zzen.zza(sharedPrefManager));
    }

    @NonNull
    private static synchronized List<String> zzb() {
        synchronized (zzel.class) {
            List<String> list = zzb;
            if (list != null) {
                return list;
            }
            LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
            zzb = new ArrayList(locales.size());
            for (int i = 0; i < locales.size(); i++) {
                zzb.add(CommonUtils.languageTagFromLocale(locales.get(i)));
            }
            return zzb;
        }
    }

    public final void zza(@NonNull zzbm.zzad.zza zza2, @NonNull zzcb zzcb) {
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable(this, zza2, zzcb) { // from class: com.google.android.gms.internal.mlkit_vision_face.zzem
            private final zzel zza;
            private final zzbm.zzad.zza zzb;
            private final zzcb zzc;

            {
                this.zza = r1;
                this.zzb = r2;
                this.zzc = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzb(this.zzb, this.zzc);
            }
        });
    }

    @WorkerThread
    public final void zza(@NonNull zzc zzc2, @NonNull zzcb zzcb) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (zza(zzcb, elapsedRealtime, 30)) {
            this.zzi.put(zzcb, Long.valueOf(elapsedRealtime));
            zza(zzc2.zza(), zzcb);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: com.google.android.gms.internal.mlkit_vision_face.zzel$zza<K> */
    /* JADX WARN: Multi-variable type inference failed */
    @WorkerThread
    public final <K> void zza(@NonNull K k, long j, @NonNull zzcb zzcb, @NonNull zza<K> zza2) {
        if (zzk) {
            if (!this.zzj.containsKey(zzcb)) {
                this.zzj.put(zzcb, zzab.zzh());
            }
            zzau<Object, Long> zzau = this.zzj.get(zzcb);
            zzau.zza(k, Long.valueOf(j));
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (zza(zzcb, elapsedRealtime, 30)) {
                this.zzi.put(zzcb, Long.valueOf(elapsedRealtime));
                for (Object obj : zzau.zzf()) {
                    List<Long> zzb2 = zzau.zzb(obj);
                    Collections.sort(zzb2);
                    zzbm.zzab.zza zza3 = zzbm.zzab.zza();
                    long j2 = 0;
                    for (Long l : zzb2) {
                        j2 += l.longValue();
                    }
                    zza(zza2.zza(obj, zzau.zzb(obj).size(), (zzbm.zzab) ((zzgd) zza3.zzc(j2 / ((long) zzb2.size())).zza(zza(zzb2, 100.0d)).zzf(zza(zzb2, 75.0d)).zze(zza(zzb2, 50.0d)).zzd(zza(zzb2, 25.0d)).zzb(zza(zzb2, 0.0d)).zzh())), zzcb);
                }
                this.zzj.remove(zzcb);
            }
        }
    }

    public final /* synthetic */ void zzb(zzbm.zzad.zza zza2, zzcb zzcb) {
        String str;
        String str2;
        String zza3 = zza2.zza().zza();
        if ("NA".equals(zza3) || "".equals(zza3)) {
            zza3 = "NA";
        }
        zzbm.zzbh.zza zzb2 = zzbm.zzbh.zzb().zza(this.zzc).zzb(this.zzd).zzd(zza3).zza(zzb()).zzb(true);
        if (this.zzg.isSuccessful()) {
            str = this.zzg.getResult();
        } else {
            str = LibraryVersion.getInstance().getVersion("play-services-mlkit-face-detection");
        }
        zzbm.zzbh.zza zzc2 = zzb2.zzc(str);
        if (zzl) {
            if (this.zzh.isSuccessful()) {
                str2 = this.zzh.getResult();
            } else {
                str2 = this.zzf.getMlSdkInstanceId();
            }
            zzc2.zze(str2);
        }
        zza2.zza(zzcb).zza(zzc2);
        this.zze.zza((zzbm.zzad) ((zzgd) zza2.zzh()));
    }

    @VisibleForTesting
    private static long zza(List<Long> list, double d) {
        return list.get(Math.max(((int) Math.ceil((d / 100.0d) * ((double) list.size()))) - 1, 0)).longValue();
    }

    @WorkerThread
    private final boolean zza(@NonNull zzcb zzcb, long j, long j2) {
        if (this.zzi.get(zzcb) != null && j - this.zzi.get(zzcb).longValue() <= TimeUnit.SECONDS.toMillis(30)) {
            return false;
        }
        return true;
    }

    public static final /* synthetic */ zzel zza(ComponentContainer componentContainer) {
        return new zzel((Context) componentContainer.get(Context.class), (SharedPrefManager) componentContainer.get(SharedPrefManager.class), (zzb) componentContainer.get(zzb.class));
    }
}
