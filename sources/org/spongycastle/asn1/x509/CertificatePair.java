package org.spongycastle.asn1.x509;

import a2.b.a.a.a;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
public class CertificatePair extends ASN1Object {
    public Certificate a;
    public Certificate b;

    public CertificatePair(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 1 || aSN1Sequence.size() == 2) {
            Enumeration objects = aSN1Sequence.getObjects();
            while (objects.hasMoreElements()) {
                ASN1TaggedObject instance = ASN1TaggedObject.getInstance(objects.nextElement());
                if (instance.getTagNo() == 0) {
                    this.a = Certificate.getInstance(instance, true);
                } else if (instance.getTagNo() == 1) {
                    this.b = Certificate.getInstance(instance, true);
                } else {
                    throw new IllegalArgumentException(a.D(instance, a.L("Bad tag number: ")));
                }
            }
            return;
        }
        throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("Bad sequence size: ")));
    }

    public static CertificatePair getInstance(Object obj) {
        if (obj == null || (obj instanceof CertificatePair)) {
            return (CertificatePair) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new CertificatePair((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("illegal object in getInstance: ")));
    }

    public Certificate getForward() {
        return this.a;
    }

    public Certificate getReverse() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Certificate certificate = this.a;
        if (certificate != null) {
            aSN1EncodableVector.add(new DERTaggedObject(0, certificate));
        }
        Certificate certificate2 = this.b;
        if (certificate2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(1, certificate2));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public CertificatePair(Certificate certificate, Certificate certificate2) {
        this.a = certificate;
        this.b = certificate2;
    }
}
