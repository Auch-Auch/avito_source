package com.avito.android.lib.design.banner;

import com.avito.android.image_loader.fresco.ImageLoadableExtensionKt;
import com.avito.android.remote.model.Image;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/lib/design/banner/Banner;", "Lcom/avito/android/remote/model/Image;", "image", "", "loadImage", "(Lcom/avito/android/lib/design/banner/Banner;Lcom/avito/android/remote/model/Image;)V", "components_release"}, k = 2, mv = {1, 4, 2})
public final class BannersKt {
    public static final void loadImage(@NotNull Banner banner, @NotNull Image image) {
        Intrinsics.checkNotNullParameter(banner, "$this$loadImage");
        Intrinsics.checkNotNullParameter(image, "image");
        ImageLoadableExtensionKt.loadImage$default(banner.getImageContainer(), image, false, null, null, 14, null);
    }
}
