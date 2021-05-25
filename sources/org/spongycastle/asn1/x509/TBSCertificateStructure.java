package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x500.X500Name;
public class TBSCertificateStructure extends ASN1Object implements X509ObjectIdentifiers, PKCSObjectIdentifiers {
    public ASN1Sequence a;
    public ASN1Integer b;
    public ASN1Integer c;
    public AlgorithmIdentifier d;
    public X500Name e;
    public Time f;
    public Time g;
    public X500Name h;
    public SubjectPublicKeyInfo i;
    public DERBitString j;
    public DERBitString k;
    public X509Extensions l;

    public TBSCertificateStructure(ASN1Sequence aSN1Sequence) {
        int i2;
        this.a = aSN1Sequence;
        if (aSN1Sequence.getObjectAt(0) instanceof DERTaggedObject) {
            this.b = ASN1Integer.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(0), true);
            i2 = 0;
        } else {
            this.b = new ASN1Integer(0);
            i2 = -1;
        }
        this.c = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(i2 + 1));
        this.d = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i2 + 2));
        this.e = X500Name.getInstance(aSN1Sequence.getObjectAt(i2 + 3));
        ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Sequence.getObjectAt(i2 + 4);
        this.f = Time.getInstance(aSN1Sequence2.getObjectAt(0));
        this.g = Time.getInstance(aSN1Sequence2.getObjectAt(1));
        this.h = X500Name.getInstance(aSN1Sequence.getObjectAt(i2 + 5));
        int i3 = i2 + 6;
        this.i = SubjectPublicKeyInfo.getInstance(aSN1Sequence.getObjectAt(i3));
        for (int size = (aSN1Sequence.size() - i3) - 1; size > 0; size--) {
            DERTaggedObject dERTaggedObject = (DERTaggedObject) aSN1Sequence.getObjectAt(i3 + size);
            int tagNo = dERTaggedObject.getTagNo();
            if (tagNo == 1) {
                this.j = DERBitString.getInstance(dERTaggedObject, false);
            } else if (tagNo == 2) {
                this.k = DERBitString.getInstance(dERTaggedObject, false);
            } else if (tagNo == 3) {
                this.l = X509Extensions.getInstance(dERTaggedObject);
            }
        }
    }

    public static TBSCertificateStructure getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public Time getEndDate() {
        return this.g;
    }

    public X509Extensions getExtensions() {
        return this.l;
    }

    public X500Name getIssuer() {
        return this.e;
    }

    public DERBitString getIssuerUniqueId() {
        return this.j;
    }

    public ASN1Integer getSerialNumber() {
        return this.c;
    }

    public AlgorithmIdentifier getSignature() {
        return this.d;
    }

    public Time getStartDate() {
        return this.f;
    }

    public X500Name getSubject() {
        return this.h;
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.i;
    }

    public DERBitString getSubjectUniqueId() {
        return this.k;
    }

    public int getVersion() {
        return this.b.getValue().intValue() + 1;
    }

    public ASN1Integer getVersionNumber() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.a;
    }

    public static TBSCertificateStructure getInstance(Object obj) {
        if (obj instanceof TBSCertificateStructure) {
            return (TBSCertificateStructure) obj;
        }
        if (obj != null) {
            return new TBSCertificateStructure(ASN1Sequence.getInstance(obj));
        }
        return null;
    }
}
