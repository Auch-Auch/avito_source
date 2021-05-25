package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.lang.reflect.Method;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
@ParametersAreNonnullByDefault
public final class zzawb {
    private final AtomicReference<ThreadPoolExecutor> zzdwt = new AtomicReference<>(null);
    private final Object zzdwu = new Object();
    @Nullable
    @GuardedBy("gmpAppIdLock")
    private String zzdwv = null;
    @Nullable
    @GuardedBy("gmpAppIdLock")
    private String zzdww = null;
    @VisibleForTesting
    private final AtomicBoolean zzdwx = new AtomicBoolean(false);
    private final AtomicInteger zzdwy = new AtomicInteger(-1);
    private final AtomicReference<Object> zzdwz = new AtomicReference<>(null);
    private final AtomicReference<Object> zzdxa = new AtomicReference<>(null);
    private final ConcurrentMap<String, Method> zzdxb = new ConcurrentHashMap(9);
    private final AtomicReference<zzbib> zzdxc = new AtomicReference<>(null);
    @GuardedBy("proxyReference")
    private final BlockingQueue<FutureTask<?>> zzdxd = new ArrayBlockingQueue(20);
    private final Object zzdxe = new Object();

    @VisibleForTesting
    private static boolean zzad(Context context) {
        if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcni)).booleanValue()) {
            return false;
        }
        if (DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) < ((Integer) zzwe.zzpu().zzd(zzaat.zzcnj)).intValue()) {
            return false;
        }
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcnk)).booleanValue()) {
            try {
                context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                return false;
            } catch (ClassNotFoundException unused) {
            }
        }
        return true;
    }

    @Nullable
    private final Method zzaj(Context context) {
        Method method = this.zzdxb.get("logEventInternal");
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", String.class, String.class, Bundle.class);
            this.zzdxb.put("logEventInternal", declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, "logEventInternal", true);
            return null;
        }
    }

    @Nullable
    private final Method zzm(Context context, String str) {
        Method method = this.zzdxb.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, String.class);
            this.zzdxb.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, str, false);
            return null;
        }
    }

    @Nullable
    private final Method zzn(Context context, String str) {
        Method method = this.zzdxb.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[0]);
            this.zzdxb.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, str, false);
            return null;
        }
    }

    private final Method zzo(Context context, String str) {
        Method method = this.zzdxb.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod(str, Activity.class, String.class, String.class);
            this.zzdxb.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, str, false);
            return null;
        }
    }

    private final ThreadPoolExecutor zzvu() {
        if (this.zzdwt.get() == null) {
            AtomicReference<ThreadPoolExecutor> atomicReference = this.zzdwt;
            zzaai<Integer> zzaai = zzaat.zzcnh;
            atomicReference.compareAndSet(null, new ThreadPoolExecutor(((Integer) zzwe.zzpu().zzd(zzaai)).intValue(), ((Integer) zzwe.zzpu().zzd(zzaai)).intValue(), 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), new zzawp(this)));
        }
        return this.zzdwt.get();
    }

    public final void zza(Context context, zzzw zzzw) {
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcno)).booleanValue() && zzac(context) && zzad(context)) {
            synchronized (this.zzdxe) {
            }
        }
    }

    public final boolean zzac(Context context) {
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcnb)).booleanValue() && !this.zzdwx.get()) {
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcnl)).booleanValue()) {
                return true;
            }
            if (this.zzdwy.get() == -1) {
                zzwe.zzpq();
                if (!zzbat.zzd(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                    zzwe.zzpq();
                    if (zzbat.zzbo(context)) {
                        zzbbd.zzfe("Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
                        this.zzdwy.set(0);
                    }
                }
                this.zzdwy.set(1);
            }
            if (this.zzdwy.get() == 1) {
                return true;
            }
        }
        return false;
    }

    public final String zzae(Context context) {
        if (!zzac(context)) {
            return "";
        }
        if (zzad(context)) {
            return (String) zza("getCurrentScreenNameOrScreenClass", "", zzawg.zzdxg);
        }
        if (!zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdwz, true)) {
            return "";
        }
        try {
            String str = (String) zzn(context, "getCurrentScreenName").invoke(this.zzdwz.get(), new Object[0]);
            if (str == null) {
                str = (String) zzn(context, "getCurrentScreenClass").invoke(this.zzdwz.get(), new Object[0]);
            }
            if (str != null) {
                return str;
            }
            return "";
        } catch (Exception e) {
            zza(e, "getCurrentScreenName", false);
            return "";
        }
    }

    @Nullable
    public final String zzaf(Context context) {
        if (!zzac(context)) {
            return null;
        }
        synchronized (this.zzdwu) {
            String str = this.zzdwv;
            if (str != null) {
                return str;
            }
            if (zzad(context)) {
                this.zzdwv = (String) zza("getGmpAppId", this.zzdwv, zzawi.zzdxg);
            } else {
                this.zzdwv = (String) zza("getGmpAppId", context);
            }
            return this.zzdwv;
        }
    }

    @Nullable
    public final String zzag(Context context) {
        if (!zzac(context)) {
            return null;
        }
        long longValue = ((Long) zzwe.zzpu().zzd(zzaat.zzcng)).longValue();
        if (zzad(context)) {
            if (longValue >= 0) {
                return (String) zzvu().submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzawk
                    private final zzawb zzdxh;

                    {
                        this.zzdxh = r1;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.zzdxh.zzvv();
                    }
                }).get(longValue, TimeUnit.MILLISECONDS);
            }
            try {
                return (String) zza("getAppInstanceId", (String) null, zzawl.zzdxg);
            } catch (TimeoutException unused) {
                return "TIME_OUT";
            } catch (Exception unused2) {
                return null;
            }
        } else if (longValue < 0) {
            return (String) zza("getAppInstanceId", context);
        } else {
            try {
                return (String) zzvu().submit(new Callable(this, context) { // from class: com.google.android.gms.internal.ads.zzawn
                    private final Context zzcjx;
                    private final zzawb zzdxh;

                    {
                        this.zzdxh = r1;
                        this.zzcjx = r2;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.zzdxh.zzak(this.zzcjx);
                    }
                }).get(longValue, TimeUnit.MILLISECONDS);
            } catch (TimeoutException unused3) {
                return "TIME_OUT";
            } catch (Exception unused4) {
                return null;
            }
        }
    }

    @Nullable
    public final String zzah(Context context) {
        if (!zzac(context)) {
            return null;
        }
        if (zzad(context)) {
            Long l = (Long) zza("getAdEventId", (String) null, zzawm.zzdxg);
            if (l != null) {
                return Long.toString(l.longValue());
            }
            return null;
        }
        Object zza = zza("generateEventId", context);
        if (zza != null) {
            return zza.toString();
        }
        return null;
    }

    @Nullable
    public final String zzai(Context context) {
        if (!zzac(context)) {
            return null;
        }
        synchronized (this.zzdwu) {
            String str = this.zzdww;
            if (str != null) {
                return str;
            }
            if (zzad(context)) {
                this.zzdww = (String) zza("getAppIdOrigin", this.zzdww, zzawd.zzdxg);
            } else {
                this.zzdww = "fa";
            }
            return this.zzdww;
        }
    }

    public final /* synthetic */ String zzak(Context context) throws Exception {
        return (String) zza("getAppInstanceId", context);
    }

    public final void zzf(Context context, String str) {
        if (zzac(context)) {
            if (zzad(context)) {
                zza("beginAdUnitExposure", new zzawr(str) { // from class: com.google.android.gms.internal.ads.zzawa
                    private final String zzdgb;

                    {
                        this.zzdgb = r1;
                    }

                    @Override // com.google.android.gms.internal.ads.zzawr
                    public final void zza(zzbib zzbib) {
                        zzbib.beginAdUnitExposure(this.zzdgb);
                    }
                });
            } else {
                zza(context, str, "beginAdUnitExposure");
            }
        }
    }

    public final void zzg(Context context, String str) {
        if (zzac(context)) {
            if (zzad(context)) {
                zza("endAdUnitExposure", new zzawr(str) { // from class: com.google.android.gms.internal.ads.zzawh
                    private final String zzdgb;

                    {
                        this.zzdgb = r1;
                    }

                    @Override // com.google.android.gms.internal.ads.zzawr
                    public final void zza(zzbib zzbib) {
                        zzbib.endAdUnitExposure(this.zzdgb);
                    }
                });
            } else {
                zza(context, str, "endAdUnitExposure");
            }
        }
    }

    public final void zzh(Context context, String str) {
        if (!zzac(context) || !(context instanceof Activity)) {
            return;
        }
        if (zzad(context)) {
            zza("setScreenName", new zzawr(context, str) { // from class: com.google.android.gms.internal.ads.zzawj
                private final Context zzcxz;
                private final String zzdft;

                {
                    this.zzcxz = r1;
                    this.zzdft = r2;
                }

                @Override // com.google.android.gms.internal.ads.zzawr
                public final void zza(zzbib zzbib) {
                    Context context2 = this.zzcxz;
                    zzbib.zzb(ObjectWrapper.wrap(context2), this.zzdft, context2.getPackageName());
                }
            });
        } else if (zza(context, "com.google.firebase.analytics.FirebaseAnalytics", this.zzdxa, false)) {
            try {
                zzo(context, "setCurrentScreen").invoke(this.zzdxa.get(), (Activity) context, str, context.getPackageName());
            } catch (Exception e) {
                zza(e, "setCurrentScreen", false);
            }
        }
    }

    public final void zzi(Context context, String str) {
        zza(context, "_ac", str, (Bundle) null);
    }

    public final void zzj(Context context, String str) {
        zza(context, "_ai", str, (Bundle) null);
    }

    public final void zzk(Context context, String str) {
        zza(context, "_aq", str, (Bundle) null);
    }

    public final void zzl(Context context, String str) {
        zza(context, "_aa", str, (Bundle) null);
    }

    public final /* synthetic */ String zzvv() throws Exception {
        return (String) zza("getAppInstanceId", (String) null, zzawe.zzdxg);
    }

    private static Bundle zzl(String str, String str2) {
        Bundle bundle = new Bundle();
        try {
            bundle.putLong("_aeid", Long.parseLong(str));
        } catch (NullPointerException | NumberFormatException e) {
            String valueOf = String.valueOf(str);
            zzbbd.zzc(valueOf.length() != 0 ? "Invalid event ID: ".concat(valueOf) : new String("Invalid event ID: "), e);
        }
        if ("_ac".equals(str2)) {
            bundle.putInt("_r", 1);
        }
        return bundle;
    }

    public final void zza(Context context, zzvc zzvc) {
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcno)).booleanValue() && zzac(context) && zzad(context)) {
            synchronized (this.zzdxe) {
            }
        }
    }

    public final void zza(Context context, String str, String str2, String str3, int i) {
        if (zzac(context)) {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str2);
            bundle.putString("reward_type", str3);
            bundle.putInt("reward_value", i);
            zza(context, "_ar", str, bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 75);
            sb.append("Log a Firebase reward video event, reward type: ");
            sb.append(str3);
            sb.append(", reward value: ");
            sb.append(i);
            zzaxy.zzei(sb.toString());
        }
    }

    private final void zza(Context context, String str, String str2, @Nullable Bundle bundle) {
        if (zzac(context)) {
            Bundle zzl = zzl(str2, str);
            if (bundle != null) {
                zzl.putAll(bundle);
            }
            if (zzad(context)) {
                zza("logEventInternal", new zzawr(str, zzl) { // from class: com.google.android.gms.internal.ads.zzawc
                    private final String zzdgb;
                    private final Bundle zzdxf;

                    {
                        this.zzdgb = r1;
                        this.zzdxf = r2;
                    }

                    @Override // com.google.android.gms.internal.ads.zzawr
                    public final void zza(zzbib zzbib) {
                        zzbib.logEvent("am", this.zzdgb, this.zzdxf);
                    }
                });
            } else if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdwz, true)) {
                try {
                    zzaj(context).invoke(this.zzdwz.get(), "am", str, zzl);
                } catch (Exception e) {
                    zza(e, "logEventInternal", true);
                }
            }
        }
    }

    private final void zza(Context context, String str, String str2) {
        if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdwz, true)) {
            try {
                zzm(context, str2).invoke(this.zzdwz.get(), str);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 37 + String.valueOf(str).length());
                sb.append("Invoke Firebase method ");
                sb.append(str2);
                sb.append(", Ad Unit Id: ");
                sb.append(str);
                zzaxy.zzei(sb.toString());
            } catch (Exception e) {
                zza(e, str2, false);
            }
        }
    }

    private final Object zza(String str, Context context) {
        if (!zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdwz, true)) {
            return null;
        }
        try {
            return zzn(context, str).invoke(this.zzdwz.get(), new Object[0]);
        } catch (Exception e) {
            zza(e, str, true);
            return null;
        }
    }

    private final void zza(Exception exc, String str, boolean z) {
        if (!this.zzdwx.get()) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 30);
            sb.append("Invoke Firebase method ");
            sb.append(str);
            sb.append(" error.");
            zzbbd.zzfe(sb.toString());
            if (z) {
                zzbbd.zzfe("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
                this.zzdwx.set(true);
            }
        }
    }

    private final boolean zza(Context context, String str, AtomicReference<Object> atomicReference, boolean z) {
        if (atomicReference.get() == null) {
            try {
                atomicReference.compareAndSet(null, context.getClassLoader().loadClass(str).getDeclaredMethod("getInstance", Context.class).invoke(null, context));
            } catch (Exception e) {
                zza(e, "getInstance", z);
                return false;
            }
        }
        return true;
    }

    private final void zza(String str, zzawr zzawr) {
        synchronized (this.zzdxc) {
            FutureTask<?> futureTask = new FutureTask<>(new Runnable(this, zzawr, str) { // from class: com.google.android.gms.internal.ads.zzawf
                private final String zzdin;
                private final zzawb zzdxh;
                private final zzawr zzdxi;

                {
                    this.zzdxh = r1;
                    this.zzdxi = r2;
                    this.zzdin = r3;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzdxh.zza(this.zzdxi, this.zzdin);
                }
            }, null);
            if (this.zzdxc.get() != null) {
                futureTask.run();
            } else {
                this.zzdxd.offer(futureTask);
            }
        }
    }

    private final <T> T zza(String str, @Nullable T t, zzawo<T> zzawo) {
        synchronized (this.zzdxc) {
            if (this.zzdxc.get() != null) {
                try {
                    return zzawo.zzb(this.zzdxc.get());
                } catch (Exception e) {
                    zza(e, str, false);
                }
            }
            return t;
        }
    }

    public final /* synthetic */ void zza(zzawr zzawr, String str) {
        if (this.zzdxc.get() != null) {
            try {
                zzawr.zza(this.zzdxc.get());
            } catch (Exception e) {
                zza(e, str, false);
            }
        }
    }
}
