package org.spongycastle.asn1.x509;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
public class AttributeCertificateInfo extends ASN1Object {
    public ASN1Integer a;
    public Holder b;
    public AttCertIssuer c;
    public AlgorithmIdentifier d;
    public ASN1Integer e;
    public AttCertValidityPeriod f;
    public ASN1Sequence g;
    public DERBitString h;
    public Extensions i;

    public AttributeCertificateInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 6 || aSN1Sequence.size() > 9) {
            throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("Bad sequence size: ")));
        }
        int i2 = 0;
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1Integer) {
            this.a = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
            i2 = 1;
        } else {
            this.a = new ASN1Integer(0);
        }
        this.b = Holder.getInstance(aSN1Sequence.getObjectAt(i2));
        this.c = AttCertIssuer.getInstance(aSN1Sequence.getObjectAt(i2 + 1));
        this.d = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i2 + 2));
        this.e = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(i2 + 3));
        this.f = AttCertValidityPeriod.getInstance(aSN1Sequence.getObjectAt(i2 + 4));
        this.g = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(i2 + 5));
        for (int i3 = i2 + 6; i3 < aSN1Sequence.size(); i3++) {
            ASN1Encodable objectAt = aSN1Sequence.getObjectAt(i3);
            if (objectAt instanceof DERBitString) {
                this.h = DERBitString.getInstance(aSN1Sequence.getObjectAt(i3));
            } else if ((objectAt instanceof ASN1Sequence) || (objectAt instanceof Extensions)) {
                this.i = Extensions.getInstance(aSN1Sequence.getObjectAt(i3));
            }
        }
    }

    public static AttributeCertificateInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public AttCertValidityPeriod getAttrCertValidityPeriod() {
        return this.f;
    }

    public ASN1Sequence getAttributes() {
        return this.g;
    }

    public Extensions getExtensions() {
        return this.i;
    }

    public Holder getHolder() {
        return this.b;
    }

    public AttCertIssuer getIssuer() {
        return this.c;
    }

    public DERBitString getIssuerUniqueID() {
        return this.h;
    }

    public ASN1Integer getSerialNumber() {
        return this.e;
    }

    public AlgorithmIdentifier getSignature() {
        return this.d;
    }

    public ASN1Integer getVersion() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.a.getValue().intValue() != 0) {
            aSN1EncodableVector.add(this.a);
        }
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        aSN1EncodableVector.add(this.d);
        aSN1EncodableVector.add(this.e);
        aSN1EncodableVector.add(this.f);
        aSN1EncodableVector.add(this.g);
        DERBitString dERBitString = this.h;
        if (dERBitString != null) {
            aSN1EncodableVector.add(dERBitString);
        }
        Extensions extensions = this.i;
        if (extensions != null) {
            aSN1EncodableVector.add(extensions);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public static AttributeCertificateInfo getInstance(Object obj) {
        if (obj instanceof AttributeCertificateInfo) {
            return (AttributeCertificateInfo) obj;
        }
        if (obj != null) {
            return new AttributeCertificateInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }
}
