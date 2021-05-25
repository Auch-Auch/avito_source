package v6.b.a;

import a2.b.a.a.a;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.ColorInt;
import androidx.appcompat.R;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
public final class b {
    public float A;
    public int[] B;
    public boolean C;
    public final TextPaint D;
    public Interpolator E;
    public float F;
    public float G;
    public float H;
    public int I;
    public float J;
    public float K;
    public float L;
    public int M;
    public CharSequence N;
    public Bitmap O;
    public Bitmap P;
    public StaticLayout Q;
    public float R;
    public float S;
    public float T;
    public int U = 3;
    public final View a;
    public boolean b;
    public float c;
    public final Rect d;
    public final Rect e;
    public final RectF f;
    public int g = 16;
    public int h = 16;
    public float i = 15.0f;
    public float j = 15.0f;
    public ColorStateList k;
    public ColorStateList l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public Typeface s;
    public Typeface t;
    public Typeface u;
    public CharSequence v;
    public CharSequence w;
    public boolean x;
    public Bitmap y;
    public float z;

    public b(View view) {
        this.a = view;
        this.D = new TextPaint(129);
        this.e = new Rect();
        this.d = new Rect();
        this.f = new RectF();
    }

    public static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((((float) Color.alpha(i3)) * f2) + (((float) Color.alpha(i2)) * f3)), (int) ((((float) Color.red(i3)) * f2) + (((float) Color.red(i2)) * f3)), (int) ((((float) Color.green(i3)) * f2) + (((float) Color.green(i2)) * f3)), (int) ((((float) Color.blue(i3)) * f2) + (((float) Color.blue(i2)) * f3)));
    }

    public static float f(float f2, float f3, float f4, Interpolator interpolator) {
        if (interpolator != null) {
            f4 = interpolator.getInterpolation(f4);
        }
        Interpolator interpolator2 = a.a;
        return a.b(f3, f2, f4, f2);
    }

    public static boolean j(Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }

    public final void b(float f2) {
        int i2;
        this.f.left = f((float) this.d.left, (float) this.e.left, f2, null);
        this.f.top = f(this.m, this.n, f2, null);
        this.f.right = f((float) this.d.right, (float) this.e.right, f2, null);
        this.f.bottom = f((float) this.d.bottom, (float) this.e.bottom, f2, null);
        this.q = f(this.o, this.p, f2, null);
        this.r = f(this.m, this.n, f2, null);
        m(f(this.i, this.j, f2, this.E));
        Interpolator interpolator = a.a;
        this.R = 1.0f - f(0.0f, 1.0f, 1.0f - f2, interpolator);
        ViewCompat.postInvalidateOnAnimation(this.a);
        this.S = f(1.0f, 0.0f, f2, interpolator);
        ViewCompat.postInvalidateOnAnimation(this.a);
        ColorStateList colorStateList = this.l;
        ColorStateList colorStateList2 = this.k;
        if (colorStateList != colorStateList2) {
            TextPaint textPaint = this.D;
            int[] iArr = this.B;
            if (iArr != null) {
                i2 = colorStateList2.getColorForState(iArr, 0);
            } else {
                i2 = colorStateList2.getDefaultColor();
            }
            textPaint.setColor(a(i2, e(), f2));
        } else {
            this.D.setColor(e());
        }
        this.D.setShadowLayer(f(this.J, this.F, f2, null), f(this.K, this.G, f2, null), f(this.L, this.H, f2, null), a(this.M, this.I, f2));
        ViewCompat.postInvalidateOnAnimation(this.a);
    }

    public final void c(float f2) {
        boolean z2;
        int i2;
        float f3;
        CharSequence charSequence;
        Layout.Alignment alignment;
        boolean z3;
        if (this.v != null) {
            float width = (float) this.e.width();
            float width2 = (float) this.d.width();
            if (Math.abs(f2 - this.j) < 0.001f) {
                f3 = this.j;
                this.z = 1.0f;
                Typeface typeface = this.u;
                Typeface typeface2 = this.s;
                if (typeface != typeface2) {
                    this.u = typeface2;
                    z3 = true;
                } else {
                    z3 = false;
                }
                z2 = z3;
                i2 = 1;
            } else {
                float f4 = this.i;
                Typeface typeface3 = this.u;
                Typeface typeface4 = this.t;
                if (typeface3 != typeface4) {
                    this.u = typeface4;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (Math.abs(f2 - f4) < 0.001f) {
                    this.z = 1.0f;
                } else {
                    this.z = f2 / this.i;
                }
                float f5 = this.j / this.i;
                width = width2 * f5 > width ? Math.min(width / f5, width2) : width2;
                i2 = this.U;
                f3 = f4;
            }
            if (width > 0.0f) {
                z2 = this.A != f3 || this.C || z2;
                this.A = f3;
                this.C = false;
            }
            if (this.w == null || z2) {
                this.D.setTextSize(this.A);
                this.D.setTypeface(this.u);
                int i3 = (int) width;
                StaticLayout staticLayout = new StaticLayout(this.v, this.D, i3, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                if (staticLayout.getLineCount() > i2) {
                    int i4 = i2 - 1;
                    CharSequence charSequence2 = "";
                    CharSequence subSequence = i4 > 0 ? this.v.subSequence(0, staticLayout.getLineEnd(i4 - 1)) : charSequence2;
                    CharSequence subSequence2 = this.v.subSequence(staticLayout.getLineStart(i4), staticLayout.getLineEnd(i4));
                    if (subSequence2.charAt(subSequence2.length() - 1) == ' ') {
                        charSequence2 = subSequence2.subSequence(subSequence2.length() - 1, subSequence2.length());
                        subSequence2 = subSequence2.subSequence(0, subSequence2.length() - 1);
                    }
                    charSequence = TextUtils.concat(subSequence, TextUtils.ellipsize(TextUtils.concat(subSequence2, "…", charSequence2), this.D, width, TextUtils.TruncateAt.END));
                } else {
                    charSequence = this.v;
                }
                if (!TextUtils.equals(charSequence, this.w)) {
                    this.w = charSequence;
                    this.x = (ViewCompat.getLayoutDirection(this.a) == 1 ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR).isRtl(charSequence, 0, charSequence.length());
                }
                int i5 = this.g & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
                if (i5 == 1) {
                    alignment = Layout.Alignment.ALIGN_CENTER;
                } else if (i5 == 5 || i5 == 8388613) {
                    alignment = Layout.Alignment.ALIGN_OPPOSITE;
                } else {
                    alignment = Layout.Alignment.ALIGN_NORMAL;
                }
                this.Q = new StaticLayout(this.w, this.D, i3, alignment, 1.0f, 0.0f, false);
            }
        }
    }

    public final void d() {
        Bitmap bitmap = this.y;
        if (bitmap != null) {
            bitmap.recycle();
            this.y = null;
        }
        Bitmap bitmap2 = this.O;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.O = null;
        }
        Bitmap bitmap3 = this.P;
        if (bitmap3 != null) {
            bitmap3.recycle();
            this.P = null;
        }
    }

    @ColorInt
    public final int e() {
        int[] iArr = this.B;
        if (iArr != null) {
            return this.l.getColorForState(iArr, 0);
        }
        return this.l.getDefaultColor();
    }

    public void g() {
        this.b = this.e.width() > 0 && this.e.height() > 0 && this.d.width() > 0 && this.d.height() > 0;
    }

    public final Typeface h(int i2) {
        TypedArray obtainStyledAttributes = this.a.getContext().obtainStyledAttributes(i2, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                return Typeface.create(string, 0);
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void i() {
        if (this.a.getHeight() > 0 && this.a.getWidth() > 0) {
            float f2 = this.A;
            c(this.j);
            CharSequence charSequence = this.w;
            this.N = charSequence;
            float f3 = 0.0f;
            float measureText = charSequence != null ? this.D.measureText(charSequence, 0, charSequence.length()) : 0.0f;
            int absoluteGravity = GravityCompat.getAbsoluteGravity(this.h, this.x ? 1 : 0);
            StaticLayout staticLayout = this.Q;
            float height = staticLayout != null ? (float) staticLayout.getHeight() : 0.0f;
            int i2 = absoluteGravity & 112;
            if (i2 == 48) {
                this.n = (float) this.e.top;
            } else if (i2 != 80) {
                this.n = ((float) this.e.centerY()) - (height / 2.0f);
            } else {
                this.n = ((float) this.e.bottom) - height;
            }
            int i3 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
            if (i3 == 1) {
                this.p = ((float) this.e.centerX()) - (measureText / 2.0f);
            } else if (i3 != 5) {
                this.p = (float) this.e.left;
            } else {
                this.p = ((float) this.e.right) - measureText;
            }
            c(this.i);
            StaticLayout staticLayout2 = this.Q;
            float lineWidth = staticLayout2 != null ? staticLayout2.getLineWidth(0) : 0.0f;
            StaticLayout staticLayout3 = this.Q;
            this.T = staticLayout3 != null ? staticLayout3.getLineLeft(0) : 0.0f;
            int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.g, this.x ? 1 : 0);
            StaticLayout staticLayout4 = this.Q;
            if (staticLayout4 != null) {
                f3 = (float) staticLayout4.getHeight();
            }
            int i4 = absoluteGravity2 & 112;
            if (i4 == 48) {
                this.m = (float) this.d.top;
            } else if (i4 != 80) {
                this.m = ((float) this.d.centerY()) - (f3 / 2.0f);
            } else {
                this.m = ((float) this.d.bottom) - f3;
            }
            int i5 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
            if (i5 == 1) {
                this.o = ((float) this.d.centerX()) - (lineWidth / 2.0f);
            } else if (i5 != 5) {
                this.o = (float) this.d.left;
            } else {
                this.o = ((float) this.d.right) - lineWidth;
            }
            d();
            c(f2);
            ViewCompat.postInvalidateOnAnimation(this.a);
            b(this.c);
        }
    }

    public void k(int i2) {
        TypedArray obtainStyledAttributes = this.a.getContext().obtainStyledAttributes(i2, R.styleable.TextAppearance);
        int i3 = R.styleable.TextAppearance_android_textColor;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.l = obtainStyledAttributes.getColorStateList(i3);
        }
        int i4 = R.styleable.TextAppearance_android_textSize;
        if (obtainStyledAttributes.hasValue(i4)) {
            this.j = (float) obtainStyledAttributes.getDimensionPixelSize(i4, (int) this.j);
        }
        this.I = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_shadowColor, 0);
        this.G = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.H = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.F = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        this.s = h(i2);
        i();
    }

    public void l(int i2) {
        TypedArray obtainStyledAttributes = this.a.getContext().obtainStyledAttributes(i2, R.styleable.TextAppearance);
        int i3 = R.styleable.TextAppearance_android_textColor;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.k = obtainStyledAttributes.getColorStateList(i3);
        }
        int i4 = R.styleable.TextAppearance_android_textSize;
        if (obtainStyledAttributes.hasValue(i4)) {
            this.i = (float) obtainStyledAttributes.getDimensionPixelSize(i4, (int) this.i);
        }
        this.M = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_shadowColor, 0);
        this.K = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.L = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.J = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        this.t = h(i2);
        i();
    }

    public final void m(float f2) {
        c(f2);
        ViewCompat.postInvalidateOnAnimation(this.a);
    }

    public void n(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.v)) {
            this.v = charSequence;
            this.w = null;
            d();
            i();
        }
    }
}
