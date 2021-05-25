package com.google.android.exoplayer2.offline;

import a2.j.b.b.x0.p;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.database.VersionTable;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;
public final class DefaultDownloadIndex implements WritableDownloadIndex {
    public static final String e = g(3, 4);
    public static final String[] f = {"id", "mime_type", ShareConstants.MEDIA_URI, "stream_keys", "custom_cache_key", "data", "state", "start_time_ms", "update_time_ms", "content_length", DownloadService.KEY_STOP_REASON, "failure_reason", "percent_downloaded", "bytes_downloaded", "key_set_id"};
    public final String a;
    public final String b;
    public final DatabaseProvider c;
    public boolean d;

    public static final class b implements DownloadCursor {
        public final Cursor a;

        public b(Cursor cursor, a aVar) {
            this.a = cursor;
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.a.close();
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public int getCount() {
            return this.a.getCount();
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public Download getDownload() {
            return DefaultDownloadIndex.e(this.a);
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public int getPosition() {
            return this.a.getPosition();
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public /* synthetic */ boolean isAfterLast() {
            return p.$default$isAfterLast(this);
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public /* synthetic */ boolean isBeforeFirst() {
            return p.$default$isBeforeFirst(this);
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public boolean isClosed() {
            return this.a.isClosed();
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public /* synthetic */ boolean isFirst() {
            return p.$default$isFirst(this);
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public /* synthetic */ boolean isLast() {
            return p.$default$isLast(this);
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public /* synthetic */ boolean moveToFirst() {
            return p.$default$moveToFirst(this);
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public /* synthetic */ boolean moveToLast() {
            return p.$default$moveToLast(this);
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public /* synthetic */ boolean moveToNext() {
            return p.$default$moveToNext(this);
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public boolean moveToPosition(int i) {
            return this.a.moveToPosition(i);
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public /* synthetic */ boolean moveToPrevious() {
            return p.$default$moveToPrevious(this);
        }
    }

    public DefaultDownloadIndex(DatabaseProvider databaseProvider) {
        this(databaseProvider, "");
    }

    public static /* synthetic */ void a(Throwable th, AutoCloseable autoCloseable) {
        if (th != null) {
            try {
                autoCloseable.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            autoCloseable.close();
        }
    }

    public static List<StreamKey> b(String str) {
        ArrayList arrayList = new ArrayList();
        if (str.isEmpty()) {
            return arrayList;
        }
        for (String str2 : Util.split(str, ",")) {
            String[] split = Util.split(str2, "\\.");
            Assertions.checkState(split.length == 3);
            arrayList.add(new StreamKey(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])));
        }
        return arrayList;
    }

    public static Download e(Cursor cursor) {
        byte[] blob = cursor.getBlob(14);
        DownloadRequest.Builder streamKeys = new DownloadRequest.Builder(cursor.getString(0), Uri.parse(cursor.getString(2))).setMimeType(cursor.getString(1)).setStreamKeys(b(cursor.getString(3)));
        if (blob.length <= 0) {
            blob = null;
        }
        DownloadRequest build = streamKeys.setKeySetId(blob).setCustomCacheKey(cursor.getString(4)).setData(cursor.getBlob(5)).build();
        DownloadProgress downloadProgress = new DownloadProgress();
        downloadProgress.bytesDownloaded = cursor.getLong(13);
        downloadProgress.percentDownloaded = cursor.getFloat(12);
        int i = cursor.getInt(6);
        return new Download(build, i, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i == 4 ? cursor.getInt(11) : 0, downloadProgress);
    }

    public static Download f(Cursor cursor) {
        String str;
        DownloadRequest.Builder builder = new DownloadRequest.Builder(cursor.getString(0), Uri.parse(cursor.getString(2)));
        String string = cursor.getString(1);
        if ("dash".equals(string)) {
            str = MimeTypes.APPLICATION_MPD;
        } else if ("hls".equals(string)) {
            str = MimeTypes.APPLICATION_M3U8;
        } else {
            str = AuthSource.OPEN_SEARCH_SUBSCRIPTIONS.equals(string) ? MimeTypes.APPLICATION_SS : MimeTypes.VIDEO_UNKNOWN;
        }
        DownloadRequest build = builder.setMimeType(str).setStreamKeys(b(cursor.getString(3))).setCustomCacheKey(cursor.getString(4)).setData(cursor.getBlob(5)).build();
        DownloadProgress downloadProgress = new DownloadProgress();
        downloadProgress.bytesDownloaded = cursor.getLong(13);
        downloadProgress.percentDownloaded = cursor.getFloat(12);
        int i = cursor.getInt(6);
        return new Download(build, i, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i == 4 ? cursor.getInt(11) : 0, downloadProgress);
    }

    public static String g(int... iArr) {
        if (iArr.length == 0) {
            return "1";
        }
        StringBuilder Q = a2.b.a.a.a.Q("state", " IN (");
        for (int i = 0; i < iArr.length; i++) {
            if (i > 0) {
                Q.append(',');
            }
            Q.append(iArr[i]);
        }
        Q.append(')');
        return Q.toString();
    }

    public final void c() throws DatabaseIOException {
        if (!this.d) {
            try {
                int version = VersionTable.getVersion(this.c.getReadableDatabase(), 0, this.a);
                if (version != 3) {
                    SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        VersionTable.setVersion(writableDatabase, 0, this.a, 3);
                        List<Download> h = version == 2 ? h(writableDatabase) : new ArrayList<>();
                        writableDatabase.execSQL("DROP TABLE IF EXISTS " + this.b);
                        writableDatabase.execSQL("CREATE TABLE " + this.b + " (id TEXT PRIMARY KEY NOT NULL,mime_type TEXT,uri TEXT NOT NULL,stream_keys TEXT NOT NULL,custom_cache_key TEXT,data BLOB NOT NULL,state INTEGER NOT NULL,start_time_ms INTEGER NOT NULL,update_time_ms INTEGER NOT NULL,content_length INTEGER NOT NULL,stop_reason INTEGER NOT NULL,failure_reason INTEGER NOT NULL,percent_downloaded REAL NOT NULL,bytes_downloaded INTEGER NOT NULL,key_set_id BLOB NOT NULL)");
                        for (Download download : h) {
                            i(download, writableDatabase);
                        }
                        writableDatabase.setTransactionSuccessful();
                    } finally {
                        writableDatabase.endTransaction();
                    }
                }
                this.d = true;
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            }
        }
    }

    public final Cursor d(String str, @Nullable String[] strArr) throws DatabaseIOException {
        try {
            return this.c.getReadableDatabase().query(this.b, f, str, strArr, null, null, "start_time_ms ASC");
        } catch (SQLiteException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
        if (r4 != null) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
        a(r0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
        throw r1;
     */
    @Override // com.google.android.exoplayer2.offline.DownloadIndex
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.offline.Download getDownload(java.lang.String r4) throws com.google.android.exoplayer2.database.DatabaseIOException {
        /*
            r3 = this;
            r3.c()
            java.lang.String r0 = "id = ?"
            r1 = 1
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch:{ SQLiteException -> 0x002e }
            r2 = 0
            r1[r2] = r4     // Catch:{ SQLiteException -> 0x002e }
            android.database.Cursor r4 = r3.d(r0, r1)     // Catch:{ SQLiteException -> 0x002e }
            int r0 = r4.getCount()     // Catch:{ all -> 0x0025 }
            r1 = 0
            if (r0 != 0) goto L_0x001a
            a(r1, r4)
            return r1
        L_0x001a:
            r4.moveToNext()
            com.google.android.exoplayer2.offline.Download r0 = e(r4)
            a(r1, r4)
            return r0
        L_0x0025:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0027 }
        L_0x0027:
            r1 = move-exception
            if (r4 == 0) goto L_0x002d
            a(r0, r4)
        L_0x002d:
            throw r1
        L_0x002e:
            r4 = move-exception
            com.google.android.exoplayer2.database.DatabaseIOException r0 = new com.google.android.exoplayer2.database.DatabaseIOException
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.offline.DefaultDownloadIndex.getDownload(java.lang.String):com.google.android.exoplayer2.offline.Download");
    }

    @Override // com.google.android.exoplayer2.offline.DownloadIndex
    public DownloadCursor getDownloads(int... iArr) throws DatabaseIOException {
        c();
        return new b(d(g(iArr), null), null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0055, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0057, code lost:
        if (r2 != null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0059, code lost:
        a(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005c, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.exoplayer2.offline.Download> h(android.database.sqlite.SQLiteDatabase r19) {
        /*
            r18 = this;
            r1 = r18
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r2 = r1.b
            r3 = r19
            boolean r2 = com.google.android.exoplayer2.util.Util.tableExists(r3, r2)
            if (r2 != 0) goto L_0x0012
            return r0
        L_0x0012:
            java.lang.String r4 = "id"
            java.lang.String r5 = "title"
            java.lang.String r6 = "uri"
            java.lang.String r7 = "stream_keys"
            java.lang.String r8 = "custom_cache_key"
            java.lang.String r9 = "data"
            java.lang.String r10 = "state"
            java.lang.String r11 = "start_time_ms"
            java.lang.String r12 = "update_time_ms"
            java.lang.String r13 = "content_length"
            java.lang.String r14 = "stop_reason"
            java.lang.String r15 = "failure_reason"
            java.lang.String r16 = "percent_downloaded"
            java.lang.String r17 = "bytes_downloaded"
            java.lang.String[] r5 = new java.lang.String[]{r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17}
            java.lang.String r4 = r1.b
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r3 = r19
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10)
            r3 = 0
        L_0x0040:
            boolean r4 = r2.moveToNext()     // Catch:{ all -> 0x0052 }
            if (r4 == 0) goto L_0x004e
            com.google.android.exoplayer2.offline.Download r4 = f(r2)     // Catch:{ all -> 0x0052 }
            r0.add(r4)     // Catch:{ all -> 0x0052 }
            goto L_0x0040
        L_0x004e:
            a(r3, r2)
            return r0
        L_0x0052:
            r0 = move-exception
            r3 = r0
            throw r3     // Catch:{ all -> 0x0055 }
        L_0x0055:
            r0 = move-exception
            r4 = r0
            if (r2 == 0) goto L_0x005c
            a(r3, r2)
        L_0x005c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.offline.DefaultDownloadIndex.h(android.database.sqlite.SQLiteDatabase):java.util.List");
    }

    public final void i(Download download, SQLiteDatabase sQLiteDatabase) {
        byte[] bArr = download.request.keySetId;
        if (bArr == null) {
            bArr = Util.EMPTY_BYTE_ARRAY;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", download.request.id);
        contentValues.put("mime_type", download.request.mimeType);
        contentValues.put(ShareConstants.MEDIA_URI, download.request.uri.toString());
        List<StreamKey> list = download.request.streamKeys;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            StreamKey streamKey = list.get(i);
            sb.append(streamKey.periodIndex);
            sb.append(FormatterType.defaultDecimalSeparator);
            sb.append(streamKey.groupIndex);
            sb.append(FormatterType.defaultDecimalSeparator);
            sb.append(streamKey.trackIndex);
            sb.append(',');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        contentValues.put("stream_keys", sb.toString());
        contentValues.put("custom_cache_key", download.request.customCacheKey);
        contentValues.put("data", download.request.data);
        contentValues.put("state", Integer.valueOf(download.state));
        contentValues.put("start_time_ms", Long.valueOf(download.startTimeMs));
        contentValues.put("update_time_ms", Long.valueOf(download.updateTimeMs));
        contentValues.put("content_length", Long.valueOf(download.contentLength));
        contentValues.put(DownloadService.KEY_STOP_REASON, Integer.valueOf(download.stopReason));
        contentValues.put("failure_reason", Integer.valueOf(download.failureReason));
        contentValues.put("percent_downloaded", Float.valueOf(download.getPercentDownloaded()));
        contentValues.put("bytes_downloaded", Long.valueOf(download.getBytesDownloaded()));
        contentValues.put("key_set_id", bArr);
        sQLiteDatabase.replaceOrThrow(this.b, null, contentValues);
    }

    @Override // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void putDownload(Download download) throws DatabaseIOException {
        c();
        try {
            i(download, this.c.getWritableDatabase());
        } catch (SQLiteException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void removeDownload(String str) throws DatabaseIOException {
        c();
        try {
            this.c.getWritableDatabase().delete(this.b, "id = ?", new String[]{str});
        } catch (SQLiteException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void setDownloadingStatesToQueued() throws DatabaseIOException {
        c();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", (Integer) 0);
            this.c.getWritableDatabase().update(this.b, contentValues, "state = 2", null);
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void setStatesToRemoving() throws DatabaseIOException {
        c();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", (Integer) 5);
            contentValues.put("failure_reason", (Integer) 0);
            this.c.getWritableDatabase().update(this.b, contentValues, null, null);
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void setStopReason(int i) throws DatabaseIOException {
        c();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DownloadService.KEY_STOP_REASON, Integer.valueOf(i));
            this.c.getWritableDatabase().update(this.b, contentValues, e, null);
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    public DefaultDownloadIndex(DatabaseProvider databaseProvider, String str) {
        this.a = str;
        this.c = databaseProvider;
        this.b = a2.b.a.a.a.c3("ExoPlayerDownloads", str);
    }

    @Override // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void setStopReason(String str, int i) throws DatabaseIOException {
        c();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DownloadService.KEY_STOP_REASON, Integer.valueOf(i));
            SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
            String str2 = this.b;
            writableDatabase.update(str2, contentValues, e + " AND id = ?", new String[]{str});
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }
}
