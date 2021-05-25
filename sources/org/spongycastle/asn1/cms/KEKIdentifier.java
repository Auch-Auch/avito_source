package org.spongycastle.asn1.cms;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
public class KEKIdentifier extends ASN1Object {
    public ASN1OctetString a;
    public ASN1GeneralizedTime b;
    public OtherKeyAttribute c;

    public KEKIdentifier(byte[] bArr, ASN1GeneralizedTime aSN1GeneralizedTime, OtherKeyAttribute otherKeyAttribute) {
        this.a = new DEROctetString(bArr);
        this.b = aSN1GeneralizedTime;
        this.c = otherKeyAttribute;
    }

    public static KEKIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public ASN1GeneralizedTime getDate() {
        return this.b;
    }

    public ASN1OctetString getKeyIdentifier() {
        return this.a;
    }

    public OtherKeyAttribute getOther() {
        return this.c;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        ASN1GeneralizedTime aSN1GeneralizedTime = this.b;
        if (aSN1GeneralizedTime != null) {
            aSN1EncodableVector.add(aSN1GeneralizedTime);
        }
        OtherKeyAttribute otherKeyAttribute = this.c;
        if (otherKeyAttribute != null) {
            aSN1EncodableVector.add(otherKeyAttribute);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public static KEKIdentifier getInstance(Object obj) {
        if (obj == null || (obj instanceof KEKIdentifier)) {
            return (KEKIdentifier) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new KEKIdentifier((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("Invalid KEKIdentifier: ")));
    }

    public KEKIdentifier(ASN1Sequence aSN1Sequence) {
        this.a = (ASN1OctetString) aSN1Sequence.getObjectAt(0);
        int size = aSN1Sequence.size();
        if (size == 1) {
            return;
        }
        if (size != 2) {
            if (size == 3) {
                this.b = (ASN1GeneralizedTime) aSN1Sequence.getObjectAt(1);
                this.c = OtherKeyAttribute.getInstance(aSN1Sequence.getObjectAt(2));
                return;
            }
            throw new IllegalArgumentException("Invalid KEKIdentifier");
        } else if (aSN1Sequence.getObjectAt(1) instanceof ASN1GeneralizedTime) {
            this.b = (ASN1GeneralizedTime) aSN1Sequence.getObjectAt(1);
        } else {
            this.c = OtherKeyAttribute.getInstance(aSN1Sequence.getObjectAt(1));
        }
    }
}
