package com.avito.android.util;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/graphics/Rect;", "", "fullWidth", "fullHeight", "Lcom/avito/android/util/NormalizedRect;", "normalize", "(Landroid/graphics/Rect;II)Lcom/avito/android/util/NormalizedRect;", "photo-picker_release"}, k = 2, mv = {1, 4, 2})
public final class RectsKt {
    @NotNull
    public static final NormalizedRect normalize(@NotNull Rect rect, int i, int i2) {
        Intrinsics.checkNotNullParameter(rect, "$this$normalize");
        float f = (float) i;
        float f2 = (float) i2;
        return new NormalizedRect(((float) rect.left) / f, ((float) rect.top) / f2, ((float) rect.right) / f, ((float) rect.bottom) / f2);
    }
}
