package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.GoppaCode;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.spongycastle.pqc.math.linearalgebra.PolynomialRingGF2m;
public class McEliecePrivateKeyParameters extends McElieceKeyParameters {
    public int c;
    public int d;
    public GF2mField e;
    public PolynomialGF2mSmallM f;
    public GF2Matrix g;
    public Permutation i;
    public Permutation j;
    public GF2Matrix k;
    public PolynomialGF2mSmallM[] l;

    public McEliecePrivateKeyParameters(int i2, int i3, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, Permutation permutation, Permutation permutation2, GF2Matrix gF2Matrix) {
        super(true, null);
        this.d = i3;
        this.c = i2;
        this.e = gF2mField;
        this.f = polynomialGF2mSmallM;
        this.g = gF2Matrix;
        this.i = permutation;
        this.j = permutation2;
        this.k = GoppaCode.createCanonicalCheckMatrix(gF2mField, polynomialGF2mSmallM);
        this.l = new PolynomialRingGF2m(gF2mField, polynomialGF2mSmallM).getSquareRootMatrix();
    }

    public GF2mField getField() {
        return this.e;
    }

    public PolynomialGF2mSmallM getGoppaPoly() {
        return this.f;
    }

    public GF2Matrix getH() {
        return this.k;
    }

    public int getK() {
        return this.d;
    }

    public int getN() {
        return this.c;
    }

    public Permutation getP1() {
        return this.i;
    }

    public Permutation getP2() {
        return this.j;
    }

    public PolynomialGF2mSmallM[] getQInv() {
        return this.l;
    }

    public GF2Matrix getSInv() {
        return this.g;
    }

    public McEliecePrivateKeyParameters(int i2, int i3, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[][] bArr7) {
        super(true, null);
        this.c = i2;
        this.d = i3;
        GF2mField gF2mField = new GF2mField(bArr);
        this.e = gF2mField;
        this.f = new PolynomialGF2mSmallM(gF2mField, bArr2);
        this.g = new GF2Matrix(bArr3);
        this.i = new Permutation(bArr4);
        this.j = new Permutation(bArr5);
        this.k = new GF2Matrix(bArr6);
        this.l = new PolynomialGF2mSmallM[bArr7.length];
        for (int i4 = 0; i4 < bArr7.length; i4++) {
            this.l[i4] = new PolynomialGF2mSmallM(this.e, bArr7[i4]);
        }
    }
}
