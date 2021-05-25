package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.KeySpec;
import org.spongycastle.pqc.crypto.rainbow.Layer;
public class RainbowPrivateKeySpec implements KeySpec {
    public short[][] a;
    public short[] b;
    public short[][] c;
    public short[] d;
    public int[] e;
    public Layer[] f;

    public RainbowPrivateKeySpec(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, Layer[] layerArr) {
        this.a = sArr;
        this.b = sArr2;
        this.c = sArr3;
        this.d = sArr4;
        this.e = iArr;
        this.f = layerArr;
    }

    public short[] getB1() {
        return this.b;
    }

    public short[] getB2() {
        return this.d;
    }

    public short[][] getInvA1() {
        return this.a;
    }

    public short[][] getInvA2() {
        return this.c;
    }

    public Layer[] getLayers() {
        return this.f;
    }

    public int[] getVi() {
        return this.e;
    }
}
