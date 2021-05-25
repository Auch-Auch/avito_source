package com.avito.android.util;

import a2.b.a.a.a;
import android.net.Uri;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.common.util.UriUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\t\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a#\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\b\u001a\u0019\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f\u001a!\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010\u001a!\u0010\u0016\u001a\u00020\u0015*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0013\u0010\u0018\u001a\u00020\u0006*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0014\u0010\u001d\u001a\u00020\u0005*\u00020\u0005H\b¢\u0006\u0004\b\u001d\u0010\u001c\"\u001f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u001f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"¨\u0006'"}, d2 = {"Landroid/net/Uri;", "", "id", "withAppendedId", "(Landroid/net/Uri;J)Landroid/net/Uri;", "", "", "encoded", "(Landroid/net/Uri;Ljava/lang/String;Z)Landroid/net/Uri;", "", "delta", "moveNextPageOffset", "(Landroid/net/Uri;I)Landroid/net/Uri;", "key", "newValue", "replaceQueryParameter", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;", "Landroid/content/Context;", "context", "Ljava/io/File;", "target", "", "saveContentToFile", "(Landroid/net/Uri;Landroid/content/Context;Ljava/io/File;)V", "isNullOrEmpty", "(Landroid/net/Uri;)Z", "url", "addUrlSchemeIfMissing", "(Ljava/lang/String;)Ljava/lang/String;", "forceWrappingByChar", "", AuthSource.BOOKING_ORDER, "[Ljava/lang/String;", "getURL_SCHEMES_ONLY_LETTERS", "()[Ljava/lang/String;", "URL_SCHEMES_ONLY_LETTERS", AuthSource.SEND_ABUSE, "getURL_SCHEMES", "URL_SCHEMES", "android_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Uris")
public final class Uris {
    @NotNull
    public static final String[] a = {"http://", "https://", "rtsp://"};
    @NotNull
    public static final String[] b = {UriUtil.HTTP_SCHEME, "https", "rtsp"};

    @NotNull
    public static final String addUrlSchemeIfMissing(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        String[] url_schemes = getURL_SCHEMES();
        for (String str2 : url_schemes) {
            if (m.startsWith(str, str2, true)) {
                if (m.startsWith(str, str2, false)) {
                    return str;
                } else {
                    StringBuilder L = a.L(str2);
                    String substring = str.substring(str2.length());
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                    L.append(substring);
                    return L.toString();
                }
            }
        }
        return a.t(new StringBuilder(), getURL_SCHEMES()[0], str);
    }

    @NotNull
    public static final String forceWrappingByChar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$forceWrappingByChar");
        return new Regex(".(?!$)").replace(str, "$0​");
    }

    @NotNull
    public static final String[] getURL_SCHEMES() {
        return a;
    }

    @NotNull
    public static final String[] getURL_SCHEMES_ONLY_LETTERS() {
        return b;
    }

    public static final boolean isNullOrEmpty(@Nullable Uri uri) {
        return uri == null || Intrinsics.areEqual(uri, Uri.EMPTY);
    }

    @NotNull
    public static final Uri moveNextPageOffset(@NotNull Uri uri, int i) {
        Intrinsics.checkNotNullParameter(uri, "$this$moveNextPageOffset");
        String queryParameter = uri.getQueryParameter("offset");
        if (queryParameter == null) {
            return uri;
        }
        Intrinsics.checkNotNullExpressionValue(queryParameter, "offset");
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= queryParameter.length()) {
                z = true;
                break;
            } else if (!Character.isDigit(queryParameter.charAt(i2))) {
                break;
            } else {
                i2++;
            }
        }
        return z ? replaceQueryParameter(uri, "offset", String.valueOf(Integer.parseInt(queryParameter) + i)) : uri;
    }

    @NotNull
    public static final Uri replaceQueryParameter(@NotNull Uri uri, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(uri, "$this$replaceQueryParameter");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "newValue");
        Uri.Builder clearQuery = uri.buildUpon().clearQuery();
        for (String str3 : uri.getQueryParameterNames()) {
            clearQuery.appendQueryParameter(str3, Intrinsics.areEqual(str3, str) ? str2 : uri.getQueryParameter(str3));
        }
        Uri build = clearQuery.build();
        Intrinsics.checkNotNullExpressionValue(build, "buildUpon().clearQuery()…)\n        }\n    }.build()");
        return build;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003d, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void saveContentToFile(@org.jetbrains.annotations.NotNull android.net.Uri r2, @org.jetbrains.annotations.NotNull android.content.Context r3, @org.jetbrains.annotations.NotNull java.io.File r4) {
        /*
            java.lang.String r0 = "$this$saveContentToFile"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "target"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.ContentResolver r3 = r3.getContentResolver()
            java.io.InputStream r2 = r3.openInputStream(r2)
            if (r2 == 0) goto L_0x003e
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x0037 }
            r3.<init>(r4)     // Catch:{ all -> 0x0037 }
            java.lang.String r4 = "inputStream"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)     // Catch:{ all -> 0x0030 }
            r4 = 0
            r0 = 2
            r1 = 0
            kotlin.io.ByteStreamsKt.copyTo$default(r2, r3, r4, r0, r1)     // Catch:{ all -> 0x0030 }
            kotlin.io.CloseableKt.closeFinally(r3, r1)
            kotlin.io.CloseableKt.closeFinally(r2, r1)
            goto L_0x003e
        L_0x0030:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0032 }
        L_0x0032:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r4)
            throw r0
        L_0x0037:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0039 }
        L_0x0039:
            r4 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r3)
            throw r4
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.Uris.saveContentToFile(android.net.Uri, android.content.Context, java.io.File):void");
    }

    @NotNull
    public static final Uri withAppendedId(@NotNull Uri uri, long j) {
        Intrinsics.checkNotNullParameter(uri, "$this$withAppendedId");
        return withAppendedId(uri, String.valueOf(j), true);
    }

    public static /* synthetic */ Uri withAppendedId$default(Uri uri, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return withAppendedId(uri, str, z);
    }

    @NotNull
    public static final Uri withAppendedId(@NotNull Uri uri, @NotNull String str, boolean z) {
        Uri.Builder builder;
        Intrinsics.checkNotNullParameter(uri, "$this$withAppendedId");
        Intrinsics.checkNotNullParameter(str, "id");
        Uri.Builder buildUpon = uri.buildUpon();
        if (z) {
            builder = buildUpon.appendEncodedPath(str);
        } else {
            builder = buildUpon.appendPath(str);
        }
        Uri build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "if (encoded) {\n        b…endPath(id)\n    }.build()");
        return build;
    }
}
