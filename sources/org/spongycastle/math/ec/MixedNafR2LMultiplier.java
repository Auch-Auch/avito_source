package org.spongycastle.math.ec;

import a2.b.a.a.a;
import java.math.BigInteger;
public class MixedNafR2LMultiplier extends AbstractECMultiplier {
    public int additionCoord;
    public int doublingCoord;

    public MixedNafR2LMultiplier() {
        this(2, 4);
    }

    public ECCurve configureCurve(ECCurve eCCurve, int i) {
        if (eCCurve.getCoordinateSystem() == i) {
            return eCCurve;
        }
        if (eCCurve.supportsCoordinateSystem(i)) {
            return eCCurve.configure().setCoordinateSystem(i).create();
        }
        throw new IllegalArgumentException(a.Q2("Coordinate system ", i, " not supported by this curve"));
    }

    @Override // org.spongycastle.math.ec.AbstractECMultiplier
    public ECPoint multiplyPositive(ECPoint eCPoint, BigInteger bigInteger) {
        ECCurve curve = eCPoint.getCurve();
        ECCurve configureCurve = configureCurve(curve, this.additionCoord);
        ECCurve configureCurve2 = configureCurve(curve, this.doublingCoord);
        int[] generateCompactNaf = WNafUtil.generateCompactNaf(bigInteger);
        ECPoint infinity = configureCurve.getInfinity();
        ECPoint importPoint = configureCurve2.importPoint(eCPoint);
        int i = 0;
        ECPoint eCPoint2 = infinity;
        int i2 = 0;
        while (i < generateCompactNaf.length) {
            int i3 = generateCompactNaf[i];
            int i4 = i3 >> 16;
            importPoint = importPoint.timesPow2(i2 + (i3 & 65535));
            ECPoint importPoint2 = configureCurve.importPoint(importPoint);
            if (i4 < 0) {
                importPoint2 = importPoint2.negate();
            }
            eCPoint2 = eCPoint2.add(importPoint2);
            i++;
            i2 = 1;
        }
        return curve.importPoint(eCPoint2);
    }

    public MixedNafR2LMultiplier(int i, int i2) {
        this.additionCoord = i;
        this.doublingCoord = i2;
    }
}
