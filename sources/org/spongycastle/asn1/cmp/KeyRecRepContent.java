package org.spongycastle.asn1.cmp;

import a2.b.a.a.a;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
public class KeyRecRepContent extends ASN1Object {
    public PKIStatusInfo a;
    public CMPCertificate b;
    public ASN1Sequence c;
    public ASN1Sequence d;

    public KeyRecRepContent(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.a = PKIStatusInfo.getInstance(objects.nextElement());
        while (objects.hasMoreElements()) {
            ASN1TaggedObject instance = ASN1TaggedObject.getInstance(objects.nextElement());
            int tagNo = instance.getTagNo();
            if (tagNo == 0) {
                this.b = CMPCertificate.getInstance(instance.getObject());
            } else if (tagNo == 1) {
                this.c = ASN1Sequence.getInstance(instance.getObject());
            } else if (tagNo == 2) {
                this.d = ASN1Sequence.getInstance(instance.getObject());
            } else {
                throw new IllegalArgumentException(a.D(instance, a.L("unknown tag number: ")));
            }
        }
    }

    public static KeyRecRepContent getInstance(Object obj) {
        if (obj instanceof KeyRecRepContent) {
            return (KeyRecRepContent) obj;
        }
        if (obj != null) {
            return new KeyRecRepContent(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public final void a(ASN1EncodableVector aSN1EncodableVector, int i, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, i, aSN1Encodable));
        }
    }

    public CMPCertificate[] getCaCerts() {
        ASN1Sequence aSN1Sequence = this.c;
        if (aSN1Sequence == null) {
            return null;
        }
        int size = aSN1Sequence.size();
        CMPCertificate[] cMPCertificateArr = new CMPCertificate[size];
        for (int i = 0; i != size; i++) {
            cMPCertificateArr[i] = CMPCertificate.getInstance(this.c.getObjectAt(i));
        }
        return cMPCertificateArr;
    }

    public CertifiedKeyPair[] getKeyPairHist() {
        ASN1Sequence aSN1Sequence = this.d;
        if (aSN1Sequence == null) {
            return null;
        }
        int size = aSN1Sequence.size();
        CertifiedKeyPair[] certifiedKeyPairArr = new CertifiedKeyPair[size];
        for (int i = 0; i != size; i++) {
            certifiedKeyPairArr[i] = CertifiedKeyPair.getInstance(this.d.getObjectAt(i));
        }
        return certifiedKeyPairArr;
    }

    public CMPCertificate getNewSigCert() {
        return this.b;
    }

    public PKIStatusInfo getStatus() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        a(aSN1EncodableVector, 0, this.b);
        a(aSN1EncodableVector, 1, this.c);
        a(aSN1EncodableVector, 2, this.d);
        return new DERSequence(aSN1EncodableVector);
    }
}
