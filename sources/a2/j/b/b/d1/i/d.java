package a2.j.b.b.d1.i;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.WorkerThread;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.database.VersionTable;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Iterator;
import java.util.Set;
public final class d {
    public static final String[] c = {"name", "length", "last_touch_timestamp"};
    public final DatabaseProvider a;
    public String b;

    public d(DatabaseProvider databaseProvider) {
        this.a = databaseProvider;
    }

    @WorkerThread
    public static void a(DatabaseProvider databaseProvider, long j) throws DatabaseIOException {
        String hexString = Long.toHexString(j);
        try {
            String str = "ExoPlayerCacheFileMetadata" + hexString;
            SQLiteDatabase writableDatabase = databaseProvider.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                VersionTable.removeVersion(writableDatabase, 2, hexString);
                writableDatabase.execSQL("DROP TABLE IF EXISTS " + str);
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0045, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        if (r0 != null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
        throw r2;
     */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.String, a2.j.b.b.d1.i.c> b() throws com.google.android.exoplayer2.database.DatabaseIOException {
        /*
            r9 = this;
            java.lang.String r0 = r9.b     // Catch:{ SQLException -> 0x0051 }
            com.google.android.exoplayer2.util.Assertions.checkNotNull(r0)     // Catch:{ SQLException -> 0x0051 }
            com.google.android.exoplayer2.database.DatabaseProvider r0 = r9.a     // Catch:{ SQLException -> 0x0051 }
            android.database.sqlite.SQLiteDatabase r1 = r0.getReadableDatabase()     // Catch:{ SQLException -> 0x0051 }
            java.lang.String r2 = r9.b     // Catch:{ SQLException -> 0x0051 }
            java.lang.String[] r3 = a2.j.b.b.d1.i.d.c     // Catch:{ SQLException -> 0x0051 }
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLException -> 0x0051 }
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x0043 }
            int r2 = r0.getCount()     // Catch:{ all -> 0x0043 }
            r1.<init>(r2)     // Catch:{ all -> 0x0043 }
        L_0x0021:
            boolean r2 = r0.moveToNext()     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x003f
            r2 = 0
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x0043 }
            r3 = 1
            long r3 = r0.getLong(r3)     // Catch:{ all -> 0x0043 }
            r5 = 2
            long r5 = r0.getLong(r5)     // Catch:{ all -> 0x0043 }
            a2.j.b.b.d1.i.c r7 = new a2.j.b.b.d1.i.c     // Catch:{ all -> 0x0043 }
            r7.<init>(r3, r5)     // Catch:{ all -> 0x0043 }
            r1.put(r2, r7)     // Catch:{ all -> 0x0043 }
            goto L_0x0021
        L_0x003f:
            r0.close()
            return r1
        L_0x0043:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0045 }
        L_0x0045:
            r2 = move-exception
            if (r0 == 0) goto L_0x0050
            r0.close()     // Catch:{ all -> 0x004c }
            goto L_0x0050
        L_0x004c:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x0050:
            throw r2
        L_0x0051:
            r0 = move-exception
            com.google.android.exoplayer2.database.DatabaseIOException r1 = new com.google.android.exoplayer2.database.DatabaseIOException
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.b.b.d1.i.d.b():java.util.Map");
    }

    @WorkerThread
    public void c(long j) throws DatabaseIOException {
        try {
            String hexString = Long.toHexString(j);
            this.b = "ExoPlayerCacheFileMetadata" + hexString;
            if (VersionTable.getVersion(this.a.getReadableDatabase(), 2, hexString) != 1) {
                SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    VersionTable.setVersion(writableDatabase, 2, hexString, 1);
                    String str = this.b;
                    writableDatabase.execSQL("DROP TABLE IF EXISTS " + str);
                    writableDatabase.execSQL("CREATE TABLE " + this.b + " (name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)");
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    @WorkerThread
    public void d(Set<String> set) throws DatabaseIOException {
        Assertions.checkNotNull(this.b);
        try {
            SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    writableDatabase.delete(this.b, "name = ?", new String[]{it.next()});
                }
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    @WorkerThread
    public void e(String str, long j, long j2) throws DatabaseIOException {
        Assertions.checkNotNull(this.b);
        try {
            SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str);
            contentValues.put("length", Long.valueOf(j));
            contentValues.put("last_touch_timestamp", Long.valueOf(j2));
            writableDatabase.replaceOrThrow(this.b, null, contentValues);
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }
}
