package org.spongycastle.pqc.crypto.rainbow;

import org.spongycastle.crypto.CipherParameters;
public class RainbowParameters implements CipherParameters {
    public final int[] a;
    public int[] b;

    public RainbowParameters() {
        int[] iArr = {6, 12, 17, 22, 33};
        this.a = iArr;
        this.b = iArr;
    }

    public final void a() throws Exception {
        int[] iArr;
        int i;
        int[] iArr2 = this.b;
        if (iArr2 == null) {
            throw new Exception("no layers defined.");
        } else if (iArr2.length > 1) {
            int i2 = 0;
            do {
                iArr = this.b;
                if (i2 < iArr.length - 1) {
                    i = iArr[i2];
                    i2++;
                } else {
                    return;
                }
            } while (i < iArr[i2]);
            throw new Exception("v[i] has to be smaller than v[i+1]");
        } else {
            throw new Exception("Rainbow needs at least 1 layer, such that v1 < v2.");
        }
    }

    public int getDocLength() {
        int[] iArr = this.b;
        return iArr[iArr.length - 1] - iArr[0];
    }

    public int getNumOfLayers() {
        return this.b.length - 1;
    }

    public int[] getVi() {
        return this.b;
    }

    public RainbowParameters(int[] iArr) {
        this.a = new int[]{6, 12, 17, 22, 33};
        this.b = iArr;
        try {
            a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
