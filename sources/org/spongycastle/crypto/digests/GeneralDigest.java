package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;
public abstract class GeneralDigest implements ExtendedDigest, Memoable {
    public final byte[] a;
    public int b;
    public long c;

    public GeneralDigest() {
        this.a = new byte[4];
        this.b = 0;
    }

    public void copyIn(GeneralDigest generalDigest) {
        byte[] bArr = generalDigest.a;
        System.arraycopy(bArr, 0, this.a, 0, bArr.length);
        this.b = generalDigest.b;
        this.c = generalDigest.c;
    }

    public void finish() {
        long j = this.c << 3;
        update(Byte.MIN_VALUE);
        while (this.b != 0) {
            update((byte) 0);
        }
        processLength(j);
        processBlock();
    }

    @Override // org.spongycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return 64;
    }

    public void populateState(byte[] bArr) {
        System.arraycopy(this.a, 0, bArr, 0, this.b);
        Pack.intToBigEndian(this.b, bArr, 4);
        Pack.longToBigEndian(this.c, bArr, 8);
    }

    public abstract void processBlock();

    public abstract void processLength(long j);

    public abstract void processWord(byte[] bArr, int i);

    @Override // org.spongycastle.crypto.Digest
    public void reset() {
        this.c = 0;
        this.b = 0;
        int i = 0;
        while (true) {
            byte[] bArr = this.a;
            if (i < bArr.length) {
                bArr[i] = 0;
                i++;
            } else {
                return;
            }
        }
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte b2) {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        bArr[i] = b2;
        if (i2 == bArr.length) {
            processWord(bArr, 0);
            this.b = 0;
        }
        this.c++;
    }

    public GeneralDigest(GeneralDigest generalDigest) {
        this.a = new byte[4];
        copyIn(generalDigest);
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte[] bArr, int i, int i2) {
        int i3 = 0;
        int max = Math.max(0, i2);
        if (this.b != 0) {
            int i4 = 0;
            while (true) {
                if (i4 >= max) {
                    i3 = i4;
                    break;
                }
                byte[] bArr2 = this.a;
                int i5 = this.b;
                int i6 = i5 + 1;
                this.b = i6;
                int i7 = i4 + 1;
                bArr2[i5] = bArr[i4 + i];
                if (i6 == 4) {
                    processWord(bArr2, 0);
                    this.b = 0;
                    i3 = i7;
                    break;
                }
                i4 = i7;
            }
        }
        int i8 = ((max - i3) & -4) + i3;
        while (i3 < i8) {
            processWord(bArr, i + i3);
            i3 += 4;
        }
        while (i3 < max) {
            byte[] bArr3 = this.a;
            int i9 = this.b;
            this.b = i9 + 1;
            bArr3[i9] = bArr[i3 + i];
            i3++;
        }
        this.c += (long) max;
    }

    public GeneralDigest(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        this.a = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.b = Pack.bigEndianToInt(bArr, 4);
        this.c = Pack.bigEndianToLong(bArr, 8);
    }
}
