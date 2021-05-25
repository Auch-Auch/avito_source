package x6.e.b.b;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.math.ec.WNafUtil;
import org.spongycastle.util.BigIntegers;
public class b {
    public static final BigInteger a = BigInteger.valueOf(1);
    public static final BigInteger b = BigInteger.valueOf(2);

    public static BigInteger[] a(int i, int i2, SecureRandom secureRandom) {
        int i3 = i - 1;
        int i4 = i >>> 2;
        while (true) {
            BigInteger bigInteger = new BigInteger(i3, 2, secureRandom);
            BigInteger add = bigInteger.shiftLeft(1).add(a);
            if (add.isProbablePrime(i2) && (i2 <= 2 || bigInteger.isProbablePrime(i2 - 2))) {
                if (WNafUtil.getNafWeight(add) >= i4) {
                    return new BigInteger[]{add, bigInteger};
                }
            }
        }
    }

    public static BigInteger b(BigInteger bigInteger, SecureRandom secureRandom) {
        BigInteger modPow;
        BigInteger subtract = bigInteger.subtract(b);
        do {
            BigInteger bigInteger2 = b;
            modPow = BigIntegers.createRandomInRange(bigInteger2, subtract, secureRandom).modPow(bigInteger2, bigInteger);
        } while (modPow.equals(a));
        return modPow;
    }
}
