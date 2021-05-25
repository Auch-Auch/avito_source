package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
public class OtherRecipientInfo extends ASN1Object {
    public ASN1ObjectIdentifier a;
    public ASN1Encodable b;

    public OtherRecipientInfo(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.a = aSN1ObjectIdentifier;
        this.b = aSN1Encodable;
    }

    public static OtherRecipientInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public ASN1ObjectIdentifier getType() {
        return this.a;
    }

    public ASN1Encodable getValue() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        return new DERSequence(aSN1EncodableVector);
    }

    public static OtherRecipientInfo getInstance(Object obj) {
        if (obj instanceof OtherRecipientInfo) {
            return (OtherRecipientInfo) obj;
        }
        if (obj != null) {
            return new OtherRecipientInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public OtherRecipientInfo(ASN1Sequence aSN1Sequence) {
        this.a = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.b = aSN1Sequence.getObjectAt(1);
    }
}
