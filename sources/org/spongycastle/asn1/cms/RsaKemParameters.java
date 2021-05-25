package org.spongycastle.asn1.cms;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class RsaKemParameters extends ASN1Object {
    public final AlgorithmIdentifier a;
    public final BigInteger b;

    public RsaKemParameters(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.a = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            this.b = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1)).getValue();
            return;
        }
        throw new IllegalArgumentException("ASN.1 SEQUENCE should be of length 2");
    }

    public static RsaKemParameters getInstance(Object obj) {
        if (obj instanceof RsaKemParameters) {
            return (RsaKemParameters) obj;
        }
        if (obj != null) {
            return new RsaKemParameters(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getKeyDerivationFunction() {
        return this.a;
    }

    public BigInteger getKeyLength() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(new ASN1Integer(this.b));
        return new DERSequence(aSN1EncodableVector);
    }

    public RsaKemParameters(AlgorithmIdentifier algorithmIdentifier, int i) {
        this.a = algorithmIdentifier;
        this.b = BigInteger.valueOf((long) i);
    }
}
