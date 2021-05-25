package a2.j.b.d.n;

import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import java.util.Arrays;
public final class l extends i<ObjectAnimator> {
    public static final Property<l, Float> j = new a(Float.class, "animationFraction");
    public ObjectAnimator d;
    public FastOutSlowInInterpolator e;
    public final BaseProgressIndicatorSpec f;
    public int g = 1;
    public boolean h;
    public float i;

    public static class a extends Property<l, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(l lVar) {
            return Float.valueOf(lVar.i);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(l lVar, Float f) {
            l lVar2 = lVar;
            float floatValue = f.floatValue();
            lVar2.i = floatValue;
            lVar2.b[0] = 0.0f;
            float b = lVar2.b((int) (floatValue * 333.0f), 0, 667);
            float[] fArr = lVar2.b;
            float interpolation = lVar2.e.getInterpolation(b);
            fArr[2] = interpolation;
            fArr[1] = interpolation;
            float[] fArr2 = lVar2.b;
            float interpolation2 = lVar2.e.getInterpolation(b + 0.49925038f);
            fArr2[4] = interpolation2;
            fArr2[3] = interpolation2;
            float[] fArr3 = lVar2.b;
            fArr3[5] = 1.0f;
            if (lVar2.h && fArr3[3] < 1.0f) {
                int[] iArr = lVar2.c;
                iArr[2] = iArr[1];
                iArr[1] = iArr[0];
                iArr[0] = MaterialColors.compositeARGBWithAlpha(lVar2.f.indicatorColors[lVar2.g], lVar2.a.getAlpha());
                lVar2.h = false;
            }
            lVar2.a.invalidateSelf();
        }
    }

    public l(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(3);
        this.f = linearProgressIndicatorSpec;
        this.e = new FastOutSlowInInterpolator();
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
    public void d(@Nullable Animatable2Compat.AnimationCallback animationCallback) {
    }

    @Override // a2.j.b.d.n.i
    public void e() {
    }

    @Override // a2.j.b.d.n.i
    public void f() {
        if (this.d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, j, 0.0f, 1.0f);
            this.d = ofFloat;
            ofFloat.setDuration(333L);
            this.d.setInterpolator(null);
            this.d.setRepeatCount(-1);
            this.d.addListener(new k(this));
        }
        h();
        this.d.start();
    }

    @Override // a2.j.b.d.n.i
    public void g() {
    }

    @VisibleForTesting
    public void h() {
        this.h = true;
        this.g = 1;
        Arrays.fill(this.c, MaterialColors.compositeARGBWithAlpha(this.f.indicatorColors[0], this.a.getAlpha()));
    }
}
