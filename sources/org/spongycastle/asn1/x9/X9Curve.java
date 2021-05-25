package org.spongycastle.asn1.x9;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECCurve;
public class X9Curve extends ASN1Object implements X9ObjectIdentifiers {
    public ECCurve a;
    public byte[] b;
    public ASN1ObjectIdentifier c = null;

    public X9Curve(ECCurve eCCurve) {
        this.a = eCCurve;
        this.b = null;
        a();
    }

    public final void a() {
        if (ECAlgorithms.isFpCurve(this.a)) {
            this.c = X9ObjectIdentifiers.prime_field;
        } else if (ECAlgorithms.isF2mCurve(this.a)) {
            this.c = X9ObjectIdentifiers.characteristic_two_field;
        } else {
            throw new IllegalArgumentException("This type of ECCurve is not implemented");
        }
    }

    public ECCurve getCurve() {
        return this.a;
    }

    public byte[] getSeed() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.c.equals(X9ObjectIdentifiers.prime_field)) {
            aSN1EncodableVector.add(new X9FieldElement(this.a.getA()).toASN1Primitive());
            aSN1EncodableVector.add(new X9FieldElement(this.a.getB()).toASN1Primitive());
        } else if (this.c.equals(X9ObjectIdentifiers.characteristic_two_field)) {
            aSN1EncodableVector.add(new X9FieldElement(this.a.getA()).toASN1Primitive());
            aSN1EncodableVector.add(new X9FieldElement(this.a.getB()).toASN1Primitive());
        }
        byte[] bArr = this.b;
        if (bArr != null) {
            aSN1EncodableVector.add(new DERBitString(bArr));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public X9Curve(ECCurve eCCurve, byte[] bArr) {
        this.a = eCCurve;
        this.b = bArr;
        a();
    }

    public X9Curve(X9FieldID x9FieldID, ASN1Sequence aSN1Sequence) {
        int i;
        int i2;
        int i3;
        ASN1ObjectIdentifier identifier = x9FieldID.getIdentifier();
        this.c = identifier;
        if (identifier.equals(X9ObjectIdentifiers.prime_field)) {
            BigInteger value = ((ASN1Integer) x9FieldID.getParameters()).getValue();
            this.a = new ECCurve.Fp(value, new X9FieldElement(value, (ASN1OctetString) aSN1Sequence.getObjectAt(0)).getValue().toBigInteger(), new X9FieldElement(value, (ASN1OctetString) aSN1Sequence.getObjectAt(1)).getValue().toBigInteger());
        } else if (this.c.equals(X9ObjectIdentifiers.characteristic_two_field)) {
            ASN1Sequence instance = ASN1Sequence.getInstance(x9FieldID.getParameters());
            int intValue = ((ASN1Integer) instance.getObjectAt(0)).getValue().intValue();
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) instance.getObjectAt(1);
            if (aSN1ObjectIdentifier.equals(X9ObjectIdentifiers.tpBasis)) {
                i = ASN1Integer.getInstance(instance.getObjectAt(2)).getValue().intValue();
                i3 = 0;
                i2 = 0;
            } else if (aSN1ObjectIdentifier.equals(X9ObjectIdentifiers.ppBasis)) {
                ASN1Sequence instance2 = ASN1Sequence.getInstance(instance.getObjectAt(2));
                int intValue2 = ASN1Integer.getInstance(instance2.getObjectAt(0)).getValue().intValue();
                int intValue3 = ASN1Integer.getInstance(instance2.getObjectAt(1)).getValue().intValue();
                i2 = ASN1Integer.getInstance(instance2.getObjectAt(2)).getValue().intValue();
                i = intValue2;
                i3 = intValue3;
            } else {
                throw new IllegalArgumentException("This type of EC basis is not implemented");
            }
            this.a = new ECCurve.F2m(intValue, i, i3, i2, new X9FieldElement(intValue, i, i3, i2, (ASN1OctetString) aSN1Sequence.getObjectAt(0)).getValue().toBigInteger(), new X9FieldElement(intValue, i, i3, i2, (ASN1OctetString) aSN1Sequence.getObjectAt(1)).getValue().toBigInteger());
        } else {
            throw new IllegalArgumentException("This type of ECCurve is not implemented");
        }
        if (aSN1Sequence.size() == 3) {
            this.b = ((DERBitString) aSN1Sequence.getObjectAt(2)).getBytes();
        }
    }
}
