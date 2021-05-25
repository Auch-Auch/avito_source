package org.spongycastle.pqc.asn1;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class XMSSMTKeyParams extends ASN1Object {
    public final ASN1Integer a;
    public final int b;
    public final int c;
    public final AlgorithmIdentifier d;

    public XMSSMTKeyParams(int i, int i2, AlgorithmIdentifier algorithmIdentifier) {
        this.a = new ASN1Integer(0);
        this.b = i;
        this.c = i2;
        this.d = algorithmIdentifier;
    }

    public static XMSSMTKeyParams getInstance(Object obj) {
        if (obj instanceof XMSSMTKeyParams) {
            return (XMSSMTKeyParams) obj;
        }
        if (obj != null) {
            return new XMSSMTKeyParams(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public int getHeight() {
        return this.b;
    }

    public int getLayers() {
        return this.c;
    }

    public AlgorithmIdentifier getTreeDigest() {
        return this.d;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(new ASN1Integer((long) this.b));
        aSN1EncodableVector.add(new ASN1Integer((long) this.c));
        aSN1EncodableVector.add(this.d);
        return new DERSequence(aSN1EncodableVector);
    }

    public XMSSMTKeyParams(ASN1Sequence aSN1Sequence) {
        this.a = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        this.b = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1)).getValue().intValue();
        this.c = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(2)).getValue().intValue();
        this.d = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(3));
    }
}
