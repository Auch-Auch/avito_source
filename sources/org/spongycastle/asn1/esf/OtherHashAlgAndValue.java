package org.spongycastle.asn1.esf;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class OtherHashAlgAndValue extends ASN1Object {
    public AlgorithmIdentifier a;
    public ASN1OctetString b;

    public OtherHashAlgAndValue(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.a = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            this.b = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1));
            return;
        }
        throw new IllegalArgumentException(a.C(aSN1Sequence, a.L("Bad sequence size: ")));
    }

    public static OtherHashAlgAndValue getInstance(Object obj) {
        if (obj instanceof OtherHashAlgAndValue) {
            return (OtherHashAlgAndValue) obj;
        }
        if (obj != null) {
            return new OtherHashAlgAndValue(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.a;
    }

    public ASN1OctetString getHashValue() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        return new DERSequence(aSN1EncodableVector);
    }

    public OtherHashAlgAndValue(AlgorithmIdentifier algorithmIdentifier, ASN1OctetString aSN1OctetString) {
        this.a = algorithmIdentifier;
        this.b = aSN1OctetString;
    }
}
