package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.my.target.common.models.ImageData;
@SuppressLint({"AppCompatCustomView"})
public class gc extends ImageView {
    @Nullable
    public Bitmap a;
    public int b;
    public int c;
    public int d;
    public int e;

    public gc(Context context) {
        super(context);
        a();
    }

    public gc(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public gc(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public final void a() {
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        setAdjustViewBounds(true);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i4 = this.b;
        if (i4 == 0 || (i3 = this.c) == 0) {
            Bitmap bitmap = this.a;
            if (bitmap != null) {
                i3 = bitmap.getWidth();
                i4 = this.a.getHeight();
            } else {
                setMeasuredDimension(0, 0);
                return;
            }
        }
        if (i3 <= 0 || i4 <= 0) {
            super.onMeasure(i, i2);
            return;
        }
        float f = (float) i3;
        float f2 = (float) i4;
        float f3 = f / f2;
        int i5 = this.e;
        if (i5 > 0) {
            size2 = Math.min(i5, size2);
        }
        int i6 = this.d;
        if (i6 > 0) {
            size = Math.min(i6, size);
        }
        if (mode == 1073741824 && mode2 == 1073741824) {
            setMeasuredDimension(size, size2);
            return;
        }
        if (!(mode == 0 && mode2 == 0)) {
            if (mode == 0) {
                i3 = (int) (((float) size2) * f3);
            } else {
                if (mode2 == 0) {
                    i4 = (int) (((float) size) / f3);
                } else {
                    float f4 = (float) size;
                    float f5 = f4 / f;
                    float f6 = (float) size2;
                    if (Math.min(f5, f6 / f2) != f5 || f3 <= 0.0f) {
                        i3 = (int) (f6 * f3);
                    } else {
                        i4 = (int) (f4 / f3);
                    }
                }
                i3 = size;
            }
            i4 = size2;
        }
        setMeasuredDimension(i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(@Nullable Bitmap bitmap) {
        this.a = bitmap;
        super.setImageBitmap(bitmap);
    }

    public void setImageBitmap(@Nullable Bitmap bitmap, boolean z) {
        if (z) {
            setAlpha(0.0f);
            setImageBitmap(bitmap);
            animate().alpha(1.0f).setDuration(300);
            return;
        }
        setImageBitmap(bitmap);
    }

    public void setImageData(@Nullable ImageData imageData) {
        Bitmap bitmap;
        if (imageData == null) {
            this.b = 0;
            this.c = 0;
            bitmap = null;
        } else {
            this.b = imageData.getHeight();
            this.c = imageData.getWidth();
            bitmap = imageData.getBitmap();
        }
        setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    public void setMaxHeight(int i) {
        this.e = i;
    }

    @Override // android.widget.ImageView
    public void setMaxWidth(int i) {
        this.d = i;
    }

    public void setPlaceholderDimensions(int i, int i2) {
        this.c = i;
        this.b = i2;
    }
}
