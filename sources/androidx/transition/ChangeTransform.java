package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import l6.z.f;
import l6.z.j;
import l6.z.p;
import org.xmlpull.v1.XmlPullParser;
public class ChangeTransform extends Transition {
    public static final String[] M = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
    public static final Property<d, float[]> N = new a(float[].class, "nonTranslations");
    public static final Property<d, PointF> O = new b(PointF.class, "translations");
    public static final boolean P = true;
    public boolean J = true;
    public boolean K = true;
    public Matrix L = new Matrix();

    public static class a extends Property<d, float[]> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ float[] get(d dVar) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(d dVar, float[] fArr) {
            d dVar2 = dVar;
            float[] fArr2 = fArr;
            System.arraycopy(fArr2, 0, dVar2.c, 0, fArr2.length);
            dVar2.a();
        }
    }

    public static class b extends Property<d, PointF> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(d dVar) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(d dVar, PointF pointF) {
            d dVar2 = dVar;
            PointF pointF2 = pointF;
            Objects.requireNonNull(dVar2);
            dVar2.d = pointF2.x;
            dVar2.e = pointF2.y;
            dVar2.a();
        }
    }

    public static class c extends TransitionListenerAdapter {
        public View a;
        public l6.z.c b;

        public c(View view, l6.z.c cVar) {
            this.a = view;
            this.b = cVar;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            transition.removeListener(this);
            View view = this.a;
            if (Build.VERSION.SDK_INT == 28) {
                if (!l6.z.e.g) {
                    try {
                        if (!l6.z.e.c) {
                            try {
                                l6.z.e.b = Class.forName("android.view.GhostView");
                            } catch (ClassNotFoundException unused) {
                            }
                            l6.z.e.c = true;
                        }
                        Method declaredMethod = l6.z.e.b.getDeclaredMethod("removeGhost", View.class);
                        l6.z.e.f = declaredMethod;
                        declaredMethod.setAccessible(true);
                    } catch (NoSuchMethodException unused2) {
                    }
                    l6.z.e.g = true;
                }
                Method method = l6.z.e.f;
                if (method != null) {
                    try {
                        method.invoke(null, view);
                    } catch (IllegalAccessException unused3) {
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e.getCause());
                    }
                }
            } else {
                int i = f.g;
                f fVar = (f) view.getTag(R.id.ghost_view);
                if (fVar != null) {
                    int i2 = fVar.d - 1;
                    fVar.d = i2;
                    if (i2 <= 0) {
                        ((l6.z.d) fVar.getParent()).removeView(fVar);
                    }
                }
            }
            this.a.setTag(R.id.transition_transform, null);
            this.a.setTag(R.id.parent_matrix, null);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition transition) {
            this.b.setVisibility(4);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition transition) {
            this.b.setVisibility(0);
        }
    }

    public static class d {
        public final Matrix a = new Matrix();
        public final View b;
        public final float[] c;
        public float d;
        public float e;

        public d(View view, float[] fArr) {
            this.b = view;
            float[] fArr2 = (float[]) fArr.clone();
            this.c = fArr2;
            this.d = fArr2[2];
            this.e = fArr2[5];
            a();
        }

        public final void a() {
            float[] fArr = this.c;
            fArr[2] = this.d;
            fArr[5] = this.e;
            this.a.setValues(fArr);
            p.a.d(this.b, this.a);
        }
    }

    public static class e {
        public final float a;
        public final float b;
        public final float c;
        public final float d;
        public final float e;
        public final float f;
        public final float g;
        public final float h;

        public e(View view) {
            this.a = view.getTranslationX();
            this.b = view.getTranslationY();
            this.c = ViewCompat.getTranslationZ(view);
            this.d = view.getScaleX();
            this.e = view.getScaleY();
            this.f = view.getRotationX();
            this.g = view.getRotationY();
            this.h = view.getRotation();
        }

        public void a(View view) {
            float f2 = this.a;
            float f3 = this.b;
            float f4 = this.c;
            float f5 = this.d;
            float f6 = this.e;
            float f7 = this.f;
            float f8 = this.g;
            float f9 = this.h;
            String[] strArr = ChangeTransform.M;
            view.setTranslationX(f2);
            view.setTranslationY(f3);
            ViewCompat.setTranslationZ(view, f4);
            view.setScaleX(f5);
            view.setScaleY(f6);
            view.setRotationX(f7);
            view.setRotationY(f8);
            view.setRotation(f9);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            if (eVar.a == this.a && eVar.b == this.b && eVar.c == this.c && eVar.d == this.d && eVar.e == this.e && eVar.f == this.f && eVar.g == this.g && eVar.h == this.h) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            float f2 = this.a;
            int i = 0;
            int floatToIntBits = (f2 != 0.0f ? Float.floatToIntBits(f2) : 0) * 31;
            float f3 = this.b;
            int floatToIntBits2 = (floatToIntBits + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
            float f4 = this.c;
            int floatToIntBits3 = (floatToIntBits2 + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0)) * 31;
            float f5 = this.d;
            int floatToIntBits4 = (floatToIntBits3 + (f5 != 0.0f ? Float.floatToIntBits(f5) : 0)) * 31;
            float f6 = this.e;
            int floatToIntBits5 = (floatToIntBits4 + (f6 != 0.0f ? Float.floatToIntBits(f6) : 0)) * 31;
            float f7 = this.f;
            int floatToIntBits6 = (floatToIntBits5 + (f7 != 0.0f ? Float.floatToIntBits(f7) : 0)) * 31;
            float f8 = this.g;
            int floatToIntBits7 = (floatToIntBits6 + (f8 != 0.0f ? Float.floatToIntBits(f8) : 0)) * 31;
            float f9 = this.h;
            if (f9 != 0.0f) {
                i = Float.floatToIntBits(f9);
            }
            return floatToIntBits7 + i;
        }
    }

    public ChangeTransform() {
    }

    public static void p(View view) {
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        ViewCompat.setTranslationZ(view, 0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setRotation(0.0f);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        o(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        o(transitionValues);
        if (!P) {
            ((ViewGroup) transitionValues.view.getParent()).startViewTransition(transitionValues.view);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v24, types: [androidx.transition.TransitionSet] */
    /* JADX WARN: Type inference failed for: r6v4, types: [l6.z.e] */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x02fd: APUT  (r10v6 java.lang.Class[]), (1 ??[boolean, int, float, short, byte, char]), (r7v13 java.lang.Class) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0329: APUT  
      (r8v7 java.lang.Object[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.Integer : 0x0323: INVOKE  (r10v4 java.lang.Integer) = 
      (wrap: int : 0x031f: INVOKE  (r10v3 int) = (r12v8 android.view.ViewGroup) type: VIRTUAL call: android.view.ViewGroup.getChildCount():int)
     type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02ca, code lost:
        if (r15.getZ() > r0.getZ()) goto L_0x0390;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0380, code lost:
        if (r3.size() == r12) goto L_0x0390;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0383, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
        r1 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0424  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e4  */
    /* JADX WARNING: Unknown variable types count: 7 */
    @Override // androidx.transition.Transition
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator createAnimator(@androidx.annotation.NonNull android.view.ViewGroup r25, androidx.transition.TransitionValues r26, androidx.transition.TransitionValues r27) {
        /*
        // Method dump skipped, instructions count: 1070
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeTransform.createAnimator(android.view.ViewGroup, androidx.transition.TransitionValues, androidx.transition.TransitionValues):android.animation.Animator");
    }

    public boolean getReparent() {
        return this.K;
    }

    public boolean getReparentWithOverlay() {
        return this.J;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return M;
    }

    public final void o(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view.getVisibility() != 8) {
            transitionValues.values.put("android:changeTransform:parent", view.getParent());
            transitionValues.values.put("android:changeTransform:transforms", new e(view));
            Matrix matrix = view.getMatrix();
            transitionValues.values.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
            if (this.K) {
                Matrix matrix2 = new Matrix();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                p.a.h(viewGroup, matrix2);
                matrix2.preTranslate((float) (-viewGroup.getScrollX()), (float) (-viewGroup.getScrollY()));
                transitionValues.values.put("android:changeTransform:parentMatrix", matrix2);
                transitionValues.values.put("android:changeTransform:intermediateMatrix", view.getTag(R.id.transition_transform));
                transitionValues.values.put("android:changeTransform:intermediateParentMatrix", view.getTag(R.id.parent_matrix));
            }
        }
    }

    public void setReparent(boolean z) {
        this.K = z;
    }

    public void setReparentWithOverlay(boolean z) {
        this.J = z;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.g);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.J = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.K = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        obtainStyledAttributes.recycle();
    }
}
