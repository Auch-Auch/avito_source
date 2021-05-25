package org.spongycastle.asn1.cmp;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.crmf.EncryptedValue;
public class CertOrEncCert extends ASN1Object implements ASN1Choice {
    public CMPCertificate a;
    public EncryptedValue b;

    public CertOrEncCert(ASN1TaggedObject aSN1TaggedObject) {
        if (aSN1TaggedObject.getTagNo() == 0) {
            this.a = CMPCertificate.getInstance(aSN1TaggedObject.getObject());
        } else if (aSN1TaggedObject.getTagNo() == 1) {
            this.b = EncryptedValue.getInstance(aSN1TaggedObject.getObject());
        } else {
            throw new IllegalArgumentException(a.D(aSN1TaggedObject, a.L("unknown tag: ")));
        }
    }

    public static CertOrEncCert getInstance(Object obj) {
        if (obj instanceof CertOrEncCert) {
            return (CertOrEncCert) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new CertOrEncCert((ASN1TaggedObject) obj);
        }
        return null;
    }

    public CMPCertificate getCertificate() {
        return this.a;
    }

    public EncryptedValue getEncryptedCert() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        CMPCertificate cMPCertificate = this.a;
        if (cMPCertificate != null) {
            return new DERTaggedObject(true, 0, cMPCertificate);
        }
        return new DERTaggedObject(true, 1, this.b);
    }

    public CertOrEncCert(CMPCertificate cMPCertificate) {
        if (cMPCertificate != null) {
            this.a = cMPCertificate;
            return;
        }
        throw new IllegalArgumentException("'certificate' cannot be null");
    }

    public CertOrEncCert(EncryptedValue encryptedValue) {
        if (encryptedValue != null) {
            this.b = encryptedValue;
            return;
        }
        throw new IllegalArgumentException("'encryptedCert' cannot be null");
    }
}
