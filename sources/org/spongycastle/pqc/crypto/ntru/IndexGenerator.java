package org.spongycastle.pqc.crypto.ntru;

import java.util.Objects;
import org.spongycastle.crypto.Digest;
import org.spongycastle.util.Arrays;
public class IndexGenerator {
    public byte[] a;
    public int b;
    public int c;
    public int d;
    public int e = 0;
    public int f = 0;
    public BitString g;
    public int h = 0;
    public boolean i;
    public Digest j;
    public int k;

    public static class BitString {
        public byte[] a = new byte[4];
        public int b;
        public int c;

        public void appendBits(byte b2) {
            int i = this.b;
            byte[] bArr = this.a;
            if (i == bArr.length) {
                int length = bArr.length * 2;
                byte[] bArr2 = new byte[length];
                if (length >= bArr.length) {
                    length = bArr.length;
                }
                System.arraycopy(bArr, 0, bArr2, 0, length);
                this.a = bArr2;
            }
            int i2 = this.b;
            if (i2 == 0) {
                this.b = 1;
                this.a[0] = b2;
                this.c = 8;
                return;
            }
            int i3 = this.c;
            if (i3 == 8) {
                byte[] bArr3 = this.a;
                this.b = i2 + 1;
                bArr3[i2] = b2;
                return;
            }
            byte[] bArr4 = this.a;
            int i4 = i2 - 1;
            int i5 = b2 & 255;
            bArr4[i4] = (byte) ((i5 << i3) | bArr4[i4]);
            this.b = i2 + 1;
            bArr4[i2] = (byte) (i5 >> (8 - i3));
        }

        public byte[] getBytes() {
            return Arrays.clone(this.a);
        }

        public int getLeadingAsInt(int i) {
            int i2 = (((this.b - 1) * 8) + this.c) - i;
            int i3 = i2 / 8;
            int i4 = i2 % 8;
            int i5 = (this.a[i3] & 255) >>> i4;
            int i6 = 8 - i4;
            while (true) {
                i3++;
                if (i3 >= this.b) {
                    return i5;
                }
                i5 |= (this.a[i3] & 255) << i6;
                i6 += 8;
            }
        }

        public BitString getTrailing(int i) {
            int i2;
            BitString bitString = new BitString();
            int i3 = (i + 7) / 8;
            bitString.b = i3;
            bitString.a = new byte[i3];
            int i4 = 0;
            while (true) {
                i2 = bitString.b;
                if (i4 >= i2) {
                    break;
                }
                bitString.a[i4] = this.a[i4];
                i4++;
            }
            int i5 = i % 8;
            bitString.c = i5;
            if (i5 == 0) {
                bitString.c = 8;
            } else {
                int i6 = 32 - i5;
                byte[] bArr = bitString.a;
                bArr[i2 - 1] = (byte) ((bArr[i2 - 1] << i6) >>> i6);
            }
            return bitString;
        }
    }

    public IndexGenerator(byte[] bArr, NTRUEncryptionParameters nTRUEncryptionParameters) {
        this.a = bArr;
        this.b = nTRUEncryptionParameters.N;
        this.c = nTRUEncryptionParameters.c;
        this.d = nTRUEncryptionParameters.minCallsR;
        Digest digest = nTRUEncryptionParameters.hashAlg;
        this.j = digest;
        this.k = digest.getDigestSize();
        this.i = false;
    }

    public final void a(BitString bitString, byte[] bArr) {
        Digest digest = this.j;
        byte[] bArr2 = this.a;
        digest.update(bArr2, 0, bArr2.length);
        Digest digest2 = this.j;
        int i2 = this.h;
        digest2.update((byte) (i2 >> 24));
        digest2.update((byte) (i2 >> 16));
        digest2.update((byte) (i2 >> 8));
        digest2.update((byte) i2);
        this.j.doFinal(bArr, 0);
        Objects.requireNonNull(bitString);
        for (int i3 = 0; i3 != bArr.length; i3++) {
            bitString.appendBits(bArr[i3]);
        }
    }
}
