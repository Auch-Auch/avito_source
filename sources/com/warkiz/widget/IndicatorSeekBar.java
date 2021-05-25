package com.warkiz.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.TextView;
import com.avito.android.lib.design.input.FormatterType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
public class IndicatorSeekBar extends View {
    public float[] A;
    public int A0;
    public boolean B;
    public Drawable B0;
    public boolean C;
    public Bitmap C0;
    public boolean D;
    public int D0;
    public int E;
    public boolean E0;
    public String[] F;
    public float F0;
    public float[] G;
    public int G0;
    public float[] H;
    public boolean H0;
    public float I;
    public boolean I0;
    public int J;
    public Typeface K;
    public int L;
    public int M;
    public int N;
    public CharSequence[] O;
    public Indicator P;
    public int Q;
    public int R;
    public boolean S;
    public int T;
    public View U;
    public View V;
    public int W;
    public Context a;
    public String a0;
    public Paint b;
    public float[] b0;
    public TextPaint c;
    public int c0;
    public OnSeekChangeListener d;
    public int d0;
    public Rect e;
    public int e0;
    public float f;
    public float f0;
    public float g;
    public Bitmap g0;
    public float h;
    public Bitmap h0;
    public float i;
    public Drawable i0;
    public boolean j;
    public int j0;
    public SeekParams k;
    public boolean k0;
    public int l;
    public boolean l0;
    public int m;
    public int m0;
    public int n;
    public boolean n0;
    public int o;
    public RectF o0;
    public float p;
    public RectF p0;
    public float q;
    public int q0;
    public boolean r;
    public int r0;
    public float s;
    public int s0;
    public float t;
    public int t0;
    public float u;
    public int[] u0;
    public boolean v;
    public boolean v0;
    public int w;
    public float w0;
    public boolean x;
    public float x0;
    public boolean y;
    public Bitmap y0;
    public boolean z;
    public int z0;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IndicatorSeekBar.this.requestLayout();
        }
    }

    public IndicatorSeekBar(Context context) {
        this(context, null);
    }

    private float getAmplitude() {
        float f2 = this.s;
        float f3 = this.t;
        if (f2 - f3 > 0.0f) {
            return f2 - f3;
        }
        return 1.0f;
    }

    private int getClosestIndex() {
        float abs = Math.abs(this.s - this.t);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            float[] fArr = this.A;
            if (i2 >= fArr.length) {
                return i3;
            }
            float abs2 = Math.abs(fArr[i2] - this.u);
            if (abs2 <= abs) {
                i3 = i2;
                abs = abs2;
            }
            i2++;
        }
    }

    private int getLeftSideTickColor() {
        if (this.B) {
            return this.d0;
        }
        return this.e0;
    }

    private int getLeftSideTickTextsColor() {
        if (this.B) {
            return this.M;
        }
        return this.L;
    }

    private int getLeftSideTrackSize() {
        if (this.B) {
            return this.q0;
        }
        return this.r0;
    }

    private int getRightSideTickColor() {
        if (this.B) {
            return this.e0;
        }
        return this.d0;
    }

    private int getRightSideTickTextsColor() {
        if (this.B) {
            return this.L;
        }
        return this.M;
    }

    private int getRightSideTrackSize() {
        if (this.B) {
            return this.r0;
        }
        return this.q0;
    }

    private float getThumbCenterX() {
        if (this.B) {
            return this.p0.right;
        }
        return this.o0.right;
    }

    private int getThumbPosOnTick() {
        if (this.c0 != 0) {
            return Math.round((getThumbCenterX() - ((float) this.l)) / this.q);
        }
        return 0;
    }

    private float getThumbPosOnTickFloat() {
        if (this.c0 != 0) {
            return (getThumbCenterX() - ((float) this.l)) / this.q;
        }
        return 0.0f;
    }

    /* access modifiers changed from: private */
    public void setSeekListener(boolean z2) {
        String[] strArr;
        if (this.d != null) {
            boolean z3 = true;
            if (!this.v ? Math.round(this.g) == Math.round(this.u) : this.g == this.u) {
                z3 = false;
            }
            if (z3) {
                OnSeekChangeListener onSeekChangeListener = this.d;
                if (this.k == null) {
                    this.k = new SeekParams(this);
                }
                this.k.progress = getProgress();
                this.k.progressFloat = getProgressFloat();
                this.k.fromUser = z2;
                if (this.c0 > 2) {
                    int thumbPosOnTick = getThumbPosOnTick();
                    if (this.C && (strArr = this.F) != null) {
                        this.k.tickText = strArr[thumbPosOnTick];
                    }
                    if (this.B) {
                        this.k.thumbPosition = (this.c0 - thumbPosOnTick) - 1;
                    } else {
                        this.k.thumbPosition = thumbPosOnTick;
                    }
                }
                onSeekChangeListener.onSeeking(this.k);
            }
        }
    }

    public static Builder with(@NonNull Context context) {
        return new Builder(context);
    }

    public final void b(Builder builder) {
        this.s = builder.b;
        this.t = builder.c;
        this.u = builder.d;
        this.v = builder.e;
        this.c0 = builder.H;
        this.z = builder.f;
        this.B = builder.g;
        this.x = builder.h;
        this.j = builder.j;
        this.y = builder.i;
        this.W = builder.k;
        this.Q = builder.l;
        this.R = builder.m;
        this.T = builder.n;
        this.U = builder.o;
        this.V = builder.p;
        this.q0 = builder.q;
        this.s0 = builder.r;
        this.r0 = builder.s;
        this.t0 = builder.t;
        this.n0 = builder.u;
        this.A0 = builder.x;
        this.B0 = builder.A;
        this.G0 = builder.v;
        q(builder.z, builder.y);
        this.E0 = builder.w;
        this.j0 = builder.I;
        this.m0 = builder.K;
        this.i0 = builder.L;
        this.k0 = builder.M;
        this.l0 = builder.N;
        s(builder.O, builder.J);
        this.C = builder.B;
        this.J = builder.D;
        this.O = builder.E;
        this.K = builder.F;
        t(builder.G, builder.C);
    }

    public final void c() {
        int i2 = this.c0;
        if (i2 < 0 || i2 > 50) {
            StringBuilder L2 = a2.b.a.a.a.L("the Argument: TICK COUNT must be limited between (0-50), Now is ");
            L2.append(this.c0);
            throw new IllegalArgumentException(L2.toString());
        } else if (i2 != 0) {
            this.b0 = new float[i2];
            if (this.C) {
                this.H = new float[i2];
                this.G = new float[i2];
            }
            this.A = new float[i2];
            int i3 = 0;
            while (true) {
                float[] fArr = this.A;
                if (i3 < fArr.length) {
                    float f2 = this.t;
                    float f3 = (this.s - f2) * ((float) i3);
                    int i4 = this.c0;
                    fArr[i3] = (f3 / ((float) (i4 + -1 > 0 ? i4 - 1 : 1))) + f2;
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    public void customSectionTrackColor(@NonNull ColorCollector colorCollector) {
        int i2 = this.c0;
        int i3 = 1;
        if (i2 - 1 > 0) {
            i3 = i2 - 1;
        }
        int[] iArr = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            iArr[i4] = this.s0;
        }
        this.v0 = colorCollector.collectSectionTrackColor(iArr);
        this.u0 = iArr;
        invalidate();
    }

    public void customTickTexts(@NonNull String[] strArr) {
        this.O = strArr;
        if (this.F != null) {
            int i2 = 0;
            while (i2 < this.F.length) {
                String valueOf = i2 < strArr.length ? String.valueOf(strArr[i2]) : "";
                int i3 = this.B ? (this.c0 - 1) - i2 : i2;
                this.F[i3] = valueOf;
                TextPaint textPaint = this.c;
                if (!(textPaint == null || this.e == null)) {
                    textPaint.getTextBounds(valueOf, 0, valueOf.length(), this.e);
                    this.G[i3] = (float) this.e.width();
                }
                i2++;
            }
            invalidate();
        }
    }

    public void customTickTextsTypeface(@NonNull Typeface typeface) {
        this.K = typeface;
        u();
        requestLayout();
        invalidate();
    }

    public final void d(Canvas canvas) {
        if (!this.H0) {
            float thumbCenterX = getThumbCenterX();
            if (this.B0 != null) {
                if (this.y0 == null || this.C0 == null) {
                    p();
                }
                if (this.y0 == null || this.C0 == null) {
                    throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
                }
                this.b.setAlpha(255);
                if (this.r) {
                    Bitmap bitmap = this.C0;
                    canvas.drawBitmap(bitmap, thumbCenterX - (((float) bitmap.getWidth()) / 2.0f), this.o0.top - (((float) this.C0.getHeight()) / 2.0f), this.b);
                    return;
                }
                Bitmap bitmap2 = this.y0;
                canvas.drawBitmap(bitmap2, thumbCenterX - (((float) bitmap2.getWidth()) / 2.0f), this.o0.top - (((float) this.y0.getHeight()) / 2.0f), this.b);
                return;
            }
            if (this.r) {
                this.b.setColor(this.D0);
            } else {
                this.b.setColor(this.z0);
            }
            canvas.drawCircle(thumbCenterX, this.o0.top, this.r ? this.x0 : this.w0, this.b);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewParent parent = getParent();
        if (parent == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            parent.requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void e(Canvas canvas) {
        int i2;
        Bitmap bitmap;
        if (this.c0 == 0) {
            return;
        }
        if (!(this.j0 == 0 && this.i0 == null)) {
            float thumbCenterX = getThumbCenterX();
            for (int i3 = 0; i3 < this.b0.length; i3++) {
                float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                if ((!this.l0 || thumbCenterX < this.b0[i3]) && ((!this.k0 || !(i3 == 0 || i3 == this.b0.length - 1)) && (i3 != getThumbPosOnTick() || this.c0 <= 2 || this.z))) {
                    int i4 = (((float) i3) > thumbPosOnTickFloat ? 1 : (((float) i3) == thumbPosOnTickFloat ? 0 : -1));
                    if (i4 <= 0) {
                        this.b.setColor(getLeftSideTickColor());
                    } else {
                        this.b.setColor(getRightSideTickColor());
                    }
                    if (this.i0 != null) {
                        if (this.h0 == null || this.g0 == null) {
                            r();
                        }
                        Bitmap bitmap2 = this.h0;
                        if (bitmap2 == null || (bitmap = this.g0) == null) {
                            throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
                        } else if (i4 <= 0) {
                            canvas.drawBitmap(bitmap2, this.b0[i3] - (((float) bitmap.getWidth()) / 2.0f), this.o0.top - (((float) this.g0.getHeight()) / 2.0f), this.b);
                        } else {
                            canvas.drawBitmap(bitmap, this.b0[i3] - (((float) bitmap.getWidth()) / 2.0f), this.o0.top - (((float) this.g0.getHeight()) / 2.0f), this.b);
                        }
                    } else {
                        int i5 = this.j0;
                        if (i5 == 1) {
                            canvas.drawCircle(this.b0[i3], this.o0.top, this.f0, this.b);
                        } else if (i5 == 3) {
                            int dp2px = SizeUtils.dp2px(this.a, 1.0f);
                            if (thumbCenterX >= this.b0[i3]) {
                                i2 = getLeftSideTrackSize();
                            } else {
                                i2 = getRightSideTrackSize();
                            }
                            float[] fArr = this.b0;
                            float f2 = (float) dp2px;
                            float f3 = fArr[i3] - f2;
                            float f4 = this.o0.top;
                            float f5 = ((float) i2) / 2.0f;
                            canvas.drawRect(f3, f4 - f5, fArr[i3] + f2, f4 + f5, this.b);
                        } else if (i5 == 2) {
                            float[] fArr2 = this.b0;
                            float f6 = fArr2[i3];
                            int i6 = this.m0;
                            float f7 = f6 - (((float) i6) / 2.0f);
                            float f8 = this.o0.top;
                            canvas.drawRect(f7, f8 - (((float) i6) / 2.0f), (((float) i6) / 2.0f) + fArr2[i3], (((float) i6) / 2.0f) + f8, this.b);
                        }
                    }
                }
            }
        }
    }

    public final void f(Canvas canvas) {
        if (this.F != null) {
            float thumbPosOnTickFloat = getThumbPosOnTickFloat();
            int i2 = 0;
            while (true) {
                String[] strArr = this.F;
                if (i2 < strArr.length) {
                    if (!this.D || i2 == 0 || i2 == strArr.length - 1) {
                        if (i2 == getThumbPosOnTick() && ((float) i2) == thumbPosOnTickFloat) {
                            this.c.setColor(this.N);
                        } else if (((float) i2) < thumbPosOnTickFloat) {
                            this.c.setColor(getLeftSideTickTextsColor());
                        } else {
                            this.c.setColor(getRightSideTickTextsColor());
                        }
                        int length = this.B ? (this.F.length - i2) - 1 : i2;
                        if (i2 == 0) {
                            canvas.drawText(this.F[length], (this.G[length] / 2.0f) + this.H[i2], this.I, this.c);
                        } else {
                            String[] strArr2 = this.F;
                            if (i2 == strArr2.length - 1) {
                                canvas.drawText(strArr2[length], this.H[i2] - (this.G[length] / 2.0f), this.I, this.c);
                            } else {
                                canvas.drawText(strArr2[length], this.H[i2], this.I, this.c);
                            }
                        }
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public final void g(Canvas canvas) {
        if (this.v0) {
            int i2 = this.c0;
            int i3 = i2 + -1 > 0 ? i2 - 1 : 1;
            for (int i4 = 0; i4 < i3; i4++) {
                if (this.B) {
                    this.b.setColor(this.u0[(i3 - i4) - 1]);
                } else {
                    this.b.setColor(this.u0[i4]);
                }
                float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                int i5 = (((float) i4) > thumbPosOnTickFloat ? 1 : (((float) i4) == thumbPosOnTickFloat ? 0 : -1));
                if (i5 < 0) {
                    int i6 = i4 + 1;
                    if (thumbPosOnTickFloat < ((float) i6)) {
                        float thumbCenterX = getThumbCenterX();
                        this.b.setStrokeWidth((float) getLeftSideTrackSize());
                        float f2 = this.b0[i4];
                        RectF rectF = this.o0;
                        canvas.drawLine(f2, rectF.top, thumbCenterX, rectF.bottom, this.b);
                        this.b.setStrokeWidth((float) getRightSideTrackSize());
                        RectF rectF2 = this.o0;
                        canvas.drawLine(thumbCenterX, rectF2.top, this.b0[i6], rectF2.bottom, this.b);
                    }
                }
                if (i5 < 0) {
                    this.b.setStrokeWidth((float) getLeftSideTrackSize());
                } else {
                    this.b.setStrokeWidth((float) getRightSideTrackSize());
                }
                float[] fArr = this.b0;
                float f3 = fArr[i4];
                RectF rectF3 = this.o0;
                canvas.drawLine(f3, rectF3.top, fArr[i4 + 1], rectF3.bottom, this.b);
            }
            return;
        }
        this.b.setColor(this.t0);
        this.b.setStrokeWidth((float) this.r0);
        RectF rectF4 = this.o0;
        canvas.drawLine(rectF4.left, rectF4.top, rectF4.right, rectF4.bottom, this.b);
        this.b.setColor(this.s0);
        this.b.setStrokeWidth((float) this.q0);
        RectF rectF5 = this.p0;
        canvas.drawLine(rectF5.left, rectF5.top, rectF5.right, rectF5.bottom, this.b);
    }

    public Indicator getIndicator() {
        return this.P;
    }

    public View getIndicatorContentView() {
        return this.U;
    }

    public String getIndicatorTextString() {
        String[] strArr;
        String str = this.a0;
        if (str == null || !str.contains("${TICK_TEXT}")) {
            String str2 = this.a0;
            if (str2 != null && str2.contains("${PROGRESS}")) {
                return this.a0.replace("${PROGRESS}", j(this.u));
            }
        } else if (this.c0 > 2 && (strArr = this.F) != null) {
            return this.a0.replace("${TICK_TEXT}", strArr[getThumbPosOnTick()]);
        }
        return j(this.u);
    }

    public float getMax() {
        return this.s;
    }

    public float getMin() {
        return this.t;
    }

    public OnSeekChangeListener getOnSeekChangeListener() {
        return this.d;
    }

    public int getProgress() {
        return Math.round(this.u);
    }

    public synchronized float getProgressFloat() {
        return BigDecimal.valueOf((double) this.u).setScale(this.w, 4).floatValue();
    }

    public int getTickCount() {
        return this.c0;
    }

    public final Bitmap h(Drawable drawable, boolean z2) {
        int i2;
        int i3;
        if (drawable == null) {
            return null;
        }
        int dp2px = SizeUtils.dp2px(this.a, 30.0f);
        if (drawable.getIntrinsicWidth() > dp2px) {
            if (z2) {
                i3 = this.A0;
            } else {
                i3 = this.m0;
            }
            i2 = i(drawable, i3);
            if (i3 > dp2px) {
                i2 = i(drawable, dp2px);
            } else {
                dp2px = i3;
            }
        } else {
            dp2px = drawable.getIntrinsicWidth();
            i2 = drawable.getIntrinsicHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(dp2px, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public void hideThumb(boolean z2) {
        this.H0 = z2;
        invalidate();
    }

    public void hideThumbText(boolean z2) {
        this.E0 = !z2;
        invalidate();
    }

    public final int i(Drawable drawable, int i2) {
        return Math.round(((((float) i2) * 1.0f) * ((float) drawable.getIntrinsicHeight())) / ((float) drawable.getIntrinsicWidth()));
    }

    public final String j(float f2) {
        String str;
        char[] cArr;
        if (!this.v) {
            return String.valueOf(Math.round(f2));
        }
        double d2 = (double) f2;
        int i2 = this.w;
        char[][] cArr2 = a2.u.a.a.a;
        int abs = Math.abs(i2);
        double pow = (Math.pow(10.0d, (double) abs) * Math.abs(d2)) + 0.5d;
        if (pow > 9.99999999999999E14d || abs > 16) {
            str = new BigDecimal(Double.toString(d2)).setScale(Math.abs(abs), RoundingMode.HALF_UP).toString();
            if (abs != 0) {
                int length = str.length();
                do {
                    length--;
                    if (length < 0) {
                        break;
                    }
                } while (str.charAt(length) == '0');
                String substring = str.substring(0, length + 1);
                return substring.charAt(substring.length() + -1) == '.' ? a2.b.a.a.a.O2(substring, -1, 0) : substring;
            }
        } else {
            long nextUp = (long) Math.nextUp(pow);
            if (nextUp < 1) {
                return "0";
            }
            char[] charArray = Long.toString(nextUp).toCharArray();
            if (charArray.length > abs) {
                int length2 = charArray.length - 1;
                int length3 = charArray.length - abs;
                while (length2 >= length3 && charArray[length2] == '0') {
                    length2--;
                }
                if (length2 >= length3) {
                    cArr = new char[(length2 + 2)];
                    System.arraycopy(charArray, 0, cArr, 0, length3);
                    cArr[length3] = FormatterType.defaultDecimalSeparator;
                    System.arraycopy(charArray, length3, cArr, length3 + 1, (length2 - length3) + 1);
                } else {
                    cArr = new char[length3];
                    System.arraycopy(charArray, 0, cArr, 0, length3);
                }
            } else {
                int length4 = charArray.length;
                do {
                    length4--;
                    if (length4 < 0) {
                        break;
                    }
                } while (charArray[length4] == '0');
                char[] cArr3 = a2.u.a.a.a[abs - charArray.length];
                char[] copyOf = Arrays.copyOf(cArr3, cArr3.length + length4 + 1);
                System.arraycopy(charArray, 0, copyOf, cArr3.length, length4 + 1);
                cArr = copyOf;
            }
            if (Math.signum(d2) > 0.0d) {
                str = new String(cArr);
            } else {
                StringBuilder L2 = a2.b.a.a.a.L("-");
                L2.append(new String(cArr));
                return L2.toString();
            }
        }
        return str;
    }

    public final void k(Context context, AttributeSet attributeSet) {
        Builder builder = new Builder(context);
        if (attributeSet == null) {
            b(builder);
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorSeekBar);
        this.s = obtainStyledAttributes.getFloat(R.styleable.IndicatorSeekBar_isb_max, builder.b);
        this.t = obtainStyledAttributes.getFloat(R.styleable.IndicatorSeekBar_isb_min, builder.c);
        this.u = obtainStyledAttributes.getFloat(R.styleable.IndicatorSeekBar_isb_progress, builder.d);
        this.v = obtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_progress_value_float, builder.e);
        this.x = obtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_user_seekable, builder.h);
        this.j = obtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_clear_default_padding, builder.j);
        this.y = obtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_only_thumb_draggable, builder.i);
        this.z = obtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_seek_smoothly, builder.f);
        this.B = obtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_r2l, builder.g);
        this.q0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorSeekBar_isb_track_background_size, builder.q);
        this.r0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorSeekBar_isb_track_progress_size, builder.s);
        this.s0 = obtainStyledAttributes.getColor(R.styleable.IndicatorSeekBar_isb_track_background_color, builder.r);
        this.t0 = obtainStyledAttributes.getColor(R.styleable.IndicatorSeekBar_isb_track_progress_color, builder.t);
        this.n0 = obtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_track_rounded_corners, builder.u);
        this.A0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorSeekBar_isb_thumb_size, builder.x);
        this.B0 = obtainStyledAttributes.getDrawable(R.styleable.IndicatorSeekBar_isb_thumb_drawable);
        this.I0 = obtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_thumb_adjust_auto, true);
        q(obtainStyledAttributes.getColorStateList(R.styleable.IndicatorSeekBar_isb_thumb_color), builder.y);
        this.E0 = obtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_show_thumb_text, builder.w);
        this.G0 = obtainStyledAttributes.getColor(R.styleable.IndicatorSeekBar_isb_thumb_text_color, builder.v);
        this.c0 = obtainStyledAttributes.getInt(R.styleable.IndicatorSeekBar_isb_ticks_count, builder.H);
        this.j0 = obtainStyledAttributes.getInt(R.styleable.IndicatorSeekBar_isb_show_tick_marks_type, builder.I);
        this.m0 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorSeekBar_isb_tick_marks_size, builder.K);
        s(obtainStyledAttributes.getColorStateList(R.styleable.IndicatorSeekBar_isb_tick_marks_color), builder.J);
        this.i0 = obtainStyledAttributes.getDrawable(R.styleable.IndicatorSeekBar_isb_tick_marks_drawable);
        this.l0 = obtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_tick_marks_swept_hide, builder.N);
        this.k0 = obtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_tick_marks_ends_hide, builder.M);
        this.C = obtainStyledAttributes.getBoolean(R.styleable.IndicatorSeekBar_isb_show_tick_texts, builder.B);
        this.J = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorSeekBar_isb_tick_texts_size, builder.D);
        t(obtainStyledAttributes.getColorStateList(R.styleable.IndicatorSeekBar_isb_tick_texts_color), builder.C);
        this.O = obtainStyledAttributes.getTextArray(R.styleable.IndicatorSeekBar_isb_tick_texts_array);
        int i2 = obtainStyledAttributes.getInt(R.styleable.IndicatorSeekBar_isb_tick_texts_typeface, -1);
        Typeface typeface = builder.F;
        if (i2 == 0) {
            this.K = Typeface.DEFAULT;
        } else if (i2 == 1) {
            this.K = Typeface.MONOSPACE;
        } else if (i2 == 2) {
            this.K = Typeface.SANS_SERIF;
        } else if (i2 == 3) {
            this.K = Typeface.SERIF;
        } else if (typeface == null) {
            this.K = Typeface.DEFAULT;
        } else {
            this.K = typeface;
        }
        this.W = obtainStyledAttributes.getInt(R.styleable.IndicatorSeekBar_isb_show_indicator, builder.k);
        this.Q = obtainStyledAttributes.getColor(R.styleable.IndicatorSeekBar_isb_indicator_color, builder.l);
        this.T = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IndicatorSeekBar_isb_indicator_text_size, builder.n);
        this.R = obtainStyledAttributes.getColor(R.styleable.IndicatorSeekBar_isb_indicator_text_color, builder.m);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.IndicatorSeekBar_isb_indicator_content_layout, 0);
        if (resourceId > 0) {
            this.U = View.inflate(this.a, resourceId, null);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.IndicatorSeekBar_isb_indicator_top_content_layout, 0);
        if (resourceId2 > 0) {
            this.V = View.inflate(this.a, resourceId2, null);
        }
        obtainStyledAttributes.recycle();
    }

    public final void l() {
        m();
        int i2 = this.q0;
        int i3 = this.r0;
        if (i2 > i3) {
            this.q0 = i3;
        }
        if (this.B0 == null) {
            float f2 = ((float) this.A0) / 2.0f;
            this.w0 = f2;
            this.x0 = f2 * 1.2f;
        } else {
            float min = ((float) Math.min(SizeUtils.dp2px(this.a, 30.0f), this.A0)) / 2.0f;
            this.w0 = min;
            this.x0 = min;
        }
        if (this.i0 == null) {
            this.f0 = ((float) this.m0) / 2.0f;
        } else {
            this.f0 = ((float) Math.min(SizeUtils.dp2px(this.a, 30.0f), this.m0)) / 2.0f;
        }
        this.f = Math.max(this.x0, this.f0) * 2.0f;
        if (this.b == null) {
            this.b = new Paint();
        }
        if (this.n0) {
            this.b.setStrokeCap(Paint.Cap.ROUND);
        }
        this.b.setAntiAlias(true);
        int i4 = this.q0;
        if (i4 > this.r0) {
            this.r0 = i4;
        }
        u();
        this.g = this.u;
        c();
        this.o0 = new RectF();
        this.p0 = new RectF();
        if (!this.j) {
            int dp2px = SizeUtils.dp2px(this.a, 16.0f);
            if (getPaddingLeft() == 0) {
                setPadding(dp2px, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            }
            if (getPaddingRight() == 0) {
                setPadding(getPaddingLeft(), getPaddingTop(), dp2px, getPaddingBottom());
            }
        }
        int i5 = this.W;
        if (i5 != 0 && this.P == null) {
            Indicator indicator = new Indicator(this.a, this, this.Q, i5, this.T, this.R, this.U, this.V);
            this.P = indicator;
            this.U = indicator.l;
        }
    }

    public final void m() {
        float f2 = this.s;
        float f3 = this.t;
        if (f2 >= f3) {
            if (this.u < f3) {
                this.u = f3;
            }
            if (this.u > f2) {
                this.u = f2;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("the Argument: MAX's value must be larger than MIN's.");
    }

    public final void n() {
        this.n = getMeasuredWidth();
        this.l = getPaddingStart();
        this.m = getPaddingEnd();
        this.o = getPaddingTop();
        float f2 = (float) ((this.n - this.l) - this.m);
        this.p = f2;
        int i2 = this.c0;
        int i3 = 1;
        if (i2 - 1 > 0) {
            i3 = i2 - 1;
        }
        this.q = f2 / ((float) i3);
    }

    public final void o() {
        String str;
        int i2 = this.c0;
        if (i2 != 0) {
            if (this.C) {
                this.F = new String[i2];
            }
            int i3 = 0;
            while (i3 < this.b0.length) {
                if (this.C) {
                    String[] strArr = this.F;
                    CharSequence[] charSequenceArr = this.O;
                    if (charSequenceArr == null) {
                        str = j(this.A[i3]);
                    } else {
                        str = i3 < charSequenceArr.length ? String.valueOf(charSequenceArr[i3]) : "";
                    }
                    strArr[i3] = str;
                    TextPaint textPaint = this.c;
                    String[] strArr2 = this.F;
                    textPaint.getTextBounds(strArr2[i3], 0, strArr2[i3].length(), this.e);
                    this.G[i3] = (float) this.e.width();
                    this.H[i3] = (this.q * ((float) i3)) + ((float) this.l);
                }
                this.b0[i3] = (this.q * ((float) i3)) + ((float) this.l);
                i3++;
            }
        }
    }

    @Override // android.view.View
    public synchronized void onDraw(Canvas canvas) {
        g(canvas);
        e(canvas);
        f(canvas);
        d(canvas);
        if (this.E0) {
            if (!this.C || this.c0 <= 2) {
                this.c.setColor(this.G0);
                canvas.drawText(j(this.u), getThumbCenterX(), this.F0, this.c);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        setMeasuredDimension(View.resolveSize(SizeUtils.dp2px(this.a, 170.0f), i2), Math.round(this.f + ((float) getPaddingTop()) + ((float) getPaddingBottom())) + this.E);
        n();
        x();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setProgress(bundle.getFloat("isb_progress"));
            super.onRestoreInstanceState(bundle.getParcelable("isb_instance_state"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("isb_instance_state", super.onSaveInstanceState());
        bundle.putFloat("isb_progress", this.u);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        post(new a());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        if (r0 != 3) goto L_0x0106;
     */
    @Override // android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r11) {
        /*
        // Method dump skipped, instructions count: 268
        */
        throw new UnsupportedOperationException("Method not decompiled: com.warkiz.widget.IndicatorSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        Drawable drawable = this.B0;
        if (drawable != null) {
            if (drawable instanceof StateListDrawable) {
                try {
                    StateListDrawable stateListDrawable = (StateListDrawable) drawable;
                    Class<?> cls = stateListDrawable.getClass();
                    int intValue = ((Integer) cls.getMethod("getStateCount", new Class[0]).invoke(stateListDrawable, new Object[0])).intValue();
                    if (intValue == 2) {
                        Class<?> cls2 = Integer.TYPE;
                        Method method = cls.getMethod("getStateSet", cls2);
                        Method method2 = cls.getMethod("getStateDrawable", cls2);
                        for (int i2 = 0; i2 < intValue; i2++) {
                            int[] iArr = (int[]) method.invoke(stateListDrawable, Integer.valueOf(i2));
                            if (iArr.length <= 0) {
                                this.y0 = h((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i2)), true);
                            } else if (iArr[0] == 16842919) {
                                this.C0 = h((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i2)), true);
                            } else {
                                throw new IllegalArgumentException("the state of the selector thumb drawable is wrong!");
                            }
                        }
                        return;
                    }
                    throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
                } catch (Exception unused) {
                    Bitmap h2 = h(this.B0, true);
                    this.y0 = h2;
                    this.C0 = h2;
                }
            } else {
                Bitmap h3 = h(drawable, true);
                this.y0 = h3;
                this.C0 = h3;
            }
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public final void q(ColorStateList colorStateList, int i2) {
        if (colorStateList == null) {
            this.z0 = i2;
            this.D0 = i2;
            return;
        }
        try {
            Field[] declaredFields = colorStateList.getClass().getDeclaredFields();
            int[][] iArr = null;
            int[] iArr2 = null;
            for (Field field : declaredFields) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr != null && iArr2 != null) {
                if (iArr.length == 1) {
                    int i3 = iArr2[0];
                    this.z0 = i3;
                    this.D0 = i3;
                } else if (iArr.length == 2) {
                    for (int i4 = 0; i4 < iArr.length; i4++) {
                        int[] iArr3 = iArr[i4];
                        if (iArr3.length == 0) {
                            this.D0 = iArr2[i4];
                        } else if (iArr3[0] == 16842919) {
                            this.z0 = iArr2[i4];
                        } else {
                            throw new IllegalArgumentException("the selector color file you set for the argument: isb_thumb_color is in wrong format.");
                        }
                    }
                } else {
                    throw new IllegalArgumentException("the selector color file you set for the argument: isb_thumb_color is in wrong format.");
                }
            }
        } catch (Exception unused) {
            throw new RuntimeException("Something wrong happened when parseing thumb selector color.");
        }
    }

    public final void r() {
        Drawable drawable = this.i0;
        if (drawable instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) drawable;
            try {
                Class<?> cls = stateListDrawable.getClass();
                int intValue = ((Integer) cls.getMethod("getStateCount", new Class[0]).invoke(stateListDrawable, new Object[0])).intValue();
                if (intValue == 2) {
                    Class<?> cls2 = Integer.TYPE;
                    Method method = cls.getMethod("getStateSet", cls2);
                    Method method2 = cls.getMethod("getStateDrawable", cls2);
                    for (int i2 = 0; i2 < intValue; i2++) {
                        int[] iArr = (int[]) method.invoke(stateListDrawable, Integer.valueOf(i2));
                        if (iArr.length <= 0) {
                            this.g0 = h((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i2)), false);
                        } else if (iArr[0] == 16842913) {
                            this.h0 = h((Drawable) method2.invoke(stateListDrawable, Integer.valueOf(i2)), false);
                        } else {
                            throw new IllegalArgumentException("the state of the selector TickMarks drawable is wrong!");
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
            } catch (Exception unused) {
                Bitmap h2 = h(this.i0, false);
                this.g0 = h2;
                this.h0 = h2;
            }
        } else {
            Bitmap h3 = h(drawable, false);
            this.g0 = h3;
            this.h0 = h3;
        }
    }

    public final void s(ColorStateList colorStateList, int i2) {
        if (colorStateList == null) {
            this.e0 = i2;
            this.d0 = i2;
            return;
        }
        try {
            Field[] declaredFields = colorStateList.getClass().getDeclaredFields();
            int[][] iArr = null;
            int[] iArr2 = null;
            for (Field field : declaredFields) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr != null && iArr2 != null) {
                if (iArr.length == 1) {
                    int i3 = iArr2[0];
                    this.e0 = i3;
                    this.d0 = i3;
                } else if (iArr.length == 2) {
                    for (int i4 = 0; i4 < iArr.length; i4++) {
                        int[] iArr3 = iArr[i4];
                        if (iArr3.length == 0) {
                            this.d0 = iArr2[i4];
                        } else if (iArr3[0] == 16842913) {
                            this.e0 = iArr2[i4];
                        } else {
                            throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_marks_color is in wrong format.");
                        }
                    }
                } else {
                    throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_marks_color is in wrong format.");
                }
            }
        } catch (Exception e2) {
            throw new RuntimeException(a2.b.a.a.a.F2(e2, a2.b.a.a.a.L("Something wrong happened when parsing thumb selector color.")));
        }
    }

    public void setDecimalScale(int i2) {
        this.w = i2;
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        if (z2 != isEnabled()) {
            super.setEnabled(z2);
            if (isEnabled()) {
                setAlpha(1.0f);
                if (this.S) {
                    this.U.setAlpha(1.0f);
                    return;
                }
                return;
            }
            setAlpha(0.3f);
            if (this.S) {
                this.U.setAlpha(0.3f);
            }
        }
    }

    public void setIndicatorStayAlways(boolean z2) {
        this.S = z2;
    }

    public void setIndicatorTextFormat(String str) {
        this.a0 = str;
        o();
        z();
    }

    public synchronized void setMax(float f2) {
        this.s = Math.max(this.t, f2);
        m();
        c();
        x();
        invalidate();
        z();
    }

    public synchronized void setMin(float f2) {
        this.t = Math.min(this.s, f2);
        m();
        c();
        x();
        invalidate();
        z();
    }

    public void setOnSeekChangeListener(@NonNull OnSeekChangeListener onSeekChangeListener) {
        this.d = onSeekChangeListener;
    }

    public synchronized void setProgress(float f2) {
        this.g = this.u;
        float f3 = this.t;
        if (f2 >= f3) {
            f3 = this.s;
            if (f2 > f3) {
            }
            this.u = f2;
            if (!this.z && this.c0 > 2) {
                this.u = this.A[getClosestIndex()];
            }
            setSeekListener(false);
            y(this.u);
            postInvalidate();
            z();
        }
        f2 = f3;
        this.u = f2;
        this.u = this.A[getClosestIndex()];
        setSeekListener(false);
        y(this.u);
        postInvalidate();
        z();
    }

    public void setR2L(boolean z2) {
        this.B = z2;
        requestLayout();
        invalidate();
        z();
    }

    public void setThumbAdjustAuto(boolean z2) {
        this.I0 = z2;
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            this.B0 = null;
            this.y0 = null;
            this.C0 = null;
        } else {
            this.B0 = drawable;
            float min = ((float) Math.min(SizeUtils.dp2px(this.a, 30.0f), this.A0)) / 2.0f;
            this.w0 = min;
            this.x0 = min;
            this.f = Math.max(min, this.f0) * 2.0f;
            p();
        }
        requestLayout();
        invalidate();
    }

    public synchronized void setTickCount(int i2) {
        int i3 = this.c0;
        if (i3 < 0 || i3 > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.c0);
        }
        this.c0 = i2;
        c();
        o();
        n();
        x();
        invalidate();
        z();
    }

    public void setTickMarksDrawable(Drawable drawable) {
        if (drawable == null) {
            this.i0 = null;
            this.g0 = null;
            this.h0 = null;
        } else {
            this.i0 = drawable;
            float min = ((float) Math.min(SizeUtils.dp2px(this.a, 30.0f), this.m0)) / 2.0f;
            this.f0 = min;
            this.f = Math.max(this.x0, min) * 2.0f;
            r();
        }
        invalidate();
    }

    public void setUserSeekAble(boolean z2) {
        this.x = z2;
    }

    public void showBothEndsTickTextsOnly(boolean z2) {
        this.D = z2;
    }

    public final void t(ColorStateList colorStateList, int i2) {
        if (colorStateList == null) {
            this.M = i2;
            this.L = i2;
            this.N = i2;
            return;
        }
        try {
            Field[] declaredFields = colorStateList.getClass().getDeclaredFields();
            int[][] iArr = null;
            int[] iArr2 = null;
            for (Field field : declaredFields) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr != null && iArr2 != null) {
                if (iArr.length == 1) {
                    int i3 = iArr2[0];
                    this.M = i3;
                    this.L = i3;
                    this.N = i3;
                } else if (iArr.length == 3) {
                    for (int i4 = 0; i4 < iArr.length; i4++) {
                        int[] iArr3 = iArr[i4];
                        if (iArr3.length == 0) {
                            this.M = iArr2[i4];
                        } else {
                            int i5 = iArr3[0];
                            if (i5 == 16842913) {
                                this.L = iArr2[i4];
                            } else if (i5 == 16843623) {
                                this.N = iArr2[i4];
                            } else {
                                throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_texts_color is in wrong format.");
                            }
                        }
                    }
                } else {
                    throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_texts_color is in wrong format.");
                }
            }
        } catch (Exception unused) {
            throw new RuntimeException("Something wrong happened when parseing thumb selector color.");
        }
    }

    public void thumbColor(@ColorInt int i2) {
        this.z0 = i2;
        this.D0 = i2;
        invalidate();
    }

    public void thumbColorStateList(@NonNull ColorStateList colorStateList) {
        q(colorStateList, this.z0);
        invalidate();
    }

    public void tickMarksColor(@ColorInt int i2) {
        this.e0 = i2;
        this.d0 = i2;
        invalidate();
    }

    public void tickTextsColor(@ColorInt int i2) {
        this.M = i2;
        this.L = i2;
        this.N = i2;
        invalidate();
    }

    public void tickTextsColorStateList(@NonNull ColorStateList colorStateList) {
        t(colorStateList, this.L);
        invalidate();
    }

    public final void u() {
        if (v()) {
            if (this.c == null) {
                TextPaint textPaint = new TextPaint();
                this.c = textPaint;
                textPaint.setAntiAlias(true);
                this.c.setTextAlign(Paint.Align.CENTER);
                this.c.setTextSize((float) this.J);
            }
            if (this.e == null) {
                this.e = new Rect();
            }
            this.c.setTypeface(this.K);
            this.c.getTextBounds("j", 0, 1, this.e);
            this.E = SizeUtils.dp2px(this.a, 3.0f) + this.e.height();
        }
    }

    public final boolean v() {
        return this.E0 || (this.c0 != 0 && this.C);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void w(android.view.MotionEvent r11) {
        /*
        // Method dump skipped, instructions count: 347
        */
        throw new UnsupportedOperationException("Method not decompiled: com.warkiz.widget.IndicatorSeekBar.w(android.view.MotionEvent):void");
    }

    public final void x() {
        if (this.B) {
            RectF rectF = this.p0;
            float f2 = (float) this.l;
            rectF.left = f2;
            rectF.top = ((float) this.o) + this.x0;
            rectF.right = ((1.0f - ((this.u - this.t) / getAmplitude())) * this.p) + f2;
            RectF rectF2 = this.p0;
            float f3 = rectF2.top;
            rectF2.bottom = f3;
            RectF rectF3 = this.o0;
            rectF3.left = rectF2.right;
            rectF3.top = f3;
            rectF3.right = (float) (this.n - this.m);
            rectF3.bottom = f3;
        } else {
            RectF rectF4 = this.o0;
            rectF4.left = (float) this.l;
            rectF4.top = ((float) this.o) + this.x0;
            rectF4.right = (((this.u - this.t) * this.p) / getAmplitude()) + ((float) this.l);
            RectF rectF5 = this.o0;
            float f4 = rectF5.top;
            rectF5.bottom = f4;
            RectF rectF6 = this.p0;
            rectF6.left = rectF5.right;
            rectF6.top = f4;
            rectF6.right = (float) (this.n - this.m);
            rectF6.bottom = f4;
        }
        if (v()) {
            this.c.getTextBounds("j", 0, 1, this.e);
            float round = ((float) this.o) + this.f + ((float) Math.round(((float) this.e.height()) - this.c.descent())) + ((float) SizeUtils.dp2px(this.a, 3.0f));
            this.I = round;
            this.F0 = round;
        }
        if (this.b0 != null) {
            o();
            if (this.c0 > 2) {
                float f5 = this.A[getClosestIndex()];
                this.u = f5;
                this.g = f5;
            }
            y(this.u);
        }
    }

    public final void y(float f2) {
        if (this.B) {
            this.p0.right = ((1.0f - ((f2 - this.t) / getAmplitude())) * this.p) + ((float) this.l);
            this.o0.left = this.p0.right;
            return;
        }
        this.o0.right = (((f2 - this.t) * this.p) / getAmplitude()) + ((float) this.l);
        this.p0.left = this.o0.right;
    }

    public final void z() {
        Indicator indicator;
        int i2;
        int i3;
        if (this.S && (indicator = this.P) != null) {
            String indicatorTextString = getIndicatorTextString();
            View view = indicator.l;
            if (view instanceof CircleBubbleView) {
                ((CircleBubbleView) view).setProgress(indicatorTextString);
            } else {
                TextView textView = indicator.d;
                if (textView != null) {
                    textView.setText(indicatorTextString);
                }
            }
            this.U.measure(0, 0);
            int measuredWidth = this.U.getMeasuredWidth();
            float thumbCenterX = getThumbCenterX();
            if (this.i == -1.0f) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
                if (windowManager != null) {
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                    this.i = (float) displayMetrics.widthPixels;
                }
            }
            float f2 = (float) (measuredWidth / 2);
            int i4 = this.n;
            if (f2 + thumbCenterX > ((float) i4)) {
                int i5 = i4 - measuredWidth;
                i3 = (int) ((thumbCenterX - ((float) i5)) - f2);
                i2 = i5;
            } else if (thumbCenterX - f2 < 0.0f) {
                i3 = -((int) (f2 - thumbCenterX));
                i2 = 0;
            } else {
                i2 = (int) (getThumbCenterX() - f2);
                i3 = 0;
            }
            Indicator indicator2 = this.P;
            indicator2.e(indicator2.l, i2, -1, -1, -1);
            Indicator indicator3 = this.P;
            indicator3.e(indicator3.c, i3, -1, -1, -1);
        }
    }

    public IndicatorSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = -1.0f;
        this.i = -1.0f;
        this.w = 1;
        this.a = context;
        k(context, attributeSet);
        l();
    }

    public void tickMarksColor(@NonNull ColorStateList colorStateList) {
        s(colorStateList, this.e0);
        invalidate();
    }

    @RequiresApi(api = 21)
    public IndicatorSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.h = -1.0f;
        this.i = -1.0f;
        this.w = 1;
        this.a = context;
        k(context, attributeSet);
        l();
    }

    public IndicatorSeekBar(Builder builder) {
        super(builder.a);
        this.h = -1.0f;
        this.i = -1.0f;
        this.w = 1;
        Context context = builder.a;
        this.a = context;
        int dp2px = SizeUtils.dp2px(context, 16.0f);
        setPadding(dp2px, getPaddingTop(), dp2px, getPaddingBottom());
        b(builder);
        l();
    }
}
