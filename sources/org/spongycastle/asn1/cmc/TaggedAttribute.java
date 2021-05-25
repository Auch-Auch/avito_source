package org.spongycastle.asn1.cmc;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.DERSequence;
public class TaggedAttribute extends ASN1Object {
    public final BodyPartID a;
    public final ASN1ObjectIdentifier b;
    public final ASN1Set c;

    public TaggedAttribute(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 3) {
            this.a = BodyPartID.getInstance(aSN1Sequence.getObjectAt(0));
            this.b = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
            this.c = ASN1Set.getInstance(aSN1Sequence.getObjectAt(2));
            return;
        }
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public static TaggedAttribute getInstance(Object obj) {
        if (obj instanceof TaggedAttribute) {
            return (TaggedAttribute) obj;
        }
        if (obj != null) {
            return new TaggedAttribute(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1ObjectIdentifier getAttrType() {
        return this.b;
    }

    public ASN1Set getAttrValues() {
        return this.c;
    }

    public BodyPartID getBodyPartID() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.a, this.b, this.c});
    }

    public TaggedAttribute(BodyPartID bodyPartID, ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Set aSN1Set) {
        this.a = bodyPartID;
        this.b = aSN1ObjectIdentifier;
        this.c = aSN1Set;
    }
}
