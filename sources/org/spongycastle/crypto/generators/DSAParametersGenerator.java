package org.spongycastle.crypto.generators;

import a2.b.a.a.a;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.params.DSAParameterGenerationParameters;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAValidationParameters;
import org.spongycastle.crypto.util.DigestFactory;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;
import org.spongycastle.util.encoders.Hex;
public class DSAParametersGenerator {
    public static final BigInteger h = BigInteger.valueOf(1);
    public static final BigInteger i = BigInteger.valueOf(2);
    public Digest a;
    public int b;
    public int c;
    public int d;
    public SecureRandom e;
    public boolean f;
    public int g;

    static {
        BigInteger.valueOf(0);
    }

    public DSAParametersGenerator() {
        this(DigestFactory.createSHA1());
    }

    public static BigInteger a(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        BigInteger modPow;
        BigInteger divide = bigInteger.subtract(h).divide(bigInteger2);
        BigInteger subtract = bigInteger.subtract(i);
        do {
            modPow = BigIntegers.createRandomInRange(i, subtract, secureRandom).modPow(divide, bigInteger);
        } while (modPow.bitLength() <= 1);
        return modPow;
    }

    public static void b(byte[] bArr) {
        for (int length = bArr.length - 1; length >= 0; length--) {
            byte b2 = (byte) ((bArr[length] + 1) & 255);
            bArr[length] = b2;
            if (b2 != 0) {
                return;
            }
        }
    }

    public final boolean c(BigInteger bigInteger) {
        return bigInteger.isProbablePrime(this.d);
    }

    public DSAParameters generateParameters() {
        BigInteger bit;
        int i2;
        BigInteger bigInteger;
        BigInteger subtract;
        BigInteger bigInteger2;
        int i3 = 0;
        int i4 = 1;
        if (this.f) {
            Digest digest = this.a;
            int digestSize = digest.getDigestSize() * 8;
            int i5 = this.c / 8;
            byte[] bArr = new byte[i5];
            int i6 = this.b;
            int i7 = i6 - 1;
            int i8 = i7 / digestSize;
            int i9 = i7 % digestSize;
            int i10 = i6 / 8;
            byte[] bArr2 = new byte[i10];
            int digestSize2 = digest.getDigestSize();
            byte[] bArr3 = new byte[digestSize2];
            loop0:
            while (true) {
                this.e.nextBytes(bArr);
                digest.update(bArr, i3, i5);
                digest.doFinal(bArr3, i3);
                bit = new BigInteger(i4, bArr3).mod(h.shiftLeft(this.c - i4)).setBit(i3).setBit(this.c - i4);
                if (c(bit)) {
                    byte[] clone = Arrays.clone(bArr);
                    int i11 = this.b * 4;
                    i2 = 0;
                    while (i2 < i11) {
                        int i12 = 1;
                        while (i12 <= i8) {
                            b(clone);
                            digest.update(clone, i3, clone.length);
                            digest.doFinal(bArr2, i10 - (i12 * digestSize2));
                            i12++;
                            i11 = i11;
                        }
                        int i13 = i10 - (i8 * digestSize2);
                        b(clone);
                        digest.update(clone, i3, clone.length);
                        digest.doFinal(bArr3, i3);
                        System.arraycopy(bArr3, digestSize2 - i13, bArr2, i3, i13);
                        bArr2[i3] = (byte) (bArr2[i3] | Byte.MIN_VALUE);
                        BigInteger bigInteger3 = new BigInteger(1, bArr2);
                        BigInteger mod = bigInteger3.mod(bit.shiftLeft(1));
                        bigInteger = h;
                        subtract = bigInteger3.subtract(mod.subtract(bigInteger));
                        if (subtract.bitLength() == this.b && subtract.isProbablePrime(this.d)) {
                            break loop0;
                        }
                        i2++;
                        i3 = 0;
                        i4 = 1;
                        i11 = i11;
                    }
                    continue;
                }
            }
            int i14 = this.g;
            if (i14 >= 0) {
                BigInteger divide = subtract.subtract(bigInteger).divide(bit);
                byte[] decode = Hex.decode("6767656E");
                int G1 = a.G1(decode.length, i5, 1, 2);
                byte[] bArr4 = new byte[G1];
                int i15 = 0;
                System.arraycopy(bArr, 0, bArr4, 0, i5);
                System.arraycopy(decode, 0, bArr4, i5, decode.length);
                bArr4[G1 - 3] = (byte) i14;
                byte[] bArr5 = new byte[digest.getDigestSize()];
                int i16 = 1;
                while (true) {
                    if (i16 >= 65536) {
                        bigInteger2 = null;
                        break;
                    }
                    b(bArr4);
                    digest.update(bArr4, i15, G1);
                    digest.doFinal(bArr5, i15);
                    bigInteger2 = new BigInteger(1, bArr5).modPow(divide, subtract);
                    if (bigInteger2.compareTo(i) >= 0) {
                        break;
                    }
                    i16++;
                    i15 = 0;
                }
                if (bigInteger2 != null) {
                    return new DSAParameters(subtract, bit, bigInteger2, new DSAValidationParameters(bArr, i2, this.g));
                }
            }
            return new DSAParameters(subtract, bit, a(subtract, bit, this.e), new DSAValidationParameters(bArr, i2));
        }
        int i17 = 20;
        byte[] bArr6 = new byte[20];
        byte[] bArr7 = new byte[20];
        byte[] bArr8 = new byte[20];
        byte[] bArr9 = new byte[20];
        int i18 = this.b;
        int i19 = (i18 - 1) / 160;
        int i20 = i18 / 8;
        byte[] bArr10 = new byte[i20];
        if (this.a instanceof SHA1Digest) {
            while (true) {
                this.e.nextBytes(bArr6);
                Digest digest2 = this.a;
                digest2.update(bArr6, 0, i17);
                digest2.doFinal(bArr7, 0);
                System.arraycopy(bArr6, 0, bArr8, 0, i17);
                b(bArr8);
                Digest digest3 = this.a;
                digest3.update(bArr8, 0, i17);
                digest3.doFinal(bArr8, 0);
                for (int i21 = 0; i21 != i17; i21++) {
                    bArr9[i21] = (byte) (bArr7[i21] ^ bArr8[i21]);
                }
                bArr9[0] = (byte) (bArr9[0] | Byte.MIN_VALUE);
                bArr9[19] = (byte) (bArr9[19] | 1);
                BigInteger bigInteger4 = new BigInteger(1, bArr9);
                if (bigInteger4.isProbablePrime(this.d)) {
                    byte[] clone2 = Arrays.clone(bArr6);
                    b(clone2);
                    int i22 = 0;
                    while (i22 < 4096) {
                        for (int i23 = 1; i23 <= i19; i23++) {
                            b(clone2);
                            Digest digest4 = this.a;
                            digest4.update(clone2, 0, clone2.length);
                            digest4.doFinal(bArr10, i20 - (i23 * 20));
                        }
                        int i24 = i20 - (i19 * 20);
                        b(clone2);
                        Digest digest5 = this.a;
                        digest5.update(clone2, 0, clone2.length);
                        digest5.doFinal(bArr7, 0);
                        System.arraycopy(bArr7, 20 - i24, bArr10, 0, i24);
                        bArr10[0] = (byte) (bArr10[0] | Byte.MIN_VALUE);
                        BigInteger bigInteger5 = new BigInteger(1, bArr10);
                        BigInteger subtract2 = bigInteger5.subtract(bigInteger5.mod(bigInteger4.shiftLeft(1)).subtract(h));
                        if (subtract2.bitLength() == this.b && subtract2.isProbablePrime(this.d)) {
                            return new DSAParameters(subtract2, bigInteger4, a(subtract2, bigInteger4, this.e), new DSAValidationParameters(bArr6, i22));
                        }
                        i22++;
                        i17 = 20;
                    }
                    continue;
                }
            }
        } else {
            throw new IllegalStateException("can only use SHA-1 for generating FIPS 186-2 parameters");
        }
    }

    public void init(int i2, int i3, SecureRandom secureRandom) {
        int i4;
        this.b = i2;
        this.c = i2 > 1024 ? 256 : 160;
        this.d = i3;
        if (i2 <= 1024) {
            i4 = 40;
        } else {
            i4 = (((i2 - 1) / 1024) * 8) + 48;
        }
        Math.max(i4, (i3 + 1) / 2);
        this.e = secureRandom;
        this.f = false;
        this.g = -1;
    }

    public DSAParametersGenerator(Digest digest) {
        this.a = digest;
    }

    public void init(DSAParameterGenerationParameters dSAParameterGenerationParameters) {
        int i2;
        int l = dSAParameterGenerationParameters.getL();
        int n = dSAParameterGenerationParameters.getN();
        if (l < 1024 || l > 3072 || l % 1024 != 0) {
            throw new IllegalArgumentException("L values must be between 1024 and 3072 and a multiple of 1024");
        } else if (l == 1024 && n != 160) {
            throw new IllegalArgumentException("N must be 160 for L = 1024");
        } else if (l == 2048 && n != 224 && n != 256) {
            throw new IllegalArgumentException("N must be 224 or 256 for L = 2048");
        } else if (l == 3072 && n != 256) {
            throw new IllegalArgumentException("N must be 256 for L = 3072");
        } else if (this.a.getDigestSize() * 8 >= n) {
            this.b = l;
            this.c = n;
            int certainty = dSAParameterGenerationParameters.getCertainty();
            this.d = certainty;
            if (l <= 1024) {
                i2 = 40;
            } else {
                i2 = (((l - 1) / 1024) * 8) + 48;
            }
            Math.max(i2, (certainty + 1) / 2);
            this.e = dSAParameterGenerationParameters.getRandom();
            this.f = true;
            this.g = dSAParameterGenerationParameters.getUsageIndex();
        } else {
            throw new IllegalStateException("Digest output size too small for value of N");
        }
    }
}
