package a2.j.b.d.n;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;
public final class a extends h<CircularProgressIndicatorSpec> {
    public int c = 1;
    public float d;
    public float e;
    public float f;

    public a(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
    }

    @Override // a2.j.b.d.n.h
    public void a(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        S s = this.a;
        float f3 = (((float) ((CircularProgressIndicatorSpec) s).indicatorSize) / 2.0f) + ((float) ((CircularProgressIndicatorSpec) s).indicatorInset);
        canvas.translate(f3, f3);
        canvas.rotate(-90.0f);
        float f4 = -f3;
        canvas.clipRect(f4, f4, f3, f3);
        S s2 = this.a;
        this.c = ((CircularProgressIndicatorSpec) s2).indicatorDirection == 0 ? 1 : -1;
        this.d = ((float) ((CircularProgressIndicatorSpec) s2).trackThickness) * f2;
        this.e = ((float) ((CircularProgressIndicatorSpec) s2).trackCornerRadius) * f2;
        this.f = ((float) (((CircularProgressIndicatorSpec) s2).indicatorSize - ((CircularProgressIndicatorSpec) s2).trackThickness)) / 2.0f;
        if ((this.b.isShowing() && ((CircularProgressIndicatorSpec) this.a).showAnimationBehavior == 2) || (this.b.isHiding() && ((CircularProgressIndicatorSpec) this.a).hideAnimationBehavior == 1)) {
            this.f = (((1.0f - f2) * ((float) ((CircularProgressIndicatorSpec) this.a).trackThickness)) / 2.0f) + this.f;
        } else if ((this.b.isShowing() && ((CircularProgressIndicatorSpec) this.a).showAnimationBehavior == 1) || (this.b.isHiding() && ((CircularProgressIndicatorSpec) this.a).hideAnimationBehavior == 2)) {
            this.f -= ((1.0f - f2) * ((float) ((CircularProgressIndicatorSpec) this.a).trackThickness)) / 2.0f;
        }
    }

    @Override // a2.j.b.d.n.h
    public void b(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @ColorInt int i) {
        if (f2 != f3) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(Paint.Cap.BUTT);
            paint.setAntiAlias(true);
            paint.setColor(i);
            paint.setStrokeWidth(this.d);
            float f4 = (float) this.c;
            float f5 = f2 * 360.0f * f4;
            if (f3 < f2) {
                f3 += 1.0f;
            }
            float f6 = (f3 - f2) * 360.0f * f4;
            float f7 = this.f;
            float f8 = -f7;
            canvas.drawArc(new RectF(f8, f8, f7, f7), f5, f6, false, paint);
            if (this.e > 0.0f && Math.abs(f6) < 360.0f) {
                paint.setStyle(Paint.Style.FILL);
                float f9 = this.e;
                float f10 = -f9;
                RectF rectF = new RectF(f10, f10, f9, f9);
                f(canvas, paint, this.d, this.e, f5, true, rectF);
                f(canvas, paint, this.d, this.e, f5 + f6, false, rectF);
            }
        }
    }

    @Override // a2.j.b.d.n.h
    public void c(@NonNull Canvas canvas, @NonNull Paint paint) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(((CircularProgressIndicatorSpec) this.a).trackColor, this.b.getAlpha());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(compositeARGBWithAlpha);
        paint.setStrokeWidth(this.d);
        float f2 = this.f;
        float f3 = -f2;
        canvas.drawArc(new RectF(f3, f3, f2, f2), 0.0f, 360.0f, false, paint);
    }

    @Override // a2.j.b.d.n.h
    public int d() {
        CircularProgressIndicatorSpec circularProgressIndicatorSpec = (CircularProgressIndicatorSpec) this.a;
        return (circularProgressIndicatorSpec.indicatorInset * 2) + circularProgressIndicatorSpec.indicatorSize;
    }

    @Override // a2.j.b.d.n.h
    public int e() {
        CircularProgressIndicatorSpec circularProgressIndicatorSpec = (CircularProgressIndicatorSpec) this.a;
        return (circularProgressIndicatorSpec.indicatorInset * 2) + circularProgressIndicatorSpec.indicatorSize;
    }

    public final void f(Canvas canvas, Paint paint, float f2, float f3, float f4, boolean z, RectF rectF) {
        float f5 = z ? -1.0f : 1.0f;
        canvas.save();
        canvas.rotate(f4);
        float f6 = f2 / 2.0f;
        float f7 = f5 * f3;
        canvas.drawRect((this.f - f6) + f3, Math.min(0.0f, ((float) this.c) * f7), (this.f + f6) - f3, Math.max(0.0f, f7 * ((float) this.c)), paint);
        canvas.translate((this.f - f6) + f3, 0.0f);
        canvas.drawArc(rectF, 180.0f, (-f5) * 90.0f * ((float) this.c), true, paint);
        canvas.translate(f2 - (f3 * 2.0f), 0.0f);
        canvas.drawArc(rectF, 0.0f, f5 * 90.0f * ((float) this.c), true, paint);
        canvas.restore();
    }
}
