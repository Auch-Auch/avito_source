package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
public class PKIMessages extends ASN1Object {
    public ASN1Sequence a;

    public PKIMessages(ASN1Sequence aSN1Sequence) {
        this.a = aSN1Sequence;
    }

    public static PKIMessages getInstance(Object obj) {
        if (obj instanceof PKIMessages) {
            return (PKIMessages) obj;
        }
        if (obj != null) {
            return new PKIMessages(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.a;
    }

    public PKIMessage[] toPKIMessageArray() {
        int size = this.a.size();
        PKIMessage[] pKIMessageArr = new PKIMessage[size];
        for (int i = 0; i != size; i++) {
            pKIMessageArr[i] = PKIMessage.getInstance(this.a.getObjectAt(i));
        }
        return pKIMessageArr;
    }

    public PKIMessages(PKIMessage pKIMessage) {
        this.a = new DERSequence(pKIMessage);
    }

    public PKIMessages(PKIMessage[] pKIMessageArr) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (PKIMessage pKIMessage : pKIMessageArr) {
            aSN1EncodableVector.add(pKIMessage);
        }
        this.a = new DERSequence(aSN1EncodableVector);
    }
}
