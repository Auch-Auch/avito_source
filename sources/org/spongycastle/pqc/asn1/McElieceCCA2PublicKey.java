package org.spongycastle.pqc.asn1;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
public class McElieceCCA2PublicKey extends ASN1Object {
    public final int a;
    public final int b;
    public final GF2Matrix c;
    public final AlgorithmIdentifier d;

    public McElieceCCA2PublicKey(int i, int i2, GF2Matrix gF2Matrix, AlgorithmIdentifier algorithmIdentifier) {
        this.a = i;
        this.b = i2;
        this.c = new GF2Matrix(gF2Matrix.getEncoded());
        this.d = algorithmIdentifier;
    }

    public static McElieceCCA2PublicKey getInstance(Object obj) {
        if (obj instanceof McElieceCCA2PublicKey) {
            return (McElieceCCA2PublicKey) obj;
        }
        if (obj != null) {
            return new McElieceCCA2PublicKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getDigest() {
        return this.d;
    }

    public GF2Matrix getG() {
        return this.c;
    }

    public int getN() {
        return this.a;
    }

    public int getT() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer((long) this.a));
        aSN1EncodableVector.add(new ASN1Integer((long) this.b));
        aSN1EncodableVector.add(new DEROctetString(this.c.getEncoded()));
        aSN1EncodableVector.add(this.d);
        return new DERSequence(aSN1EncodableVector);
    }

    public McElieceCCA2PublicKey(ASN1Sequence aSN1Sequence) {
        this.a = ((ASN1Integer) aSN1Sequence.getObjectAt(0)).getValue().intValue();
        this.b = ((ASN1Integer) aSN1Sequence.getObjectAt(1)).getValue().intValue();
        this.c = new GF2Matrix(((ASN1OctetString) aSN1Sequence.getObjectAt(2)).getOctets());
        this.d = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(3));
    }
}
