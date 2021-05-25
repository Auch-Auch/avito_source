package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public final class zzdh implements zzcm {
    @GuardedBy("SharedPreferencesLoader.class")
    private static final Map<String, zzdh> zza = new ArrayMap();
    private final SharedPreferences zzb;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc;
    private final Object zzd = new Object();
    private volatile Map<String, ?> zze;
    @GuardedBy("this")
    private final List<zzcn> zzf = new ArrayList();

    private zzdh(SharedPreferences sharedPreferences) {
        zzdg zzdg = new SharedPreferences.OnSharedPreferenceChangeListener(this) { // from class: com.google.android.gms.internal.measurement.zzdg
            private final zzdh zza;

            {
                this.zza = r1;
            }

            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str) {
                this.zza.zza(sharedPreferences2, str);
            }
        };
        this.zzc = zzdg;
        this.zzb = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(zzdg);
    }

    public static zzdh zza(Context context, String str) {
        zzdh zzdh;
        if (!((!zzcg.zza() || str.startsWith("direct_boot:")) ? true : zzcg.zza(context))) {
            return null;
        }
        synchronized (zzdh.class) {
            Map<String, zzdh> map = zza;
            zzdh = map.get(str);
            if (zzdh == null) {
                zzdh = new zzdh(zzb(context, str));
                map.put(str, zzdh);
            }
        }
        return zzdh;
    }

    private static SharedPreferences zzb(Context context, String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (str.startsWith("direct_boot:")) {
                if (zzcg.zza()) {
                    context = context.createDeviceProtectedStorageContext();
                }
                return context.getSharedPreferences(str.substring(12), 0);
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return sharedPreferences;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // com.google.android.gms.internal.measurement.zzcm
    public final Object zza(String str) {
        Map<String, ?> map = this.zze;
        if (map == null) {
            synchronized (this.zzd) {
                map = this.zze;
                if (map == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        Map<String, ?> all = this.zzb.getAll();
                        this.zze = all;
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        map = all;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public static synchronized void zza() {
        synchronized (zzdh.class) {
            for (zzdh zzdh : zza.values()) {
                zzdh.zzb.unregisterOnSharedPreferenceChangeListener(zzdh.zzc);
            }
            zza.clear();
        }
    }

    public final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zzd) {
            this.zze = null;
            zzcw.zza();
        }
        synchronized (this) {
            for (zzcn zzcn : this.zzf) {
                zzcn.zza();
            }
        }
    }
}
