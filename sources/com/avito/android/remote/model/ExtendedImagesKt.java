package com.avito.android.remote.model;

import android.net.Uri;
import com.avito.android.util.DensityDpi;
import com.avito.android.util.Images;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u001a#\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b\"\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\b\"\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\b\"\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/remote/model/Image;", "image", "", "densityDpi", "", "getListSizeIcon", "(Lcom/avito/android/remote/model/Image;I)Ljava/lang/String;", "MEDIUM_IMAGE_HEIGHT", "I", "MEDIUM_IMAGE_WIDTH", "LARGE_IMAGE_WIDTH", "LARGE_IMAGE_HEIGHT", "models_release"}, k = 2, mv = {1, 4, 2})
public final class ExtendedImagesKt {
    private static final int LARGE_IMAGE_HEIGHT = 180;
    private static final int LARGE_IMAGE_WIDTH = 240;
    private static final int MEDIUM_IMAGE_HEIGHT = 105;
    private static final int MEDIUM_IMAGE_WIDTH = 140;

    @Nullable
    public static final String getListSizeIcon(@Nullable Image image, @DensityDpi int i) {
        Uri uri;
        if (image == null) {
            return null;
        }
        if (i == 120 || i == 160) {
            uri = Images.fit$default(image, 140, 105, 0.0f, 0.0f, 0, 28, null).width();
        } else {
            uri = Images.fit$default(image, 240, 180, 0.0f, 0.0f, 0, 28, null).width();
        }
        if (uri != null) {
            return uri.toString();
        }
        return null;
    }
}
