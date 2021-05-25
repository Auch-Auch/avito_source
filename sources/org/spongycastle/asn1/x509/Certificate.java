package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.x500.X500Name;
public class Certificate extends ASN1Object {
    public ASN1Sequence a;
    public TBSCertificate b;
    public AlgorithmIdentifier c;
    public DERBitString d;

    public Certificate(ASN1Sequence aSN1Sequence) {
        this.a = aSN1Sequence;
        if (aSN1Sequence.size() == 3) {
            this.b = TBSCertificate.getInstance(aSN1Sequence.getObjectAt(0));
            this.c = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
            this.d = DERBitString.getInstance(aSN1Sequence.getObjectAt(2));
            return;
        }
        throw new IllegalArgumentException("sequence wrong size for a certificate");
    }

    public static Certificate getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public Time getEndDate() {
        return this.b.getEndDate();
    }

    public X500Name getIssuer() {
        return this.b.getIssuer();
    }

    public ASN1Integer getSerialNumber() {
        return this.b.getSerialNumber();
    }

    public DERBitString getSignature() {
        return this.d;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.c;
    }

    public Time getStartDate() {
        return this.b.getStartDate();
    }

    public X500Name getSubject() {
        return this.b.getSubject();
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.b.getSubjectPublicKeyInfo();
    }

    public TBSCertificate getTBSCertificate() {
        return this.b;
    }

    public ASN1Integer getVersion() {
        return this.b.getVersion();
    }

    public int getVersionNumber() {
        return this.b.getVersionNumber();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.a;
    }

    public static Certificate getInstance(Object obj) {
        if (obj instanceof Certificate) {
            return (Certificate) obj;
        }
        if (obj != null) {
            return new Certificate(ASN1Sequence.getInstance(obj));
        }
        return null;
    }
}
