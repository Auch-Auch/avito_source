package com.my.target;

import androidx.annotation.NonNull;
public final class dg extends de<String> {
    @NonNull
    public static dg cM() {
        return new dg();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a7  */
    @androidx.annotation.Nullable
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String c(@androidx.annotation.NonNull java.lang.String r6, @androidx.annotation.NonNull android.content.Context r7) {
        /*
            r5 = this;
            com.my.target.hy r7 = com.my.target.hy.Z(r7)
            r0 = 0
            r1 = 0
            if (r7 == 0) goto L_0x00af
            java.lang.String r2 = r7.ae(r6)
            r5.eX = r2
            r3 = 1
            if (r2 == 0) goto L_0x0016
            r5.dx = r3
            java.lang.String r2 = (java.lang.String) r2
            return r2
        L_0x0016:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0089 }
            r2.<init>()     // Catch:{ all -> 0x0089 }
            java.lang.String r4 = "send video request: "
            r2.append(r4)     // Catch:{ all -> 0x0089 }
            r2.append(r6)     // Catch:{ all -> 0x0089 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0089 }
            com.my.target.ae.a(r2)     // Catch:{ all -> 0x0089 }
            java.net.URL r2 = new java.net.URL     // Catch:{ all -> 0x0089 }
            r2.<init>(r6)     // Catch:{ all -> 0x0089 }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ all -> 0x0089 }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ all -> 0x0089 }
            r0 = 10000(0x2710, float:1.4013E-41)
            r2.setReadTimeout(r0)     // Catch:{ all -> 0x0086 }
            r2.setConnectTimeout(r0)     // Catch:{ all -> 0x0086 }
            r2.setInstanceFollowRedirects(r3)     // Catch:{ all -> 0x0086 }
            java.lang.String r0 = "connection"
            java.lang.String r3 = "close"
            r2.setRequestProperty(r0, r3)     // Catch:{ all -> 0x0086 }
            r2.connect()     // Catch:{ all -> 0x0086 }
            int r0 = r2.getResponseCode()     // Catch:{ all -> 0x0086 }
            r5.responseCode = r0     // Catch:{ all -> 0x0086 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r0 != r3) goto L_0x006c
            java.io.InputStream r0 = r2.getInputStream()     // Catch:{ all -> 0x0086 }
            java.io.File r6 = r7.b(r0, r6)     // Catch:{ all -> 0x0086 }
            if (r6 == 0) goto L_0x0065
            java.lang.String r6 = r6.getAbsolutePath()     // Catch:{ all -> 0x0086 }
            r5.eX = r6     // Catch:{ all -> 0x0086 }
            goto L_0x00a5
        L_0x0065:
            r5.eW = r1     // Catch:{ all -> 0x0086 }
            java.lang.String r6 = "video request error: can't save video to disk cache"
        L_0x0069:
            r5.c = r6     // Catch:{ all -> 0x0086 }
            goto L_0x0082
        L_0x006c:
            r5.eW = r1     // Catch:{ all -> 0x0086 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0086 }
            r6.<init>()     // Catch:{ all -> 0x0086 }
            java.lang.String r7 = "video request error: response code "
            r6.append(r7)     // Catch:{ all -> 0x0086 }
            int r7 = r5.responseCode     // Catch:{ all -> 0x0086 }
            r6.append(r7)     // Catch:{ all -> 0x0086 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0086 }
            goto L_0x0069
        L_0x0082:
            com.my.target.ae.a(r6)     // Catch:{ all -> 0x0086 }
            goto L_0x00a5
        L_0x0086:
            r6 = move-exception
            r0 = r2
            goto L_0x008a
        L_0x0089:
            r6 = move-exception
        L_0x008a:
            r5.eW = r1
            java.lang.String r6 = r6.getMessage()
            r5.c = r6
            java.lang.String r6 = "video request error: "
            java.lang.StringBuilder r6 = a2.b.a.a.a.L(r6)
            java.lang.String r7 = r5.c
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            com.my.target.ae.a(r6)
            r2 = r0
        L_0x00a5:
            if (r2 == 0) goto L_0x00aa
            r2.disconnect()
        L_0x00aa:
            T r6 = r5.eX
            java.lang.String r6 = (java.lang.String) r6
            return r6
        L_0x00af:
            java.lang.String r7 = "unable to open disk cache and load/save video "
            a2.b.a.a.a.U0(r7, r6)
            r5.eW = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.dg.c(java.lang.String, android.content.Context):java.lang.String");
    }
}
