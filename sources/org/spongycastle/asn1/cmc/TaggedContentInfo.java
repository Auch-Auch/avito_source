package org.spongycastle.asn1.cmc;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.cms.ContentInfo;
public class TaggedContentInfo extends ASN1Object {
    public final BodyPartID a;
    public final ContentInfo b;

    public TaggedContentInfo(BodyPartID bodyPartID, ContentInfo contentInfo) {
        this.a = bodyPartID;
        this.b = contentInfo;
    }

    public static TaggedContentInfo getInstance(Object obj) {
        if (obj instanceof TaggedContentInfo) {
            return (TaggedContentInfo) obj;
        }
        if (obj != null) {
            return new TaggedContentInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BodyPartID getBodyPartID() {
        return this.a;
    }

    public ContentInfo getContentInfo() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        return new DERSequence(aSN1EncodableVector);
    }

    public TaggedContentInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.a = BodyPartID.getInstance(aSN1Sequence.getObjectAt(0));
            this.b = ContentInfo.getInstance(aSN1Sequence.getObjectAt(1));
            return;
        }
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public static TaggedContentInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
