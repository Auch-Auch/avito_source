package com.google.android.gms.internal.ads;

import java.io.IOException;
public final class zzkp {
    private final zzpk zzapo = new zzpk(8);
    private int zzarh;

    private final long zzc(zzjy zzjy) throws IOException, InterruptedException {
        int i = 0;
        zzjy.zza(this.zzapo.data, 0, 1);
        int i2 = this.zzapo.data[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = i2 & (~i3);
        zzjy.zza(this.zzapo.data, 1, i4);
        while (i < i4) {
            i++;
            i5 = (this.zzapo.data[i] & 255) + (i5 << 8);
        }
        this.zzarh = i4 + 1 + this.zzarh;
        return (long) i5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0098, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(com.google.android.gms.internal.ads.zzjy r18) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            long r2 = r18.getLength()
            r4 = 1024(0x400, double:5.06E-321)
            r6 = -1
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0016
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r4 = r2
        L_0x0016:
            int r5 = (int) r4
            com.google.android.gms.internal.ads.zzpk r4 = r0.zzapo
            byte[] r4 = r4.data
            r6 = 0
            r7 = 4
            r1.zza(r4, r6, r7)
            com.google.android.gms.internal.ads.zzpk r4 = r0.zzapo
            long r9 = r4.zzja()
            r0.zzarh = r7
        L_0x0028:
            r11 = 440786851(0x1a45dfa3, double:2.1777764E-315)
            r4 = 1
            int r7 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r7 == 0) goto L_0x0050
            int r7 = r0.zzarh
            int r7 = r7 + r4
            r0.zzarh = r7
            if (r7 != r5) goto L_0x0038
            return r6
        L_0x0038:
            com.google.android.gms.internal.ads.zzpk r7 = r0.zzapo
            byte[] r7 = r7.data
            r1.zza(r7, r6, r4)
            r4 = 8
            long r9 = r9 << r4
            r11 = -256(0xffffffffffffff00, double:NaN)
            long r9 = r9 & r11
            com.google.android.gms.internal.ads.zzpk r4 = r0.zzapo
            byte[] r4 = r4.data
            byte r4 = r4[r6]
            r4 = r4 & 255(0xff, float:3.57E-43)
            long r11 = (long) r4
            long r9 = r9 | r11
            goto L_0x0028
        L_0x0050:
            long r9 = r17.zzc(r18)
            int r5 = r0.zzarh
            long r11 = (long) r5
            r13 = -9223372036854775808
            int r5 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r5 == 0) goto L_0x009f
            if (r8 == 0) goto L_0x0066
            long r7 = r11 + r9
            int r5 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r5 < 0) goto L_0x0066
            goto L_0x009f
        L_0x0066:
            int r2 = r0.zzarh
            long r7 = (long) r2
            long r15 = r11 + r9
            int r3 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r3 >= 0) goto L_0x0099
            long r2 = r17.zzc(r18)
            int r5 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r5 != 0) goto L_0x0078
            return r6
        L_0x0078:
            long r2 = r17.zzc(r18)
            r7 = 0
            int r5 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r5 < 0) goto L_0x0098
            r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r15 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r15 <= 0) goto L_0x008a
            goto L_0x0098
        L_0x008a:
            if (r5 == 0) goto L_0x0066
            int r5 = (int) r2
            r1.zzaj(r5)
            int r5 = r0.zzarh
            long r7 = (long) r5
            long r7 = r7 + r2
            int r2 = (int) r7
            r0.zzarh = r2
            goto L_0x0066
        L_0x0098:
            return r6
        L_0x0099:
            long r1 = (long) r2
            int r3 = (r1 > r15 ? 1 : (r1 == r15 ? 0 : -1))
            if (r3 != 0) goto L_0x009f
            return r4
        L_0x009f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkp.zza(com.google.android.gms.internal.ads.zzjy):boolean");
    }
}
