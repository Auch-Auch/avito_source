package com.google.android.gms.common.config;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Binder;
import android.os.StrictMode;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
@KeepForSdk
public abstract class GservicesValue<T> {
    private static final Object zzc = new Object();
    @Nullable
    private static zza zzd;
    private static int zze;
    @Nullable
    @SuppressLint({"StaticFieldLeak"})
    private static Context zzf;
    @Nullable
    @GuardedBy("lock")
    private static Set<String> zzg;
    @RecentlyNonNull
    public final String zza;
    @RecentlyNonNull
    public final T zzb;
    @Nullable
    private T zzh = null;

    public interface zza {
        Boolean zza(String str, Boolean bool);

        Float zza(String str, Float f);

        Integer zza(String str, Integer num);

        Long zza(String str, Long l);

        String zza(String str, String str2);
    }

    public GservicesValue(@RecentlyNonNull String str, @RecentlyNonNull T t) {
        this.zza = str;
        this.zzb = t;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static boolean isInitialized() {
        synchronized (zzc) {
        }
        return false;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static GservicesValue<Boolean> value(@RecentlyNonNull String str, @RecentlyNonNull boolean z) {
        return new zzb(str, Boolean.valueOf(z));
    }

    private static boolean zza() {
        synchronized (zzc) {
        }
        return false;
    }

    @RecentlyNonNull
    @KeepForSdk
    public final T get() {
        long clearCallingIdentity;
        T t = this.zzh;
        if (t != null) {
            return t;
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        Object obj = zzc;
        synchronized (obj) {
        }
        synchronized (obj) {
            zzg = null;
            zzf = null;
        }
        try {
            T zza2 = zza(this.zza);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return zza2;
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            T zza3 = zza(this.zza);
            Binder.restoreCallingIdentity(clearCallingIdentity);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return zza3;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }

    @RecentlyNonNull
    @Deprecated
    @KeepForSdk
    public final T getBinderSafe() {
        return get();
    }

    @VisibleForTesting
    @KeepForSdk
    public void override(@RecentlyNonNull T t) {
        this.zzh = t;
        synchronized (zzc) {
            zza();
        }
    }

    @VisibleForTesting
    @KeepForSdk
    public void resetOverride() {
        this.zzh = null;
    }

    @RecentlyNonNull
    public abstract T zza(@RecentlyNonNull String str);

    @RecentlyNonNull
    @KeepForSdk
    public static GservicesValue<Long> value(@RecentlyNonNull String str, @RecentlyNonNull Long l) {
        return new zza(str, l);
    }

    @RecentlyNonNull
    @KeepForSdk
    public static GservicesValue<Integer> value(@RecentlyNonNull String str, @RecentlyNonNull Integer num) {
        return new zzd(str, num);
    }

    @RecentlyNonNull
    @KeepForSdk
    public static GservicesValue<Float> value(@RecentlyNonNull String str, @RecentlyNonNull Float f) {
        return new zzc(str, f);
    }

    @RecentlyNonNull
    @KeepForSdk
    public static GservicesValue<String> value(@RecentlyNonNull String str, @RecentlyNonNull String str2) {
        return new zze(str, str2);
    }
}
