package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import java.util.ArrayList;
import l6.m.a.a;
public abstract class DynamicAnimation<T extends DynamicAnimation<T>> implements a.b {
    public static final ViewProperty ALPHA = new c("alpha");
    public static final float MIN_VISIBLE_CHANGE_ALPHA = 0.00390625f;
    public static final float MIN_VISIBLE_CHANGE_PIXELS = 1.0f;
    public static final float MIN_VISIBLE_CHANGE_ROTATION_DEGREES = 0.1f;
    public static final float MIN_VISIBLE_CHANGE_SCALE = 0.002f;
    public static final ViewProperty ROTATION = new l("rotation");
    public static final ViewProperty ROTATION_X = new m("rotationX");
    public static final ViewProperty ROTATION_Y = new n("rotationY");
    public static final ViewProperty SCALE_X = new j("scaleX");
    public static final ViewProperty SCALE_Y = new k("scaleY");
    public static final ViewProperty SCROLL_X = new d("scrollX");
    public static final ViewProperty SCROLL_Y = new e("scrollY");
    public static final ViewProperty TRANSLATION_X = new g("translationX");
    public static final ViewProperty TRANSLATION_Y = new h("translationY");
    public static final ViewProperty TRANSLATION_Z = new i("translationZ");
    public static final ViewProperty X = new o("x");
    public static final ViewProperty Y = new a("y");
    public static final ViewProperty Z = new b("z");
    public float a;
    public float b;
    public boolean c;
    public final Object d;
    public final FloatPropertyCompat e;
    public boolean f;
    public float g;
    public float h;
    public long i;
    public float j;
    public final ArrayList<OnAnimationEndListener> k;
    public final ArrayList<OnAnimationUpdateListener> l;

    public interface OnAnimationEndListener {
        void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f2);
    }

    public interface OnAnimationUpdateListener {
        void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2);
    }

    public static abstract class ViewProperty extends FloatPropertyCompat<View> {
        public ViewProperty(String str, g gVar) {
            super(str);
        }
    }

    public static class a extends ViewProperty {
        public a(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getY();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            view.setY(f);
        }
    }

    public static class b extends ViewProperty {
        public b(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return ViewCompat.getZ(view);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            ViewCompat.setZ(view, f);
        }
    }

    public static class c extends ViewProperty {
        public c(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getAlpha();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            view.setAlpha(f);
        }
    }

    public static class d extends ViewProperty {
        public d(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return (float) view.getScrollX();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            view.setScrollX((int) f);
        }
    }

    public static class e extends ViewProperty {
        public e(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return (float) view.getScrollY();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            view.setScrollY((int) f);
        }
    }

    public class f extends FloatPropertyCompat {
        public final /* synthetic */ FloatValueHolder a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(DynamicAnimation dynamicAnimation, String str, FloatValueHolder floatValueHolder) {
            super(str);
            this.a = floatValueHolder;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(Object obj) {
            return this.a.getValue();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(Object obj, float f) {
            this.a.setValue(f);
        }
    }

    public static class g extends ViewProperty {
        public g(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getTranslationX();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            view.setTranslationX(f);
        }
    }

    public static class h extends ViewProperty {
        public h(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getTranslationY();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            view.setTranslationY(f);
        }
    }

    public static class i extends ViewProperty {
        public i(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return ViewCompat.getTranslationZ(view);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            ViewCompat.setTranslationZ(view, f);
        }
    }

    public static class j extends ViewProperty {
        public j(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getScaleX();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            view.setScaleX(f);
        }
    }

    public static class k extends ViewProperty {
        public k(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getScaleY();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            view.setScaleY(f);
        }
    }

    public static class l extends ViewProperty {
        public l(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getRotation();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            view.setRotation(f);
        }
    }

    public static class m extends ViewProperty {
        public m(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getRotationX();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            view.setRotationX(f);
        }
    }

    public static class n extends ViewProperty {
        public n(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getRotationY();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            view.setRotationY(f);
        }
    }

    public static class o extends ViewProperty {
        public o(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getX();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, float] */
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            view.setX(f);
        }
    }

    public static class p {
        public float a;
        public float b;
    }

    public DynamicAnimation(FloatValueHolder floatValueHolder) {
        this.a = 0.0f;
        this.b = Float.MAX_VALUE;
        this.c = false;
        this.f = false;
        this.g = Float.MAX_VALUE;
        this.h = -Float.MAX_VALUE;
        this.i = 0;
        this.k = new ArrayList<>();
        this.l = new ArrayList<>();
        this.d = null;
        this.e = new f(this, "FloatValueHolder", floatValueHolder);
        this.j = 1.0f;
    }

    public static <T> void c(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    public final void a(boolean z) {
        this.f = false;
        l6.m.a.a a3 = l6.m.a.a.a();
        a3.a.remove(this);
        int indexOf = a3.b.indexOf(this);
        if (indexOf >= 0) {
            a3.b.set(indexOf, null);
            a3.f = true;
        }
        this.i = 0;
        this.c = false;
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            if (this.k.get(i2) != null) {
                this.k.get(i2).onAnimationEnd(this, z, this.b, this.a);
            }
        }
        c(this.k);
    }

    public T addEndListener(OnAnimationEndListener onAnimationEndListener) {
        if (!this.k.contains(onAnimationEndListener)) {
            this.k.add(onAnimationEndListener);
        }
        return this;
    }

    public T addUpdateListener(OnAnimationUpdateListener onAnimationUpdateListener) {
        if (!isRunning()) {
            if (!this.l.contains(onAnimationUpdateListener)) {
                this.l.add(onAnimationUpdateListener);
            }
            return this;
        }
        throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
    }

    public float b() {
        return this.j * 0.75f;
    }

    public void cancel() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        } else if (this.f) {
            a(true);
        }
    }

    public void d(float f2) {
        this.e.setValue(this.d, f2);
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            if (this.l.get(i2) != null) {
                this.l.get(i2).onAnimationUpdate(this, this.b, this.a);
            }
        }
        c(this.l);
    }

    @Override // l6.m.a.a.b
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean doAnimationFrame(long j2) {
        long j3 = this.i;
        if (j3 == 0) {
            this.i = j2;
            d(this.b);
            return false;
        }
        this.i = j2;
        boolean f2 = f(j2 - j3);
        float min = Math.min(this.b, this.g);
        this.b = min;
        float max = Math.max(min, this.h);
        this.b = max;
        d(max);
        if (f2) {
            a(false);
        }
        return f2;
    }

    public abstract void e(float f2);

    public abstract boolean f(long j2);

    public float getMinimumVisibleChange() {
        return this.j;
    }

    public boolean isRunning() {
        return this.f;
    }

    public void removeEndListener(OnAnimationEndListener onAnimationEndListener) {
        ArrayList<OnAnimationEndListener> arrayList = this.k;
        int indexOf = arrayList.indexOf(onAnimationEndListener);
        if (indexOf >= 0) {
            arrayList.set(indexOf, null);
        }
    }

    public void removeUpdateListener(OnAnimationUpdateListener onAnimationUpdateListener) {
        ArrayList<OnAnimationUpdateListener> arrayList = this.l;
        int indexOf = arrayList.indexOf(onAnimationUpdateListener);
        if (indexOf >= 0) {
            arrayList.set(indexOf, null);
        }
    }

    public T setMaxValue(float f2) {
        this.g = f2;
        return this;
    }

    public T setMinValue(float f2) {
        this.h = f2;
        return this;
    }

    public T setMinimumVisibleChange(@FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        if (f2 > 0.0f) {
            this.j = f2;
            e(f2 * 0.75f);
            return this;
        }
        throw new IllegalArgumentException("Minimum visible change must be positive.");
    }

    public T setStartValue(float f2) {
        this.b = f2;
        this.c = true;
        return this;
    }

    public T setStartVelocity(float f2) {
        this.a = f2;
        return this;
    }

    public void start() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            boolean z = this.f;
            if (!z && !z) {
                this.f = true;
                if (!this.c) {
                    this.b = this.e.getValue(this.d);
                }
                float f2 = this.b;
                if (f2 > this.g || f2 < this.h) {
                    throw new IllegalArgumentException("Starting value need to be in between min value and max value");
                }
                l6.m.a.a a3 = l6.m.a.a.a();
                if (a3.b.size() == 0) {
                    if (a3.d == null) {
                        a3.d = new a.d(a3.c);
                    }
                    a.d dVar = (a.d) a3.d;
                    dVar.b.postFrameCallback(dVar.c);
                }
                if (!a3.b.contains(this)) {
                    a3.b.add(this);
                    return;
                }
                return;
            }
            return;
        }
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    }

    public <K> DynamicAnimation(K k2, FloatPropertyCompat<K> floatPropertyCompat) {
        this.a = 0.0f;
        this.b = Float.MAX_VALUE;
        this.c = false;
        this.f = false;
        this.g = Float.MAX_VALUE;
        this.h = -Float.MAX_VALUE;
        this.i = 0;
        this.k = new ArrayList<>();
        this.l = new ArrayList<>();
        this.d = k2;
        this.e = floatPropertyCompat;
        if (floatPropertyCompat == ROTATION || floatPropertyCompat == ROTATION_X || floatPropertyCompat == ROTATION_Y) {
            this.j = 0.1f;
        } else if (floatPropertyCompat == ALPHA) {
            this.j = 0.00390625f;
        } else if (floatPropertyCompat == SCALE_X || floatPropertyCompat == SCALE_Y) {
            this.j = 0.00390625f;
        } else {
            this.j = 1.0f;
        }
    }
}
