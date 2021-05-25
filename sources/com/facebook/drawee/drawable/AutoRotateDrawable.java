package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
public class AutoRotateDrawable extends ForwardingDrawable implements Runnable, CloneableDrawable {
    public int d;
    public boolean e;
    @VisibleForTesting
    public float f;
    public boolean g;

    public AutoRotateDrawable(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right;
        int i2 = bounds.left;
        int i3 = i - i2;
        int i4 = bounds.bottom;
        int i5 = bounds.top;
        int i6 = i4 - i5;
        float f2 = this.f;
        if (!this.e) {
            f2 = 360.0f - f2;
        }
        canvas.rotate(f2, (float) ((i3 / 2) + i2), (float) ((i6 / 2) + i5));
        super.draw(canvas);
        canvas.restoreToCount(save);
        if (!this.g) {
            this.g = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    public void reset() {
        this.f = 0.0f;
        this.g = false;
        unscheduleSelf(this);
        invalidateSelf();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.g = false;
        this.f += (float) ((int) ((20.0f / ((float) this.d)) * 360.0f));
        invalidateSelf();
    }

    public void setClockwise(boolean z) {
        this.e = z;
    }

    public AutoRotateDrawable(Drawable drawable, int i, boolean z) {
        super((Drawable) Preconditions.checkNotNull(drawable));
        this.f = 0.0f;
        this.g = false;
        this.d = i;
        this.e = z;
    }

    @Override // com.facebook.drawee.drawable.CloneableDrawable
    public AutoRotateDrawable cloneDrawable() {
        return new AutoRotateDrawable(DrawableUtils.cloneDrawable(getDrawable()), this.d, this.e);
    }
}
