package org.spongycastle.asn1.tsp;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.cmp.PKIStatusInfo;
import org.spongycastle.asn1.cms.ContentInfo;
public class TimeStampResp extends ASN1Object {
    public PKIStatusInfo a;
    public ContentInfo b;

    public TimeStampResp(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.a = PKIStatusInfo.getInstance(objects.nextElement());
        if (objects.hasMoreElements()) {
            this.b = ContentInfo.getInstance(objects.nextElement());
        }
    }

    public static TimeStampResp getInstance(Object obj) {
        if (obj instanceof TimeStampResp) {
            return (TimeStampResp) obj;
        }
        if (obj != null) {
            return new TimeStampResp(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public PKIStatusInfo getStatus() {
        return this.a;
    }

    public ContentInfo getTimeStampToken() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        ContentInfo contentInfo = this.b;
        if (contentInfo != null) {
            aSN1EncodableVector.add(contentInfo);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public TimeStampResp(PKIStatusInfo pKIStatusInfo, ContentInfo contentInfo) {
        this.a = pKIStatusInfo;
        this.b = contentInfo;
    }
}
