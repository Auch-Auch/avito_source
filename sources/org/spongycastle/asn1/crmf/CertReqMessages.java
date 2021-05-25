package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
public class CertReqMessages extends ASN1Object {
    public ASN1Sequence a;

    public CertReqMessages(ASN1Sequence aSN1Sequence) {
        this.a = aSN1Sequence;
    }

    public static CertReqMessages getInstance(Object obj) {
        if (obj instanceof CertReqMessages) {
            return (CertReqMessages) obj;
        }
        if (obj != null) {
            return new CertReqMessages(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.a;
    }

    public CertReqMsg[] toCertReqMsgArray() {
        int size = this.a.size();
        CertReqMsg[] certReqMsgArr = new CertReqMsg[size];
        for (int i = 0; i != size; i++) {
            certReqMsgArr[i] = CertReqMsg.getInstance(this.a.getObjectAt(i));
        }
        return certReqMsgArr;
    }

    public CertReqMessages(CertReqMsg certReqMsg) {
        this.a = new DERSequence(certReqMsg);
    }

    public CertReqMessages(CertReqMsg[] certReqMsgArr) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (CertReqMsg certReqMsg : certReqMsgArr) {
            aSN1EncodableVector.add(certReqMsg);
        }
        this.a = new DERSequence(aSN1EncodableVector);
    }
}
