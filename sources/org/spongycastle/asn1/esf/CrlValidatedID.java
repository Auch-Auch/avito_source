package org.spongycastle.asn1.esf;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
public class CrlValidatedID extends ASN1Object {
    public OtherHash a;
    public CrlIdentifier b;

    public CrlValidatedID(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 1 || aSN1Sequence.size() > 2) {
            throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("Bad sequence size: ")));
        }
        this.a = OtherHash.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() > 1) {
            this.b = CrlIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        }
    }

    public static CrlValidatedID getInstance(Object obj) {
        if (obj instanceof CrlValidatedID) {
            return (CrlValidatedID) obj;
        }
        if (obj != null) {
            return new CrlValidatedID(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public OtherHash getCrlHash() {
        return this.a;
    }

    public CrlIdentifier getCrlIdentifier() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a.toASN1Primitive());
        CrlIdentifier crlIdentifier = this.b;
        if (crlIdentifier != null) {
            aSN1EncodableVector.add(crlIdentifier.toASN1Primitive());
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public CrlValidatedID(OtherHash otherHash) {
        this(otherHash, null);
    }

    public CrlValidatedID(OtherHash otherHash, CrlIdentifier crlIdentifier) {
        this.a = otherHash;
        this.b = crlIdentifier;
    }
}
