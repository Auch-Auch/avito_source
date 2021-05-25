package org.spongycastle.asn1.x509;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
public class Holder extends ASN1Object {
    public static final int V1_CERTIFICATE_HOLDER = 0;
    public static final int V2_CERTIFICATE_HOLDER = 1;
    public IssuerSerial a;
    public GeneralNames b;
    public ObjectDigestInfo c;
    public int d;

    public Holder(ASN1TaggedObject aSN1TaggedObject) {
        this.d = 1;
        int tagNo = aSN1TaggedObject.getTagNo();
        if (tagNo == 0) {
            this.a = IssuerSerial.getInstance(aSN1TaggedObject, true);
        } else if (tagNo == 1) {
            this.b = GeneralNames.getInstance(aSN1TaggedObject, true);
        } else {
            throw new IllegalArgumentException("unknown tag in Holder");
        }
        this.d = 0;
    }

    public static Holder getInstance(Object obj) {
        if (obj instanceof Holder) {
            return (Holder) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new Holder(ASN1TaggedObject.getInstance(obj));
        }
        if (obj != null) {
            return new Holder(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public IssuerSerial getBaseCertificateID() {
        return this.a;
    }

    public GeneralNames getEntityName() {
        return this.b;
    }

    public ObjectDigestInfo getObjectDigestInfo() {
        return this.c;
    }

    public int getVersion() {
        return this.d;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        if (this.d == 1) {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            IssuerSerial issuerSerial = this.a;
            if (issuerSerial != null) {
                aSN1EncodableVector.add(new DERTaggedObject(false, 0, issuerSerial));
            }
            GeneralNames generalNames = this.b;
            if (generalNames != null) {
                aSN1EncodableVector.add(new DERTaggedObject(false, 1, generalNames));
            }
            ObjectDigestInfo objectDigestInfo = this.c;
            if (objectDigestInfo != null) {
                aSN1EncodableVector.add(new DERTaggedObject(false, 2, objectDigestInfo));
            }
            return new DERSequence(aSN1EncodableVector);
        }
        GeneralNames generalNames2 = this.b;
        if (generalNames2 != null) {
            return new DERTaggedObject(true, 1, generalNames2);
        }
        return new DERTaggedObject(true, 0, this.a);
    }

    public Holder(ASN1Sequence aSN1Sequence) {
        this.d = 1;
        if (aSN1Sequence.size() <= 3) {
            for (int i = 0; i != aSN1Sequence.size(); i++) {
                ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(i));
                int tagNo = instance.getTagNo();
                if (tagNo == 0) {
                    this.a = IssuerSerial.getInstance(instance, false);
                } else if (tagNo == 1) {
                    this.b = GeneralNames.getInstance(instance, false);
                } else if (tagNo == 2) {
                    this.c = ObjectDigestInfo.getInstance(instance, false);
                } else {
                    throw new IllegalArgumentException("unknown tag in Holder");
                }
            }
            this.d = 1;
            return;
        }
        throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("Bad sequence size: ")));
    }

    public Holder(IssuerSerial issuerSerial) {
        this(issuerSerial, 1);
    }

    public Holder(IssuerSerial issuerSerial, int i) {
        this.d = 1;
        this.a = issuerSerial;
        this.d = i;
    }

    public Holder(GeneralNames generalNames) {
        this(generalNames, 1);
    }

    public Holder(GeneralNames generalNames, int i) {
        this.d = 1;
        this.b = generalNames;
        this.d = i;
    }

    public Holder(ObjectDigestInfo objectDigestInfo) {
        this.d = 1;
        this.c = objectDigestInfo;
    }
}
