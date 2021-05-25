package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
@TargetApi(16)
public final class zzqb {
    private final zzqe zzbmc;
    private final boolean zzbmd;
    private final long zzbme;
    private final long zzbmf;
    private long zzbmg;
    private long zzbmh;
    private long zzbmi;
    private boolean zzbmj;
    private long zzbmk;
    private long zzbml;
    private long zzbmm;

    public zzqb() {
        this(-1.0d);
    }

    private final boolean zzg(long j, long j2) {
        return Math.abs((j2 - this.zzbmk) - (j - this.zzbml)) > 20000000;
    }

    public final void disable() {
        if (this.zzbmd) {
            this.zzbmc.zzjp();
        }
    }

    public final void enable() {
        this.zzbmj = false;
        if (this.zzbmd) {
            this.zzbmc.zzjo();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzf(long r10, long r12) {
        /*
            r9 = this;
            r0 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r10
            boolean r2 = r9.zzbmj
            if (r2 == 0) goto L_0x0042
            long r2 = r9.zzbmg
            int r4 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0019
            long r2 = r9.zzbmm
            r4 = 1
            long r2 = r2 + r4
            r9.zzbmm = r2
            long r2 = r9.zzbmi
            r9.zzbmh = r2
        L_0x0019:
            long r2 = r9.zzbmm
            r4 = 6
            r6 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 < 0) goto L_0x003a
            long r4 = r9.zzbml
            long r4 = r0 - r4
            long r4 = r4 / r2
            long r2 = r9.zzbmh
            long r2 = r2 + r4
            boolean r4 = r9.zzg(r2, r12)
            if (r4 == 0) goto L_0x0033
            r9.zzbmj = r6
            goto L_0x0042
        L_0x0033:
            long r4 = r9.zzbmk
            long r4 = r4 + r2
            long r6 = r9.zzbml
            long r4 = r4 - r6
            goto L_0x0044
        L_0x003a:
            boolean r2 = r9.zzg(r0, r12)
            if (r2 == 0) goto L_0x0042
            r9.zzbmj = r6
        L_0x0042:
            r4 = r12
            r2 = r0
        L_0x0044:
            boolean r6 = r9.zzbmj
            r7 = 0
            if (r6 != 0) goto L_0x0053
            r9.zzbml = r0
            r9.zzbmk = r12
            r9.zzbmm = r7
            r12 = 1
            r9.zzbmj = r12
        L_0x0053:
            r9.zzbmg = r10
            r9.zzbmi = r2
            com.google.android.gms.internal.ads.zzqe r10 = r9.zzbmc
            if (r10 == 0) goto L_0x0085
            long r10 = r10.zzbmo
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 != 0) goto L_0x0062
            goto L_0x0085
        L_0x0062:
            com.google.android.gms.internal.ads.zzqe r10 = r9.zzbmc
            long r10 = r10.zzbmo
            long r12 = r9.zzbme
            long r0 = r4 - r10
            long r0 = r0 / r12
            long r0 = r0 * r12
            long r0 = r0 + r10
            int r10 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r10 > 0) goto L_0x0075
            long r10 = r0 - r12
            goto L_0x0078
        L_0x0075:
            long r12 = r12 + r0
            r10 = r0
            r0 = r12
        L_0x0078:
            long r12 = r0 - r4
            long r4 = r4 - r10
            int r2 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0080
            goto L_0x0081
        L_0x0080:
            r0 = r10
        L_0x0081:
            long r10 = r9.zzbmf
            long r0 = r0 - r10
            return r0
        L_0x0085:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqb.zzf(long, long):long");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzqb(android.content.Context r3) {
        /*
            r2 = this;
            java.lang.String r0 = "window"
            java.lang.Object r3 = r3.getSystemService(r0)
            android.view.WindowManager r3 = (android.view.WindowManager) r3
            android.view.Display r0 = r3.getDefaultDisplay()
            if (r0 == 0) goto L_0x0018
            android.view.Display r3 = r3.getDefaultDisplay()
            float r3 = r3.getRefreshRate()
            double r0 = (double) r3
            goto L_0x001a
        L_0x0018:
            r0 = -4616189618054758400(0xbff0000000000000, double:-1.0)
        L_0x001a:
            r2.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqb.<init>(android.content.Context):void");
    }

    private zzqb(double d) {
        boolean z = d != -1.0d;
        this.zzbmd = z;
        if (z) {
            this.zzbmc = zzqe.zzjn();
            long j = (long) (1.0E9d / d);
            this.zzbme = j;
            this.zzbmf = (j * 80) / 100;
            return;
        }
        this.zzbmc = null;
        this.zzbme = -1;
        this.zzbmf = -1;
    }
}
