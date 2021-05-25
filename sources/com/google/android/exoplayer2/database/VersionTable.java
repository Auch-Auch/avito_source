package com.google.android.exoplayer2.database;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.exoplayer2.util.Util;
public final class VersionTable {
    public static final int FEATURE_CACHE_CONTENT_METADATA = 1;
    public static final int FEATURE_CACHE_FILE_METADATA = 2;
    public static final int FEATURE_EXTERNAL = 1000;
    public static final int FEATURE_OFFLINE = 0;
    public static final int VERSION_UNSET = -1;

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        if (r10 != null) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0048, code lost:
        r11.addSuppressed(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
        throw r12;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getVersion(android.database.sqlite.SQLiteDatabase r10, int r11, java.lang.String r12) throws com.google.android.exoplayer2.database.DatabaseIOException {
        /*
            java.lang.String r0 = "ExoPlayerVersions"
            boolean r0 = com.google.android.exoplayer2.util.Util.tableExists(r10, r0)     // Catch:{ SQLException -> 0x004c }
            r1 = -1
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            java.lang.String r3 = "ExoPlayerVersions"
            java.lang.String r0 = "version"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch:{ SQLException -> 0x004c }
            java.lang.String r5 = "feature = ? AND instance_uid = ?"
            r0 = 2
            java.lang.String[] r6 = new java.lang.String[r0]     // Catch:{ SQLException -> 0x004c }
            java.lang.String r11 = java.lang.Integer.toString(r11)     // Catch:{ SQLException -> 0x004c }
            r0 = 0
            r6[r0] = r11     // Catch:{ SQLException -> 0x004c }
            r11 = 1
            r6[r11] = r12     // Catch:{ SQLException -> 0x004c }
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r10
            android.database.Cursor r10 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLException -> 0x004c }
            int r11 = r10.getCount()     // Catch:{ all -> 0x003e }
            if (r11 != 0) goto L_0x0033
            r10.close()
            return r1
        L_0x0033:
            r10.moveToNext()
            int r11 = r10.getInt(r0)
            r10.close()
            return r11
        L_0x003e:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x0040 }
        L_0x0040:
            r12 = move-exception
            if (r10 == 0) goto L_0x004b
            r10.close()     // Catch:{ all -> 0x0047 }
            goto L_0x004b
        L_0x0047:
            r10 = move-exception
            r11.addSuppressed(r10)
        L_0x004b:
            throw r12
        L_0x004c:
            r10 = move-exception
            com.google.android.exoplayer2.database.DatabaseIOException r11 = new com.google.android.exoplayer2.database.DatabaseIOException
            r11.<init>(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.database.VersionTable.getVersion(android.database.sqlite.SQLiteDatabase, int, java.lang.String):int");
    }

    public static void removeVersion(SQLiteDatabase sQLiteDatabase, int i, String str) throws DatabaseIOException {
        try {
            if (Util.tableExists(sQLiteDatabase, "ExoPlayerVersions")) {
                sQLiteDatabase.delete("ExoPlayerVersions", "feature = ? AND instance_uid = ?", new String[]{Integer.toString(i), str});
            }
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }

    public static void setVersion(SQLiteDatabase sQLiteDatabase, int i, String str, int i2) throws DatabaseIOException {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ExoPlayerVersions (feature INTEGER NOT NULL,instance_uid TEXT NOT NULL,version INTEGER NOT NULL,PRIMARY KEY (feature, instance_uid))");
            ContentValues contentValues = new ContentValues();
            contentValues.put("feature", Integer.valueOf(i));
            contentValues.put("instance_uid", str);
            contentValues.put("version", Integer.valueOf(i2));
            sQLiteDatabase.replaceOrThrow("ExoPlayerVersions", null, contentValues);
        } catch (SQLException e) {
            throw new DatabaseIOException(e);
        }
    }
}
