package com.avito.android.remote.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/remote/model/UniversalImage;", "", "isLightTheme", "Lcom/avito/android/remote/model/Image;", "getImageDependsOnTheme", "(Lcom/avito/android/remote/model/UniversalImage;Z)Lcom/avito/android/remote/model/Image;", "models_release"}, k = 2, mv = {1, 4, 2})
public final class UniversalImageKt {
    @Nullable
    public static final Image getImageDependsOnTheme(@NotNull UniversalImage universalImage, boolean z) {
        Intrinsics.checkNotNullParameter(universalImage, "$this$getImageDependsOnTheme");
        return z ? universalImage.getImage() : universalImage.getImageDark();
    }
}
