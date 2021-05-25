package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.KeySpec;
public class RainbowPublicKeySpec implements KeySpec {
    public short[][] a;
    public short[][] b;
    public short[] c;
    public int d;

    public RainbowPublicKeySpec(int i, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.d = i;
        this.a = sArr;
        this.b = sArr2;
        this.c = sArr3;
    }

    public short[][] getCoeffQuadratic() {
        return this.a;
    }

    public short[] getCoeffScalar() {
        return this.c;
    }

    public short[][] getCoeffSingular() {
        return this.b;
    }

    public int getDocLength() {
        return this.d;
    }
}
