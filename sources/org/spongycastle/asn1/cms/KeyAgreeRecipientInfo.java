package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class KeyAgreeRecipientInfo extends ASN1Object {
    public ASN1Integer a;
    public OriginatorIdentifierOrKey b;
    public ASN1OctetString c;
    public AlgorithmIdentifier d;
    public ASN1Sequence e;

    public KeyAgreeRecipientInfo(OriginatorIdentifierOrKey originatorIdentifierOrKey, ASN1OctetString aSN1OctetString, AlgorithmIdentifier algorithmIdentifier, ASN1Sequence aSN1Sequence) {
        this.a = new ASN1Integer(3);
        this.b = originatorIdentifierOrKey;
        this.c = aSN1OctetString;
        this.d = algorithmIdentifier;
        this.e = aSN1Sequence;
    }

    public static KeyAgreeRecipientInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public AlgorithmIdentifier getKeyEncryptionAlgorithm() {
        return this.d;
    }

    public OriginatorIdentifierOrKey getOriginator() {
        return this.b;
    }

    public ASN1Sequence getRecipientEncryptedKeys() {
        return this.e;
    }

    public ASN1OctetString getUserKeyingMaterial() {
        return this.c;
    }

    public ASN1Integer getVersion() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(new DERTaggedObject(true, 0, this.b));
        ASN1OctetString aSN1OctetString = this.c;
        if (aSN1OctetString != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, aSN1OctetString));
        }
        aSN1EncodableVector.add(this.d);
        aSN1EncodableVector.add(this.e);
        return new DERSequence(aSN1EncodableVector);
    }

    public static KeyAgreeRecipientInfo getInstance(Object obj) {
        if (obj instanceof KeyAgreeRecipientInfo) {
            return (KeyAgreeRecipientInfo) obj;
        }
        if (obj != null) {
            return new KeyAgreeRecipientInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public KeyAgreeRecipientInfo(ASN1Sequence aSN1Sequence) {
        this.a = (ASN1Integer) aSN1Sequence.getObjectAt(0);
        this.b = OriginatorIdentifierOrKey.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), true);
        int i = 2;
        if (aSN1Sequence.getObjectAt(2) instanceof ASN1TaggedObject) {
            this.c = ASN1OctetString.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(2), true);
            i = 3;
        }
        this.d = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i));
        this.e = (ASN1Sequence) aSN1Sequence.getObjectAt(i + 1);
    }
}
