package a2.j.b.d.k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.ArrayList;
import java.util.Iterator;
public class g {
    public static final TimeInterpolator F = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
    public static final int[] G = {16842919, 16842910};
    public static final int[] H = {16843623, 16842908, 16842910};
    public static final int[] I = {16842908, 16842910};
    public static final int[] J = {16843623, 16842910};
    public static final int[] K = {16842910};
    public static final int[] L = new int[0];
    public final Rect A = new Rect();
    public final RectF B = new RectF();
    public final RectF C = new RectF();
    public final Matrix D = new Matrix();
    @Nullable
    public ViewTreeObserver.OnPreDrawListener E;
    @Nullable
    public ShapeAppearanceModel a;
    @Nullable
    public MaterialShapeDrawable b;
    @Nullable
    public Drawable c;
    @Nullable
    public c d;
    @Nullable
    public Drawable e;
    public boolean f;
    public boolean g = true;
    public float h;
    public float i;
    public float j;
    public int k;
    @NonNull
    public final StateListAnimator l;
    @Nullable
    public MotionSpec m;
    @Nullable
    public MotionSpec n;
    @Nullable
    public Animator o;
    @Nullable
    public MotionSpec p;
    @Nullable
    public MotionSpec q;
    public float r;
    public float s = 1.0f;
    public int t;
    public int u = 0;
    public ArrayList<Animator.AnimatorListener> v;
    public ArrayList<Animator.AnimatorListener> w;
    public ArrayList<e> x;
    public final FloatingActionButton y;
    public final ShadowViewDelegate z;

    public class b extends h {
        public b(g gVar) {
            super(null);
        }

        @Override // a2.j.b.d.k.g.h
        public float a() {
            return 0.0f;
        }
    }

    public class c extends h {
        public c() {
            super(null);
        }

        @Override // a2.j.b.d.k.g.h
        public float a() {
            g gVar = g.this;
            return gVar.h + gVar.i;
        }
    }

    public class d extends h {
        public d() {
            super(null);
        }

        @Override // a2.j.b.d.k.g.h
        public float a() {
            g gVar = g.this;
            return gVar.h + gVar.j;
        }
    }

    public interface e {
        void a();

        void b();
    }

    public interface f {
    }

    /* renamed from: a2.j.b.d.k.g$g  reason: collision with other inner class name */
    public class C0042g extends h {
        public C0042g() {
            super(null);
        }

        @Override // a2.j.b.d.k.g.h
        public float a() {
            return g.this.h;
        }
    }

    public abstract class h extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        public boolean a;
        public float b;
        public float c;

        public h(e eVar) {
        }

        public abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            g.this.x((float) ((int) this.c));
            this.a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            if (!this.a) {
                MaterialShapeDrawable materialShapeDrawable = g.this.b;
                this.b = materialShapeDrawable == null ? 0.0f : materialShapeDrawable.getElevation();
                this.c = a();
                this.a = true;
            }
            g gVar = g.this;
            float f = this.b;
            gVar.x((float) ((int) ((valueAnimator.getAnimatedFraction() * (this.c - f)) + f)));
        }
    }

    public g(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate) {
        this.y = floatingActionButton;
        this.z = shadowViewDelegate;
        StateListAnimator stateListAnimator = new StateListAnimator();
        this.l = stateListAnimator;
        stateListAnimator.addState(G, c(new d()));
        stateListAnimator.addState(H, c(new c()));
        stateListAnimator.addState(I, c(new c()));
        stateListAnimator.addState(J, c(new c()));
        stateListAnimator.addState(K, c(new C0042g()));
        stateListAnimator.addState(L, c(new b(this)));
        this.r = floatingActionButton.getRotation();
    }

    public final void a(float f2, @NonNull Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.y.getDrawable();
        if (drawable != null && this.t != 0) {
            RectF rectF = this.B;
            RectF rectF2 = this.C;
            rectF.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            int i2 = this.t;
            rectF2.set(0.0f, 0.0f, (float) i2, (float) i2);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int i3 = this.t;
            matrix.postScale(f2, f2, ((float) i3) / 2.0f, ((float) i3) / 2.0f);
        }
    }

    @NonNull
    public final AnimatorSet b(@NonNull MotionSpec motionSpec, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.y, View.ALPHA, f2);
        motionSpec.getTiming("opacity").apply(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.y, View.SCALE_X, f3);
        motionSpec.getTiming("scale").apply(ofFloat2);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 26) {
            ofFloat2.setEvaluator(new h(this));
        }
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.y, View.SCALE_Y, f3);
        motionSpec.getTiming("scale").apply(ofFloat3);
        if (i2 == 26) {
            ofFloat3.setEvaluator(new h(this));
        }
        arrayList.add(ofFloat3);
        a(f4, this.D);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.y, new ImageMatrixProperty(), new a(), new Matrix(this.D));
        motionSpec.getTiming("iconScale").apply(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    @NonNull
    public final ValueAnimator c(@NonNull h hVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(F);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(hVar);
        valueAnimator.addUpdateListener(hVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    public float d() {
        throw null;
    }

    public void e(@NonNull Rect rect) {
        int sizeDimension = this.f ? (this.k - this.y.getSizeDimension()) / 2 : 0;
        float d2 = this.g ? d() + this.j : 0.0f;
        int max = Math.max(sizeDimension, (int) Math.ceil((double) d2));
        int max2 = Math.max(sizeDimension, (int) Math.ceil((double) (d2 * 1.5f)));
        rect.set(max, max2, max, max2);
    }

    public void f(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        throw null;
    }

    public boolean g() {
        if (this.y.getVisibility() == 0) {
            if (this.u == 1) {
                return true;
            }
            return false;
        } else if (this.u != 2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean h() {
        if (this.y.getVisibility() != 0) {
            if (this.u == 2) {
                return true;
            }
            return false;
        } else if (this.u != 1) {
            return true;
        } else {
            return false;
        }
    }

    public void i() {
        throw null;
    }

    public void j() {
        throw null;
    }

    public void k(int[] iArr) {
        throw null;
    }

    public void l(float f2, float f3, float f4) {
        throw null;
    }

    public void m() {
        ArrayList<e> arrayList = this.x;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public void n() {
        ArrayList<e> arrayList = this.x;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    public boolean o() {
        throw null;
    }

    public final void p(float f2) {
        this.s = f2;
        Matrix matrix = this.D;
        a(f2, matrix);
        this.y.setImageMatrix(matrix);
    }

    public void q(@Nullable ColorStateList colorStateList) {
        throw null;
    }

    public final void r(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.a = shapeAppearanceModel;
        MaterialShapeDrawable materialShapeDrawable = this.b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        Drawable drawable = this.c;
        if (drawable instanceof Shapeable) {
            ((Shapeable) drawable).setShapeAppearanceModel(shapeAppearanceModel);
        }
        c cVar = this.d;
        if (cVar != null) {
            cVar.o = shapeAppearanceModel;
            cVar.invalidateSelf();
        }
    }

    public boolean s() {
        throw null;
    }

    public final boolean t() {
        return ViewCompat.isLaidOut(this.y) && !this.y.isInEditMode();
    }

    public final boolean u() {
        return !this.f || this.y.getSizeDimension() >= this.k;
    }

    public void v() {
        throw null;
    }

    public final void w() {
        Rect rect = this.A;
        e(rect);
        Preconditions.checkNotNull(this.e, "Didn't initialize content background");
        if (s()) {
            this.z.setBackgroundDrawable(new InsetDrawable(this.e, rect.left, rect.top, rect.right, rect.bottom));
        } else {
            this.z.setBackgroundDrawable(this.e);
        }
        this.z.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void x(float f2) {
        MaterialShapeDrawable materialShapeDrawable = this.b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setElevation(f2);
        }
    }

    public class a extends MatrixEvaluator {
        public a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
        @Override // com.google.android.material.animation.MatrixEvaluator, android.animation.TypeEvaluator
        public Matrix evaluate(float f, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
            g.this.s = f;
            return super.evaluate(f, matrix, matrix2);
        }

        @Override // com.google.android.material.animation.MatrixEvaluator
        public Matrix evaluate(float f, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
            g.this.s = f;
            return super.evaluate(f, matrix, matrix2);
        }
    }
}
