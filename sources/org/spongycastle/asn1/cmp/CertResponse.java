package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
public class CertResponse extends ASN1Object {
    public ASN1Integer a;
    public PKIStatusInfo b;
    public CertifiedKeyPair c;
    public ASN1OctetString d;

    public CertResponse(ASN1Sequence aSN1Sequence) {
        this.a = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        this.b = PKIStatusInfo.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.size() < 3) {
            return;
        }
        if (aSN1Sequence.size() == 3) {
            ASN1Encodable objectAt = aSN1Sequence.getObjectAt(2);
            if (objectAt instanceof ASN1OctetString) {
                this.d = ASN1OctetString.getInstance(objectAt);
            } else {
                this.c = CertifiedKeyPair.getInstance(objectAt);
            }
        } else {
            this.c = CertifiedKeyPair.getInstance(aSN1Sequence.getObjectAt(2));
            this.d = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(3));
        }
    }

    public static CertResponse getInstance(Object obj) {
        if (obj instanceof CertResponse) {
            return (CertResponse) obj;
        }
        if (obj != null) {
            return new CertResponse(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Integer getCertReqId() {
        return this.a;
    }

    public CertifiedKeyPair getCertifiedKeyPair() {
        return this.c;
    }

    public PKIStatusInfo getStatus() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        CertifiedKeyPair certifiedKeyPair = this.c;
        if (certifiedKeyPair != null) {
            aSN1EncodableVector.add(certifiedKeyPair);
        }
        ASN1OctetString aSN1OctetString = this.d;
        if (aSN1OctetString != null) {
            aSN1EncodableVector.add(aSN1OctetString);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public CertResponse(ASN1Integer aSN1Integer, PKIStatusInfo pKIStatusInfo) {
        this(aSN1Integer, pKIStatusInfo, null, null);
    }

    public CertResponse(ASN1Integer aSN1Integer, PKIStatusInfo pKIStatusInfo, CertifiedKeyPair certifiedKeyPair, ASN1OctetString aSN1OctetString) {
        if (aSN1Integer == null) {
            throw new IllegalArgumentException("'certReqId' cannot be null");
        } else if (pKIStatusInfo != null) {
            this.a = aSN1Integer;
            this.b = pKIStatusInfo;
            this.c = certifiedKeyPair;
            this.d = aSN1OctetString;
        } else {
            throw new IllegalArgumentException("'status' cannot be null");
        }
    }
}
