package org.spongycastle.crypto.prng;

import android.support.v4.media.session.PlaybackStateCompat;
import org.spongycastle.crypto.BlockCipher;
public class X931RNG {
    public final BlockCipher a;
    public final EntropySource b;
    public final byte[] c;
    public final byte[] d;
    public final byte[] e;
    public byte[] f;
    public long g = 1;

    public X931RNG(BlockCipher blockCipher, byte[] bArr, EntropySource entropySource) {
        this.a = blockCipher;
        this.b = entropySource;
        byte[] bArr2 = new byte[blockCipher.getBlockSize()];
        this.c = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.d = new byte[blockCipher.getBlockSize()];
        this.e = new byte[blockCipher.getBlockSize()];
    }

    public int a(byte[] bArr, boolean z) {
        boolean z2 = true;
        if (this.e.length == 8) {
            if (this.g > PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) {
                return -1;
            }
            if (bArr == null || bArr.length <= 512) {
                z2 = false;
            }
            if (z2) {
                throw new IllegalArgumentException("Number of bits per request limited to 4096");
            }
        } else if (this.g > 8388608) {
            return -1;
        } else {
            if (bArr == null || bArr.length <= 32768) {
                z2 = false;
            }
            if (z2) {
                throw new IllegalArgumentException("Number of bits per request limited to 262144");
            }
        }
        if (z || this.f == null) {
            byte[] entropy = this.b.getEntropy();
            this.f = entropy;
            if (entropy.length != this.a.getBlockSize()) {
                throw new IllegalStateException("Insufficient entropy returned");
            }
        }
        int length = bArr.length / this.e.length;
        for (int i = 0; i < length; i++) {
            this.a.processBlock(this.c, 0, this.d, 0);
            c(this.e, this.d, this.f);
            c(this.f, this.e, this.d);
            byte[] bArr2 = this.e;
            System.arraycopy(bArr2, 0, bArr, bArr2.length * i, bArr2.length);
            b(this.c);
        }
        int length2 = bArr.length - (this.e.length * length);
        if (length2 > 0) {
            this.a.processBlock(this.c, 0, this.d, 0);
            c(this.e, this.d, this.f);
            c(this.f, this.e, this.d);
            byte[] bArr3 = this.e;
            System.arraycopy(bArr3, 0, bArr, length * bArr3.length, length2);
            b(this.c);
        }
        this.g++;
        return bArr.length;
    }

    public final void b(byte[] bArr) {
        for (int length = bArr.length - 1; length >= 0; length--) {
            byte b2 = (byte) (bArr[length] + 1);
            bArr[length] = b2;
            if (b2 != 0) {
                return;
            }
        }
    }

    public final void c(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = (byte) (bArr2[i] ^ bArr3[i]);
        }
        this.a.processBlock(bArr, 0, bArr, 0);
    }
}
