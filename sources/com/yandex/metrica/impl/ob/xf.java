package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;
public class xf {
    @NonNull
    private Socket a;
    @NonNull
    private xg b;
    @NonNull
    private Map<String, xe> c;

    public xf(@NonNull Socket socket, @NonNull xg xgVar, @NonNull Map<String, xe> map) {
        this.a = socket;
        this.b = xgVar;
        this.c = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r6 = this;
            r0 = 0
            java.net.Socket r1 = r6.a     // Catch:{ all -> 0x0047 }
            r2 = 1000(0x3e8, float:1.401E-42)
            r1.setSoTimeout(r2)     // Catch:{ all -> 0x0047 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0047 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0047 }
            java.net.Socket r3 = r6.a     // Catch:{ all -> 0x0047 }
            java.io.InputStream r3 = r3.getInputStream()     // Catch:{ all -> 0x0047 }
            r2.<init>(r3)     // Catch:{ all -> 0x0047 }
            r1.<init>(r2)     // Catch:{ all -> 0x0047 }
            java.lang.String r0 = r6.a(r1)     // Catch:{ all -> 0x0045 }
            if (r0 == 0) goto L_0x0041
            android.net.Uri r2 = android.net.Uri.parse(r0)     // Catch:{ all -> 0x0045 }
            java.lang.String r3 = r2.getPath()     // Catch:{ all -> 0x0045 }
            java.util.Map<java.lang.String, com.yandex.metrica.impl.ob.xe> r4 = r6.c     // Catch:{ all -> 0x0045 }
            java.lang.Object r3 = r4.get(r3)     // Catch:{ all -> 0x0045 }
            com.yandex.metrica.impl.ob.xe r3 = (com.yandex.metrica.impl.ob.xe) r3     // Catch:{ all -> 0x0045 }
            if (r3 == 0) goto L_0x003a
            java.net.Socket r0 = r6.a     // Catch:{ all -> 0x0045 }
            com.yandex.metrica.impl.ob.xd r0 = r3.a(r0, r2)     // Catch:{ all -> 0x0045 }
            r0.a()     // Catch:{ all -> 0x0045 }
            goto L_0x0041
        L_0x003a:
            com.yandex.metrica.impl.ob.xg r2 = r6.b     // Catch:{ all -> 0x0045 }
            java.lang.String r3 = "request_to_unknown_path"
            r2.a(r3, r0)     // Catch:{ all -> 0x0045 }
        L_0x0041:
            r1.close()     // Catch:{ all -> 0x0055 }
            goto L_0x0055
        L_0x0045:
            r0 = move-exception
            goto L_0x004b
        L_0x0047:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x004b:
            com.yandex.metrica.impl.ob.xg r2 = r6.b     // Catch:{ all -> 0x0056 }
            java.lang.String r3 = "LocalHttpServer exception"
            r2.a(r3, r0)     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x0055
            goto L_0x0041
        L_0x0055:
            return
        L_0x0056:
            r0 = move-exception
            if (r1 == 0) goto L_0x005c
            r1.close()     // Catch:{ all -> 0x005c }
        L_0x005c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.xf.a():void");
    }

    @Nullable
    private String a(@NonNull BufferedReader bufferedReader) throws IOException {
        int indexOf;
        int indexOf2;
        String readLine = bufferedReader.readLine();
        if (!TextUtils.isEmpty(readLine) && readLine.startsWith("GET /") && (indexOf2 = readLine.indexOf(32, (indexOf = readLine.indexOf(47) + 1))) > 0) {
            return readLine.substring(indexOf, indexOf2);
        }
        this.b.a("invalid_route", readLine);
        return null;
    }
}
