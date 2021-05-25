package org.spongycastle.asn1.ua;

import java.math.BigInteger;
import java.util.Random;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
public abstract class DSTU4145PointEncoder {
    public static ECFieldElement a(ECFieldElement eCFieldElement) {
        ECFieldElement eCFieldElement2 = eCFieldElement;
        for (int i = 1; i < eCFieldElement.getFieldSize(); i++) {
            eCFieldElement2 = eCFieldElement2.square().add(eCFieldElement);
        }
        return eCFieldElement2;
    }

    public static ECPoint decodePoint(ECCurve eCCurve, byte[] bArr) {
        ECFieldElement fromBigInteger = eCCurve.fromBigInteger(BigInteger.valueOf((long) (bArr[bArr.length - 1] & 1)));
        ECFieldElement fromBigInteger2 = eCCurve.fromBigInteger(new BigInteger(1, bArr));
        if (!a(fromBigInteger2).equals(eCCurve.getA())) {
            fromBigInteger2 = fromBigInteger2.addOne();
        }
        ECFieldElement eCFieldElement = null;
        if (fromBigInteger2.isZero()) {
            eCFieldElement = eCCurve.getB().sqrt();
        } else {
            ECFieldElement add = fromBigInteger2.square().invert().multiply(eCCurve.getB()).add(eCCurve.getA()).add(fromBigInteger2);
            if (!add.isZero()) {
                ECFieldElement fromBigInteger3 = eCCurve.fromBigInteger(ECConstants.ZERO);
                Random random = new Random();
                int fieldSize = add.getFieldSize();
                while (true) {
                    ECFieldElement fromBigInteger4 = eCCurve.fromBigInteger(new BigInteger(fieldSize, random));
                    ECFieldElement eCFieldElement2 = add;
                    ECFieldElement eCFieldElement3 = fromBigInteger3;
                    for (int i = 1; i <= fieldSize - 1; i++) {
                        ECFieldElement square = eCFieldElement2.square();
                        eCFieldElement3 = eCFieldElement3.square().add(square.multiply(fromBigInteger4));
                        eCFieldElement2 = square.add(add);
                    }
                    if (eCFieldElement2.isZero()) {
                        if (!eCFieldElement3.square().add(eCFieldElement3).isZero()) {
                            add = eCFieldElement3;
                            break;
                        }
                    } else {
                        add = null;
                        break;
                    }
                }
            }
            if (add != null) {
                if (!a(add).equals(fromBigInteger)) {
                    add = add.addOne();
                }
                eCFieldElement = fromBigInteger2.multiply(add);
            }
        }
        if (eCFieldElement != null) {
            return eCCurve.validatePoint(fromBigInteger2.toBigInteger(), eCFieldElement.toBigInteger());
        }
        throw new IllegalArgumentException("Invalid point compression");
    }

    public static byte[] encodePoint(ECPoint eCPoint) {
        ECPoint normalize = eCPoint.normalize();
        ECFieldElement affineXCoord = normalize.getAffineXCoord();
        byte[] encoded = affineXCoord.getEncoded();
        if (!affineXCoord.isZero()) {
            if (a(normalize.getAffineYCoord().divide(affineXCoord)).isOne()) {
                int length = encoded.length - 1;
                encoded[length] = (byte) (encoded[length] | 1);
            } else {
                int length2 = encoded.length - 1;
                encoded[length2] = (byte) (encoded[length2] & 254);
            }
        }
        return encoded;
    }
}
