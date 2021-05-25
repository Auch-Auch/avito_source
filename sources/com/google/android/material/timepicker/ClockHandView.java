package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.Px;
import java.util.ArrayList;
import java.util.List;
public class ClockHandView extends View {
    public static final /* synthetic */ int r = 0;
    public ValueAnimator a;
    public boolean b;
    public float c;
    public float d;
    public boolean e;
    public int f;
    public final List<OnRotateListener> g = new ArrayList();
    public final int h;
    public final float i;
    public final Paint j;
    public final RectF k;
    @Px
    public final int l;
    public float m;
    public boolean n;
    public OnActionUpListener o;
    public double p;
    public int q;

    public interface OnActionUpListener {
        void onActionUp(@FloatRange(from = 0.0d, to = 360.0d) float f, boolean z);
    }

    public interface OnRotateListener {
        void onRotate(@FloatRange(from = 0.0d, to = 360.0d) float f, boolean z);
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ClockHandView clockHandView = ClockHandView.this;
            int i = ClockHandView.r;
            clockHandView.c(floatValue, true);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b(ClockHandView clockHandView) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ClockHandView(android.content.Context r5, @androidx.annotation.Nullable android.util.AttributeSet r6) {
        /*
            r4 = this;
            int r0 = com.google.android.material.R.attr.materialClockStyle
            r4.<init>(r5, r6, r0)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r4.g = r1
            android.graphics.Paint r1 = new android.graphics.Paint
            r1.<init>()
            r4.j = r1
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r4.k = r2
            int[] r2 = com.google.android.material.R.styleable.ClockHandView
            int r3 = com.google.android.material.R.style.Widget_MaterialComponents_TimePicker_Clock
            android.content.res.TypedArray r6 = r5.obtainStyledAttributes(r6, r2, r0, r3)
            int r0 = com.google.android.material.R.styleable.ClockHandView_materialCircleRadius
            r2 = 0
            int r0 = r6.getDimensionPixelSize(r0, r2)
            r4.q = r0
            int r0 = com.google.android.material.R.styleable.ClockHandView_selectorSize
            int r0 = r6.getDimensionPixelSize(r0, r2)
            r4.h = r0
            android.content.res.Resources r0 = r4.getResources()
            int r3 = com.google.android.material.R.dimen.material_clock_hand_stroke_width
            int r3 = r0.getDimensionPixelSize(r3)
            r4.l = r3
            int r3 = com.google.android.material.R.dimen.material_clock_hand_center_dot_radius
            int r0 = r0.getDimensionPixelSize(r3)
            float r0 = (float) r0
            r4.i = r0
            int r0 = com.google.android.material.R.styleable.ClockHandView_clockHandColor
            int r0 = r6.getColor(r0, r2)
            r3 = 1
            r1.setAntiAlias(r3)
            r1.setColor(r0)
            r0 = 0
            r4.b(r0, r2)
            android.view.ViewConfiguration r5 = android.view.ViewConfiguration.get(r5)
            int r5 = r5.getScaledTouchSlop()
            r4.f = r5
            r5 = 2
            androidx.core.view.ViewCompat.setImportantForAccessibility(r4, r5)
            r6.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.timepicker.ClockHandView.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public final int a(float f2, float f3) {
        int degrees = ((int) Math.toDegrees(Math.atan2((double) (f3 - ((float) (getHeight() / 2))), (double) (f2 - ((float) (getWidth() / 2)))))) + 90;
        return degrees < 0 ? degrees + 360 : degrees;
    }

    public void b(@FloatRange(from = 0.0d, to = 360.0d) float f2, boolean z) {
        ValueAnimator valueAnimator = this.a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z) {
            c(f2, false);
            return;
        }
        float f3 = this.m;
        if (Math.abs(f3 - f2) > 180.0f) {
            if (f3 > 180.0f && f2 < 180.0f) {
                f2 += 360.0f;
            }
            if (f3 < 180.0f && f2 > 180.0f) {
                f3 += 360.0f;
            }
        }
        Pair pair = new Pair(Float.valueOf(f3), Float.valueOf(f2));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(((Float) pair.first).floatValue(), ((Float) pair.second).floatValue());
        this.a = ofFloat;
        ofFloat.setDuration(200L);
        this.a.addUpdateListener(new a());
        this.a.addListener(new b(this));
        this.a.start();
    }

    public final void c(@FloatRange(from = 0.0d, to = 360.0d) float f2, boolean z) {
        float f3 = f2 % 360.0f;
        this.m = f3;
        this.p = Math.toRadians((double) (f3 - 90.0f));
        float cos = (((float) this.q) * ((float) Math.cos(this.p))) + ((float) (getWidth() / 2));
        float sin = (((float) this.q) * ((float) Math.sin(this.p))) + ((float) (getHeight() / 2));
        RectF rectF = this.k;
        int i2 = this.h;
        rectF.set(cos - ((float) i2), sin - ((float) i2), cos + ((float) i2), sin + ((float) i2));
        for (OnRotateListener onRotateListener : this.g) {
            onRotateListener.onRotate(f3, z);
        }
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f2 = (float) width;
        float f3 = (float) height;
        this.j.setStrokeWidth(0.0f);
        canvas.drawCircle((((float) this.q) * ((float) Math.cos(this.p))) + f2, (((float) this.q) * ((float) Math.sin(this.p))) + f3, (float) this.h, this.j);
        double sin = Math.sin(this.p);
        double cos = Math.cos(this.p);
        double d2 = (double) ((float) (this.q - this.h));
        this.j.setStrokeWidth((float) this.l);
        canvas.drawLine(f2, f3, (float) (width + ((int) (cos * d2))), (float) (height + ((int) (d2 * sin))), this.j);
        canvas.drawCircle(f2, f3, this.i, this.j);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        b(this.m, false);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        OnActionUpListener onActionUpListener;
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        boolean z4 = false;
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 2) {
                int i2 = (int) (x - this.c);
                int i3 = (int) (y - this.d);
                this.e = (i3 * i3) + (i2 * i2) > this.f;
                z2 = this.n;
                z3 = actionMasked == 1;
            } else {
                z3 = false;
                z2 = false;
            }
            z = false;
        } else {
            this.c = x;
            this.d = y;
            this.e = true;
            this.n = false;
            z3 = false;
            z2 = false;
            z = true;
        }
        boolean z5 = this.n;
        float a3 = (float) a(x, y);
        boolean z7 = this.m != a3;
        if (!z || !z7) {
            if (z7 || z2) {
                if (z3 && this.b) {
                    z4 = true;
                }
                b(a3, z4);
            }
            boolean z8 = z4 | z5;
            this.n = z8;
            if (z8 && z3 && (onActionUpListener = this.o) != null) {
                onActionUpListener.onActionUp((float) a(x, y), this.e);
            }
            return true;
        }
        z4 = true;
        boolean z8 = z4 | z5;
        this.n = z8;
        onActionUpListener.onActionUp((float) a(x, y), this.e);
        return true;
    }
}
