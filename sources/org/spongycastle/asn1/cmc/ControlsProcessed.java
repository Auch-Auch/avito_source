package org.spongycastle.asn1.cmc;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
public class ControlsProcessed extends ASN1Object {
    public final ASN1Sequence a;

    public ControlsProcessed(BodyPartReference bodyPartReference) {
        this.a = new DERSequence(bodyPartReference);
    }

    public static ControlsProcessed getInstance(Object obj) {
        if (obj instanceof ControlsProcessed) {
            return (ControlsProcessed) obj;
        }
        if (obj != null) {
            return new ControlsProcessed(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BodyPartReference[] getBodyList() {
        BodyPartReference[] bodyPartReferenceArr = new BodyPartReference[this.a.size()];
        for (int i = 0; i != this.a.size(); i++) {
            bodyPartReferenceArr[i] = BodyPartReference.getInstance(this.a.getObjectAt(i));
        }
        return bodyPartReferenceArr;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.a);
    }

    public ControlsProcessed(BodyPartReference[] bodyPartReferenceArr) {
        this.a = new DERSequence(bodyPartReferenceArr);
    }

    public ControlsProcessed(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 1) {
            this.a = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(0));
            return;
        }
        throw new IllegalArgumentException("incorrect sequence size");
    }
}
