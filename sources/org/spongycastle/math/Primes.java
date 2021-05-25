package org.spongycastle.math;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.Digest;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;
public abstract class Primes {
    public static final int SMALL_FACTOR_LIMIT = 211;
    public static final BigInteger a = BigInteger.valueOf(1);
    public static final BigInteger b = BigInteger.valueOf(2);
    public static final BigInteger c = BigInteger.valueOf(3);

    public static class MROutput {
        public boolean a;
        public BigInteger b;

        public MROutput(boolean z, BigInteger bigInteger) {
            this.a = z;
            this.b = bigInteger;
        }

        public static MROutput a(BigInteger bigInteger) {
            return new MROutput(true, bigInteger);
        }

        public BigInteger getFactor() {
            return this.b;
        }

        public boolean isNotPrimePower() {
            return this.a && this.b == null;
        }

        public boolean isProvablyComposite() {
            return this.a;
        }
    }

    public static class STOutput {
        public BigInteger a;
        public byte[] b;
        public int c;

        public STOutput(BigInteger bigInteger, byte[] bArr, int i, a aVar) {
            this.a = bigInteger;
            this.b = bArr;
            this.c = i;
        }

        public BigInteger getPrime() {
            return this.a;
        }

        public int getPrimeGenCounter() {
            return this.c;
        }

        public byte[] getPrimeSeed() {
            return this.b;
        }
    }

    public static void a(BigInteger bigInteger, String str) {
        if (bigInteger == null || bigInteger.signum() < 1 || bigInteger.bitLength() < 2) {
            throw new IllegalArgumentException(a2.b.a.a.a.e3("'", str, "' must be non-null and >= 2"));
        }
    }

    public static int b(byte[] bArr) {
        int min = Math.min(4, bArr.length);
        int i = 0;
        int i2 = 0;
        while (i < min) {
            int i3 = i + 1;
            i2 |= (bArr[bArr.length - i3] & 255) << (i * 8);
            i = i3;
        }
        return i2;
    }

    public static BigInteger c(Digest digest, byte[] bArr, int i) {
        int digestSize = digest.getDigestSize();
        int i2 = i * digestSize;
        byte[] bArr2 = new byte[i2];
        for (int i3 = 0; i3 < i; i3++) {
            i2 -= digestSize;
            digest.update(bArr, 0, bArr.length);
            digest.doFinal(bArr2, i2);
            g(bArr, 1);
        }
        return new BigInteger(1, bArr2);
    }

    public static boolean d(BigInteger bigInteger) {
        int intValue = bigInteger.mod(BigInteger.valueOf((long) 223092870)).intValue();
        if (!(intValue % 2 == 0 || intValue % 3 == 0 || intValue % 5 == 0 || intValue % 7 == 0 || intValue % 11 == 0 || intValue % 13 == 0 || intValue % 17 == 0 || intValue % 19 == 0 || intValue % 23 == 0)) {
            int intValue2 = bigInteger.mod(BigInteger.valueOf((long) 58642669)).intValue();
            if (!(intValue2 % 29 == 0 || intValue2 % 31 == 0 || intValue2 % 37 == 0 || intValue2 % 41 == 0 || intValue2 % 43 == 0)) {
                int intValue3 = bigInteger.mod(BigInteger.valueOf((long) 600662303)).intValue();
                if (!(intValue3 % 47 == 0 || intValue3 % 53 == 0 || intValue3 % 59 == 0 || intValue3 % 61 == 0 || intValue3 % 67 == 0)) {
                    int intValue4 = bigInteger.mod(BigInteger.valueOf((long) 33984931)).intValue();
                    if (!(intValue4 % 71 == 0 || intValue4 % 73 == 0 || intValue4 % 79 == 0 || intValue4 % 83 == 0)) {
                        int intValue5 = bigInteger.mod(BigInteger.valueOf((long) 89809099)).intValue();
                        if (!(intValue5 % 89 == 0 || intValue5 % 97 == 0 || intValue5 % 101 == 0 || intValue5 % 103 == 0)) {
                            int intValue6 = bigInteger.mod(BigInteger.valueOf((long) 167375713)).intValue();
                            if (!(intValue6 % 107 == 0 || intValue6 % 109 == 0 || intValue6 % 113 == 0 || intValue6 % 127 == 0)) {
                                int intValue7 = bigInteger.mod(BigInteger.valueOf((long) 371700317)).intValue();
                                if (!(intValue7 % 131 == 0 || intValue7 % 137 == 0 || intValue7 % 139 == 0 || intValue7 % 149 == 0)) {
                                    int intValue8 = bigInteger.mod(BigInteger.valueOf((long) 645328247)).intValue();
                                    if (!(intValue8 % 151 == 0 || intValue8 % 157 == 0 || intValue8 % 163 == 0 || intValue8 % 167 == 0)) {
                                        int intValue9 = bigInteger.mod(BigInteger.valueOf((long) 1070560157)).intValue();
                                        if (!(intValue9 % 173 == 0 || intValue9 % 179 == 0 || intValue9 % 181 == 0 || intValue9 % 191 == 0)) {
                                            int intValue10 = bigInteger.mod(BigInteger.valueOf((long) 1596463769)).intValue();
                                            if (intValue10 % 193 != 0 && intValue10 % 197 != 0 && intValue10 % 199 != 0 && intValue10 % 211 != 0) {
                                                return false;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean e(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i, BigInteger bigInteger4) {
        BigInteger modPow = bigInteger4.modPow(bigInteger3, bigInteger);
        if (!modPow.equals(a) && !modPow.equals(bigInteger2)) {
            for (int i2 = 1; i2 < i; i2++) {
                modPow = modPow.modPow(b, bigInteger);
                if (!modPow.equals(bigInteger2)) {
                    if (modPow.equals(a)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public static MROutput enhancedMRProbablePrimeTest(BigInteger bigInteger, SecureRandom secureRandom, int i) {
        BigInteger bigInteger2;
        boolean z;
        a(bigInteger, "candidate");
        if (secureRandom == null) {
            throw new IllegalArgumentException("'random' cannot be null");
        } else if (i < 1) {
            throw new IllegalArgumentException("'iterations' must be > 0");
        } else if (bigInteger.bitLength() == 2) {
            return new MROutput(false, null);
        } else {
            if (!bigInteger.testBit(0)) {
                return MROutput.a(b);
            }
            BigInteger subtract = bigInteger.subtract(a);
            BigInteger subtract2 = bigInteger.subtract(b);
            int lowestSetBit = subtract.getLowestSetBit();
            BigInteger shiftRight = subtract.shiftRight(lowestSetBit);
            for (int i2 = 0; i2 < i; i2++) {
                BigInteger createRandomInRange = BigIntegers.createRandomInRange(b, subtract2, secureRandom);
                BigInteger gcd = createRandomInRange.gcd(bigInteger);
                BigInteger bigInteger3 = a;
                if (gcd.compareTo(bigInteger3) > 0) {
                    return MROutput.a(gcd);
                }
                BigInteger modPow = createRandomInRange.modPow(shiftRight, bigInteger);
                if (!modPow.equals(bigInteger3) && !modPow.equals(subtract)) {
                    int i3 = 1;
                    while (true) {
                        if (i3 >= lowestSetBit) {
                            bigInteger2 = modPow;
                            break;
                        }
                        bigInteger2 = modPow.modPow(b, bigInteger);
                        if (bigInteger2.equals(subtract)) {
                            z = true;
                            break;
                        } else if (bigInteger2.equals(a)) {
                            break;
                        } else {
                            i3++;
                            modPow = bigInteger2;
                        }
                    }
                    z = false;
                    if (!z) {
                        BigInteger bigInteger4 = a;
                        if (!bigInteger2.equals(bigInteger4)) {
                            modPow = bigInteger2.modPow(b, bigInteger);
                            if (modPow.equals(bigInteger4)) {
                                modPow = bigInteger2;
                            }
                        }
                        BigInteger gcd2 = modPow.subtract(bigInteger4).gcd(bigInteger);
                        if (gcd2.compareTo(bigInteger4) > 0) {
                            return MROutput.a(gcd2);
                        }
                        return new MROutput(true, null);
                    }
                }
            }
            return new MROutput(false, null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0067, code lost:
        if (r19 != 0) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0097, code lost:
        if (r11 < 30) goto L_0x00a5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ac A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.spongycastle.math.Primes.STOutput f(org.spongycastle.crypto.Digest r24, int r25, byte[] r26) {
        /*
        // Method dump skipped, instructions count: 456
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.Primes.f(org.spongycastle.crypto.Digest, int, byte[]):org.spongycastle.math.Primes$STOutput");
    }

    public static void g(byte[] bArr, int i) {
        int length = bArr.length;
        while (i > 0) {
            length--;
            if (length >= 0) {
                int i2 = i + (bArr[length] & 255);
                bArr[length] = (byte) i2;
                i = i2 >>> 8;
            } else {
                return;
            }
        }
    }

    public static STOutput generateSTRandomPrime(Digest digest, int i, byte[] bArr) {
        if (digest == null) {
            throw new IllegalArgumentException("'hash' cannot be null");
        } else if (i < 2) {
            throw new IllegalArgumentException("'length' must be >= 2");
        } else if (bArr != null && bArr.length != 0) {
            return f(digest, i, Arrays.clone(bArr));
        } else {
            throw new IllegalArgumentException("'inputSeed' cannot be null or empty");
        }
    }

    public static boolean hasAnySmallFactors(BigInteger bigInteger) {
        a(bigInteger, "candidate");
        return d(bigInteger);
    }

    public static boolean isMRProbablePrime(BigInteger bigInteger, SecureRandom secureRandom, int i) {
        a(bigInteger, "candidate");
        if (secureRandom == null) {
            throw new IllegalArgumentException("'random' cannot be null");
        } else if (i < 1) {
            throw new IllegalArgumentException("'iterations' must be > 0");
        } else if (bigInteger.bitLength() == 2) {
            return true;
        } else {
            if (!bigInteger.testBit(0)) {
                return false;
            }
            BigInteger subtract = bigInteger.subtract(a);
            BigInteger subtract2 = bigInteger.subtract(b);
            int lowestSetBit = subtract.getLowestSetBit();
            BigInteger shiftRight = subtract.shiftRight(lowestSetBit);
            for (int i2 = 0; i2 < i; i2++) {
                if (!e(bigInteger, subtract, shiftRight, lowestSetBit, BigIntegers.createRandomInRange(b, subtract2, secureRandom))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean isMRProbablePrimeToBase(BigInteger bigInteger, BigInteger bigInteger2) {
        a(bigInteger, "candidate");
        a(bigInteger2, "base");
        BigInteger bigInteger3 = a;
        if (bigInteger2.compareTo(bigInteger.subtract(bigInteger3)) >= 0) {
            throw new IllegalArgumentException("'base' must be < ('candidate' - 1)");
        } else if (bigInteger.bitLength() == 2) {
            return true;
        } else {
            BigInteger subtract = bigInteger.subtract(bigInteger3);
            int lowestSetBit = subtract.getLowestSetBit();
            return e(bigInteger, subtract, subtract.shiftRight(lowestSetBit), lowestSetBit, bigInteger2);
        }
    }
}
