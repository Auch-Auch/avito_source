package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
@TargetApi(17)
public final class zzpt extends Surface {
    private static boolean zzbko;
    private static boolean zzbkp;
    private final boolean zzbbb;
    private final zzpv zzbkq;
    private boolean zzbkr;

    private zzpt(zzpv zzpv, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.zzbkq = zzpv;
        this.zzbbb = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean zzc(android.content.Context r6) {
        /*
            java.lang.Class<com.google.android.gms.internal.ads.zzpt> r0 = com.google.android.gms.internal.ads.zzpt.class
            monitor-enter(r0)
            boolean r1 = com.google.android.gms.internal.ads.zzpt.zzbkp     // Catch:{ all -> 0x0053 }
            if (r1 != 0) goto L_0x004f
            int r1 = com.google.android.gms.internal.ads.zzpq.SDK_INT     // Catch:{ all -> 0x0053 }
            r2 = 17
            r3 = 1
            if (r1 < r2) goto L_0x004d
            r2 = 0
            android.opengl.EGLDisplay r4 = android.opengl.EGL14.eglGetDisplay(r2)     // Catch:{ all -> 0x0053 }
            r5 = 12373(0x3055, float:1.7338E-41)
            java.lang.String r4 = android.opengl.EGL14.eglQueryString(r4, r5)     // Catch:{ all -> 0x0053 }
            if (r4 == 0) goto L_0x004b
            java.lang.String r5 = "EGL_EXT_protected_content"
            boolean r4 = r4.contains(r5)     // Catch:{ all -> 0x0053 }
            if (r4 == 0) goto L_0x004b
            r4 = 24
            if (r1 != r4) goto L_0x0047
            java.lang.String r1 = com.google.android.gms.internal.ads.zzpq.MODEL     // Catch:{ all -> 0x0053 }
            java.lang.String r4 = "SM-G950"
            boolean r4 = r1.startsWith(r4)     // Catch:{ all -> 0x0053 }
            if (r4 != 0) goto L_0x0039
            java.lang.String r4 = "SM-G955"
            boolean r1 = r1.startsWith(r4)     // Catch:{ all -> 0x0053 }
            if (r1 == 0) goto L_0x0047
        L_0x0039:
            android.content.pm.PackageManager r6 = r6.getPackageManager()     // Catch:{ all -> 0x0053 }
            java.lang.String r1 = "android.hardware.vr.high_performance"
            boolean r6 = r6.hasSystemFeature(r1)     // Catch:{ all -> 0x0053 }
            if (r6 != 0) goto L_0x0047
            r6 = 1
            goto L_0x0048
        L_0x0047:
            r6 = 0
        L_0x0048:
            if (r6 != 0) goto L_0x004b
            r2 = 1
        L_0x004b:
            com.google.android.gms.internal.ads.zzpt.zzbko = r2     // Catch:{ all -> 0x0053 }
        L_0x004d:
            com.google.android.gms.internal.ads.zzpt.zzbkp = r3     // Catch:{ all -> 0x0053 }
        L_0x004f:
            boolean r6 = com.google.android.gms.internal.ads.zzpt.zzbko     // Catch:{ all -> 0x0053 }
            monitor-exit(r0)
            return r6
        L_0x0053:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpt.zzc(android.content.Context):boolean");
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.zzbkq) {
            if (!this.zzbkr) {
                this.zzbkq.release();
                this.zzbkr = true;
            }
        }
    }

    public static zzpt zzc(Context context, boolean z) {
        if (zzpq.SDK_INT >= 17) {
            zzoz.checkState(!z || zzc(context));
            return new zzpv().zzm(z);
        }
        throw new UnsupportedOperationException("Unsupported prior to API level 17");
    }
}
