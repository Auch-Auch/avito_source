package org.spongycastle.asn1.cmc;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
public class PKIResponse extends ASN1Object {
    public final ASN1Sequence a;
    public final ASN1Sequence b;
    public final ASN1Sequence c;

    public PKIResponse(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 3) {
            this.a = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(0));
            this.b = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
            this.c = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(2));
            return;
        }
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public static PKIResponse getInstance(Object obj) {
        if (obj instanceof PKIResponse) {
            return (PKIResponse) obj;
        }
        if (obj != null) {
            return new PKIResponse(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Sequence getCmsSequence() {
        return this.b;
    }

    public ASN1Sequence getControlSequence() {
        return this.a;
    }

    public ASN1Sequence getOtherMsgSequence() {
        return this.c;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        return new DERSequence(aSN1EncodableVector);
    }

    public static PKIResponse getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
