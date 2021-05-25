package com.facebook.widget.text.span;

import a2.b.a.a.a;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
public class BetterImageSpan extends ReplacementSpan {
    public static final int ALIGN_BASELINE = 1;
    public static final int ALIGN_BOTTOM = 0;
    public static final int ALIGN_CENTER = 2;
    public int a;
    public int b;
    public Rect c;
    public final int d;
    public final Paint.FontMetricsInt e;
    public final Drawable f;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BetterImageSpanAlignment {
    }

    public BetterImageSpan(Drawable drawable) {
        this(drawable, 1);
    }

    public static final int normalizeAlignment(int i) {
        if (i != 0) {
            return i != 2 ? 1 : 2;
        }
        return 0;
    }

    public final int a(Paint.FontMetricsInt fontMetricsInt) {
        int i = this.d;
        if (i == 0) {
            return fontMetricsInt.descent - this.b;
        }
        if (i != 2) {
            return -this.b;
        }
        int i2 = fontMetricsInt.descent;
        int i3 = fontMetricsInt.ascent;
        return a.R1(i2 - i3, this.b, 2, i3);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
        paint.getFontMetricsInt(this.e);
        int a3 = a(this.e) + i4;
        canvas.translate(f2, (float) a3);
        this.f.draw(canvas);
        canvas.translate(-f2, (float) (-a3));
    }

    public Drawable getDrawable() {
        return this.f;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        updateBounds();
        if (fontMetricsInt == null) {
            return this.a;
        }
        int a3 = a(fontMetricsInt);
        int i3 = this.b + a3;
        if (a3 < fontMetricsInt.ascent) {
            fontMetricsInt.ascent = a3;
        }
        if (a3 < fontMetricsInt.top) {
            fontMetricsInt.top = a3;
        }
        if (i3 > fontMetricsInt.descent) {
            fontMetricsInt.descent = i3;
        }
        if (i3 > fontMetricsInt.bottom) {
            fontMetricsInt.bottom = i3;
        }
        return this.a;
    }

    public void updateBounds() {
        Rect bounds = this.f.getBounds();
        this.c = bounds;
        this.a = bounds.width();
        this.b = this.c.height();
    }

    public BetterImageSpan(Drawable drawable, int i) {
        this.e = new Paint.FontMetricsInt();
        this.f = drawable;
        this.d = i;
        updateBounds();
    }
}
