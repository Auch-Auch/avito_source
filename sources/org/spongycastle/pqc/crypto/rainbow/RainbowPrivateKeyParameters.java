package org.spongycastle.pqc.crypto.rainbow;
public class RainbowPrivateKeyParameters extends RainbowKeyParameters {
    public short[][] c;
    public short[] d;
    public short[][] e;
    public short[] f;
    public int[] g;
    public Layer[] i;

    public RainbowPrivateKeyParameters(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, Layer[] layerArr) {
        super(true, iArr[iArr.length - 1] - iArr[0]);
        this.c = sArr;
        this.d = sArr2;
        this.e = sArr3;
        this.f = sArr4;
        this.g = iArr;
        this.i = layerArr;
    }

    public short[] getB1() {
        return this.d;
    }

    public short[] getB2() {
        return this.f;
    }

    public short[][] getInvA1() {
        return this.c;
    }

    public short[][] getInvA2() {
        return this.e;
    }

    public Layer[] getLayers() {
        return this.i;
    }

    public int[] getVi() {
        return this.g;
    }
}
