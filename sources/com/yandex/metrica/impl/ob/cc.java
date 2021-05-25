package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
public class cc {
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:11:0x0032 */
    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.yandex.metrica.impl.ob.cc */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(@android.support.annotation.NonNull com.yandex.metrica.impl.ob.ca r8) {
        /*
            r7 = this;
            r0 = 0
            r8.d()     // Catch:{ all -> 0x009c }
            com.yandex.metrica.impl.ob.sg r1 = r8.c()     // Catch:{ all -> 0x009c }
            java.net.HttpURLConnection r1 = r1.a()     // Catch:{ all -> 0x009c }
            java.util.Map r2 = r8.B()     // Catch:{ all -> 0x0099 }
            r7.a(r1, r2)     // Catch:{ all -> 0x0099 }
            r2 = 2
            int r3 = r8.i()     // Catch:{ all -> 0x0099 }
            if (r2 != r3) goto L_0x004a
            byte[] r2 = r8.j()     // Catch:{ all -> 0x0099 }
            if (r2 == 0) goto L_0x004a
            int r3 = r2.length     // Catch:{ all -> 0x0099 }
            if (r3 <= 0) goto L_0x004a
            java.lang.Long r3 = r8.z()     // Catch:{ all -> 0x0099 }
            java.lang.Integer r4 = r8.A()     // Catch:{ all -> 0x0099 }
            r7.a(r1, r3, r4)     // Catch:{ all -> 0x0099 }
            java.io.OutputStream r3 = r1.getOutputStream()     // Catch:{ all -> 0x0099 }
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0046 }
            int r2 = r2.length     // Catch:{ all -> 0x0046 }
            r4.<init>(r3, r2)     // Catch:{ all -> 0x0046 }
            byte[] r2 = r8.j()     // Catch:{ all -> 0x0093 }
            r4.write(r2)     // Catch:{ all -> 0x0093 }
            r4.flush()     // Catch:{ all -> 0x0093 }
            com.yandex.metrica.impl.ob.dl.a(r3)     // Catch:{ all -> 0x0093 }
            goto L_0x004c
        L_0x0046:
            r2 = move-exception
            r6 = r0
            goto L_0x00a0
        L_0x004a:
            r3 = r0
            r4 = r3
        L_0x004c:
            int r2 = r1.getResponseCode()     // Catch:{ all -> 0x0093 }
            r8.a(r2)     // Catch:{ all -> 0x0093 }
            java.util.Map r5 = r1.getHeaderFields()     // Catch:{ all -> 0x0093 }
            r8.a(r5)     // Catch:{ all -> 0x0093 }
            boolean r2 = r8.b(r2)     // Catch:{ all -> 0x0093 }
            r5 = 8000(0x1f40, float:1.121E-41)
            if (r2 == 0) goto L_0x007d
            java.io.InputStream r2 = r1.getInputStream()     // Catch:{ all -> 0x0093 }
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ all -> 0x007a }
            r6.<init>(r2, r5)     // Catch:{ all -> 0x007a }
            byte[] r0 = com.yandex.metrica.impl.ob.ax.b(r6)     // Catch:{ all -> 0x0077 }
            r8.b(r0)     // Catch:{ all -> 0x0077 }
            com.yandex.metrica.impl.ob.dl.a(r2)     // Catch:{ all -> 0x0077 }
            r0 = r2
            goto L_0x0086
        L_0x0077:
            r0 = move-exception
            r5 = r0
            goto L_0x0097
        L_0x007a:
            r5 = move-exception
            r6 = r0
            goto L_0x0097
        L_0x007d:
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream
            java.io.InputStream r2 = r1.getErrorStream()
            r6.<init>(r2, r5)
        L_0x0086:
            com.yandex.metrica.impl.ob.dl.a(r4)
            com.yandex.metrica.impl.ob.dl.a(r6)
            com.yandex.metrica.impl.ob.dl.a(r3)
            com.yandex.metrica.impl.ob.dl.a(r0)
            goto L_0x00b1
        L_0x0093:
            r2 = move-exception
            r6 = r0
            r5 = r2
            r2 = r6
        L_0x0097:
            r0 = r4
            goto L_0x00a2
        L_0x0099:
            r2 = move-exception
            r3 = r0
            goto L_0x009f
        L_0x009c:
            r2 = move-exception
            r1 = r0
            r3 = r1
        L_0x009f:
            r6 = r3
        L_0x00a0:
            r5 = r2
            r2 = r6
        L_0x00a2:
            r8.a(r5)     // Catch:{ all -> 0x00b5 }
            com.yandex.metrica.impl.ob.dl.a(r0)
            com.yandex.metrica.impl.ob.dl.a(r6)
            com.yandex.metrica.impl.ob.dl.a(r3)
            com.yandex.metrica.impl.ob.dl.a(r2)
        L_0x00b1:
            com.yandex.metrica.impl.ob.dl.a(r1)
            return
        L_0x00b5:
            r8 = move-exception
            com.yandex.metrica.impl.ob.dl.a(r0)
            com.yandex.metrica.impl.ob.dl.a(r6)
            com.yandex.metrica.impl.ob.dl.a(r3)
            com.yandex.metrica.impl.ob.dl.a(r2)
            com.yandex.metrica.impl.ob.dl.a(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.cc.a(com.yandex.metrica.impl.ob.ca):void");
    }

    private void a(@NonNull HttpURLConnection httpURLConnection, @NonNull Map<String, List<String>> map) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), TextUtils.join(",", entry.getValue()));
        }
    }

    @NonNull
    private HttpURLConnection a(@NonNull HttpURLConnection httpURLConnection, @Nullable Long l, @Nullable Integer num) {
        httpURLConnection.setDoOutput(true);
        if (l != null) {
            httpURLConnection.setRequestProperty("Send-Timestamp", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(l.longValue())));
        }
        if (num != null) {
            httpURLConnection.setRequestProperty("Send-Timezone", String.valueOf(num));
        }
        return httpURLConnection;
    }
}
