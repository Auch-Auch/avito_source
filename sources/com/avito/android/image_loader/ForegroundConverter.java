package com.avito.android.image_loader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/image_loader/ForegroundConverter;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/image_loader/Picture;", "picture", "", "roundCorners", "Landroid/graphics/drawable/Drawable;", "convert", "(Landroid/content/Context;Lcom/avito/android/image_loader/Picture;Ljava/lang/Integer;)Landroid/graphics/drawable/Drawable;", "image-loader_release"}, k = 1, mv = {1, 4, 2})
public interface ForegroundConverter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Drawable convert$default(ForegroundConverter foregroundConverter, Context context, Picture picture, Integer num, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    num = null;
                }
                return foregroundConverter.convert(context, picture, num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: convert");
        }
    }

    @Nullable
    Drawable convert(@NotNull Context context, @Nullable Picture picture, @Nullable Integer num);
}
