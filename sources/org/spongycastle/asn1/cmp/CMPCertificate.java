package org.spongycastle.asn1.cmp;

import a2.b.a.a.a;
import java.io.IOException;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AttributeCertificate;
import org.spongycastle.asn1.x509.Certificate;
public class CMPCertificate extends ASN1Object implements ASN1Choice {
    public Certificate a;
    public int b;
    public ASN1Object c;

    public CMPCertificate(AttributeCertificate attributeCertificate) {
        this(1, attributeCertificate);
    }

    public static CMPCertificate getInstance(Object obj) {
        if (obj == null || (obj instanceof CMPCertificate)) {
            return (CMPCertificate) obj;
        }
        if (obj instanceof byte[]) {
            try {
                obj = ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (IOException unused) {
                throw new IllegalArgumentException("Invalid encoding in CMPCertificate");
            }
        }
        if (obj instanceof ASN1Sequence) {
            return new CMPCertificate(Certificate.getInstance(obj));
        }
        if (obj instanceof ASN1TaggedObject) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) obj;
            return new CMPCertificate(aSN1TaggedObject.getTagNo(), aSN1TaggedObject.getObject());
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("Invalid object: ")));
    }

    public ASN1Object getOtherCert() {
        return this.c;
    }

    public int getOtherCertTag() {
        return this.b;
    }

    public AttributeCertificate getX509v2AttrCert() {
        return AttributeCertificate.getInstance(this.c);
    }

    public Certificate getX509v3PKCert() {
        return this.a;
    }

    public boolean isX509v3PKCert() {
        return this.a != null;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1Object aSN1Object = this.c;
        if (aSN1Object != null) {
            return new DERTaggedObject(true, this.b, aSN1Object);
        }
        return this.a.toASN1Primitive();
    }

    public CMPCertificate(int i, ASN1Object aSN1Object) {
        this.b = i;
        this.c = aSN1Object;
    }

    public CMPCertificate(Certificate certificate) {
        if (certificate.getVersionNumber() == 3) {
            this.a = certificate;
            return;
        }
        throw new IllegalArgumentException("only version 3 certificates allowed");
    }
}
