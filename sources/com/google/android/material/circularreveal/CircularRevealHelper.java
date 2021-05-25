package com.google.android.material.circularreveal;

import a2.b.a.a.a;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.math.MathUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
public class CircularRevealHelper {
    public static final int BITMAP_SHADER = 0;
    public static final int CLIP_PATH = 1;
    public static final int REVEAL_ANIMATOR = 2;
    public static final int STRATEGY = 2;
    public final Delegate a;
    @NonNull
    public final View b;
    @NonNull
    public final Path c = new Path();
    @NonNull
    public final Paint d = new Paint(7);
    @NonNull
    public final Paint e;
    @Nullable
    public CircularRevealWidget.RevealInfo f;
    @Nullable
    public Drawable g;
    public boolean h;
    public boolean i;

    public interface Delegate {
        void actualDraw(Canvas canvas);

        boolean actualIsOpaque();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Strategy {
    }

    public CircularRevealHelper(Delegate delegate) {
        this.a = delegate;
        View view = (View) delegate;
        this.b = view;
        view.setWillNotDraw(false);
        Paint paint = new Paint(1);
        this.e = paint;
        paint.setColor(0);
    }

    public final float a(@NonNull CircularRevealWidget.RevealInfo revealInfo) {
        return MathUtils.distanceToFurthestCorner(revealInfo.centerX, revealInfo.centerY, 0.0f, 0.0f, (float) this.b.getWidth(), (float) this.b.getHeight());
    }

    public final boolean b() {
        CircularRevealWidget.RevealInfo revealInfo = this.f;
        boolean z = revealInfo == null || revealInfo.isInvalid();
        if (STRATEGY != 0) {
            return !z;
        }
        if (z || !this.i) {
            return false;
        }
        return true;
    }

    public void buildCircularRevealCache() {
        if (STRATEGY == 0) {
            this.h = true;
            this.i = false;
            this.b.buildDrawingCache();
            Bitmap drawingCache = this.b.getDrawingCache();
            if (!(drawingCache != null || this.b.getWidth() == 0 || this.b.getHeight() == 0)) {
                drawingCache = Bitmap.createBitmap(this.b.getWidth(), this.b.getHeight(), Bitmap.Config.ARGB_8888);
                this.b.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.d;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.h = false;
            this.i = true;
        }
    }

    public final boolean c() {
        return !this.h && Color.alpha(this.e.getColor()) != 0;
    }

    public void destroyCircularRevealCache() {
        if (STRATEGY == 0) {
            this.i = false;
            this.b.destroyDrawingCache();
            this.d.setShader(null);
            this.b.invalidate();
        }
    }

    public void draw(@NonNull Canvas canvas) {
        boolean z = true;
        if (b()) {
            int i2 = STRATEGY;
            if (i2 == 0) {
                CircularRevealWidget.RevealInfo revealInfo = this.f;
                canvas.drawCircle(revealInfo.centerX, revealInfo.centerY, revealInfo.radius, this.d);
                if (c()) {
                    CircularRevealWidget.RevealInfo revealInfo2 = this.f;
                    canvas.drawCircle(revealInfo2.centerX, revealInfo2.centerY, revealInfo2.radius, this.e);
                }
            } else if (i2 == 1) {
                int save = canvas.save();
                canvas.clipPath(this.c);
                this.a.actualDraw(canvas);
                if (c()) {
                    canvas.drawRect(0.0f, 0.0f, (float) this.b.getWidth(), (float) this.b.getHeight(), this.e);
                }
                canvas.restoreToCount(save);
            } else if (i2 == 2) {
                this.a.actualDraw(canvas);
                if (c()) {
                    canvas.drawRect(0.0f, 0.0f, (float) this.b.getWidth(), (float) this.b.getHeight(), this.e);
                }
            } else {
                throw new IllegalStateException(a.M2("Unsupported strategy ", i2));
            }
        } else {
            this.a.actualDraw(canvas);
            if (c()) {
                canvas.drawRect(0.0f, 0.0f, (float) this.b.getWidth(), (float) this.b.getHeight(), this.e);
            }
        }
        if (this.h || this.g == null || this.f == null) {
            z = false;
        }
        if (z) {
            Rect bounds = this.g.getBounds();
            float width = this.f.centerX - (((float) bounds.width()) / 2.0f);
            float height = this.f.centerY - (((float) bounds.height()) / 2.0f);
            canvas.translate(width, height);
            this.g.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        return this.g;
    }

    @ColorInt
    public int getCircularRevealScrimColor() {
        return this.e.getColor();
    }

    @Nullable
    public CircularRevealWidget.RevealInfo getRevealInfo() {
        CircularRevealWidget.RevealInfo revealInfo = this.f;
        if (revealInfo == null) {
            return null;
        }
        CircularRevealWidget.RevealInfo revealInfo2 = new CircularRevealWidget.RevealInfo(revealInfo);
        if (revealInfo2.isInvalid()) {
            revealInfo2.radius = a(revealInfo2);
        }
        return revealInfo2;
    }

    public boolean isOpaque() {
        return this.a.actualIsOpaque() && !b();
    }

    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        this.g = drawable;
        this.b.invalidate();
    }

    public void setCircularRevealScrimColor(@ColorInt int i2) {
        this.e.setColor(i2);
        this.b.invalidate();
    }

    public void setRevealInfo(@Nullable CircularRevealWidget.RevealInfo revealInfo) {
        if (revealInfo == null) {
            this.f = null;
        } else {
            CircularRevealWidget.RevealInfo revealInfo2 = this.f;
            if (revealInfo2 == null) {
                this.f = new CircularRevealWidget.RevealInfo(revealInfo);
            } else {
                revealInfo2.set(revealInfo);
            }
            if (MathUtils.geq(revealInfo.radius, a(revealInfo), 1.0E-4f)) {
                this.f.radius = Float.MAX_VALUE;
            }
        }
        if (STRATEGY == 1) {
            this.c.rewind();
            CircularRevealWidget.RevealInfo revealInfo3 = this.f;
            if (revealInfo3 != null) {
                this.c.addCircle(revealInfo3.centerX, revealInfo3.centerY, revealInfo3.radius, Path.Direction.CW);
            }
        }
        this.b.invalidate();
    }
}
