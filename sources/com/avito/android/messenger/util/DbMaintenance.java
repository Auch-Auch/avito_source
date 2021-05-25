package com.avito.android.messenger.util;

import com.avito.android.remote.auth.AuthSource;
import java.io.File;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001d\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR$\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00028\u0006@BX\u000e¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00028\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001a\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000f¨\u0006 "}, d2 = {"Lcom/avito/android/messenger/util/DbMaintenance;", "", "", "deleteDb", "", "", "getMetaData", "(Z)Ljava/util/Map;", "e", "Ljava/lang/String;", "headerString", "<set-?>", AuthSource.BOOKING_ORDER, "Z", "getFileExists", "()Z", "fileExists", "c", "getDbFileDeleted", "dbFileDeleted", "Ljava/io/File;", "d", "Ljava/io/File;", "dbFile", AuthSource.SEND_ABUSE, "getDbIsCorrupt", "dbIsCorrupt", "Landroid/content/Context;", "context", "databaseFileName", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
@ExperimentalUnsignedTypes
public final class DbMaintenance {
    public final boolean a;
    public volatile boolean b = true;
    public volatile boolean c;
    public final File d;
    public final String e;

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0057, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        kotlin.io.CloseableKt.closeFinally(r9, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005c, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DbMaintenance(@org.jetbrains.annotations.NotNull android.content.Context r21, @org.jetbrains.annotations.NotNull java.lang.String r22) {
        /*
        // Method dump skipped, instructions count: 294
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.util.DbMaintenance.<init>(android.content.Context, java.lang.String):void");
    }

    public final boolean getDbFileDeleted() {
        return this.c;
    }

    public final boolean getDbIsCorrupt() {
        return this.a;
    }

    public final boolean getFileExists() {
        return this.b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0069, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006a, code lost:
        kotlin.io.CloseableKt.closeFinally(r6, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006d, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0071, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0074, code lost:
        throw r4;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, java.lang.Object> getMetaData(boolean r9) {
        /*
        // Method dump skipped, instructions count: 348
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.util.DbMaintenance.getMetaData(boolean):java.util.Map");
    }
}
