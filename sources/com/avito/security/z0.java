package com.avito.security;

import java.io.File;
import java.nio.charset.Charset;
public class z0 extends y0 {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        com.avito.security.w0.a(r1, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String a(java.io.File r1, java.nio.charset.Charset r2) {
        /*
            java.lang.String r0 = "$this$readText"
            com.avito.security.j1.b(r1, r0)
            java.lang.String r0 = "charset"
            com.avito.security.j1.b(r2, r0)
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r1)
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            r1.<init>(r0, r2)
            java.lang.String r2 = com.avito.security.c1.a(r1)     // Catch:{ all -> 0x001d }
            r0 = 0
            com.avito.security.w0.a(r1, r0)
            return r2
        L_0x001d:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001f }
        L_0x001f:
            r0 = move-exception
            com.avito.security.w0.a(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.security.z0.a(java.io.File, java.nio.charset.Charset):java.lang.String");
    }

    public static /* synthetic */ String a(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = d2.a;
        }
        return a(file, charset);
    }
}
