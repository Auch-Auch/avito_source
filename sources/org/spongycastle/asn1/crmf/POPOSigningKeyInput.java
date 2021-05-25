package org.spongycastle.asn1.crmf;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
public class POPOSigningKeyInput extends ASN1Object {
    public GeneralName a;
    public PKMACValue b;
    public SubjectPublicKeyInfo c;

    public POPOSigningKeyInput(ASN1Sequence aSN1Sequence) {
        ASN1Encodable objectAt = aSN1Sequence.getObjectAt(0);
        if (objectAt instanceof ASN1TaggedObject) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objectAt;
            if (aSN1TaggedObject.getTagNo() == 0) {
                this.a = GeneralName.getInstance(aSN1TaggedObject.getObject());
            } else {
                throw new IllegalArgumentException(a.D(aSN1TaggedObject, a.L("Unknown authInfo tag: ")));
            }
        } else {
            this.b = PKMACValue.getInstance(objectAt);
        }
        this.c = SubjectPublicKeyInfo.getInstance(aSN1Sequence.getObjectAt(1));
    }

    public static POPOSigningKeyInput getInstance(Object obj) {
        if (obj instanceof POPOSigningKeyInput) {
            return (POPOSigningKeyInput) obj;
        }
        if (obj != null) {
            return new POPOSigningKeyInput(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public SubjectPublicKeyInfo getPublicKey() {
        return this.c;
    }

    public PKMACValue getPublicKeyMAC() {
        return this.b;
    }

    public GeneralName getSender() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        GeneralName generalName = this.a;
        if (generalName != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, generalName));
        } else {
            aSN1EncodableVector.add(this.b);
        }
        aSN1EncodableVector.add(this.c);
        return new DERSequence(aSN1EncodableVector);
    }

    public POPOSigningKeyInput(GeneralName generalName, SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.a = generalName;
        this.c = subjectPublicKeyInfo;
    }

    public POPOSigningKeyInput(PKMACValue pKMACValue, SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.b = pKMACValue;
        this.c = subjectPublicKeyInfo;
    }
}
