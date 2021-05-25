package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;
@Nullsafe(Nullsafe.Mode.STRICT)
public class Files {
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] toByteArray(java.io.File r6) throws java.io.IOException {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0048 }
            r1.<init>(r6)     // Catch:{ all -> 0x0048 }
            java.nio.channels.FileChannel r6 = r1.getChannel()     // Catch:{ all -> 0x0045 }
            long r2 = r6.size()     // Catch:{ all -> 0x0045 }
            r4 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0029
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0020
            byte[] r6 = com.facebook.common.internal.ByteStreams.toByteArray(r1)     // Catch:{ all -> 0x0045 }
            goto L_0x0025
        L_0x0020:
            int r6 = (int) r2     // Catch:{ all -> 0x0045 }
            byte[] r6 = com.facebook.common.internal.ByteStreams.toByteArray(r1, r6)     // Catch:{ all -> 0x0045 }
        L_0x0025:
            r1.close()
            return r6
        L_0x0029:
            java.lang.OutOfMemoryError r6 = new java.lang.OutOfMemoryError
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "file is too large to fit in a byte array: "
            r0.append(r4)
            r0.append(r2)
            java.lang.String r2 = " bytes"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L_0x0045:
            r6 = move-exception
            r0 = r1
            goto L_0x0049
        L_0x0048:
            r6 = move-exception
        L_0x0049:
            if (r0 == 0) goto L_0x004e
            r0.close()
        L_0x004e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.internal.Files.toByteArray(java.io.File):byte[]");
    }
}
