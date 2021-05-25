package com.my.target;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
public class fo extends gc {
    public static final int DEFAULT_HEIGHT = 20;
    public int f;

    public fo(Context context) {
        this(context, null);
    }

    public fo(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public fo(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = -1;
        this.f = io.c(20, context);
    }

    @Override // com.my.target.gc, android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f >= 0) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
        } else {
            super.onMeasure(i, i2);
        }
    }

    public void setFixedHeight(int i) {
        this.f = i;
    }

    @Override // com.my.target.gc, android.widget.ImageView
    public void setImageBitmap(@Nullable Bitmap bitmap) {
        int i;
        int i2;
        int i3 = this.f;
        int i4 = 0;
        if (i3 >= 0) {
            i = (i3 - getPaddingTop()) - getPaddingBottom();
            if (i < 0) {
                i = 0;
            }
        } else {
            i = -1;
        }
        if (i >= 0) {
            if (bitmap != null) {
                i2 = bitmap.getWidth();
                i4 = bitmap.getHeight();
            } else {
                i2 = 0;
            }
            float f2 = 0.0f;
            if (i4 > 0) {
                f2 = ((float) i2) / ((float) i4);
            }
            setMeasuredDimension(getPaddingRight() + getPaddingLeft() + ((int) (((float) i) * f2)), this.f);
        }
        super.setImageBitmap(bitmap);
    }
}
