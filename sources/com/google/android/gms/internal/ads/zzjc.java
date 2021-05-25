package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
public final class zzjc implements zzie {
    private int zzahi = -1;
    private int zzajw = 0;
    private ByteBuffer zzalb;
    private int zzame = -1;
    private ByteBuffer zzami;
    private boolean zzamj;

    public zzjc() {
        ByteBuffer byteBuffer = zzie.zzaiu;
        this.zzami = byteBuffer;
        this.zzalb = byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final void flush() {
        this.zzalb = zzie.zzaiu;
        this.zzamj = false;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final boolean isActive() {
        int i = this.zzajw;
        return (i == 0 || i == 2) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final void reset() {
        flush();
        this.zzami = zzie.zzaiu;
        this.zzame = -1;
        this.zzahi = -1;
        this.zzajw = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final boolean zzb(int i, int i2, int i3) throws zzih {
        if (i3 != 3 && i3 != 2 && i3 != Integer.MIN_VALUE && i3 != 1073741824) {
            throw new zzih(i, i2, i3);
        } else if (this.zzame == i && this.zzahi == i2 && this.zzajw == i3) {
            return false;
        } else {
            this.zzame = i;
            this.zzahi = i2;
            this.zzajw = i3;
            if (i3 != 2) {
                return true;
            }
            this.zzami = zzie.zzaiu;
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final boolean zzfc() {
        return this.zzamj && this.zzalb == zzie.zzaiu;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final int zzfh() {
        return this.zzahi;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final int zzfi() {
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final void zzfj() {
        this.zzamj = true;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final ByteBuffer zzfk() {
        ByteBuffer byteBuffer = this.zzalb;
        this.zzalb = zzie.zzaiu;
        return byteBuffer;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081 A[LOOP:2: B:23:0x0081->B:24:0x0083, LOOP_START, PHI: r0 
      PHI: (r0v2 int) = (r0v0 int), (r0v3 int) binds: [B:14:0x0041, B:24:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.ads.zzie
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzn(java.nio.ByteBuffer r8) {
        /*
            r7 = this;
            int r0 = r8.position()
            int r1 = r8.limit()
            int r2 = r1 - r0
            int r3 = r7.zzajw
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 3
            if (r3 == r5) goto L_0x0020
            if (r3 == r6) goto L_0x0021
            if (r3 != r4) goto L_0x001a
            int r2 = r2 / 2
            goto L_0x0023
        L_0x001a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L_0x0020:
            int r2 = r2 / r6
        L_0x0021:
            int r2 = r2 << 1
        L_0x0023:
            java.nio.ByteBuffer r3 = r7.zzami
            int r3 = r3.capacity()
            if (r3 >= r2) goto L_0x003a
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocateDirect(r2)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r2 = r2.order(r3)
            r7.zzami = r2
            goto L_0x003f
        L_0x003a:
            java.nio.ByteBuffer r2 = r7.zzami
            r2.clear()
        L_0x003f:
            int r2 = r7.zzajw
            if (r2 == r5) goto L_0x0081
            if (r2 == r6) goto L_0x0068
            if (r2 != r4) goto L_0x0062
        L_0x0047:
            if (r0 >= r1) goto L_0x009c
            java.nio.ByteBuffer r2 = r7.zzami
            int r3 = r0 + 2
            byte r3 = r8.get(r3)
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.zzami
            int r3 = r0 + 3
            byte r3 = r8.get(r3)
            r2.put(r3)
            int r0 = r0 + 4
            goto L_0x0047
        L_0x0062:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L_0x0068:
            if (r0 >= r1) goto L_0x009c
            java.nio.ByteBuffer r2 = r7.zzami
            r3 = 0
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.zzami
            byte r3 = r8.get(r0)
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 + -128
            byte r3 = (byte) r3
            r2.put(r3)
            int r0 = r0 + 1
            goto L_0x0068
        L_0x0081:
            if (r0 >= r1) goto L_0x009c
            java.nio.ByteBuffer r2 = r7.zzami
            int r3 = r0 + 1
            byte r3 = r8.get(r3)
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.zzami
            int r3 = r0 + 2
            byte r3 = r8.get(r3)
            r2.put(r3)
            int r0 = r0 + 3
            goto L_0x0081
        L_0x009c:
            int r0 = r8.limit()
            r8.position(r0)
            java.nio.ByteBuffer r8 = r7.zzami
            r8.flip()
            java.nio.ByteBuffer r8 = r7.zzami
            r7.zzalb = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjc.zzn(java.nio.ByteBuffer):void");
    }
}
