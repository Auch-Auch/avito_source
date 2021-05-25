package com.google.zxing.datamatrix.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
public final class Detector {
    public final BitMatrix a;
    public final WhiteRectangleDetector b;

    public static final class b {
        public final ResultPoint a;
        public final ResultPoint b;
        public final int c;

        public b(ResultPoint resultPoint, ResultPoint resultPoint2, int i, a aVar) {
            this.a = resultPoint;
            this.b = resultPoint2;
            this.c = i;
        }

        public String toString() {
            return this.a + "/" + this.b + '/' + this.c;
        }
    }

    public static final class c implements Serializable, Comparator<b> {
        public c(a aVar) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(b bVar, b bVar2) {
            return bVar.c - bVar2.c;
        }
    }

    public Detector(BitMatrix bitMatrix) throws NotFoundException {
        this.a = bitMatrix;
        this.b = new WhiteRectangleDetector(bitMatrix);
    }

    public static int a(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2));
    }

    public static void b(Map<ResultPoint, Integer> map, ResultPoint resultPoint) {
        Integer num = map.get(resultPoint);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        map.put(resultPoint, Integer.valueOf(i));
    }

    public static BitMatrix d(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) throws NotFoundException {
        float f = ((float) i) - 0.5f;
        float f2 = ((float) i2) - 0.5f;
        return GridSampler.getInstance().sampleGrid(bitMatrix, i, i2, 0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, resultPoint.getX(), resultPoint.getY(), resultPoint4.getX(), resultPoint4.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint2.getX(), resultPoint2.getY());
    }

    public final boolean c(ResultPoint resultPoint) {
        return resultPoint.getX() >= 0.0f && resultPoint.getX() < ((float) this.a.getWidth()) && resultPoint.getY() > 0.0f && resultPoint.getY() < ((float) this.a.getHeight());
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x0284  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x029e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.common.DetectorResult detect() throws com.google.zxing.NotFoundException {
        /*
        // Method dump skipped, instructions count: 711
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.detector.Detector.detect():com.google.zxing.common.DetectorResult");
    }

    public final b e(ResultPoint resultPoint, ResultPoint resultPoint2) {
        int x = (int) resultPoint.getX();
        int y = (int) resultPoint.getY();
        int x2 = (int) resultPoint2.getX();
        int y2 = (int) resultPoint2.getY();
        int i = 0;
        int i2 = 1;
        boolean z = Math.abs(y2 - y) > Math.abs(x2 - x);
        if (z) {
            y = x;
            x = y;
            y2 = x2;
            x2 = y2;
        }
        int abs = Math.abs(x2 - x);
        int abs2 = Math.abs(y2 - y);
        int i3 = (-abs) / 2;
        int i4 = y < y2 ? 1 : -1;
        if (x >= x2) {
            i2 = -1;
        }
        boolean z2 = this.a.get(z ? y : x, z ? x : y);
        while (x != x2) {
            boolean z3 = this.a.get(z ? y : x, z ? x : y);
            if (z3 != z2) {
                i++;
                z2 = z3;
            }
            i3 += abs2;
            if (i3 > 0) {
                if (y == y2) {
                    break;
                }
                y += i4;
                i3 -= abs;
            }
            x += i2;
        }
        return new b(resultPoint, resultPoint2, i, null);
    }
}
