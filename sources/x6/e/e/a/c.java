package x6.e.e.a;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
public class c {
    public static final BigInteger a;
    public static final BigInteger b = ECConstants.TWO.negate();
    public static final BigInteger c;
    public static final d[] d;
    public static final byte[][] e = {null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, 1}};
    public static final d[] f;
    public static final byte[][] g = {null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, -1}};

    static {
        BigInteger bigInteger = ECConstants.ONE;
        BigInteger negate = bigInteger.negate();
        a = negate;
        BigInteger negate2 = ECConstants.THREE.negate();
        c = negate2;
        BigInteger bigInteger2 = ECConstants.ZERO;
        d = new d[]{null, new d(bigInteger, bigInteger2), null, new d(negate2, negate), null, new d(negate, negate), null, new d(bigInteger, negate), null};
        f = new d[]{null, new d(bigInteger, bigInteger2), null, new d(negate2, bigInteger), null, new d(negate, bigInteger), null, new d(bigInteger, bigInteger), null};
    }

    public static b a(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, byte b2, int i, int i2) {
        int i3 = ((i + 5) / 2) + i2;
        BigInteger multiply = bigInteger2.multiply(bigInteger.shiftRight(((i - i3) - 2) + b2));
        BigInteger add = multiply.add(bigInteger3.multiply(multiply.shiftRight(i)));
        int i4 = i3 - i2;
        BigInteger shiftRight = add.shiftRight(i4);
        if (add.testBit(i4 - 1)) {
            shiftRight = shiftRight.add(ECConstants.ONE);
        }
        return new b(shiftRight, i2);
    }

    public static BigInteger[] b(byte b2, int i, boolean z) {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        if (b2 == 1 || b2 == -1) {
            if (z) {
                bigInteger = ECConstants.TWO;
                bigInteger2 = BigInteger.valueOf((long) b2);
            } else {
                bigInteger = ECConstants.ZERO;
                bigInteger2 = ECConstants.ONE;
            }
            int i2 = 1;
            while (i2 < i) {
                if (b2 == 1) {
                    bigInteger3 = bigInteger2;
                } else {
                    bigInteger3 = bigInteger2.negate();
                }
                i2++;
                bigInteger2 = bigInteger3.subtract(bigInteger.shiftLeft(1));
                bigInteger = bigInteger2;
            }
            return new BigInteger[]{bigInteger, bigInteger2};
        }
        throw new IllegalArgumentException("mu must be 1 or -1");
    }

    public static BigInteger[] c(ECCurve.AbstractF2m abstractF2m) {
        int i;
        if (abstractF2m.isKoblitz()) {
            int fieldSize = abstractF2m.getFieldSize();
            int intValue = abstractF2m.getA().toBigInteger().intValue();
            byte b2 = (byte) (intValue == 0 ? -1 : 1);
            BigInteger cofactor = abstractF2m.getCofactor();
            if (cofactor != null) {
                if (cofactor.equals(ECConstants.TWO)) {
                    i = 1;
                } else if (cofactor.equals(ECConstants.FOUR)) {
                    i = 2;
                }
                BigInteger[] b3 = b(b2, (fieldSize + 3) - intValue, false);
                if (b2 == 1) {
                    b3[0] = b3[0].negate();
                    b3[1] = b3[1].negate();
                }
                BigInteger bigInteger = ECConstants.ONE;
                return new BigInteger[]{bigInteger.add(b3[1]).shiftRight(i), bigInteger.add(b3[0]).shiftRight(i).negate()};
            }
            throw new IllegalArgumentException("h (Cofactor) must be 2 or 4");
        }
        throw new IllegalArgumentException("si is defined for Koblitz curves only");
    }
}
