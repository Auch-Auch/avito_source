package com.yandex.mobile.ads.nativeads.template;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.widget.ImageView;
public final class b {
    @VisibleForTesting
    public static final int a = Color.parseColor("#eaeaea");
    private final ImageView[] b;

    public b(@NonNull ImageView... imageViewArr) {
        this.b = imageViewArr;
        b();
    }

    private void b() {
        ImageView[] imageViewArr = this.b;
        for (ImageView imageView : imageViewArr) {
            if (imageView != null) {
                if (imageView.getDrawable() != null) {
                    imageView.setBackgroundColor(0);
                } else {
                    imageView.setBackgroundColor(a);
                }
            }
        }
    }

    public final void a() {
        ImageView[] imageViewArr = this.b;
        for (ImageView imageView : imageViewArr) {
            ColorDrawable colorDrawable = (ColorDrawable) imageView.getBackground();
            Drawable drawable = imageView.getDrawable();
            if (drawable != null && colorDrawable.getAlpha() == 255) {
                a(colorDrawable, 255, 0).start();
                a(drawable, 0, 255).start();
            }
        }
    }

    @TargetApi(11)
    private static ObjectAnimator a(Drawable drawable, int i, int i2) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(drawable, PropertyValuesHolder.ofInt("alpha", i, i2));
        ofPropertyValuesHolder.setTarget(drawable);
        ofPropertyValuesHolder.setDuration(500L);
        return ofPropertyValuesHolder;
    }
}
