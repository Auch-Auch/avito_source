package org.spongycastle.asn1.pkcs;

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
public class RSAPrivateKeyStructure extends ASN1Object {
    public int a;
    public BigInteger b;
    public BigInteger c;
    public BigInteger d;
    public BigInteger e;
    public BigInteger f;
    public BigInteger g;
    public BigInteger h;
    public BigInteger i;
    public ASN1Sequence j;

    public RSAPrivateKeyStructure(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
        this.j = null;
        this.a = 0;
        this.b = bigInteger;
        this.c = bigInteger2;
        this.d = bigInteger3;
        this.e = bigInteger4;
        this.f = bigInteger5;
        this.g = bigInteger6;
        this.h = bigInteger7;
        this.i = bigInteger8;
    }

    public static RSAPrivateKeyStructure getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public BigInteger getCoefficient() {
        return this.i;
    }

    public BigInteger getExponent1() {
        return this.g;
    }

    public BigInteger getExponent2() {
        return this.h;
    }

    public BigInteger getModulus() {
        return this.b;
    }

    public BigInteger getPrime1() {
        return this.e;
    }

    public BigInteger getPrime2() {
        return this.f;
    }

    public BigInteger getPrivateExponent() {
        return this.d;
    }

    public BigInteger getPublicExponent() {
        return this.c;
    }

    public int getVersion() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer((long) this.a));
        aSN1EncodableVector.add(new ASN1Integer(getModulus()));
        aSN1EncodableVector.add(new ASN1Integer(getPublicExponent()));
        aSN1EncodableVector.add(new ASN1Integer(getPrivateExponent()));
        aSN1EncodableVector.add(new ASN1Integer(getPrime1()));
        aSN1EncodableVector.add(new ASN1Integer(getPrime2()));
        aSN1EncodableVector.add(new ASN1Integer(getExponent1()));
        aSN1EncodableVector.add(new ASN1Integer(getExponent2()));
        aSN1EncodableVector.add(new ASN1Integer(getCoefficient()));
        ASN1Sequence aSN1Sequence = this.j;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.add(aSN1Sequence);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public static RSAPrivateKeyStructure getInstance(Object obj) {
        if (obj instanceof RSAPrivateKeyStructure) {
            return (RSAPrivateKeyStructure) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new RSAPrivateKeyStructure((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("unknown object in factory: ")));
    }

    public RSAPrivateKeyStructure(ASN1Sequence aSN1Sequence) {
        this.j = null;
        Enumeration objects = aSN1Sequence.getObjects();
        BigInteger value = ((ASN1Integer) objects.nextElement()).getValue();
        if (value.intValue() == 0 || value.intValue() == 1) {
            this.a = value.intValue();
            this.b = ((ASN1Integer) objects.nextElement()).getValue();
            this.c = ((ASN1Integer) objects.nextElement()).getValue();
            this.d = ((ASN1Integer) objects.nextElement()).getValue();
            this.e = ((ASN1Integer) objects.nextElement()).getValue();
            this.f = ((ASN1Integer) objects.nextElement()).getValue();
            this.g = ((ASN1Integer) objects.nextElement()).getValue();
            this.h = ((ASN1Integer) objects.nextElement()).getValue();
            this.i = ((ASN1Integer) objects.nextElement()).getValue();
            if (objects.hasMoreElements()) {
                this.j = (ASN1Sequence) objects.nextElement();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("wrong version for RSA private key");
    }
}
