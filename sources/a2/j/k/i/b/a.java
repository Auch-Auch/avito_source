package a2.j.k.i.b;

import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.detector.AlignmentPattern;
import java.util.ArrayList;
import java.util.List;
public final class a {
    public final BitMatrix a;
    public final List<AlignmentPattern> b = new ArrayList(5);
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final float g;
    public final int[] h;
    public final ResultPointCallback i;

    public a(BitMatrix bitMatrix, int i2, int i3, int i4, int i5, float f2, ResultPointCallback resultPointCallback) {
        this.a = bitMatrix;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = f2;
        this.h = new int[3];
        this.i = resultPointCallback;
    }

    public static float a(int[] iArr, int i2) {
        return ((float) (i2 - iArr[2])) - (((float) iArr[1]) / 2.0f);
    }

    public final boolean b(int[] iArr) {
        float f2 = this.g;
        float f3 = f2 / 2.0f;
        for (int i2 = 0; i2 < 3; i2++) {
            if (Math.abs(f2 - ((float) iArr[i2])) >= f3) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x0106 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.zxing.qrcode.detector.AlignmentPattern c(int[] r13, int r14, int r15) {
        /*
        // Method dump skipped, instructions count: 305
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.k.i.b.a.c(int[], int, int):com.google.zxing.qrcode.detector.AlignmentPattern");
    }
}
