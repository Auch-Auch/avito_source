package com.avito.android.delivery.utils;

import android.graphics.drawable.Drawable;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/delivery/utils/DrawableFactory;", "", "", "layoutId", "textViewId", "", "text", "Landroid/graphics/drawable/Drawable;", "getTextDrawable", "(IILjava/lang/CharSequence;)Landroid/graphics/drawable/Drawable;", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface DrawableFactory {
    @NotNull
    Drawable getTextDrawable(@LayoutRes int i, @IdRes int i2, @NotNull CharSequence charSequence);
}
