package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.CertificateList;
public class TimeStampAndCRL extends ASN1Object {
    public ContentInfo a;
    public CertificateList b;

    public TimeStampAndCRL(ContentInfo contentInfo) {
        this.a = contentInfo;
    }

    public static TimeStampAndCRL getInstance(Object obj) {
        if (obj instanceof TimeStampAndCRL) {
            return (TimeStampAndCRL) obj;
        }
        if (obj != null) {
            return new TimeStampAndCRL(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CertificateList getCRL() {
        return this.b;
    }

    public CertificateList getCertificateList() {
        return this.b;
    }

    public ContentInfo getTimeStampToken() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        CertificateList certificateList = this.b;
        if (certificateList != null) {
            aSN1EncodableVector.add(certificateList);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public TimeStampAndCRL(ASN1Sequence aSN1Sequence) {
        this.a = ContentInfo.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() == 2) {
            this.b = CertificateList.getInstance(aSN1Sequence.getObjectAt(1));
        }
    }
}
