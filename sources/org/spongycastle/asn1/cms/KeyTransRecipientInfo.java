package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class KeyTransRecipientInfo extends ASN1Object {
    public ASN1Integer a;
    public RecipientIdentifier b;
    public AlgorithmIdentifier c;
    public ASN1OctetString d;

    public KeyTransRecipientInfo(RecipientIdentifier recipientIdentifier, AlgorithmIdentifier algorithmIdentifier, ASN1OctetString aSN1OctetString) {
        if (recipientIdentifier.toASN1Primitive() instanceof ASN1TaggedObject) {
            this.a = new ASN1Integer(2);
        } else {
            this.a = new ASN1Integer(0);
        }
        this.b = recipientIdentifier;
        this.c = algorithmIdentifier;
        this.d = aSN1OctetString;
    }

    public static KeyTransRecipientInfo getInstance(Object obj) {
        if (obj instanceof KeyTransRecipientInfo) {
            return (KeyTransRecipientInfo) obj;
        }
        if (obj != null) {
            return new KeyTransRecipientInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1OctetString getEncryptedKey() {
        return this.d;
    }

    public AlgorithmIdentifier getKeyEncryptionAlgorithm() {
        return this.c;
    }

    public RecipientIdentifier getRecipientIdentifier() {
        return this.b;
    }

    public ASN1Integer getVersion() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        aSN1EncodableVector.add(this.d);
        return new DERSequence(aSN1EncodableVector);
    }

    public KeyTransRecipientInfo(ASN1Sequence aSN1Sequence) {
        this.a = (ASN1Integer) aSN1Sequence.getObjectAt(0);
        this.b = RecipientIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        this.c = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(2));
        this.d = (ASN1OctetString) aSN1Sequence.getObjectAt(3);
    }
}
