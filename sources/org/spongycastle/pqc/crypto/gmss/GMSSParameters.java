package org.spongycastle.pqc.crypto.gmss;

import org.spongycastle.util.Arrays;
public class GMSSParameters {
    public int a;
    public int[] b;
    public int[] c;
    public int[] d;

    public GMSSParameters(int i, int[] iArr, int[] iArr2, int[] iArr3) throws IllegalArgumentException {
        a(i, iArr, iArr2, iArr3);
    }

    public final void a(int i, int[] iArr, int[] iArr2, int[] iArr3) throws IllegalArgumentException {
        boolean z;
        String str;
        this.a = i;
        if (i == iArr2.length && i == iArr.length && i == iArr3.length) {
            z = true;
            str = "";
        } else {
            str = "Unexpected parameterset format";
            z = false;
        }
        for (int i2 = 0; i2 < this.a; i2++) {
            if (iArr3[i2] < 2 || (iArr[i2] - iArr3[i2]) % 2 != 0) {
                str = "Wrong parameter K (K >= 2 and H-K even required)!";
                z = false;
            }
            if (iArr[i2] < 4 || iArr2[i2] < 2) {
                str = "Wrong parameter H or w (H > 3 and w > 1 required)!";
                z = false;
            }
        }
        if (z) {
            this.b = Arrays.clone(iArr);
            this.c = Arrays.clone(iArr2);
            this.d = Arrays.clone(iArr3);
            return;
        }
        throw new IllegalArgumentException(str);
    }

    public int[] getHeightOfTrees() {
        return Arrays.clone(this.b);
    }

    public int[] getK() {
        return Arrays.clone(this.d);
    }

    public int getNumOfLayers() {
        return this.a;
    }

    public int[] getWinternitzParameter() {
        return Arrays.clone(this.c);
    }

    public GMSSParameters(int i) throws IllegalArgumentException {
        if (i <= 10) {
            a(1, new int[]{10}, new int[]{3}, new int[]{2});
        } else if (i <= 20) {
            a(2, new int[]{10, 10}, new int[]{5, 4}, new int[]{2, 2});
        } else {
            a(4, new int[]{10, 10, 10, 10}, new int[]{9, 9, 9, 3}, new int[]{2, 2, 2, 2});
        }
    }
}
