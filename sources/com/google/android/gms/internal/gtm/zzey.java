package com.google.android.gms.internal.gtm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
@VisibleForTesting
public final class zzey implements zzem {
    private static final String zzaog = String.format("CREATE TABLE IF NOT EXISTS %s ('%s' TEXT UNIQUE);", "gtm_hit_unique_ids", "hit_unique_id");
    private static final String zzaoh = String.format("CREATE TRIGGER IF NOT EXISTS %s DELETE ON %s FOR EACH ROW WHEN OLD.%s NOTNULL BEGIN     INSERT OR IGNORE INTO %s (%s) VALUES (OLD.%s); END;", "save_unique_on_delete", "gtm_hits", "hit_unique_id", "gtm_hit_unique_ids", "hit_unique_id", "hit_unique_id");
    private static final String zzaoi = String.format("CREATE TRIGGER IF NOT EXISTS %s BEFORE INSERT ON %s FOR EACH ROW WHEN NEW.%s NOT NULL BEGIN     SELECT RAISE(ABORT, 'Duplicate unique ID.')     WHERE EXISTS (SELECT 1 FROM %s WHERE %s = NEW.%s); END;", "check_unique_on_insert", "gtm_hits", "hit_unique_id", "gtm_hit_unique_ids", "hit_unique_id", "hit_unique_id");
    private static final String zzxj = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT UNIQUE, '%s' TEXT, '%s' TEXT);", "gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time", "hit_method", "hit_unique_id", "hit_headers", "hit_body");
    private final String zzaih;
    private long zzaii;
    private final int zzaij;
    private final zzfa zzaoj;
    private volatile zzed zzaok;
    private final zzen zzaol;
    private final Context zzrm;
    private Clock zzsd;

    public zzey(zzen zzen, Context context) {
        this(zzen, context, "gtm_urls.db", 2000);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01f1, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01ba, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01bb, code lost:
        r14 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01c0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01db, code lost:
        r0 = "Error in peekHits fetching hitIds: ".concat(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01e0, code lost:
        r0 = new java.lang.String("Error in peekHits fetching hitIds: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01ea, code lost:
        r14.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0178 A[Catch:{ all -> 0x01b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x017d A[Catch:{ all -> 0x01b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0191 A[Catch:{ all -> 0x01b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01ba A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01db A[Catch:{ all -> 0x01ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01e0 A[Catch:{ all -> 0x01ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01ea  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<com.google.android.gms.internal.gtm.zzeh> zzaa(int r25) {
        /*
        // Method dump skipped, instructions count: 501
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzey.zzaa(int):java.util.List");
    }

    private final SQLiteDatabase zzau(String str) {
        try {
            return this.zzaoj.getWritableDatabase();
        } catch (SQLiteException e) {
            Context context = this.zzrm;
            zzev.zzb(str, e);
            if (CrashUtils.addDynamiteErrorToDropBox(context, e)) {
                zzev.zzab("Crash reported successfully.");
                return null;
            }
            zzev.zzab("Failed to report crash");
            return null;
        }
    }

    /* access modifiers changed from: public */
    private final void zzb(long j, long j2) {
        SQLiteDatabase zzau = zzau("Error opening database for getNumStoredHits.");
        if (zzau != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_first_send_time", Long.valueOf(j2));
            try {
                zzau.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
            } catch (SQLiteException e) {
                String message = e.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 70);
                sb.append("Error setting HIT_FIRST_DISPATCH_TIME for hitId ");
                sb.append(j);
                sb.append(": ");
                sb.append(message);
                zzev.zzac(sb.toString());
                zze(j);
            }
        }
    }

    private final int zzbv(String str) {
        SQLiteDatabase zzau = zzau("Error opening database for getNumRecords.");
        int i = 0;
        if (zzau == null) {
            return 0;
        }
        Cursor cursor = null;
        try {
            String valueOf = String.valueOf(str);
            Cursor rawQuery = zzau.rawQuery(valueOf.length() != 0 ? "SELECT COUNT(*) from ".concat(valueOf) : new String("SELECT COUNT(*) from "), null);
            if (rawQuery.moveToFirst()) {
                i = (int) rawQuery.getLong(0);
            }
            rawQuery.close();
        } catch (SQLiteException e) {
            String valueOf2 = String.valueOf(e.getMessage());
            zzev.zzac(valueOf2.length() != 0 ? "Error getting numStoredRecords: ".concat(valueOf2) : new String("Error getting numStoredRecords: "));
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
        return i;
    }

    /* access modifiers changed from: public */
    private final void zze(long j) {
        zza(new String[]{String.valueOf(j)});
    }

    private final int zziw() {
        SQLiteDatabase zzau = zzau("Error opening database for getNumStoredHits.");
        int i = 0;
        if (zzau == null) {
            return 0;
        }
        Cursor cursor = null;
        try {
            cursor = zzau.query("gtm_hits", new String[]{"hit_id", "hit_first_send_time"}, "hit_first_send_time=0", null, null, null, null);
            i = cursor.getCount();
            cursor.close();
        } catch (SQLiteException e) {
            String valueOf = String.valueOf(e.getMessage());
            zzev.zzac(valueOf.length() != 0 ? "Error getting num untried hits: ".concat(valueOf) : new String("Error getting num untried hits: "));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return i;
    }

    private final List<String> zzz(int i) {
        ArrayList arrayList = new ArrayList();
        if (i <= 0) {
            zzev.zzac("Invalid maxHits specified. Skipping");
            return arrayList;
        }
        SQLiteDatabase zzau = zzau("Error opening database for peekHitIds.");
        if (zzau == null) {
            return arrayList;
        }
        Cursor cursor = null;
        try {
            Cursor query = zzau.query("gtm_hits", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", "hit_id"), Integer.toString(i));
            if (query.moveToFirst()) {
                do {
                    arrayList.add(String.valueOf(query.getLong(0)));
                } while (query.moveToNext());
            }
            query.close();
        } catch (SQLiteException e) {
            String valueOf = String.valueOf(e.getMessage());
            zzev.zzac(valueOf.length() != 0 ? "Error in peekHits fetching hitIds: ".concat(valueOf) : new String("Error in peekHits fetching hitIds: "));
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.gtm.zzem
    public final void dispatch() {
        zzev.zzab("GTM Dispatch running...");
        if (this.zzaok.zzhy()) {
            List<zzeh> zzaa = zzaa(40);
            if (zzaa.isEmpty()) {
                zzev.zzab("...nothing to dispatch");
                this.zzaol.zze(true);
                return;
            }
            this.zzaok.zzd(zzaa);
            if (zziw() > 0) {
                zzfo.zzkv().dispatch();
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzem
    public final void zza(long j, String str, @Nullable String str2, @Nullable String str3, @Nullable Map<String, String> map, @Nullable String str4) {
        String str5;
        long currentTimeMillis = this.zzsd.currentTimeMillis();
        if (currentTimeMillis > this.zzaii + 86400000) {
            this.zzaii = currentTimeMillis;
            SQLiteDatabase zzau = zzau("Error opening database for deleteStaleHits.");
            if (zzau != null) {
                int delete = zzau.delete("gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(this.zzsd.currentTimeMillis() - 2592000000L)});
                StringBuilder sb = new StringBuilder(31);
                sb.append("Removed ");
                sb.append(delete);
                sb.append(" stale hits.");
                zzev.zzab(sb.toString());
                this.zzaol.zze(zzbv("gtm_hits") == 0);
            }
        }
        int zzbv = (zzbv("gtm_hits") - this.zzaij) + 1;
        if (zzbv > 0) {
            List<String> zzz = zzz(zzbv);
            int size = zzz.size();
            StringBuilder sb2 = new StringBuilder(51);
            sb2.append("Store full, deleting ");
            sb2.append(size);
            sb2.append(" hits to make room.");
            zzev.zzab(sb2.toString());
            zza((String[]) zzz.toArray(new String[0]));
        }
        SQLiteDatabase zzau2 = zzau("Error opening database for putHit");
        if (zzau2 != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_time", Long.valueOf(j));
            contentValues.put("hit_url", str);
            contentValues.put("hit_first_send_time", (Integer) 0);
            contentValues.put("hit_method", str2 == null ? ShareTarget.METHOD_GET : str2);
            contentValues.put("hit_unique_id", str3);
            if (map == null) {
                str5 = null;
            } else {
                str5 = new JSONObject(map).toString();
            }
            contentValues.put("hit_headers", str5);
            contentValues.put("hit_body", str4);
            try {
                zzau2.insertOrThrow("gtm_hits", null, contentValues);
                StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 19);
                sb3.append("Hit stored (url = ");
                sb3.append(str);
                sb3.append(")");
                zzev.zzab(sb3.toString());
                this.zzaol.zze(false);
            } catch (SQLiteConstraintException unused) {
                String valueOf = String.valueOf(str);
                zzev.zzab(valueOf.length() != 0 ? "Hit has already been sent: ".concat(valueOf) : new String("Hit has already been sent: "));
            } catch (SQLiteException e) {
                String valueOf2 = String.valueOf(e.getMessage());
                zzev.zzac(valueOf2.length() != 0 ? "Error storing hit: ".concat(valueOf2) : new String("Error storing hit: "));
            }
        }
        if (zzfd.zzkr().isPreview()) {
            zzev.zzab("Sending hits immediately under preview.");
            dispatch();
        }
    }

    @VisibleForTesting
    private zzey(zzen zzen, Context context, String str, int i) {
        Context applicationContext = context.getApplicationContext();
        this.zzrm = applicationContext;
        this.zzaih = str;
        this.zzaol = zzen;
        this.zzsd = DefaultClock.getInstance();
        this.zzaoj = new zzfa(this, applicationContext, str);
        this.zzaok = new zzfu(applicationContext, new zzez(this));
        this.zzaii = 0;
        this.zzaij = 2000;
    }

    private final void zza(String[] strArr) {
        SQLiteDatabase zzau;
        if (strArr != null && strArr.length != 0 && (zzau = zzau("Error opening database for deleteHits.")) != null) {
            boolean z = true;
            try {
                zzau.delete("gtm_hits", String.format("HIT_ID in (%s)", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))), strArr);
                zzen zzen = this.zzaol;
                if (zzbv("gtm_hits") != 0) {
                    z = false;
                }
                zzen.zze(z);
            } catch (SQLiteException e) {
                String valueOf = String.valueOf(e.getMessage());
                zzev.zzac(valueOf.length() != 0 ? "Error deleting hits: ".concat(valueOf) : new String("Error deleting hits: "));
            }
        }
    }

    public static /* synthetic */ Clock zza(zzey zzey) {
        return zzey.zzsd;
    }
}
