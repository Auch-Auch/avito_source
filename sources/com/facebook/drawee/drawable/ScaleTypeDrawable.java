package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.drawable.ScalingUtils;
import javax.annotation.Nullable;
public class ScaleTypeDrawable extends ForwardingDrawable {
    @VisibleForTesting
    public ScalingUtils.ScaleType d;
    @VisibleForTesting
    public Object e;
    @VisibleForTesting
    @Nullable
    public PointF f = null;
    @VisibleForTesting
    public int g = 0;
    @VisibleForTesting
    public int h = 0;
    @VisibleForTesting
    public Matrix i;
    public Matrix j = new Matrix();

    public ScaleTypeDrawable(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        super((Drawable) Preconditions.checkNotNull(drawable));
        this.d = scaleType;
    }

    @VisibleForTesting
    public void a() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.g = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.h = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.i = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            current.setBounds(bounds);
            this.i = null;
        } else if (this.d == ScalingUtils.ScaleType.FIT_XY) {
            current.setBounds(bounds);
            this.i = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            ScalingUtils.ScaleType scaleType = this.d;
            Matrix matrix = this.j;
            PointF pointF = this.f;
            scaleType.getTransform(matrix, bounds, intrinsicWidth, intrinsicHeight, pointF != null ? pointF.x : 0.5f, pointF != null ? pointF.y : 0.5f);
            this.i = this.j;
        }
    }

    public final void b() {
        boolean z;
        ScalingUtils.ScaleType scaleType = this.d;
        boolean z2 = true;
        if (scaleType instanceof ScalingUtils.StatefulScaleType) {
            Object state = ((ScalingUtils.StatefulScaleType) scaleType).getState();
            z = state == null || !state.equals(this.e);
            this.e = state;
        } else {
            z = false;
        }
        if (this.g == getCurrent().getIntrinsicWidth() && this.h == getCurrent().getIntrinsicHeight()) {
            z2 = false;
        }
        if (z2 || z) {
            a();
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b();
        if (this.i != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.i);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    @Nullable
    public PointF getFocusPoint() {
        return this.f;
    }

    public ScalingUtils.ScaleType getScaleType() {
        return this.d;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, com.facebook.drawee.drawable.TransformCallback
    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
        b();
        Matrix matrix2 = this.i;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        a();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable
    public Drawable setCurrent(Drawable drawable) {
        Drawable current = super.setCurrent(drawable);
        a();
        return current;
    }

    public void setFocusPoint(@Nullable PointF pointF) {
        if (!Objects.equal(this.f, pointF)) {
            if (pointF == null) {
                this.f = null;
            } else {
                if (this.f == null) {
                    this.f = new PointF();
                }
                this.f.set(pointF);
            }
            a();
            invalidateSelf();
        }
    }

    public void setScaleType(ScalingUtils.ScaleType scaleType) {
        if (!Objects.equal(this.d, scaleType)) {
            this.d = scaleType;
            this.e = null;
            a();
            invalidateSelf();
        }
    }

    public ScaleTypeDrawable(Drawable drawable, ScalingUtils.ScaleType scaleType, @Nullable PointF pointF) {
        super((Drawable) Preconditions.checkNotNull(drawable));
        this.d = scaleType;
        this.f = pointF;
    }
}
