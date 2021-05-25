package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.VisibleForTesting;
public class OrientedDrawable extends ForwardingDrawable {
    @VisibleForTesting
    public final Matrix d;
    public int e;
    public int f;
    public final Matrix g;
    public final RectF h;

    public OrientedDrawable(Drawable drawable, int i) {
        this(drawable, i, 0);
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i;
        if (this.e > 0 || !((i = this.f) == 0 || i == 1)) {
            int save = canvas.save();
            canvas.concat(this.d);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i = this.f;
        if (i == 5 || i == 7 || this.e % 180 != 0) {
            return super.getIntrinsicWidth();
        }
        return super.getIntrinsicHeight();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = this.f;
        if (i == 5 || i == 7 || this.e % 180 != 0) {
            return super.getIntrinsicHeight();
        }
        return super.getIntrinsicWidth();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, com.facebook.drawee.drawable.TransformCallback
    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
        if (!this.d.isIdentity()) {
            matrix.preConcat(this.d);
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        int i;
        Drawable current = getCurrent();
        int i2 = this.e;
        if (i2 > 0 || !((i = this.f) == 0 || i == 1)) {
            int i3 = this.f;
            if (i3 == 2) {
                this.d.setScale(-1.0f, 1.0f);
            } else if (i3 == 7) {
                this.d.setRotate(270.0f, (float) rect.centerX(), (float) rect.centerY());
                this.d.postScale(-1.0f, 1.0f);
            } else if (i3 == 4) {
                this.d.setScale(1.0f, -1.0f);
            } else if (i3 != 5) {
                this.d.setRotate((float) i2, (float) rect.centerX(), (float) rect.centerY());
            } else {
                this.d.setRotate(270.0f, (float) rect.centerX(), (float) rect.centerY());
                this.d.postScale(1.0f, -1.0f);
            }
            this.g.reset();
            this.d.invert(this.g);
            this.h.set(rect);
            this.g.mapRect(this.h);
            RectF rectF = this.h;
            current.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            return;
        }
        current.setBounds(rect);
    }

    public OrientedDrawable(Drawable drawable, int i, int i2) {
        super(drawable);
        this.g = new Matrix();
        this.h = new RectF();
        this.d = new Matrix();
        this.e = i - (i % 90);
        this.f = (i2 < 0 || i2 > 8) ? 0 : i2;
    }
}
