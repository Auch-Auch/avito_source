package com.google.android.gms.internal.vision;

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
public final class zzau implements zzay {
    @GuardedBy("ConfigurationContentLoader.class")
    private static final Map<Uri, zzau> zzfp = new ArrayMap();
    private static final String[] zzfv = {"key", "value"};
    private final Uri uri;
    private final ContentResolver zzfq;
    private final ContentObserver zzfr;
    private final Object zzfs = new Object();
    private volatile Map<String, String> zzft;
    @GuardedBy("this")
    private final List<zzaz> zzfu = new ArrayList();

    private zzau(ContentResolver contentResolver, Uri uri2) {
        zzaw zzaw = new zzaw(this, null);
        this.zzfr = zzaw;
        this.zzfq = contentResolver;
        this.uri = uri2;
        contentResolver.registerContentObserver(uri2, false, zzaw);
    }

    public static zzau zza(ContentResolver contentResolver, Uri uri2) {
        zzau zzau;
        synchronized (zzau.class) {
            Map<Uri, zzau> map = zzfp;
            zzau = map.get(uri2);
            if (zzau == null) {
                try {
                    zzau zzau2 = new zzau(contentResolver, uri2);
                    try {
                        map.put(uri2, zzau2);
                    } catch (SecurityException unused) {
                    }
                    zzau = zzau2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzau;
    }

    private final Map<String, String> zzv() {
        Map<String, String> map = this.zzft;
        if (map == null) {
            synchronized (this.zzfs) {
                map = this.zzft;
                if (map == null) {
                    map = zzx();
                    this.zzft = map;
                }
            }
        }
        if (map != null) {
            return map;
        }
        return Collections.emptyMap();
    }

    /* JADX INFO: finally extract failed */
    private final Map<String, String> zzx() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Map<String, String> map = (Map) zzbb.zza(new zzba(this) { // from class: com.google.android.gms.internal.vision.zzax
                private final zzau zzfy;

                {
                    this.zzfy = r1;
                }

                @Override // com.google.android.gms.internal.vision.zzba
                public final Object zzac() {
                    return this.zzfy.zzz();
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

    public static synchronized void zzy() {
        synchronized (zzau.class) {
            for (zzau zzau : zzfp.values()) {
                zzau.zzfq.unregisterContentObserver(zzau.zzfr);
            }
            zzfp.clear();
        }
    }

    @Override // com.google.android.gms.internal.vision.zzay
    public final /* synthetic */ Object zzb(String str) {
        return zzv().get(str);
    }

    public final void zzw() {
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

    public final /* synthetic */ Map zzz() {
        Map map;
        Cursor query = this.zzfq.query(this.uri, zzfv, null, null, null);
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
}
