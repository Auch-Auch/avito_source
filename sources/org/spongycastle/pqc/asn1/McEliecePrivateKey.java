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
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
public class McEliecePrivateKey extends ASN1Object {
    public int a;
    public int b;
    public byte[] c;
    public byte[] d;
    public byte[] e;
    public byte[] f;
    public byte[] g;

    public McEliecePrivateKey(int i, int i2, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, Permutation permutation, Permutation permutation2, GF2Matrix gF2Matrix) {
        this.a = i;
        this.b = i2;
        this.c = gF2mField.getEncoded();
        this.d = polynomialGF2mSmallM.getEncoded();
        this.e = gF2Matrix.getEncoded();
        this.f = permutation.getEncoded();
        this.g = permutation2.getEncoded();
    }

    public static McEliecePrivateKey getInstance(Object obj) {
        if (obj instanceof McEliecePrivateKey) {
            return (McEliecePrivateKey) obj;
        }
        if (obj != null) {
            return new McEliecePrivateKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public GF2mField getField() {
        return new GF2mField(this.c);
    }

    public PolynomialGF2mSmallM getGoppaPoly() {
        return new PolynomialGF2mSmallM(getField(), this.d);
    }

    public int getK() {
        return this.b;
    }

    public int getN() {
        return this.a;
    }

    public Permutation getP1() {
        return new Permutation(this.f);
    }

    public Permutation getP2() {
        return new Permutation(this.g);
    }

    public GF2Matrix getSInv() {
        return new GF2Matrix(this.e);
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer((long) this.a));
        aSN1EncodableVector.add(new ASN1Integer((long) this.b));
        aSN1EncodableVector.add(new DEROctetString(this.c));
        aSN1EncodableVector.add(new DEROctetString(this.d));
        aSN1EncodableVector.add(new DEROctetString(this.f));
        aSN1EncodableVector.add(new DEROctetString(this.g));
        aSN1EncodableVector.add(new DEROctetString(this.e));
        return new DERSequence(aSN1EncodableVector);
    }

    public McEliecePrivateKey(ASN1Sequence aSN1Sequence) {
        this.a = ((ASN1Integer) aSN1Sequence.getObjectAt(0)).getValue().intValue();
        this.b = ((ASN1Integer) aSN1Sequence.getObjectAt(1)).getValue().intValue();
        this.c = ((ASN1OctetString) aSN1Sequence.getObjectAt(2)).getOctets();
        this.d = ((ASN1OctetString) aSN1Sequence.getObjectAt(3)).getOctets();
        this.f = ((ASN1OctetString) aSN1Sequence.getObjectAt(4)).getOctets();
        this.g = ((ASN1OctetString) aSN1Sequence.getObjectAt(5)).getOctets();
        this.e = ((ASN1OctetString) aSN1Sequence.getObjectAt(6)).getOctets();
    }
}
