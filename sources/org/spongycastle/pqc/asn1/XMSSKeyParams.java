package org.spongycastle.pqc.asn1;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class XMSSKeyParams extends ASN1Object {
    public final ASN1Integer a;
    public final int b;
    public final AlgorithmIdentifier c;

    public XMSSKeyParams(int i, AlgorithmIdentifier algorithmIdentifier) {
        this.a = new ASN1Integer(0);
        this.b = i;
        this.c = algorithmIdentifier;
    }

    public static XMSSKeyParams getInstance(Object obj) {
        if (obj instanceof XMSSKeyParams) {
            return (XMSSKeyParams) obj;
        }
        if (obj != null) {
            return new XMSSKeyParams(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public int getHeight() {
        return this.b;
    }

    public AlgorithmIdentifier getTreeDigest() {
        return this.c;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(new ASN1Integer((long) this.b));
        aSN1EncodableVector.add(this.c);
        return new DERSequence(aSN1EncodableVector);
    }

    public XMSSKeyParams(ASN1Sequence aSN1Sequence) {
        this.a = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        this.b = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1)).getValue().intValue();
        this.c = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(2));
    }
}
