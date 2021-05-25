package com.avito.android.util;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/util/SearchContextWrapper;", "", "extractSearchXFromContext", "(Lcom/avito/android/util/SearchContextWrapper;)Ljava/lang/String;", "analytics-core_release"}, k = 2, mv = {1, 4, 2})
public final class SearchContextWrapperKt {
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0070, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0073, code lost:
        throw r0;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String extractSearchXFromContext(@org.jetbrains.annotations.NotNull com.avito.android.util.SearchContextWrapper r15) {
        /*
            java.lang.String r0 = "x"
            java.lang.String r1 = "$this$extractSearchXFromContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            java.lang.String r1 = r15.getContext()
            r2 = 0
            if (r1 != 0) goto L_0x000f
            goto L_0x0078
        L_0x000f:
            java.util.zip.GZIPInputStream r1 = new java.util.zip.GZIPInputStream     // Catch:{ Exception -> 0x0074 }
            java.lang.String r3 = r15.getContext()     // Catch:{ Exception -> 0x0074 }
            java.lang.String r4 = "-"
            java.lang.String r5 = "+"
            r6 = 0
            r7 = 4
            r8 = 0
            java.lang.String r9 = t6.y.m.replace$default(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0074 }
            java.lang.String r10 = "_"
            java.lang.String r11 = "/"
            r12 = 0
            r13 = 4
            r14 = 0
            java.lang.String r15 = t6.y.m.replace$default(r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0074 }
            r3 = 0
            byte[] r15 = android.util.Base64.decode(r15, r3)     // Catch:{ Exception -> 0x0074 }
            java.lang.String r3 = "Base64.decode(\n         …ULT\n                    )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r3)     // Catch:{ Exception -> 0x0074 }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0074 }
            r3.<init>(r15)     // Catch:{ Exception -> 0x0074 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x0074 }
            java.nio.charset.Charset r15 = kotlin.text.Charsets.UTF_8     // Catch:{ Exception -> 0x0074 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0074 }
            r3.<init>(r1, r15)     // Catch:{ Exception -> 0x0074 }
            r15 = 8192(0x2000, float:1.14794E-41)
            boolean r1 = r3 instanceof java.io.BufferedReader     // Catch:{ Exception -> 0x0074 }
            if (r1 == 0) goto L_0x004d
            java.io.BufferedReader r3 = (java.io.BufferedReader) r3     // Catch:{ Exception -> 0x0074 }
            goto L_0x0053
        L_0x004d:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0074 }
            r1.<init>(r3, r15)     // Catch:{ Exception -> 0x0074 }
            r3 = r1
        L_0x0053:
            java.lang.String r15 = kotlin.io.TextStreamsKt.readText(r3)     // Catch:{ all -> 0x006d }
            kotlin.io.CloseableKt.closeFinally(r3, r2)
            de.ailis.pherialize.Mixed r15 = de.ailis.pherialize.Pherialize.unserialize(r15)
            de.ailis.pherialize.MixedArray r15 = r15.toArray()
            boolean r1 = r15.containsKey(r0)
            if (r1 == 0) goto L_0x0078
            java.lang.String r2 = r15.getString(r0)
            goto L_0x0078
        L_0x006d:
            r15 = move-exception
            throw r15     // Catch:{ all -> 0x006f }
        L_0x006f:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r15)
            throw r0
        L_0x0074:
            r15 = move-exception
            com.avito.android.util.Logs.error(r15)
        L_0x0078:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.SearchContextWrapperKt.extractSearchXFromContext(com.avito.android.util.SearchContextWrapper):java.lang.String");
    }
}
