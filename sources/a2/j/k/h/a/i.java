package a2.j.k.h.a;

import com.google.zxing.pdf417.PDF417Common;
import java.lang.reflect.Array;
public final class i {
    public static final float[][] a;

    static {
        int i;
        int length = PDF417Common.SYMBOL_TABLE.length;
        int[] iArr = new int[2];
        iArr[1] = 8;
        iArr[0] = length;
        a = (float[][]) Array.newInstance(float.class, iArr);
        int i2 = 0;
        while (true) {
            int[] iArr2 = PDF417Common.SYMBOL_TABLE;
            if (i2 < iArr2.length) {
                int i3 = iArr2[i2];
                int i4 = i3 & 1;
                int i5 = 0;
                while (i5 < 8) {
                    float f = 0.0f;
                    while (true) {
                        i = i3 & 1;
                        if (i != i4) {
                            break;
                        }
                        f += 1.0f;
                        i3 >>= 1;
                    }
                    a[i2][(8 - i5) - 1] = f / 17.0f;
                    i5++;
                    i4 = i;
                }
                i2++;
            } else {
                return;
            }
        }
    }
}
