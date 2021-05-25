package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.internal.mlkit_vision_common.zzr;
import com.google.android.gms.tasks.Task;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
public final class zzcq {
    public static final Component<?> zza = Component.builder(zzcq.class).add(Dependency.required(Context.class)).add(Dependency.required(SharedPrefManager.class)).add(Dependency.required(zzb.class)).factory(zzct.zza).build();
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
    private final Map<zzag, Long> zzi = new HashMap();
    private final Map<zzag, Object> zzj = new HashMap();

    public interface zza {
        zzr.zzad.zza zza();
    }

    public interface zzb {
        void zza(zzr.zzad zzad);
    }

    private zzcq(Context context, SharedPrefManager sharedPrefManager, zzb zzb2) {
        this.zzc = context.getPackageName();
        this.zzd = CommonUtils.getAppVersion(context);
        this.zzf = sharedPrefManager;
        this.zze = zzb2;
        this.zzg = MLTaskExecutor.getInstance().scheduleCallable(zzcp.zza);
        MLTaskExecutor instance = MLTaskExecutor.getInstance();
        sharedPrefManager.getClass();
        this.zzh = instance.scheduleCallable(zzcs.zza(sharedPrefManager));
    }

    @NonNull
    private static synchronized List<String> zzb() {
        synchronized (zzcq.class) {
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

    @WorkerThread
    public final void zza(@NonNull zza zza2, @NonNull zzag zzag) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = true;
        if (this.zzi.get(zzag) != null && elapsedRealtime - this.zzi.get(zzag).longValue() <= TimeUnit.SECONDS.toMillis(30)) {
            z = false;
        }
        if (z) {
            this.zzi.put(zzag, Long.valueOf(elapsedRealtime));
            MLTaskExecutor.workerThreadExecutor().execute(new Runnable(this, zza2.zza(), zzag) { // from class: com.google.android.gms.internal.mlkit_vision_common.zzcr
                private final zzcq zza;
                private final zzr.zzad.zza zzb;
                private final zzag zzc;

                {
                    this.zza = r1;
                    this.zzb = r2;
                    this.zzc = r3;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zza(this.zzb, this.zzc);
                }
            });
        }
    }

    public final /* synthetic */ void zza(zzr.zzad.zza zza2, zzag zzag) {
        String str;
        String str2;
        String zza3 = zza2.zza().zza();
        if ("NA".equals(zza3) || "".equals(zza3)) {
            zza3 = "NA";
        }
        zzr.zzbh.zza zzb2 = zzr.zzbh.zzb().zza(this.zzc).zzb(this.zzd).zzd(zza3).zza(zzb()).zzb(true);
        if (this.zzg.isSuccessful()) {
            str = this.zzg.getResult();
        } else {
            str = LibraryVersion.getInstance().getVersion("vision-common");
        }
        zzr.zzbh.zza zzc2 = zzb2.zzc(str);
        if (zzl) {
            if (this.zzh.isSuccessful()) {
                str2 = this.zzh.getResult();
            } else {
                str2 = this.zzf.getMlSdkInstanceId();
            }
            zzc2.zze(str2);
        }
        zza2.zza(zzag).zza(zzc2);
        this.zze.zza((zzr.zzad) ((zzej) zza2.zzh()));
    }

    public static final /* synthetic */ zzcq zza(ComponentContainer componentContainer) {
        return new zzcq((Context) componentContainer.get(Context.class), (SharedPrefManager) componentContainer.get(SharedPrefManager.class), (zzb) componentContainer.get(zzb.class));
    }
}
