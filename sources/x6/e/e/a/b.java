package x6.e.e.a;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECConstants;
public class b {
    public final BigInteger a;
    public final int b;

    public b(BigInteger bigInteger, int i) {
        if (i >= 0) {
            this.a = bigInteger;
            this.b = i;
            return;
        }
        throw new IllegalArgumentException("scale may not be negative");
    }

    public b a(b bVar) {
        if (this.b == bVar.b) {
            return new b(this.a.add(bVar.a), this.b);
        }
        throw new IllegalArgumentException("Only SimpleBigDecimal of same scale allowed in arithmetic operations");
    }

    public int b(BigInteger bigInteger) {
        return this.a.compareTo(bigInteger.shiftLeft(this.b));
    }

    public BigInteger c() {
        BigInteger bigInteger = ECConstants.ONE;
        b bVar = new b(bigInteger, 1);
        int i = this.b;
        if (i >= 0) {
            if (i != 1) {
                bVar = new b(bigInteger.shiftLeft(i - 1), i);
            }
            b a3 = a(bVar);
            return a3.a.shiftRight(a3.b);
        }
        throw new IllegalArgumentException("scale may not be negative");
    }

    public b d(b bVar) {
        BigInteger negate = bVar.a.negate();
        int i = bVar.b;
        if (i < 0) {
            throw new IllegalArgumentException("scale may not be negative");
        } else if (this.b == i) {
            return new b(this.a.add(negate), this.b);
        } else {
            throw new IllegalArgumentException("Only SimpleBigDecimal of same scale allowed in arithmetic operations");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!this.a.equals(bVar.a) || this.b != bVar.b) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.a.hashCode() ^ this.b;
    }

    public String toString() {
        int i = this.b;
        if (i == 0) {
            return this.a.toString();
        }
        BigInteger shiftRight = this.a.shiftRight(i);
        BigInteger subtract = this.a.subtract(shiftRight.shiftLeft(this.b));
        if (this.a.signum() == -1) {
            subtract = ECConstants.ONE.shiftLeft(this.b).subtract(subtract);
        }
        if (shiftRight.signum() == -1 && !subtract.equals(ECConstants.ZERO)) {
            shiftRight = shiftRight.add(ECConstants.ONE);
        }
        String bigInteger = shiftRight.toString();
        char[] cArr = new char[this.b];
        String bigInteger2 = subtract.toString(2);
        int length = bigInteger2.length();
        int i2 = this.b - length;
        for (int i3 = 0; i3 < i2; i3++) {
            cArr[i3] = '0';
        }
        for (int i4 = 0; i4 < length; i4++) {
            cArr[i2 + i4] = bigInteger2.charAt(i4);
        }
        String str = new String(cArr);
        StringBuffer stringBuffer = new StringBuffer(bigInteger);
        stringBuffer.append(".");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
