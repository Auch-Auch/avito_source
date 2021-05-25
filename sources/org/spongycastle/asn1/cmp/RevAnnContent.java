package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.crmf.CertId;
import org.spongycastle.asn1.x509.Extensions;
public class RevAnnContent extends ASN1Object {
    public PKIStatus a;
    public CertId b;
    public ASN1GeneralizedTime c;
    public ASN1GeneralizedTime d;
    public Extensions e;

    public RevAnnContent(ASN1Sequence aSN1Sequence) {
        this.a = PKIStatus.getInstance(aSN1Sequence.getObjectAt(0));
        this.b = CertId.getInstance(aSN1Sequence.getObjectAt(1));
        this.c = ASN1GeneralizedTime.getInstance(aSN1Sequence.getObjectAt(2));
        this.d = ASN1GeneralizedTime.getInstance(aSN1Sequence.getObjectAt(3));
        if (aSN1Sequence.size() > 4) {
            this.e = Extensions.getInstance(aSN1Sequence.getObjectAt(4));
        }
    }

    public static RevAnnContent getInstance(Object obj) {
        if (obj instanceof RevAnnContent) {
            return (RevAnnContent) obj;
        }
        if (obj != null) {
            return new RevAnnContent(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1GeneralizedTime getBadSinceDate() {
        return this.d;
    }

    public CertId getCertId() {
        return this.b;
    }

    public Extensions getCrlDetails() {
        return this.e;
    }

    public PKIStatus getStatus() {
        return this.a;
    }

    public ASN1GeneralizedTime getWillBeRevokedAt() {
        return this.c;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        aSN1EncodableVector.add(this.d);
        Extensions extensions = this.e;
        if (extensions != null) {
            aSN1EncodableVector.add(extensions);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
