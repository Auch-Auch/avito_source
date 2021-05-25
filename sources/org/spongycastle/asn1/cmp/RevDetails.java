package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.crmf.CertTemplate;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.X509Extensions;
public class RevDetails extends ASN1Object {
    public CertTemplate a;
    public Extensions b;

    public RevDetails(ASN1Sequence aSN1Sequence) {
        this.a = CertTemplate.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() > 1) {
            this.b = Extensions.getInstance(aSN1Sequence.getObjectAt(1));
        }
    }

    public static RevDetails getInstance(Object obj) {
        if (obj instanceof RevDetails) {
            return (RevDetails) obj;
        }
        if (obj != null) {
            return new RevDetails(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CertTemplate getCertDetails() {
        return this.a;
    }

    public Extensions getCrlEntryDetails() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        Extensions extensions = this.b;
        if (extensions != null) {
            aSN1EncodableVector.add(extensions);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public RevDetails(CertTemplate certTemplate) {
        this.a = certTemplate;
    }

    public RevDetails(CertTemplate certTemplate, X509Extensions x509Extensions) {
        this.a = certTemplate;
        this.b = Extensions.getInstance(x509Extensions.toASN1Primitive());
    }

    public RevDetails(CertTemplate certTemplate, Extensions extensions) {
        this.a = certTemplate;
        this.b = extensions;
    }
}
