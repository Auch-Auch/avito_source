package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1UTCTime;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x500.X500Name;
public class V3TBSCertificateGenerator {
    public DERTaggedObject a = new DERTaggedObject(true, 0, new ASN1Integer(2));
    public ASN1Integer b;
    public AlgorithmIdentifier c;
    public X500Name d;
    public Time e;
    public Time f;
    public X500Name g;
    public SubjectPublicKeyInfo h;
    public Extensions i;
    public boolean j;
    public DERBitString k;
    public DERBitString l;

    public TBSCertificate generateTBSCertificate() {
        if (this.b == null || this.c == null || this.d == null || this.e == null || this.f == null || ((this.g == null && !this.j) || this.h == null)) {
            throw new IllegalStateException("not all mandatory fields set in V3 TBScertificate generator");
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        aSN1EncodableVector.add(this.d);
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        aSN1EncodableVector2.add(this.e);
        aSN1EncodableVector2.add(this.f);
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        X500Name x500Name = this.g;
        if (x500Name != null) {
            aSN1EncodableVector.add(x500Name);
        } else {
            aSN1EncodableVector.add(new DERSequence());
        }
        aSN1EncodableVector.add(this.h);
        DERBitString dERBitString = this.k;
        if (dERBitString != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, dERBitString));
        }
        DERBitString dERBitString2 = this.l;
        if (dERBitString2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 2, dERBitString2));
        }
        Extensions extensions = this.i;
        if (extensions != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 3, extensions));
        }
        return TBSCertificate.getInstance(new DERSequence(aSN1EncodableVector));
    }

    public void setEndDate(ASN1UTCTime aSN1UTCTime) {
        this.f = new Time(aSN1UTCTime);
    }

    public void setExtensions(X509Extensions x509Extensions) {
        setExtensions(Extensions.getInstance(x509Extensions));
    }

    public void setIssuer(X509Name x509Name) {
        this.d = X500Name.getInstance(x509Name);
    }

    public void setIssuerUniqueID(DERBitString dERBitString) {
        this.k = dERBitString;
    }

    public void setSerialNumber(ASN1Integer aSN1Integer) {
        this.b = aSN1Integer;
    }

    public void setSignature(AlgorithmIdentifier algorithmIdentifier) {
        this.c = algorithmIdentifier;
    }

    public void setStartDate(ASN1UTCTime aSN1UTCTime) {
        this.e = new Time(aSN1UTCTime);
    }

    public void setSubject(X509Name x509Name) {
        this.g = X500Name.getInstance(x509Name.toASN1Primitive());
    }

    public void setSubjectPublicKeyInfo(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.h = subjectPublicKeyInfo;
    }

    public void setSubjectUniqueID(DERBitString dERBitString) {
        this.l = dERBitString;
    }

    public void setEndDate(Time time) {
        this.f = time;
    }

    public void setExtensions(Extensions extensions) {
        Extension extension;
        this.i = extensions;
        if (extensions != null && (extension = extensions.getExtension(Extension.subjectAlternativeName)) != null && extension.isCritical()) {
            this.j = true;
        }
    }

    public void setIssuer(X500Name x500Name) {
        this.d = x500Name;
    }

    public void setStartDate(Time time) {
        this.e = time;
    }

    public void setSubject(X500Name x500Name) {
        this.g = x500Name;
    }
}
