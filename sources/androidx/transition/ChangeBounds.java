package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import com.vk.sdk.api.VKApiConst;
import java.util.Map;
import java.util.Objects;
import l6.z.l;
import l6.z.o;
import l6.z.p;
public class ChangeBounds extends Transition {
    public static final String[] L = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final Property<Drawable, PointF> M = new a(PointF.class, "boundsOrigin");
    public static final Property<j, PointF> N = new b(PointF.class, "topLeft");
    public static final Property<j, PointF> O = new c(PointF.class, "bottomRight");
    public static final Property<View, PointF> P = new d(PointF.class, "bottomRight");
    public static final Property<View, PointF> Q = new e(PointF.class, "topLeft");
    public static final Property<View, PointF> R = new f(PointF.class, VKApiConst.POSITION);
    public static l6.z.i S = new l6.z.i();
    public int[] J;
    public boolean K;

    public static class a extends Property<Drawable, PointF> {
        public Rect a = new Rect();

        public a(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.a);
            Rect rect = this.a;
            return new PointF((float) rect.left, (float) rect.top);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(Drawable drawable, PointF pointF) {
            Drawable drawable2 = drawable;
            PointF pointF2 = pointF;
            drawable2.copyBounds(this.a);
            this.a.offsetTo(Math.round(pointF2.x), Math.round(pointF2.y));
            drawable2.setBounds(this.a);
        }
    }

    public static class b extends Property<j, PointF> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(j jVar) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(j jVar, PointF pointF) {
            j jVar2 = jVar;
            PointF pointF2 = pointF;
            Objects.requireNonNull(jVar2);
            jVar2.a = Math.round(pointF2.x);
            int round = Math.round(pointF2.y);
            jVar2.b = round;
            int i = jVar2.f + 1;
            jVar2.f = i;
            if (i == jVar2.g) {
                p.b(jVar2.e, jVar2.a, round, jVar2.c, jVar2.d);
                jVar2.f = 0;
                jVar2.g = 0;
            }
        }
    }

    public static class c extends Property<j, PointF> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(j jVar) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(j jVar, PointF pointF) {
            j jVar2 = jVar;
            PointF pointF2 = pointF;
            Objects.requireNonNull(jVar2);
            jVar2.c = Math.round(pointF2.x);
            int round = Math.round(pointF2.y);
            jVar2.d = round;
            int i = jVar2.g + 1;
            jVar2.g = i;
            if (jVar2.f == i) {
                p.b(jVar2.e, jVar2.a, jVar2.b, jVar2.c, round);
                jVar2.f = 0;
                jVar2.g = 0;
            }
        }
    }

    public static class d extends Property<View, PointF> {
        public d(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            p.b(view2, view2.getLeft(), view2.getTop(), Math.round(pointF2.x), Math.round(pointF2.y));
        }
    }

    public static class e extends Property<View, PointF> {
        public e(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            p.b(view2, Math.round(pointF2.x), Math.round(pointF2.y), view2.getRight(), view2.getBottom());
        }
    }

    public static class f extends Property<View, PointF> {
        public f(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            int round = Math.round(pointF2.x);
            int round2 = Math.round(pointF2.y);
            p.b(view2, round, round2, view2.getWidth() + round, view2.getHeight() + round2);
        }
    }

    public class g extends AnimatorListenerAdapter {
        public final /* synthetic */ j a;
        private j mViewBounds;

        public g(ChangeBounds changeBounds, j jVar) {
            this.a = jVar;
            this.mViewBounds = jVar;
        }
    }

    public class h extends AnimatorListenerAdapter {
        public boolean a;
        public final /* synthetic */ View b;
        public final /* synthetic */ Rect c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ int g;

        public h(ChangeBounds changeBounds, View view, Rect rect, int i, int i2, int i3, int i4) {
            this.b = view;
            this.c = rect;
            this.d = i;
            this.e = i2;
            this.f = i3;
            this.g = i4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.a) {
                ViewCompat.setClipBounds(this.b, this.c);
                p.b(this.b, this.d, this.e, this.f, this.g);
            }
        }
    }

    public class i extends TransitionListenerAdapter {
        public boolean a = false;
        public final /* synthetic */ ViewGroup b;

        public i(ChangeBounds changeBounds, ViewGroup viewGroup) {
            this.b = viewGroup;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(@NonNull Transition transition) {
            o.a(this.b, false);
            this.a = true;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            if (!this.a) {
                o.a(this.b, false);
            }
            transition.removeListener(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition transition) {
            o.a(this.b, false);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition transition) {
            o.a(this.b, true);
        }
    }

    public static class j {
        public int a;
        public int b;
        public int c;
        public int d;
        public View e;
        public int f;
        public int g;

        public j(View view) {
            this.e = view;
        }
    }

    public ChangeBounds() {
        this.J = new int[2];
        this.K = false;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        o(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        o(transitionValues);
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        int i2;
        boolean z;
        View view;
        Animator animator;
        ObjectAnimator objectAnimator;
        int i3;
        Rect rect;
        ObjectAnimator objectAnimator2;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        Map<String, Object> map = transitionValues.values;
        Map<String, Object> map2 = transitionValues2.values;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = transitionValues2.view;
        Rect rect2 = (Rect) transitionValues.values.get("android:changeBounds:bounds");
        Rect rect3 = (Rect) transitionValues2.values.get("android:changeBounds:bounds");
        int i4 = rect2.left;
        int i5 = rect3.left;
        int i6 = rect2.top;
        int i7 = rect3.top;
        int i8 = rect2.right;
        int i9 = rect3.right;
        int i10 = rect2.bottom;
        int i11 = rect3.bottom;
        int i12 = i8 - i4;
        int i13 = i10 - i6;
        int i14 = i9 - i5;
        int i15 = i11 - i7;
        Rect rect4 = (Rect) transitionValues.values.get("android:changeBounds:clip");
        Rect rect5 = (Rect) transitionValues2.values.get("android:changeBounds:clip");
        if ((i12 == 0 || i13 == 0) && (i14 == 0 || i15 == 0)) {
            i2 = 0;
        } else {
            i2 = (i4 == i5 && i6 == i7) ? 0 : 1;
            if (!(i8 == i9 && i10 == i11)) {
                i2++;
            }
        }
        if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
            i2++;
        }
        if (i2 <= 0) {
            return null;
        }
        if (!this.K) {
            view = view2;
            p.b(view, i4, i6, i8, i10);
            if (i2 == 2) {
                if (i12 == i14 && i13 == i15) {
                    animator = AppCompatDelegateImpl.i.o1(view, R, getPathMotion().getPath((float) i4, (float) i6, (float) i5, (float) i7));
                } else {
                    j jVar = new j(view);
                    ObjectAnimator o1 = AppCompatDelegateImpl.i.o1(jVar, N, getPathMotion().getPath((float) i4, (float) i6, (float) i5, (float) i7));
                    ObjectAnimator o12 = AppCompatDelegateImpl.i.o1(jVar, O, getPathMotion().getPath((float) i8, (float) i10, (float) i9, (float) i11));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(o1, o12);
                    animatorSet.addListener(new g(this, jVar));
                    animator = animatorSet;
                }
            } else if (i4 == i5 && i6 == i7) {
                animator = AppCompatDelegateImpl.i.o1(view, P, getPathMotion().getPath((float) i8, (float) i10, (float) i9, (float) i11));
            } else {
                animator = AppCompatDelegateImpl.i.o1(view, Q, getPathMotion().getPath((float) i4, (float) i6, (float) i5, (float) i7));
            }
            z = true;
        } else {
            view = view2;
            p.b(view, i4, i6, Math.max(i12, i14) + i4, Math.max(i13, i15) + i6);
            if (i4 == i5 && i6 == i7) {
                objectAnimator = null;
            } else {
                objectAnimator = AppCompatDelegateImpl.i.o1(view, R, getPathMotion().getPath((float) i4, (float) i6, (float) i5, (float) i7));
            }
            if (rect4 == null) {
                i3 = 0;
                rect = new Rect(0, 0, i12, i13);
            } else {
                i3 = 0;
                rect = rect4;
            }
            Rect rect6 = rect5 == null ? new Rect(i3, i3, i14, i15) : rect5;
            if (!rect.equals(rect6)) {
                ViewCompat.setClipBounds(view, rect);
                l6.z.i iVar = S;
                Object[] objArr = new Object[2];
                objArr[i3] = rect;
                objArr[1] = rect6;
                ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", iVar, objArr);
                z = true;
                ofObject.addListener(new h(this, view, rect5, i5, i7, i9, i11));
                objectAnimator2 = ofObject;
            } else {
                z = true;
                objectAnimator2 = null;
            }
            animator = l.a(objectAnimator, objectAnimator2);
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            o.a(viewGroup4, z);
            addListener(new i(this, viewGroup4));
        }
        return animator;
    }

    public boolean getResizeClip() {
        return this.K;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return L;
    }

    public final void o(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (ViewCompat.isLaidOut(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            transitionValues.values.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            transitionValues.values.put("android:changeBounds:parent", transitionValues.view.getParent());
            if (this.K) {
                transitionValues.values.put("android:changeBounds:clip", ViewCompat.getClipBounds(view));
            }
        }
    }

    public void setResizeClip(boolean z) {
        this.K = z;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.J = new int[2];
        this.K = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l6.z.j.d);
        boolean namedBoolean = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        setResizeClip(namedBoolean);
    }
}
