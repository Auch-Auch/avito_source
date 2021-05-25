package org.spongycastle.asn1.eac;

import a2.b.a.a.a;
import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
public class RSAPublicKey extends PublicKeyDataObject {
    public ASN1ObjectIdentifier a;
    public BigInteger b;
    public BigInteger c;
    public int d = 0;

    public RSAPublicKey(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.a = ASN1ObjectIdentifier.getInstance(objects.nextElement());
        while (objects.hasMoreElements()) {
            UnsignedInteger instance = UnsignedInteger.getInstance(objects.nextElement());
            int tagNo = instance.getTagNo();
            if (tagNo == 1) {
                int i = this.d;
                if ((i & 1) == 0) {
                    this.d = i | 1;
                    this.b = instance.getValue();
                } else {
                    throw new IllegalArgumentException("Modulus already set");
                }
            } else if (tagNo == 2) {
                int i2 = this.d;
                if ((i2 & 2) == 0) {
                    this.d = i2 | 2;
                    this.c = instance.getValue();
                } else {
                    throw new IllegalArgumentException("Exponent already set");
                }
            } else {
                StringBuilder L = a.L("Unknown DERTaggedObject :");
                L.append(instance.getTagNo());
                L.append("-> not an Iso7816RSAPublicKeyStructure");
                throw new IllegalArgumentException(L.toString());
            }
        }
        if (this.d != 3) {
            throw new IllegalArgumentException("missing argument -> not an Iso7816RSAPublicKeyStructure");
        }
    }

    public BigInteger getModulus() {
        return this.b;
    }

    public BigInteger getPublicExponent() {
        return this.c;
    }

    @Override // org.spongycastle.asn1.eac.PublicKeyDataObject
    public ASN1ObjectIdentifier getUsage() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(new UnsignedInteger(1, getModulus()));
        aSN1EncodableVector.add(new UnsignedInteger(2, getPublicExponent()));
        return new DERSequence(aSN1EncodableVector);
    }

    public RSAPublicKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, BigInteger bigInteger, BigInteger bigInteger2) {
        this.a = aSN1ObjectIdentifier;
        this.b = bigInteger;
        this.c = bigInteger2;
    }
}
