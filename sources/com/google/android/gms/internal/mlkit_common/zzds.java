package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.internal.mlkit_common.zzav;
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
public final class zzds {
    public static final Component<?> zza = Component.builder(zzds.class).add(Dependency.required(Context.class)).add(Dependency.required(SharedPrefManager.class)).add(Dependency.required(zza.class)).factory(zzdv.zza).build();
    @Nullable
    private static List<String> zzb = null;
    private static boolean zzk = true;
    private static boolean zzl = true;
    private final String zzc;
    private final String zzd;
    private final zza zze;
    private final SharedPrefManager zzf;
    private final Task<String> zzg;
    private final Task<String> zzh;
    private final Map<zzbg, Long> zzi = new HashMap();
    private final Map<zzbg, Object> zzj = new HashMap();

    public interface zza {
        void zza(zzav.zzad zzad);
    }

    private zzds(Context context, SharedPrefManager sharedPrefManager, zza zza2) {
        this.zzc = context.getPackageName();
        this.zzd = CommonUtils.getAppVersion(context);
        this.zzf = sharedPrefManager;
        this.zze = zza2;
        this.zzg = MLTaskExecutor.getInstance().scheduleCallable(zzdr.zza);
        MLTaskExecutor instance = MLTaskExecutor.getInstance();
        sharedPrefManager.getClass();
        this.zzh = instance.scheduleCallable(zzdu.zza(sharedPrefManager));
    }

    @NonNull
    private static synchronized List<String> zzb() {
        synchronized (zzds.class) {
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

    public final void zza(@NonNull zzav.zzad.zza zza2, @NonNull zzbg zzbg) {
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable(this, zza2, zzbg) { // from class: com.google.android.gms.internal.mlkit_common.zzdt
            private final zzds zza;
            private final zzav.zzad.zza zzb;
            private final zzbg zzc;

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

    public static final /* synthetic */ zzds zza(ComponentContainer componentContainer) {
        return new zzds((Context) componentContainer.get(Context.class), (SharedPrefManager) componentContainer.get(SharedPrefManager.class), (zza) componentContainer.get(zza.class));
    }

    public final /* synthetic */ void zzb(zzav.zzad.zza zza2, zzbg zzbg) {
        String str;
        String str2;
        String zza3 = zza2.zza().zza();
        if ("NA".equals(zza3) || "".equals(zza3)) {
            zza3 = "NA";
        }
        zzav.zzbh.zza zzb2 = zzav.zzbh.zzb().zza(this.zzc).zzb(this.zzd).zzd(zza3).zza(zzb()).zzb(true);
        if (this.zzg.isSuccessful()) {
            str = this.zzg.getResult();
        } else {
            str = LibraryVersion.getInstance().getVersion("common");
        }
        zzav.zzbh.zza zzc2 = zzb2.zzc(str);
        if (zzl) {
            if (this.zzh.isSuccessful()) {
                str2 = this.zzh.getResult();
            } else {
                str2 = this.zzf.getMlSdkInstanceId();
            }
            zzc2.zze(str2);
        }
        zza2.zza(zzbg).zza(zzc2);
        this.zze.zza((zzav.zzad) ((zzfq) zza2.zzg()));
    }
}
