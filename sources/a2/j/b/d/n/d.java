package a2.j.b.d.n;

import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;
public final class d extends i<ObjectAnimator> {
    public static final int[] l = {0, 1350, 2700, 4050};
    public static final int[] m = {667, 2017, 3367, 4717};
    public static final int[] n = {1000, 2350, 3700, 5050};
    public static final Property<d, Float> o = new a(Float.class, "animationFraction");
    public static final Property<d, Float> p = new b(Float.class, "completeEndFraction");
    public ObjectAnimator d;
    public ObjectAnimator e;
    public final FastOutSlowInInterpolator f;
    public final BaseProgressIndicatorSpec g;
    public int h = 0;
    public float i;
    public float j;
    public Animatable2Compat.AnimationCallback k = null;

    public static class a extends Property<d, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(d dVar) {
            return Float.valueOf(dVar.i);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(d dVar, Float f) {
            d dVar2 = dVar;
            float floatValue = f.floatValue();
            dVar2.i = floatValue;
            int i = (int) (5400.0f * floatValue);
            float[] fArr = dVar2.b;
            float f2 = floatValue * 1520.0f;
            fArr[0] = -20.0f + f2;
            fArr[1] = f2;
            for (int i2 = 0; i2 < 4; i2++) {
                float b = dVar2.b(i, d.l[i2], 667);
                float[] fArr2 = dVar2.b;
                fArr2[1] = (dVar2.f.getInterpolation(b) * 250.0f) + fArr2[1];
                float b2 = dVar2.b(i, d.m[i2], 667);
                float[] fArr3 = dVar2.b;
                fArr3[0] = (dVar2.f.getInterpolation(b2) * 250.0f) + fArr3[0];
            }
            float[] fArr4 = dVar2.b;
            fArr4[0] = ((fArr4[1] - fArr4[0]) * dVar2.j) + fArr4[0];
            fArr4[0] = fArr4[0] / 360.0f;
            fArr4[1] = fArr4[1] / 360.0f;
            int i3 = 0;
            while (true) {
                if (i3 >= 4) {
                    break;
                }
                float b3 = dVar2.b(i, d.n[i3], 333);
                if (b3 >= 0.0f && b3 <= 1.0f) {
                    int i4 = i3 + dVar2.h;
                    int[] iArr = dVar2.g.indicatorColors;
                    int length = i4 % iArr.length;
                    int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(iArr[length], dVar2.a.getAlpha());
                    int compositeARGBWithAlpha2 = MaterialColors.compositeARGBWithAlpha(dVar2.g.indicatorColors[(length + 1) % iArr.length], dVar2.a.getAlpha());
                    dVar2.c[0] = ArgbEvaluatorCompat.getInstance().evaluate(dVar2.f.getInterpolation(b3), Integer.valueOf(compositeARGBWithAlpha), Integer.valueOf(compositeARGBWithAlpha2)).intValue();
                    break;
                }
                i3++;
            }
            dVar2.a.invalidateSelf();
        }
    }

    public static class b extends Property<d, Float> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(d dVar) {
            return Float.valueOf(dVar.j);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(d dVar, Float f) {
            dVar.j = f.floatValue();
        }
    }

    public d(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.g = circularProgressIndicatorSpec;
        this.f = new FastOutSlowInInterpolator();
    }

    @Override // a2.j.b.d.n.i
    public void a() {
        ObjectAnimator objectAnimator = this.d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // a2.j.b.d.n.i
    public void c() {
        h();
    }

    @Override // a2.j.b.d.n.i
    public void d(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.k = animationCallback;
    }

    @Override // a2.j.b.d.n.i
    public void e() {
        if (!this.e.isRunning()) {
            if (this.a.isVisible()) {
                this.e.start();
            } else {
                a();
            }
        }
    }

    @Override // a2.j.b.d.n.i
    public void f() {
        if (this.d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, o, 0.0f, 1.0f);
            this.d = ofFloat;
            ofFloat.setDuration(5400L);
            this.d.setInterpolator(null);
            this.d.setRepeatCount(-1);
            this.d.addListener(new b(this));
        }
        if (this.e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, p, 0.0f, 1.0f);
            this.e = ofFloat2;
            ofFloat2.setDuration(333L);
            this.e.setInterpolator(this.f);
            this.e.addListener(new c(this));
        }
        h();
        this.d.start();
    }

    @Override // a2.j.b.d.n.i
    public void g() {
        this.k = null;
    }

    @VisibleForTesting
    public void h() {
        this.h = 0;
        this.c[0] = MaterialColors.compositeARGBWithAlpha(this.g.indicatorColors[0], this.a.getAlpha());
        this.j = 0.0f;
    }
}
