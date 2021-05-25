package org.spongycastle.pqc.crypto.rainbow;
public class RainbowPublicKeyParameters extends RainbowKeyParameters {
    public short[][] c;
    public short[][] d;
    public short[] e;

    public RainbowPublicKeyParameters(int i, short[][] sArr, short[][] sArr2, short[] sArr3) {
        super(false, i);
        this.c = sArr;
        this.d = sArr2;
        this.e = sArr3;
    }

    public short[][] getCoeffQuadratic() {
        return this.c;
    }

    public short[] getCoeffScalar() {
        return this.e;
    }

    public short[][] getCoeffSingular() {
        return this.d;
    }
}
