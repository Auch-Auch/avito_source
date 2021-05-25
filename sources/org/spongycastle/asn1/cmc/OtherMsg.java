package org.spongycastle.asn1.cmc;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
public class OtherMsg extends ASN1Object {
    public final BodyPartID a;
    public final ASN1ObjectIdentifier b;
    public final ASN1Encodable c;

    public OtherMsg(BodyPartID bodyPartID, ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.a = bodyPartID;
        this.b = aSN1ObjectIdentifier;
        this.c = aSN1Encodable;
    }

    public static OtherMsg getInstance(Object obj) {
        if (obj instanceof OtherMsg) {
            return (OtherMsg) obj;
        }
        if (obj != null) {
            return new OtherMsg(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BodyPartID getBodyPartID() {
        return this.a;
    }

    public ASN1ObjectIdentifier getOtherMsgType() {
        return this.b;
    }

    public ASN1Encodable getOtherMsgValue() {
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

    public static OtherMsg getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public OtherMsg(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 3) {
            this.a = BodyPartID.getInstance(aSN1Sequence.getObjectAt(0));
            this.b = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
            this.c = aSN1Sequence.getObjectAt(2);
            return;
        }
        throw new IllegalArgumentException("incorrect sequence size");
    }
}
