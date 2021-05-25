package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
public final class sm implements rv {
    public static final boolean a = sd.b;
    public final sq b;
    public final sn c;

    public sm(sq sqVar) {
        this(sqVar, new sn());
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00c1: APUT  (r15v3 java.lang.Object[]), (2 ??[int, float, short, byte, char]), (r13v8 java.lang.Object) */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0103, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0104, code lost:
        r14 = r5;
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0108, code lost:
        r0 = r8.getStatusLine().getStatusCode();
        com.yandex.mobile.ads.impl.sd.c("Unexpected response code %d for %s", java.lang.Integer.valueOf(r0), r21.b());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0123, code lost:
        if (r13 != null) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0125, code lost:
        r5 = new com.yandex.mobile.ads.impl.rx(r0, r13, r14, false, android.os.SystemClock.elapsedRealtime() - r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0135, code lost:
        if (r0 == 401) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0140, code lost:
        if (r0 < 400) goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x014a, code lost:
        throw new com.yandex.mobile.ads.impl.sf(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x014b, code lost:
        if (r0 < 500) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0155, code lost:
        if (r21.n() != false) goto L_0x0157;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0157, code lost:
        a(ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt.ANALYTIC_FAIL_SERVER, r21, new com.yandex.mobile.ads.impl.sj(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0168, code lost:
        throw new com.yandex.mobile.ads.impl.sj(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x016f, code lost:
        a(com.avito.android.authorization.event.SocialButtonClickedEventKt.AUTH, r21, new com.yandex.mobile.ads.impl.se(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x017b, code lost:
        a("network", r21, new com.yandex.mobile.ads.impl.sg());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x018c, code lost:
        throw new com.yandex.mobile.ads.impl.sh(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x018d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01a5, code lost:
        throw new java.lang.RuntimeException("Bad URL " + r21.b(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01a6, code lost:
        a("connection", r21, new com.yandex.mobile.ads.impl.sk());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01b2, code lost:
        a("socket", r21, new com.yandex.mobile.ads.impl.sk());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x018d A[ExcHandler: MalformedURLException (r0v2 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:2:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:76:? A[ExcHandler: ConnectTimeoutException (unused org.apache.http.conn.ConnectTimeoutException), SYNTHETIC, Splitter:B:2:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:78:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), SYNTHETIC, Splitter:B:2:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0187 A[SYNTHETIC] */
    @Override // com.yandex.mobile.ads.impl.rv
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.yandex.mobile.ads.impl.rx a(com.yandex.mobile.ads.impl.ry<?> r21) throws com.yandex.mobile.ads.impl.sl {
        /*
        // Method dump skipped, instructions count: 446
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.sm.a(com.yandex.mobile.ads.impl.ry):com.yandex.mobile.ads.impl.rx");
    }

    private sm(sq sqVar, sn snVar) {
        this.b = sqVar;
        this.c = snVar;
    }

    private static void a(String str, ry<?> ryVar, sl slVar) throws sl {
        sc q = ryVar.q();
        int p = ryVar.p();
        try {
            q.a(slVar);
            String.format("%s-retry [timeout=%s]", str, Integer.valueOf(p));
        } catch (sl e) {
            String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(p));
            throw e;
        }
    }

    private byte[] a(HttpEntity httpEntity) throws IOException, sj {
        sv svVar = new sv(this.c, (int) httpEntity.getContentLength());
        try {
            InputStream content = httpEntity.getContent();
            if (content != null) {
                byte[] a3 = this.c.a(1024);
                while (true) {
                    int read = content.read(a3);
                    if (read == -1) {
                        break;
                    }
                    svVar.write(a3, 0, read);
                }
                byte[] byteArray = svVar.toByteArray();
                try {
                    httpEntity.consumeContent();
                } catch (IOException unused) {
                    sd.a("Error occured when calling consumingContent", new Object[0]);
                }
                this.c.a(a3);
                svVar.close();
                return byteArray;
            }
            throw new sj();
        } catch (Throwable th) {
            try {
                httpEntity.consumeContent();
            } catch (IOException unused2) {
                sd.a("Error occured when calling consumingContent", new Object[0]);
            }
            this.c.a((byte[]) null);
            svVar.close();
            throw th;
        }
    }

    private static Map<String, String> a(Header[] headerArr) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }
}
