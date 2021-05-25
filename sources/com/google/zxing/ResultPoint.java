package com.google.zxing;

import com.google.zxing.common.detector.MathUtils;
public class ResultPoint {
    public final float a;
    public final float b;

    public ResultPoint(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.distance(resultPoint.a, resultPoint.b, resultPoint2.a, resultPoint2.b);
    }

    public static void orderBestPatterns(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        float distance = distance(resultPointArr[0], resultPointArr[1]);
        float distance2 = distance(resultPointArr[1], resultPointArr[2]);
        float distance3 = distance(resultPointArr[0], resultPointArr[2]);
        if (distance2 >= distance && distance2 >= distance3) {
            resultPoint3 = resultPointArr[0];
            resultPoint2 = resultPointArr[1];
            resultPoint = resultPointArr[2];
        } else if (distance3 < distance2 || distance3 < distance) {
            resultPoint3 = resultPointArr[2];
            resultPoint2 = resultPointArr[0];
            resultPoint = resultPointArr[1];
        } else {
            resultPoint3 = resultPointArr[1];
            resultPoint2 = resultPointArr[0];
            resultPoint = resultPointArr[2];
        }
        float f = resultPoint3.a;
        float f2 = resultPoint3.b;
        if (((resultPoint2.b - f2) * (resultPoint.a - f)) - ((resultPoint2.a - f) * (resultPoint.b - f2)) < 0.0f) {
            resultPoint = resultPoint2;
            resultPoint2 = resultPoint;
        }
        resultPointArr[0] = resultPoint2;
        resultPointArr[1] = resultPoint3;
        resultPointArr[2] = resultPoint;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ResultPoint) {
            ResultPoint resultPoint = (ResultPoint) obj;
            if (this.a == resultPoint.a && this.b == resultPoint.b) {
                return true;
            }
        }
        return false;
    }

    public final float getX() {
        return this.a;
    }

    public final float getY() {
        return this.b;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.b) + (Float.floatToIntBits(this.a) * 31);
    }

    public final String toString() {
        return "(" + this.a + ',' + this.b + ')';
    }
}
