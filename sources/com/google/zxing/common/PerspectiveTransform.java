package com.google.zxing.common;
public final class PerspectiveTransform {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final float h;
    public final float i;

    public PerspectiveTransform(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.a = f2;
        this.b = f5;
        this.c = f8;
        this.d = f3;
        this.e = f6;
        this.f = f9;
        this.g = f4;
        this.h = f7;
        this.i = f10;
    }

    public static PerspectiveTransform quadrilateralToQuadrilateral(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        PerspectiveTransform quadrilateralToSquare = quadrilateralToSquare(f2, f3, f4, f5, f6, f7, f8, f9);
        PerspectiveTransform squareToQuadrilateral = squareToQuadrilateral(f10, f11, f12, f13, f14, f15, f16, f17);
        float f18 = squareToQuadrilateral.a;
        float f19 = quadrilateralToSquare.a;
        float f20 = squareToQuadrilateral.d;
        float f21 = quadrilateralToSquare.b;
        float f22 = squareToQuadrilateral.g;
        float f23 = quadrilateralToSquare.c;
        float f24 = (f20 * f21) + (f18 * f19) + (f22 * f23);
        float f25 = quadrilateralToSquare.d;
        float f26 = quadrilateralToSquare.e;
        float f27 = quadrilateralToSquare.f;
        float f28 = (f20 * f26) + (f18 * f25) + (f22 * f27);
        float f29 = quadrilateralToSquare.g;
        float f30 = quadrilateralToSquare.h;
        float f31 = quadrilateralToSquare.i;
        float f32 = f22 * f31;
        float f33 = f32 + (f20 * f30) + (f18 * f29);
        float f34 = squareToQuadrilateral.b;
        float f35 = squareToQuadrilateral.e;
        float f36 = squareToQuadrilateral.h;
        float f37 = (f36 * f23) + (f35 * f21) + (f34 * f19);
        float f38 = (f35 * f26) + (f34 * f25);
        float f39 = (f35 * f30) + (f34 * f29) + (f36 * f31);
        float f40 = squareToQuadrilateral.c;
        float f41 = squareToQuadrilateral.f;
        float f42 = f21 * f41;
        float f43 = squareToQuadrilateral.i;
        return new PerspectiveTransform(f24, f28, f33, f37, (f36 * f27) + f38, f39, (f23 * f43) + f42 + (f19 * f40), (f27 * f43) + (f26 * f41) + (f25 * f40), (f43 * f31) + (f41 * f30) + (f40 * f29));
    }

    public static PerspectiveTransform quadrilateralToSquare(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        PerspectiveTransform squareToQuadrilateral = squareToQuadrilateral(f2, f3, f4, f5, f6, f7, f8, f9);
        float f10 = squareToQuadrilateral.e;
        float f11 = squareToQuadrilateral.i;
        float f12 = squareToQuadrilateral.f;
        float f13 = squareToQuadrilateral.h;
        float f14 = (f10 * f11) - (f12 * f13);
        float f15 = squareToQuadrilateral.g;
        float f16 = squareToQuadrilateral.d;
        float f17 = (f12 * f15) - (f16 * f11);
        float f18 = (f16 * f13) - (f10 * f15);
        float f19 = squareToQuadrilateral.c;
        float f20 = squareToQuadrilateral.b;
        float f21 = squareToQuadrilateral.a;
        return new PerspectiveTransform(f14, f17, f18, (f19 * f13) - (f20 * f11), (f11 * f21) - (f19 * f15), (f15 * f20) - (f13 * f21), (f20 * f12) - (f19 * f10), (f19 * f16) - (f12 * f21), (f21 * f10) - (f20 * f16));
    }

    public static PerspectiveTransform squareToQuadrilateral(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = ((f2 - f4) + f6) - f8;
        float f11 = ((f3 - f5) + f7) - f9;
        if (f10 == 0.0f && f11 == 0.0f) {
            return new PerspectiveTransform(f4 - f2, f6 - f4, f2, f5 - f3, f7 - f5, f3, 0.0f, 0.0f, 1.0f);
        }
        float f12 = f4 - f6;
        float f13 = f8 - f6;
        float f14 = f5 - f7;
        float f15 = f9 - f7;
        float f16 = (f12 * f15) - (f13 * f14);
        float f17 = ((f15 * f10) - (f13 * f11)) / f16;
        float f18 = ((f12 * f11) - (f10 * f14)) / f16;
        return new PerspectiveTransform((f17 * f4) + (f4 - f2), (f18 * f8) + (f8 - f2), f2, (f17 * f5) + (f5 - f3), (f18 * f9) + (f9 - f3), f3, f17, f18, 1.0f);
    }

    public void transformPoints(float[] fArr) {
        int length = fArr.length;
        float f2 = this.a;
        float f3 = this.b;
        float f4 = this.c;
        float f5 = this.d;
        float f6 = this.e;
        float f7 = this.f;
        float f8 = this.g;
        float f9 = this.h;
        float f10 = this.i;
        for (int i2 = 0; i2 < length; i2 += 2) {
            float f11 = fArr[i2];
            int i3 = i2 + 1;
            float f12 = fArr[i3];
            float f13 = (f7 * f12) + (f4 * f11) + f10;
            fArr[i2] = (((f5 * f12) + (f2 * f11)) + f8) / f13;
            fArr[i3] = (((f12 * f6) + (f11 * f3)) + f9) / f13;
        }
    }

    public void transformPoints(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            float f2 = fArr[i2];
            float f3 = fArr2[i2];
            float f4 = (this.f * f3) + (this.c * f2) + this.i;
            fArr[i2] = (((this.d * f3) + (this.a * f2)) + this.g) / f4;
            fArr2[i2] = (((this.e * f3) + (this.b * f2)) + this.h) / f4;
        }
    }
}
