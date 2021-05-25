package org.spongycastle.asn1.cms;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class GenericHybridParameters extends ASN1Object {
    public final AlgorithmIdentifier a;
    public final AlgorithmIdentifier b;

    public GenericHybridParameters(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.a = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            this.b = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
            return;
        }
        throw new IllegalArgumentException("ASN.1 SEQUENCE should be of length 2");
    }

    public static GenericHybridParameters getInstance(Object obj) {
        if (obj instanceof GenericHybridParameters) {
            return (GenericHybridParameters) obj;
        }
        if (obj != null) {
            return new GenericHybridParameters(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getDem() {
        return this.b;
    }

    public AlgorithmIdentifier getKem() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        return new DERSequence(aSN1EncodableVector);
    }

    public GenericHybridParameters(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2) {
        this.a = algorithmIdentifier;
        this.b = algorithmIdentifier2;
    }
}
