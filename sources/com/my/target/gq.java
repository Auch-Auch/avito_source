package com.my.target;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class gq extends FrameLayout {
    @NonNull
    public final ImageView a;

    public gq(@NonNull Context context) {
        super(context);
        ImageView imageView = new ImageView(context);
        this.a = imageView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(imageView, layoutParams);
    }

    public void setImageBitmap(@Nullable Bitmap bitmap) {
        this.a.setImageBitmap(bitmap);
    }
}
