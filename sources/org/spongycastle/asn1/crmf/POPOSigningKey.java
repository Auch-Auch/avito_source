package org.spongycastle.asn1.crmf;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class POPOSigningKey extends ASN1Object {
    public POPOSigningKeyInput a;
    public AlgorithmIdentifier b;
    public DERBitString c;

    public POPOSigningKey(ASN1Sequence aSN1Sequence) {
        int i = 0;
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1TaggedObject) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(0);
            if (aSN1TaggedObject.getTagNo() == 0) {
                this.a = POPOSigningKeyInput.getInstance(aSN1TaggedObject.getObject());
                i = 1;
            } else {
                throw new IllegalArgumentException(a.D(aSN1TaggedObject, a.L("Unknown POPOSigningKeyInput tag: ")));
            }
        }
        this.b = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i));
        this.c = DERBitString.getInstance(aSN1Sequence.getObjectAt(i + 1));
    }

    public static POPOSigningKey getInstance(Object obj) {
        if (obj instanceof POPOSigningKey) {
            return (POPOSigningKey) obj;
        }
        if (obj != null) {
            return new POPOSigningKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getAlgorithmIdentifier() {
        return this.b;
    }

    public POPOSigningKeyInput getPoposkInput() {
        return this.a;
    }

    public DERBitString getSignature() {
        return this.c;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        POPOSigningKeyInput pOPOSigningKeyInput = this.a;
        if (pOPOSigningKeyInput != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, pOPOSigningKeyInput));
        }
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.c);
        return new DERSequence(aSN1EncodableVector);
    }

    public static POPOSigningKey getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public POPOSigningKey(POPOSigningKeyInput pOPOSigningKeyInput, AlgorithmIdentifier algorithmIdentifier, DERBitString dERBitString) {
        this.a = pOPOSigningKeyInput;
        this.b = algorithmIdentifier;
        this.c = dERBitString;
    }
}
