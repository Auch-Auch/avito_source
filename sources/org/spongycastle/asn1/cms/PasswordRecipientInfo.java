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
public class PasswordRecipientInfo extends ASN1Object {
    public ASN1Integer a;
    public AlgorithmIdentifier b;
    public AlgorithmIdentifier c;
    public ASN1OctetString d;

    public PasswordRecipientInfo(AlgorithmIdentifier algorithmIdentifier, ASN1OctetString aSN1OctetString) {
        this.a = new ASN1Integer(0);
        this.c = algorithmIdentifier;
        this.d = aSN1OctetString;
    }

    public static PasswordRecipientInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public ASN1OctetString getEncryptedKey() {
        return this.d;
    }

    public AlgorithmIdentifier getKeyDerivationAlgorithm() {
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
        AlgorithmIdentifier algorithmIdentifier = this.b;
        if (algorithmIdentifier != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, algorithmIdentifier));
        }
        aSN1EncodableVector.add(this.c);
        aSN1EncodableVector.add(this.d);
        return new DERSequence(aSN1EncodableVector);
    }

    public static PasswordRecipientInfo getInstance(Object obj) {
        if (obj instanceof PasswordRecipientInfo) {
            return (PasswordRecipientInfo) obj;
        }
        if (obj != null) {
            return new PasswordRecipientInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public PasswordRecipientInfo(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, ASN1OctetString aSN1OctetString) {
        this.a = new ASN1Integer(0);
        this.b = algorithmIdentifier;
        this.c = algorithmIdentifier2;
        this.d = aSN1OctetString;
    }

    public PasswordRecipientInfo(ASN1Sequence aSN1Sequence) {
        this.a = (ASN1Integer) aSN1Sequence.getObjectAt(0);
        if (aSN1Sequence.getObjectAt(1) instanceof ASN1TaggedObject) {
            this.b = AlgorithmIdentifier.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), false);
            this.c = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(2));
            this.d = (ASN1OctetString) aSN1Sequence.getObjectAt(3);
            return;
        }
        this.c = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        this.d = (ASN1OctetString) aSN1Sequence.getObjectAt(2);
    }
}
