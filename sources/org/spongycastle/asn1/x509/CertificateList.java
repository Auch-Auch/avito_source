package org.spongycastle.asn1.x509;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.TBSCertList;
public class CertificateList extends ASN1Object {
    public TBSCertList a;
    public AlgorithmIdentifier b;
    public DERBitString c;
    public boolean d = false;
    public int e;

    public CertificateList(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 3) {
            this.a = TBSCertList.getInstance(aSN1Sequence.getObjectAt(0));
            this.b = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
            this.c = DERBitString.getInstance(aSN1Sequence.getObjectAt(2));
            return;
        }
        throw new IllegalArgumentException("sequence wrong size for CertificateList");
    }

    public static CertificateList getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public X500Name getIssuer() {
        return this.a.getIssuer();
    }

    public Time getNextUpdate() {
        return this.a.getNextUpdate();
    }

    public Enumeration getRevokedCertificateEnumeration() {
        return this.a.getRevokedCertificateEnumeration();
    }

    public TBSCertList.CRLEntry[] getRevokedCertificates() {
        return this.a.getRevokedCertificates();
    }

    public DERBitString getSignature() {
        return this.c;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.b;
    }

    public TBSCertList getTBSCertList() {
        return this.a;
    }

    public Time getThisUpdate() {
        return this.a.getThisUpdate();
    }

    public int getVersionNumber() {
        return this.a.getVersionNumber();
    }

    @Override // org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        if (!this.d) {
            this.e = super.hashCode();
            this.d = true;
        }
        return this.e;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        return new DERSequence(aSN1EncodableVector);
    }

    public static CertificateList getInstance(Object obj) {
        if (obj instanceof CertificateList) {
            return (CertificateList) obj;
        }
        if (obj != null) {
            return new CertificateList(ASN1Sequence.getInstance(obj));
        }
        return null;
    }
}
