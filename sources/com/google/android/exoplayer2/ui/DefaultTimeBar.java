package com.google.android.exoplayer2.ui;

import a2.b.a.a.a;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.google.android.exoplayer2.ui.TimeBar;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
public class DefaultTimeBar extends View implements TimeBar {
    public static final int BAR_GRAVITY_BOTTOM = 1;
    public static final int BAR_GRAVITY_CENTER = 0;
    public static final int BAR_GRAVITY_TOP = 2;
    public static final int DEFAULT_AD_MARKER_COLOR = -1291845888;
    public static final int DEFAULT_AD_MARKER_WIDTH_DP = 4;
    public static final int DEFAULT_BAR_HEIGHT_DP = 4;
    public static final int DEFAULT_BUFFERED_COLOR = -855638017;
    public static final int DEFAULT_PLAYED_AD_MARKER_COLOR = 872414976;
    public static final int DEFAULT_PLAYED_COLOR = -1;
    public static final int DEFAULT_SCRUBBER_COLOR = -1;
    public static final int DEFAULT_SCRUBBER_DISABLED_SIZE_DP = 0;
    public static final int DEFAULT_SCRUBBER_DRAGGED_SIZE_DP = 16;
    public static final int DEFAULT_SCRUBBER_ENABLED_SIZE_DP = 12;
    public static final int DEFAULT_TOUCH_TARGET_HEIGHT_DP = 26;
    public static final int DEFAULT_UNPLAYED_COLOR = 872415231;
    public int A;
    public long B;
    public int C;
    public Rect D;
    public ValueAnimator E;
    public float F;
    public boolean G;
    public long H;
    public long I;
    public long J;
    public long K;
    public int L;
    @Nullable
    public long[] M;
    @Nullable
    public boolean[] N;
    public final Rect a;
    public final Rect b;
    public final Rect c;
    public final Rect d;
    public final Paint e;
    public final Paint f;
    public final Paint g;
    public final Paint h;
    public final Paint i;
    public final Paint j;
    @Nullable
    public final Drawable k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;
    public final int s;
    public final int t;
    public final StringBuilder u;
    public final Formatter v;
    public final Runnable w;
    public final CopyOnWriteArraySet<TimeBar.OnScrubListener> x;
    public final Point y;
    public final float z;

    public DefaultTimeBar(Context context) {
        this(context, null);
    }

    public static int a(float f2, int i2) {
        return (int) ((((float) i2) * f2) + 0.5f);
    }

    private long getPositionIncrement() {
        long j2 = this.B;
        if (j2 != C.TIME_UNSET) {
            return j2;
        }
        long j3 = this.I;
        if (j3 == C.TIME_UNSET) {
            return 0;
        }
        return j3 / ((long) this.A);
    }

    private String getProgressText() {
        return Util.getStringForTime(this.u, this.v, this.J);
    }

    private long getScrubberPosition() {
        if (this.b.width() <= 0 || this.I == C.TIME_UNSET) {
            return 0;
        }
        return (((long) this.d.width()) * this.I) / ((long) this.b.width());
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void addListener(TimeBar.OnScrubListener onScrubListener) {
        Assertions.checkNotNull(onScrubListener);
        this.x.add(onScrubListener);
    }

    public final void b(float f2) {
        Rect rect = this.d;
        Rect rect2 = this.b;
        rect.right = Util.constrainValue((int) f2, rect2.left, rect2.right);
    }

    public final boolean c(long j2) {
        long j3 = this.I;
        if (j3 <= 0) {
            return false;
        }
        long j4 = this.G ? this.H : this.J;
        long constrainValue = Util.constrainValue(j4 + j2, 0, j3);
        if (constrainValue == j4) {
            return false;
        }
        if (!this.G) {
            d(constrainValue);
        } else {
            h(constrainValue);
        }
        f();
        return true;
    }

    public final void d(long j2) {
        this.H = j2;
        this.G = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<TimeBar.OnScrubListener> it = this.x.iterator();
        while (it.hasNext()) {
            it.next().onScrubStart(this, j2);
        }
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        g();
    }

    public final void e(boolean z2) {
        removeCallbacks(this.w);
        this.G = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<TimeBar.OnScrubListener> it = this.x.iterator();
        while (it.hasNext()) {
            it.next().onScrubStop(this, this.H, z2);
        }
    }

    public final void f() {
        this.c.set(this.b);
        this.d.set(this.b);
        long j2 = this.G ? this.H : this.J;
        if (this.I > 0) {
            int width = (int) ((((long) this.b.width()) * this.K) / this.I);
            Rect rect = this.c;
            Rect rect2 = this.b;
            rect.right = Math.min(rect2.left + width, rect2.right);
            int width2 = (int) ((((long) this.b.width()) * j2) / this.I);
            Rect rect3 = this.d;
            Rect rect4 = this.b;
            rect3.right = Math.min(rect4.left + width2, rect4.right);
        } else {
            Rect rect5 = this.c;
            int i2 = this.b.left;
            rect5.right = i2;
            this.d.right = i2;
        }
        invalidate(this.a);
    }

    public final void g() {
        Drawable drawable = this.k;
        if (drawable != null && drawable.isStateful() && this.k.setState(getDrawableState())) {
            invalidate();
        }
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public long getPreferredUpdateDelay() {
        int width = (int) (((float) this.b.width()) / this.z);
        if (width != 0) {
            long j2 = this.I;
            if (!(j2 == 0 || j2 == C.TIME_UNSET)) {
                return j2 / ((long) width);
            }
        }
        return Long.MAX_VALUE;
    }

    public final void h(long j2) {
        if (this.H != j2) {
            this.H = j2;
            Iterator<TimeBar.OnScrubListener> it = this.x.iterator();
            while (it.hasNext()) {
                it.next().onScrubMove(this, j2);
            }
        }
    }

    public void hideScrubber() {
        hideScrubber(0);
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.k;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        canvas.save();
        int height = this.b.height();
        int centerY = this.b.centerY() - (height / 2);
        int i3 = height + centerY;
        if (this.I <= 0) {
            Rect rect = this.b;
            canvas.drawRect((float) rect.left, (float) centerY, (float) rect.right, (float) i3, this.g);
        } else {
            Rect rect2 = this.c;
            int i4 = rect2.left;
            int i5 = rect2.right;
            int max = Math.max(Math.max(this.b.left, i5), this.d.right);
            int i6 = this.b.right;
            if (max < i6) {
                canvas.drawRect((float) max, (float) centerY, (float) i6, (float) i3, this.g);
            }
            int max2 = Math.max(i4, this.d.right);
            if (i5 > max2) {
                canvas.drawRect((float) max2, (float) centerY, (float) i5, (float) i3, this.f);
            }
            if (this.d.width() > 0) {
                Rect rect3 = this.d;
                canvas.drawRect((float) rect3.left, (float) centerY, (float) rect3.right, (float) i3, this.e);
            }
            if (this.L != 0) {
                long[] jArr = (long[]) Assertions.checkNotNull(this.M);
                boolean[] zArr = (boolean[]) Assertions.checkNotNull(this.N);
                int i7 = this.o / 2;
                for (int i8 = 0; i8 < this.L; i8++) {
                    long constrainValue = Util.constrainValue(jArr[i8], 0, this.I);
                    Rect rect4 = this.b;
                    int min = Math.min(rect4.width() - this.o, Math.max(0, ((int) ((((long) this.b.width()) * constrainValue) / this.I)) - i7)) + rect4.left;
                    canvas.drawRect((float) min, (float) centerY, (float) (min + this.o), (float) i3, zArr[i8] ? this.i : this.h);
                }
            }
        }
        if (this.I > 0) {
            Rect rect5 = this.d;
            int constrainValue2 = Util.constrainValue(rect5.right, rect5.left, this.b.right);
            int centerY2 = this.d.centerY();
            Drawable drawable = this.k;
            if (drawable == null) {
                if (this.G || isFocused()) {
                    i2 = this.r;
                } else {
                    i2 = isEnabled() ? this.p : this.q;
                }
                canvas.drawCircle((float) constrainValue2, (float) centerY2, (float) ((int) ((((float) i2) * this.F) / 2.0f)), this.j);
            } else {
                int intrinsicWidth = ((int) (((float) drawable.getIntrinsicWidth()) * this.F)) / 2;
                int intrinsicHeight = ((int) (((float) this.k.getIntrinsicHeight()) * this.F)) / 2;
                this.k.setBounds(constrainValue2 - intrinsicWidth, centerY2 - intrinsicHeight, constrainValue2 + intrinsicWidth, centerY2 + intrinsicHeight);
                this.k.draw(canvas);
            }
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z2, int i2, @Nullable Rect rect) {
        super.onFocusChanged(z2, i2, rect);
        if (this.G && !z2) {
            e(false);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.I > 0) {
            if (Util.SDK_INT >= 21) {
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
                return;
            }
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001a  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L_0x0030
            long r0 = r4.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r5 == r2) goto L_0x0027
            switch(r5) {
                case 21: goto L_0x0013;
                case 22: goto L_0x0014;
                case 23: goto L_0x0027;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0030
        L_0x0013:
            long r0 = -r0
        L_0x0014:
            boolean r0 = r4.c(r0)
            if (r0 == 0) goto L_0x0030
            java.lang.Runnable r5 = r4.w
            r4.removeCallbacks(r5)
            java.lang.Runnable r5 = r4.w
            r0 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r0)
            return r3
        L_0x0027:
            boolean r0 = r4.G
            if (r0 == 0) goto L_0x0030
            r5 = 0
            r4.e(r5)
            return r3
        L_0x0030:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
            switch-data {21->0x0013, 22->0x0014, 23->0x0027, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        Rect rect;
        int i7 = i4 - i2;
        int i8 = i5 - i3;
        int i9 = (i8 - this.m) / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i7 - getPaddingRight();
        int i10 = this.n;
        if (i10 == 1) {
            i6 = (this.m + i9) - ((this.l / 2) + (getPaddingBottom() + this.s));
        } else if (i10 == 2) {
            i6 = ((getPaddingTop() + i9) + this.s) - (this.l / 2);
        } else {
            i6 = a.R1(this.m, this.l, 2, i9);
        }
        this.a.set(paddingLeft, i9, paddingRight, this.m + i9);
        Rect rect2 = this.b;
        Rect rect3 = this.a;
        int i11 = rect3.left;
        int i12 = this.s;
        rect2.set(i11 + i12, i6, rect3.right - i12, this.l + i6);
        if (Util.SDK_INT >= 29 && !((rect = this.D) != null && rect.width() == i7 && this.D.height() == i8)) {
            Rect rect4 = new Rect(0, 0, i7, i8);
            this.D = rect4;
            setSystemGestureExclusionRects(Collections.singletonList(rect4));
        }
        f();
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == 0) {
            size = this.m;
        } else if (mode != 1073741824) {
            size = Math.min(this.m, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i2), size);
        g();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i2) {
        Drawable drawable = this.k;
        if (drawable != null) {
            if (Util.SDK_INT >= 23 && drawable.setLayoutDirection(i2)) {
                invalidate();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0033, code lost:
        if (r3 != 3) goto L_0x0089;
     */
    @Override // android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.isEnabled()
            r1 = 0
            if (r0 == 0) goto L_0x0089
            long r2 = r7.I
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x0011
            goto L_0x0089
        L_0x0011:
            android.graphics.Point r0 = r7.y
            float r2 = r8.getX()
            int r2 = (int) r2
            float r3 = r8.getY()
            int r3 = (int) r3
            r0.set(r2, r3)
            android.graphics.Point r0 = r7.y
            int r2 = r0.x
            int r0 = r0.y
            int r3 = r8.getAction()
            r4 = 1
            if (r3 == 0) goto L_0x006c
            r5 = 3
            if (r3 == r4) goto L_0x005d
            r6 = 2
            if (r3 == r6) goto L_0x0036
            if (r3 == r5) goto L_0x005d
            goto L_0x0089
        L_0x0036:
            boolean r8 = r7.G
            if (r8 == 0) goto L_0x0089
            int r8 = r7.t
            if (r0 >= r8) goto L_0x0049
            int r8 = r7.C
            int r8 = a2.b.a.a.a.R1(r2, r8, r5, r8)
            float r8 = (float) r8
            r7.b(r8)
            goto L_0x004f
        L_0x0049:
            r7.C = r2
            float r8 = (float) r2
            r7.b(r8)
        L_0x004f:
            long r0 = r7.getScrubberPosition()
            r7.h(r0)
            r7.f()
            r7.invalidate()
            return r4
        L_0x005d:
            boolean r0 = r7.G
            if (r0 == 0) goto L_0x0089
            int r8 = r8.getAction()
            if (r8 != r5) goto L_0x0068
            r1 = 1
        L_0x0068:
            r7.e(r1)
            return r4
        L_0x006c:
            float r8 = (float) r2
            float r0 = (float) r0
            android.graphics.Rect r2 = r7.a
            int r3 = (int) r8
            int r0 = (int) r0
            boolean r0 = r2.contains(r3, r0)
            if (r0 == 0) goto L_0x0089
            r7.b(r8)
            long r0 = r7.getScrubberPosition()
            r7.d(r0)
            r7.f()
            r7.invalidate()
            return r4
        L_0x0089:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i2, @Nullable Bundle bundle) {
        if (super.performAccessibilityAction(i2, bundle)) {
            return true;
        }
        if (this.I <= 0) {
            return false;
        }
        if (i2 == 8192) {
            if (c(-getPositionIncrement())) {
                e(false);
            }
        } else if (i2 != 4096) {
            return false;
        } else {
            if (c(getPositionIncrement())) {
                e(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void removeListener(TimeBar.OnScrubListener onScrubListener) {
        this.x.remove(onScrubListener);
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setAdGroupTimesMs(@Nullable long[] jArr, @Nullable boolean[] zArr, int i2) {
        Assertions.checkArgument(i2 == 0 || !(jArr == null || zArr == null));
        this.L = i2;
        this.M = jArr;
        this.N = zArr;
        f();
    }

    public void setAdMarkerColor(@ColorInt int i2) {
        this.h.setColor(i2);
        invalidate(this.a);
    }

    public void setBufferedColor(@ColorInt int i2) {
        this.f.setColor(i2);
        invalidate(this.a);
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setBufferedPosition(long j2) {
        this.K = j2;
        f();
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setDuration(long j2) {
        this.I = j2;
        if (this.G && j2 == C.TIME_UNSET) {
            e(true);
        }
        f();
    }

    @Override // android.view.View, com.google.android.exoplayer2.ui.TimeBar
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (this.G && !z2) {
            e(true);
        }
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setKeyCountIncrement(int i2) {
        Assertions.checkArgument(i2 > 0);
        this.A = i2;
        this.B = C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setKeyTimeIncrement(long j2) {
        Assertions.checkArgument(j2 > 0);
        this.A = -1;
        this.B = j2;
    }

    public void setPlayedAdMarkerColor(@ColorInt int i2) {
        this.i.setColor(i2);
        invalidate(this.a);
    }

    public void setPlayedColor(@ColorInt int i2) {
        this.e.setColor(i2);
        invalidate(this.a);
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setPosition(long j2) {
        this.J = j2;
        setContentDescription(getProgressText());
        f();
    }

    public void setScrubberColor(@ColorInt int i2) {
        this.j.setColor(i2);
        invalidate(this.a);
    }

    public void setUnplayedColor(@ColorInt int i2) {
        this.g.setColor(i2);
        invalidate(this.a);
    }

    public void showScrubber() {
        showScrubber(0);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void hideScrubber(long j2) {
        if (this.E.isStarted()) {
            this.E.cancel();
        }
        this.E.setFloatValues(this.F, 0.0f);
        this.E.setDuration(j2);
        this.E.start();
    }

    public void showScrubber(long j2) {
        if (this.E.isStarted()) {
            this.E.cancel();
        }
        this.E.setFloatValues(this.F, 1.0f);
        this.E.setDuration(j2);
        this.E.start();
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, attributeSet);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i2, @Nullable AttributeSet attributeSet2) {
        this(context, attributeSet, i2, attributeSet2, 0);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i2, @Nullable AttributeSet attributeSet2, int i3) {
        super(context, attributeSet, i2);
        this.a = new Rect();
        this.b = new Rect();
        this.c = new Rect();
        this.d = new Rect();
        Paint paint = new Paint();
        this.e = paint;
        Paint paint2 = new Paint();
        this.f = paint2;
        Paint paint3 = new Paint();
        this.g = paint3;
        Paint paint4 = new Paint();
        this.h = paint4;
        Paint paint5 = new Paint();
        this.i = paint5;
        Paint paint6 = new Paint();
        this.j = paint6;
        paint6.setAntiAlias(true);
        this.x = new CopyOnWriteArraySet<>();
        this.y = new Point();
        float f2 = context.getResources().getDisplayMetrics().density;
        this.z = f2;
        this.t = a(f2, -50);
        int a3 = a(f2, 4);
        int a4 = a(f2, 26);
        int a5 = a(f2, 4);
        int a6 = a(f2, 12);
        int a8 = a(f2, 0);
        int a9 = a(f2, 16);
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.DefaultTimeBar, i2, i3);
            try {
                Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.DefaultTimeBar_scrubber_drawable);
                this.k = drawable;
                if (drawable != null) {
                    int i4 = Util.SDK_INT;
                    if (i4 >= 23) {
                        int layoutDirection = getLayoutDirection();
                        if (i4 < 23 || !drawable.setLayoutDirection(layoutDirection)) {
                        }
                    }
                    a4 = Math.max(drawable.getMinimumHeight(), a4);
                }
                this.l = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_bar_height, a3);
                this.m = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_touch_target_height, a4);
                this.n = obtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_bar_gravity, 0);
                this.o = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_ad_marker_width, a5);
                this.p = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_scrubber_enabled_size, a6);
                this.q = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_scrubber_disabled_size, a8);
                this.r = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_scrubber_dragged_size, a9);
                int i5 = obtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_played_color, -1);
                int i6 = obtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_scrubber_color, -1);
                int i7 = obtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_buffered_color, DEFAULT_BUFFERED_COLOR);
                int i8 = obtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_unplayed_color, DEFAULT_UNPLAYED_COLOR);
                int i9 = obtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_ad_marker_color, DEFAULT_AD_MARKER_COLOR);
                int i10 = obtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_played_ad_marker_color, DEFAULT_PLAYED_AD_MARKER_COLOR);
                paint.setColor(i5);
                paint6.setColor(i6);
                paint2.setColor(i7);
                paint3.setColor(i8);
                paint4.setColor(i9);
                paint5.setColor(i10);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            this.l = a3;
            this.m = a4;
            this.n = 0;
            this.o = a5;
            this.p = a6;
            this.q = a8;
            this.r = a9;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(DEFAULT_BUFFERED_COLOR);
            paint3.setColor(DEFAULT_UNPLAYED_COLOR);
            paint4.setColor(DEFAULT_AD_MARKER_COLOR);
            paint5.setColor(DEFAULT_PLAYED_AD_MARKER_COLOR);
            this.k = null;
        }
        StringBuilder sb = new StringBuilder();
        this.u = sb;
        this.v = new Formatter(sb, Locale.getDefault());
        this.w = new Runnable() { // from class: a2.j.b.b.c1.b
            @Override // java.lang.Runnable
            public final void run() {
                DefaultTimeBar.this.e(false);
            }
        };
        Drawable drawable2 = this.k;
        if (drawable2 != null) {
            this.s = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.s = (Math.max(this.q, Math.max(this.p, this.r)) + 1) / 2;
        }
        this.F = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.E = valueAnimator;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: a2.j.b.b.c1.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                DefaultTimeBar defaultTimeBar = DefaultTimeBar.this;
                Objects.requireNonNull(defaultTimeBar);
                defaultTimeBar.F = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                defaultTimeBar.invalidate(defaultTimeBar.a);
            }
        });
        this.I = C.TIME_UNSET;
        this.B = C.TIME_UNSET;
        this.A = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }
}
