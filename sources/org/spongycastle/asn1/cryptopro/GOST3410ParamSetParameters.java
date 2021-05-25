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
public class GOST3410ParamSetParameters extends ASN1Object {
    public int a;
    public ASN1Integer b;
    public ASN1Integer c;
    public ASN1Integer d;

    public GOST3410ParamSetParameters(int i, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.a = i;
        this.b = new ASN1Integer(bigInteger);
        this.c = new ASN1Integer(bigInteger2);
        this.d = new ASN1Integer(bigInteger3);
    }

    public static GOST3410ParamSetParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public BigInteger getA() {
        return this.d.getPositiveValue();
    }

    public int getKeySize() {
        return this.a;
    }

    public int getLKeySize() {
        return this.a;
    }

    public BigInteger getP() {
        return this.b.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.c.getPositiveValue();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer((long) this.a));
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        aSN1EncodableVector.add(this.d);
        return new DERSequence(aSN1EncodableVector);
    }

    public static GOST3410ParamSetParameters getInstance(Object obj) {
        if (obj == null || (obj instanceof GOST3410ParamSetParameters)) {
            return (GOST3410ParamSetParameters) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new GOST3410ParamSetParameters((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("Invalid GOST3410Parameter: ")));
    }

    public GOST3410ParamSetParameters(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.a = ((ASN1Integer) objects.nextElement()).getValue().intValue();
        this.b = (ASN1Integer) objects.nextElement();
        this.c = (ASN1Integer) objects.nextElement();
        this.d = (ASN1Integer) objects.nextElement();
    }
}
