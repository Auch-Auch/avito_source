package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
/* renamed from: com.yandex.mobile.ads.impl.do  reason: invalid class name */
public final class Cdo implements dp {
    @NonNull
    private final cq a;
    @NonNull
    private final dm b;
    @NonNull
    private final Context c;
    private final int d;

    public Cdo(@NonNull Context context, @NonNull x xVar, @NonNull cq cqVar, @NonNull dm dmVar) {
        this.a = cqVar;
        this.b = dmVar;
        this.c = context.getApplicationContext();
        this.d = xVar.t();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0081, code lost:
        com.yandex.mobile.ads.impl.dt.a(r1);
     */
    @android.support.annotation.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String b(@android.support.annotation.NonNull java.lang.String r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            r2 = 0
        L_0x0003:
            int r3 = r7.d
            if (r2 >= r3) goto L_0x0096
            boolean r3 = com.yandex.mobile.ads.impl.ee.a(r8)     // Catch:{ Exception -> 0x0087 }
            if (r3 != 0) goto L_0x0081
            boolean r3 = com.yandex.mobile.ads.impl.ee.c(r8)     // Catch:{ Exception -> 0x0087 }
            if (r3 != 0) goto L_0x0015
            goto L_0x0081
        L_0x0015:
            android.content.Context r3 = r7.c     // Catch:{ Exception -> 0x0087 }
            int r4 = com.yandex.mobile.ads.impl.hr.a     // Catch:{ Exception -> 0x0087 }
            java.net.URL r5 = new java.net.URL     // Catch:{ Exception -> 0x0087 }
            r5.<init>(r8)     // Catch:{ Exception -> 0x0087 }
            java.net.URLConnection r5 = r5.openConnection()     // Catch:{ Exception -> 0x0087 }
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ Exception -> 0x0087 }
            java.lang.String r6 = "User-Agent"
            java.lang.String r3 = com.yandex.mobile.ads.impl.ic.a(r3)     // Catch:{ Exception -> 0x0087 }
            r5.setRequestProperty(r6, r3)     // Catch:{ Exception -> 0x0087 }
            if (r4 <= 0) goto L_0x0035
            r5.setConnectTimeout(r4)     // Catch:{ Exception -> 0x0087 }
            r5.setReadTimeout(r4)     // Catch:{ Exception -> 0x0087 }
        L_0x0035:
            r3 = 21
            boolean r3 = com.yandex.mobile.ads.impl.id.a(r3)     // Catch:{ Exception -> 0x0087 }
            if (r3 == 0) goto L_0x004d
            boolean r3 = r5 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ Exception -> 0x0087 }
            if (r3 == 0) goto L_0x004d
            javax.net.ssl.SSLSocketFactory r3 = com.yandex.mobile.ads.impl.td.a()     // Catch:{ Exception -> 0x0087 }
            if (r3 == 0) goto L_0x004d
            r4 = r5
            javax.net.ssl.HttpsURLConnection r4 = (javax.net.ssl.HttpsURLConnection) r4     // Catch:{ Exception -> 0x0087 }
            r4.setSSLSocketFactory(r3)     // Catch:{ Exception -> 0x0087 }
        L_0x004d:
            r5.setInstanceFollowRedirects(r0)     // Catch:{ Exception -> 0x0087 }
            int r1 = r5.getResponseCode()     // Catch:{ Exception -> 0x007e, all -> 0x007b }
            com.yandex.mobile.ads.impl.rq r3 = com.yandex.mobile.ads.impl.rq.LOCATION     // Catch:{ Exception -> 0x007e, all -> 0x007b }
            java.lang.String r3 = r3.a()     // Catch:{ Exception -> 0x007e, all -> 0x007b }
            java.lang.String r3 = r5.getHeaderField(r3)     // Catch:{ Exception -> 0x007e, all -> 0x007b }
            r4 = 300(0x12c, float:4.2E-43)
            if (r1 < r4) goto L_0x006e
            r4 = 400(0x190, float:5.6E-43)
            if (r1 >= r4) goto L_0x006e
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x007e, all -> 0x007b }
            if (r1 != 0) goto L_0x006e
            r1 = 1
            goto L_0x006f
        L_0x006e:
            r1 = 0
        L_0x006f:
            if (r1 == 0) goto L_0x0077
            com.yandex.mobile.ads.impl.dt.a(r5)
            r8 = r3
            r1 = r5
            goto L_0x008e
        L_0x0077:
            com.yandex.mobile.ads.impl.dt.a(r5)
            goto L_0x0096
        L_0x007b:
            r8 = move-exception
            r1 = r5
            goto L_0x0092
        L_0x007e:
            r3 = move-exception
            r1 = r5
            goto L_0x0088
        L_0x0081:
            com.yandex.mobile.ads.impl.dt.a(r1)
            goto L_0x0096
        L_0x0085:
            r8 = move-exception
            goto L_0x0092
        L_0x0087:
            r3 = move-exception
        L_0x0088:
            r3.toString()     // Catch:{ all -> 0x0085 }
            com.yandex.mobile.ads.impl.dt.a(r1)
        L_0x008e:
            int r2 = r2 + 1
            goto L_0x0003
        L_0x0092:
            com.yandex.mobile.ads.impl.dt.a(r1)
            throw r8
        L_0x0096:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.Cdo.b(java.lang.String):java.lang.String");
    }

    @Override // com.yandex.mobile.ads.impl.dp
    public final void a(@NonNull String str) {
        this.b.a(this.a, b(str));
    }
}
