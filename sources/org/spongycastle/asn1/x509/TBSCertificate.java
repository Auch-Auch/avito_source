package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.x500.X500Name;
public class TBSCertificate extends ASN1Object {
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
    public Extensions l;

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TBSCertificate(org.spongycastle.asn1.ASN1Sequence r9) {
        /*
        // Method dump skipped, instructions count: 278
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.x509.TBSCertificate.<init>(org.spongycastle.asn1.ASN1Sequence):void");
    }

    public static TBSCertificate getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public Time getEndDate() {
        return this.g;
    }

    public Extensions getExtensions() {
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

    public ASN1Integer getVersion() {
        return this.b;
    }

    public int getVersionNumber() {
        return this.b.getValue().intValue() + 1;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.a;
    }

    public static TBSCertificate getInstance(Object obj) {
        if (obj instanceof TBSCertificate) {
            return (TBSCertificate) obj;
        }
        if (obj != null) {
            return new TBSCertificate(ASN1Sequence.getInstance(obj));
        }
        return null;
    }
}
