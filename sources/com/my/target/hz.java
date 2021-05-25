package com.my.target;

import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Locale;
public class hz {
    @Nullable
    public static String ag(@NonNull String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    public static String ah(@NonNull String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("md5");
            instance.update(str.getBytes(Charset.forName("UTF-8")));
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digest.length; i++) {
                sb.append(String.format("%02X", Byte.valueOf(digest[i])));
            }
            return sb.toString().toLowerCase(Locale.ROOT);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0058 A[SYNTHETIC, Splitter:B:24:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005d A[Catch:{ all -> 0x0065 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0062 A[Catch:{ all -> 0x0065 }] */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String ai(@androidx.annotation.NonNull java.lang.String r6) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x003b }
            r2.<init>()     // Catch:{ all -> 0x003b }
            android.util.Base64OutputStream r3 = new android.util.Base64OutputStream     // Catch:{ all -> 0x0036 }
            r4 = 0
            r3.<init>(r2, r4)     // Catch:{ all -> 0x0036 }
            java.util.zip.DeflaterOutputStream r4 = new java.util.zip.DeflaterOutputStream     // Catch:{ all -> 0x0033 }
            r4.<init>(r3)     // Catch:{ all -> 0x0033 }
            byte[] r6 = r6.getBytes()     // Catch:{ all -> 0x0031 }
            r4.write(r6)     // Catch:{ all -> 0x0031 }
            r4.close()     // Catch:{ all -> 0x0031 }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x0031 }
            java.lang.String r1 = "\n"
            java.lang.String r6 = r6.replaceAll(r1, r0)     // Catch:{ all -> 0x0031 }
            r4.close()     // Catch:{ all -> 0x0030 }
            r3.close()     // Catch:{ all -> 0x0030 }
            r2.close()     // Catch:{ all -> 0x0030 }
        L_0x0030:
            return r6
        L_0x0031:
            r6 = move-exception
            goto L_0x0039
        L_0x0033:
            r6 = move-exception
            r4 = r1
            goto L_0x0039
        L_0x0036:
            r6 = move-exception
            r3 = r1
            r4 = r3
        L_0x0039:
            r1 = r2
            goto L_0x003e
        L_0x003b:
            r6 = move-exception
            r3 = r1
            r4 = r3
        L_0x003e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0066 }
            r2.<init>()     // Catch:{ all -> 0x0066 }
            java.lang.String r5 = "cannot obtain bidder token: "
            r2.append(r5)     // Catch:{ all -> 0x0066 }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x0066 }
            r2.append(r6)     // Catch:{ all -> 0x0066 }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x0066 }
            com.my.target.ae.a(r6)     // Catch:{ all -> 0x0066 }
            if (r4 == 0) goto L_0x005b
            r4.close()     // Catch:{ all -> 0x0065 }
        L_0x005b:
            if (r3 == 0) goto L_0x0060
            r3.close()     // Catch:{ all -> 0x0065 }
        L_0x0060:
            if (r1 == 0) goto L_0x0065
            r1.close()     // Catch:{ all -> 0x0065 }
        L_0x0065:
            return r0
        L_0x0066:
            r6 = move-exception
            if (r4 == 0) goto L_0x006c
            r4.close()     // Catch:{ all -> 0x0076 }
        L_0x006c:
            if (r3 == 0) goto L_0x0071
            r3.close()     // Catch:{ all -> 0x0076 }
        L_0x0071:
            if (r1 == 0) goto L_0x0076
            r1.close()     // Catch:{ all -> 0x0076 }
        L_0x0076:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.hz.ai(java.lang.String):java.lang.String");
    }
}
