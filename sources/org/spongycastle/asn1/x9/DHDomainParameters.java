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
public class DHDomainParameters extends ASN1Object {
    public ASN1Integer a;
    public ASN1Integer b;
    public ASN1Integer c;
    public ASN1Integer d;
    public DHValidationParms e;

    public DHDomainParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, DHValidationParms dHValidationParms) {
        if (bigInteger == null) {
            throw new IllegalArgumentException("'p' cannot be null");
        } else if (bigInteger2 == null) {
            throw new IllegalArgumentException("'g' cannot be null");
        } else if (bigInteger3 != null) {
            this.a = new ASN1Integer(bigInteger);
            this.b = new ASN1Integer(bigInteger2);
            this.c = new ASN1Integer(bigInteger3);
            this.d = new ASN1Integer(bigInteger4);
            this.e = dHValidationParms;
        } else {
            throw new IllegalArgumentException("'q' cannot be null");
        }
    }

    public static DHDomainParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public ASN1Integer getG() {
        return this.b;
    }

    public ASN1Integer getJ() {
        return this.d;
    }

    public ASN1Integer getP() {
        return this.a;
    }

    public ASN1Integer getQ() {
        return this.c;
    }

    public DHValidationParms getValidationParms() {
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
        DHValidationParms dHValidationParms = this.e;
        if (dHValidationParms != null) {
            aSN1EncodableVector.add(dHValidationParms);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public static DHDomainParameters getInstance(Object obj) {
        if (obj == null || (obj instanceof DHDomainParameters)) {
            return (DHDomainParameters) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new DHDomainParameters((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("Invalid DHDomainParameters: ")));
    }

    public DHDomainParameters(ASN1Integer aSN1Integer, ASN1Integer aSN1Integer2, ASN1Integer aSN1Integer3, ASN1Integer aSN1Integer4, DHValidationParms dHValidationParms) {
        if (aSN1Integer == null) {
            throw new IllegalArgumentException("'p' cannot be null");
        } else if (aSN1Integer2 == null) {
            throw new IllegalArgumentException("'g' cannot be null");
        } else if (aSN1Integer3 != null) {
            this.a = aSN1Integer;
            this.b = aSN1Integer2;
            this.c = aSN1Integer3;
            this.d = aSN1Integer4;
            this.e = dHValidationParms;
        } else {
            throw new IllegalArgumentException("'q' cannot be null");
        }
    }

    public DHDomainParameters(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 3 || aSN1Sequence.size() > 5) {
            throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("Bad sequence size: ")));
        }
        Enumeration objects = aSN1Sequence.getObjects();
        this.a = ASN1Integer.getInstance(objects.nextElement());
        this.b = ASN1Integer.getInstance(objects.nextElement());
        this.c = ASN1Integer.getInstance(objects.nextElement());
        ASN1Encodable aSN1Encodable = null;
        ASN1Encodable aSN1Encodable2 = objects.hasMoreElements() ? (ASN1Encodable) objects.nextElement() : null;
        if (aSN1Encodable2 != null && (aSN1Encodable2 instanceof ASN1Integer)) {
            this.d = ASN1Integer.getInstance(aSN1Encodable2);
            aSN1Encodable2 = objects.hasMoreElements() ? (ASN1Encodable) objects.nextElement() : aSN1Encodable;
        }
        if (aSN1Encodable2 != null) {
            this.e = DHValidationParms.getInstance(aSN1Encodable2.toASN1Primitive());
        }
    }
}
