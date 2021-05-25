package com.google.android.exoplayer2.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public final class ExoDatabaseProvider extends SQLiteOpenHelper implements DatabaseProvider {
    public static final String DATABASE_NAME = "exoplayer_internal.db";

    public ExoDatabaseProvider(Context context) {
        super(context.getApplicationContext(), DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0067, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0068, code lost:
        if (r10 != null) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006e, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006f, code lost:
        r9.addSuppressed(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0072, code lost:
        throw r11;
     */
    @Override // android.database.sqlite.SQLiteOpenHelper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDowngrade(android.database.sqlite.SQLiteDatabase r9, int r10, int r11) {
        /*
            r8 = this;
            java.lang.String r10 = "type"
            java.lang.String r11 = "name"
            java.lang.String[] r2 = new java.lang.String[]{r10, r11}
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.String r1 = "sqlite_master"
            r0 = r9
            android.database.Cursor r10 = r0.query(r1, r2, r3, r4, r5, r6, r7)
        L_0x0014:
            boolean r11 = r10.moveToNext()     // Catch:{ all -> 0x0065 }
            if (r11 == 0) goto L_0x0061
            r11 = 0
            java.lang.String r11 = r10.getString(r11)     // Catch:{ all -> 0x0065 }
            r0 = 1
            java.lang.String r0 = r10.getString(r0)     // Catch:{ all -> 0x0065 }
            java.lang.String r1 = "sqlite_sequence"
            boolean r1 = r1.equals(r0)     // Catch:{ all -> 0x0065 }
            if (r1 != 0) goto L_0x0014
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
            r1.<init>()     // Catch:{ all -> 0x0065 }
            java.lang.String r2 = "DROP "
            r1.append(r2)     // Catch:{ all -> 0x0065 }
            r1.append(r11)     // Catch:{ all -> 0x0065 }
            java.lang.String r11 = " IF EXISTS "
            r1.append(r11)     // Catch:{ all -> 0x0065 }
            r1.append(r0)     // Catch:{ all -> 0x0065 }
            java.lang.String r11 = r1.toString()     // Catch:{ all -> 0x0065 }
            r9.execSQL(r11)     // Catch:{ SQLException -> 0x0049 }
            goto L_0x0014
        L_0x0049:
            r0 = move-exception
            java.lang.String r1 = "ExoDatabaseProvider"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error executing "
            r2.append(r3)
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            com.google.android.exoplayer2.util.Log.e(r1, r11, r0)
            goto L_0x0014
        L_0x0061:
            r10.close()
            return
        L_0x0065:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0067 }
        L_0x0067:
            r11 = move-exception
            if (r10 == 0) goto L_0x0072
            r10.close()     // Catch:{ all -> 0x006e }
            goto L_0x0072
        L_0x006e:
            r10 = move-exception
            r9.addSuppressed(r10)
        L_0x0072:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.database.ExoDatabaseProvider.onDowngrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
