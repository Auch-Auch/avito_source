package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.google.common.net.HttpHeaders;
public class DrawableProperties {
    public int a = -1;
    public boolean b = false;
    public ColorFilter c = null;
    public int d = -1;
    public int e = -1;

    @SuppressLint({HttpHeaders.RANGE})
    public void applyTo(Drawable drawable) {
        if (drawable != null) {
            int i = this.a;
            if (i != -1) {
                drawable.setAlpha(i);
            }
            if (this.b) {
                drawable.setColorFilter(this.c);
            }
            int i2 = this.d;
            boolean z = true;
            if (i2 != -1) {
                drawable.setDither(i2 != 0);
            }
            int i3 = this.e;
            if (i3 != -1) {
                if (i3 == 0) {
                    z = false;
                }
                drawable.setFilterBitmap(z);
            }
        }
    }

    public void setAlpha(int i) {
        this.a = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.c = colorFilter;
        this.b = true;
    }

    public void setDither(boolean z) {
        this.d = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.e = z ? 1 : 0;
    }
}
