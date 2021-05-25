package org.spongycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.util.BigIntegers;
public class SRP6Util {
    public static BigInteger a = BigInteger.valueOf(0);
    public static BigInteger b = BigInteger.valueOf(1);

    public static byte[] a(BigInteger bigInteger, int i) {
        byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(bigInteger);
        if (asUnsignedByteArray.length >= i) {
            return asUnsignedByteArray;
        }
        byte[] bArr = new byte[i];
        System.arraycopy(asUnsignedByteArray, 0, bArr, i - asUnsignedByteArray.length, asUnsignedByteArray.length);
        return bArr;
    }

    public static BigInteger b(Digest digest, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        int bitLength = (bigInteger.bitLength() + 7) / 8;
        byte[] a3 = a(bigInteger2, bitLength);
        byte[] a4 = a(bigInteger3, bitLength);
        digest.update(a3, 0, a3.length);
        digest.update(a4, 0, a4.length);
        byte[] bArr = new byte[digest.getDigestSize()];
        digest.doFinal(bArr, 0);
        return new BigInteger(1, bArr);
    }

    public static BigInteger c(Digest digest, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        int bitLength = (bigInteger.bitLength() + 7) / 8;
        byte[] a3 = a(bigInteger2, bitLength);
        byte[] a4 = a(bigInteger3, bitLength);
        byte[] a5 = a(bigInteger4, bitLength);
        digest.update(a3, 0, a3.length);
        digest.update(a4, 0, a4.length);
        digest.update(a5, 0, a5.length);
        byte[] bArr = new byte[digest.getDigestSize()];
        digest.doFinal(bArr, 0);
        return new BigInteger(1, bArr);
    }

    public static BigInteger calculateK(Digest digest, BigInteger bigInteger, BigInteger bigInteger2) {
        return b(digest, bigInteger, bigInteger, bigInteger2);
    }

    public static BigInteger calculateKey(Digest digest, BigInteger bigInteger, BigInteger bigInteger2) {
        byte[] a3 = a(bigInteger2, (bigInteger.bitLength() + 7) / 8);
        digest.update(a3, 0, a3.length);
        byte[] bArr = new byte[digest.getDigestSize()];
        digest.doFinal(bArr, 0);
        return new BigInteger(1, bArr);
    }

    public static BigInteger calculateM1(Digest digest, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        return c(digest, bigInteger, bigInteger2, bigInteger3, bigInteger4);
    }

    public static BigInteger calculateM2(Digest digest, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        return c(digest, bigInteger, bigInteger2, bigInteger3, bigInteger4);
    }

    public static BigInteger calculateU(Digest digest, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return b(digest, bigInteger, bigInteger2, bigInteger3);
    }

    public static BigInteger calculateX(Digest digest, BigInteger bigInteger, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int digestSize = digest.getDigestSize();
        byte[] bArr4 = new byte[digestSize];
        digest.update(bArr2, 0, bArr2.length);
        digest.update((byte) 58);
        digest.update(bArr3, 0, bArr3.length);
        digest.doFinal(bArr4, 0);
        digest.update(bArr, 0, bArr.length);
        digest.update(bArr4, 0, digestSize);
        digest.doFinal(bArr4, 0);
        return new BigInteger(1, bArr4);
    }

    public static BigInteger generatePrivateValue(Digest digest, BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        return BigIntegers.createRandomInRange(b.shiftLeft(Math.min(256, bigInteger.bitLength() / 2) - 1), bigInteger.subtract(b), secureRandom);
    }

    public static BigInteger validatePublicValue(BigInteger bigInteger, BigInteger bigInteger2) throws CryptoException {
        BigInteger mod = bigInteger2.mod(bigInteger);
        if (!mod.equals(a)) {
            return mod;
        }
        throw new CryptoException("Invalid public value: 0");
    }
}
