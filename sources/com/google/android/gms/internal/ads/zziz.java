package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
public final class zziz implements zzie {
    private int zzahi = -1;
    private ByteBuffer zzalb;
    private int zzame = -1;
    private int[] zzamf;
    private boolean zzamg;
    private int[] zzamh;
    private ByteBuffer zzami;
    private boolean zzamj;

    public zziz() {
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
        return this.zzamg;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final void reset() {
        flush();
        this.zzami = zzie.zzaiu;
        this.zzahi = -1;
        this.zzame = -1;
        this.zzamh = null;
        this.zzamg = false;
    }

    public final void zzb(int[] iArr) {
        this.zzamf = iArr;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final boolean zzfc() {
        return this.zzamj && this.zzalb == zzie.zzaiu;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final int zzfh() {
        int[] iArr = this.zzamh;
        return iArr == null ? this.zzahi : iArr.length;
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

    @Override // com.google.android.gms.internal.ads.zzie
    public final void zzn(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = (((limit - position) / (this.zzahi * 2)) * this.zzamh.length) << 1;
        if (this.zzami.capacity() < length) {
            this.zzami = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.zzami.clear();
        }
        while (position < limit) {
            for (int i : this.zzamh) {
                this.zzami.putShort(byteBuffer.getShort((i * 2) + position));
            }
            position += this.zzahi << 1;
        }
        byteBuffer.position(limit);
        this.zzami.flip();
        this.zzalb = this.zzami;
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final boolean zzb(int i, int i2, int i3) throws zzih {
        boolean z = !Arrays.equals(this.zzamf, this.zzamh);
        int[] iArr = this.zzamf;
        this.zzamh = iArr;
        if (iArr == null) {
            this.zzamg = false;
            return z;
        } else if (i3 != 2) {
            throw new zzih(i, i2, i3);
        } else if (!z && this.zzame == i && this.zzahi == i2) {
            return false;
        } else {
            this.zzame = i;
            this.zzahi = i2;
            this.zzamg = i2 != iArr.length;
            int i4 = 0;
            while (true) {
                int[] iArr2 = this.zzamh;
                if (i4 >= iArr2.length) {
                    return true;
                }
                int i5 = iArr2[i4];
                if (i5 < i2) {
                    this.zzamg = (i5 != i4) | this.zzamg;
                    i4++;
                } else {
                    throw new zzih(i, i2, i3);
                }
            }
        }
    }
}
