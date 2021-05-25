package com.google.android.exoplayer2.upstream.crypto;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
public final class AesFlushingCipher {
    public final Cipher a;
    public final int b;
    public final byte[] c;
    public final byte[] d;
    public int e;

    public AesFlushingCipher(int i, byte[] bArr, long j, long j2) {
        try {
            Cipher instance = Cipher.getInstance("AES/CTR/NoPadding");
            this.a = instance;
            int blockSize = instance.getBlockSize();
            this.b = blockSize;
            this.c = new byte[blockSize];
            this.d = new byte[blockSize];
            int i2 = (int) (j2 % ((long) blockSize));
            instance.init(i, new SecretKeySpec(bArr, Util.splitAtFirst(instance.getAlgorithm(), "/")[0]), new IvParameterSpec(a(j, j2 / ((long) blockSize))));
            if (i2 != 0) {
                updateInPlace(new byte[i2], 0, i2);
            }
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final byte[] a(long j, long j2) {
        return ByteBuffer.allocate(16).putLong(j).putLong(j2).array();
    }

    public final int b(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        try {
            return this.a.update(bArr, i, i2, bArr2, i3);
        } catch (ShortBufferException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void update(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = i;
        do {
            int i5 = this.e;
            if (i5 > 0) {
                bArr2[i3] = (byte) (bArr[i4] ^ this.d[this.b - i5]);
                i3++;
                i4++;
                this.e = i5 - 1;
                i2--;
            } else {
                int b2 = b(bArr, i4, i2, bArr2, i3);
                if (i2 != b2) {
                    int i6 = i2 - b2;
                    int i7 = 0;
                    boolean z = true;
                    Assertions.checkState(i6 < this.b);
                    int i8 = i3 + b2;
                    int i9 = this.b - i6;
                    this.e = i9;
                    if (b(this.c, 0, i9, this.d, 0) != this.b) {
                        z = false;
                    }
                    Assertions.checkState(z);
                    while (i7 < i6) {
                        bArr2[i8] = this.d[i7];
                        i7++;
                        i8++;
                    }
                    return;
                }
                return;
            }
        } while (i2 != 0);
    }

    public void updateInPlace(byte[] bArr, int i, int i2) {
        update(bArr, i, i2, bArr, i);
    }
}
