package com.avito.android.util;

import android.net.Uri;
import android.view.View;
import androidx.annotation.FloatRange;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Size;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.o.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\u001a;\u0010\t\u001a\u00020\b*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n\u001aC\u0010\t\u001a\u00020\b*\u0004\u0018\u00010\u00002\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\r\u001a\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001b\u0010\u0012\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0013\"\u0016\u0010\u0014\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0016\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015\"\u0016\u0010\u0017\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/Image;", "Landroid/view/View;", "view", "", "minScale", "maxScale", "", "notFoundReturnStrategy", "Lcom/avito/android/util/ImageFitting;", "fit", "(Lcom/avito/android/remote/model/Image;Landroid/view/View;FFI)Lcom/avito/android/util/ImageFitting;", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "(Lcom/avito/android/remote/model/Image;IIFFI)Lcom/avito/android/util/ImageFitting;", "", SDKConstants.PARAM_CONTEXT_MAX_SIZE, "(Lcom/avito/android/remote/model/Image;)Ljava/lang/String;", "default", "aspectRatio", "(Lcom/avito/android/remote/model/Image;F)F", "STRATEGY_RETURN_NULL", "I", "STRATEGY_RETURN_MAX", "STRATEGY_RETURN_MIN", "image-loader_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Images")
public final class Images {
    public static final int STRATEGY_RETURN_MAX = 1;
    public static final int STRATEGY_RETURN_MIN = 2;
    public static final int STRATEGY_RETURN_NULL = 0;

    public static final float access$heightEstimation(Size size, int i, int i2) {
        return ((float) size.getHeight()) / ((float) i2);
    }

    public static final boolean access$isBetter(float f, float f2) {
        return Math.abs(1.0f - f) < Math.abs(f2 - 1.0f);
    }

    public static final float access$widthEstimation(Size size, int i, int i2) {
        return ((float) size.getWidth()) / ((float) i);
    }

    public static final float aspectRatio(@Nullable Image image, float f) {
        Map<Size, Uri> variants;
        Set<Size> keySet;
        Size size;
        return (image == null || (variants = image.getVariants()) == null || (keySet = variants.keySet()) == null || (size = (Size) CollectionsKt___CollectionsKt.firstOrNull(keySet)) == null) ? f : ((float) size.getWidth()) / ((float) size.getHeight());
    }

    @JvmOverloads
    @NotNull
    public static final ImageFitting fit(@Nullable Image image, int i, int i2) {
        return fit$default(image, i, i2, 0.0f, 0.0f, 0, 28, null);
    }

    @JvmOverloads
    @NotNull
    public static final ImageFitting fit(@Nullable Image image, int i, int i2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        return fit$default(image, i, i2, f, 0.0f, 0, 24, null);
    }

    @JvmOverloads
    @NotNull
    public static final ImageFitting fit(@Nullable Image image, int i, int i2, @FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d) float f2) {
        return fit$default(image, i, i2, f, f2, 0, 16, null);
    }

    @JvmOverloads
    @NotNull
    public static final ImageFitting fit(@Nullable Image image, @NotNull View view) {
        return fit$default(image, view, 0.0f, 0.0f, 0, 14, null);
    }

    @JvmOverloads
    @NotNull
    public static final ImageFitting fit(@Nullable Image image, @NotNull View view, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        return fit$default(image, view, f, 0.0f, 0, 12, null);
    }

    @JvmOverloads
    @NotNull
    public static final ImageFitting fit(@Nullable Image image, @NotNull View view, @FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d) float f2) {
        return fit$default(image, view, f, f2, 0, 8, null);
    }

    @JvmOverloads
    @NotNull
    public static final ImageFitting fit(@Nullable Image image, @NotNull View view, @FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d) float f2, @NotFoundReturnStrategy int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        return fit(image, Views.getDefinedWidth(view), Views.getDefinedHeight(view), f, f2, i);
    }

    public static /* synthetic */ ImageFitting fit$default(Image image, View view, float f, float f2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f2 = 1.5f;
        }
        if ((i2 & 8) != 0) {
            i = 0;
        }
        return fit(image, view, f, f2, i);
    }

    @Nullable
    public static final String maxSize(@NotNull Image image) {
        Uri uri;
        Intrinsics.checkNotNullParameter(image, "$this$maxSize");
        Size size = (Size) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) CollectionsKt___CollectionsKt.sortedWith(image.getVariants().keySet(), new Comparator<T>() { // from class: com.avito.android.util.Images$maxSize$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return a.compareValues(Integer.valueOf(t2.area()), Integer.valueOf(t.area()));
            }
        }));
        if (size == null || (uri = image.getVariants().get(size)) == null) {
            return null;
        }
        return uri.toString();
    }

    @JvmOverloads
    @NotNull
    public static final ImageFitting fit(@Nullable Image image, int i, int i2, @FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d) float f2, @NotFoundReturnStrategy int i3) {
        return new ImageFitting(image != null ? image.getVariants() : null, i, i2, f, f2, i3);
    }

    public static /* synthetic */ ImageFitting fit$default(Image image, int i, int i2, float f, float f2, int i3, int i4, Object obj) {
        return fit(image, i, i2, (i4 & 4) != 0 ? 0.0f : f, (i4 & 8) != 0 ? 1.5f : f2, (i4 & 16) != 0 ? 0 : i3);
    }
}
