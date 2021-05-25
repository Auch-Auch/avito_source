package org.spongycastle.asn1.cms;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
public class OriginatorInfo extends ASN1Object {
    public ASN1Set a;
    public ASN1Set b;

    public OriginatorInfo(ASN1Set aSN1Set, ASN1Set aSN1Set2) {
        this.a = aSN1Set;
        this.b = aSN1Set2;
    }

    public static OriginatorInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public ASN1Set getCRLs() {
        return this.b;
    }

    public ASN1Set getCertificates() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1Set aSN1Set = this.a;
        if (aSN1Set != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, aSN1Set));
        }
        ASN1Set aSN1Set2 = this.b;
        if (aSN1Set2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, aSN1Set2));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public static OriginatorInfo getInstance(Object obj) {
        if (obj instanceof OriginatorInfo) {
            return (OriginatorInfo) obj;
        }
        if (obj != null) {
            return new OriginatorInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public OriginatorInfo(ASN1Sequence aSN1Sequence) {
        int size = aSN1Sequence.size();
        if (size == 0) {
            return;
        }
        if (size == 1) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(0);
            int tagNo = aSN1TaggedObject.getTagNo();
            if (tagNo == 0) {
                this.a = ASN1Set.getInstance(aSN1TaggedObject, false);
            } else if (tagNo == 1) {
                this.b = ASN1Set.getInstance(aSN1TaggedObject, false);
            } else {
                throw new IllegalArgumentException(a.D(aSN1TaggedObject, a.L("Bad tag in OriginatorInfo: ")));
            }
        } else if (size == 2) {
            this.a = ASN1Set.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(0), false);
            this.b = ASN1Set.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), false);
        } else {
            throw new IllegalArgumentException("OriginatorInfo too big");
        }
    }
}
