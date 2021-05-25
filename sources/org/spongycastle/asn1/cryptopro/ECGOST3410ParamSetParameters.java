package org.spongycastle.asn1.cryptopro;

import a2.b.a.a.a;
import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
public class ECGOST3410ParamSetParameters extends ASN1Object {
    public ASN1Integer a;
    public ASN1Integer b;
    public ASN1Integer c;
    public ASN1Integer d;
    public ASN1Integer e;
    public ASN1Integer f;

    public ECGOST3410ParamSetParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i, BigInteger bigInteger5) {
        this.c = new ASN1Integer(bigInteger);
        this.d = new ASN1Integer(bigInteger2);
        this.a = new ASN1Integer(bigInteger3);
        this.b = new ASN1Integer(bigInteger4);
        this.e = new ASN1Integer((long) i);
        this.f = new ASN1Integer(bigInteger5);
    }

    public static ECGOST3410ParamSetParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public BigInteger getA() {
        return this.c.getPositiveValue();
    }

    public BigInteger getP() {
        return this.a.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.b.getPositiveValue();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.c);
        aSN1EncodableVector.add(this.d);
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.e);
        aSN1EncodableVector.add(this.f);
        return new DERSequence(aSN1EncodableVector);
    }

    public static ECGOST3410ParamSetParameters getInstance(Object obj) {
        if (obj == null || (obj instanceof ECGOST3410ParamSetParameters)) {
            return (ECGOST3410ParamSetParameters) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new ECGOST3410ParamSetParameters((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("Invalid GOST3410Parameter: ")));
    }

    public ECGOST3410ParamSetParameters(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.c = (ASN1Integer) objects.nextElement();
        this.d = (ASN1Integer) objects.nextElement();
        this.a = (ASN1Integer) objects.nextElement();
        this.b = (ASN1Integer) objects.nextElement();
        this.e = (ASN1Integer) objects.nextElement();
        this.f = (ASN1Integer) objects.nextElement();
    }
}
