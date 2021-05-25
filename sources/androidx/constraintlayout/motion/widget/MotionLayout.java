package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.motion.utils.VelocityMatrix;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Flow;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import com.google.android.gms.ads.AdError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    public static boolean IS_IN_EDIT_MODE = false;
    public static final int TOUCH_UP_COMPLETE = 0;
    public static final int TOUCH_UP_COMPLETE_TO_END = 2;
    public static final int TOUCH_UP_COMPLETE_TO_START = 1;
    public static final int TOUCH_UP_DECELERATE = 4;
    public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int TOUCH_UP_STOP = 3;
    public static final int VELOCITY_LAYOUT = 1;
    public static final int VELOCITY_POST_LAYOUT = 0;
    public static final int VELOCITY_STATIC_LAYOUT = 3;
    public static final int VELOCITY_STATIC_POST_LAYOUT = 2;
    public long A = 0;
    public float B = 1.0f;
    public float C = 0.0f;
    public float D = 0.0f;
    public long E;
    public float F = 0.0f;
    public boolean G;
    public boolean H = false;
    public TransitionListener I;
    public float J;
    public float K;
    public int L = 0;
    public c M;
    public boolean N = false;
    public StopLogic O = new StopLogic();
    public b P = new b();
    public DesignTool Q;
    public int R;
    public int S;
    public boolean T = false;
    public float U;
    public float V;
    public long W;
    public float a0;
    public boolean b0 = false;
    public ArrayList<MotionHelper> c0 = null;
    public ArrayList<MotionHelper> d0 = null;
    public ArrayList<TransitionListener> e0 = null;
    public int f0 = 0;
    public long g0 = -1;
    public float h0 = 0.0f;
    public int i0 = 0;
    public float j0 = 0.0f;
    public int k0;
    public int l0;
    public int m0;
    public boolean mMeasureDuringTransition = false;
    public int n0;
    public int o0;
    public int p0;
    public MotionScene q;
    public float q0;
    public Interpolator r;
    public KeyCache r0 = new KeyCache();
    public float s = 0.0f;
    public boolean s0 = false;
    public int t = -1;
    public f t0;
    public int u = -1;
    public g u0 = g.UNDEFINED;
    public int v = -1;
    public d v0 = new d();
    public int w = 0;
    public boolean w0 = false;
    public int x = 0;
    public RectF x0 = new RectF();
    public boolean y = true;
    public View y0 = null;
    public HashMap<View, MotionController> z = new HashMap<>();
    public ArrayList<Integer> z0 = new ArrayList<>();

    public interface MotionTracker {
        void addMovement(MotionEvent motionEvent);

        void clear();

        void computeCurrentVelocity(int i);

        void computeCurrentVelocity(int i, float f);

        float getXVelocity();

        float getXVelocity(int i);

        float getYVelocity();

        float getYVelocity(int i);

        void recycle();
    }

    public interface TransitionListener {
        void onTransitionChange(MotionLayout motionLayout, int i, int i2, float f);

        void onTransitionCompleted(MotionLayout motionLayout, int i);

        void onTransitionStarted(MotionLayout motionLayout, int i, int i2);

        void onTransitionTrigger(MotionLayout motionLayout, int i, boolean z, float f);
    }

    public class a implements Runnable {
        public final /* synthetic */ View a;

        public a(MotionLayout motionLayout, View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.setNestedScrollingEnabled(true);
        }
    }

    public class b extends MotionInterpolator {
        public float a = 0.0f;
        public float b = 0.0f;
        public float c;

        public b() {
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.a;
            if (f2 > 0.0f) {
                float f3 = this.c;
                if (f2 / f3 < f) {
                    f = f2 / f3;
                }
                MotionLayout.this.s = f2 - (f3 * f);
                return ((f2 * f) - (((f3 * f) * f) / 2.0f)) + this.b;
            }
            float f4 = this.c;
            if ((-f2) / f4 < f) {
                f = (-f2) / f4;
            }
            MotionLayout.this.s = (f4 * f) + f2;
            return (((f4 * f) * f) / 2.0f) + (f2 * f) + this.b;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
        public float getVelocity() {
            return MotionLayout.this.s;
        }
    }

    public class c {
        public float[] a;
        public int[] b;
        public float[] c;
        public Path d;
        public Paint e;
        public Paint f;
        public Paint g;
        public Paint h;
        public Paint i;
        public float[] j;
        public DashPathEffect k;
        public int l;
        public Rect m = new Rect();
        public int n = 1;

        public c() {
            Paint paint = new Paint();
            this.e = paint;
            paint.setAntiAlias(true);
            this.e.setColor(-21965);
            this.e.setStrokeWidth(2.0f);
            this.e.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.f = paint2;
            paint2.setAntiAlias(true);
            this.f.setColor(-2067046);
            this.f.setStrokeWidth(2.0f);
            this.f.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint();
            this.g = paint3;
            paint3.setAntiAlias(true);
            this.g.setColor(-13391360);
            this.g.setStrokeWidth(2.0f);
            this.g.setStyle(Paint.Style.STROKE);
            Paint paint4 = new Paint();
            this.h = paint4;
            paint4.setAntiAlias(true);
            this.h.setColor(-13391360);
            this.h.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.j = new float[8];
            Paint paint5 = new Paint();
            this.i = paint5;
            paint5.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.k = dashPathEffect;
            this.g.setPathEffect(dashPathEffect);
            this.c = new float[100];
            this.b = new int[50];
        }

        public void a(Canvas canvas, int i2, int i3, MotionController motionController) {
            int i4;
            int i5;
            int i6;
            float f2;
            float f3;
            if (i2 == 4) {
                boolean z = false;
                boolean z2 = false;
                for (int i7 = 0; i7 < this.l; i7++) {
                    int[] iArr = this.b;
                    if (iArr[i7] == 1) {
                        z = true;
                    }
                    if (iArr[i7] == 2) {
                        z2 = true;
                    }
                }
                if (z) {
                    d(canvas);
                }
                if (z2) {
                    b(canvas);
                }
            }
            if (i2 == 2) {
                d(canvas);
            }
            if (i2 == 3) {
                b(canvas);
            }
            canvas.drawLines(this.a, this.e);
            View view = motionController.a;
            if (view != null) {
                i5 = view.getWidth();
                i4 = motionController.a.getHeight();
            } else {
                i5 = 0;
                i4 = 0;
            }
            int i8 = 1;
            while (i8 < i3 - 1) {
                if (i2 == 4 && this.b[i8 - 1] == 0) {
                    i6 = i8;
                } else {
                    float[] fArr = this.c;
                    int i9 = i8 * 2;
                    float f4 = fArr[i9];
                    float f5 = fArr[i9 + 1];
                    this.d.reset();
                    this.d.moveTo(f4, f5 + 10.0f);
                    this.d.lineTo(f4 + 10.0f, f5);
                    this.d.lineTo(f4, f5 - 10.0f);
                    this.d.lineTo(f4 - 10.0f, f5);
                    this.d.close();
                    int i10 = i8 - 1;
                    motionController.t.get(i10);
                    if (i2 == 4) {
                        int[] iArr2 = this.b;
                        if (iArr2[i10] == 1) {
                            e(canvas, f4 - 0.0f, f5 - 0.0f);
                        } else if (iArr2[i10] == 2) {
                            c(canvas, f4 - 0.0f, f5 - 0.0f);
                        } else if (iArr2[i10] == 3) {
                            f2 = f5;
                            f3 = f4;
                            i6 = i8;
                            f(canvas, f4 - 0.0f, f5 - 0.0f, i5, i4);
                            canvas.drawPath(this.d, this.i);
                        }
                        f2 = f5;
                        f3 = f4;
                        i6 = i8;
                        canvas.drawPath(this.d, this.i);
                    } else {
                        f2 = f5;
                        f3 = f4;
                        i6 = i8;
                    }
                    if (i2 == 2) {
                        e(canvas, f3 - 0.0f, f2 - 0.0f);
                    }
                    if (i2 == 3) {
                        c(canvas, f3 - 0.0f, f2 - 0.0f);
                    }
                    if (i2 == 6) {
                        f(canvas, f3 - 0.0f, f2 - 0.0f, i5, i4);
                    }
                    canvas.drawPath(this.d, this.i);
                }
                i8 = i6 + 1;
            }
            float[] fArr2 = this.a;
            if (fArr2.length > 1) {
                canvas.drawCircle(fArr2[0], fArr2[1], 8.0f, this.f);
                float[] fArr3 = this.a;
                canvas.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.f);
            }
        }

        public final void b(Canvas canvas) {
            float[] fArr = this.a;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[fArr.length - 2];
            float f5 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f2, f4), Math.max(f3, f5), Math.max(f2, f4), Math.max(f3, f5), this.g);
            canvas.drawLine(Math.min(f2, f4), Math.min(f3, f5), Math.min(f2, f4), Math.max(f3, f5), this.g);
        }

        public final void c(Canvas canvas, float f2, float f3) {
            float[] fArr = this.a;
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[fArr.length - 2];
            float f7 = fArr[fArr.length - 1];
            float min = Math.min(f4, f6);
            float max = Math.max(f5, f7);
            float min2 = f2 - Math.min(f4, f6);
            float max2 = Math.max(f5, f7) - f3;
            StringBuilder L = a2.b.a.a.a.L("");
            L.append(((float) ((int) (((double) ((min2 * 100.0f) / Math.abs(f6 - f4))) + 0.5d))) / 100.0f);
            String sb = L.toString();
            g(sb, this.h);
            canvas.drawText(sb, ((min2 / 2.0f) - ((float) (this.m.width() / 2))) + min, f3 - 20.0f, this.h);
            canvas.drawLine(f2, f3, Math.min(f4, f6), f3, this.g);
            StringBuilder L2 = a2.b.a.a.a.L("");
            L2.append(((float) ((int) (((double) ((max2 * 100.0f) / Math.abs(f7 - f5))) + 0.5d))) / 100.0f);
            String sb2 = L2.toString();
            g(sb2, this.h);
            canvas.drawText(sb2, f2 + 5.0f, max - ((max2 / 2.0f) - ((float) (this.m.height() / 2))), this.h);
            canvas.drawLine(f2, f3, f2, Math.max(f5, f7), this.g);
        }

        public final void d(Canvas canvas) {
            float[] fArr = this.a;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.g);
        }

        public final void e(Canvas canvas, float f2, float f3) {
            float[] fArr = this.a;
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[fArr.length - 2];
            float f7 = fArr[fArr.length - 1];
            float hypot = (float) Math.hypot((double) (f4 - f6), (double) (f5 - f7));
            float f8 = f6 - f4;
            float f9 = f7 - f5;
            float f10 = (((f3 - f5) * f9) + ((f2 - f4) * f8)) / (hypot * hypot);
            float f11 = f4 + (f8 * f10);
            float f12 = f5 + (f10 * f9);
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f11, f12);
            float hypot2 = (float) Math.hypot((double) (f11 - f2), (double) (f12 - f3));
            StringBuilder L = a2.b.a.a.a.L("");
            L.append(((float) ((int) ((hypot2 * 100.0f) / hypot))) / 100.0f);
            String sb = L.toString();
            g(sb, this.h);
            canvas.drawTextOnPath(sb, path, (hypot2 / 2.0f) - ((float) (this.m.width() / 2)), -20.0f, this.h);
            canvas.drawLine(f2, f3, f11, f12, this.g);
        }

        public final void f(Canvas canvas, float f2, float f3, int i2, int i3) {
            StringBuilder L = a2.b.a.a.a.L("");
            L.append(((float) ((int) (((double) (((f2 - ((float) (i2 / 2))) * 100.0f) / ((float) (MotionLayout.this.getWidth() - i2)))) + 0.5d))) / 100.0f);
            String sb = L.toString();
            g(sb, this.h);
            canvas.drawText(sb, ((f2 / 2.0f) - ((float) (this.m.width() / 2))) + 0.0f, f3 - 20.0f, this.h);
            canvas.drawLine(f2, f3, Math.min(0.0f, 1.0f), f3, this.g);
            StringBuilder L2 = a2.b.a.a.a.L("");
            L2.append(((float) ((int) (((double) (((f3 - ((float) (i3 / 2))) * 100.0f) / ((float) (MotionLayout.this.getHeight() - i3)))) + 0.5d))) / 100.0f);
            String sb2 = L2.toString();
            g(sb2, this.h);
            canvas.drawText(sb2, f2 + 5.0f, 0.0f - ((f3 / 2.0f) - ((float) (this.m.height() / 2))), this.h);
            canvas.drawLine(f2, f3, f2, Math.max(0.0f, 1.0f), this.g);
        }

        public void g(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.m);
        }
    }

    public class d {
        public ConstraintWidgetContainer a = new ConstraintWidgetContainer();
        public ConstraintWidgetContainer b = new ConstraintWidgetContainer();
        public ConstraintSet c = null;
        public ConstraintSet d = null;
        public int e;
        public int f;

        public d() {
        }

        public void a() {
            int childCount = MotionLayout.this.getChildCount();
            MotionLayout.this.z.clear();
            for (int i = 0; i < childCount; i++) {
                View childAt = MotionLayout.this.getChildAt(i);
                MotionLayout.this.z.put(childAt, new MotionController(childAt));
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt2 = MotionLayout.this.getChildAt(i2);
                MotionController motionController = MotionLayout.this.z.get(childAt2);
                if (motionController != null) {
                    if (this.c != null) {
                        ConstraintWidget c2 = c(this.a, childAt2);
                        if (c2 != null) {
                            ConstraintSet constraintSet = this.c;
                            l6.g.a.b.c cVar = motionController.d;
                            cVar.c = 0.0f;
                            cVar.d = 0.0f;
                            motionController.g(cVar);
                            motionController.d.e((float) c2.getX(), (float) c2.getY(), (float) c2.getWidth(), (float) c2.getHeight());
                            ConstraintSet.Constraint parameters = constraintSet.getParameters(motionController.b);
                            motionController.d.a(parameters);
                            motionController.j = parameters.motion.mMotionStagger;
                            motionController.f.c(c2, constraintSet, motionController.b);
                        } else if (MotionLayout.this.L != 0) {
                            Debug.getLocation();
                            Debug.getName(childAt2);
                            childAt2.getClass().getName();
                        }
                    }
                    if (this.d != null) {
                        ConstraintWidget c3 = c(this.b, childAt2);
                        if (c3 != null) {
                            ConstraintSet constraintSet2 = this.d;
                            l6.g.a.b.c cVar2 = motionController.e;
                            cVar2.c = 1.0f;
                            cVar2.d = 1.0f;
                            motionController.g(cVar2);
                            motionController.e.e((float) c3.getX(), (float) c3.getY(), (float) c3.getWidth(), (float) c3.getHeight());
                            motionController.e.a(constraintSet2.getParameters(motionController.b));
                            motionController.g.c(c3, constraintSet2, motionController.b);
                        } else if (MotionLayout.this.L != 0) {
                            Debug.getLocation();
                            Debug.getName(childAt2);
                            childAt2.getClass().getName();
                        }
                    }
                }
            }
        }

        public void b(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidgetContainer constraintWidgetContainer2) {
            ConstraintWidget constraintWidget;
            ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
            HashMap<ConstraintWidget, ConstraintWidget> hashMap = new HashMap<>();
            hashMap.put(constraintWidgetContainer, constraintWidgetContainer2);
            constraintWidgetContainer2.getChildren().clear();
            constraintWidgetContainer2.copy(constraintWidgetContainer, hashMap);
            Iterator<ConstraintWidget> it = children.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                if (next instanceof Barrier) {
                    constraintWidget = new Barrier();
                } else if (next instanceof Guideline) {
                    constraintWidget = new Guideline();
                } else if (next instanceof Flow) {
                    constraintWidget = new Flow();
                } else if (next instanceof Helper) {
                    constraintWidget = new HelperWidget();
                } else {
                    constraintWidget = new ConstraintWidget();
                }
                constraintWidgetContainer2.add(constraintWidget);
                hashMap.put(next, constraintWidget);
            }
            Iterator<ConstraintWidget> it2 = children.iterator();
            while (it2.hasNext()) {
                ConstraintWidget next2 = it2.next();
                hashMap.get(next2).copy(next2, hashMap);
            }
        }

        public ConstraintWidget c(ConstraintWidgetContainer constraintWidgetContainer, View view) {
            if (constraintWidgetContainer.getCompanionWidget() == view) {
                return constraintWidgetContainer;
            }
            ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
            int size = children.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = children.get(i);
                if (constraintWidget.getCompanionWidget() == view) {
                    return constraintWidget;
                }
            }
            return null;
        }

        public void d(ConstraintSet constraintSet, ConstraintSet constraintSet2) {
            this.c = constraintSet;
            this.d = constraintSet2;
            this.a = new ConstraintWidgetContainer();
            this.b = new ConstraintWidgetContainer();
            ConstraintWidgetContainer constraintWidgetContainer = this.a;
            MotionLayout motionLayout = MotionLayout.this;
            int i = MotionLayout.TOUCH_UP_COMPLETE;
            constraintWidgetContainer.setMeasurer(motionLayout.mLayoutWidget.getMeasurer());
            this.b.setMeasurer(MotionLayout.this.mLayoutWidget.getMeasurer());
            this.a.removeAllChildren();
            this.b.removeAllChildren();
            b(MotionLayout.this.mLayoutWidget, this.a);
            b(MotionLayout.this.mLayoutWidget, this.b);
            if (((double) MotionLayout.this.D) > 0.5d) {
                if (constraintSet != null) {
                    f(this.a, constraintSet);
                }
                f(this.b, constraintSet2);
            } else {
                f(this.b, constraintSet2);
                if (constraintSet != null) {
                    f(this.a, constraintSet);
                }
            }
            this.a.setRtl(MotionLayout.this.isRtl());
            this.a.updateHierarchy();
            this.b.setRtl(MotionLayout.this.isRtl());
            this.b.updateHierarchy();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    constraintWidgetContainer2.setHorizontalDimensionBehaviour(dimensionBehaviour);
                    this.b.setHorizontalDimensionBehaviour(dimensionBehaviour);
                }
                if (layoutParams.height == -2) {
                    ConstraintWidgetContainer constraintWidgetContainer3 = this.a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    constraintWidgetContainer3.setVerticalDimensionBehaviour(dimensionBehaviour2);
                    this.b.setVerticalDimensionBehaviour(dimensionBehaviour2);
                }
            }
        }

        public void e() {
            int i;
            MotionLayout motionLayout = MotionLayout.this;
            int i2 = motionLayout.w;
            int i3 = motionLayout.x;
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            MotionLayout motionLayout2 = MotionLayout.this;
            motionLayout2.o0 = mode;
            motionLayout2.p0 = mode2;
            int optimizationLevel = motionLayout2.getOptimizationLevel();
            MotionLayout motionLayout3 = MotionLayout.this;
            if (motionLayout3.u == motionLayout3.getStartState()) {
                MotionLayout.this.resolveSystem(this.b, optimizationLevel, i2, i3);
                if (this.c != null) {
                    MotionLayout.this.resolveSystem(this.a, optimizationLevel, i2, i3);
                }
            } else {
                if (this.c != null) {
                    MotionLayout.this.resolveSystem(this.a, optimizationLevel, i2, i3);
                }
                MotionLayout.this.resolveSystem(this.b, optimizationLevel, i2, i3);
            }
            int i4 = 0;
            boolean z = true;
            if (((MotionLayout.this.getParent() instanceof MotionLayout) && mode == 1073741824 && mode2 == 1073741824) ? false : true) {
                MotionLayout motionLayout4 = MotionLayout.this;
                motionLayout4.o0 = mode;
                motionLayout4.p0 = mode2;
                if (motionLayout4.u == motionLayout4.getStartState()) {
                    MotionLayout.this.resolveSystem(this.b, optimizationLevel, i2, i3);
                    if (this.c != null) {
                        MotionLayout.this.resolveSystem(this.a, optimizationLevel, i2, i3);
                    }
                } else {
                    if (this.c != null) {
                        MotionLayout.this.resolveSystem(this.a, optimizationLevel, i2, i3);
                    }
                    MotionLayout.this.resolveSystem(this.b, optimizationLevel, i2, i3);
                }
                MotionLayout.this.k0 = this.a.getWidth();
                MotionLayout.this.l0 = this.a.getHeight();
                MotionLayout.this.m0 = this.b.getWidth();
                MotionLayout.this.n0 = this.b.getHeight();
                MotionLayout motionLayout5 = MotionLayout.this;
                motionLayout5.mMeasureDuringTransition = (motionLayout5.k0 == motionLayout5.m0 && motionLayout5.l0 == motionLayout5.n0) ? false : true;
            }
            MotionLayout motionLayout6 = MotionLayout.this;
            int i5 = motionLayout6.k0;
            int i6 = motionLayout6.l0;
            int i7 = motionLayout6.o0;
            if (i7 == Integer.MIN_VALUE || i7 == 0) {
                i5 = (int) ((motionLayout6.q0 * ((float) (motionLayout6.m0 - i5))) + ((float) i5));
            }
            int i8 = motionLayout6.p0;
            if (i8 == Integer.MIN_VALUE || i8 == 0) {
                i = (int) ((motionLayout6.q0 * ((float) (motionLayout6.n0 - i6))) + ((float) i6));
            } else {
                i = i6;
            }
            MotionLayout.this.resolveMeasuredDimension(i2, i3, i5, i, this.a.isWidthMeasuredTooSmall() || this.b.isWidthMeasuredTooSmall(), this.a.isHeightMeasuredTooSmall() || this.b.isHeightMeasuredTooSmall());
            MotionLayout motionLayout7 = MotionLayout.this;
            int childCount = motionLayout7.getChildCount();
            motionLayout7.v0.a();
            motionLayout7.H = true;
            int width = motionLayout7.getWidth();
            int height = motionLayout7.getHeight();
            int gatPathMotionArc = motionLayout7.q.gatPathMotionArc();
            if (gatPathMotionArc != -1) {
                for (int i9 = 0; i9 < childCount; i9++) {
                    MotionController motionController = motionLayout7.z.get(motionLayout7.getChildAt(i9));
                    if (motionController != null) {
                        motionController.setPathMotionArc(gatPathMotionArc);
                    }
                }
            }
            for (int i10 = 0; i10 < childCount; i10++) {
                MotionController motionController2 = motionLayout7.z.get(motionLayout7.getChildAt(i10));
                if (motionController2 != null) {
                    motionLayout7.q.getKeyFrames(motionController2);
                    motionController2.setup(width, height, motionLayout7.B, motionLayout7.getNanoTime());
                }
            }
            float staggered = motionLayout7.q.getStaggered();
            if (staggered != 0.0f) {
                boolean z2 = ((double) staggered) < 0.0d;
                float abs = Math.abs(staggered);
                float f2 = -3.4028235E38f;
                float f3 = Float.MAX_VALUE;
                int i11 = 0;
                float f4 = Float.MAX_VALUE;
                float f5 = -3.4028235E38f;
                while (true) {
                    if (i11 >= childCount) {
                        z = false;
                        break;
                    }
                    MotionController motionController3 = motionLayout7.z.get(motionLayout7.getChildAt(i11));
                    if (!Float.isNaN(motionController3.j)) {
                        break;
                    }
                    l6.g.a.b.c cVar = motionController3.e;
                    float f6 = cVar.e;
                    float f7 = cVar.f;
                    float f8 = z2 ? f7 - f6 : f7 + f6;
                    f4 = Math.min(f4, f8);
                    f5 = Math.max(f5, f8);
                    i11++;
                }
                if (z) {
                    for (int i12 = 0; i12 < childCount; i12++) {
                        MotionController motionController4 = motionLayout7.z.get(motionLayout7.getChildAt(i12));
                        if (!Float.isNaN(motionController4.j)) {
                            f3 = Math.min(f3, motionController4.j);
                            f2 = Math.max(f2, motionController4.j);
                        }
                    }
                    while (i4 < childCount) {
                        MotionController motionController5 = motionLayout7.z.get(motionLayout7.getChildAt(i4));
                        if (!Float.isNaN(motionController5.j)) {
                            motionController5.l = 1.0f / (1.0f - abs);
                            if (z2) {
                                motionController5.k = abs - (((f2 - motionController5.j) / (f2 - f3)) * abs);
                            } else {
                                motionController5.k = abs - (((motionController5.j - f3) * abs) / (f2 - f3));
                            }
                        }
                        i4++;
                    }
                    return;
                }
                while (i4 < childCount) {
                    MotionController motionController6 = motionLayout7.z.get(motionLayout7.getChildAt(i4));
                    l6.g.a.b.c cVar2 = motionController6.e;
                    float f9 = cVar2.e;
                    float f10 = cVar2.f;
                    float f11 = z2 ? f10 - f9 : f10 + f9;
                    motionController6.l = 1.0f / (1.0f - abs);
                    motionController6.k = abs - (((f11 - f4) * abs) / (f5 - f4));
                    i4++;
                }
            }
        }

        public final void f(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet) {
            SparseArray<ConstraintWidget> sparseArray = new SparseArray<>();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, constraintWidgetContainer);
            sparseArray.put(MotionLayout.this.getId(), constraintWidgetContainer);
            Iterator<ConstraintWidget> it = constraintWidgetContainer.getChildren().iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                sparseArray.put(((View) next.getCompanionWidget()).getId(), next);
            }
            Iterator<ConstraintWidget> it2 = constraintWidgetContainer.getChildren().iterator();
            while (it2.hasNext()) {
                ConstraintWidget next2 = it2.next();
                View view = (View) next2.getCompanionWidget();
                constraintSet.applyToLayoutParams(view.getId(), layoutParams);
                next2.setWidth(constraintSet.getWidth(view.getId()));
                next2.setHeight(constraintSet.getHeight(view.getId()));
                if (view instanceof ConstraintHelper) {
                    constraintSet.applyToHelper((ConstraintHelper) view, next2, layoutParams, sparseArray);
                    if (view instanceof androidx.constraintlayout.widget.Barrier) {
                        ((androidx.constraintlayout.widget.Barrier) view).validateParams();
                    }
                }
                layoutParams.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                MotionLayout motionLayout = MotionLayout.this;
                int i = MotionLayout.TOUCH_UP_COMPLETE;
                motionLayout.applyConstraintsFromLayoutParams(false, view, next2, layoutParams, sparseArray);
                if (constraintSet.getVisibilityMode(view.getId()) == 1) {
                    next2.setVisibility(view.getVisibility());
                } else {
                    next2.setVisibility(constraintSet.getVisibility(view.getId()));
                }
            }
            Iterator<ConstraintWidget> it3 = constraintWidgetContainer.getChildren().iterator();
            while (it3.hasNext()) {
                ConstraintWidget next3 = it3.next();
                if (next3 instanceof VirtualLayout) {
                    Helper helper = (Helper) next3;
                    ((ConstraintHelper) next3.getCompanionWidget()).updatePreLayout(constraintWidgetContainer, helper, sparseArray);
                    ((VirtualLayout) helper).captureWidgets();
                }
            }
        }
    }

    public class f {
        public float a = Float.NaN;
        public float b = Float.NaN;
        public int c = -1;
        public int d = -1;

        public f() {
        }

        public void a() {
            int i = this.c;
            if (!(i == -1 && this.d == -1)) {
                if (i == -1) {
                    MotionLayout.this.transitionToState(this.d);
                } else {
                    int i2 = this.d;
                    if (i2 == -1) {
                        MotionLayout.this.setState(i, -1, -1);
                    } else {
                        MotionLayout.this.setTransition(i, i2);
                    }
                }
                MotionLayout.this.setState(g.SETUP);
            }
            if (!Float.isNaN(this.b)) {
                MotionLayout.this.setProgress(this.a, this.b);
                this.a = Float.NaN;
                this.b = Float.NaN;
                this.c = -1;
                this.d = -1;
            } else if (!Float.isNaN(this.a)) {
                MotionLayout.this.setProgress(this.a);
            }
        }
    }

    public enum g {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public MotionLayout(@NonNull Context context) {
        super(context);
        h(null);
    }

    public void addTransitionListener(TransitionListener transitionListener) {
        if (this.e0 == null) {
            this.e0 = new ArrayList<>();
        }
        this.e0.add(transitionListener);
    }

    public void b(float f2) {
        MotionScene motionScene = this.q;
        if (motionScene != null) {
            float f3 = this.D;
            float f4 = this.C;
            if (f3 != f4 && this.G) {
                this.D = f4;
            }
            float f5 = this.D;
            if (f5 != f2) {
                this.N = false;
                this.F = f2;
                this.B = ((float) motionScene.getDuration()) / 1000.0f;
                setProgress(this.F);
                this.r = this.q.getInterpolator();
                this.G = false;
                this.A = getNanoTime();
                this.H = true;
                this.C = f5;
                this.D = f5;
                invalidate();
            }
        }
    }

    public void c(boolean z2) {
        float f2;
        boolean z3;
        int i;
        int i2;
        float f3;
        g gVar = g.FINISHED;
        if (this.E == -1) {
            this.E = getNanoTime();
        }
        float f4 = this.D;
        if (f4 > 0.0f && f4 < 1.0f) {
            this.u = -1;
        }
        boolean z4 = true;
        boolean z5 = false;
        if (this.b0 || (this.H && (z2 || this.F != f4))) {
            float signum = Math.signum(this.F - f4);
            long nanoTime = getNanoTime();
            Interpolator interpolator = this.r;
            if (!(interpolator instanceof MotionInterpolator)) {
                f2 = ((((float) (nanoTime - this.E)) * signum) * 1.0E-9f) / this.B;
                this.s = f2;
            } else {
                f2 = 0.0f;
            }
            float f5 = this.D + f2;
            if (this.G) {
                f5 = this.F;
            }
            int i3 = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
            if ((i3 <= 0 || f5 < this.F) && (signum > 0.0f || f5 > this.F)) {
                z3 = false;
            } else {
                f5 = this.F;
                this.H = false;
                z3 = true;
            }
            this.D = f5;
            this.C = f5;
            this.E = nanoTime;
            if (interpolator != null && !z3) {
                if (this.N) {
                    f3 = interpolator.getInterpolation(((float) (nanoTime - this.A)) * 1.0E-9f);
                    this.D = f3;
                    this.E = nanoTime;
                    Interpolator interpolator2 = this.r;
                    if (interpolator2 instanceof MotionInterpolator) {
                        float velocity = ((MotionInterpolator) interpolator2).getVelocity();
                        this.s = velocity;
                        if (Math.abs(velocity) * this.B <= 1.0E-5f) {
                            this.H = false;
                        }
                        if (velocity > 0.0f && f3 >= 1.0f) {
                            this.D = 1.0f;
                            this.H = false;
                            f3 = 1.0f;
                        }
                        if (velocity < 0.0f && f3 <= 0.0f) {
                            this.D = 0.0f;
                            this.H = false;
                            f5 = 0.0f;
                        }
                    }
                } else {
                    f3 = interpolator.getInterpolation(f5);
                    Interpolator interpolator3 = this.r;
                    if (interpolator3 instanceof MotionInterpolator) {
                        this.s = ((MotionInterpolator) interpolator3).getVelocity();
                    } else {
                        this.s = ((interpolator3.getInterpolation(f5 + f2) - f3) * signum) / f2;
                    }
                }
                f5 = f3;
            }
            if (Math.abs(this.s) > 1.0E-5f) {
                setState(g.MOVING);
            }
            if ((i3 > 0 && f5 >= this.F) || (signum <= 0.0f && f5 <= this.F)) {
                f5 = this.F;
                this.H = false;
            }
            int i4 = (f5 > 1.0f ? 1 : (f5 == 1.0f ? 0 : -1));
            if (i4 >= 0 || f5 <= 0.0f) {
                this.H = false;
                setState(gVar);
            }
            int childCount = getChildCount();
            this.b0 = false;
            long nanoTime2 = getNanoTime();
            this.q0 = f5;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                MotionController motionController = this.z.get(childAt);
                if (motionController != null) {
                    this.b0 = motionController.f(childAt, f5, nanoTime2, this.r0) | this.b0;
                }
            }
            boolean z7 = (i3 > 0 && f5 >= this.F) || (signum <= 0.0f && f5 <= this.F);
            if (!this.b0 && !this.H && z7) {
                setState(gVar);
            }
            if (this.mMeasureDuringTransition) {
                requestLayout();
            }
            this.b0 = (!z7) | this.b0;
            if (f5 > 0.0f || (i2 = this.t) == -1 || this.u == i2) {
                z5 = false;
            } else {
                this.u = i2;
                this.q.b(i2).applyCustomAttributes(this);
                setState(gVar);
                z5 = true;
            }
            if (((double) f5) >= 1.0d && this.u != (i = this.v)) {
                this.u = i;
                this.q.b(i).applyCustomAttributes(this);
                setState(gVar);
                z5 = true;
            }
            if (this.b0 || this.H) {
                invalidate();
            } else if ((i3 > 0 && i4 == 0) || (signum < 0.0f && f5 == 0.0f)) {
                setState(gVar);
            }
            if ((!this.b0 && this.H && i3 > 0 && i4 == 0) || (signum < 0.0f && f5 == 0.0f)) {
                i();
            }
        }
        float f6 = this.D;
        if (f6 >= 1.0f) {
            int i6 = this.u;
            int i7 = this.v;
            if (i6 == i7) {
                z4 = z5;
            }
            this.u = i7;
        } else {
            if (f6 <= 0.0f) {
                int i8 = this.u;
                int i9 = this.t;
                if (i8 == i9) {
                    z4 = z5;
                }
                this.u = i9;
            }
            this.w0 |= z5;
            if (z5 && !this.s0) {
                requestLayout();
            }
            this.C = this.D;
        }
        z5 = z4;
        this.w0 |= z5;
        requestLayout();
        this.C = this.D;
    }

    public final void d() {
        ArrayList<TransitionListener> arrayList;
        if ((this.I != null || ((arrayList = this.e0) != null && !arrayList.isEmpty())) && this.j0 != this.C) {
            if (this.i0 != -1) {
                TransitionListener transitionListener = this.I;
                if (transitionListener != null) {
                    transitionListener.onTransitionStarted(this, this.t, this.v);
                }
                ArrayList<TransitionListener> arrayList2 = this.e0;
                if (arrayList2 != null) {
                    Iterator<TransitionListener> it = arrayList2.iterator();
                    while (it.hasNext()) {
                        it.next().onTransitionStarted(this, this.t, this.v);
                    }
                }
            }
            this.i0 = -1;
            float f2 = this.C;
            this.j0 = f2;
            TransitionListener transitionListener2 = this.I;
            if (transitionListener2 != null) {
                transitionListener2.onTransitionChange(this, this.t, this.v, f2);
            }
            ArrayList<TransitionListener> arrayList3 = this.e0;
            if (arrayList3 != null) {
                Iterator<TransitionListener> it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    it2.next().onTransitionChange(this, this.t, this.v, this.C);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        String str;
        c(false);
        super.dispatchDraw(canvas);
        if (this.q != null) {
            if ((this.L & 1) == 1 && !isInEditMode()) {
                this.f0++;
                long nanoTime = getNanoTime();
                long j = this.g0;
                if (j != -1) {
                    long j2 = nanoTime - j;
                    if (j2 > 200000000) {
                        this.h0 = ((float) ((int) ((((float) this.f0) / (((float) j2) * 1.0E-9f)) * 100.0f))) / 100.0f;
                        this.f0 = 0;
                        this.g0 = nanoTime;
                    }
                } else {
                    this.g0 = nanoTime;
                }
                Paint paint = new Paint();
                paint.setTextSize(42.0f);
                StringBuilder L2 = a2.b.a.a.a.L(this.h0 + " fps " + Debug.getState(this, this.t) + " -> ");
                L2.append(Debug.getState(this, this.v));
                L2.append(" (progress: ");
                L2.append(((float) ((int) (getProgress() * 1000.0f))) / 10.0f);
                L2.append(" ) state=");
                int i = this.u;
                if (i == -1) {
                    str = AdError.UNDEFINED_DOMAIN;
                } else {
                    str = Debug.getState(this, i);
                }
                L2.append(str);
                String sb = L2.toString();
                paint.setColor(ViewCompat.MEASURED_STATE_MASK);
                canvas.drawText(sb, 11.0f, (float) (getHeight() - 29), paint);
                paint.setColor(-7864184);
                canvas.drawText(sb, 10.0f, (float) (getHeight() - 30), paint);
            }
            if (this.L > 1) {
                if (this.M == null) {
                    this.M = new c();
                }
                c cVar = this.M;
                HashMap<View, MotionController> hashMap = this.z;
                int duration = this.q.getDuration();
                int i2 = this.L;
                Objects.requireNonNull(cVar);
                if (!(hashMap == null || hashMap.size() == 0)) {
                    canvas.save();
                    if (!MotionLayout.this.isInEditMode() && (i2 & 1) == 2) {
                        String str2 = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.v) + ":" + MotionLayout.this.getProgress();
                        canvas.drawText(str2, 10.0f, (float) (MotionLayout.this.getHeight() - 30), cVar.h);
                        canvas.drawText(str2, 11.0f, (float) (MotionLayout.this.getHeight() - 29), cVar.e);
                    }
                    for (MotionController motionController : hashMap.values()) {
                        int drawPath = motionController.getDrawPath();
                        if (i2 > 0 && drawPath == 0) {
                            drawPath = 1;
                        }
                        if (drawPath != 0) {
                            cVar.l = motionController.a(cVar.c, cVar.b);
                            if (drawPath >= 1) {
                                int i3 = duration / 16;
                                float[] fArr = cVar.a;
                                if (fArr == null || fArr.length != i3 * 2) {
                                    cVar.a = new float[(i3 * 2)];
                                    cVar.d = new Path();
                                }
                                float f2 = (float) cVar.n;
                                canvas.translate(f2, f2);
                                cVar.e.setColor(1996488704);
                                cVar.i.setColor(1996488704);
                                cVar.f.setColor(1996488704);
                                cVar.g.setColor(1996488704);
                                motionController.b(cVar.a, i3);
                                cVar.a(canvas, drawPath, cVar.l, motionController);
                                cVar.e.setColor(-21965);
                                cVar.f.setColor(-2067046);
                                cVar.i.setColor(-2067046);
                                cVar.g.setColor(-13391360);
                                float f3 = (float) (-cVar.n);
                                canvas.translate(f3, f3);
                                cVar.a(canvas, drawPath, cVar.l, motionController);
                                if (drawPath == 5) {
                                    cVar.d.reset();
                                    for (int i4 = 0; i4 <= 50; i4++) {
                                        float[] fArr2 = cVar.j;
                                        motionController.h[0].getPos((double) motionController.c(((float) i4) / ((float) 50), null), motionController.n);
                                        motionController.d.d(motionController.m, motionController.n, fArr2, 0);
                                        Path path = cVar.d;
                                        float[] fArr3 = cVar.j;
                                        path.moveTo(fArr3[0], fArr3[1]);
                                        Path path2 = cVar.d;
                                        float[] fArr4 = cVar.j;
                                        path2.lineTo(fArr4[2], fArr4[3]);
                                        Path path3 = cVar.d;
                                        float[] fArr5 = cVar.j;
                                        path3.lineTo(fArr5[4], fArr5[5]);
                                        Path path4 = cVar.d;
                                        float[] fArr6 = cVar.j;
                                        path4.lineTo(fArr6[6], fArr6[7]);
                                        cVar.d.close();
                                    }
                                    cVar.e.setColor(1140850688);
                                    canvas.translate(2.0f, 2.0f);
                                    canvas.drawPath(cVar.d, cVar.e);
                                    canvas.translate(-2.0f, -2.0f);
                                    cVar.e.setColor(SupportMenu.CATEGORY_MASK);
                                    canvas.drawPath(cVar.d, cVar.e);
                                }
                            }
                        }
                    }
                    canvas.restore();
                }
            }
        }
    }

    public void e(int i, float f2, float f3, float f4, float[] fArr) {
        HashMap<View, MotionController> hashMap = this.z;
        View viewById = getViewById(i);
        MotionController motionController = hashMap.get(viewById);
        if (motionController != null) {
            motionController.d(f2, f3, f4, fArr);
            float y2 = viewById.getY();
            int i2 = ((f2 - this.J) > 0.0f ? 1 : ((f2 - this.J) == 0.0f ? 0 : -1));
            this.J = f2;
            this.K = y2;
        } else if (viewById == null) {
            String str = "" + i;
        } else {
            viewById.getContext().getResources().getResourceName(i);
        }
    }

    public void enableTransition(int i, boolean z2) {
        MotionScene.Transition transition = getTransition(i);
        if (z2) {
            transition.setEnable(true);
            return;
        }
        MotionScene motionScene = this.q;
        if (transition == motionScene.c) {
            Iterator<MotionScene.Transition> it = motionScene.getTransitionsWithState(this.u).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MotionScene.Transition next = it.next();
                if (next.isEnabled()) {
                    this.q.c = next;
                    break;
                }
            }
        }
        transition.setEnable(false);
    }

    public String f(int i) {
        MotionScene motionScene = this.q;
        if (motionScene == null) {
            return null;
        }
        return motionScene.lookUpConstraintName(i);
    }

    public void fireTransitionCompleted() {
        int i;
        ArrayList<TransitionListener> arrayList;
        if ((this.I != null || ((arrayList = this.e0) != null && !arrayList.isEmpty())) && this.i0 == -1) {
            this.i0 = this.u;
            if (!this.z0.isEmpty()) {
                ArrayList<Integer> arrayList2 = this.z0;
                i = arrayList2.get(arrayList2.size() - 1).intValue();
            } else {
                i = -1;
            }
            int i2 = this.u;
            if (!(i == i2 || i2 == -1)) {
                this.z0.add(Integer.valueOf(i2));
            }
        }
        j();
    }

    public void fireTrigger(int i, boolean z2, float f2) {
        TransitionListener transitionListener = this.I;
        if (transitionListener != null) {
            transitionListener.onTransitionTrigger(this, i, z2, f2);
        }
        ArrayList<TransitionListener> arrayList = this.e0;
        if (arrayList != null) {
            Iterator<TransitionListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onTransitionTrigger(this, i, z2, f2);
            }
        }
    }

    public final boolean g(float f2, float f3, View view, MotionEvent motionEvent) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (g(((float) view.getLeft()) + f2, ((float) view.getTop()) + f3, viewGroup.getChildAt(i), motionEvent)) {
                    return true;
                }
            }
        }
        this.x0.set(((float) view.getLeft()) + f2, ((float) view.getTop()) + f3, f2 + ((float) view.getRight()), f3 + ((float) view.getBottom()));
        if (motionEvent.getAction() == 0) {
            if (this.x0.contains(motionEvent.getX(), motionEvent.getY()) && view.onTouchEvent(motionEvent)) {
                return true;
            }
        } else if (view.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public ConstraintSet getConstraintSet(int i) {
        MotionScene motionScene = this.q;
        if (motionScene == null) {
            return null;
        }
        return motionScene.b(i);
    }

    public int[] getConstraintSetIds() {
        MotionScene motionScene = this.q;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getConstraintSetIds();
    }

    public int getCurrentState() {
        return this.u;
    }

    public void getDebugMode(boolean z2) {
        this.L = z2 ? 2 : 1;
        invalidate();
    }

    public ArrayList<MotionScene.Transition> getDefinedTransitions() {
        MotionScene motionScene = this.q;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getDefinedTransitions();
    }

    public DesignTool getDesignTool() {
        if (this.Q == null) {
            this.Q = new DesignTool(this);
        }
        return this.Q;
    }

    public int getEndState() {
        return this.v;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.D;
    }

    public int getStartState() {
        return this.t;
    }

    public float getTargetPosition() {
        return this.F;
    }

    public MotionScene.Transition getTransition(int i) {
        return this.q.getTransitionById(i);
    }

    public Bundle getTransitionState() {
        if (this.t0 == null) {
            this.t0 = new f();
        }
        f fVar = this.t0;
        MotionLayout motionLayout = MotionLayout.this;
        fVar.d = motionLayout.v;
        fVar.c = motionLayout.t;
        fVar.b = motionLayout.getVelocity();
        fVar.a = MotionLayout.this.getProgress();
        f fVar2 = this.t0;
        Objects.requireNonNull(fVar2);
        Bundle bundle = new Bundle();
        bundle.putFloat("motion.progress", fVar2.a);
        bundle.putFloat("motion.velocity", fVar2.b);
        bundle.putInt("motion.StartState", fVar2.c);
        bundle.putInt("motion.EndState", fVar2.d);
        return bundle;
    }

    public long getTransitionTimeMs() {
        MotionScene motionScene = this.q;
        if (motionScene != null) {
            this.B = ((float) motionScene.getDuration()) / 1000.0f;
        }
        return (long) (this.B * 1000.0f);
    }

    public float getVelocity() {
        return this.s;
    }

    public void getViewVelocity(View view, float f2, float f3, float[] fArr, int i) {
        float f4;
        SplineSet splineSet;
        double[] dArr;
        float f5 = this.s;
        float f6 = this.D;
        if (this.r != null) {
            float signum = Math.signum(this.F - f6);
            float interpolation = this.r.getInterpolation(this.D + 1.0E-5f);
            float interpolation2 = this.r.getInterpolation(this.D);
            f5 = (((interpolation - interpolation2) / 1.0E-5f) * signum) / this.B;
            f6 = interpolation2;
        }
        Interpolator interpolator = this.r;
        if (interpolator instanceof MotionInterpolator) {
            f5 = ((MotionInterpolator) interpolator).getVelocity();
        }
        MotionController motionController = this.z.get(view);
        if ((i & 1) == 0) {
            int width = view.getWidth();
            int height = view.getHeight();
            float c2 = motionController.c(f6, motionController.u);
            HashMap<String, SplineSet> hashMap = motionController.x;
            SplineSet splineSet2 = hashMap == null ? null : hashMap.get("translationX");
            HashMap<String, SplineSet> hashMap2 = motionController.x;
            SplineSet splineSet3 = hashMap2 == null ? null : hashMap2.get("translationY");
            HashMap<String, SplineSet> hashMap3 = motionController.x;
            SplineSet splineSet4 = hashMap3 == null ? null : hashMap3.get("rotation");
            HashMap<String, SplineSet> hashMap4 = motionController.x;
            if (hashMap4 == null) {
                f4 = f5;
                splineSet = null;
            } else {
                splineSet = hashMap4.get("scaleX");
                f4 = f5;
            }
            HashMap<String, SplineSet> hashMap5 = motionController.x;
            SplineSet splineSet5 = hashMap5 == null ? null : hashMap5.get("scaleY");
            HashMap<String, KeyCycleOscillator> hashMap6 = motionController.y;
            KeyCycleOscillator keyCycleOscillator = hashMap6 == null ? null : hashMap6.get("translationX");
            HashMap<String, KeyCycleOscillator> hashMap7 = motionController.y;
            KeyCycleOscillator keyCycleOscillator2 = hashMap7 == null ? null : hashMap7.get("translationY");
            HashMap<String, KeyCycleOscillator> hashMap8 = motionController.y;
            KeyCycleOscillator keyCycleOscillator3 = hashMap8 == null ? null : hashMap8.get("rotation");
            HashMap<String, KeyCycleOscillator> hashMap9 = motionController.y;
            KeyCycleOscillator keyCycleOscillator4 = hashMap9 == null ? null : hashMap9.get("scaleX");
            HashMap<String, KeyCycleOscillator> hashMap10 = motionController.y;
            KeyCycleOscillator keyCycleOscillator5 = hashMap10 == null ? null : hashMap10.get("scaleY");
            VelocityMatrix velocityMatrix = new VelocityMatrix();
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(splineSet4, c2);
            velocityMatrix.setTranslationVelocity(splineSet2, splineSet3, c2);
            velocityMatrix.setScaleVelocity(splineSet, splineSet5, c2);
            velocityMatrix.setRotationVelocity(keyCycleOscillator3, c2);
            velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, c2);
            velocityMatrix.setScaleVelocity(keyCycleOscillator4, keyCycleOscillator5, c2);
            CurveFit curveFit = motionController.i;
            if (curveFit != null) {
                double[] dArr2 = motionController.n;
                if (dArr2.length > 0) {
                    double d2 = (double) c2;
                    curveFit.getPos(d2, dArr2);
                    motionController.i.getSlope(d2, motionController.o);
                    motionController.d.f(f2, f3, fArr, motionController.m, motionController.o, motionController.n);
                }
                velocityMatrix.applyTransform(f2, f3, width, height, fArr);
            } else if (motionController.h != null) {
                double c3 = (double) motionController.c(c2, motionController.u);
                motionController.h[0].getSlope(c3, motionController.o);
                motionController.h[0].getPos(c3, motionController.n);
                float f7 = motionController.u[0];
                int i2 = 0;
                while (true) {
                    dArr = motionController.o;
                    if (i2 >= dArr.length) {
                        break;
                    }
                    dArr[i2] = dArr[i2] * ((double) f7);
                    i2++;
                }
                motionController.d.f(f2, f3, fArr, motionController.m, dArr, motionController.n);
                velocityMatrix.applyTransform(f2, f3, width, height, fArr);
            } else {
                l6.g.a.b.c cVar = motionController.e;
                float f8 = cVar.e;
                l6.g.a.b.c cVar2 = motionController.d;
                float f9 = f8 - cVar2.e;
                float f10 = cVar.f - cVar2.f;
                fArr[0] = (((cVar.g - cVar2.g) + f9) * f2) + ((1.0f - f2) * f9);
                fArr[1] = (((cVar.h - cVar2.h) + f10) * f3) + ((1.0f - f3) * f10);
                velocityMatrix.clear();
                velocityMatrix.setRotationVelocity(splineSet4, c2);
                velocityMatrix.setTranslationVelocity(splineSet2, splineSet3, c2);
                velocityMatrix.setScaleVelocity(splineSet, splineSet5, c2);
                velocityMatrix.setRotationVelocity(keyCycleOscillator3, c2);
                velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, c2);
                velocityMatrix.setScaleVelocity(keyCycleOscillator4, keyCycleOscillator5, c2);
                velocityMatrix.applyTransform(f2, f3, width, height, fArr);
            }
        } else {
            f4 = f5;
            motionController.d(f6, f2, f3, fArr);
        }
        if (i < 2) {
            fArr[0] = fArr[0] * f4;
            fArr[1] = fArr[1] * f4;
        }
    }

    public final void h(AttributeSet attributeSet) {
        MotionScene motionScene;
        MotionScene motionScene2;
        IS_IN_EDIT_MODE = isInEditMode();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionLayout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z2 = true;
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.MotionLayout_layoutDescription) {
                    this.q = new MotionScene(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R.styleable.MotionLayout_currentState) {
                    this.u = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R.styleable.MotionLayout_motionProgress) {
                    this.F = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.H = true;
                } else if (index == R.styleable.MotionLayout_applyMotionScene) {
                    z2 = obtainStyledAttributes.getBoolean(index, z2);
                } else if (index == R.styleable.MotionLayout_showPaths) {
                    if (this.L == 0) {
                        this.L = obtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                    }
                } else if (index == R.styleable.MotionLayout_motionDebug) {
                    this.L = obtainStyledAttributes.getInt(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
            MotionScene motionScene3 = this.q;
            if (!z2) {
                this.q = null;
            }
        }
        if (!(this.L == 0 || (motionScene2 = this.q) == null)) {
            int h = motionScene2.h();
            MotionScene motionScene4 = this.q;
            ConstraintSet b2 = motionScene4.b(motionScene4.h());
            Debug.getName(getContext(), h);
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                int id = childAt.getId();
                if (id == -1) {
                    childAt.getClass().getName();
                }
                if (b2.getConstraint(id) == null) {
                    Debug.getName(childAt);
                }
            }
            int[] knownIds = b2.getKnownIds();
            for (int i3 = 0; i3 < knownIds.length; i3++) {
                int i4 = knownIds[i3];
                Debug.getName(getContext(), i4);
                findViewById(knownIds[i3]);
                b2.getHeight(i4);
                b2.getWidth(i4);
            }
            SparseIntArray sparseIntArray = new SparseIntArray();
            SparseIntArray sparseIntArray2 = new SparseIntArray();
            Iterator<MotionScene.Transition> it = this.q.getDefinedTransitions().iterator();
            while (it.hasNext()) {
                MotionScene.Transition next = it.next();
                MotionScene.Transition transition = this.q.c;
                next.debugString(getContext());
                next.getDuration();
                next.getStartConstraintSetId();
                next.getEndConstraintSetId();
                int startConstraintSetId = next.getStartConstraintSetId();
                int endConstraintSetId = next.getEndConstraintSetId();
                Debug.getName(getContext(), startConstraintSetId);
                Debug.getName(getContext(), endConstraintSetId);
                sparseIntArray.get(startConstraintSetId);
                sparseIntArray2.get(endConstraintSetId);
                sparseIntArray.put(startConstraintSetId, endConstraintSetId);
                sparseIntArray2.put(endConstraintSetId, startConstraintSetId);
                this.q.b(startConstraintSetId);
                this.q.b(endConstraintSetId);
            }
        }
        if (this.u == -1 && (motionScene = this.q) != null) {
            this.u = motionScene.h();
            this.t = this.q.h();
            this.v = this.q.c();
        }
    }

    public void i() {
        MotionScene.Transition transition;
        l6.g.a.b.f fVar;
        View view;
        MotionScene motionScene = this.q;
        if (motionScene != null) {
            if (motionScene.a(this, this.u)) {
                requestLayout();
                return;
            }
            int i = this.u;
            if (i != -1) {
                this.q.addOnClickListeners(this, i);
            }
            if (this.q.n() && (transition = this.q.c) != null && (fVar = transition.l) != null) {
                int i2 = fVar.d;
                if (i2 != -1) {
                    view = fVar.o.findViewById(i2);
                    if (view == null) {
                        Debug.getName(fVar.o.getContext(), fVar.d);
                    }
                } else {
                    view = null;
                }
                if (view instanceof NestedScrollView) {
                    NestedScrollView nestedScrollView = (NestedScrollView) view;
                    nestedScrollView.setOnTouchListener(new l6.g.a.b.d(fVar));
                    nestedScrollView.setOnScrollChangeListener(new l6.g.a.b.e(fVar));
                }
            }
        }
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    public boolean isInteractionEnabled() {
        return this.y;
    }

    public final void j() {
        ArrayList<TransitionListener> arrayList;
        if (this.I != null || ((arrayList = this.e0) != null && !arrayList.isEmpty())) {
            Iterator<Integer> it = this.z0.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                TransitionListener transitionListener = this.I;
                if (transitionListener != null) {
                    transitionListener.onTransitionCompleted(this, next.intValue());
                }
                ArrayList<TransitionListener> arrayList2 = this.e0;
                if (arrayList2 != null) {
                    Iterator<TransitionListener> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        it2.next().onTransitionCompleted(this, next.intValue());
                    }
                }
            }
            this.z0.clear();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int i) {
        if (i != 0) {
            try {
                this.q = new MotionScene(getContext(), this, i);
                if (isAttachedToWindow()) {
                    this.q.l(this);
                    this.v0.d(this.q.b(this.t), this.q.b(this.v));
                    rebuildScene();
                    this.q.setRtl(isRtl());
                }
            } catch (Exception e2) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e2);
            }
        } else {
            this.q = null;
        }
    }

    public MotionTracker obtainVelocityTracker() {
        e.b.a = VelocityTracker.obtain();
        return e.b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        MotionScene.Transition transition;
        int i;
        super.onAttachedToWindow();
        MotionScene motionScene = this.q;
        if (!(motionScene == null || (i = this.u) == -1)) {
            ConstraintSet b2 = motionScene.b(i);
            this.q.l(this);
            if (b2 != null) {
                b2.applyTo(this);
            }
            this.t = this.u;
        }
        i();
        f fVar = this.t0;
        if (fVar != null) {
            fVar.a();
            return;
        }
        MotionScene motionScene2 = this.q;
        if (motionScene2 != null && (transition = motionScene2.c) != null && transition.getAutoTransition() == 4) {
            transitionToEnd();
            setState(g.SETUP);
            setState(g.MOVING);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionScene.Transition transition;
        l6.g.a.b.f touchResponse;
        int i;
        RectF a3;
        MotionScene motionScene = this.q;
        if (motionScene != null && this.y && (transition = motionScene.c) != null && transition.isEnabled() && (touchResponse = transition.getTouchResponse()) != null && ((motionEvent.getAction() != 0 || (a3 = touchResponse.a(this, new RectF())) == null || a3.contains(motionEvent.getX(), motionEvent.getY())) && (i = touchResponse.e) != -1)) {
            View view = this.y0;
            if (view == null || view.getId() != i) {
                this.y0 = findViewById(i);
            }
            View view2 = this.y0;
            if (view2 != null) {
                this.x0.set((float) view2.getLeft(), (float) this.y0.getTop(), (float) this.y0.getRight(), (float) this.y0.getBottom());
                if (this.x0.contains(motionEvent.getX(), motionEvent.getY()) && !g(0.0f, 0.0f, this.y0, motionEvent)) {
                    return onTouchEvent(motionEvent);
                }
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        this.s0 = true;
        boolean z3 = false;
        try {
            if (this.q == null) {
                super.onLayout(z2, i, i2, i3, i4);
                return;
            }
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (!(this.R == i5 && this.S == i6)) {
                rebuildScene();
                c(true);
            }
            this.R = i5;
            this.S = i6;
            this.s0 = false;
        } finally {
            this.s0 = z3;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004e, code lost:
        if (((r6 == r3.e && r7 == r3.f) ? false : true) != false) goto L_0x0050;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r18, int r19) {
        /*
        // Method dump skipped, instructions count: 366
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        MotionScene.Transition transition;
        l6.g.a.b.f fVar;
        float f2;
        float f3;
        l6.g.a.b.f fVar2;
        l6.g.a.b.f fVar3;
        l6.g.a.b.f touchResponse;
        int i4;
        MotionScene motionScene = this.q;
        if (motionScene != null && (transition = motionScene.c) != null && transition.isEnabled()) {
            MotionScene.Transition transition2 = this.q.c;
            if (transition2 == null || !transition2.isEnabled() || (touchResponse = transition2.getTouchResponse()) == null || (i4 = touchResponse.e) == -1 || view.getId() == i4) {
                MotionScene motionScene2 = this.q;
                if (motionScene2 != null) {
                    MotionScene.Transition transition3 = motionScene2.c;
                    if ((transition3 == null || (fVar3 = transition3.l) == null) ? false : fVar3.r) {
                        float f4 = this.C;
                        if ((f4 == 1.0f || f4 == 0.0f) && view.canScrollVertically(-1)) {
                            return;
                        }
                    }
                }
                if (!(transition2.getTouchResponse() == null || (this.q.c.getTouchResponse().t & 1) == 0)) {
                    float f5 = (float) i;
                    float f6 = (float) i2;
                    MotionScene.Transition transition4 = this.q.c;
                    if (transition4 == null || (fVar2 = transition4.l) == null) {
                        f3 = 0.0f;
                    } else {
                        fVar2.o.e(fVar2.d, fVar2.o.getProgress(), fVar2.h, fVar2.g, fVar2.l);
                        float f7 = fVar2.i;
                        if (f7 != 0.0f) {
                            float[] fArr = fVar2.l;
                            if (fArr[0] == 0.0f) {
                                fArr[0] = 1.0E-7f;
                            }
                            f3 = (f5 * f7) / fArr[0];
                        } else {
                            float[] fArr2 = fVar2.l;
                            if (fArr2[1] == 0.0f) {
                                fArr2[1] = 1.0E-7f;
                            }
                            f3 = (f6 * fVar2.j) / fArr2[1];
                        }
                    }
                    float f8 = this.D;
                    if ((f8 <= 0.0f && f3 < 0.0f) || (f8 >= 1.0f && f3 > 0.0f)) {
                        view.setNestedScrollingEnabled(false);
                        view.post(new a(this, view));
                        return;
                    }
                }
                float f9 = this.C;
                long nanoTime = getNanoTime();
                float f10 = (float) i;
                this.U = f10;
                float f11 = (float) i2;
                this.V = f11;
                this.a0 = (float) (((double) (nanoTime - this.W)) * 1.0E-9d);
                this.W = nanoTime;
                MotionScene.Transition transition5 = this.q.c;
                if (!(transition5 == null || (fVar = transition5.l) == null)) {
                    float progress = fVar.o.getProgress();
                    if (!fVar.k) {
                        fVar.k = true;
                        fVar.o.setProgress(progress);
                    }
                    fVar.o.e(fVar.d, progress, fVar.h, fVar.g, fVar.l);
                    float f12 = fVar.i;
                    float[] fArr3 = fVar.l;
                    if (((double) Math.abs((fVar.j * fArr3[1]) + (f12 * fArr3[0]))) < 0.01d) {
                        float[] fArr4 = fVar.l;
                        fArr4[0] = 0.01f;
                        fArr4[1] = 0.01f;
                    }
                    float f13 = fVar.i;
                    if (f13 != 0.0f) {
                        f2 = (f10 * f13) / fVar.l[0];
                    } else {
                        f2 = (f11 * fVar.j) / fVar.l[1];
                    }
                    float max = Math.max(Math.min(progress + f2, 1.0f), 0.0f);
                    if (max != fVar.o.getProgress()) {
                        fVar.o.setProgress(max);
                    }
                }
                if (f9 != this.C) {
                    iArr[0] = i;
                    iArr[1] = i2;
                }
                c(false);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    this.T = true;
                }
            }
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (!(!this.T && i == 0 && i2 == 0)) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
        }
        this.T = false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        MotionScene motionScene = this.q;
        if (motionScene != null) {
            motionScene.setRtl(isRtl());
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        MotionScene.Transition transition;
        MotionScene motionScene = this.q;
        return (motionScene == null || (transition = motionScene.c) == null || transition.getTouchResponse() == null || (this.q.c.getTouchResponse().t & 2) != 0) ? false : true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i) {
        l6.g.a.b.f fVar;
        float f2;
        MotionScene motionScene = this.q;
        if (motionScene != null) {
            float f3 = this.U;
            float f4 = this.a0;
            float f5 = f3 / f4;
            float f6 = this.V / f4;
            MotionScene.Transition transition = motionScene.c;
            if (transition != null && (fVar = transition.l) != null) {
                boolean z2 = false;
                fVar.k = false;
                float progress = fVar.o.getProgress();
                fVar.o.e(fVar.d, progress, fVar.h, fVar.g, fVar.l);
                float f7 = fVar.i;
                float[] fArr = fVar.l;
                float f8 = fArr[0];
                float f9 = fVar.j;
                float f10 = fArr[1];
                float f11 = 0.0f;
                if (f7 != 0.0f) {
                    f2 = (f5 * f7) / fArr[0];
                } else {
                    f2 = (f6 * f9) / fArr[1];
                }
                if (!Float.isNaN(f2)) {
                    progress += f2 / 3.0f;
                }
                if (progress != 0.0f) {
                    boolean z3 = progress != 1.0f;
                    int i2 = fVar.c;
                    if (i2 != 3) {
                        z2 = true;
                    }
                    if (z2 && z3) {
                        MotionLayout motionLayout = fVar.o;
                        if (((double) progress) >= 0.5d) {
                            f11 = 1.0f;
                        }
                        motionLayout.touchAnimateTo(i2, f11, f2);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionTracker motionTracker;
        l6.g.a.b.f fVar;
        float f2;
        int i;
        float f3;
        RectF rectF;
        View findViewById;
        MotionEvent motionEvent2;
        MotionScene motionScene = this.q;
        if (motionScene == null || !this.y || !motionScene.n()) {
            return super.onTouchEvent(motionEvent);
        }
        MotionScene.Transition transition = this.q.c;
        if (transition != null && !transition.isEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        MotionScene motionScene2 = this.q;
        int currentState = getCurrentState();
        Objects.requireNonNull(motionScene2);
        RectF rectF2 = new RectF();
        if (motionScene2.p == null) {
            motionScene2.p = motionScene2.a.obtainVelocityTracker();
        }
        motionScene2.p.addMovement(motionEvent);
        if (currentState != -1) {
            int action = motionEvent.getAction();
            if (action == 0) {
                motionScene2.r = motionEvent.getRawX();
                motionScene2.s = motionEvent.getRawY();
                motionScene2.m = motionEvent;
                motionScene2.n = false;
                l6.g.a.b.f fVar2 = motionScene2.c.l;
                if (fVar2 != null) {
                    MotionLayout motionLayout = motionScene2.a;
                    int i2 = fVar2.f;
                    if (i2 == -1 || (findViewById = motionLayout.findViewById(i2)) == null) {
                        rectF = null;
                    } else {
                        rectF2.set((float) findViewById.getLeft(), (float) findViewById.getTop(), (float) findViewById.getRight(), (float) findViewById.getBottom());
                        rectF = rectF2;
                    }
                    if (rectF == null || rectF.contains(motionScene2.m.getX(), motionScene2.m.getY())) {
                        RectF a3 = motionScene2.c.l.a(motionScene2.a, rectF2);
                        if (a3 == null || a3.contains(motionScene2.m.getX(), motionScene2.m.getY())) {
                            motionScene2.o = false;
                        } else {
                            motionScene2.o = true;
                        }
                        l6.g.a.b.f fVar3 = motionScene2.c.l;
                        float f4 = motionScene2.r;
                        float f5 = motionScene2.s;
                        fVar3.m = f4;
                        fVar3.n = f5;
                    } else {
                        motionScene2.m = null;
                        motionScene2.n = true;
                    }
                }
            } else if (action == 2 && !motionScene2.n) {
                float rawY = motionEvent.getRawY() - motionScene2.s;
                float rawX = motionEvent.getRawX() - motionScene2.r;
                if (!((((double) rawX) == 0.0d && ((double) rawY) == 0.0d) || (motionEvent2 = motionScene2.m) == null)) {
                    MotionScene.Transition bestTransitionFor = motionScene2.bestTransitionFor(currentState, rawX, rawY, motionEvent2);
                    if (bestTransitionFor != null) {
                        setTransition(bestTransitionFor);
                        RectF a4 = motionScene2.c.l.a(motionScene2.a, rectF2);
                        motionScene2.o = a4 != null && !a4.contains(motionScene2.m.getX(), motionScene2.m.getY());
                        l6.g.a.b.f fVar4 = motionScene2.c.l;
                        float f6 = motionScene2.r;
                        float f7 = motionScene2.s;
                        fVar4.m = f6;
                        fVar4.n = f7;
                        fVar4.k = false;
                    }
                }
            }
            return true;
        }
        if (!motionScene2.n) {
            MotionScene.Transition transition2 = motionScene2.c;
            if (!(transition2 == null || (fVar = transition2.l) == null || motionScene2.o)) {
                MotionTracker motionTracker2 = motionScene2.p;
                g gVar = g.FINISHED;
                motionTracker2.addMovement(motionEvent);
                int action2 = motionEvent.getAction();
                if (action2 == 0) {
                    fVar.m = motionEvent.getRawX();
                    fVar.n = motionEvent.getRawY();
                    fVar.k = false;
                } else if (action2 == 1) {
                    fVar.k = false;
                    motionTracker2.computeCurrentVelocity(1000);
                    float xVelocity = motionTracker2.getXVelocity();
                    float yVelocity = motionTracker2.getYVelocity();
                    float progress = fVar.o.getProgress();
                    int i3 = fVar.d;
                    if (i3 != -1) {
                        fVar.o.e(i3, progress, fVar.h, fVar.g, fVar.l);
                    } else {
                        float min = (float) Math.min(fVar.o.getWidth(), fVar.o.getHeight());
                        float[] fArr = fVar.l;
                        fArr[1] = fVar.j * min;
                        fArr[0] = min * fVar.i;
                    }
                    float f8 = fVar.i;
                    float[] fArr2 = fVar.l;
                    float f9 = fArr2[0];
                    float f10 = fArr2[1];
                    if (f8 != 0.0f) {
                        f2 = xVelocity / fArr2[0];
                    } else {
                        f2 = yVelocity / fArr2[1];
                    }
                    float f11 = !Float.isNaN(f2) ? (f2 / 3.0f) + progress : progress;
                    if (f11 != 0.0f && f11 != 1.0f && (i = fVar.c) != 3) {
                        fVar.o.touchAnimateTo(i, ((double) f11) < 0.5d ? 0.0f : 1.0f, f2);
                        if (0.0f >= progress || 1.0f <= progress) {
                            fVar.o.setState(gVar);
                        }
                    } else if (0.0f >= f11 || 1.0f <= f11) {
                        fVar.o.setState(gVar);
                    }
                } else if (action2 == 2) {
                    float rawY2 = motionEvent.getRawY() - fVar.n;
                    float rawX2 = motionEvent.getRawX() - fVar.m;
                    if (Math.abs((fVar.j * rawY2) + (fVar.i * rawX2)) > fVar.u || fVar.k) {
                        float progress2 = fVar.o.getProgress();
                        if (!fVar.k) {
                            fVar.k = true;
                            fVar.o.setProgress(progress2);
                        }
                        int i4 = fVar.d;
                        if (i4 != -1) {
                            fVar.o.e(i4, progress2, fVar.h, fVar.g, fVar.l);
                        } else {
                            float min2 = (float) Math.min(fVar.o.getWidth(), fVar.o.getHeight());
                            float[] fArr3 = fVar.l;
                            fArr3[1] = fVar.j * min2;
                            fArr3[0] = min2 * fVar.i;
                        }
                        float f12 = fVar.i;
                        float[] fArr4 = fVar.l;
                        if (((double) Math.abs(((fVar.j * fArr4[1]) + (f12 * fArr4[0])) * fVar.s)) < 0.01d) {
                            float[] fArr5 = fVar.l;
                            fArr5[0] = 0.01f;
                            fArr5[1] = 0.01f;
                        }
                        if (fVar.i != 0.0f) {
                            f3 = rawX2 / fVar.l[0];
                        } else {
                            f3 = rawY2 / fVar.l[1];
                        }
                        float max = Math.max(Math.min(progress2 + f3, 1.0f), 0.0f);
                        if (max != fVar.o.getProgress()) {
                            fVar.o.setProgress(max);
                            motionTracker2.computeCurrentVelocity(1000);
                            fVar.o.s = fVar.i != 0.0f ? motionTracker2.getXVelocity() / fVar.l[0] : motionTracker2.getYVelocity() / fVar.l[1];
                        } else {
                            fVar.o.s = 0.0f;
                        }
                        fVar.m = motionEvent.getRawX();
                        fVar.n = motionEvent.getRawY();
                    }
                }
            }
            motionScene2.r = motionEvent.getRawX();
            motionScene2.s = motionEvent.getRawY();
            if (motionEvent.getAction() == 1 && (motionTracker = motionScene2.p) != null) {
                motionTracker.recycle();
                motionScene2.p = null;
                int i5 = this.u;
                if (i5 != -1) {
                    motionScene2.a(this, i5);
                }
            }
        }
        return true;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.e0 == null) {
                this.e0 = new ArrayList<>();
            }
            this.e0.add(motionHelper);
            if (motionHelper.isUsedOnShow()) {
                if (this.c0 == null) {
                    this.c0 = new ArrayList<>();
                }
                this.c0.add(motionHelper);
            }
            if (motionHelper.isUseOnHide()) {
                if (this.d0 == null) {
                    this.d0 = new ArrayList<>();
                }
                this.d0.add(motionHelper);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.c0;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<MotionHelper> arrayList2 = this.d0;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void parseLayoutDescription(int i) {
        this.mConstraintLayoutSpec = null;
    }

    @Deprecated
    public void rebuildMotion() {
        rebuildScene();
    }

    public void rebuildScene() {
        this.v0.e();
        invalidate();
    }

    public boolean removeTransitionListener(TransitionListener transitionListener) {
        ArrayList<TransitionListener> arrayList = this.e0;
        if (arrayList == null) {
            return false;
        }
        return arrayList.remove(transitionListener);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewParent, android.view.View
    public void requestLayout() {
        MotionScene motionScene;
        MotionScene.Transition transition;
        if (this.mMeasureDuringTransition || this.u != -1 || (motionScene = this.q) == null || (transition = motionScene.c) == null || transition.getLayoutDuringTransition() != 0) {
            super.requestLayout();
        }
    }

    public void setDebugMode(int i) {
        this.L = i;
        invalidate();
    }

    public void setInteractionEnabled(boolean z2) {
        this.y = z2;
    }

    public void setInterpolatedProgress(float f2) {
        if (this.q != null) {
            setState(g.MOVING);
            Interpolator interpolator = this.q.getInterpolator();
            if (interpolator != null) {
                setProgress(interpolator.getInterpolation(f2));
                return;
            }
        }
        setProgress(f2);
    }

    public void setOnHide(float f2) {
        ArrayList<MotionHelper> arrayList = this.d0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.d0.get(i).setProgress(f2);
            }
        }
    }

    public void setOnShow(float f2) {
        ArrayList<MotionHelper> arrayList = this.c0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.c0.get(i).setProgress(f2);
            }
        }
    }

    public void setProgress(float f2, float f3) {
        if (!isAttachedToWindow()) {
            if (this.t0 == null) {
                this.t0 = new f();
            }
            f fVar = this.t0;
            fVar.a = f2;
            fVar.b = f3;
            return;
        }
        setProgress(f2);
        setState(g.MOVING);
        this.s = f3;
        b(1.0f);
    }

    public void setScene(MotionScene motionScene) {
        this.q = motionScene;
        motionScene.setRtl(isRtl());
        rebuildScene();
    }

    public void setState(g gVar) {
        g gVar2 = g.FINISHED;
        if (gVar != gVar2 || this.u != -1) {
            g gVar3 = this.u0;
            this.u0 = gVar;
            g gVar4 = g.MOVING;
            if (gVar3 == gVar4 && gVar == gVar4) {
                d();
            }
            int ordinal = gVar3.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                if (gVar == gVar4) {
                    d();
                }
                if (gVar == gVar2) {
                    fireTransitionCompleted();
                }
            } else if (ordinal == 2 && gVar == gVar2) {
                fireTransitionCompleted();
            }
        }
    }

    public void setTransition(int i, int i2) {
        if (!isAttachedToWindow()) {
            if (this.t0 == null) {
                this.t0 = new f();
            }
            f fVar = this.t0;
            fVar.c = i;
            fVar.d = i2;
            return;
        }
        MotionScene motionScene = this.q;
        if (motionScene != null) {
            this.t = i;
            this.v = i2;
            motionScene.m(i, i2);
            this.v0.d(this.q.b(i), this.q.b(i2));
            rebuildScene();
            this.D = 0.0f;
            transitionToStart();
        }
    }

    public void setTransitionDuration(int i) {
        MotionScene motionScene = this.q;
        if (motionScene != null) {
            motionScene.setDuration(i);
        }
    }

    public void setTransitionListener(TransitionListener transitionListener) {
        this.I = transitionListener;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.t0 == null) {
            this.t0 = new f();
        }
        f fVar = this.t0;
        Objects.requireNonNull(fVar);
        fVar.a = bundle.getFloat("motion.progress");
        fVar.b = bundle.getFloat("motion.velocity");
        fVar.c = bundle.getInt("motion.StartState");
        fVar.d = bundle.getInt("motion.EndState");
        if (isAttachedToWindow()) {
            this.t0.a();
        }
    }

    @Override // android.view.View, java.lang.Object
    public String toString() {
        Context context = getContext();
        return Debug.getName(context, this.t) + "->" + Debug.getName(context, this.v) + " (pos:" + this.D + " Dpos/Dt:" + this.s;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0054, code lost:
        if ((((r15 * r6) - (((r1 * r6) * r6) / 2.0f)) + r13) > 1.0f) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0064, code lost:
        if ((((((r1 * r3) * r3) / 2.0f) + (r15 * r3)) + r13) < 0.0f) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void touchAnimateTo(int r13, float r14, float r15) {
        /*
        // Method dump skipped, instructions count: 255
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.touchAnimateTo(int, float, float):void");
    }

    public void transitionToEnd() {
        b(1.0f);
    }

    public void transitionToStart() {
        b(0.0f);
    }

    public void transitionToState(int i) {
        if (!isAttachedToWindow()) {
            if (this.t0 == null) {
                this.t0 = new f();
            }
            this.t0.d = i;
            return;
        }
        transitionToState(i, -1, -1);
    }

    public void updateState(int i, ConstraintSet constraintSet) {
        MotionScene motionScene = this.q;
        if (motionScene != null) {
            motionScene.setConstraintSet(i, constraintSet);
        }
        updateState();
        if (this.u == i) {
            constraintSet.applyTo(this);
        }
    }

    public static class e implements MotionTracker {
        public static e b = new e();
        public VelocityTracker a;

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void addMovement(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.a;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void clear() {
            VelocityTracker velocityTracker = this.a;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int i) {
            VelocityTracker velocityTracker = this.a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity() {
            VelocityTracker velocityTracker = this.a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity() {
            VelocityTracker velocityTracker = this.a;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void recycle() {
            VelocityTracker velocityTracker = this.a;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.a = null;
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int i, float f) {
            VelocityTracker velocityTracker = this.a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i, f);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity(int i) {
            VelocityTracker velocityTracker = this.a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity(i);
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity(int i) {
            if (this.a != null) {
                return getYVelocity(i);
            }
            return 0.0f;
        }
    }

    public void updateState() {
        this.v0.d(this.q.b(this.t), this.q.b(this.v));
        rebuildScene();
    }

    public void transitionToState(int i, int i2, int i3) {
        StateSet stateSet;
        int convertToConstraintSet;
        MotionScene motionScene = this.q;
        if (!(motionScene == null || (stateSet = motionScene.b) == null || (convertToConstraintSet = stateSet.convertToConstraintSet(this.u, i, (float) i2, (float) i3)) == -1)) {
            i = convertToConstraintSet;
        }
        int i4 = this.u;
        if (i4 != i) {
            if (this.t == i) {
                b(0.0f);
            } else if (this.v == i) {
                b(1.0f);
            } else {
                this.v = i;
                if (i4 != -1) {
                    setTransition(i4, i);
                    b(1.0f);
                    this.D = 0.0f;
                    transitionToEnd();
                    return;
                }
                this.N = false;
                this.F = 1.0f;
                this.C = 0.0f;
                this.D = 0.0f;
                this.E = getNanoTime();
                this.A = getNanoTime();
                this.G = false;
                this.r = null;
                this.B = ((float) this.q.getDuration()) / 1000.0f;
                this.t = -1;
                this.q.m(-1, this.v);
                this.q.h();
                int childCount = getChildCount();
                this.z.clear();
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = getChildAt(i5);
                    this.z.put(childAt, new MotionController(childAt));
                }
                this.H = true;
                this.v0.d(null, this.q.b(i));
                rebuildScene();
                this.v0.a();
                int childCount2 = getChildCount();
                for (int i6 = 0; i6 < childCount2; i6++) {
                    View childAt2 = getChildAt(i6);
                    MotionController motionController = this.z.get(childAt2);
                    if (motionController != null) {
                        l6.g.a.b.c cVar = motionController.d;
                        cVar.c = 0.0f;
                        cVar.d = 0.0f;
                        cVar.e(childAt2.getX(), childAt2.getY(), (float) childAt2.getWidth(), (float) childAt2.getHeight());
                        l6.g.a.b.b bVar = motionController.f;
                        Objects.requireNonNull(bVar);
                        childAt2.getX();
                        childAt2.getY();
                        childAt2.getWidth();
                        childAt2.getHeight();
                        bVar.c = childAt2.getVisibility();
                        bVar.a = childAt2.getVisibility() != 0 ? 0.0f : childAt2.getAlpha();
                        bVar.d = childAt2.getElevation();
                        bVar.e = childAt2.getRotation();
                        bVar.f = childAt2.getRotationX();
                        bVar.g = childAt2.getRotationY();
                        bVar.h = childAt2.getScaleX();
                        bVar.i = childAt2.getScaleY();
                        bVar.j = childAt2.getPivotX();
                        bVar.k = childAt2.getPivotY();
                        bVar.l = childAt2.getTranslationX();
                        bVar.m = childAt2.getTranslationY();
                        bVar.n = childAt2.getTranslationZ();
                    }
                }
                int width = getWidth();
                int height = getHeight();
                for (int i7 = 0; i7 < childCount; i7++) {
                    MotionController motionController2 = this.z.get(getChildAt(i7));
                    this.q.getKeyFrames(motionController2);
                    motionController2.setup(width, height, this.B, getNanoTime());
                }
                float staggered = this.q.getStaggered();
                if (staggered != 0.0f) {
                    float f2 = Float.MAX_VALUE;
                    float f3 = -3.4028235E38f;
                    for (int i8 = 0; i8 < childCount; i8++) {
                        l6.g.a.b.c cVar2 = this.z.get(getChildAt(i8)).e;
                        float f4 = cVar2.f + cVar2.e;
                        f2 = Math.min(f2, f4);
                        f3 = Math.max(f3, f4);
                    }
                    for (int i9 = 0; i9 < childCount; i9++) {
                        MotionController motionController3 = this.z.get(getChildAt(i9));
                        l6.g.a.b.c cVar3 = motionController3.e;
                        float f5 = cVar3.e;
                        float f6 = cVar3.f;
                        motionController3.l = 1.0f / (1.0f - staggered);
                        motionController3.k = staggered - ((((f5 + f6) - f2) * staggered) / (f3 - f2));
                    }
                }
                this.C = 0.0f;
                this.D = 0.0f;
                this.H = true;
                invalidate();
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int i, int i2, int i3) {
        setState(g.SETUP);
        this.u = i;
        this.t = -1;
        this.v = -1;
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.updateConstraints(i, (float) i2, (float) i3);
            return;
        }
        MotionScene motionScene = this.q;
        if (motionScene != null) {
            motionScene.b(i).applyTo(this);
        }
    }

    public void setProgress(float f2) {
        g gVar = g.FINISHED;
        int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (!isAttachedToWindow()) {
            if (this.t0 == null) {
                this.t0 = new f();
            }
            this.t0.a = f2;
            return;
        }
        if (i <= 0) {
            this.u = this.t;
            if (this.D == 0.0f) {
                setState(gVar);
            }
        } else if (f2 >= 1.0f) {
            this.u = this.v;
            if (this.D == 1.0f) {
                setState(gVar);
            }
        } else {
            this.u = -1;
            setState(g.MOVING);
        }
        if (this.q != null) {
            this.G = true;
            this.F = f2;
            this.C = f2;
            this.E = -1;
            this.A = -1;
            this.r = null;
            this.H = true;
            invalidate();
        }
    }

    public void setTransition(int i) {
        if (this.q != null) {
            MotionScene.Transition transition = getTransition(i);
            this.t = transition.getStartConstraintSetId();
            this.v = transition.getEndConstraintSetId();
            if (!isAttachedToWindow()) {
                if (this.t0 == null) {
                    this.t0 = new f();
                }
                f fVar = this.t0;
                fVar.c = this.t;
                fVar.d = this.v;
                return;
            }
            float f2 = Float.NaN;
            int i2 = this.u;
            float f3 = 0.0f;
            if (i2 == this.t) {
                f2 = 0.0f;
            } else if (i2 == this.v) {
                f2 = 1.0f;
            }
            this.q.setTransition(transition);
            this.v0.d(this.q.b(this.t), this.q.b(this.v));
            rebuildScene();
            if (!Float.isNaN(f2)) {
                f3 = f2;
            }
            this.D = f3;
            if (Float.isNaN(f2)) {
                Debug.getLocation();
                transitionToStart();
                return;
            }
            setProgress(f2);
        }
    }

    public void setTransition(MotionScene.Transition transition) {
        this.q.setTransition(transition);
        setState(g.SETUP);
        if (this.u == this.q.c()) {
            this.D = 1.0f;
            this.C = 1.0f;
            this.F = 1.0f;
        } else {
            this.D = 0.0f;
            this.C = 0.0f;
            this.F = 0.0f;
        }
        this.E = transition.isTransitionFlag(1) ? -1 : getNanoTime();
        int h = this.q.h();
        int c2 = this.q.c();
        if (h != this.t || c2 != this.v) {
            this.t = h;
            this.v = c2;
            this.q.m(h, c2);
            this.v0.d(this.q.b(this.t), this.q.b(this.v));
            d dVar = this.v0;
            int i = this.t;
            int i2 = this.v;
            dVar.e = i;
            dVar.f = i2;
            dVar.e();
            rebuildScene();
        }
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        h(attributeSet);
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        h(attributeSet);
    }
}
