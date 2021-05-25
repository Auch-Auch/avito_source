package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class PBMParameter extends ASN1Object {
    public ASN1OctetString a;
    public AlgorithmIdentifier b;
    public ASN1Integer c;
    public AlgorithmIdentifier d;

    public PBMParameter(ASN1Sequence aSN1Sequence) {
        this.a = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0));
        this.b = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        this.c = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(2));
        this.d = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(3));
    }

    public static PBMParameter getInstance(Object obj) {
        if (obj instanceof PBMParameter) {
            return (PBMParameter) obj;
        }
        if (obj != null) {
            return new PBMParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Integer getIterationCount() {
        return this.c;
    }

    public AlgorithmIdentifier getMac() {
        return this.d;
    }

    public AlgorithmIdentifier getOwf() {
        return this.b;
    }

    public ASN1OctetString getSalt() {
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

    public PBMParameter(byte[] bArr, AlgorithmIdentifier algorithmIdentifier, int i, AlgorithmIdentifier algorithmIdentifier2) {
        this(new DEROctetString(bArr), algorithmIdentifier, new ASN1Integer((long) i), algorithmIdentifier2);
    }

    public PBMParameter(ASN1OctetString aSN1OctetString, AlgorithmIdentifier algorithmIdentifier, ASN1Integer aSN1Integer, AlgorithmIdentifier algorithmIdentifier2) {
        this.a = aSN1OctetString;
        this.b = algorithmIdentifier;
        this.c = aSN1Integer;
        this.d = algorithmIdentifier2;
    }
}
