package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.GoppaCode;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.spongycastle.pqc.math.linearalgebra.PolynomialRingGF2m;
public class McElieceCCA2PrivateKeyParameters extends McElieceCCA2KeyParameters {
    public int c;
    public int d;
    public GF2mField e;
    public PolynomialGF2mSmallM f;
    public Permutation g;
    public GF2Matrix i;
    public PolynomialGF2mSmallM[] j;

    public McElieceCCA2PrivateKeyParameters(int i2, int i3, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, Permutation permutation, String str) {
        this(i2, i3, gF2mField, polynomialGF2mSmallM, GoppaCode.createCanonicalCheckMatrix(gF2mField, polynomialGF2mSmallM), permutation, str);
    }

    public GF2mField getField() {
        return this.e;
    }

    public PolynomialGF2mSmallM getGoppaPoly() {
        return this.f;
    }

    public GF2Matrix getH() {
        return this.i;
    }

    public int getK() {
        return this.d;
    }

    public int getN() {
        return this.c;
    }

    public Permutation getP() {
        return this.g;
    }

    public PolynomialGF2mSmallM[] getQInv() {
        return this.j;
    }

    public int getT() {
        return this.f.getDegree();
    }

    public McElieceCCA2PrivateKeyParameters(int i2, int i3, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, GF2Matrix gF2Matrix, Permutation permutation, String str) {
        super(true, str);
        this.c = i2;
        this.d = i3;
        this.e = gF2mField;
        this.f = polynomialGF2mSmallM;
        this.i = gF2Matrix;
        this.g = permutation;
        this.j = new PolynomialRingGF2m(gF2mField, polynomialGF2mSmallM).getSquareRootMatrix();
    }
}
