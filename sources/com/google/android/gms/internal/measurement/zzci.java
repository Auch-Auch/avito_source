package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public final class zzci implements zzcm {
    @GuardedBy("ConfigurationContentLoader.class")
    private static final Map<Uri, zzci> zza = new ArrayMap();
    private static final String[] zzh = {"key", "value"};
    private final ContentResolver zzb;
    private final Uri zzc;
    private final ContentObserver zzd;
    private final Object zze = new Object();
    private volatile Map<String, String> zzf;
    @GuardedBy("this")
    private final List<zzcn> zzg = new ArrayList();

    private zzci(ContentResolver contentResolver, Uri uri) {
        zzck zzck = new zzck(this, null);
        this.zzd = zzck;
        this.zzb = contentResolver;
        this.zzc = uri;
        contentResolver.registerContentObserver(uri, false, zzck);
    }

    public static zzci zza(ContentResolver contentResolver, Uri uri) {
        zzci zzci;
        synchronized (zzci.class) {
            Map<Uri, zzci> map = zza;
            zzci = map.get(uri);
            if (zzci == null) {
                try {
                    zzci zzci2 = new zzci(contentResolver, uri);
                    try {
                        map.put(uri, zzci2);
                    } catch (SecurityException unused) {
                    }
                    zzci = zzci2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzci;
    }

    public static synchronized void zzc() {
        synchronized (zzci.class) {
            for (zzci zzci : zza.values()) {
                zzci.zzb.unregisterContentObserver(zzci.zzd);
            }
            zza.clear();
        }
    }

    /* JADX INFO: finally extract failed */
    private final Map<String, String> zze() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Map<String, String> map = (Map) zzcp.zza(new zzco(this) { // from class: com.google.android.gms.internal.measurement.zzcl
                private final zzci zza;

                {
                    this.zza = r1;
                }

                @Override // com.google.android.gms.internal.measurement.zzco
                public final Object zza() {
                    return this.zza.zzd();
                }
            });
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return map;
        } catch (SQLiteException | IllegalStateException | SecurityException unused) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return null;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
    }

    public final void zzb() {
        synchronized (this.zze) {
            this.zzf = null;
            zzcw.zza();
        }
        synchronized (this) {
            for (zzcn zzcn : this.zzg) {
                zzcn.zza();
            }
        }
    }

    public final /* synthetic */ Map zzd() {
        Map map;
        Cursor query = this.zzb.query(this.zzc, zzh, null, null, null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            if (count <= 256) {
                map = new ArrayMap(count);
            } else {
                map = new HashMap(count, 1.0f);
            }
            while (query.moveToNext()) {
                map.put(query.getString(0), query.getString(1));
            }
            query.close();
            return map;
        } finally {
            query.close();
        }
    }

    public final Map<String, String> zza() {
        Map<String, String> map = this.zzf;
        if (map == null) {
            synchronized (this.zze) {
                map = this.zzf;
                if (map == null) {
                    map = zze();
                    this.zzf = map;
                }
            }
        }
        if (map != null) {
            return map;
        }
        return Collections.emptyMap();
    }

    @Override // com.google.android.gms.internal.measurement.zzcm
    public final /* synthetic */ Object zza(String str) {
        return zza().get(str);
    }
}
