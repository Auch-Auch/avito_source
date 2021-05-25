package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
public class CertConfirmContent extends ASN1Object {
    public ASN1Sequence a;

    public CertConfirmContent(ASN1Sequence aSN1Sequence) {
        this.a = aSN1Sequence;
    }

    public static CertConfirmContent getInstance(Object obj) {
        if (obj instanceof CertConfirmContent) {
            return (CertConfirmContent) obj;
        }
        if (obj != null) {
            return new CertConfirmContent(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.a;
    }

    public CertStatus[] toCertStatusArray() {
        int size = this.a.size();
        CertStatus[] certStatusArr = new CertStatus[size];
        for (int i = 0; i != size; i++) {
            certStatusArr[i] = CertStatus.getInstance(this.a.getObjectAt(i));
        }
        return certStatusArr;
    }
}
