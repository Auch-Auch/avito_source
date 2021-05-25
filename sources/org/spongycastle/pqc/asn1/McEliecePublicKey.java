package org.spongycastle.pqc.asn1;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
public class McEliecePublicKey extends ASN1Object {
    public final int a;
    public final int b;
    public final GF2Matrix c;

    public McEliecePublicKey(int i, int i2, GF2Matrix gF2Matrix) {
        this.a = i;
        this.b = i2;
        this.c = new GF2Matrix(gF2Matrix);
    }

    public static McEliecePublicKey getInstance(Object obj) {
        if (obj instanceof McEliecePublicKey) {
            return (McEliecePublicKey) obj;
        }
        if (obj != null) {
            return new McEliecePublicKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public GF2Matrix getG() {
        return new GF2Matrix(this.c);
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
        return new DERSequence(aSN1EncodableVector);
    }

    public McEliecePublicKey(ASN1Sequence aSN1Sequence) {
        this.a = ((ASN1Integer) aSN1Sequence.getObjectAt(0)).getValue().intValue();
        this.b = ((ASN1Integer) aSN1Sequence.getObjectAt(1)).getValue().intValue();
        this.c = new GF2Matrix(((ASN1OctetString) aSN1Sequence.getObjectAt(2)).getOctets());
    }
}
