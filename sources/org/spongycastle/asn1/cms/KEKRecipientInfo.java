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
public class KEKRecipientInfo extends ASN1Object {
    public ASN1Integer a;
    public KEKIdentifier b;
    public AlgorithmIdentifier c;
    public ASN1OctetString d;

    public KEKRecipientInfo(KEKIdentifier kEKIdentifier, AlgorithmIdentifier algorithmIdentifier, ASN1OctetString aSN1OctetString) {
        this.a = new ASN1Integer(4);
        this.b = kEKIdentifier;
        this.c = algorithmIdentifier;
        this.d = aSN1OctetString;
    }

    public static KEKRecipientInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public ASN1OctetString getEncryptedKey() {
        return this.d;
    }

    public KEKIdentifier getKekid() {
        return this.b;
    }

    public AlgorithmIdentifier getKeyEncryptionAlgorithm() {
        return this.c;
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

    public static KEKRecipientInfo getInstance(Object obj) {
        if (obj instanceof KEKRecipientInfo) {
            return (KEKRecipientInfo) obj;
        }
        if (obj != null) {
            return new KEKRecipientInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public KEKRecipientInfo(ASN1Sequence aSN1Sequence) {
        this.a = (ASN1Integer) aSN1Sequence.getObjectAt(0);
        this.b = KEKIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        this.c = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(2));
        this.d = (ASN1OctetString) aSN1Sequence.getObjectAt(3);
    }
}
