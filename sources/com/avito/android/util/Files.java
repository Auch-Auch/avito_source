package com.avito.android.util;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001b\u0010\u0007\u001a\u00020\u0006*\u0004\u0018\u00010\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\t\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\t\u0010\u0003\u001a\u0013\u0010\u000b\u001a\u00020\n*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Ljava/io/File;", "", "createOrClear", "(Ljava/io/File;)V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "contains", "(Ljava/io/File;Landroid/net/Uri;)Z", "ensureDirectoryExists", "", "size", "(Ljava/io/File;)J", "", "name", "get", "(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;", "android_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Files")
public final class Files {
    public static final boolean contains(@Nullable File file, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        if (file != null) {
            String path = uri.getPath();
            Intrinsics.checkNotNull(path);
            Intrinsics.checkNotNullExpressionValue(path, "uri.path!!");
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "this.absolutePath");
            if (m.startsWith(path, absolutePath, true)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        r1 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void createOrClear(@org.jetbrains.annotations.NotNull java.io.File r2) {
        /*
            java.lang.String r0 = "$this$createOrClear"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            boolean r0 = r2.exists()
            if (r0 == 0) goto L_0x002a
            java.nio.charset.Charset r0 = kotlin.text.Charsets.UTF_8
            java.io.FileOutputStream r1 = new java.io.FileOutputStream
            r1.<init>(r2)
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter
            r2.<init>(r1, r0)
            r0 = 0
            java.lang.String r1 = ""
            r2.write(r1)     // Catch:{ all -> 0x0023 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0023 }
            kotlin.io.CloseableKt.closeFinally(r2, r0)
            goto L_0x0034
        L_0x0023:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0025 }
        L_0x0025:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r0)
            throw r1
        L_0x002a:
            java.io.File r0 = r2.getParentFile()
            r0.mkdirs()
            r2.createNewFile()
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.Files.createOrClear(java.io.File):void");
    }

    public static final void ensureDirectoryExists(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "$this$ensureDirectoryExists");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    @Nullable
    public static final File get(@NotNull File file, @NotNull String str) {
        Intrinsics.checkNotNullParameter(file, "$this$get");
        Intrinsics.checkNotNullParameter(str, "name");
        File[] listFiles = file.listFiles();
        Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
        for (File file2 : listFiles) {
            Intrinsics.checkNotNullExpressionValue(file2, "it");
            if (Intrinsics.areEqual(file2.getName(), str)) {
                return file2;
            }
        }
        return null;
    }

    public static final long size(@Nullable File file) {
        long j = 0;
        if (file == null) {
            return 0;
        }
        try {
            if (!file.exists() || !file.canRead()) {
                return 0;
            }
            if (file.isFile()) {
                return 0 + file.length();
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return 0;
            }
            for (File file2 : listFiles) {
                j += size(file2);
            }
            return j;
        } catch (Throwable unused) {
            return 0;
        }
    }
}
