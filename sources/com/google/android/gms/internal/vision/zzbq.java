package com.google.android.gms.internal.vision;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public final class zzbq implements zzay {
    @GuardedBy("SharedPreferencesLoader.class")
    private static final Map<String, zzbq> zzhc = new ArrayMap();
    private final Object zzfs = new Object();
    private volatile Map<String, ?> zzft;
    @GuardedBy("this")
    private final List<zzaz> zzfu = new ArrayList();
    private final SharedPreferences zzhd;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzhe;

    private zzbq(SharedPreferences sharedPreferences) {
        zzbt zzbt = new SharedPreferences.OnSharedPreferenceChangeListener(this) { // from class: com.google.android.gms.internal.vision.zzbt
            private final zzbq zzhg;

            {
                this.zzhg = r1;
            }

            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str) {
                this.zzhg.zza(sharedPreferences2, str);
            }
        };
        this.zzhe = zzbt;
        this.zzhd = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(zzbt);
    }

    public static zzbq zzb(Context context, String str) {
        zzbq zzbq;
        if (!((!zzas.zzu() || str.startsWith("direct_boot:")) ? true : zzas.isUserUnlocked(context))) {
            return null;
        }
        synchronized (zzbq.class) {
            Map<String, zzbq> map = zzhc;
            zzbq = map.get(str);
            if (zzbq == null) {
                zzbq = new zzbq(zzc(context, str));
                map.put(str, zzbq);
            }
        }
        return zzbq;
    }

    private static SharedPreferences zzc(Context context, String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (str.startsWith("direct_boot:")) {
                if (zzas.zzu()) {
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

    public static synchronized void zzy() {
        synchronized (zzbq.class) {
            for (zzbq zzbq : zzhc.values()) {
                zzbq.zzhd.unregisterOnSharedPreferenceChangeListener(zzbq.zzhe);
            }
            zzhc.clear();
        }
    }

    public final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zzfs) {
            this.zzft = null;
            zzbi.zzaf();
        }
        synchronized (this) {
            for (zzaz zzaz : this.zzfu) {
                zzaz.zzad();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // com.google.android.gms.internal.vision.zzay
    public final Object zzb(String str) {
        Map<String, ?> map = this.zzft;
        if (map == null) {
            synchronized (this.zzfs) {
                map = this.zzft;
                if (map == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        Map<String, ?> all = this.zzhd.getAll();
                        this.zzft = all;
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
}
