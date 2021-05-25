package org.spongycastle.crypto.engines;

import a2.b.a.a.a;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.util.DigestFactory;
import org.spongycastle.util.Arrays;
public class DESedeWrapEngine implements Wrapper {
    public static final byte[] h = {74, -35, -94, 44, 121, -24, 33, 5};
    public CBCBlockCipher a;
    public KeyParameter b;
    public ParametersWithIV c;
    public byte[] d;
    public boolean e;
    public Digest f = DigestFactory.createSHA1();
    public byte[] g = new byte[20];

    public static byte[] b(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        while (i < bArr.length) {
            int i2 = i + 1;
            bArr2[i] = bArr[bArr.length - i2];
            i = i2;
        }
        return bArr2;
    }

    public final byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        this.f.update(bArr, 0, bArr.length);
        this.f.doFinal(this.g, 0);
        System.arraycopy(this.g, 0, bArr2, 0, 8);
        return bArr2;
    }

    @Override // org.spongycastle.crypto.Wrapper
    public String getAlgorithmName() {
        return "DESede";
    }

    @Override // org.spongycastle.crypto.Wrapper
    public void init(boolean z, CipherParameters cipherParameters) {
        SecureRandom secureRandom;
        this.e = z;
        this.a = new CBCBlockCipher(new DESedeEngine());
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            CipherParameters parameters = parametersWithRandom.getParameters();
            SecureRandom random = parametersWithRandom.getRandom();
            cipherParameters = parameters;
            secureRandom = random;
        } else {
            secureRandom = new SecureRandom();
        }
        if (cipherParameters instanceof KeyParameter) {
            this.b = (KeyParameter) cipherParameters;
            if (this.e) {
                byte[] bArr = new byte[8];
                this.d = bArr;
                secureRandom.nextBytes(bArr);
                this.c = new ParametersWithIV(this.b, this.d);
            }
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.c = parametersWithIV;
            this.d = parametersWithIV.getIV();
            this.b = (KeyParameter) this.c.getParameters();
            if (this.e) {
                byte[] bArr2 = this.d;
                if (bArr2 == null || bArr2.length != 8) {
                    throw new IllegalArgumentException("IV is not 8 octets");
                }
                return;
            }
            throw new IllegalArgumentException("You should not supply an IV for unwrapping");
        }
    }

    @Override // org.spongycastle.crypto.Wrapper
    public byte[] unwrap(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        if (this.e) {
            throw new IllegalStateException("Not set for unwrapping");
        } else if (bArr != null) {
            int blockSize = this.a.getBlockSize();
            if (i2 % blockSize == 0) {
                this.a.init(false, new ParametersWithIV(this.b, h));
                byte[] bArr2 = new byte[i2];
                for (int i3 = 0; i3 != i2; i3 += blockSize) {
                    this.a.processBlock(bArr, i + i3, bArr2, i3);
                }
                byte[] b2 = b(bArr2);
                byte[] bArr3 = new byte[8];
                this.d = bArr3;
                int length = b2.length - 8;
                byte[] bArr4 = new byte[length];
                System.arraycopy(b2, 0, bArr3, 0, 8);
                System.arraycopy(b2, 8, bArr4, 0, b2.length - 8);
                ParametersWithIV parametersWithIV = new ParametersWithIV(this.b, this.d);
                this.c = parametersWithIV;
                this.a.init(false, parametersWithIV);
                byte[] bArr5 = new byte[length];
                for (int i4 = 0; i4 != length; i4 += blockSize) {
                    this.a.processBlock(bArr4, i4, bArr5, i4);
                }
                int i5 = length - 8;
                byte[] bArr6 = new byte[i5];
                byte[] bArr7 = new byte[8];
                System.arraycopy(bArr5, 0, bArr6, 0, i5);
                System.arraycopy(bArr5, i5, bArr7, 0, 8);
                if (Arrays.constantTimeAreEqual(a(bArr6), bArr7)) {
                    return bArr6;
                }
                throw new InvalidCipherTextException("Checksum inside ciphertext is corrupted");
            }
            throw new InvalidCipherTextException(a.M2("Ciphertext not multiple of ", blockSize));
        } else {
            throw new InvalidCipherTextException("Null pointer as ciphertext");
        }
    }

    @Override // org.spongycastle.crypto.Wrapper
    public byte[] wrap(byte[] bArr, int i, int i2) {
        if (this.e) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            byte[] a3 = a(bArr2);
            int length = a3.length + i2;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr2, 0, bArr3, 0, i2);
            System.arraycopy(a3, 0, bArr3, i2, a3.length);
            int blockSize = this.a.getBlockSize();
            if (length % blockSize == 0) {
                this.a.init(true, this.c);
                byte[] bArr4 = new byte[length];
                for (int i3 = 0; i3 != length; i3 += blockSize) {
                    this.a.processBlock(bArr3, i3, bArr4, i3);
                }
                byte[] bArr5 = this.d;
                byte[] bArr6 = new byte[(bArr5.length + length)];
                System.arraycopy(bArr5, 0, bArr6, 0, bArr5.length);
                System.arraycopy(bArr4, 0, bArr6, this.d.length, length);
                byte[] b2 = b(bArr6);
                this.a.init(true, new ParametersWithIV(this.b, h));
                for (int i4 = 0; i4 != b2.length; i4 += blockSize) {
                    this.a.processBlock(b2, i4, b2, i4);
                }
                return b2;
            }
            throw new IllegalStateException("Not multiple of block length");
        }
        throw new IllegalStateException("Not initialized for wrapping");
    }
}
