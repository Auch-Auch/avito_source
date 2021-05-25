package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.X509Name;
public class IssuerAndSerialNumber extends ASN1Object {
    public X500Name a;
    public ASN1Integer b;

    public IssuerAndSerialNumber(ASN1Sequence aSN1Sequence) {
        this.a = X500Name.getInstance(aSN1Sequence.getObjectAt(0));
        this.b = (ASN1Integer) aSN1Sequence.getObjectAt(1);
    }

    public static IssuerAndSerialNumber getInstance(Object obj) {
        if (obj instanceof IssuerAndSerialNumber) {
            return (IssuerAndSerialNumber) obj;
        }
        if (obj != null) {
            return new IssuerAndSerialNumber(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Integer getCertificateSerialNumber() {
        return this.b;
    }

    public X500Name getName() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        return new DERSequence(aSN1EncodableVector);
    }

    public IssuerAndSerialNumber(X509Name x509Name, BigInteger bigInteger) {
        this.a = X500Name.getInstance(x509Name.toASN1Primitive());
        this.b = new ASN1Integer(bigInteger);
    }

    public IssuerAndSerialNumber(X509Name x509Name, ASN1Integer aSN1Integer) {
        this.a = X500Name.getInstance(x509Name.toASN1Primitive());
        this.b = aSN1Integer;
    }

    public IssuerAndSerialNumber(X500Name x500Name, BigInteger bigInteger) {
        this.a = x500Name;
        this.b = new ASN1Integer(bigInteger);
    }
}
