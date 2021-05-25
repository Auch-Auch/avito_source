package org.spongycastle.asn1.cmc;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
public class PKIData extends ASN1Object {
    public final TaggedAttribute[] a;
    public final TaggedRequest[] b;
    public final TaggedContentInfo[] c;
    public final OtherMsg[] d;

    public PKIData(TaggedAttribute[] taggedAttributeArr, TaggedRequest[] taggedRequestArr, TaggedContentInfo[] taggedContentInfoArr, OtherMsg[] otherMsgArr) {
        this.a = taggedAttributeArr;
        this.b = taggedRequestArr;
        this.c = taggedContentInfoArr;
        this.d = otherMsgArr;
    }

    public static PKIData getInstance(Object obj) {
        if (obj instanceof PKIData) {
            return (PKIData) obj;
        }
        if (obj != null) {
            return new PKIData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public TaggedContentInfo[] getCmsSequence() {
        return this.c;
    }

    public TaggedAttribute[] getControlSequence() {
        return this.a;
    }

    public OtherMsg[] getOtherMsgSequence() {
        return this.d;
    }

    public TaggedRequest[] getReqSequence() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{new DERSequence(this.a), new DERSequence(this.b), new DERSequence(this.c), new DERSequence(this.d)});
    }

    public PKIData(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 4) {
            int i = 0;
            ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Sequence.getObjectAt(0);
            this.a = new TaggedAttribute[aSN1Sequence2.size()];
            int i2 = 0;
            while (true) {
                TaggedAttribute[] taggedAttributeArr = this.a;
                if (i2 >= taggedAttributeArr.length) {
                    break;
                }
                taggedAttributeArr[i2] = TaggedAttribute.getInstance(aSN1Sequence2.getObjectAt(i2));
                i2++;
            }
            ASN1Sequence aSN1Sequence3 = (ASN1Sequence) aSN1Sequence.getObjectAt(1);
            this.b = new TaggedRequest[aSN1Sequence3.size()];
            int i3 = 0;
            while (true) {
                TaggedRequest[] taggedRequestArr = this.b;
                if (i3 >= taggedRequestArr.length) {
                    break;
                }
                taggedRequestArr[i3] = TaggedRequest.getInstance(aSN1Sequence3.getObjectAt(i3));
                i3++;
            }
            ASN1Sequence aSN1Sequence4 = (ASN1Sequence) aSN1Sequence.getObjectAt(2);
            this.c = new TaggedContentInfo[aSN1Sequence4.size()];
            int i4 = 0;
            while (true) {
                TaggedContentInfo[] taggedContentInfoArr = this.c;
                if (i4 >= taggedContentInfoArr.length) {
                    break;
                }
                taggedContentInfoArr[i4] = TaggedContentInfo.getInstance(aSN1Sequence4.getObjectAt(i4));
                i4++;
            }
            ASN1Sequence aSN1Sequence5 = (ASN1Sequence) aSN1Sequence.getObjectAt(3);
            this.d = new OtherMsg[aSN1Sequence5.size()];
            while (true) {
                OtherMsg[] otherMsgArr = this.d;
                if (i < otherMsgArr.length) {
                    otherMsgArr[i] = OtherMsg.getInstance(aSN1Sequence5.getObjectAt(i));
                    i++;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Sequence not 4 elements.");
        }
    }
}
