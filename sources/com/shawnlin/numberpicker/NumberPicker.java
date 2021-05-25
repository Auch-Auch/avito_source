package com.shawnlin.numberpicker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
public class NumberPicker extends LinearLayout {
    public static final int ASCENDING = 0;
    public static final b C0 = new b();
    public static final int CENTER = 1;
    public static final int DESCENDING = 1;
    public static final int HORIZONTAL = 0;
    public static final int LEFT = 2;
    public static final int RIGHT = 0;
    public static final int VERTICAL = 1;
    public OnValueChangeListener A;
    public NumberFormat A0;
    public OnScrollListener B;
    public ViewConfiguration B0;
    public Formatter C;
    public long D;
    public final SparseArray<String> E;
    public int F;
    public int G;
    public int H;
    public int[] I;
    public final Paint J;
    public int K;
    public int L;
    public int M;
    public final Scroller N;
    public final Scroller O;
    public int P;
    public int Q;
    public a R;
    public float S;
    public float T;
    public float U;
    public float V;
    public VelocityTracker W;
    public final EditText a;
    public int a0;
    public float b;
    public int b0;
    public float c;
    public int c0;
    public int d;
    public boolean d0;
    public int e;
    public boolean e0;
    public int f;
    public Drawable f0;
    public int g;
    public int g0;
    public final boolean h;
    public int h0;
    public int i;
    public int i0;
    public int j;
    public int j0;
    public float k;
    public int k0;
    public boolean l;
    public int l0;
    public boolean m;
    public int m0;
    public int n;
    public int n0;
    public int o;
    public int o0;
    public float p;
    public boolean p0;
    public boolean q;
    public float q0;
    public boolean r;
    public float r0;
    public Typeface s;
    public int s0;
    public int t;
    public int t0;
    public int u;
    public boolean u0;
    public String[] v;
    public float v0;
    public int w;
    public boolean w0;
    public int x;
    public float x0;
    public int y;
    public int y0;
    public View.OnClickListener z;
    public Context z0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Align {
    }

    public interface Formatter {
        String format(int i);
    }

    public interface OnScrollListener {
        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;

        @Retention(RetentionPolicy.SOURCE)
        public @interface ScrollState {
        }

        void onScrollStateChange(NumberPicker numberPicker, int i);
    }

    public interface OnValueChangeListener {
        void onValueChange(NumberPicker numberPicker, int i, int i2);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Order {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    public class a implements Runnable {
        public boolean a;

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NumberPicker numberPicker = NumberPicker.this;
            boolean z = this.a;
            int i = NumberPicker.VERTICAL;
            numberPicker.a(z);
            NumberPicker numberPicker2 = NumberPicker.this;
            numberPicker2.postDelayed(this, numberPicker2.D);
        }
    }

    public static class b implements Formatter {
        public final StringBuilder a;
        public char b;
        public java.util.Formatter c;
        public final Object[] d = new Object[1];

        public b() {
            StringBuilder sb = new StringBuilder();
            this.a = sb;
            Locale locale = Locale.getDefault();
            this.c = new java.util.Formatter(sb, locale);
            this.b = new DecimalFormatSymbols(locale).getZeroDigit();
        }

        @Override // com.shawnlin.numberpicker.NumberPicker.Formatter
        public String format(int i) {
            Locale locale = Locale.getDefault();
            if (this.b != new DecimalFormatSymbols(locale).getZeroDigit()) {
                this.c = new java.util.Formatter(this.a, locale);
                this.b = new DecimalFormatSymbols(locale).getZeroDigit();
            }
            this.d[0] = Integer.valueOf(i);
            StringBuilder sb = this.a;
            sb.delete(0, sb.length());
            this.c.format("%02d", this.d);
            return this.c.toString();
        }
    }

    public NumberPicker(Context context) {
        this(context, null);
    }

    private float getMaxTextSize() {
        return Math.max(this.p, this.k);
    }

    private int[] getSelectorIndices() {
        return this.I;
    }

    public static final Formatter getTwoDigitFormatter() {
        return C0;
    }

    public static int resolveSizeAndState(int i2, int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 1073741824) {
                i2 = size;
            }
        } else if (size < i2) {
            i2 = 16777216 | size;
        }
        return i2 | (-16777216 & i4);
    }

    public final void a(boolean z2) {
        if (!n(this.N)) {
            n(this.O);
        }
        smoothScroll(z2, 1);
    }

    public final void b(int[] iArr) {
        for (int length = iArr.length - 1; length > 0; length--) {
            iArr[length] = iArr[length - 1];
        }
        int i2 = iArr[1] - 1;
        if (this.d0 && i2 < this.w) {
            i2 = this.x;
        }
        iArr[0] = i2;
        d(i2);
    }

    public final float c(float f2) {
        return f2 * getResources().getDisplayMetrics().density;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return isHorizontalMode() ? getWidth() : getHeight();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        if (isHorizontalMode()) {
            return this.M;
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        if (isHorizontalMode()) {
            return ((this.x - this.w) + 1) * this.K;
        }
        return 0;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (isScrollerEnabled()) {
            Scroller scroller = this.N;
            if (scroller.isFinished()) {
                scroller = this.O;
                if (scroller.isFinished()) {
                    return;
                }
            }
            scroller.computeScrollOffset();
            if (isHorizontalMode()) {
                int currX = scroller.getCurrX();
                if (this.P == 0) {
                    this.P = scroller.getStartX();
                }
                scrollBy(currX - this.P, 0);
                this.P = currX;
            } else {
                int currY = scroller.getCurrY();
                if (this.Q == 0) {
                    this.Q = scroller.getStartY();
                }
                scrollBy(0, currY - this.Q);
                this.Q = currY;
            }
            if (!scroller.isFinished()) {
                postInvalidate();
            } else if (scroller == this.N) {
                e();
                w();
                p(0);
            } else if (this.n0 != 1) {
                w();
            }
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return isHorizontalMode() ? getWidth() : getHeight();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        if (!isHorizontalMode()) {
            return this.M;
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        if (!isHorizontalMode()) {
            return ((this.x - this.w) + 1) * this.K;
        }
        return 0;
    }

    public final void d(int i2) {
        String str;
        SparseArray<String> sparseArray = this.E;
        if (sparseArray.get(i2) == null) {
            int i3 = this.w;
            if (i2 < i3 || i2 > this.x) {
                str = "";
            } else {
                String[] strArr = this.v;
                str = strArr != null ? strArr[i2 - i3] : g(i2);
            }
            sparseArray.put(i2, str);
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19 || keyCode == 20) {
            int action = keyEvent.getAction();
            if (action == 0) {
                if (!this.d0) {
                    if (keyCode == 20) {
                    }
                }
                requestFocus();
                this.o0 = keyCode;
                r();
                if (this.N.isFinished()) {
                    a(keyCode == 20);
                }
                return true;
            } else if (action == 1 && this.o0 == keyCode) {
                this.o0 = -1;
                return true;
            }
        } else if (keyCode == 23 || keyCode == 66) {
            r();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View, android.view.ViewGroup
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            r();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View, android.view.ViewGroup
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            r();
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.View, android.view.ViewGroup
    @CallSuper
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f0;
        if (drawable != null && drawable.isStateful() && drawable.setState(getDrawableState())) {
            invalidateDrawable(drawable);
        }
    }

    public final boolean e() {
        int i2 = this.L - this.M;
        if (i2 == 0) {
            return false;
        }
        int abs = Math.abs(i2);
        int i3 = this.K;
        if (abs > i3 / 2) {
            if (i2 > 0) {
                i3 = -i3;
            }
            i2 += i3;
        }
        if (isHorizontalMode()) {
            this.P = 0;
            this.O.startScroll(0, 0, i2, 0, 800);
        } else {
            this.Q = 0;
            this.O.startScroll(0, 0, 0, i2, 800);
        }
        invalidate();
        return true;
    }

    public final void f(int i2) {
        if (isHorizontalMode()) {
            this.P = 0;
            if (i2 > 0) {
                this.N.fling(0, 0, i2, 0, 0, Integer.MAX_VALUE, 0, 0);
            } else {
                this.N.fling(Integer.MAX_VALUE, 0, i2, 0, 0, Integer.MAX_VALUE, 0, 0);
            }
        } else {
            this.Q = 0;
            if (i2 > 0) {
                this.N.fling(0, 0, 0, i2, 0, 0, 0, Integer.MAX_VALUE);
            } else {
                this.N.fling(0, Integer.MAX_VALUE, 0, i2, 0, 0, 0, Integer.MAX_VALUE);
            }
        }
        invalidate();
    }

    public final String g(int i2) {
        Formatter formatter = this.C;
        if (formatter != null) {
            return formatter.format(i2);
        }
        return this.A0.format((long) i2);
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        return h(!isHorizontalMode());
    }

    public String[] getDisplayedValues() {
        return this.v;
    }

    public int getDividerColor() {
        return this.g0;
    }

    public float getDividerDistance() {
        return ((float) this.h0) / getResources().getDisplayMetrics().density;
    }

    public float getDividerThickness() {
        return ((float) this.i0) / getResources().getDisplayMetrics().density;
    }

    public float getFadingEdgeStrength() {
        return this.v0;
    }

    public Formatter getFormatter() {
        return this.C;
    }

    @Override // android.view.View
    public float getLeftFadingEdgeStrength() {
        return h(isHorizontalMode());
    }

    public float getLineSpacingMultiplier() {
        return this.x0;
    }

    public int getMaxFlingVelocityCoefficient() {
        return this.y0;
    }

    public int getMaxValue() {
        return this.x;
    }

    public int getMinValue() {
        return this.w;
    }

    public int getOrder() {
        return this.t0;
    }

    @Override // android.widget.LinearLayout
    public int getOrientation() {
        return this.s0;
    }

    @Override // android.view.View
    public float getRightFadingEdgeStrength() {
        return h(isHorizontalMode());
    }

    public int getSelectedTextAlign() {
        return this.i;
    }

    public int getSelectedTextColor() {
        return this.j;
    }

    public float getSelectedTextSize() {
        return this.k;
    }

    public boolean getSelectedTextStrikeThru() {
        return this.l;
    }

    public boolean getSelectedTextUnderline() {
        return this.m;
    }

    public int getTextAlign() {
        return this.n;
    }

    public int getTextColor() {
        return this.o;
    }

    public float getTextSize() {
        return u(this.p);
    }

    public boolean getTextStrikeThru() {
        return this.q;
    }

    public boolean getTextUnderline() {
        return this.r;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        return h(!isHorizontalMode());
    }

    public Typeface getTypeface() {
        return this.s;
    }

    public int getValue() {
        return this.y;
    }

    public int getWheelItemCount() {
        return this.F;
    }

    public boolean getWrapSelectorWheel() {
        return this.d0;
    }

    public final float h(boolean z2) {
        if (!z2 || !this.u0) {
            return 0.0f;
        }
        return this.v0;
    }

    public final int i(int i2) {
        int i3 = this.x;
        if (i2 > i3) {
            int i4 = this.w;
            return (((i2 - i3) % (i3 - i4)) + i4) - 1;
        }
        int i5 = this.w;
        return i2 < i5 ? (i3 - ((i5 - i2) % (i3 - i5))) + 1 : i2;
    }

    public boolean isAscendingOrder() {
        return getOrder() == 0;
    }

    public boolean isFadingEdgeEnabled() {
        return this.u0;
    }

    public boolean isHorizontalMode() {
        return getOrientation() == 0;
    }

    public boolean isScrollerEnabled() {
        return this.w0;
    }

    public final void j(int[] iArr) {
        int i2 = 0;
        while (i2 < iArr.length - 1) {
            int i3 = i2 + 1;
            iArr[i2] = iArr[i3];
            i2 = i3;
        }
        int i4 = iArr[iArr.length - 2] + 1;
        if (this.d0 && i4 > this.x) {
            i4 = this.w;
        }
        iArr[iArr.length - 1] = i4;
        d(i4);
    }

    @Override // android.view.View, android.view.ViewGroup
    @CallSuper
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f0;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public final void k() {
        this.E.clear();
        int[] selectorIndices = getSelectorIndices();
        int value = getValue();
        for (int i2 = 0; i2 < this.I.length; i2++) {
            int i3 = (i2 - this.H) + value;
            if (this.d0) {
                i3 = i(i3);
            }
            selectorIndices[i2] = i3;
            d(selectorIndices[i2]);
        }
    }

    public final boolean l() {
        return this.x - this.w >= this.I.length - 1;
    }

    public final int m(int i2, int i3) {
        if (i3 == -1) {
            return i2;
        }
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i3), 1073741824);
        }
        if (mode == 0) {
            return View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        }
        if (mode == 1073741824) {
            return i2;
        }
        throw new IllegalArgumentException(a2.b.a.a.a.M2("Unknown measure mode: ", mode));
    }

    public final boolean n(Scroller scroller) {
        scroller.forceFinished(true);
        if (isHorizontalMode()) {
            int finalX = scroller.getFinalX() - scroller.getCurrX();
            int i2 = this.L - ((this.M + finalX) % this.K);
            if (i2 != 0) {
                int abs = Math.abs(i2);
                int i3 = this.K;
                if (abs > i3 / 2) {
                    i2 = i2 > 0 ? i2 - i3 : i2 + i3;
                }
                scrollBy(finalX + i2, 0);
                return true;
            }
        } else {
            int finalY = scroller.getFinalY() - scroller.getCurrY();
            int i4 = this.L - ((this.M + finalY) % this.K);
            if (i4 != 0) {
                int abs2 = Math.abs(i4);
                int i5 = this.K;
                if (abs2 > i5 / 2) {
                    i4 = i4 > 0 ? i4 - i5 : i4 + i5;
                }
                scrollBy(0, finalY + i4);
                return true;
            }
        }
        return false;
    }

    public final void o(int i2) {
        OnValueChangeListener onValueChangeListener = this.A;
        if (onValueChangeListener != null) {
            onValueChangeListener.onValueChange(this, i2, this.y);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.A0 = NumberFormat.getInstance();
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        r();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        float f5;
        canvas.save();
        boolean hasFocus = this.p0 ? hasFocus() : true;
        if (isHorizontalMode()) {
            f3 = (float) this.M;
            f2 = (float) (this.a.getTop() + this.a.getBaseline());
            if (this.G < 3) {
                canvas.clipRect(this.l0, 0, this.m0, getBottom());
            }
        } else {
            f3 = (float) ((getRight() - getLeft()) / 2);
            f2 = (float) this.M;
            if (this.G < 3) {
                canvas.clipRect(0, this.j0, getRight(), this.k0);
            }
        }
        int[] selectorIndices = getSelectorIndices();
        for (int i2 = 0; i2 < selectorIndices.length; i2++) {
            if (i2 == this.H) {
                this.J.setTextAlign(Paint.Align.values()[this.i]);
                this.J.setTextSize(this.k);
                this.J.setColor(this.j);
                this.J.setStrikeThruText(this.l);
                this.J.setUnderlineText(this.m);
            } else {
                this.J.setTextAlign(Paint.Align.values()[this.n]);
                this.J.setTextSize(this.p);
                this.J.setColor(this.o);
                this.J.setStrikeThruText(this.q);
                this.J.setUnderlineText(this.r);
            }
            String str = this.E.get(selectorIndices[isAscendingOrder() ? i2 : (selectorIndices.length - i2) - 1]);
            if ((hasFocus && i2 != this.H) || (i2 == this.H && this.a.getVisibility() != 0)) {
                if (!isHorizontalMode()) {
                    Paint.FontMetrics fontMetrics = this.J.getFontMetrics();
                    if (fontMetrics == null) {
                        f5 = 0.0f;
                    } else {
                        f5 = Math.abs(fontMetrics.top + fontMetrics.bottom) / 2.0f;
                    }
                    f4 = f5 + f2;
                } else {
                    f4 = f2;
                }
                Paint paint = this.J;
                if (str.contains("\n")) {
                    String[] split = str.split("\n");
                    float abs = Math.abs(paint.ascent() + paint.descent()) * this.x0;
                    float length = f4 - ((((float) (split.length - 1)) * abs) / 2.0f);
                    for (String str2 : split) {
                        canvas.drawText(str2, f3, length, paint);
                        length += abs;
                    }
                } else {
                    canvas.drawText(str, f3, f4, paint);
                }
            }
            if (isHorizontalMode()) {
                f3 += (float) this.K;
            } else {
                f2 += (float) this.K;
            }
        }
        canvas.restore();
        if (hasFocus && this.f0 != null) {
            if (isHorizontalMode()) {
                int bottom = getBottom();
                int i3 = this.l0;
                this.f0.setBounds(i3, 0, this.i0 + i3, bottom);
                this.f0.draw(canvas);
                int i4 = this.m0;
                this.f0.setBounds(i4 - this.i0, 0, i4, bottom);
                this.f0.draw(canvas);
                return;
            }
            int right = getRight();
            int i5 = this.j0;
            this.f0.setBounds(0, i5, right, this.i0 + i5);
            this.f0.draw(canvas);
            int i6 = this.k0;
            this.f0.setBounds(0, i6 - this.i0, right, i6);
            this.f0.draw(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(NumberPicker.class.getName());
        accessibilityEvent.setScrollable(isScrollerEnabled());
        int i2 = this.w;
        int i3 = this.K;
        int i4 = (this.y + i2) * i3;
        int i5 = (this.x - i2) * i3;
        if (isHorizontalMode()) {
            accessibilityEvent.setScrollX(i4);
            accessibilityEvent.setMaxScrollX(i5);
            return;
        }
        accessibilityEvent.setScrollY(i4);
        accessibilityEvent.setMaxScrollY(i5);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || (motionEvent.getAction() & 255) != 0) {
            return false;
        }
        r();
        getParent().requestDisallowInterceptTouchEvent(true);
        if (isHorizontalMode()) {
            float x2 = motionEvent.getX();
            this.S = x2;
            this.U = x2;
            if (!this.N.isFinished()) {
                this.N.forceFinished(true);
                this.O.forceFinished(true);
                p(0);
            } else if (!this.O.isFinished()) {
                this.N.forceFinished(true);
                this.O.forceFinished(true);
            } else {
                float f2 = this.S;
                int i2 = this.l0;
                if (f2 >= ((float) i2) && f2 <= ((float) this.m0)) {
                    View.OnClickListener onClickListener = this.z;
                    if (onClickListener != null) {
                        onClickListener.onClick(this);
                    }
                } else if (f2 < ((float) i2)) {
                    q(false);
                } else if (f2 > ((float) this.m0)) {
                    q(true);
                }
            }
        } else {
            float y2 = motionEvent.getY();
            this.T = y2;
            this.V = y2;
            if (!this.N.isFinished()) {
                this.N.forceFinished(true);
                this.O.forceFinished(true);
                p(0);
            } else if (!this.O.isFinished()) {
                this.N.forceFinished(true);
                this.O.forceFinished(true);
            } else {
                float f3 = this.T;
                int i3 = this.j0;
                if (f3 >= ((float) i3) && f3 <= ((float) this.k0)) {
                    View.OnClickListener onClickListener2 = this.z;
                    if (onClickListener2 != null) {
                        onClickListener2.onClick(this);
                    }
                } else if (f3 < ((float) i3)) {
                    q(false);
                } else if (f3 > ((float) this.k0)) {
                    q(true);
                }
            }
        }
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.View, android.view.ViewGroup
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int measuredWidth2 = this.a.getMeasuredWidth();
        int measuredHeight2 = this.a.getMeasuredHeight();
        int i6 = (measuredWidth - measuredWidth2) / 2;
        int i7 = (measuredHeight - measuredHeight2) / 2;
        this.a.layout(i6, i7, measuredWidth2 + i6, measuredHeight2 + i7);
        this.b = this.a.getX() + ((float) (this.a.getMeasuredWidth() / 2));
        this.c = this.a.getY() + ((float) (this.a.getMeasuredHeight() / 2));
        if (z2) {
            k();
            int[] selectorIndices = getSelectorIndices();
            int length = ((selectorIndices.length - 1) * ((int) this.p)) + ((int) this.k);
            float length2 = (float) selectorIndices.length;
            if (isHorizontalMode()) {
                this.t = (int) (((float) ((getRight() - getLeft()) - length)) / length2);
                int maxTextSize = ((int) getMaxTextSize()) + this.t;
                this.K = maxTextSize;
                this.L = ((int) this.b) - (maxTextSize * this.H);
            } else {
                this.u = (int) (((float) ((getBottom() - getTop()) - length)) / length2);
                int maxTextSize2 = ((int) getMaxTextSize()) + this.u;
                this.K = maxTextSize2;
                this.L = ((int) this.c) - (maxTextSize2 * this.H);
            }
            this.M = this.L;
            w();
            if (isHorizontalMode()) {
                setHorizontalFadingEdgeEnabled(true);
                setFadingEdgeLength(((getRight() - getLeft()) - ((int) this.p)) / 2);
            } else {
                setVerticalFadingEdgeEnabled(true);
                setFadingEdgeLength(((getBottom() - getTop()) - ((int) this.p)) / 2);
            }
            int i8 = (this.i0 * 2) + this.h0;
            if (isHorizontalMode()) {
                int width = ((getWidth() - this.h0) / 2) - this.i0;
                this.l0 = width;
                this.m0 = width + i8;
                return;
            }
            int height = ((getHeight() - this.h0) / 2) - this.i0;
            this.j0 = height;
            this.k0 = height + i8;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(m(i2, this.g), m(i3, this.e));
        int i4 = this.f;
        int measuredWidth = getMeasuredWidth();
        if (i4 != -1) {
            measuredWidth = resolveSizeAndState(Math.max(i4, measuredWidth), i2, 0);
        }
        int i5 = this.d;
        int measuredHeight = getMeasuredHeight();
        if (i5 != -1) {
            measuredHeight = resolveSizeAndState(Math.max(i5, measuredHeight), i3, 0);
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !isScrollerEnabled()) {
            return false;
        }
        if (this.W == null) {
            this.W = VelocityTracker.obtain();
        }
        this.W.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 1) {
            a aVar = this.R;
            if (aVar != null) {
                removeCallbacks(aVar);
            }
            VelocityTracker velocityTracker = this.W;
            velocityTracker.computeCurrentVelocity(1000, (float) this.c0);
            if (isHorizontalMode()) {
                int xVelocity = (int) velocityTracker.getXVelocity();
                if (Math.abs(xVelocity) > this.b0) {
                    f(xVelocity);
                    p(2);
                } else {
                    int x2 = (int) motionEvent.getX();
                    if (((int) Math.abs(((float) x2) - this.S)) <= this.a0) {
                        int i2 = (x2 / this.K) - this.H;
                        if (i2 > 0) {
                            a(true);
                        } else if (i2 < 0) {
                            a(false);
                        } else {
                            e();
                        }
                    } else {
                        e();
                    }
                    p(0);
                }
            } else {
                int yVelocity = (int) velocityTracker.getYVelocity();
                if (Math.abs(yVelocity) > this.b0) {
                    f(yVelocity);
                    p(2);
                } else {
                    int y2 = (int) motionEvent.getY();
                    if (((int) Math.abs(((float) y2) - this.T)) <= this.a0) {
                        int i3 = (y2 / this.K) - this.H;
                        if (i3 > 0) {
                            a(true);
                        } else if (i3 < 0) {
                            a(false);
                        } else {
                            e();
                        }
                    } else {
                        e();
                    }
                    p(0);
                }
            }
            this.W.recycle();
            this.W = null;
        } else if (action == 2) {
            if (isHorizontalMode()) {
                float x3 = motionEvent.getX();
                if (this.n0 == 1) {
                    scrollBy((int) (x3 - this.U), 0);
                    invalidate();
                } else if (((int) Math.abs(x3 - this.S)) > this.a0) {
                    r();
                    p(1);
                }
                this.U = x3;
            } else {
                float y3 = motionEvent.getY();
                if (this.n0 == 1) {
                    scrollBy(0, (int) (y3 - this.V));
                    invalidate();
                } else if (((int) Math.abs(y3 - this.T)) > this.a0) {
                    r();
                    p(1);
                }
                this.V = y3;
            }
        }
        return true;
    }

    public final void p(int i2) {
        if (this.n0 != i2) {
            this.n0 = i2;
            OnScrollListener onScrollListener = this.B;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChange(this, i2);
            }
        }
    }

    public final void q(boolean z2) {
        long longPressTimeout = (long) ViewConfiguration.getLongPressTimeout();
        Runnable runnable = this.R;
        if (runnable == null) {
            this.R = new a();
        } else {
            removeCallbacks(runnable);
        }
        a aVar = this.R;
        aVar.a = z2;
        postDelayed(aVar, longPressTimeout);
    }

    public final void r() {
        a aVar = this.R;
        if (aVar != null) {
            removeCallbacks(aVar);
        }
    }

    public final void s(int i2, boolean z2) {
        int i3;
        if (this.y != i2) {
            if (this.d0) {
                i3 = i(i2);
            } else {
                i3 = Math.min(Math.max(i2, this.w), this.x);
            }
            int i4 = this.y;
            this.y = i3;
            if (this.n0 != 2) {
                w();
            }
            if (z2) {
                o(i4);
            }
            k();
            setContentDescription(String.valueOf(getValue()));
            invalidate();
        }
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        int i4;
        int i5;
        if (isScrollerEnabled()) {
            int[] selectorIndices = getSelectorIndices();
            int i6 = this.M;
            if (isHorizontalMode()) {
                if (isAscendingOrder()) {
                    boolean z2 = this.d0;
                    if (!z2 && i2 > 0 && selectorIndices[this.H] <= this.w) {
                        this.M = this.L;
                        return;
                    } else if (!z2 && i2 < 0 && selectorIndices[this.H] >= this.x) {
                        this.M = this.L;
                        return;
                    }
                } else {
                    boolean z3 = this.d0;
                    if (!z3 && i2 > 0 && selectorIndices[this.H] >= this.x) {
                        this.M = this.L;
                        return;
                    } else if (!z3 && i2 < 0 && selectorIndices[this.H] <= this.w) {
                        this.M = this.L;
                        return;
                    }
                }
                this.M += i2;
                i4 = this.t;
            } else {
                if (isAscendingOrder()) {
                    boolean z4 = this.d0;
                    if (!z4 && i3 > 0 && selectorIndices[this.H] <= this.w) {
                        this.M = this.L;
                        return;
                    } else if (!z4 && i3 < 0 && selectorIndices[this.H] >= this.x) {
                        this.M = this.L;
                        return;
                    }
                } else {
                    boolean z5 = this.d0;
                    if (!z5 && i3 > 0 && selectorIndices[this.H] >= this.x) {
                        this.M = this.L;
                        return;
                    } else if (!z5 && i3 < 0 && selectorIndices[this.H] <= this.w) {
                        this.M = this.L;
                        return;
                    }
                }
                this.M += i3;
                i4 = this.u;
            }
            while (true) {
                int i7 = this.M;
                if (i7 - this.L <= i4) {
                    break;
                }
                this.M = i7 - this.K;
                if (isAscendingOrder()) {
                    b(selectorIndices);
                } else {
                    j(selectorIndices);
                }
                s(selectorIndices[this.H], true);
                if (!this.d0 && selectorIndices[this.H] < this.w) {
                    this.M = this.L;
                }
            }
            while (true) {
                i5 = this.M;
                if (i5 - this.L >= (-i4)) {
                    break;
                }
                this.M = i5 + this.K;
                if (isAscendingOrder()) {
                    j(selectorIndices);
                } else {
                    b(selectorIndices);
                }
                s(selectorIndices[this.H], true);
                if (!this.d0 && selectorIndices[this.H] > this.x) {
                    this.M = this.L;
                }
            }
            if (i6 == i5) {
                return;
            }
            if (isHorizontalMode()) {
                onScrollChanged(this.M, 0, i6, 0);
            } else {
                onScrollChanged(0, this.M, 0, i6);
            }
        }
    }

    public void setDisplayedValues(String[] strArr) {
        if (this.v != strArr) {
            this.v = strArr;
            if (strArr != null) {
                this.a.setRawInputType(655360);
            } else {
                this.a.setRawInputType(2);
            }
            w();
            k();
            v();
        }
    }

    public void setDividerColor(@ColorInt int i2) {
        this.g0 = i2;
        this.f0 = new ColorDrawable(i2);
    }

    public void setDividerColorResource(@ColorRes int i2) {
        setDividerColor(ContextCompat.getColor(this.z0, i2));
    }

    public void setDividerDistance(int i2) {
        this.h0 = i2;
    }

    public void setDividerDistanceResource(@DimenRes int i2) {
        setDividerDistance(getResources().getDimensionPixelSize(i2));
    }

    public void setDividerThickness(int i2) {
        this.i0 = i2;
    }

    public void setDividerThicknessResource(@DimenRes int i2) {
        setDividerThickness(getResources().getDimensionPixelSize(i2));
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        this.a.setEnabled(z2);
    }

    public void setFadingEdgeEnabled(boolean z2) {
        this.u0 = z2;
    }

    public void setFadingEdgeStrength(float f2) {
        this.v0 = f2;
    }

    public void setFormatter(Formatter formatter) {
        if (formatter != this.C) {
            this.C = formatter;
            k();
            w();
        }
    }

    public void setLineSpacingMultiplier(float f2) {
        this.x0 = f2;
    }

    public void setMaxFlingVelocityCoefficient(int i2) {
        this.y0 = i2;
        this.c0 = this.B0.getScaledMaximumFlingVelocity() / this.y0;
    }

    public void setMaxValue(int i2) {
        if (i2 >= 0) {
            this.x = i2;
            if (i2 < this.y) {
                this.y = i2;
            }
            this.d0 = l() && this.e0;
            k();
            w();
            v();
            invalidate();
            return;
        }
        throw new IllegalArgumentException("maxValue must be >= 0");
    }

    public void setMinValue(int i2) {
        this.w = i2;
        if (i2 > this.y) {
            this.y = i2;
        }
        setWrapSelectorWheel(l());
        k();
        w();
        v();
        invalidate();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.z = onClickListener;
    }

    public void setOnLongPressUpdateInterval(long j2) {
        this.D = j2;
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.B = onScrollListener;
    }

    public void setOnValueChangedListener(OnValueChangeListener onValueChangeListener) {
        this.A = onValueChangeListener;
    }

    public void setOrder(int i2) {
        this.t0 = i2;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i2) {
        this.s0 = i2;
        t();
    }

    public void setScrollerEnabled(boolean z2) {
        this.w0 = z2;
    }

    public void setSelectedTextAlign(int i2) {
        this.i = i2;
    }

    public void setSelectedTextColor(@ColorInt int i2) {
        this.j = i2;
        this.a.setTextColor(i2);
    }

    public void setSelectedTextColorResource(@ColorRes int i2) {
        setSelectedTextColor(ContextCompat.getColor(this.z0, i2));
    }

    public void setSelectedTextSize(float f2) {
        this.k = f2;
        this.a.setTextSize(f2 / getResources().getDisplayMetrics().scaledDensity);
    }

    public void setSelectedTextStrikeThru(boolean z2) {
        this.l = z2;
    }

    public void setSelectedTextUnderline(boolean z2) {
        this.m = z2;
    }

    public void setTextAlign(int i2) {
        this.n = i2;
    }

    public void setTextColor(@ColorInt int i2) {
        this.o = i2;
        this.J.setColor(i2);
    }

    public void setTextColorResource(@ColorRes int i2) {
        setTextColor(ContextCompat.getColor(this.z0, i2));
    }

    public void setTextSize(float f2) {
        this.p = f2;
        this.J.setTextSize(f2);
    }

    public void setTextStrikeThru(boolean z2) {
        this.q = z2;
    }

    public void setTextUnderline(boolean z2) {
        this.r = z2;
    }

    public void setTypeface(Typeface typeface) {
        this.s = typeface;
        if (typeface != null) {
            this.a.setTypeface(typeface);
            this.J.setTypeface(this.s);
            return;
        }
        this.a.setTypeface(Typeface.MONOSPACE);
        this.J.setTypeface(Typeface.MONOSPACE);
    }

    public void setValue(int i2) {
        s(i2, false);
    }

    public void setWheelItemCount(int i2) {
        if (i2 >= 1) {
            this.G = i2;
            if (i2 < 3) {
                i2 = 3;
            }
            this.F = i2;
            this.H = i2 / 2;
            this.I = new int[i2];
            return;
        }
        throw new IllegalArgumentException("Wheel item count must be >= 1");
    }

    public void setWrapSelectorWheel(boolean z2) {
        this.e0 = z2;
        this.d0 = l() && this.e0;
    }

    public void smoothScroll(boolean z2, int i2) {
        if (isHorizontalMode()) {
            this.P = 0;
            if (z2) {
                this.N.startScroll(0, 0, (-this.K) * i2, 0, 300);
            } else {
                this.N.startScroll(0, 0, this.K * i2, 0, 300);
            }
        } else {
            this.Q = 0;
            if (z2) {
                this.N.startScroll(0, 0, 0, (-this.K) * i2, 300);
            } else {
                this.N.startScroll(0, 0, 0, this.K * i2, 300);
            }
        }
        invalidate();
    }

    public void smoothScrollToPosition(int i2) {
        int i3 = getSelectorIndices()[this.H];
        if (i3 != i2) {
            smoothScroll(i2 > i3, Math.abs(i2 - i3));
        }
    }

    public final void t() {
        if (isHorizontalMode()) {
            this.d = -1;
            this.e = (int) c(64.0f);
            this.f = (int) c(180.0f);
            this.g = -1;
            return;
        }
        this.d = -1;
        this.e = (int) c(180.0f);
        this.f = (int) c(64.0f);
        this.g = -1;
    }

    public final float u(float f2) {
        return TypedValue.applyDimension(2, f2, getResources().getDisplayMetrics());
    }

    public final void v() {
        int i2;
        if (this.h) {
            this.J.setTextSize(getMaxTextSize());
            String[] strArr = this.v;
            int i3 = 0;
            if (strArr == null) {
                float f2 = 0.0f;
                for (int i4 = 0; i4 <= 9; i4++) {
                    float measureText = this.J.measureText(g(i4));
                    if (measureText > f2) {
                        f2 = measureText;
                    }
                }
                for (int i5 = this.x; i5 > 0; i5 /= 10) {
                    i3++;
                }
                i2 = (int) (((float) i3) * f2);
            } else {
                int length = strArr.length;
                int i6 = 0;
                while (i3 < length) {
                    float measureText2 = this.J.measureText(this.v[i3]);
                    if (measureText2 > ((float) i6)) {
                        i6 = (int) measureText2;
                    }
                    i3++;
                }
                i2 = i6;
            }
            int paddingRight = this.a.getPaddingRight() + this.a.getPaddingLeft() + i2;
            if (this.g != paddingRight) {
                int i7 = this.f;
                if (paddingRight > i7) {
                    this.g = paddingRight;
                } else {
                    this.g = i7;
                }
                invalidate();
            }
        }
    }

    public final boolean w() {
        String[] strArr = this.v;
        String g2 = strArr == null ? g(this.y) : strArr[this.y - this.w];
        if (TextUtils.isEmpty(g2) || g2.equals(this.a.getText().toString())) {
            return false;
        }
        this.a.setText(g2);
        return true;
    }

    public NumberPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NumberPicker(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        a2.o.a.a aVar;
        this.i = 1;
        this.j = ViewCompat.MEASURED_STATE_MASK;
        this.k = 25.0f;
        this.n = 1;
        this.o = ViewCompat.MEASURED_STATE_MASK;
        this.p = 25.0f;
        this.w = 1;
        this.x = 100;
        this.D = 300;
        this.E = new SparseArray<>();
        this.F = 3;
        this.G = 3;
        this.H = 1;
        this.I = new int[3];
        this.L = Integer.MIN_VALUE;
        this.e0 = true;
        this.g0 = ViewCompat.MEASURED_STATE_MASK;
        this.n0 = 0;
        this.o0 = -1;
        this.u0 = true;
        this.v0 = 0.9f;
        this.w0 = true;
        this.x0 = 1.0f;
        this.y0 = 8;
        this.z0 = context;
        this.A0 = NumberFormat.getInstance();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NumberPicker, i2, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.NumberPicker_np_divider);
        if (drawable != null) {
            drawable.setCallback(this);
            if (drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
            this.f0 = drawable;
        } else {
            int color = obtainStyledAttributes.getColor(R.styleable.NumberPicker_np_dividerColor, this.g0);
            this.g0 = color;
            setDividerColor(color);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.h0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NumberPicker_np_dividerDistance, (int) TypedValue.applyDimension(1, 48.0f, displayMetrics));
        this.i0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NumberPicker_np_dividerThickness, (int) TypedValue.applyDimension(1, 2.0f, displayMetrics));
        this.t0 = obtainStyledAttributes.getInt(R.styleable.NumberPicker_np_order, 0);
        this.s0 = obtainStyledAttributes.getInt(R.styleable.NumberPicker_np_orientation, 1);
        this.q0 = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.NumberPicker_np_width, -1);
        this.r0 = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.NumberPicker_np_height, -1);
        t();
        this.h = true;
        this.y = obtainStyledAttributes.getInt(R.styleable.NumberPicker_np_value, this.y);
        this.x = obtainStyledAttributes.getInt(R.styleable.NumberPicker_np_max, this.x);
        this.w = obtainStyledAttributes.getInt(R.styleable.NumberPicker_np_min, this.w);
        this.i = obtainStyledAttributes.getInt(R.styleable.NumberPicker_np_selectedTextAlign, this.i);
        this.j = obtainStyledAttributes.getColor(R.styleable.NumberPicker_np_selectedTextColor, this.j);
        this.k = obtainStyledAttributes.getDimension(R.styleable.NumberPicker_np_selectedTextSize, u(this.k));
        this.l = obtainStyledAttributes.getBoolean(R.styleable.NumberPicker_np_selectedTextStrikeThru, this.l);
        this.m = obtainStyledAttributes.getBoolean(R.styleable.NumberPicker_np_selectedTextUnderline, this.m);
        this.n = obtainStyledAttributes.getInt(R.styleable.NumberPicker_np_textAlign, this.n);
        this.o = obtainStyledAttributes.getColor(R.styleable.NumberPicker_np_textColor, this.o);
        this.p = obtainStyledAttributes.getDimension(R.styleable.NumberPicker_np_textSize, u(this.p));
        this.q = obtainStyledAttributes.getBoolean(R.styleable.NumberPicker_np_textStrikeThru, this.q);
        this.r = obtainStyledAttributes.getBoolean(R.styleable.NumberPicker_np_textUnderline, this.r);
        this.s = Typeface.create(obtainStyledAttributes.getString(R.styleable.NumberPicker_np_typeface), 0);
        String string = obtainStyledAttributes.getString(R.styleable.NumberPicker_np_formatter);
        if (TextUtils.isEmpty(string)) {
            aVar = null;
        } else {
            aVar = new a2.o.a.a(this, string);
        }
        this.C = aVar;
        this.u0 = obtainStyledAttributes.getBoolean(R.styleable.NumberPicker_np_fadingEdgeEnabled, this.u0);
        this.v0 = obtainStyledAttributes.getFloat(R.styleable.NumberPicker_np_fadingEdgeStrength, this.v0);
        this.w0 = obtainStyledAttributes.getBoolean(R.styleable.NumberPicker_np_scrollerEnabled, this.w0);
        this.F = obtainStyledAttributes.getInt(R.styleable.NumberPicker_np_wheelItemCount, this.F);
        this.x0 = obtainStyledAttributes.getFloat(R.styleable.NumberPicker_np_lineSpacingMultiplier, this.x0);
        this.y0 = obtainStyledAttributes.getInt(R.styleable.NumberPicker_np_maxFlingVelocityCoefficient, this.y0);
        this.p0 = obtainStyledAttributes.getBoolean(R.styleable.NumberPicker_np_hideWheelUntilFocused, false);
        setWillNotDraw(false);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.number_picker_material, (ViewGroup) this, true);
        EditText editText = (EditText) findViewById(R.id.np__numberpicker_input);
        this.a = editText;
        editText.setEnabled(false);
        editText.setFocusable(false);
        editText.setImeOptions(1);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        this.J = paint;
        setSelectedTextColor(this.j);
        setTextColor(this.o);
        setTextSize(this.p);
        setSelectedTextSize(this.k);
        setTypeface(this.s);
        setFormatter(this.C);
        w();
        setValue(this.y);
        setMaxValue(this.x);
        setMinValue(this.w);
        setWheelItemCount(this.F);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.NumberPicker_np_wrapSelectorWheel, this.d0);
        this.d0 = z2;
        setWrapSelectorWheel(z2);
        float f2 = this.q0;
        int i3 = (f2 > -1.0f ? 1 : (f2 == -1.0f ? 0 : -1));
        if (i3 != 0 && this.r0 != -1.0f) {
            setScaleX(f2 / ((float) this.f));
            setScaleY(this.r0 / ((float) this.e));
        } else if (i3 != 0) {
            setScaleX(f2 / ((float) this.f));
            setScaleY(this.q0 / ((float) this.f));
        } else {
            float f3 = this.r0;
            if (f3 != -1.0f) {
                setScaleX(f3 / ((float) this.e));
                setScaleY(this.r0 / ((float) this.e));
            }
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.B0 = viewConfiguration;
        this.a0 = viewConfiguration.getScaledTouchSlop();
        this.b0 = this.B0.getScaledMinimumFlingVelocity();
        this.c0 = this.B0.getScaledMaximumFlingVelocity() / this.y0;
        this.N = new Scroller(context, null, true);
        this.O = new Scroller(context, new DecelerateInterpolator(2.5f));
        int i4 = Build.VERSION.SDK_INT;
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        if (i4 >= 26 && getFocusable() == 16) {
            setFocusable(1);
            setFocusableInTouchMode(true);
        }
        obtainStyledAttributes.recycle();
    }

    public void setTextSize(@DimenRes int i2) {
        setTextSize(getResources().getDimension(i2));
    }

    public void setFormatter(String str) {
        a2.o.a.a aVar;
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str)) {
                aVar = null;
            } else {
                aVar = new a2.o.a.a(this, str);
            }
            setFormatter(aVar);
        }
    }

    public void setSelectedTextSize(@DimenRes int i2) {
        setSelectedTextSize(getResources().getDimension(i2));
    }

    public void setTypeface(String str, int i2) {
        if (!TextUtils.isEmpty(str)) {
            setTypeface(Typeface.create(str, i2));
        }
    }

    public void setTypeface(String str) {
        setTypeface(str, 0);
    }

    public void setFormatter(@StringRes int i2) {
        setFormatter(getResources().getString(i2));
    }

    public void setTypeface(@StringRes int i2, int i3) {
        setTypeface(getResources().getString(i2), i3);
    }

    public void setTypeface(@StringRes int i2) {
        setTypeface(i2, 0);
    }
}
