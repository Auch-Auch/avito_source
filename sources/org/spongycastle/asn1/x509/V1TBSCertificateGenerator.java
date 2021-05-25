package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1UTCTime;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x500.X500Name;
public class V1TBSCertificateGenerator {
    public ASN1Integer a;
    public AlgorithmIdentifier b;
    public X500Name c;
    public Time d;
    public Time e;
    public X500Name f;
    public SubjectPublicKeyInfo g;

    public V1TBSCertificateGenerator() {
        new DERTaggedObject(true, 0, new ASN1Integer(0));
    }

    public TBSCertificate generateTBSCertificate() {
        if (this.a == null || this.b == null || this.c == null || this.d == null || this.e == null || this.f == null || this.g == null) {
            throw new IllegalStateException("not all mandatory fields set in V1 TBScertificate generator");
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        aSN1EncodableVector2.add(this.d);
        aSN1EncodableVector2.add(this.e);
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        aSN1EncodableVector.add(this.f);
        aSN1EncodableVector.add(this.g);
        return TBSCertificate.getInstance(new DERSequence(aSN1EncodableVector));
    }

    public void setEndDate(Time time) {
        this.e = time;
    }

    public void setIssuer(X509Name x509Name) {
        this.c = X500Name.getInstance(x509Name.toASN1Primitive());
    }

    public void setSerialNumber(ASN1Integer aSN1Integer) {
        this.a = aSN1Integer;
    }

    public void setSignature(AlgorithmIdentifier algorithmIdentifier) {
        this.b = algorithmIdentifier;
    }

    public void setStartDate(Time time) {
        this.d = time;
    }

    public void setSubject(X509Name x509Name) {
        this.f = X500Name.getInstance(x509Name.toASN1Primitive());
    }

    public void setSubjectPublicKeyInfo(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.g = subjectPublicKeyInfo;
    }

    public void setEndDate(ASN1UTCTime aSN1UTCTime) {
        this.e = new Time(aSN1UTCTime);
    }

    public void setIssuer(X500Name x500Name) {
        this.c = x500Name;
    }

    public void setStartDate(ASN1UTCTime aSN1UTCTime) {
        this.d = new Time(aSN1UTCTime);
    }

    public void setSubject(X500Name x500Name) {
        this.f = x500Name;
    }
}
