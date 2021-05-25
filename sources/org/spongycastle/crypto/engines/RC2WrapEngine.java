package org.spongycastle.crypto.engines;

import a2.b.a.a.a;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.util.DigestFactory;
import org.spongycastle.util.Arrays;
public class RC2WrapEngine implements Wrapper {
    public static final byte[] i = {74, -35, -94, 44, 121, -24, 33, 5};
    public CBCBlockCipher a;
    public CipherParameters b;
    public ParametersWithIV c;
    public byte[] d;
    public boolean e;
    public SecureRandom f;
    public Digest g = DigestFactory.createSHA1();
    public byte[] h = new byte[20];

    public final byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        this.g.update(bArr, 0, bArr.length);
        this.g.doFinal(this.h, 0);
        System.arraycopy(this.h, 0, bArr2, 0, 8);
        return bArr2;
    }

    @Override // org.spongycastle.crypto.Wrapper
    public String getAlgorithmName() {
        return "RC2";
    }

    @Override // org.spongycastle.crypto.Wrapper
    public void init(boolean z, CipherParameters cipherParameters) {
        this.e = z;
        this.a = new CBCBlockCipher(new RC2Engine());
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f = parametersWithRandom.getRandom();
            cipherParameters = parametersWithRandom.getParameters();
        } else {
            this.f = new SecureRandom();
        }
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.c = parametersWithIV;
            this.d = parametersWithIV.getIV();
            this.b = this.c.getParameters();
            if (this.e) {
                byte[] bArr = this.d;
                if (bArr == null || bArr.length != 8) {
                    throw new IllegalArgumentException("IV is not 8 octets");
                }
                return;
            }
            throw new IllegalArgumentException("You should not supply an IV for unwrapping");
        }
        this.b = cipherParameters;
        if (this.e) {
            byte[] bArr2 = new byte[8];
            this.d = bArr2;
            this.f.nextBytes(bArr2);
            this.c = new ParametersWithIV(this.b, this.d);
        }
    }

    @Override // org.spongycastle.crypto.Wrapper
    public byte[] unwrap(byte[] bArr, int i2, int i3) throws InvalidCipherTextException {
        if (this.e) {
            throw new IllegalStateException("Not set for unwrapping");
        } else if (bArr == null) {
            throw new InvalidCipherTextException("Null pointer as ciphertext");
        } else if (i3 % this.a.getBlockSize() == 0) {
            this.a.init(false, new ParametersWithIV(this.b, i));
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            for (int i4 = 0; i4 < i3 / this.a.getBlockSize(); i4++) {
                int blockSize = this.a.getBlockSize() * i4;
                this.a.processBlock(bArr2, blockSize, bArr2, blockSize);
            }
            byte[] bArr3 = new byte[i3];
            int i5 = 0;
            while (i5 < i3) {
                int i6 = i5 + 1;
                bArr3[i5] = bArr2[i3 - i6];
                i5 = i6;
            }
            byte[] bArr4 = new byte[8];
            this.d = bArr4;
            int i7 = i3 - 8;
            byte[] bArr5 = new byte[i7];
            System.arraycopy(bArr3, 0, bArr4, 0, 8);
            System.arraycopy(bArr3, 8, bArr5, 0, i7);
            ParametersWithIV parametersWithIV = new ParametersWithIV(this.b, this.d);
            this.c = parametersWithIV;
            this.a.init(false, parametersWithIV);
            byte[] bArr6 = new byte[i7];
            System.arraycopy(bArr5, 0, bArr6, 0, i7);
            for (int i8 = 0; i8 < i7 / this.a.getBlockSize(); i8++) {
                int blockSize2 = this.a.getBlockSize() * i8;
                this.a.processBlock(bArr6, blockSize2, bArr6, blockSize2);
            }
            int i9 = i7 - 8;
            byte[] bArr7 = new byte[i9];
            byte[] bArr8 = new byte[8];
            System.arraycopy(bArr6, 0, bArr7, 0, i9);
            System.arraycopy(bArr6, i9, bArr8, 0, 8);
            if (!Arrays.constantTimeAreEqual(a(bArr7), bArr8)) {
                throw new InvalidCipherTextException("Checksum inside ciphertext is corrupted");
            } else if (i9 - ((bArr7[0] & 255) + 1) <= 7) {
                byte b2 = bArr7[0];
                byte[] bArr9 = new byte[b2];
                System.arraycopy(bArr7, 1, bArr9, 0, b2);
                return bArr9;
            } else {
                StringBuilder L = a.L("too many pad bytes (");
                L.append(i9 - ((bArr7[0] & 255) + 1));
                L.append(")");
                throw new InvalidCipherTextException(L.toString());
            }
        } else {
            StringBuilder L2 = a.L("Ciphertext not multiple of ");
            L2.append(this.a.getBlockSize());
            throw new InvalidCipherTextException(L2.toString());
        }
    }

    @Override // org.spongycastle.crypto.Wrapper
    public byte[] wrap(byte[] bArr, int i2, int i3) {
        if (this.e) {
            int i4 = i3 + 1;
            int i5 = i4 % 8;
            int i6 = i5 != 0 ? (8 - i5) + i4 : i4;
            byte[] bArr2 = new byte[i6];
            bArr2[0] = (byte) i3;
            System.arraycopy(bArr, i2, bArr2, 1, i3);
            int i7 = (i6 - i3) - 1;
            byte[] bArr3 = new byte[i7];
            if (i7 > 0) {
                this.f.nextBytes(bArr3);
                System.arraycopy(bArr3, 0, bArr2, i4, i7);
            }
            byte[] a3 = a(bArr2);
            int length = a3.length + i6;
            byte[] bArr4 = new byte[length];
            System.arraycopy(bArr2, 0, bArr4, 0, i6);
            System.arraycopy(a3, 0, bArr4, i6, a3.length);
            byte[] bArr5 = new byte[length];
            System.arraycopy(bArr4, 0, bArr5, 0, length);
            int blockSize = length / this.a.getBlockSize();
            if (length % this.a.getBlockSize() == 0) {
                this.a.init(true, this.c);
                for (int i8 = 0; i8 < blockSize; i8++) {
                    int blockSize2 = this.a.getBlockSize() * i8;
                    this.a.processBlock(bArr5, blockSize2, bArr5, blockSize2);
                }
                byte[] bArr6 = this.d;
                int length2 = bArr6.length + length;
                byte[] bArr7 = new byte[length2];
                System.arraycopy(bArr6, 0, bArr7, 0, bArr6.length);
                System.arraycopy(bArr5, 0, bArr7, this.d.length, length);
                byte[] bArr8 = new byte[length2];
                int i9 = 0;
                while (i9 < length2) {
                    int i10 = i9 + 1;
                    bArr8[i9] = bArr7[length2 - i10];
                    i9 = i10;
                }
                this.a.init(true, new ParametersWithIV(this.b, i));
                for (int i11 = 0; i11 < blockSize + 1; i11++) {
                    int blockSize3 = this.a.getBlockSize() * i11;
                    this.a.processBlock(bArr8, blockSize3, bArr8, blockSize3);
                }
                return bArr8;
            }
            throw new IllegalStateException("Not multiple of block length");
        }
        throw new IllegalStateException("Not initialized for wrapping");
    }
}
