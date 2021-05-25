package com.google.android.gms.internal.ads;

import java.io.OutputStream;
import java.util.ArrayList;
public final class zzefo extends OutputStream {
    private static final byte[] zzibj = new byte[0];
    private byte[] buffer = new byte[128];
    private final int zzibk = 128;
    private final ArrayList<zzeff> zzibl = new ArrayList<>();
    private int zzibm;
    private int zzibn;

    public zzefo(int i) {
    }

    private final synchronized int size() {
        return this.zzibm + this.zzibn;
    }

    private final void zzfx(int i) {
        this.zzibl.add(new zzefp(this.buffer));
        int length = this.zzibm + this.buffer.length;
        this.zzibm = length;
        this.buffer = new byte[Math.max(this.zzibk, Math.max(i, length >>> 1))];
        this.zzibn = 0;
    }

    @Override // java.lang.Object
    public final String toString() {
        return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    @Override // java.io.OutputStream
    public final synchronized void write(int i) {
        if (this.zzibn == this.buffer.length) {
            zzfx(1);
        }
        byte[] bArr = this.buffer;
        int i2 = this.zzibn;
        this.zzibn = i2 + 1;
        bArr[i2] = (byte) i;
    }

    public final synchronized zzeff zzbda() {
        int i = this.zzibn;
        byte[] bArr = this.buffer;
        if (i >= bArr.length) {
            this.zzibl.add(new zzefp(this.buffer));
            this.buffer = zzibj;
        } else if (i > 0) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
            this.zzibl.add(new zzefp(bArr2));
        }
        this.zzibm += this.zzibn;
        this.zzibn = 0;
        return zzeff.zzl(this.zzibl);
    }

    @Override // java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.buffer;
        int length = bArr2.length;
        int i3 = this.zzibn;
        if (i2 <= length - i3) {
            System.arraycopy(bArr, i, bArr2, i3, i2);
            this.zzibn += i2;
            return;
        }
        int length2 = bArr2.length - i3;
        System.arraycopy(bArr, i, bArr2, i3, length2);
        int i4 = i2 - length2;
        zzfx(i4);
        System.arraycopy(bArr, i + length2, this.buffer, 0, i4);
        this.zzibn = i4;
    }
}
