package com.facebook.drawee.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
public class RoundedBitmapDrawable extends RoundedDrawable {
    private WeakReference<Bitmap> mLastBitmap;
    public final Paint w;
    public final Paint x;
    @Nullable
    public final Bitmap y;

    public RoundedBitmapDrawable(Resources resources, @Nullable Bitmap bitmap, @Nullable Paint paint) {
        super(new BitmapDrawable(resources, bitmap));
        Paint paint2 = new Paint();
        this.w = paint2;
        Paint paint3 = new Paint(1);
        this.x = paint3;
        this.y = bitmap;
        if (paint != null) {
            paint2.set(paint);
        }
        paint2.setFlags(1);
        paint3.setStyle(Paint.Style.STROKE);
    }

    public static RoundedBitmapDrawable fromBitmapDrawable(Resources resources, BitmapDrawable bitmapDrawable) {
        return new RoundedBitmapDrawable(resources, bitmapDrawable.getBitmap(), bitmapDrawable.getPaint());
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable
    @VisibleForTesting
    public boolean a() {
        return super.a() && this.y != null;
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("RoundedBitmapDrawable#draw");
        }
        if (!(super.a() && this.y != null)) {
            super.draw(canvas);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
                return;
            }
            return;
        }
        updateTransform();
        updatePath();
        WeakReference<Bitmap> weakReference = this.mLastBitmap;
        if (weakReference == null || weakReference.get() != this.y) {
            this.mLastBitmap = new WeakReference<>(this.y);
            Paint paint = this.w;
            Bitmap bitmap = this.y;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
            this.mIsShaderTransformDirty = true;
        }
        if (this.mIsShaderTransformDirty) {
            this.w.getShader().setLocalMatrix(this.q);
            this.mIsShaderTransformDirty = false;
        }
        this.w.setFilterBitmap(getPaintFilterBitmap());
        int save = canvas.save();
        canvas.concat(this.n);
        canvas.drawPath(this.mPath, this.w);
        float f = this.mBorderWidth;
        if (f > 0.0f) {
            this.x.setStrokeWidth(f);
            this.x.setColor(DrawableUtils.multiplyColorAlpha(this.mBorderColor, this.w.getAlpha()));
            canvas.drawPath(this.mBorderPath, this.x);
        }
        canvas.restoreToCount(save);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        super.setAlpha(i);
        if (i != this.w.getAlpha()) {
            this.w.setAlpha(i);
            super.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
        this.w.setColorFilter(colorFilter);
    }

    public RoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        this(resources, bitmap, null);
    }
}
