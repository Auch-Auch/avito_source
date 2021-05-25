package com.avito.android.image_loader;

import androidx.annotation.FloatRange;
import com.avito.android.remote.model.Image;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\b\u001a\u00020\u00072\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0003\u0010\u0005\u001a\u00020\u00042\b\b\u0003\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/Image;", "image", "", "fitWidth", "", "minScale", "maxScale", "Lcom/avito/android/image_loader/RemotePicture;", "simplePictureOf", "(Lcom/avito/android/remote/model/Image;ZFF)Lcom/avito/android/image_loader/RemotePicture;", "image-loader_release"}, k = 2, mv = {1, 4, 2})
public final class RemotePictureKt {
    @NotNull
    public static final RemotePicture simplePictureOf(@Nullable Image image, boolean z, @FloatRange(from = 0.0d) float f, @FloatRange(from = 0.0d) float f2) {
        return new RemotePicture(image, z, f, f2);
    }

    public static /* synthetic */ RemotePicture simplePictureOf$default(Image image, boolean z, float f, float f2, int i, Object obj) {
        if ((i & 4) != 0) {
            f = 0.0f;
        }
        if ((i & 8) != 0) {
            f2 = 1.5f;
        }
        return simplePictureOf(image, z, f, f2);
    }
}
