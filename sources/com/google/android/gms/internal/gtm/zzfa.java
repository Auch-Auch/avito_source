package com.google.android.gms.internal.gtm;

import a2.b.a.a.a;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import ru.avito.messenger.internal.ConstantsKt;
@VisibleForTesting
public final class zzfa extends SQLiteOpenHelper {
    private boolean zzail;
    private long zzaim = 0;
    private final /* synthetic */ zzey zzaom;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfa(zzey zzey, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.zzaom = zzey;
    }

    private static boolean zza(String str, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
            boolean moveToFirst = cursor.moveToFirst();
            cursor.close();
            return moveToFirst;
        } catch (SQLiteException unused) {
            if (cursor != null) {
                cursor.close();
            }
            return false;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        if (!this.zzail || this.zzaim + ConstantsKt.DEFAULT_TIME_TO_MODIFY_MESSAGE_MS <= zzey.zza(this.zzaom).currentTimeMillis()) {
            SQLiteDatabase sQLiteDatabase = null;
            this.zzail = true;
            this.zzaim = zzey.zza(this.zzaom).currentTimeMillis();
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException unused) {
                zzey.zzc(this.zzaom).getDatabasePath(zzey.zzb(this.zzaom)).delete();
            }
            if (sQLiteDatabase == null) {
                sQLiteDatabase = super.getWritableDatabase();
            }
            this.zzail = false;
            return sQLiteDatabase;
        }
        throw new SQLiteException("Database creation failed");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        String path = sQLiteDatabase.getPath();
        if (zzeg.version() >= 9) {
            File file = new File(path);
            file.setReadable(false, false);
            file.setWritable(false, false);
            file.setReadable(true, true);
            file.setWritable(true, true);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (!zza("gtm_hit_unique_ids", sQLiteDatabase)) {
            sQLiteDatabase.execSQL(zzey.zzix());
        } else {
            zza(sQLiteDatabase, "gtm_hit_unique_ids", Arrays.asList("hit_unique_id"));
        }
        if (!zza("gtm_hits", sQLiteDatabase)) {
            sQLiteDatabase.execSQL(zzey.zzkn());
        } else {
            zza(sQLiteDatabase, "gtm_hits", Arrays.asList("hit_id", "hit_url", "hit_time", "hit_first_send_time", "hit_method", "hit_unique_id", "hit_headers", "hit_body"));
        }
        sQLiteDatabase.execSQL(zzey.zzko());
        sQLiteDatabase.execSQL(zzey.zzkp());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    /* JADX INFO: finally extract failed */
    private static void zza(SQLiteDatabase sQLiteDatabase, String str, List<String> list) {
        String[] columnNames;
        Cursor rawQuery = sQLiteDatabase.rawQuery(a.s2(a.q0(str, 22), "SELECT * FROM ", str, " WHERE 0"), null);
        HashSet hashSet = new HashSet();
        try {
            for (String str2 : rawQuery.getColumnNames()) {
                hashSet.add(str2);
            }
            rawQuery.close();
            for (String str3 : list) {
                if (!hashSet.remove(str3)) {
                    throw new SQLiteException(String.format("Database column %s missing in table %s.", str3, str));
                }
            }
            if (!hashSet.isEmpty()) {
                throw new SQLiteException(String.format("Database has extra columns in table %s.", str));
            }
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }
}
