package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.EllipticCurve;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.field.FiniteField;
import org.spongycastle.math.field.Polynomial;
import org.spongycastle.math.field.PolynomialExtensionField;
import org.spongycastle.util.Arrays;
public class ECNamedCurveSpec extends ECParameterSpec {
    public String a;

    public ECNamedCurveSpec(String str, ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger) {
        super(a(eCCurve, null), b(eCPoint), bigInteger, 1);
        this.a = str;
    }

    public static EllipticCurve a(ECCurve eCCurve, byte[] bArr) {
        ECField eCField;
        FiniteField field = eCCurve.getField();
        if (ECAlgorithms.isFpField(field)) {
            eCField = new ECFieldFp(field.getCharacteristic());
        } else {
            Polynomial minimalPolynomial = ((PolynomialExtensionField) field).getMinimalPolynomial();
            int[] exponentsPresent = minimalPolynomial.getExponentsPresent();
            eCField = new ECFieldF2m(minimalPolynomial.getDegree(), Arrays.reverse(Arrays.copyOfRange(exponentsPresent, 1, exponentsPresent.length - 1)));
        }
        return new EllipticCurve(eCField, eCCurve.getA().toBigInteger(), eCCurve.getB().toBigInteger(), bArr);
    }

    public static java.security.spec.ECPoint b(ECPoint eCPoint) {
        ECPoint normalize = eCPoint.normalize();
        return new java.security.spec.ECPoint(normalize.getAffineXCoord().toBigInteger(), normalize.getAffineYCoord().toBigInteger());
    }

    public String getName() {
        return this.a;
    }

    public ECNamedCurveSpec(String str, EllipticCurve ellipticCurve, java.security.spec.ECPoint eCPoint, BigInteger bigInteger) {
        super(ellipticCurve, eCPoint, bigInteger, 1);
        this.a = str;
    }

    public ECNamedCurveSpec(String str, ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        super(a(eCCurve, null), b(eCPoint), bigInteger, bigInteger2.intValue());
        this.a = str;
    }

    public ECNamedCurveSpec(String str, EllipticCurve ellipticCurve, java.security.spec.ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        super(ellipticCurve, eCPoint, bigInteger, bigInteger2.intValue());
        this.a = str;
    }

    public ECNamedCurveSpec(String str, ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        super(a(eCCurve, bArr), b(eCPoint), bigInteger, bigInteger2.intValue());
        this.a = str;
    }
}
