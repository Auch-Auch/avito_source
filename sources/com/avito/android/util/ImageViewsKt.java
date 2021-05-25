package com.avito.android.util;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.core.widget.ImageViewCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\b\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/widget/ImageView;", "Landroid/content/res/ColorStateList;", "color", "", "setImageTintListCompat", "(Landroid/widget/ImageView;Landroid/content/res/ColorStateList;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "bindImageDrawable", "(Landroid/widget/ImageView;Landroid/graphics/drawable/Drawable;)V", "android_release"}, k = 2, mv = {1, 4, 2})
public final class ImageViewsKt {
    public static final void bindImageDrawable(@NotNull ImageView imageView, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(imageView, "$this$bindImageDrawable");
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
            Views.show(imageView);
            return;
        }
        Views.hide(imageView);
    }

    public static final void setImageTintListCompat(@NotNull ImageView imageView, @Nullable ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(imageView, "$this$setImageTintListCompat");
        ImageViewCompat.setImageTintList(imageView, colorStateList);
    }
}
