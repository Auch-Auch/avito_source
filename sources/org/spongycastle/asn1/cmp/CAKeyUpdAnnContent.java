package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
public class CAKeyUpdAnnContent extends ASN1Object {
    public CMPCertificate a;
    public CMPCertificate b;
    public CMPCertificate c;

    public CAKeyUpdAnnContent(ASN1Sequence aSN1Sequence) {
        this.a = CMPCertificate.getInstance(aSN1Sequence.getObjectAt(0));
        this.b = CMPCertificate.getInstance(aSN1Sequence.getObjectAt(1));
        this.c = CMPCertificate.getInstance(aSN1Sequence.getObjectAt(2));
    }

    public static CAKeyUpdAnnContent getInstance(Object obj) {
        if (obj instanceof CAKeyUpdAnnContent) {
            return (CAKeyUpdAnnContent) obj;
        }
        if (obj != null) {
            return new CAKeyUpdAnnContent(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CMPCertificate getNewWithNew() {
        return this.c;
    }

    public CMPCertificate getNewWithOld() {
        return this.b;
    }

    public CMPCertificate getOldWithNew() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        return new DERSequence(aSN1EncodableVector);
    }

    public CAKeyUpdAnnContent(CMPCertificate cMPCertificate, CMPCertificate cMPCertificate2, CMPCertificate cMPCertificate3) {
        this.a = cMPCertificate;
        this.b = cMPCertificate2;
        this.c = cMPCertificate3;
    }
}
