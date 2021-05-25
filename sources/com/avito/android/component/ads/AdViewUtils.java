package com.avito.android.component.ads;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/component/ads/AdViewUtils;", "", "Lcom/facebook/drawee/view/SimpleDraweeView;", "draweeView", "", "resolveCornerRadius", "(Lcom/facebook/drawee/view/SimpleDraweeView;)F", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AdViewUtils {
    @NotNull
    public static final AdViewUtils INSTANCE = new AdViewUtils();

    public final float resolveCornerRadius(@Nullable SimpleDraweeView simpleDraweeView) {
        GenericDraweeHierarchy genericDraweeHierarchy;
        RoundingParams roundingParams;
        float[] cornersRadii;
        if (simpleDraweeView == null || (genericDraweeHierarchy = (GenericDraweeHierarchy) simpleDraweeView.getHierarchy()) == null || (roundingParams = genericDraweeHierarchy.getRoundingParams()) == null || (cornersRadii = roundingParams.getCornersRadii()) == null) {
            return 0.0f;
        }
        Intrinsics.checkNotNullExpressionValue(cornersRadii, "it");
        int length = cornersRadii.length;
        boolean z = false;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= length) {
                z = true;
                break;
            }
            if (cornersRadii[i] == 0.0f) {
                z2 = false;
            }
            if (!z2) {
                break;
            }
            i++;
        }
        if (z) {
            return ArraysKt___ArraysKt.first(cornersRadii);
        }
        return 0.0f;
    }
}
