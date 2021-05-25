package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
public class PollReqContent extends ASN1Object {
    public ASN1Sequence a;

    public PollReqContent(ASN1Sequence aSN1Sequence) {
        this.a = aSN1Sequence;
    }

    public static PollReqContent getInstance(Object obj) {
        if (obj instanceof PollReqContent) {
            return (PollReqContent) obj;
        }
        if (obj != null) {
            return new PollReqContent(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Integer[][] getCertReqIds() {
        int size = this.a.size();
        ASN1Integer[][] aSN1IntegerArr = new ASN1Integer[size][];
        for (int i = 0; i != size; i++) {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) this.a.getObjectAt(i);
            int size2 = aSN1Sequence.size();
            ASN1Integer[] aSN1IntegerArr2 = new ASN1Integer[size2];
            for (int i2 = 0; i2 != size2; i2++) {
                aSN1IntegerArr2[i2] = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(i2));
            }
            aSN1IntegerArr[i] = aSN1IntegerArr2;
        }
        return aSN1IntegerArr;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.a;
    }

    public PollReqContent(ASN1Integer aSN1Integer) {
        this.a = new DERSequence(new DERSequence(aSN1Integer));
    }
}
