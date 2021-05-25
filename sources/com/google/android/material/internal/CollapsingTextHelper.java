package com.google.android.material.internal;

import a2.j.b.d.l.a;
import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CollapsingTextHelper {
    @Nullable
    public Bitmap A;
    public float B;
    public float C;
    public int[] D;
    public boolean E;
    @NonNull
    public final TextPaint F;
    @NonNull
    public final TextPaint G;
    public TimeInterpolator H;
    public TimeInterpolator I;
    public float J;
    public float K;
    public float L;
    public ColorStateList M;
    public float N;
    public float O;
    public float P;
    public ColorStateList Q;
    public float R;
    public float S;
    public StaticLayout T;
    public float U;
    public float V;
    public float W;
    public CharSequence X;
    public int Y = 1;
    public final View a;
    public boolean b;
    public float c;
    @NonNull
    public final Rect d;
    @NonNull
    public final Rect e;
    @NonNull
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
    public CancelableFontCallback v;
    public CancelableFontCallback w;
    @Nullable
    public CharSequence x;
    @Nullable
    public CharSequence y;
    public boolean z;

    public class a implements CancelableFontCallback.ApplyFont {
        public a() {
        }

        @Override // com.google.android.material.resources.CancelableFontCallback.ApplyFont
        public void apply(Typeface typeface) {
            CollapsingTextHelper.this.setCollapsedTypeface(typeface);
        }
    }

    public class b implements CancelableFontCallback.ApplyFont {
        public b() {
        }

        @Override // com.google.android.material.resources.CancelableFontCallback.ApplyFont
        public void apply(Typeface typeface) {
            CollapsingTextHelper.this.setExpandedTypeface(typeface);
        }
    }

    public CollapsingTextHelper(View view) {
        this.a = view;
        TextPaint textPaint = new TextPaint(129);
        this.F = textPaint;
        this.G = new TextPaint(textPaint);
        this.e = new Rect();
        this.d = new Rect();
        this.f = new RectF();
    }

    public static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((((float) Color.alpha(i3)) * f2) + (((float) Color.alpha(i2)) * f3)), (int) ((((float) Color.red(i3)) * f2) + (((float) Color.red(i2)) * f3)), (int) ((((float) Color.green(i3)) * f2) + (((float) Color.green(i2)) * f3)), (int) ((((float) Color.blue(i3)) * f2) + (((float) Color.blue(i2)) * f3)));
    }

    public static float g(float f2, float f3, float f4, @Nullable TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return AnimationUtils.lerp(f2, f3, f4);
    }

    public static boolean i(@NonNull Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }

    public final boolean b(@NonNull CharSequence charSequence) {
        boolean z2 = true;
        if (ViewCompat.getLayoutDirection(this.a) != 1) {
            z2 = false;
        }
        return (z2 ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR).isRtl(charSequence, 0, charSequence.length());
    }

    public final void c(float f2) {
        this.f.left = g((float) this.d.left, (float) this.e.left, f2, this.H);
        this.f.top = g(this.m, this.n, f2, this.H);
        this.f.right = g((float) this.d.right, (float) this.e.right, f2, this.H);
        this.f.bottom = g((float) this.d.bottom, (float) this.e.bottom, f2, this.H);
        this.q = g(this.o, this.p, f2, this.H);
        this.r = g(this.m, this.n, f2, this.H);
        j(g(this.i, this.j, f2, this.I));
        TimeInterpolator timeInterpolator = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        this.U = 1.0f - g(0.0f, 1.0f, 1.0f - f2, timeInterpolator);
        ViewCompat.postInvalidateOnAnimation(this.a);
        this.V = g(1.0f, 0.0f, f2, timeInterpolator);
        ViewCompat.postInvalidateOnAnimation(this.a);
        ColorStateList colorStateList = this.l;
        ColorStateList colorStateList2 = this.k;
        if (colorStateList != colorStateList2) {
            this.F.setColor(a(f(colorStateList2), getCurrentCollapsedTextColor(), f2));
        } else {
            this.F.setColor(getCurrentCollapsedTextColor());
        }
        float f3 = this.R;
        float f4 = this.S;
        if (f3 != f4) {
            this.F.setLetterSpacing(g(f4, f3, f2, timeInterpolator));
        } else {
            this.F.setLetterSpacing(f3);
        }
        this.F.setShadowLayer(g(this.N, this.J, f2, null), g(this.O, this.K, f2, null), g(this.P, this.L, f2, null), a(f(this.Q), f(this.M), f2));
        ViewCompat.postInvalidateOnAnimation(this.a);
    }

    public float calculateCollapsedTextWidth() {
        if (this.x == null) {
            return 0.0f;
        }
        TextPaint textPaint = this.G;
        textPaint.setTextSize(this.j);
        textPaint.setTypeface(this.s);
        textPaint.setLetterSpacing(this.R);
        TextPaint textPaint2 = this.G;
        CharSequence charSequence = this.x;
        return textPaint2.measureText(charSequence, 0, charSequence.length());
    }

    public final void d(float f2) {
        float f3;
        boolean z2;
        StaticLayout staticLayout;
        if (this.x != null) {
            float width = (float) this.e.width();
            float width2 = (float) this.d.width();
            int i2 = 1;
            if (Math.abs(f2 - this.j) < 0.001f) {
                f3 = this.j;
                this.B = 1.0f;
                Typeface typeface = this.u;
                Typeface typeface2 = this.s;
                if (typeface != typeface2) {
                    this.u = typeface2;
                    z2 = true;
                } else {
                    z2 = false;
                }
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
                    this.B = 1.0f;
                } else {
                    this.B = f2 / this.i;
                }
                float f5 = this.j / this.i;
                width = width2 * f5 > width ? Math.min(width / f5, width2) : width2;
                f3 = f4;
            }
            if (width > 0.0f) {
                z2 = this.C != f3 || this.E || z2;
                this.C = f3;
                this.E = false;
            }
            if (this.y == null || z2) {
                this.F.setTextSize(this.C);
                this.F.setTypeface(this.u);
                this.F.setLinearText(this.B != 1.0f);
                boolean b2 = b(this.x);
                this.z = b2;
                int i3 = this.Y;
                if (i3 > 1 && !b2) {
                    i2 = i3;
                }
                try {
                    a2.j.b.d.l.a aVar = new a2.j.b.d.l.a(this.x, this.F, (int) width);
                    aVar.i = TextUtils.TruncateAt.END;
                    aVar.h = b2;
                    aVar.e = Layout.Alignment.ALIGN_NORMAL;
                    aVar.g = false;
                    aVar.f = i2;
                    staticLayout = aVar.a();
                } catch (a.C0043a e2) {
                    e2.getCause().getMessage();
                    staticLayout = null;
                }
                StaticLayout staticLayout2 = (StaticLayout) Preconditions.checkNotNull(staticLayout);
                this.T = staticLayout2;
                this.y = staticLayout2.getText();
            }
        }
    }

    public void draw(@NonNull Canvas canvas) {
        int save = canvas.save();
        if (this.y != null && this.b) {
            float lineLeft = (this.T.getLineLeft(0) + this.q) - (this.W * 2.0f);
            this.F.setTextSize(this.C);
            float f2 = this.q;
            float f3 = this.r;
            float f4 = this.B;
            if (f4 != 1.0f) {
                canvas.scale(f4, f4, f2, f3);
            }
            boolean z2 = true;
            if (this.Y <= 1 || this.z) {
                z2 = false;
            }
            if (z2) {
                int alpha = this.F.getAlpha();
                canvas.translate(lineLeft, f3);
                float f5 = (float) alpha;
                this.F.setAlpha((int) (this.V * f5));
                this.T.draw(canvas);
                this.F.setAlpha((int) (this.U * f5));
                int lineBaseline = this.T.getLineBaseline(0);
                CharSequence charSequence = this.X;
                float f6 = (float) lineBaseline;
                canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f6, this.F);
                String trim = this.X.toString().trim();
                if (trim.endsWith("…")) {
                    trim = trim.substring(0, trim.length() - 1);
                }
                this.F.setAlpha(alpha);
                canvas.drawText(trim, 0, Math.min(this.T.getLineEnd(0), trim.length()), 0.0f, f6, (Paint) this.F);
            } else {
                canvas.translate(f2, f3);
                this.T.draw(canvas);
            }
            canvas.restoreToCount(save);
        }
    }

    public final void e() {
        Bitmap bitmap = this.A;
        if (bitmap != null) {
            bitmap.recycle();
            this.A = null;
        }
    }

    @ColorInt
    public final int f(@Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.D;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    public void getCollapsedTextActualBounds(@NonNull RectF rectF, int i2, int i3) {
        float f2;
        float f3;
        int i4;
        float calculateCollapsedTextWidth;
        float f4;
        float calculateCollapsedTextWidth2;
        int i5;
        boolean b2 = b(this.x);
        this.z = b2;
        if (i3 == 17 || (i3 & 7) == 1) {
            f4 = ((float) i2) / 2.0f;
            calculateCollapsedTextWidth2 = calculateCollapsedTextWidth() / 2.0f;
        } else {
            if ((i3 & GravityCompat.END) == 8388613 || (i3 & 5) == 5) {
                if (b2) {
                    i5 = this.e.left;
                } else {
                    f4 = (float) this.e.right;
                    calculateCollapsedTextWidth2 = calculateCollapsedTextWidth();
                }
            } else if (b2) {
                f4 = (float) this.e.right;
                calculateCollapsedTextWidth2 = calculateCollapsedTextWidth();
            } else {
                i5 = this.e.left;
            }
            f2 = (float) i5;
            rectF.left = f2;
            Rect rect = this.e;
            rectF.top = (float) rect.top;
            if (i3 != 17 || (i3 & 7) == 1) {
                f3 = (((float) i2) / 2.0f) + (calculateCollapsedTextWidth() / 2.0f);
            } else {
                if ((i3 & GravityCompat.END) == 8388613 || (i3 & 5) == 5) {
                    if (this.z) {
                        calculateCollapsedTextWidth = calculateCollapsedTextWidth();
                        f3 = calculateCollapsedTextWidth + f2;
                    } else {
                        i4 = rect.right;
                    }
                } else if (this.z) {
                    i4 = rect.right;
                } else {
                    calculateCollapsedTextWidth = calculateCollapsedTextWidth();
                    f3 = calculateCollapsedTextWidth + f2;
                }
                f3 = (float) i4;
            }
            rectF.right = f3;
            rectF.bottom = getCollapsedTextHeight() + ((float) this.e.top);
        }
        f2 = f4 - calculateCollapsedTextWidth2;
        rectF.left = f2;
        Rect rect = this.e;
        rectF.top = (float) rect.top;
        if (i3 != 17) {
        }
        f3 = (((float) i2) / 2.0f) + (calculateCollapsedTextWidth() / 2.0f);
        rectF.right = f3;
        rectF.bottom = getCollapsedTextHeight() + ((float) this.e.top);
    }

    public ColorStateList getCollapsedTextColor() {
        return this.l;
    }

    public int getCollapsedTextGravity() {
        return this.h;
    }

    public float getCollapsedTextHeight() {
        TextPaint textPaint = this.G;
        textPaint.setTextSize(this.j);
        textPaint.setTypeface(this.s);
        textPaint.setLetterSpacing(this.R);
        return -this.G.ascent();
    }

    public float getCollapsedTextSize() {
        return this.j;
    }

    public Typeface getCollapsedTypeface() {
        Typeface typeface = this.s;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    @ColorInt
    public int getCurrentCollapsedTextColor() {
        return f(this.l);
    }

    public ColorStateList getExpandedTextColor() {
        return this.k;
    }

    public int getExpandedTextGravity() {
        return this.g;
    }

    public float getExpandedTextHeight() {
        TextPaint textPaint = this.G;
        textPaint.setTextSize(this.i);
        textPaint.setTypeface(this.t);
        textPaint.setLetterSpacing(this.S);
        return -this.G.ascent();
    }

    public float getExpandedTextSize() {
        return this.i;
    }

    public Typeface getExpandedTypeface() {
        Typeface typeface = this.t;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public float getExpansionFraction() {
        return this.c;
    }

    public int getMaxLines() {
        return this.Y;
    }

    @Nullable
    public CharSequence getText() {
        return this.x;
    }

    public void h() {
        this.b = this.e.width() > 0 && this.e.height() > 0 && this.d.width() > 0 && this.d.height() > 0;
    }

    public final boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.l;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.k) != null && colorStateList.isStateful());
    }

    public final void j(float f2) {
        d(f2);
        ViewCompat.postInvalidateOnAnimation(this.a);
    }

    public void recalculate() {
        StaticLayout staticLayout;
        if (this.a.getHeight() > 0 && this.a.getWidth() > 0) {
            float f2 = this.C;
            d(this.j);
            CharSequence charSequence = this.y;
            if (!(charSequence == null || (staticLayout = this.T) == null)) {
                this.X = TextUtils.ellipsize(charSequence, this.F, (float) staticLayout.getWidth(), TextUtils.TruncateAt.END);
            }
            CharSequence charSequence2 = this.X;
            float f3 = 0.0f;
            float measureText = charSequence2 != null ? this.F.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
            int absoluteGravity = GravityCompat.getAbsoluteGravity(this.h, this.z ? 1 : 0);
            int i2 = absoluteGravity & 112;
            if (i2 == 48) {
                this.n = (float) this.e.top;
            } else if (i2 != 80) {
                this.n = ((float) this.e.centerY()) - ((this.F.descent() - this.F.ascent()) / 2.0f);
            } else {
                this.n = this.F.ascent() + ((float) this.e.bottom);
            }
            int i3 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
            if (i3 == 1) {
                this.p = ((float) this.e.centerX()) - (measureText / 2.0f);
            } else if (i3 != 5) {
                this.p = (float) this.e.left;
            } else {
                this.p = ((float) this.e.right) - measureText;
            }
            d(this.i);
            StaticLayout staticLayout2 = this.T;
            float height = staticLayout2 != null ? (float) staticLayout2.getHeight() : 0.0f;
            CharSequence charSequence3 = this.y;
            float measureText2 = charSequence3 != null ? this.F.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
            StaticLayout staticLayout3 = this.T;
            if (staticLayout3 != null && this.Y > 1 && !this.z) {
                measureText2 = (float) staticLayout3.getWidth();
            }
            StaticLayout staticLayout4 = this.T;
            if (staticLayout4 != null) {
                f3 = staticLayout4.getLineLeft(0);
            }
            this.W = f3;
            int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.g, this.z ? 1 : 0);
            int i4 = absoluteGravity2 & 112;
            if (i4 == 48) {
                this.m = (float) this.d.top;
            } else if (i4 != 80) {
                this.m = ((float) this.d.centerY()) - (height / 2.0f);
            } else {
                this.m = this.F.descent() + (((float) this.d.bottom) - height);
            }
            int i5 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
            if (i5 == 1) {
                this.o = ((float) this.d.centerX()) - (measureText2 / 2.0f);
            } else if (i5 != 5) {
                this.o = (float) this.d.left;
            } else {
                this.o = ((float) this.d.right) - measureText2;
            }
            e();
            j(f2);
            c(this.c);
        }
    }

    public void setCollapsedBounds(int i2, int i3, int i4, int i5) {
        if (!i(this.e, i2, i3, i4, i5)) {
            this.e.set(i2, i3, i4, i5);
            this.E = true;
            h();
        }
    }

    public void setCollapsedTextAppearance(int i2) {
        TextAppearance textAppearance = new TextAppearance(this.a.getContext(), i2);
        ColorStateList colorStateList = textAppearance.textColor;
        if (colorStateList != null) {
            this.l = colorStateList;
        }
        float f2 = textAppearance.textSize;
        if (f2 != 0.0f) {
            this.j = f2;
        }
        ColorStateList colorStateList2 = textAppearance.shadowColor;
        if (colorStateList2 != null) {
            this.M = colorStateList2;
        }
        this.K = textAppearance.shadowDx;
        this.L = textAppearance.shadowDy;
        this.J = textAppearance.shadowRadius;
        this.R = textAppearance.letterSpacing;
        CancelableFontCallback cancelableFontCallback = this.w;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        this.w = new CancelableFontCallback(new a(), textAppearance.getFallbackFont());
        textAppearance.getFontAsync(this.a.getContext(), this.w);
        recalculate();
    }

    public void setCollapsedTextColor(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            recalculate();
        }
    }

    public void setCollapsedTextGravity(int i2) {
        if (this.h != i2) {
            this.h = i2;
            recalculate();
        }
    }

    public void setCollapsedTextSize(float f2) {
        if (this.j != f2) {
            this.j = f2;
            recalculate();
        }
    }

    public void setCollapsedTypeface(Typeface typeface) {
        boolean z2;
        CancelableFontCallback cancelableFontCallback = this.w;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        if (this.s != typeface) {
            this.s = typeface;
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            recalculate();
        }
    }

    public void setExpandedBounds(int i2, int i3, int i4, int i5) {
        if (!i(this.d, i2, i3, i4, i5)) {
            this.d.set(i2, i3, i4, i5);
            this.E = true;
            h();
        }
    }

    public void setExpandedTextAppearance(int i2) {
        TextAppearance textAppearance = new TextAppearance(this.a.getContext(), i2);
        ColorStateList colorStateList = textAppearance.textColor;
        if (colorStateList != null) {
            this.k = colorStateList;
        }
        float f2 = textAppearance.textSize;
        if (f2 != 0.0f) {
            this.i = f2;
        }
        ColorStateList colorStateList2 = textAppearance.shadowColor;
        if (colorStateList2 != null) {
            this.Q = colorStateList2;
        }
        this.O = textAppearance.shadowDx;
        this.P = textAppearance.shadowDy;
        this.N = textAppearance.shadowRadius;
        this.S = textAppearance.letterSpacing;
        CancelableFontCallback cancelableFontCallback = this.v;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        this.v = new CancelableFontCallback(new b(), textAppearance.getFallbackFont());
        textAppearance.getFontAsync(this.a.getContext(), this.v);
        recalculate();
    }

    public void setExpandedTextColor(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            recalculate();
        }
    }

    public void setExpandedTextGravity(int i2) {
        if (this.g != i2) {
            this.g = i2;
            recalculate();
        }
    }

    public void setExpandedTextSize(float f2) {
        if (this.i != f2) {
            this.i = f2;
            recalculate();
        }
    }

    public void setExpandedTypeface(Typeface typeface) {
        boolean z2;
        CancelableFontCallback cancelableFontCallback = this.v;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        if (this.t != typeface) {
            this.t = typeface;
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            recalculate();
        }
    }

    public void setExpansionFraction(float f2) {
        float clamp = MathUtils.clamp(f2, 0.0f, 1.0f);
        if (clamp != this.c) {
            this.c = clamp;
            c(clamp);
        }
    }

    public void setMaxLines(int i2) {
        if (i2 != this.Y) {
            this.Y = i2;
            e();
            recalculate();
        }
    }

    public void setPositionInterpolator(TimeInterpolator timeInterpolator) {
        this.H = timeInterpolator;
        recalculate();
    }

    public final boolean setState(int[] iArr) {
        this.D = iArr;
        if (!isStateful()) {
            return false;
        }
        recalculate();
        return true;
    }

    public void setText(@Nullable CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.x, charSequence)) {
            this.x = charSequence;
            this.y = null;
            e();
            recalculate();
        }
    }

    public void setTextSizeInterpolator(TimeInterpolator timeInterpolator) {
        this.I = timeInterpolator;
        recalculate();
    }

    public void setTypefaces(Typeface typeface) {
        boolean z2;
        CancelableFontCallback cancelableFontCallback = this.w;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        boolean z3 = false;
        if (this.s != typeface) {
            this.s = typeface;
            z2 = true;
        } else {
            z2 = false;
        }
        CancelableFontCallback cancelableFontCallback2 = this.v;
        if (cancelableFontCallback2 != null) {
            cancelableFontCallback2.cancel();
        }
        if (this.t != typeface) {
            this.t = typeface;
            z3 = true;
        }
        if (z2 || z3) {
            recalculate();
        }
    }

    public void setCollapsedBounds(@NonNull Rect rect) {
        setCollapsedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setExpandedBounds(@NonNull Rect rect) {
        setExpandedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }
}
