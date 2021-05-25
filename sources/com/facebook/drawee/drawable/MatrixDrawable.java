package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
public class MatrixDrawable extends ForwardingDrawable {
    public Matrix d;
    public Matrix e;
    public int f = 0;
    public int g = 0;

    public MatrixDrawable(Drawable drawable, Matrix matrix) {
        super((Drawable) Preconditions.checkNotNull(drawable));
        this.d = matrix;
    }

    public final void a() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.f = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.g = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.e = null;
            return;
        }
        current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        this.e = this.d;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!(this.f == getCurrent().getIntrinsicWidth() && this.g == getCurrent().getIntrinsicHeight())) {
            a();
        }
        if (this.e != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.e);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    public Matrix getMatrix() {
        return this.d;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, com.facebook.drawee.drawable.TransformCallback
    public void getTransform(Matrix matrix) {
        super.getTransform(matrix);
        Matrix matrix2 = this.e;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        a();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable
    public Drawable setCurrent(Drawable drawable) {
        Drawable current = super.setCurrent(drawable);
        a();
        return current;
    }

    public void setMatrix(Matrix matrix) {
        this.d = matrix;
        a();
        invalidateSelf();
    }
}
