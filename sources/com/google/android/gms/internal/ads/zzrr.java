package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
@VisibleForTesting
public final class zzrr {
    @VisibleForTesting
    private ByteArrayOutputStream zzbua = new ByteArrayOutputStream(4096);
    @VisibleForTesting
    private Base64OutputStream zzbub = new Base64OutputStream(this.zzbua, 10);

    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.ByteArrayOutputStream, android.util.Base64OutputStream] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String toString() {
        /*
            r3 = this;
            java.lang.String r0 = "HashManager: Unable to convert to Base64."
            android.util.Base64OutputStream r1 = r3.zzbub     // Catch:{ IOException -> 0x0008 }
            r1.close()     // Catch:{ IOException -> 0x0008 }
            goto L_0x000c
        L_0x0008:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzbbd.zzc(r0, r1)
        L_0x000c:
            r1 = 0
            java.io.ByteArrayOutputStream r2 = r3.zzbua     // Catch:{ IOException -> 0x001f }
            r2.close()     // Catch:{ IOException -> 0x001f }
            java.io.ByteArrayOutputStream r2 = r3.zzbua     // Catch:{ IOException -> 0x001f }
            java.lang.String r0 = r2.toString()     // Catch:{ IOException -> 0x001f }
            r3.zzbua = r1
            r3.zzbub = r1
            return r0
        L_0x001d:
            r0 = move-exception
            goto L_0x002a
        L_0x001f:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzbbd.zzc(r0, r2)     // Catch:{ all -> 0x001d }
            java.lang.String r0 = ""
            r3.zzbua = r1
            r3.zzbub = r1
            return r0
        L_0x002a:
            r3.zzbua = r1
            r3.zzbub = r1
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrr.toString():java.lang.String");
    }

    public final void write(byte[] bArr) throws IOException {
        this.zzbub.write(bArr);
    }
}
