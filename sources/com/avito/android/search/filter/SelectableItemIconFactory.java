package com.avito.android.search.filter;

import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/search/filter/SelectableItemIconFactory;", "", "", "color", "Landroid/graphics/drawable/Drawable;", "createIcon", "(I)Landroid/graphics/drawable/Drawable;", "filter_release"}, k = 1, mv = {1, 4, 2})
public interface SelectableItemIconFactory {
    @NotNull
    Drawable createIcon(@ColorInt int i);
}
