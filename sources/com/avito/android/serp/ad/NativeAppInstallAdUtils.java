package com.avito.android.serp.ad;

import android.net.Uri;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/google/android/gms/ads/formats/NativeAppInstallAd;", "Landroid/net/Uri;", "getImageUrl", "(Lcom/google/android/gms/ads/formats/NativeAppInstallAd;)Landroid/net/Uri;", "serp-core_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "NativeAppInstallAdUtils")
public final class NativeAppInstallAdUtils {
    @Nullable
    public static final Uri getImageUrl(@NotNull NativeAppInstallAd nativeAppInstallAd) {
        Intrinsics.checkNotNullParameter(nativeAppInstallAd, "$this$getImageUrl");
        if (nativeAppInstallAd.getImages() == null) {
            return null;
        }
        List<NativeAd.Image> images = nativeAppInstallAd.getImages();
        Intrinsics.checkNotNullExpressionValue(images, "images");
        if (!(!images.isEmpty())) {
            return null;
        }
        NativeAd.Image image = nativeAppInstallAd.getImages().get(0);
        Intrinsics.checkNotNullExpressionValue(image, "images[0]");
        return image.getUri();
    }
}
