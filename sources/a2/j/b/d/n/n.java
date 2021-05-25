package a2.j.b.d.n;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import java.util.Arrays;
public final class n extends i<ObjectAnimator> {
    public static final int[] l = {533, 567, 850, 750};
    public static final int[] m = {1267, 1000, 333, 0};
    public static final Property<n, Float> n = new a(Float.class, "animationFraction");
    public ObjectAnimator d;
    public final Interpolator[] e;
    public final BaseProgressIndicatorSpec f;
    public int g = 0;
    public boolean h;
    public float i;
    public boolean j;
    public Animatable2Compat.AnimationCallback k = null;

    public static class a extends Property<n, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(n nVar) {
            return Float.valueOf(nVar.i);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(n nVar, Float f) {
            n nVar2 = nVar;
            float floatValue = f.floatValue();
            nVar2.i = floatValue;
            int i = (int) (floatValue * 1800.0f);
            for (int i2 = 0; i2 < 4; i2++) {
                nVar2.b[i2] = Math.max(0.0f, Math.min(1.0f, nVar2.e[i2].getInterpolation(nVar2.b(i, n.m[i2], n.l[i2]))));
            }
            if (nVar2.h) {
                Arrays.fill(nVar2.c, MaterialColors.compositeARGBWithAlpha(nVar2.f.indicatorColors[nVar2.g], nVar2.a.getAlpha()));
                nVar2.h = false;
            }
            nVar2.a.invalidateSelf();
        }
    }

    public n(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(2);
        this.f = linearProgressIndicatorSpec;
        this.e = new Interpolator[]{AnimationUtilsCompat.loadInterpolator(context, R.animator.linear_indeterminate_line1_head_interpolator), AnimationUtilsCompat.loadInterpolator(context, R.animator.linear_indeterminate_line1_tail_interpolator), AnimationUtilsCompat.loadInterpolator(context, R.animator.linear_indeterminate_line2_head_interpolator), AnimationUtilsCompat.loadInterpolator(context, R.animator.linear_indeterminate_line2_tail_interpolator)};
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
        if (this.a.isVisible()) {
            this.j = true;
            this.d.setRepeatCount(0);
            return;
        }
        ObjectAnimator objectAnimator = this.d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // a2.j.b.d.n.i
    public void f() {
        if (this.d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, n, 0.0f, 1.0f);
            this.d = ofFloat;
            ofFloat.setDuration(1800L);
            this.d.setInterpolator(null);
            this.d.setRepeatCount(-1);
            this.d.addListener(new m(this));
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
        this.g = 0;
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(this.f.indicatorColors[0], this.a.getAlpha());
        int[] iArr = this.c;
        iArr[0] = compositeARGBWithAlpha;
        iArr[1] = compositeARGBWithAlpha;
    }
}
