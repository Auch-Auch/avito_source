package org.spongycastle.asn1.x9;

import a2.b.a.a.a;
import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
public class DomainParameters extends ASN1Object {
    public final ASN1Integer a;
    public final ASN1Integer b;
    public final ASN1Integer c;
    public final ASN1Integer d;
    public final ValidationParams e;

    public DomainParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, ValidationParams validationParams) {
        if (bigInteger == null) {
            throw new IllegalArgumentException("'p' cannot be null");
        } else if (bigInteger2 == null) {
            throw new IllegalArgumentException("'g' cannot be null");
        } else if (bigInteger3 != null) {
            this.a = new ASN1Integer(bigInteger);
            this.b = new ASN1Integer(bigInteger2);
            this.c = new ASN1Integer(bigInteger3);
            if (bigInteger4 != null) {
                this.d = new ASN1Integer(bigInteger4);
            } else {
                this.d = null;
            }
            this.e = validationParams;
        } else {
            throw new IllegalArgumentException("'q' cannot be null");
        }
    }

    public static DomainParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public BigInteger getG() {
        return this.b.getPositiveValue();
    }

    public BigInteger getJ() {
        ASN1Integer aSN1Integer = this.d;
        if (aSN1Integer == null) {
            return null;
        }
        return aSN1Integer.getPositiveValue();
    }

    public BigInteger getP() {
        return this.a.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.c.getPositiveValue();
    }

    public ValidationParams getValidationParams() {
        return this.e;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        ASN1Integer aSN1Integer = this.d;
        if (aSN1Integer != null) {
            aSN1EncodableVector.add(aSN1Integer);
        }
        ValidationParams validationParams = this.e;
        if (validationParams != null) {
            aSN1EncodableVector.add(validationParams);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public static DomainParameters getInstance(Object obj) {
        if (obj instanceof DomainParameters) {
            return (DomainParameters) obj;
        }
        if (obj != null) {
            return new DomainParameters(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public DomainParameters(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 3 || aSN1Sequence.size() > 5) {
            throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("Bad sequence size: ")));
        }
        Enumeration objects = aSN1Sequence.getObjects();
        this.a = ASN1Integer.getInstance(objects.nextElement());
        this.b = ASN1Integer.getInstance(objects.nextElement());
        this.c = ASN1Integer.getInstance(objects.nextElement());
        ASN1Encodable aSN1Encodable = objects.hasMoreElements() ? (ASN1Encodable) objects.nextElement() : null;
        if (aSN1Encodable == null || !(aSN1Encodable instanceof ASN1Integer)) {
            this.d = null;
        } else {
            this.d = ASN1Integer.getInstance(aSN1Encodable);
            aSN1Encodable = objects.hasMoreElements() ? (ASN1Encodable) objects.nextElement() : null;
        }
        if (aSN1Encodable != null) {
            this.e = ValidationParams.getInstance(aSN1Encodable.toASN1Primitive());
        } else {
            this.e = null;
        }
    }
}
