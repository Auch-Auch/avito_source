package org.spongycastle.asn1.cms.ecc;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.cms.OriginatorPublicKey;
public class MQVuserKeyingMaterial extends ASN1Object {
    public OriginatorPublicKey a;
    public ASN1OctetString b;

    public MQVuserKeyingMaterial(OriginatorPublicKey originatorPublicKey, ASN1OctetString aSN1OctetString) {
        if (originatorPublicKey != null) {
            this.a = originatorPublicKey;
            this.b = aSN1OctetString;
            return;
        }
        throw new IllegalArgumentException("Ephemeral public key cannot be null");
    }

    public static MQVuserKeyingMaterial getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public ASN1OctetString getAddedukm() {
        return this.b;
    }

    public OriginatorPublicKey getEphemeralPublicKey() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        ASN1OctetString aSN1OctetString = this.b;
        if (aSN1OctetString != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, aSN1OctetString));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public static MQVuserKeyingMaterial getInstance(Object obj) {
        if (obj instanceof MQVuserKeyingMaterial) {
            return (MQVuserKeyingMaterial) obj;
        }
        if (obj != null) {
            return new MQVuserKeyingMaterial(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public MQVuserKeyingMaterial(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 1 || aSN1Sequence.size() == 2) {
            this.a = OriginatorPublicKey.getInstance(aSN1Sequence.getObjectAt(0));
            if (aSN1Sequence.size() > 1) {
                this.b = ASN1OctetString.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), true);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Sequence has incorrect number of elements");
    }
}
