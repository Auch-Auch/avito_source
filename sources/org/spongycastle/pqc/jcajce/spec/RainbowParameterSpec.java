package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.util.Arrays;
public class RainbowParameterSpec implements AlgorithmParameterSpec {
    public static final int[] b = {6, 12, 17, 22, 33};
    public int[] a;

    public RainbowParameterSpec() {
        this.a = b;
    }

    public int getDocumentLength() {
        int[] iArr = this.a;
        return iArr[iArr.length - 1] - iArr[0];
    }

    public int getNumOfLayers() {
        return this.a.length - 1;
    }

    public int[] getVi() {
        return Arrays.clone(this.a);
    }

    public RainbowParameterSpec(int[] iArr) {
        int[] iArr2;
        int i;
        this.a = iArr;
        if (iArr == null) {
            throw new IllegalArgumentException("no layers defined.");
        } else if (iArr.length > 1) {
            int i2 = 0;
            do {
                iArr2 = this.a;
                if (i2 < iArr2.length - 1) {
                    i = iArr2[i2];
                    i2++;
                } else {
                    return;
                }
            } while (i < iArr2[i2]);
            throw new IllegalArgumentException("v[i] has to be smaller than v[i+1]");
        } else {
            throw new IllegalArgumentException("Rainbow needs at least 1 layer, such that v1 < v2.");
        }
    }
}
