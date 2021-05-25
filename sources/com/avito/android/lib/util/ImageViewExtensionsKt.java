package com.avito.android.lib.util;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.avito.android.util.Views;
import com.avito.android.util.drawable.ShapeStateDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a=\u0010\b\u001a\u00020\u0007*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/widget/ImageView;", "", "paddingHorizontal", "paddingVertical", "Landroid/content/res/ColorStateList;", "color", "rippleColor", "", "setBackground", "(Landroid/widget/ImageView;IILandroid/content/res/ColorStateList;Landroid/content/res/ColorStateList;)V", "components_release"}, k = 2, mv = {1, 4, 2})
public final class ImageViewExtensionsKt {
    public static final void setBackground(@NotNull ImageView imageView, int i, int i2, @Nullable ColorStateList colorStateList, @Nullable ColorStateList colorStateList2) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(imageView, "$this$setBackground");
        if (colorStateList != null) {
            ShapeStateDrawable.Companion companion = ShapeStateDrawable.Companion;
            drawable = companion.invoke(companion.getSHAPE_OVAL(), i, i2, i, i2, colorStateList, colorStateList2);
        } else {
            drawable = null;
        }
        Views.setBackgroundCompat(imageView, drawable);
    }

    public static /* synthetic */ void setBackground$default(ImageView imageView, int i, int i2, ColorStateList colorStateList, ColorStateList colorStateList2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 8) != 0) {
            colorStateList2 = null;
        }
        setBackground(imageView, i, i2, colorStateList, colorStateList2);
    }
}
