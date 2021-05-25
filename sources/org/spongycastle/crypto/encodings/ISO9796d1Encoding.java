package org.spongycastle.crypto.encodings;

import a2.b.a.a.a;
import com.google.common.base.Ascii;
import java.math.BigInteger;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSAKeyParameters;
public class ISO9796d1Encoding implements AsymmetricBlockCipher {
    public static final BigInteger f = BigInteger.valueOf(16);
    public static final BigInteger g = BigInteger.valueOf(6);
    public static byte[] h = {Ascii.SO, 3, 5, 8, 9, 4, 2, Ascii.SI, 0, Ascii.CR, Ascii.VT, 6, 7, 10, Ascii.FF, 1};
    public static byte[] i = {8, Ascii.SI, 6, 1, 5, 2, Ascii.VT, Ascii.FF, 3, 4, Ascii.CR, 10, Ascii.SO, 9, 0, 7};
    public AsymmetricBlockCipher a;
    public boolean b;
    public int c;
    public int d = 0;
    public BigInteger e;

    public ISO9796d1Encoding(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.a = asymmetricBlockCipher;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        int inputBlockSize = this.a.getInputBlockSize();
        return this.b ? (inputBlockSize + 1) / 2 : inputBlockSize;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        int outputBlockSize = this.a.getOutputBlockSize();
        if (this.b) {
            return outputBlockSize;
        }
        return (outputBlockSize + 1) / 2;
    }

    public int getPadBits() {
        return this.d;
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.a;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        RSAKeyParameters rSAKeyParameters;
        if (cipherParameters instanceof ParametersWithRandom) {
            rSAKeyParameters = (RSAKeyParameters) ((ParametersWithRandom) cipherParameters).getParameters();
        } else {
            rSAKeyParameters = (RSAKeyParameters) cipherParameters;
        }
        this.a.init(z, cipherParameters);
        BigInteger modulus = rSAKeyParameters.getModulus();
        this.e = modulus;
        this.c = modulus.bitLength();
        this.b = z;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] bArr, int i2, int i3) throws InvalidCipherTextException {
        int i4 = 0;
        if (this.b) {
            int i5 = this.c;
            int i6 = (i5 + 7) / 8;
            byte[] bArr2 = new byte[i6];
            int i7 = this.d + 1;
            int i8 = (i5 + 13) / 16;
            int i9 = 0;
            while (i9 < i8) {
                if (i9 > i8 - i3) {
                    int i10 = i8 - i9;
                    System.arraycopy(bArr, (i2 + i3) - i10, bArr2, i6 - i8, i10);
                } else {
                    System.arraycopy(bArr, i2, bArr2, i6 - (i9 + i3), i3);
                }
                i9 += i3;
            }
            for (int i11 = i6 - (i8 * 2); i11 != i6; i11 += 2) {
                byte b2 = bArr2[(i11 / 2) + (i6 - i8)];
                byte[] bArr3 = h;
                bArr2[i11] = (byte) (bArr3[b2 & Ascii.SI] | (bArr3[(b2 & 255) >>> 4] << 4));
                bArr2[i11 + 1] = b2;
            }
            int i12 = i6 - (i3 * 2);
            bArr2[i12] = (byte) (bArr2[i12] ^ i7);
            int i13 = i6 - 1;
            bArr2[i13] = (byte) ((bArr2[i13] << 4) | 6);
            int i14 = 8 - ((this.c - 1) % 8);
            if (i14 != 8) {
                bArr2[0] = (byte) (bArr2[0] & (255 >>> i14));
                bArr2[0] = (byte) ((128 >>> i14) | bArr2[0]);
            } else {
                bArr2[0] = 0;
                bArr2[1] = (byte) (bArr2[1] | 128);
                i4 = 1;
            }
            return this.a.processBlock(bArr2, i4, i6 - i4);
        }
        byte[] processBlock = this.a.processBlock(bArr, i2, i3);
        int i15 = (this.c + 13) / 16;
        BigInteger bigInteger = new BigInteger(1, processBlock);
        BigInteger bigInteger2 = f;
        BigInteger mod = bigInteger.mod(bigInteger2);
        BigInteger bigInteger3 = g;
        if (!mod.equals(bigInteger3)) {
            if (this.e.subtract(bigInteger).mod(bigInteger2).equals(bigInteger3)) {
                bigInteger = this.e.subtract(bigInteger);
            } else {
                throw new InvalidCipherTextException("resulting integer iS or (modulus - iS) is not congruent to 6 mod 16");
            }
        }
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray[0] == 0) {
            int length = byteArray.length - 1;
            byte[] bArr4 = new byte[length];
            System.arraycopy(byteArray, 1, bArr4, 0, length);
            byteArray = bArr4;
        }
        if ((byteArray[byteArray.length - 1] & Ascii.SI) == 6) {
            byteArray[byteArray.length - 1] = (byte) (((byteArray[byteArray.length - 1] & 255) >>> 4) | (i[(byteArray[byteArray.length - 2] & 255) >> 4] << 4));
            byte[] bArr5 = h;
            byteArray[0] = (byte) (bArr5[byteArray[1] & Ascii.SI] | (bArr5[(byteArray[1] & 255) >>> 4] << 4));
            int i16 = 0;
            boolean z = false;
            int i17 = 1;
            for (int length2 = byteArray.length - 1; length2 >= byteArray.length - (i15 * 2); length2 -= 2) {
                byte[] bArr6 = h;
                int i18 = bArr6[byteArray[length2] & Ascii.SI] | (bArr6[(byteArray[length2] & 255) >>> 4] << 4);
                int i19 = length2 - 1;
                if (((byteArray[i19] ^ i18) & 255) != 0) {
                    if (!z) {
                        z = true;
                        i17 = (byteArray[i19] ^ i18) & 255;
                        i16 = i19;
                    } else {
                        throw new InvalidCipherTextException("invalid tsums in block");
                    }
                }
            }
            byteArray[i16] = 0;
            int length3 = (byteArray.length - i16) / 2;
            byte[] bArr7 = new byte[length3];
            while (i4 < length3) {
                bArr7[i4] = byteArray[a.c2(i4, 2, i16, 1)];
                i4++;
            }
            this.d = i17 - 1;
            return bArr7;
        }
        throw new InvalidCipherTextException("invalid forcing byte in block");
    }

    public void setPadBits(int i2) {
        if (i2 <= 7) {
            this.d = i2;
            return;
        }
        throw new IllegalArgumentException("padBits > 7");
    }
}
