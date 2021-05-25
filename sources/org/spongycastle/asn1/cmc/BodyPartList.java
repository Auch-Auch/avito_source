package org.spongycastle.asn1.cmc;

import androidx.appcompat.app.AppCompatDelegateImpl;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
public class BodyPartList extends ASN1Object {
    public final BodyPartID[] a;

    public BodyPartList(BodyPartID bodyPartID) {
        this.a = new BodyPartID[]{bodyPartID};
    }

    public static BodyPartList getInstance(Object obj) {
        if (obj instanceof BodyPartList) {
            return (BodyPartList) obj;
        }
        if (obj != null) {
            return new BodyPartList(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BodyPartID[] getBodyPartIDs() {
        return AppCompatDelegateImpl.i.H(this.a);
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.a);
    }

    public BodyPartList(BodyPartID[] bodyPartIDArr) {
        BodyPartID[] bodyPartIDArr2 = new BodyPartID[bodyPartIDArr.length];
        System.arraycopy(bodyPartIDArr, 0, bodyPartIDArr2, 0, bodyPartIDArr.length);
        this.a = bodyPartIDArr2;
    }

    public static BodyPartList getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public BodyPartList(ASN1Sequence aSN1Sequence) {
        this.a = AppCompatDelegateImpl.i.Y1(aSN1Sequence);
    }
}
