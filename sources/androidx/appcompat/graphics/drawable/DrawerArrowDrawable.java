package androidx.appcompat.graphics.drawable;

import a2.b.a.a.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.maps.android.heatmaps.WeightedLatLng;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
public class DrawerArrowDrawable extends Drawable {
    public static final int ARROW_DIRECTION_END = 3;
    public static final int ARROW_DIRECTION_LEFT = 0;
    public static final int ARROW_DIRECTION_RIGHT = 1;
    public static final int ARROW_DIRECTION_START = 2;
    public static final float m = ((float) Math.toRadians(45.0d));
    public final Paint a;
    public float b;
    public float c;
    public float d;
    public float e;
    public boolean f;
    public final Path g = new Path();
    public final int h;
    public boolean i = false;
    public float j;
    public float k;
    public int l = 2;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ArrowDirection {
    }

    public DrawerArrowDrawable(Context context) {
        Paint paint = new Paint();
        this.a = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        setColor(obtainStyledAttributes.getColor(R.styleable.DrawerArrowToggle_color, 0));
        setBarThickness(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0f));
        setSpinEnabled(obtainStyledAttributes.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true));
        setGapSize((float) Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.c = (float) Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_barLength, 0.0f));
        this.b = (float) Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.d = obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public static float a(float f2, float f3, float f4) {
        return a.b(f3, f2, f4, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i2 = this.l;
        boolean z = false;
        if (i2 != 0 && (i2 == 1 || (i2 == 3 ? DrawableCompat.getLayoutDirection(this) == 0 : DrawableCompat.getLayoutDirection(this) == 1))) {
            z = true;
        }
        float f2 = this.b;
        float a3 = a(this.c, (float) Math.sqrt((double) (f2 * f2 * 2.0f)), this.j);
        float a4 = a(this.c, this.d, this.j);
        float round = (float) Math.round(a(0.0f, this.k, this.j));
        float a5 = a(0.0f, m, this.j);
        float a6 = a(z ? 0.0f : -180.0f, z ? 180.0f : 0.0f, this.j);
        double d2 = (double) a3;
        double d3 = (double) a5;
        float round2 = (float) Math.round(Math.cos(d3) * d2);
        float round3 = (float) Math.round(Math.sin(d3) * d2);
        this.g.rewind();
        float a8 = a(this.a.getStrokeWidth() + this.e, -this.k, this.j);
        float f3 = (-a4) / 2.0f;
        this.g.moveTo(f3 + round, 0.0f);
        this.g.rLineTo(a4 - (round * 2.0f), 0.0f);
        this.g.moveTo(f3, a8);
        this.g.rLineTo(round2, round3);
        this.g.moveTo(f3, -a8);
        this.g.rLineTo(round2, -round3);
        this.g.close();
        canvas.save();
        float strokeWidth = this.a.getStrokeWidth();
        float height = ((float) bounds.height()) - (3.0f * strokeWidth);
        float f4 = this.e;
        canvas.translate((float) bounds.centerX(), (strokeWidth * 1.5f) + f4 + ((float) ((((int) (height - (2.0f * f4))) / 4) * 2)));
        if (this.f) {
            canvas.rotate(a6 * ((float) (this.i ^ z ? -1 : 1)));
        } else if (z) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.g, this.a);
        canvas.restore();
    }

    public float getArrowHeadLength() {
        return this.b;
    }

    public float getArrowShaftLength() {
        return this.d;
    }

    public float getBarLength() {
        return this.c;
    }

    public float getBarThickness() {
        return this.a.getStrokeWidth();
    }

    @ColorInt
    public int getColor() {
        return this.a.getColor();
    }

    public int getDirection() {
        return this.l;
    }

    public float getGapSize() {
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final Paint getPaint() {
        return this.a;
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getProgress() {
        return this.j;
    }

    public boolean isSpinEnabled() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (i2 != this.a.getAlpha()) {
            this.a.setAlpha(i2);
            invalidateSelf();
        }
    }

    public void setArrowHeadLength(float f2) {
        if (this.b != f2) {
            this.b = f2;
            invalidateSelf();
        }
    }

    public void setArrowShaftLength(float f2) {
        if (this.d != f2) {
            this.d = f2;
            invalidateSelf();
        }
    }

    public void setBarLength(float f2) {
        if (this.c != f2) {
            this.c = f2;
            invalidateSelf();
        }
    }

    public void setBarThickness(float f2) {
        if (this.a.getStrokeWidth() != f2) {
            this.a.setStrokeWidth(f2);
            this.k = (float) (Math.cos((double) m) * ((double) (f2 / 2.0f)));
            invalidateSelf();
        }
    }

    public void setColor(@ColorInt int i2) {
        if (i2 != this.a.getColor()) {
            this.a.setColor(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setDirection(int i2) {
        if (i2 != this.l) {
            this.l = i2;
            invalidateSelf();
        }
    }

    public void setGapSize(float f2) {
        if (f2 != this.e) {
            this.e = f2;
            invalidateSelf();
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.j != f2) {
            this.j = f2;
            invalidateSelf();
        }
    }

    public void setSpinEnabled(boolean z) {
        if (this.f != z) {
            this.f = z;
            invalidateSelf();
        }
    }

    public void setVerticalMirror(boolean z) {
        if (this.i != z) {
            this.i = z;
            invalidateSelf();
        }
    }
}
