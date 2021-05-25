package com.yandex.mobile.ads.impl;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import com.yandex.mobile.ads.impl.ir;
public final class iq {

    public static class a {
        public static final Interpolator a = new LinearInterpolator();
        public static final Interpolator b = new AccelerateInterpolator();
    }

    public static class b extends Animation {
        private Camera a;
        private float b;
        private float c;
        private float d;
        private float e;
        private float f;
        private float g;

        public b(float f2, float f3, float f4, float f5, float f6, float f7) {
            this.b = f2;
            this.c = f3;
            this.d = f4;
            this.e = f5;
            this.f = f6;
            this.g = f7;
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float f2, Transformation transformation) {
            float f3 = this.b;
            float b2 = a2.b.a.a.a.b(this.c, f3, f2, f3);
            double sin = Math.sin(((double) ((this.g + f2) / 2.0f)) * 3.141592653589793d);
            Matrix matrix = transformation.getMatrix();
            this.a.save();
            this.a.translate(0.0f, 0.0f, (float) (sin * ((double) this.f)));
            this.a.rotateY(b2);
            this.a.getMatrix(matrix);
            this.a.restore();
            matrix.preTranslate(-this.d, -this.e);
            matrix.postTranslate(this.d, this.e);
        }

        @Override // android.view.animation.Animation
        public final void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            this.a = new Camera();
        }
    }

    public static void a(ir.f fVar, Rect rect) {
        fVar.setPivot(((float) rect.width()) / 2.0f, ((float) rect.height()) / 2.0f);
        fVar.setDepthZ(((float) rect.width()) / 2.0f);
        fVar.setAnimationDuration(400);
        fVar.setFromInterpolator(a.a);
        fVar.setToInterpolator(a.b);
        fVar.a();
    }
}
