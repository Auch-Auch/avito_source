package a2.j.k.h.a;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
public final class c {
    public final BitMatrix a;
    public final ResultPoint b;
    public final ResultPoint c;
    public final ResultPoint d;
    public final ResultPoint e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;

    public c(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) throws NotFoundException {
        boolean z = false;
        boolean z2 = resultPoint == null || resultPoint2 == null;
        z = (resultPoint3 == null || resultPoint4 == null) ? true : z;
        if (!z2 || !z) {
            if (z2) {
                resultPoint = new ResultPoint(0.0f, resultPoint3.getY());
                resultPoint2 = new ResultPoint(0.0f, resultPoint4.getY());
            } else if (z) {
                resultPoint3 = new ResultPoint((float) (bitMatrix.getWidth() - 1), resultPoint.getY());
                resultPoint4 = new ResultPoint((float) (bitMatrix.getWidth() - 1), resultPoint2.getY());
            }
            this.a = bitMatrix;
            this.b = resultPoint;
            this.c = resultPoint2;
            this.d = resultPoint3;
            this.e = resultPoint4;
            this.f = (int) Math.min(resultPoint.getX(), resultPoint2.getX());
            this.g = (int) Math.max(resultPoint3.getX(), resultPoint4.getX());
            this.h = (int) Math.min(resultPoint.getY(), resultPoint3.getY());
            this.i = (int) Math.max(resultPoint2.getY(), resultPoint4.getY());
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public c(c cVar) {
        this.a = cVar.a;
        this.b = cVar.b;
        this.c = cVar.c;
        this.d = cVar.d;
        this.e = cVar.e;
        this.f = cVar.f;
        this.g = cVar.g;
        this.h = cVar.h;
        this.i = cVar.i;
    }
}
