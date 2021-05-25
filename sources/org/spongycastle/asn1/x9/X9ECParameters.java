package org.spongycastle.asn1.x9;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.field.PolynomialExtensionField;
public class X9ECParameters extends ASN1Object implements X9ObjectIdentifiers {
    public static final BigInteger g = BigInteger.valueOf(1);
    public X9FieldID a;
    public ECCurve b;
    public X9ECPoint c;
    public BigInteger d;
    public BigInteger e;
    public byte[] f;

    public X9ECParameters(ASN1Sequence aSN1Sequence) {
        if (!(aSN1Sequence.getObjectAt(0) instanceof ASN1Integer) || !((ASN1Integer) aSN1Sequence.getObjectAt(0)).getValue().equals(g)) {
            throw new IllegalArgumentException("bad version in X9ECParameters");
        }
        X9Curve x9Curve = new X9Curve(X9FieldID.getInstance(aSN1Sequence.getObjectAt(1)), ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(2)));
        this.b = x9Curve.getCurve();
        ASN1Encodable objectAt = aSN1Sequence.getObjectAt(3);
        if (objectAt instanceof X9ECPoint) {
            this.c = (X9ECPoint) objectAt;
        } else {
            this.c = new X9ECPoint(this.b, (ASN1OctetString) objectAt);
        }
        this.d = ((ASN1Integer) aSN1Sequence.getObjectAt(4)).getValue();
        this.f = x9Curve.getSeed();
        if (aSN1Sequence.size() == 6) {
            this.e = ((ASN1Integer) aSN1Sequence.getObjectAt(5)).getValue();
        }
    }

    public static X9ECParameters getInstance(Object obj) {
        if (obj instanceof X9ECParameters) {
            return (X9ECParameters) obj;
        }
        if (obj != null) {
            return new X9ECParameters(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public X9ECPoint getBaseEntry() {
        return this.c;
    }

    public ECCurve getCurve() {
        return this.b;
    }

    public X9Curve getCurveEntry() {
        return new X9Curve(this.b, this.f);
    }

    public X9FieldID getFieldIDEntry() {
        return this.a;
    }

    public ECPoint getG() {
        return this.c.getPoint();
    }

    public BigInteger getH() {
        return this.e;
    }

    public BigInteger getN() {
        return this.d;
    }

    public byte[] getSeed() {
        return this.f;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer(g));
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(new X9Curve(this.b, this.f));
        aSN1EncodableVector.add(this.c);
        aSN1EncodableVector.add(new ASN1Integer(this.d));
        BigInteger bigInteger = this.e;
        if (bigInteger != null) {
            aSN1EncodableVector.add(new ASN1Integer(bigInteger));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public X9ECParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger) {
        this(eCCurve, eCPoint, bigInteger, (BigInteger) null, (byte[]) null);
    }

    public X9ECParameters(ECCurve eCCurve, X9ECPoint x9ECPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this(eCCurve, x9ECPoint, bigInteger, bigInteger2, (byte[]) null);
    }

    public X9ECParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this(eCCurve, eCPoint, bigInteger, bigInteger2, (byte[]) null);
    }

    public X9ECParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this(eCCurve, new X9ECPoint(eCPoint), bigInteger, bigInteger2, bArr);
    }

    public X9ECParameters(ECCurve eCCurve, X9ECPoint x9ECPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.b = eCCurve;
        this.c = x9ECPoint;
        this.d = bigInteger;
        this.e = bigInteger2;
        this.f = bArr;
        if (ECAlgorithms.isFpCurve(eCCurve)) {
            this.a = new X9FieldID(eCCurve.getField().getCharacteristic());
        } else if (ECAlgorithms.isF2mCurve(eCCurve)) {
            int[] exponentsPresent = ((PolynomialExtensionField) eCCurve.getField()).getMinimalPolynomial().getExponentsPresent();
            if (exponentsPresent.length == 3) {
                this.a = new X9FieldID(exponentsPresent[2], exponentsPresent[1]);
            } else if (exponentsPresent.length == 5) {
                this.a = new X9FieldID(exponentsPresent[4], exponentsPresent[1], exponentsPresent[2], exponentsPresent[3]);
            } else {
                throw new IllegalArgumentException("Only trinomial and pentomial curves are supported");
            }
        } else {
            throw new IllegalArgumentException("'curve' is of an unsupported type");
        }
    }
}
