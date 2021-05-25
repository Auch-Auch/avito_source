package com.avito.android.util;

import android.content.ContentResolver;
import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a!\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a!\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroid/content/ContentResolver;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Ljava/io/File;", "file", "", "safeWriteUriContentToFile", "(Landroid/content/ContentResolver;Landroid/net/Uri;Ljava/io/File;)Z", "", "writeUriContentToFile", "(Landroid/content/ContentResolver;Landroid/net/Uri;Ljava/io/File;)V", "photo-picker_release"}, k = 2, mv = {1, 4, 2})
public final class ContentResolverUtilsKt {
    public static final boolean safeWriteUriContentToFile(@NotNull ContentResolver contentResolver, @NotNull Uri uri, @NotNull File file) {
        Intrinsics.checkNotNullParameter(contentResolver, "$this$safeWriteUriContentToFile");
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intrinsics.checkNotNullParameter(file, "file");
        try {
            writeUriContentToFile(contentResolver, uri, file);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003d, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003e, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0041, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void writeUriContentToFile(@org.jetbrains.annotations.NotNull android.content.ContentResolver r2, @org.jetbrains.annotations.NotNull android.net.Uri r3, @org.jetbrains.annotations.NotNull java.io.File r4) throws java.io.IOException {
        /*
            java.lang.String r0 = "$this$writeUriContentToFile"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "uri"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "file"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r0.<init>(r4)
            java.io.InputStream r2 = r2.openInputStream(r3)     // Catch:{ all -> 0x003b }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch:{ all -> 0x003b }
            r3 = 2048(0x800, float:2.87E-42)
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x0034 }
        L_0x001f:
            int r4 = r2.read(r3)     // Catch:{ all -> 0x0034 }
            if (r4 >= 0) goto L_0x002f
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0034 }
            r3 = 0
            kotlin.io.CloseableKt.closeFinally(r2, r3)
            kotlin.io.CloseableKt.closeFinally(r0, r3)
            return
        L_0x002f:
            r1 = 0
            r0.write(r3, r1, r4)
            goto L_0x001f
        L_0x0034:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0036 }
        L_0x0036:
            r4 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r3)
            throw r4
        L_0x003b:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x003d }
        L_0x003d:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.ContentResolverUtilsKt.writeUriContentToFile(android.content.ContentResolver, android.net.Uri, java.io.File):void");
    }
}
