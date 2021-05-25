package com.my.target;

import androidx.annotation.NonNull;
public final class db extends de<String> {
    @NonNull
    public static db cE() {
        return new db();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00af  */
    @androidx.annotation.Nullable
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String c(@androidx.annotation.NonNull java.lang.String r6, @androidx.annotation.NonNull android.content.Context r7) {
        /*
            r5 = this;
            r7 = 0
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            r1.<init>()     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "send ad request: "
            r1.append(r2)     // Catch:{ all -> 0x008f }
            r1.append(r6)     // Catch:{ all -> 0x008f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x008f }
            com.my.target.ae.a(r1)     // Catch:{ all -> 0x008f }
            java.net.URL r1 = new java.net.URL     // Catch:{ all -> 0x008f }
            r1.<init>(r6)     // Catch:{ all -> 0x008f }
            java.net.URLConnection r6 = r1.openConnection()     // Catch:{ all -> 0x008f }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ all -> 0x008f }
            r0 = 10000(0x2710, float:1.4013E-41)
            r6.setReadTimeout(r0)     // Catch:{ all -> 0x008d }
            r6.setConnectTimeout(r0)     // Catch:{ all -> 0x008d }
            r0 = 1
            r6.setInstanceFollowRedirects(r0)     // Catch:{ all -> 0x008d }
            java.lang.String r0 = "connection"
            java.lang.String r1 = "close"
            r6.setRequestProperty(r0, r1)     // Catch:{ all -> 0x008d }
            r6.connect()     // Catch:{ all -> 0x008d }
            int r0 = r6.getResponseCode()     // Catch:{ all -> 0x008d }
            r5.responseCode = r0     // Catch:{ all -> 0x008d }
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 != r1) goto L_0x006e
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ all -> 0x008d }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ all -> 0x008d }
            java.io.InputStream r2 = r6.getInputStream()     // Catch:{ all -> 0x008d }
            java.lang.String r3 = "UTF-8"
            java.nio.charset.Charset r3 = java.nio.charset.Charset.forName(r3)     // Catch:{ all -> 0x008d }
            r1.<init>(r2, r3)     // Catch:{ all -> 0x008d }
            r0.<init>(r1)     // Catch:{ all -> 0x008d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
            r1.<init>()     // Catch:{ all -> 0x008d }
        L_0x005a:
            java.lang.String r2 = r0.readLine()     // Catch:{ all -> 0x008d }
            if (r2 == 0) goto L_0x0064
            r1.append(r2)     // Catch:{ all -> 0x008d }
            goto L_0x005a
        L_0x0064:
            r0.close()     // Catch:{ all -> 0x008d }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x008d }
            r5.eX = r0     // Catch:{ all -> 0x008d }
            goto L_0x00ad
        L_0x006e:
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L_0x00ad
            r5.eW = r7     // Catch:{ all -> 0x008d }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
            r0.<init>()     // Catch:{ all -> 0x008d }
            java.lang.String r1 = "ad request error: response code "
            r0.append(r1)     // Catch:{ all -> 0x008d }
            int r1 = r5.responseCode     // Catch:{ all -> 0x008d }
            r0.append(r1)     // Catch:{ all -> 0x008d }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x008d }
            r5.c = r0     // Catch:{ all -> 0x008d }
            com.my.target.ae.a(r0)     // Catch:{ all -> 0x008d }
            goto L_0x00ad
        L_0x008d:
            r0 = move-exception
            goto L_0x0093
        L_0x008f:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
        L_0x0093:
            r5.eW = r7
            java.lang.String r7 = r0.getMessage()
            r5.c = r7
            java.lang.String r7 = "ad request error: "
            java.lang.StringBuilder r7 = a2.b.a.a.a.L(r7)
            java.lang.String r0 = r5.c
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            com.my.target.ae.a(r7)
        L_0x00ad:
            if (r6 == 0) goto L_0x00b2
            r6.disconnect()
        L_0x00b2:
            T r6 = r5.eX
            java.lang.String r6 = (java.lang.String) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.db.c(java.lang.String, android.content.Context):java.lang.String");
    }
}
