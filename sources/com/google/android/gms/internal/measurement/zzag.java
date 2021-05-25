package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzhc;
import com.google.android.gms.measurement.internal.zzhf;
import com.google.android.gms.measurement.internal.zzil;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
public class zzag {
    private static volatile zzag zzb = null;
    private static Boolean zzh = null;
    @VisibleForTesting
    private static String zzi = "allow_remote_dynamite";
    private static boolean zzj = false;
    public final Clock zza;
    private final String zzc;
    private final ExecutorService zzd;
    private final AppMeasurementSdk zze;
    private List<Pair<zzhf, zzd>> zzf;
    private int zzg;
    private boolean zzk;
    private String zzl;
    private zzv zzm;

    public static class zza extends zzaa {
        private final zzhc zza;

        public zza(zzhc zzhc) {
            this.zza = zzhc;
        }

        @Override // com.google.android.gms.internal.measurement.zzab
        public final void zza(String str, String str2, Bundle bundle, long j) {
            this.zza.interceptEvent(str, str2, bundle, j);
        }

        @Override // com.google.android.gms.internal.measurement.zzab
        public final int zza() {
            return System.identityHashCode(this.zza);
        }
    }

    public abstract class zzb implements Runnable {
        public final long zza;
        public final long zzb;
        private final boolean zzc;

        public zzb(zzag zzag) {
            this(true);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (zzag.this.zzk) {
                zzb();
                return;
            }
            try {
                zza();
            } catch (Exception e) {
                zzag.this.zza(e, false, this.zzc);
                zzb();
            }
        }

        public abstract void zza() throws RemoteException;

        public void zzb() {
        }

        public zzb(boolean z) {
            this.zza = zzag.this.zza.currentTimeMillis();
            this.zzb = zzag.this.zza.elapsedRealtime();
            this.zzc = z;
        }
    }

    public class zzc implements Application.ActivityLifecycleCallbacks {
        public zzc() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            zzag.this.zza(new zzbn(this, activity, bundle));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            zzag.this.zza(new zzbs(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            zzag.this.zza(new zzbo(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            zzag.this.zza(new zzbp(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            zzt zzt = new zzt();
            zzag.this.zza(new zzbq(this, activity, zzt));
            Bundle zzb = zzt.zzb(50);
            if (zzb != null) {
                bundle.putAll(zzb);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            zzag.this.zza(new zzbm(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            zzag.this.zza(new zzbr(this, activity));
        }
    }

    public static class zzd extends zzaa {
        private final zzhf zza;

        public zzd(zzhf zzhf) {
            this.zza = zzhf;
        }

        @Override // com.google.android.gms.internal.measurement.zzab
        public final void zza(String str, String str2, Bundle bundle, long j) {
            this.zza.onEvent(str, str2, bundle, j);
        }

        @Override // com.google.android.gms.internal.measurement.zzab
        public final int zza() {
            return System.identityHashCode(this.zza);
        }
    }

    private zzag(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !zzc(str2, str3)) {
            this.zzc = "FA";
        } else {
            this.zzc = str;
        }
        this.zza = DefaultClock.getInstance();
        this.zzd = zzi.zza().zza(new zzas(this), zzr.zza);
        this.zze = new AppMeasurementSdk(this);
        boolean z = false;
        if (!(!zze(context) || zzk())) {
            this.zzl = null;
            this.zzk = true;
            return;
        }
        if (!zzc(str2, str3)) {
            this.zzl = "fa";
            if (str2 == null || str3 == null) {
                boolean z2 = (str2 == null) ^ (str3 == null ? true : z);
            }
        } else {
            this.zzl = str2;
        }
        zza(new zzaj(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application != null) {
            application.registerActivityLifecycleCallbacks(new zzc());
        }
    }

    public static zzag zza(@NonNull Context context) {
        return zza(context, (String) null, (String) null, (String) null, (Bundle) null);
    }

    /* access modifiers changed from: private */
    public static boolean zzc(String str, String str2) {
        return (str2 == null || str == null || zzk()) ? false : true;
    }

    private static boolean zze(Context context) {
        try {
            return zzil.zza(context, "google_app_id") != null;
        } catch (IllegalStateException unused) {
        }
    }

    /* access modifiers changed from: private */
    public static int zzf(Context context) {
        return DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID);
    }

    /* access modifiers changed from: private */
    public static int zzg(Context context) {
        return DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID);
    }

    private static boolean zzk() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void zzb(zzhf zzhf) {
        Preconditions.checkNotNull(zzhf);
        zza(new zzbi(this, zzhf));
    }

    public final String zzd() {
        zzt zzt = new zzt();
        zza(new zzax(this, zzt));
        return zzt.zza(50);
    }

    @WorkerThread
    public final String zzh() {
        zzt zzt = new zzt();
        zza(new zzbe(this, zzt));
        return zzt.zza(120000);
    }

    public final String zzi() {
        return this.zzl;
    }

    public static zzag zza(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzb == null) {
            synchronized (zzag.class) {
                if (zzb == null) {
                    zzb = new zzag(context, str, str2, str3, bundle);
                }
            }
        }
        return zzb;
    }

    public final void zzc(String str) {
        zza(new zzav(this, str));
    }

    public final long zze() {
        zzt zzt = new zzt();
        zza(new zzaw(this, zzt));
        Long l = (Long) zzt.zza(zzt.zzb(500), Long.class);
        if (l != null) {
            return l.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
        int i = this.zzg + 1;
        this.zzg = i;
        return nextLong + ((long) i);
    }

    public final String zzf() {
        zzt zzt = new zzt();
        zza(new zzaz(this, zzt));
        return zzt.zza(500);
    }

    public final String zzg() {
        zzt zzt = new zzt();
        zza(new zzay(this, zzt));
        return zzt.zza(500);
    }

    public final void zzb(String str, String str2, Bundle bundle) {
        zza(new zzal(this, str, str2, bundle));
    }

    public final String zzc() {
        zzt zzt = new zzt();
        zza(new zzau(this, zzt));
        return zzt.zza(500);
    }

    /* access modifiers changed from: private */
    public static void zzh(Context context) {
        synchronized (zzag.class) {
            try {
                if (zzh == null) {
                    if (zza(context, "app_measurement_internal_disable_startup_flags")) {
                        zzh = Boolean.FALSE;
                        return;
                    }
                    SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
                    zzh = Boolean.valueOf(sharedPreferences.getBoolean(zzi, false));
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.remove(zzi);
                    edit.apply();
                }
            } catch (Exception unused) {
                zzh = Boolean.FALSE;
            }
        }
    }

    public final List<Bundle> zzb(String str, String str2) {
        zzt zzt = new zzt();
        zza(new zzak(this, str, str2, zzt));
        List<Bundle> list = (List) zzt.zza(zzt.zzb(5000), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final int zzd(String str) {
        zzt zzt = new zzt();
        zza(new zzbc(this, str, zzt));
        Integer num = (Integer) zzt.zza(zzt.zzb(10000), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final void zzb() {
        zza(new zzao(this));
    }

    public final AppMeasurementSdk zza() {
        return this.zze;
    }

    public final void zzb(long j) {
        zza(new zzaq(this, j));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(zzb zzb2) {
        this.zzd.execute(zzb2);
    }

    public final void zzb(String str) {
        zza(new zzat(this, str));
    }

    public final zzv zza(Context context, boolean z) {
        DynamiteModule.VersionPolicy versionPolicy;
        if (z) {
            try {
                versionPolicy = DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION;
            } catch (DynamiteModule.LoadingException e) {
                zza((Exception) e, true, false);
                return null;
            }
        } else {
            versionPolicy = DynamiteModule.PREFER_LOCAL;
        }
        return zzu.asInterface(DynamiteModule.load(context, versionPolicy, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
    }

    public final void zzb(boolean z) {
        zza(new zzbg(this, z));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(Exception exc, boolean z, boolean z2) {
        this.zzk |= z;
        if (!z && z2) {
            zza(5, "Error with data collection. Data lost.", exc, (Object) null, (Object) null);
        }
    }

    public final void zza(zzhc zzhc) {
        zza(new zzbf(this, zzhc));
    }

    public final void zza(zzhf zzhf) {
        Preconditions.checkNotNull(zzhf);
        zza(new zzbj(this, zzhf));
    }

    public final void zza(@NonNull String str, Bundle bundle) {
        zza(null, str, bundle, false, true, null);
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, null);
    }

    public final void zza(String str, String str2, Bundle bundle, long j) {
        zza(str, str2, bundle, true, false, Long.valueOf(j));
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        zza(new zzbl(this, l, str, str2, bundle, z, z2));
    }

    public final void zza(String str, String str2) {
        zza((String) null, str, (Object) str2, false);
    }

    public final void zza(String str, String str2, Object obj) {
        zza(str, str2, obj, true);
    }

    private final void zza(String str, String str2, Object obj, boolean z) {
        zza(new zzbk(this, str, str2, obj, z));
    }

    public final void zza(Bundle bundle) {
        zza(new zzai(this, bundle));
    }

    public final void zza(String str) {
        zza(new zzan(this, str));
    }

    public final void zza(Activity activity, String str, String str2) {
        zza(new zzam(this, activity, str, str2));
    }

    public final void zza(boolean z) {
        zza(new zzap(this, z));
    }

    public final void zza(long j) {
        zza(new zzar(this, j));
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        zzt zzt = new zzt();
        zza(new zzbb(this, str, str2, z, zzt));
        Bundle zzb2 = zzt.zzb(5000);
        if (zzb2 == null || zzb2.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(zzb2.size());
        for (String str3 : zzb2.keySet()) {
            Object obj = zzb2.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }

    public final void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        zza(new zzba(this, false, 5, str, obj, null, null));
    }

    public final Bundle zza(Bundle bundle, boolean z) {
        zzt zzt = new zzt();
        zza(new zzbd(this, bundle, zzt));
        if (z) {
            return zzt.zzb(5000);
        }
        return null;
    }

    public final Object zza(int i) {
        zzt zzt = new zzt();
        zza(new zzbh(this, zzt, i));
        return zzt.zza(zzt.zzb(15000), Object.class);
    }

    private static boolean zza(Context context, @Size(min = 1) String str) {
        Preconditions.checkNotEmpty(str);
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    return bundle.getBoolean(str);
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }
}
