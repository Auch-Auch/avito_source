package org.spongycastle.asn1.ess;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.PolicyInformation;
public class SigningCertificate extends ASN1Object {
    public ASN1Sequence a;
    public ASN1Sequence b;

    public SigningCertificate(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 1 || aSN1Sequence.size() > 2) {
            throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("Bad sequence size: ")));
        }
        this.a = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() > 1) {
            this.b = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
        }
    }

    public static SigningCertificate getInstance(Object obj) {
        if (obj instanceof SigningCertificate) {
            return (SigningCertificate) obj;
        }
        if (obj != null) {
            return new SigningCertificate(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ESSCertID[] getCerts() {
        ESSCertID[] eSSCertIDArr = new ESSCertID[this.a.size()];
        for (int i = 0; i != this.a.size(); i++) {
            eSSCertIDArr[i] = ESSCertID.getInstance(this.a.getObjectAt(i));
        }
        return eSSCertIDArr;
    }

    public PolicyInformation[] getPolicies() {
        ASN1Sequence aSN1Sequence = this.b;
        if (aSN1Sequence == null) {
            return null;
        }
        PolicyInformation[] policyInformationArr = new PolicyInformation[aSN1Sequence.size()];
        for (int i = 0; i != this.b.size(); i++) {
            policyInformationArr[i] = PolicyInformation.getInstance(this.b.getObjectAt(i));
        }
        return policyInformationArr;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        ASN1Sequence aSN1Sequence = this.b;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.add(aSN1Sequence);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public SigningCertificate(ESSCertID eSSCertID) {
        this.a = new DERSequence(eSSCertID);
    }
}
