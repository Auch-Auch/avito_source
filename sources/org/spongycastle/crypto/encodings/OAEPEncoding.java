package org.spongycastle.crypto.encodings;

import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.util.DigestFactory;
import org.spongycastle.util.Arrays;
public class OAEPEncoding implements AsymmetricBlockCipher {
    public byte[] a;
    public Digest b;
    public AsymmetricBlockCipher c;
    public SecureRandom d;
    public boolean e;

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher) {
        this(asymmetricBlockCipher, DigestFactory.createSHA1(), null);
    }

    public final void a(int i, byte[] bArr) {
        bArr[0] = (byte) (i >>> 24);
        bArr[1] = (byte) (i >>> 16);
        bArr[2] = (byte) (i >>> 8);
        bArr[3] = (byte) (i >>> 0);
    }

    public final byte[] b(byte[] bArr, int i, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        int digestSize = this.b.getDigestSize();
        byte[] bArr3 = new byte[digestSize];
        byte[] bArr4 = new byte[4];
        this.b.reset();
        int i4 = 0;
        while (i4 < i3 / digestSize) {
            a(i4, bArr4);
            this.b.update(bArr, i, i2);
            this.b.update(bArr4, 0, 4);
            this.b.doFinal(bArr3, 0);
            System.arraycopy(bArr3, 0, bArr2, i4 * digestSize, digestSize);
            i4++;
        }
        int i5 = digestSize * i4;
        if (i5 < i3) {
            a(i4, bArr4);
            this.b.update(bArr, i, i2);
            this.b.update(bArr4, 0, 4);
            this.b.doFinal(bArr3, 0);
            System.arraycopy(bArr3, 0, bArr2, i5, i3 - i5);
        }
        return bArr2;
    }

    public byte[] decodeBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        byte[] bArr2;
        byte[] bArr3;
        byte[] processBlock = this.c.processBlock(bArr, i, i2);
        int outputBlockSize = this.c.getOutputBlockSize();
        byte[] bArr4 = new byte[outputBlockSize];
        System.arraycopy(processBlock, 0, bArr4, outputBlockSize - processBlock.length, processBlock.length);
        byte[] bArr5 = this.a;
        boolean z = outputBlockSize < (bArr5.length * 2) + 1;
        byte[] b2 = b(bArr4, bArr5.length, outputBlockSize - bArr5.length, bArr5.length);
        int i3 = 0;
        while (true) {
            bArr2 = this.a;
            if (i3 == bArr2.length) {
                break;
            }
            bArr4[i3] = (byte) (bArr4[i3] ^ b2[i3]);
            i3++;
        }
        byte[] b3 = b(bArr4, 0, bArr2.length, outputBlockSize - bArr2.length);
        for (int length = this.a.length; length != outputBlockSize; length++) {
            bArr4[length] = (byte) (bArr4[length] ^ b3[length - this.a.length]);
        }
        int i4 = 0;
        boolean z2 = false;
        while (true) {
            bArr3 = this.a;
            if (i4 == bArr3.length) {
                break;
            }
            if (bArr3[i4] != bArr4[bArr3.length + i4]) {
                z2 = true;
            }
            i4++;
        }
        int i5 = outputBlockSize;
        for (int length2 = bArr3.length * 2; length2 != outputBlockSize; length2++) {
            if ((bArr4[length2] != 0) && (i5 == outputBlockSize)) {
                i5 = length2;
            }
        }
        boolean z3 = i5 > outputBlockSize + -1;
        boolean z4 = bArr4[i5] != 1;
        int i6 = i5 + 1;
        if ((!z3 && !z4) && (!z && !z2)) {
            int i7 = outputBlockSize - i6;
            byte[] bArr6 = new byte[i7];
            System.arraycopy(bArr4, i6, bArr6, 0, i7);
            return bArr6;
        }
        Arrays.fill(bArr4, (byte) 0);
        throw new InvalidCipherTextException("data wrong");
    }

    public byte[] encodeBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        if (i2 <= getInputBlockSize()) {
            int length = (this.a.length * 2) + getInputBlockSize() + 1;
            byte[] bArr2 = new byte[length];
            int i3 = length - i2;
            System.arraycopy(bArr, i, bArr2, i3, i2);
            bArr2[i3 - 1] = 1;
            byte[] bArr3 = this.a;
            System.arraycopy(bArr3, 0, bArr2, bArr3.length, bArr3.length);
            int length2 = this.a.length;
            byte[] bArr4 = new byte[length2];
            this.d.nextBytes(bArr4);
            byte[] b2 = b(bArr4, 0, length2, length - this.a.length);
            for (int length3 = this.a.length; length3 != length; length3++) {
                bArr2[length3] = (byte) (bArr2[length3] ^ b2[length3 - this.a.length]);
            }
            System.arraycopy(bArr4, 0, bArr2, 0, this.a.length);
            byte[] bArr5 = this.a;
            byte[] b3 = b(bArr2, bArr5.length, length - bArr5.length, bArr5.length);
            for (int i4 = 0; i4 != this.a.length; i4++) {
                bArr2[i4] = (byte) (bArr2[i4] ^ b3[i4]);
            }
            return this.c.processBlock(bArr2, 0, length);
        }
        throw new DataLengthException("input data too long");
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        int inputBlockSize = this.c.getInputBlockSize();
        return this.e ? (inputBlockSize - 1) - (this.a.length * 2) : inputBlockSize;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        int outputBlockSize = this.c.getOutputBlockSize();
        if (this.e) {
            return outputBlockSize;
        }
        return (outputBlockSize - 1) - (this.a.length * 2);
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.c;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            this.d = ((ParametersWithRandom) cipherParameters).getRandom();
        } else {
            this.d = new SecureRandom();
        }
        this.c.init(z, cipherParameters);
        this.e = z;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        if (this.e) {
            return encodeBlock(bArr, i, i2);
        }
        return decodeBlock(bArr, i, i2);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest) {
        this(asymmetricBlockCipher, digest, null);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, byte[] bArr) {
        this(asymmetricBlockCipher, digest, digest, bArr);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, Digest digest2, byte[] bArr) {
        this.c = asymmetricBlockCipher;
        this.b = digest2;
        this.a = new byte[digest.getDigestSize()];
        digest.reset();
        if (bArr != null) {
            digest.update(bArr, 0, bArr.length);
        }
        digest.doFinal(this.a, 0);
    }
}
