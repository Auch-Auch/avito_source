package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
public class McElieceCCA2PublicKeyParameters extends McElieceCCA2KeyParameters {
    public int c;
    public int d;
    public GF2Matrix e;

    public McElieceCCA2PublicKeyParameters(int i, int i2, GF2Matrix gF2Matrix, String str) {
        super(false, str);
        this.c = i;
        this.d = i2;
        this.e = new GF2Matrix(gF2Matrix);
    }

    public GF2Matrix getG() {
        return this.e;
    }

    public int getK() {
        return this.e.getNumRows();
    }

    public int getN() {
        return this.c;
    }

    public int getT() {
        return this.d;
    }
}
