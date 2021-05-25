package a2.j.b.d.n;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
public final class j extends h<LinearProgressIndicatorSpec> {
    public float c = 300.0f;
    public float d;
    public float e;

    public j(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
    }

    public static void f(Canvas canvas, Paint paint, float f, float f2, float f3, boolean z, RectF rectF) {
        canvas.save();
        canvas.translate(f3, 0.0f);
        if (!z) {
            canvas.rotate(180.0f);
        }
        float f4 = ((-f) / 2.0f) + f2;
        float f5 = (f / 2.0f) - f2;
        canvas.drawRect(-f2, f4, 0.0f, f5, paint);
        canvas.save();
        canvas.translate(0.0f, f4);
        canvas.drawArc(rectF, 180.0f, 90.0f, true, paint);
        canvas.restore();
        canvas.translate(0.0f, f5);
        canvas.drawArc(rectF, 180.0f, -90.0f, true, paint);
        canvas.restore();
    }

    @Override // a2.j.b.d.n.h
    public void a(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        Rect clipBounds = canvas.getClipBounds();
        this.c = (float) clipBounds.width();
        float f2 = (float) ((LinearProgressIndicatorSpec) this.a).trackThickness;
        canvas.translate(((float) clipBounds.width()) / 2.0f, Math.max(0.0f, ((float) (clipBounds.height() - ((LinearProgressIndicatorSpec) this.a).trackThickness)) / 2.0f) + (((float) clipBounds.height()) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.a).a) {
            canvas.scale(-1.0f, 1.0f);
        }
        if ((this.b.isShowing() && ((LinearProgressIndicatorSpec) this.a).showAnimationBehavior == 1) || (this.b.isHiding() && ((LinearProgressIndicatorSpec) this.a).hideAnimationBehavior == 2)) {
            canvas.scale(1.0f, -1.0f);
        }
        if (this.b.isShowing() || this.b.isHiding()) {
            canvas.translate(0.0f, ((f - 1.0f) * ((float) ((LinearProgressIndicatorSpec) this.a).trackThickness)) / 2.0f);
        }
        float f3 = this.c;
        canvas.clipRect((-f3) / 2.0f, (-f2) / 2.0f, f3 / 2.0f, f2 / 2.0f);
        S s = this.a;
        this.d = ((float) ((LinearProgressIndicatorSpec) s).trackThickness) * f;
        this.e = ((float) ((LinearProgressIndicatorSpec) s).trackCornerRadius) * f;
    }

    @Override // a2.j.b.d.n.h
    public void b(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2, @ColorInt int i) {
        if (f != f2) {
            float f3 = this.c;
            float f4 = this.e;
            float f5 = ((-f3) / 2.0f) + f4;
            float f6 = f3 - (f4 * 2.0f);
            float f7 = (f * f6) + f5;
            float f8 = (f6 * f2) + f5;
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            paint.setColor(i);
            float f9 = this.d;
            canvas.drawRect(f7, (-f9) / 2.0f, f8, f9 / 2.0f, paint);
            float f10 = this.e;
            float f11 = -f10;
            RectF rectF = new RectF(f11, f11, f10, f10);
            f(canvas, paint, this.d, this.e, f7, true, rectF);
            f(canvas, paint, this.d, this.e, f8, false, rectF);
        }
    }

    @Override // a2.j.b.d.n.h
    public void c(@NonNull Canvas canvas, @NonNull Paint paint) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(((LinearProgressIndicatorSpec) this.a).trackColor, this.b.getAlpha());
        float f = ((-this.c) / 2.0f) + this.e;
        float f2 = -f;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(compositeARGBWithAlpha);
        float f3 = this.d;
        canvas.drawRect(f, (-f3) / 2.0f, f2, f3 / 2.0f, paint);
        float f4 = this.e;
        float f5 = -f4;
        RectF rectF = new RectF(f5, f5, f4, f4);
        f(canvas, paint, this.d, this.e, f, true, rectF);
        f(canvas, paint, this.d, this.e, f2, false, rectF);
    }

    @Override // a2.j.b.d.n.h
    public int d() {
        return ((LinearProgressIndicatorSpec) this.a).trackThickness;
    }

    @Override // a2.j.b.d.n.h
    public int e() {
        return -1;
    }
}
