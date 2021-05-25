package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public abstract class RoundedBitmapDrawable extends Drawable {
    public final Bitmap a;
    public int b = 160;
    public int c = 119;
    public final Paint d = new Paint(3);
    public final BitmapShader e;
    public final Matrix f = new Matrix();
    public float g;
    public final Rect h = new Rect();
    public final RectF i = new RectF();
    public boolean j = true;
    public boolean k;
    public int l;
    public int m;

    public RoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        if (resources != null) {
            this.b = resources.getDisplayMetrics().densityDpi;
        }
        this.a = bitmap;
        if (bitmap != null) {
            a();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.e = new BitmapShader(bitmap, tileMode, tileMode);
            return;
        }
        this.m = -1;
        this.l = -1;
        this.e = null;
    }

    public final void a() {
        this.l = this.a.getScaledWidth(this.b);
        this.m = this.a.getScaledHeight(this.b);
    }

    public void b(int i2, int i3, int i4, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    public void c() {
        if (this.j) {
            if (this.k) {
                int min = Math.min(this.l, this.m);
                b(this.c, min, min, getBounds(), this.h);
                int min2 = Math.min(this.h.width(), this.h.height());
                this.h.inset(Math.max(0, (this.h.width() - min2) / 2), Math.max(0, (this.h.height() - min2) / 2));
                this.g = ((float) min2) * 0.5f;
            } else {
                b(this.c, this.l, this.m, getBounds(), this.h);
            }
            this.i.set(this.h);
            if (this.e != null) {
                Matrix matrix = this.f;
                RectF rectF = this.i;
                matrix.setTranslate(rectF.left, rectF.top);
                this.f.preScale(this.i.width() / ((float) this.a.getWidth()), this.i.height() / ((float) this.a.getHeight()));
                this.e.setLocalMatrix(this.f);
                this.d.setShader(this.e);
            }
            this.j = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Bitmap bitmap = this.a;
        if (bitmap != null) {
            c();
            if (this.d.getShader() == null) {
                canvas.drawBitmap(bitmap, (Rect) null, this.h, this.d);
                return;
            }
            RectF rectF = this.i;
            float f2 = this.g;
            canvas.drawRoundRect(rectF, f2, f2, this.d);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.d.getAlpha();
    }

    @Nullable
    public final Bitmap getBitmap() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.d.getColorFilter();
    }

    public float getCornerRadius() {
        return this.g;
    }

    public int getGravity() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap;
        if (this.c == 119 && !this.k && (bitmap = this.a) != null && !bitmap.hasAlpha() && this.d.getAlpha() >= 255) {
            if (!(this.g > 0.05f)) {
                return -1;
            }
        }
        return -3;
    }

    @NonNull
    public final Paint getPaint() {
        return this.d;
    }

    public boolean hasAntiAlias() {
        return this.d.isAntiAlias();
    }

    public boolean hasMipMap() {
        throw new UnsupportedOperationException();
    }

    public boolean isCircular() {
        return this.k;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.k) {
            this.g = (float) (Math.min(this.m, this.l) / 2);
        }
        this.j = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (i2 != this.d.getAlpha()) {
            this.d.setAlpha(i2);
            invalidateSelf();
        }
    }

    public void setAntiAlias(boolean z) {
        this.d.setAntiAlias(z);
        invalidateSelf();
    }

    public void setCircular(boolean z) {
        this.k = z;
        this.j = true;
        if (z) {
            this.g = (float) (Math.min(this.m, this.l) / 2);
            this.d.setShader(this.e);
            invalidateSelf();
            return;
        }
        setCornerRadius(0.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.d.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setCornerRadius(float f2) {
        if (this.g != f2) {
            boolean z = false;
            this.k = false;
            if (f2 > 0.05f) {
                z = true;
            }
            if (z) {
                this.d.setShader(this.e);
            } else {
                this.d.setShader(null);
            }
            this.g = f2;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.d.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.d.setFilterBitmap(z);
        invalidateSelf();
    }

    public void setGravity(int i2) {
        if (this.c != i2) {
            this.c = i2;
            this.j = true;
            invalidateSelf();
        }
    }

    public void setMipMap(boolean z) {
        throw new UnsupportedOperationException();
    }

    public void setTargetDensity(@NonNull Canvas canvas) {
        setTargetDensity(canvas.getDensity());
    }

    public void setTargetDensity(@NonNull DisplayMetrics displayMetrics) {
        setTargetDensity(displayMetrics.densityDpi);
    }

    public void setTargetDensity(int i2) {
        if (this.b != i2) {
            if (i2 == 0) {
                i2 = 160;
            }
            this.b = i2;
            if (this.a != null) {
                a();
            }
            invalidateSelf();
        }
    }
}
