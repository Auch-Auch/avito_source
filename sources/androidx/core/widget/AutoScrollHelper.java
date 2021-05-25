package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import java.util.Objects;
public abstract class AutoScrollHelper implements View.OnTouchListener {
    public static final int EDGE_TYPE_INSIDE = 0;
    public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
    public static final int EDGE_TYPE_OUTSIDE = 2;
    public static final float NO_MAX = Float.MAX_VALUE;
    public static final float NO_MIN = 0.0f;
    public static final float RELATIVE_UNSPECIFIED = 0.0f;
    public static final int r = ViewConfiguration.getTapTimeout();
    public final a a = new a();
    public final Interpolator b = new AccelerateInterpolator();
    public final View c;
    public Runnable d;
    public float[] e = {0.0f, 0.0f};
    public float[] f = {Float.MAX_VALUE, Float.MAX_VALUE};
    public int g;
    public int h;
    public float[] i = {0.0f, 0.0f};
    public float[] j = {0.0f, 0.0f};
    public float[] k = {Float.MAX_VALUE, Float.MAX_VALUE};
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;

    public static class a {
        public int a;
        public int b;
        public float c;
        public float d;
        public long e = Long.MIN_VALUE;
        public long f = 0;
        public int g = 0;
        public int h = 0;
        public long i = -1;
        public float j;
        public int k;

        public final float a(long j2) {
            long j3 = this.e;
            if (j2 < j3) {
                return 0.0f;
            }
            long j4 = this.i;
            if (j4 < 0 || j2 < j4) {
                return AutoScrollHelper.b(((float) (j2 - j3)) / ((float) this.a), 0.0f, 1.0f) * 0.5f;
            }
            float f2 = this.j;
            return (AutoScrollHelper.b(((float) (j2 - j4)) / ((float) this.k), 0.0f, 1.0f) * f2) + (1.0f - f2);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AutoScrollHelper autoScrollHelper = AutoScrollHelper.this;
            if (autoScrollHelper.o) {
                if (autoScrollHelper.m) {
                    autoScrollHelper.m = false;
                    a aVar = autoScrollHelper.a;
                    Objects.requireNonNull(aVar);
                    long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                    aVar.e = currentAnimationTimeMillis;
                    aVar.i = -1;
                    aVar.f = currentAnimationTimeMillis;
                    aVar.j = 0.5f;
                    aVar.g = 0;
                    aVar.h = 0;
                }
                a aVar2 = AutoScrollHelper.this.a;
                if ((aVar2.i > 0 && AnimationUtils.currentAnimationTimeMillis() > aVar2.i + ((long) aVar2.k)) || !AutoScrollHelper.this.e()) {
                    AutoScrollHelper.this.o = false;
                    return;
                }
                AutoScrollHelper autoScrollHelper2 = AutoScrollHelper.this;
                if (autoScrollHelper2.n) {
                    autoScrollHelper2.n = false;
                    Objects.requireNonNull(autoScrollHelper2);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    autoScrollHelper2.c.onTouchEvent(obtain);
                    obtain.recycle();
                }
                if (aVar2.f != 0) {
                    long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float a3 = aVar2.a(currentAnimationTimeMillis2);
                    aVar2.f = currentAnimationTimeMillis2;
                    float f = ((float) (currentAnimationTimeMillis2 - aVar2.f)) * ((a3 * 4.0f) + (-4.0f * a3 * a3));
                    int i = (int) (aVar2.c * f);
                    aVar2.g = i;
                    int i2 = (int) (f * aVar2.d);
                    aVar2.h = i2;
                    AutoScrollHelper.this.scrollTargetBy(i, i2);
                    ViewCompat.postOnAnimation(AutoScrollHelper.this.c, this);
                    return;
                }
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
        }
    }

    public AutoScrollHelper(@NonNull View view) {
        this.c = view;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        float f3 = (float) ((int) ((1575.0f * f2) + 0.5f));
        setMaximumVelocity(f3, f3);
        float f4 = (float) ((int) ((f2 * 315.0f) + 0.5f));
        setMinimumVelocity(f4, f4);
        setEdgeType(1);
        setMaximumEdges(Float.MAX_VALUE, Float.MAX_VALUE);
        setRelativeEdges(0.2f, 0.2f);
        setRelativeVelocity(1.0f, 1.0f);
        setActivationDelay(r);
        setRampUpDuration(500);
        setRampDownDuration(500);
    }

    public static float b(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final float a(int r4, float r5, float r6, float r7) {
        /*
            r3 = this;
            float[] r0 = r3.e
            r0 = r0[r4]
            float[] r1 = r3.f
            r1 = r1[r4]
            float r0 = r0 * r6
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r5, r0)
            float r6 = r6 - r5
            float r5 = r3.c(r6, r0)
            float r5 = r5 - r1
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x0026
            android.view.animation.Interpolator r6 = r3.b
            float r5 = -r5
            float r5 = r6.getInterpolation(r5)
            float r5 = -r5
            goto L_0x0030
        L_0x0026:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 <= 0) goto L_0x0039
            android.view.animation.Interpolator r6 = r3.b
            float r5 = r6.getInterpolation(r5)
        L_0x0030:
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r5 = b(r5, r6, r0)
            goto L_0x003a
        L_0x0039:
            r5 = 0
        L_0x003a:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x003f
            return r2
        L_0x003f:
            float[] r0 = r3.i
            r0 = r0[r4]
            float[] r1 = r3.j
            r1 = r1[r4]
            float[] r2 = r3.k
            r4 = r2[r4]
            float r0 = r0 * r7
            if (r6 <= 0) goto L_0x0056
            float r5 = r5 * r0
            float r4 = b(r5, r1, r4)
            return r4
        L_0x0056:
            float r5 = -r5
            float r5 = r5 * r0
            float r4 = b(r5, r1, r4)
            float r4 = -r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.AutoScrollHelper.a(int, float, float, float):float");
    }

    public final float c(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        int i2 = this.g;
        if (i2 == 0 || i2 == 1) {
            if (f2 < f3) {
                if (f2 >= 0.0f) {
                    return 1.0f - (f2 / f3);
                }
                if (this.o && i2 == 1) {
                    return 1.0f;
                }
            }
        } else if (i2 == 2 && f2 < 0.0f) {
            return f2 / (-f3);
        }
        return 0.0f;
    }

    public abstract boolean canTargetScrollHorizontally(int i2);

    public abstract boolean canTargetScrollVertically(int i2);

    public final void d() {
        int i2 = 0;
        if (this.m) {
            this.o = false;
            return;
        }
        a aVar = this.a;
        Objects.requireNonNull(aVar);
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i3 = (int) (currentAnimationTimeMillis - aVar.e);
        int i4 = aVar.b;
        if (i3 > i4) {
            i2 = i4;
        } else if (i3 >= 0) {
            i2 = i3;
        }
        aVar.k = i2;
        aVar.j = aVar.a(currentAnimationTimeMillis);
        aVar.i = currentAnimationTimeMillis;
    }

    public boolean e() {
        a aVar = this.a;
        float f2 = aVar.d;
        int abs = (int) (f2 / Math.abs(f2));
        float f3 = aVar.c;
        int abs2 = (int) (f3 / Math.abs(f3));
        return (abs != 0 && canTargetScrollVertically(abs)) || (abs2 != 0 && canTargetScrollHorizontally(abs2));
    }

    public boolean isEnabled() {
        return this.p;
    }

    public boolean isExclusive() {
        return this.q;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x007d;
     */
    @Override // android.view.View.OnTouchListener
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.p
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x001a
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x001e
            r6 = 3
            if (r0 == r6) goto L_0x0016
            goto L_0x007d
        L_0x0016:
            r5.d()
            goto L_0x007d
        L_0x001a:
            r5.n = r2
            r5.l = r1
        L_0x001e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.c
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.a(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.c
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.a(r2, r7, r6, r3)
            androidx.core.widget.AutoScrollHelper$a r7 = r5.a
            r7.c = r0
            r7.d = r6
            boolean r6 = r5.o
            if (r6 != 0) goto L_0x007d
            boolean r6 = r5.e()
            if (r6 == 0) goto L_0x007d
            java.lang.Runnable r6 = r5.d
            if (r6 != 0) goto L_0x0061
            androidx.core.widget.AutoScrollHelper$b r6 = new androidx.core.widget.AutoScrollHelper$b
            r6.<init>()
            r5.d = r6
        L_0x0061:
            r5.o = r2
            r5.m = r2
            boolean r6 = r5.l
            if (r6 != 0) goto L_0x0076
            int r6 = r5.h
            if (r6 <= 0) goto L_0x0076
            android.view.View r7 = r5.c
            java.lang.Runnable r0 = r5.d
            long r3 = (long) r6
            androidx.core.view.ViewCompat.postOnAnimationDelayed(r7, r0, r3)
            goto L_0x007b
        L_0x0076:
            java.lang.Runnable r6 = r5.d
            r6.run()
        L_0x007b:
            r5.l = r2
        L_0x007d:
            boolean r6 = r5.q
            if (r6 == 0) goto L_0x0086
            boolean r6 = r5.o
            if (r6 == 0) goto L_0x0086
            r1 = 1
        L_0x0086:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.AutoScrollHelper.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public abstract void scrollTargetBy(int i2, int i3);

    @NonNull
    public AutoScrollHelper setActivationDelay(int i2) {
        this.h = i2;
        return this;
    }

    @NonNull
    public AutoScrollHelper setEdgeType(int i2) {
        this.g = i2;
        return this;
    }

    public AutoScrollHelper setEnabled(boolean z) {
        if (this.p && !z) {
            d();
        }
        this.p = z;
        return this;
    }

    public AutoScrollHelper setExclusive(boolean z) {
        this.q = z;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMaximumEdges(float f2, float f3) {
        float[] fArr = this.f;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMaximumVelocity(float f2, float f3) {
        float[] fArr = this.k;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMinimumVelocity(float f2, float f3) {
        float[] fArr = this.j;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    @NonNull
    public AutoScrollHelper setRampDownDuration(int i2) {
        this.a.b = i2;
        return this;
    }

    @NonNull
    public AutoScrollHelper setRampUpDuration(int i2) {
        this.a.a = i2;
        return this;
    }

    @NonNull
    public AutoScrollHelper setRelativeEdges(float f2, float f3) {
        float[] fArr = this.e;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    @NonNull
    public AutoScrollHelper setRelativeVelocity(float f2, float f3) {
        float[] fArr = this.i;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }
}
