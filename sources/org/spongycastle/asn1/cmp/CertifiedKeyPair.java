package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.crmf.EncryptedValue;
import org.spongycastle.asn1.crmf.PKIPublicationInfo;
public class CertifiedKeyPair extends ASN1Object {
    public CertOrEncCert a;
    public EncryptedValue b;
    public PKIPublicationInfo c;

    public CertifiedKeyPair(ASN1Sequence aSN1Sequence) {
        this.a = CertOrEncCert.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() < 2) {
            return;
        }
        if (aSN1Sequence.size() == 2) {
            ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1));
            if (instance.getTagNo() == 0) {
                this.b = EncryptedValue.getInstance(instance.getObject());
            } else {
                this.c = PKIPublicationInfo.getInstance(instance.getObject());
            }
        } else {
            this.b = EncryptedValue.getInstance(ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1)));
            this.c = PKIPublicationInfo.getInstance(ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(2)));
        }
    }

    public static CertifiedKeyPair getInstance(Object obj) {
        if (obj instanceof CertifiedKeyPair) {
            return (CertifiedKeyPair) obj;
        }
        if (obj != null) {
            return new CertifiedKeyPair(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CertOrEncCert getCertOrEncCert() {
        return this.a;
    }

    public EncryptedValue getPrivateKey() {
        return this.b;
    }

    public PKIPublicationInfo getPublicationInfo() {
        return this.c;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        EncryptedValue encryptedValue = this.b;
        if (encryptedValue != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, encryptedValue));
        }
        PKIPublicationInfo pKIPublicationInfo = this.c;
        if (pKIPublicationInfo != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, pKIPublicationInfo));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public CertifiedKeyPair(CertOrEncCert certOrEncCert) {
        this(certOrEncCert, null, null);
    }

    public CertifiedKeyPair(CertOrEncCert certOrEncCert, EncryptedValue encryptedValue, PKIPublicationInfo pKIPublicationInfo) {
        if (certOrEncCert != null) {
            this.a = certOrEncCert;
            this.b = encryptedValue;
            this.c = pKIPublicationInfo;
            return;
        }
        throw new IllegalArgumentException("'certOrEncCert' cannot be null");
    }
}
