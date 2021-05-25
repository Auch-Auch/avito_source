package org.spongycastle.crypto.prng.drbg;

import org.spongycastle.math.ec.ECPoint;
public class DualECPoints {
    public final ECPoint a;
    public final ECPoint b;
    public final int c;
    public final int d;

    public DualECPoints(int i, ECPoint eCPoint, ECPoint eCPoint2, int i2) {
        if (eCPoint.getCurve().equals(eCPoint2.getCurve())) {
            this.c = i;
            this.a = eCPoint;
            this.b = eCPoint2;
            this.d = i2;
            return;
        }
        throw new IllegalArgumentException("points need to be on the same curve");
    }

    public int getCofactor() {
        return this.d;
    }

    public int getMaxOutlen() {
        int fieldSize = this.a.getCurve().getFieldSize();
        int i = this.d;
        int i2 = 0;
        while (true) {
            i >>= 1;
            if (i == 0) {
                return ((fieldSize - (i2 + 13)) / 8) * 8;
            }
            i2++;
        }
    }

    public ECPoint getP() {
        return this.a;
    }

    public ECPoint getQ() {
        return this.b;
    }

    public int getSecurityStrength() {
        return this.c;
    }

    public int getSeedLen() {
        return this.a.getCurve().getFieldSize();
    }
}
