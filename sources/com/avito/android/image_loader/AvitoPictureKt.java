package com.avito.android.image_loader;

import androidx.annotation.FloatRange;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.Image;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a?\u0010\n\u001a\u00020\t2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010\u0005\u001a\u00020\u00042\b\b\u0003\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a5\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010\u0005\u001a\u00020\u00042\b\b\u0003\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/model/Image;", "image", "", "fitWidth", "", "minScale", "maxScale", "Lcom/avito/android/remote/model/ForegroundImage;", "foregroundImage", "Lcom/avito/android/image_loader/Picture;", "pictureOf", "(Lcom/avito/android/remote/model/Image;ZFFLcom/avito/android/remote/model/ForegroundImage;)Lcom/avito/android/image_loader/Picture;", "(ZFFLcom/avito/android/remote/model/ForegroundImage;)Lcom/avito/android/image_loader/Picture;", "image-loader_release"}, k = 2, mv = {1, 4, 2})
public final class AvitoPictureKt {
    @NotNull
    public static final Picture pictureOf(@Nullable Image image, boolean z, @FloatRange(from = 0.0d) float f, @FloatRange(from = 0.0d) float f2, @Nullable ForegroundImage foregroundImage) {
        return new AvitoPicture(image, z, f, f2, foregroundImage != null ? new ForegroundInfo(foregroundImage.getTitle(), foregroundImage.getDimColor()) : null);
    }

    public static /* synthetic */ Picture pictureOf$default(Image image, boolean z, float f, float f2, ForegroundImage foregroundImage, int i, Object obj) {
        if ((i & 4) != 0) {
            f = 0.0f;
        }
        if ((i & 8) != 0) {
            f2 = 1.5f;
        }
        if ((i & 16) != 0) {
            foregroundImage = null;
        }
        return pictureOf(image, z, f, f2, foregroundImage);
    }

    public static /* synthetic */ Picture pictureOf$default(boolean z, float f, float f2, ForegroundImage foregroundImage, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            f2 = 1.5f;
        }
        if ((i & 8) != 0) {
            foregroundImage = null;
        }
        return pictureOf(z, f, f2, foregroundImage);
    }

    @NotNull
    public static final Picture pictureOf(boolean z, @FloatRange(from = 0.0d) float f, @FloatRange(from = 0.0d) float f2, @Nullable ForegroundImage foregroundImage) {
        return pictureOf(foregroundImage != null ? foregroundImage.getImage() : null, z, f, f2, foregroundImage);
    }
}
