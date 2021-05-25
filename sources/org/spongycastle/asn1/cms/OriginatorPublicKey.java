package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class OriginatorPublicKey extends ASN1Object {
    public AlgorithmIdentifier a;
    public DERBitString b;

    public OriginatorPublicKey(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.a = algorithmIdentifier;
        this.b = new DERBitString(bArr);
    }

    public static OriginatorPublicKey getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public AlgorithmIdentifier getAlgorithm() {
        return this.a;
    }

    public DERBitString getPublicKey() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        return new DERSequence(aSN1EncodableVector);
    }

    public static OriginatorPublicKey getInstance(Object obj) {
        if (obj instanceof OriginatorPublicKey) {
            return (OriginatorPublicKey) obj;
        }
        if (obj != null) {
            return new OriginatorPublicKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public OriginatorPublicKey(ASN1Sequence aSN1Sequence) {
        this.a = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.b = (DERBitString) aSN1Sequence.getObjectAt(1);
    }
}
